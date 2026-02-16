package Publisher;

import java.util.Date;

public class Purchase {

  private Kunde kunde;
  private Publisher publisher;
  private Spiel purchasedGame;
  private Bundle purchasedBundle;
  private PublisherSale publisherSale;
  private Abo subscription;
  private Date date;

  /**
   * Constructor for a single game purchased now
   * @param kunde
   * @param publisher
   * @param purchasedGame
   */
  public Purchase(Kunde kunde, Publisher publisher, Spiel purchasedGame) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.purchasedGame = purchasedGame;
    this.publisherSale = null;
    this.date = new Date();
  }

  /**
   * Constructor for a single game purchased at a date
   * @param kunde
   * @param publisher
   * @param purchasedGame
   * @param date when the game was/will be purchased
   */
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

  /**
   * Constructor for a Bundle purchased now
   * @param kunde
   * @param publisher
   * @param purchasedBundle
   */
  public Purchase(Kunde kunde, Publisher publisher, Bundle purchasedBundle) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.purchasedBundle = purchasedBundle;
    this.publisherSale = null;
    this.date = new Date();
  }

  /**
   * Constructor for a bundle purchased at a date
   * @param kunde
   * @param publisher
   * @param purchasedBundle
   * @param date when the bundle was/will be purchased
   */
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

  /**
   * Constructor for a abo purchased now
   * @param kunde
   * @param publisher
   * @param subscription
   */
  public Purchase(Kunde kunde, Publisher publisher, Abo subscription) {
    this.kunde = kunde;
    this.publisher = publisher;
    this.subscription = subscription;
    this.publisherSale = null;
    this.date = new Date();
  }

  /**
   * Constructor for a abo purchased at a date
   * @param kunde
   * @param publisher
   * @param subscription
   * @param date when the abo was/will be purchased
   */
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
