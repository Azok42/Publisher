package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class Kunde {

  private String email;
  private String user;
  private ArrayList<Purchase> purchases;

  public Kunde(String email, String user) {
    this.email = email;
    this.user = user;
    purchases = new ArrayList<>();
  }

  /**
   * Calculates a score for all games based on owned games
   * @return list of all games with score >= 1
  */
  public ArrayList<Spiel> recommendSpieleForKunde() {
    ArrayList<String> ownedGenres = new ArrayList<>();
    ArrayList<Publisher> ownedPublisher = new ArrayList<>();

    for (Purchase purchase : purchases) {
      if (purchase.getSubscription() != null)
        continue;

      if (purchase.getPurchasedGame() != null) {
        for (String genre : purchase.getPurchasedGame().getGenres()) {
          if (!ownedGenres.contains(genre))
            ownedGenres.add(genre);
        }

        if (!ownedPublisher.contains(purchase.getPurchasedGame().getPublisher()))
          ownedPublisher.add(purchase.getPurchasedGame().getPublisher());
      }


      if (purchase.getPurchasedBundle() != null)
        for (Spiel game : purchase.getPurchasedBundle().getSpiele()) {
          for (String genre : game.getGenres()) {
            if (!ownedGenres.contains(genre))
              ownedGenres.add(genre);
          }

          if (!ownedPublisher.contains(game.getPublisher()))
            ownedPublisher.add(game.getPublisher());
        }
    }

    ArrayList<Spiel> recommendedSpiele = new ArrayList<>();
    DataManager dataManager = DataManager.getInstance();

    for (Spiel game : dataManager.getAllSpiele()) {
      double score = 0;
      for (String genre : game.getGenres()) {
        if (ownedGenres.contains(genre))
          score++;
      }
      score /= game.getGenres().size();
      score += ownedPublisher.contains(game.getPublisher()) ? 1 : 0;
      score += game.getBewertung() / 10;

      if (score >= 1)
        recommendedSpiele.add(game);
    }

    return recommendedSpiele;
  }

  /**
   * Creates a new PublisherSale object based on owned games and add it to the publisher
   * @param publisher
   * @return PublisherSale with Spiele based on owned games
   */
  public PublisherSale generatePersonalizedSale(Publisher publisher) {
    PublisherSale sale = new PublisherSale("Personal Sale", "", new Date(), new Date(), 33);
    ArrayList<String> ownedGenres = new ArrayList<>();
    ArrayList<Spiel> ownedGames = new ArrayList<>();

    for (Purchase purchase : purchases) {
        if (purchase.getSubscription() != null)
        continue;

      if (purchase.getPurchasedGame() != null) {
        if (purchase.getPurchasedGame().getPublisher().equals(publisher))
          ownedGames.add(purchase.getPurchasedGame());
        for (String genre : purchase.getPurchasedGame().getGenres()) {
          if (!ownedGenres.contains(genre))
            ownedGenres.add(genre);
        }
      }

      if (purchase.getPurchasedBundle() != null)
        for (Spiel game : purchase.getPurchasedBundle().getSpiele()) {
          if (game.getPublisher().equals(publisher))
            ownedGames.add(game);
          for (String genre : game.getGenres()) {
            if (!ownedGenres.contains(genre))
              ownedGenres.add(genre);
          }
        }
    }

    for (Spiel game : publisher.getSpiele()) {
      double genreSimilarity = 0;
      for (String genre : game.getGenres()) {
        if (ownedGenres.contains(genre))
          genreSimilarity++;
      }
      genreSimilarity /= game.getGenres().size();

      if (genreSimilarity >= 0.5 && !ownedGames.contains(game))
        sale.addGame(game);
    }

    publisher.addPublisherSale(sale);

    return sale;
  }

  public String getEmail() {
    return email;
  }

  public String getUser() {
    return user;
  }

  public Purchase subscribe(Abo abo) {
    Purchase purchase = new Purchase(this, abo.getGame().getPublisher(), abo);
    purchases.add(purchase);

    return purchase;
  }

  public void cancelSubscription(Purchase subscription) throws Exception {
    if (subscription.getSubscription() == null || !subscription.getKunde().equals(this))
      throw new Exception("Unowned subscription cannot be canceled");
    else
      purchases.remove(subscription);
  }

  public Purchase purchase(Bundle bundle) {
    Purchase purchase = new Purchase(this, null, bundle);
    purchases.add(purchase);

    return purchase;
  }

  public Purchase purchase(Spiel spiel) {
    Purchase purchase = new Purchase(this, spiel.getPublisher(), spiel);
    purchases.add(purchase);

    return purchase;
  }

  public Purchase giftGame(Spiel spiel, Kunde kunde) {
    Purchase purchase = new Purchase(kunde, spiel.getPublisher(), spiel);
    purchases.add(purchase);

    return purchase;
  }

  public Purchase giftGame(Spiel spiel, Kunde kunde, Date date) {
    Purchase purchase = new Purchase(kunde, spiel.getPublisher(), spiel, date);
    purchases.add(purchase);

    return purchase;
  }

  public ArrayList<Purchase> getPurchases() {
    return purchases;
  }

  protected boolean addPurchase(Purchase purchase) {
    return purchases.add(purchase);
  }
}
