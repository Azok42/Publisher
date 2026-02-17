package Publisher;

import java.util.ArrayList;

public class Spiel {

  private String name;
  private double price;
  private double previousPrice;
  private double bewertung; // 1 - 10
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
    this.bewertung = 0;
    for (int b : this.bewertungen) {
      if (b >= 1 && b <= 10) {
        this.bewertung += b;
      }
    }
    if (!this.bewertungen.isEmpty()) {
      this.bewertung /= this.bewertungen.size();
    }
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
    double newBewertung = 0;
    for (int b : bewertungen) {
      if (b >= 1 && b <= 10) {
        newBewertung += b;
      } else {
        return -1;
      }
    }
    bewertung = newBewertung / bewertungen.size();
    return bewertung;
  }

  public double getBewertung() {
    return this.bewertung;
  }

  /**
   * Calculates the optimal price in comparison to the publishers other games price,
   * accounting for their rating and abo count.
   * If no other games have subscriptions, uses rating-weighted average.
   *
   * @return the optimal price
   */
  public double suggestOptimalPrice() {
    ArrayList<Spiel> otherGames = new ArrayList<>(publisher.getSpiele());
    double optimalPrice = 0;
    double weightSum = 0;

    int totalAbos = 0;
    for (Spiel og : otherGames) {
      if (og != this) {
        totalAbos += publisher.getCurrentAbos(og);
      }
    }

    if (totalAbos == 0) {
      for (Spiel og : otherGames) {
        if (og == this) continue;
        double bew = og.getBewertung() / 10.0;
        if (bew > 0 && og.getPrice() > 0) {
          optimalPrice += og.getPrice() * bew;
          weightSum += bew;
        }
      }
      return weightSum == 0 ? 0 : optimalPrice / weightSum;
    }

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
      if (bew > 0 && maxAbos > 0) {
        double aboWeight = abosCount > 0 ? (abosCount / maxAbos) : 0.1;
        double weight = bew * aboWeight;
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
    for (Abo abo : abos) {
      if (
        abo.getDuration() == newAbo.getDuration() ||
        abo.getType().equals(newAbo.getType())
      ) {
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

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return (
      "Spiel [name=" +
      name +
      ", price=" +
      price +
      ", bewertung=" +
      bewertung +
      ", genres=" +
      genres +
      ", bewertungen=" +
      bewertungen +
      ", publisher=" +
      publisher.getFname() +
      ", abos=" +
      abos.size() +
      ", bundles=" +
      bundles.size() +
      "]"
    );
  }
}
