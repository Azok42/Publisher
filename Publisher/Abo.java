package Publisher;

public class Abo {

  private String type;
  private double duration; // in months
  private double rent; // per month
  private Spiel game;

  public Abo() {
    this.type = "Type not set";
    this.duration = -1;
    this.rent = -1;
  }

  public Abo(String type, double duration, double rent) {
    this.type = type;
    this.duration = duration;
    this.rent = rent;
  }

  public String getType() {
    return this.type;
  }

  public double getDuration() {
    return this.duration;
  }

  public double getRent() {
    return this.rent;
  }

  public double getPriceForDuration() {
    return rent * duration;
  }
}
