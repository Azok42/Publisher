package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Bundle extends Angebot {

  private double price;
  private ArrayList<Spiel> spiele;
  private int sales;
  private Publisher publisher;

  public Bundle(
    String label,
    String text,
    Date start,
    Date end,
    double price,
    ArrayList<Spiel> spiele
  ) {
    super(label, text, start, end);
    this.price = price;
    this.spiele = spiele;
    sales = 0;
    this.publisher = null;
  }

  /**
   * Calculates a new price for this bundle
   *
   * @param targetMargin the changing factor in %
   * @return the new adjusted price
   */
  public double adjustBundlePrice(double targetMargin) {
    this.price *= targetMargin / 100;

    return this.price;
  }

  /**
   * @return the predicted successrate (1.0 - 10.0)
   */
  public double predictBundleSuccess() {
    double sumRatings = 0.0;
    double sumIndividualPrices = 0.0;
    int count = 0;

    for (Spiel game : spiele) {
      count++;
      sumRatings += game.getBewertung();
      sumIndividualPrices += game.getPrice();
    }

    double avgRating = (sumRatings / count) / 10;

    double discount;
    discount = (sumIndividualPrices - this.price) / sumIndividualPrices;

    double score = 0.5 * avgRating + 0.5 * discount;

    return Math.max(0, Math.min(score, 1));
  }

  public double getPrice() {
    return price;
  }

  public ArrayList<Spiel> getSpiele() {
    return spiele;
  }

  public int getSales() {
    return sales;
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
      "Bundle [price=" + price + ", spiele=" + spiele + ", sales=" + sales + "]"
    );
  }
}
