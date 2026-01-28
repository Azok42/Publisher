package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Publisher {

  private String fname;
  private String motto;
  private ArrayList<PublisherSale> publisherSales;
  private ArrayList<Spiel> spiele;

  public Publisher(String fname, String motto) {
    this.fname = fname;
    this.motto = motto;
  }

  public Publisher(
    String fname,
    String mottol,
    ArrayList<PublisherSale> publisherSalesm,
    ArrayList<Spiel> spiele
  ) {
    this.fname = fname;
    this.motto = motto;
    this.publisherSales = publisherSales;
    this.spiele = spiele;
  }

  public double calculatePublisherRevenue(Date start, Date end) {
    return 0;
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
