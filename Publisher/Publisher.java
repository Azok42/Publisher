package Publisher;

import java.util.Date;
import java.util.ArrayList;

public class Publisher {

  private String fname;
  private String motto;
  private ArrayList<PublisherSale> publisherSales;
  private ArrayList<Spiel> spiele;

  public Publisher(String fname, String motto) {
    this.fname = fname;
    this.motto = motto;
  }

  public Publisher(String fname, String mottol, ArrayList<PublisherSale> publisherSalesm, ArrayList<Spiel> spiele) {
    this.fname = fname;
    this.motto = motto;
    this.publisherSales = publisherSales;
    this.spiele = spiele;
  }

  public double calculatePublisherRevenue(Date start, Date end){
    return 0;
  }

  public ArrayList<Spiel> getTopSpieleByBewertung(int count){
    return null;
  }

  public double calculateAverageDiscount(){
    return 0;
  }

  public Bundle getMostPopularBundle(Date start, Date end){
    return null;
  }

  public Boolean validatePublisherSaleLimit(){
    return false;
  }

  public boolean generatePublisherReport(String report){
    return false;
  }


}
