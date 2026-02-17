package Publisher;

import java.io.FileWriter;
import java.io.IOException;
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

  /**
   * The maximum number of bundles allowed per publisher.
   */
  public static final int MAX_PUBLISHER_SALES = 3;

  private String fname;
  private String motto;
  private ArrayList<PublisherSale> publisherSales;
  private ArrayList<Spiel> spiele;
  private ArrayList<Purchase> purchases;
  private ArrayList<Bundle> bundles;

  public Publisher(String fname, String motto) {
    this.fname = fname;
    this.motto = motto;
    publisherSales = new ArrayList<>();
    spiele = new ArrayList<>();
    purchases = new ArrayList<>();
    bundles = new ArrayList<>();
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
   * @param count the number of top games to return
   * @return the top {@code count} games sorted after their rating
   */
  public ArrayList<Spiel> getTopSpieleByBewertung(int count) {
    ArrayList<Spiel> topSpiele = new ArrayList<>();
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

  /**
   * Gets the most popular bundle by sales. If two bundles have the same amount of sales, only the first one in the list will be returned.
   *
   * @param start start date (excluded)
   * @param end end date (excluded)
   * @return first Bundle with the most sales
   */
  public Bundle getMostPopularBundle(Date start, Date end) {
    if (bundles == null || bundles.isEmpty()) return null;
    Bundle pBundle = null;
    for (Bundle bundle : bundles) {
      if (bundle.getStart().after(start) && bundle.getEnd().before(end)) {
        if (pBundle == null || bundle.getSales() > pBundle.getSales()) {
          pBundle = bundle;
        }
      }
    }
    return pBundle;
  }

  /**
   * @return Whether the current amount of publisher sales is below the limit of {@value #MAX_PUBLISHER_SALES}
   */
  public Boolean validatePublisherSaleLimit() {
    Angebot.cleanupExpiredAngebote();
    return publisherSales.size() >= MAX_PUBLISHER_SALES;
  }

  public boolean generatePublisherReport(String reportPath) {
    try {
      FileWriter writer = new FileWriter(reportPath);
      writer.write("# Publisher " + this.fname + " - " + this.motto + "\n");

      writer.write("## Games\n");
      for (Spiel game : this.spiele) {
        writer.write("- " + game.getName() + "\n");
      }

      writer.write("\n## Abos\n");
      for (Spiel game : this.spiele) {
        for (Abo abo : game.getAbos()) {
          writer.write("- **" + game.getName() + "**: " + abo.getType() + "\n");
        }
      }

      writer.write("\n## Revenue\n");
      writer.write("**Revenue:** " + this.calculatePublisherRevenue(new Date(), new Date()) + "\n");
      writer.write("**Average Discount:** " + this.calculateAverageDiscount() + "\n");

      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file.");
      return false;
    }

    return true;
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

  protected int getCurrentAbos(Spiel spiel){
    int count = 0;
    for (Purchase p : purchases){
      Abo s = p.getSubscription();
      if (s == null) continue;
      if (s.getGame() != spiel) continue;
      count++;
    }
    return count;
  }

  @Override
  public String toString() {
    return "Publisher [fname=" + fname + ", motto=" + motto + "]";
  }
}
