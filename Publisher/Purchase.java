package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Purchase {

  private Kunde kunde;
  private Spiel purchasedGame;
  private Bundle purchasedBundle;
  private Abo subscription;
  private Date date;

  public Purchase(Kunde kunde, Spiel purchasedGame) {
    this.kunde = kunde;
    this.purchasedGame = purchasedGame;
    this.date = new Date();
  }

  public Purchase(Kunde kunde, Spiel purchasedGame, Date date) {
    this.kunde = kunde;
    this.purchasedGame = purchasedGame;
    this.date = date;
  }

  public Purchase(Kunde kunde, Bundle purchasedBundle) {
    this.kunde = kunde;
    this.purchasedBundle = purchasedBundle;
    this.date = new Date();
  }

  public Purchase(Kunde kunde, Bundle purchasedBundle, Date date) {
    this.kunde = kunde;
    this.purchasedBundle = purchasedBundle;
    this.date = date;
  }

  public Purchase(Kunde kunde, Abo subscription) {
    this.kunde = kunde;
    this.subscription = subscription;
    this.date = new Date();
  }

  public Purchase(Kunde kunde, Abo subscription, Date date) {
    this.kunde = kunde;
    this.subscription = subscription;
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
}
