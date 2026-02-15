package Publisher;

import java.util.ArrayList;

public class Kunde {

  private String email;
  private String user;
  private ArrayList<Purchase> purchases;

  public Kunde(String email, String user) {
    this.email = email;
    this.user = user;
    purchases = new ArrayList<Purchase>();
  }

  public ArrayList<Spiel> recommendSpieleForKunde() {
    return null; //TODO: Implement recommendSpieleForKunde
  }

  public PublisherSale generatePersonalizedSale(Publisher publisher) {
    return null; //TODO: Implement generatePersonalizedSale
  }

  public String getEmail() {
    return email;
  }

  public String getUser() {
    return user;
  }

  public Purchase subscribe(Abo abo) {
    return null; //TODO: Implement subscribe(abo)
  } //cancelSubscription?

  public Purchase purchase(Bundle bundle) {
    return null; //TODO: Implement purchase(Bundle)
  }

  public Purchase purchase(Spiel spiel) {
    return null; //TODO: Implement purchase(Spiel)
  }

  public ArrayList<Purchase> getPurchases() {
    return purchases;
  }

  protected boolean addPurchase(Purchase purchase) {
    return purchases.add(purchase);
  }

  public ArrayList<Spiel> getSpieleFromPublisherSales() {
    ArrayList<Spiel> result = new ArrayList<>();
    for (Purchase p : purchases) {
      if (p.getPublisherSale() != null) {
        //TODO: Track games from publisher sales
      }
    }
    return result;
  }
}
