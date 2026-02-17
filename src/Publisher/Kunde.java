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

  /**
   * Calculates a score for all games based on owned games
   * @return list of all games with score >= 1
  */
  public ArrayList<Spiel> recommendSpieleForKunde() {
    ArrayList<String> ownedGenres = new ArrayList<>();
    ArrayList<Publisher> ownedPublisher = new ArrayList<>();
    double avgOwnedRating = 0;
    int counter = 0;

    for (Purchase purchase : purchases) {
      if (purchase.getSubscription() != null)
        continue;

      if (purchase.getPurchasedGame() != null) {
        counter++;
        for (String genre : purchase.getPurchasedGame().getGenres()) {
          if (!ownedGenres.contains(genre))
            ownedGenres.add(genre);
        }

        if (!ownedPublisher.contains(purchase.getPurchasedGame().getPublisher()))
          ownedPublisher.add(purchase.getPurchasedGame().getPublisher());

        avgOwnedRating += purchase.getPurchasedGame().getBewertung();
      }


      if (purchase.getPurchasedBundle() != null)
        for (Spiel game : purchase.getPurchasedBundle().getSpiele()) {
          counter++;
          for (String genre : game.getGenres()) {
            if (!ownedGenres.contains(genre))
              ownedGenres.add(genre);
          }

          if (!ownedPublisher.contains(game.getPublisher()))
            ownedPublisher.add(game.getPublisher());

          avgOwnedRating += game.getBewertung();
        }
    }
    avgOwnedRating /= counter;

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
