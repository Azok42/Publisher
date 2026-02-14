package src.Publisher;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a game Publisher.<br>
 *
 * It manages games, purchases from customers and publisher sales.
 * It also provides methods for analysis, game ranking, validation and reports.
 * @author Jame Bayerl
 */
public class Publisher {

  private String fname;
  private String motto;
  private ArrayList<PublisherSale> publisherSales;
  private ArrayList<Spiel> spiele;
  private ArrayList<Purchase> purchases;
  private ArrayList<Bundle> bundles;

  public Publisher(String fname, String motto) {
    this.fname = fname;
    this.motto = motto;
    publisherSales = new ArrayList<PublisherSale>();
    spiele = new ArrayList<Spiel>();
    purchases = new ArrayList<Purchase>();
    bundles = new ArrayList<Bundle>();
  }

  /**
   * Calculates publishers revenue in a date range accounting for purchased games, bundles, subscriptions and publisher sales.
   * Multiple Publisher sales will apply multiplicative discounts
   *
   * @param start start date (excluded)
   * @param end end date (excluded)
   * @return the revenue of the publisher
   */
  public double calculatePublisherRevenue(Date start, Date end) {
    double revenue = 0;
    if (purchases == null) return 0;
    for (Purchase purchase : purchases) {
      if (purchase.getDate().after(start) && purchase.getDate().before(end)) {
        double price = 0;
        if (purchase.getPurchasedGame() != null) {
          price += purchase.getPurchasedGame().getPrice();
        } else if (purchase.getPurchasedBundle() != null) {
          price += purchase.getPurchasedBundle().getPrice();
        } else if (purchase.getSubscription() != null) {
          price += purchase.getSubscription().getPriceForDuration();
        }
        // discounts of publisherSales will be on top of each other, not added
        for (PublisherSale ps : publisherSales) {
          if (ps.getStart().before(end) && ps.getEnd().after(start)) {
            price *= (100 - ps.getRabatt()) / 100;
          }
        }
        revenue += price;
      }
    }
    return revenue;
  }

  /**
   * Finds the top games of the publisher.
   *
   * @param count
   * @return the top games sorted after their rating
   */
  public ArrayList<Spiel> getTopSpieleByBewertung(int count) {
    ArrayList<Spiel> topSpiele = new ArrayList<Spiel>();
    for (Spiel spiel : spiele) {
      topSpiele.add(spiel);
    }
    topSpiele.sort((s1, s2) ->
      Double.compare(s2.getBewertung(), s1.getBewertung())
    );
    return (ArrayList<Spiel>) topSpiele.subList(0, count);
  }

  /**
   * Calculates the average discount of the publisher's publisher sales
   *
   * @return the average discount in %
   */
  public double calculateAverageDiscount() {
    if (publisherSales == null) return 0;
    double avg = 0;
    for (PublisherSale ps : publisherSales) {
      avg += ps.getRabatt();
    }
    return avg / publisherSales.size();
  }

  public static Bundle getMostPopularBundle(Date start, Date end) {
    return null; //TODO: Implement getMostPopularBundle
  }

  public Boolean validatePublisherSaleLimit() {
    return false; //TODO: Implement validatePublisherSaleLimit
  }

  public boolean generatePublisherReport(String report) {
    return false; //TODO: Implement generatePublisherReport
  }

  public String getFname() {
    return fname;
  }

  public String getMotto() {
    return motto;
  }

  public boolean addPublisherSale(PublisherSale publisherSale) {
    return publisherSales.add(publisherSale);
  }

  public ArrayList<PublisherSale> getPublisherSales() {
    return publisherSales;
  }

  public boolean addSpiel(Spiel spiel) {
    return spiele.add(spiel);
  }

  public ArrayList<Spiel> getSpiele() {
    return spiele;
  }

  public boolean addPurchase(Purchase purchase) {
    return purchases.add(purchase);
  }

  public ArrayList<Purchase> getPurchases() {
    return purchases;
  }

  public boolean addBundle(Bundle bundle) {
    return bundles.add(bundle);
  }

  public ArrayList<Bundle> getBundles() {
    return bundles;
  }
}
