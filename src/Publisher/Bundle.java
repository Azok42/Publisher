package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Bundle extends Angebot {

  private double price;
  private ArrayList<Spiel> spiele;
  private int sales;

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
  }

  public double adjustBundlePrice(double targetMargin) {
    this.price *= targetMargin / 100;

    return this.price;
  }

  public double predictBundleSuccess() {
    return 0; //TODO: Implement predictBundleSuccess
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
}
