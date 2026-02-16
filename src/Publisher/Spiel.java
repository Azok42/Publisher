package Publisher;

import java.util.ArrayList;

public class Spiel {

  private String name;
  private double price;
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
    this.bewertungen = bewertungen;
    for (int b : this.bewertungen) if (b > 0 && b < 11) this.bewertung += b;
    this.bewertung /= this.bewertungen.size();
    this.publisher = publisher;
    abos = new ArrayList<Abo>();
    bundles = new ArrayList<Bundle>();
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
      int abos = publisher.getCurrentAbos(og);
      if (bew > 0 && abos > 0 && maxAbos > 0) {
        double weight = bew * (abos / maxAbos);
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
      if (abo.getDuration() == newAbo.getDuration() || abo.getType() == newAbo.getType()){
        return true;
      }
    }
    return false;
  }

  public void syncSpielPreisBundle() {
    return; //TODO: Implement syncSpielPreisBundle
  }

  public double getPrice() {
    return price;
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

  public ArrayList<Bundle> getBundles() {
    return bundles;
  }

  public Publisher getPublisher() {
    return publisher;
  }
}
