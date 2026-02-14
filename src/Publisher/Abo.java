package src.Publisher;

public class Abo {

  private String type;
  private double duration; // in months
  private double rent; // per month
  private Spiel game;

  public Abo(String type, double duration, double rent, Spiel game) {
    this.type = type;
    this.duration = duration;
    this.rent = rent;
    this.game = game;
  }

  public Spiel getGame() {
    return game;
  }

  public double getPriceForDuration() {
    return rent * duration;
  }

  public String getType() {
    return type;
  }

  public double getDuration() {
    return duration;
  }

  public double getRent() {
    return rent;
  }
}
