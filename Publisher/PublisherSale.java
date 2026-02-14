package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class PublisherSale extends Angebot {

  private double rabatt; // 0 - 100
  private ArrayList<Purchase> purchases;

  public PublisherSale(
    String label,
    String text,
    Date start,
    Date end,
    double rabatt
  ) {
    super(label, text, start, end);
    this.rabatt = rabatt;
  }

  public double simulateRabattImpact(double price) {
    return 0; //TODO: Implement simulateRabattImpact
  }

  public double getRabatt() {
    return rabatt;
  }

  public ArrayList<Purchase> getPurchases() {
    return purchases;
  }

  public boolean addPurchase(Purchase purchase) {
    //TODO: validate Date for addPurchase
    return purchases.add(purchase);
  }
}
