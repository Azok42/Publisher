package Publisher;

import java.util.ArrayList;

public class Spiel {

  private String name;
  private double price;
  private double previousPrice;
  private int bewertung; // 1 - 10
  private ArrayList<String> genres;
  private ArrayList<Integer> bewertungen;
  private Publisher publisher;
  private ArrayList<Abo> abos;
  private ArrayList<Bundle> bundles;

  public Spiel(
    String name,
    double price,
    ArrayList<String> genres,
    ArrayList<Integer> bewertungen,
    Publisher publisher
  ) {
    this.name = name;
    this.genres = genres;
    this.price = price;
    this.previousPrice = price;
    this.bewertungen = bewertungen;
    for (int b : this.bewertungen) if (b > 0 && b < 11) this.bewertung += b;
    this.bewertung /= this.bewertungen.size();
    this.publisher = publisher;
    abos = new ArrayList<>();
    bundles = new ArrayList<>();
  }

  /**
   * Adds a rating and recalculates the average rating.
   *
   * @param rating the rating from 1 - 10
   * @return the avg. rating {@code bewertung}, -1 if {@code rating} is out of range (1 - 10)
   */
  public double rate(int rating) {
    if (rating < 1 || rating > 10) return -1;
    bewertungen.add(rating);
    int newBewertung = 0;
    for (int b : bewertungen) {
      if (bewertung > 0 && bewertung < 11) newBewertung += b;
      else return -1;
    }
    bewertung = newBewertung / bewertungen.size();
    return bewertung;
  }

  public int getBewertung() {
    return this.bewertung;
  }

  /**
   * Calculates the optimal price in comparison to the publishers other games price, accounting for their rating and abo count
   *
   * @return the optimal price
   */
  public double suggestOptimalPrice() {
    ArrayList<Spiel> otherGames = new ArrayList<>(publisher.getSpiele());
    double optimalPrice = 0;
    double weightSum = 0;
    double maxAbos = 0;

    for (Spiel og : otherGames) {
      int currentAbos = publisher.getCurrentAbos(og);
      if (currentAbos > maxAbos) {
        maxAbos = currentAbos;
      }
    }

    for (Spiel og : otherGames) {
      if (og == this) continue;
      double bew = og.getBewertung() / 10.0;
      int abosCount = publisher.getCurrentAbos(og);
      if (bew > 0 && abosCount > 0 && maxAbos > 0) {
        double weight = bew * (abosCount / maxAbos);
        optimalPrice += og.getPrice() * weight;
        weightSum += weight;
      }
    }

    return weightSum == 0 ? 0 : optimalPrice / weightSum;
  }

  /**
   * Checks if the passed Abo has the same duration or type with an other current Abo
   * 
   * @param newAbo the new abo to be compared
   * @return true if it overlaps, false if it is fine
   */
  public boolean checkAboOverlap(Abo newAbo) {
    for (Abo abo : abos){
      if (abo.getDuration() == newAbo.getDuration() || abo.getType().equals(newAbo.getType())){
        return true;
      }
    }
    return false;
  }

  /**
   * Syncs all bundles in which this game is contained
   */
  public void syncSpielPreisBundle() {
    for (Bundle bundle : this.bundles) {
      double oldSum = 0.0;

      for (Spiel game : bundle.getSpiele())
        oldSum += (game == this) ? this.previousPrice : game.getPrice();
      
      if (oldSum <= 0) continue;

      double oldDiscount = (oldSum - bundle.getPrice()) / oldSum;
      if (oldDiscount < 0) oldDiscount = 0;
      if (oldDiscount > 1) oldDiscount = 1;

      double newSum = 0.0;
      for (Spiel game : bundle.getSpiele())
        newSum += game.getPrice();

      double newPrice = newSum * (1 - oldDiscount);
      if (newPrice < 0) newPrice = 0;
      bundle.setPrice(newPrice);
    }
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.previousPrice = this.price;
    this.price = price;
    syncSpielPreisBundle();
  }

  public ArrayList<String> getGenres() {
    return genres;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Abo> getAbos() {
    return abos;
  }

  public void addAbo(Abo abo) {
    abos.add(abo);
  }

  public ArrayList<Bundle> getBundles() {
    return bundles;
  }

  public void addBundle(Bundle bundle) {
    bundles.add(bundle);
  }

  public Publisher getPublisher() {
    return publisher;
  }
}
