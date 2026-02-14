package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Bundle extends Angebot {

  private double price;
  private ArrayList<Spiel> spiele;

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
  }

  public double adjustBundlePrice(double amount) {
    return 0; //TODO: Implement
  }

  public double predictBundleSuccess() {
    return 0; //TODO: Implement
  }

  public double getPrice() {
    return price;
  }

  public ArrayList<Spiel> getSpiele() {
    return spiele;
  }
}
