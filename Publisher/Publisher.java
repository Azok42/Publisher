package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Publisher {

  private String fname;
  private String motto;
  private ArrayList<PublisherSale> publisherSales;
  private ArrayList<Spiel> spiele;
  private ArrayList<Purchase> purchases;

  public Publisher(String fname, String motto) {
    this.fname = fname;
    this.motto = motto;
  }

  public Publisher(
    String fname,
    String motto,
    ArrayList<PublisherSale> publisherSales,
    ArrayList<Spiel> spiele
  ) {
    this.fname = fname;
    this.motto = motto;
    this.publisherSales = publisherSales;
    this.spiele = spiele;
  }

  public double calculatePublisherRevenue(Date start, Date end) {
    double revenue = 0;
    if (purchases == null) return 0;
    for (Purchase purchase : purchases) {
      if (purchase.getDate().after(start) && purchase.getDate().before(end)) {
        double price = 0;
        if (purchase.getPurchasedGame() != null) {
          price += purchase.getPurchasedBundle().getPrice();
        } else if (purchase.getPurchasedBundle() != null) {
          price += purchase.getPurchasedBundle().getPrice();
        } else if (purchase.getSubscription() != null) {
          price += purchase.getSubscription().getPriceForDuration();
        }
        // discounts of publisherSales will be on top of each other, not added
        for (PublisherSale ps : publisherSales){
          if (start.before(ps.getStart()) & end.after(ps.getEnd())){
            price *= (100 - ps.getRabatt())/100;
          }
        }
        revenue += price;
      }
    }

    return revenue;
  }

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

  public double calculateAverageDiscount() {
    return 0;
  }

  public Bundle getMostPopularBundle(Date start, Date end) {
    return null;
  }

  public Boolean validatePublisherSaleLimit() {
    return false;
  }

  public boolean generatePublisherReport(String report) {
    return false;
  }
}
