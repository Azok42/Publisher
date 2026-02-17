package Publisher;

import java.util.ArrayList;
import java.util.Date;

public class PublisherSale extends Angebot {

  private double rabatt; // 0 - 100
  private ArrayList<Spiel> games;
  private Publisher publisher;

  public PublisherSale(
    String label,
    String text,
    Date start,
    Date end,
    double rabatt
  ) {
    super(label, text, start, end);
    this.rabatt = rabatt;
    this.games = new ArrayList<>();
    this.publisher = null;
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

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return "PublisherSale [rabatt=" + rabatt + ", games=" + games + "]";
  }
}
