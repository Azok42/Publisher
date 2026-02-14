package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Purchase {

  private Kunde kunde;
  private Publisher publisher;
  private Spiel purchasedGame;
  private Bundle purchasedBundle;
  private PublisherSale publisherSale;
  private Abo subscription;
  private Date date;

  public Purchase(Kunde kunde, Publisher publisher, Spiel purchasedGame) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.purchasedGame = purchasedGame;
    this.publisherSale = null;
    this.date = new Date();
  }

  public Purchase(
    Kunde kunde,
    Publisher publisher,
    Spiel purchasedGame,
    Date date
  ) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.purchasedGame = purchasedGame;
    this.publisherSale = null;
    this.date = date;
  }

  public Purchase(Kunde kunde, Publisher publisher, Bundle purchasedBundle) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.purchasedBundle = purchasedBundle;
    this.publisherSale = null;
    this.date = new Date();
  }

  public Purchase(
    Kunde kunde,
    Publisher publisher,
    Bundle purchasedBundle,
    Date date
  ) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.purchasedBundle = purchasedBundle;
    this.publisherSale = null;
    this.date = date;
  }

  public Purchase(Kunde kunde, Publisher publisher, Abo subscription) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.subscription = subscription;
    this.publisherSale = null;
    this.date = new Date();
  }

  public Purchase(
    Kunde kunde,
    Publisher publisher,
    Abo subscription,
    Date date
  ) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.subscription = subscription;
    this.publisherSale = null;
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  public Spiel getPurchasedGame() {
    return purchasedGame;
  }

  public Abo getSubscription() {
    return subscription;
  }

  public Bundle getPurchasedBundle() {
    return purchasedBundle;
  }

  public Kunde getKunde() {
    return kunde;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public PublisherSale getPublisherSale() {
    return publisherSale;
  }

  public void setPublisherSale(PublisherSale publisherSale) {
    this.publisherSale = publisherSale;
  }
}
