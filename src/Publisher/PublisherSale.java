package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class PublisherSale extends Angebot {

  private double rabatt; // 0 - 100
  private ArrayList<Spiel> games; //Purchase makes no sense... .,.

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

  public ArrayList<Spiel> getGames() {
    return games;
  }

  public boolean addGame(Spiel game) {
    return games.add(game);
  }
}
