package Publisher;

import java.util.ArrayList;

public class Spiel {

  private String name;
  private double price;
  private int bewertung;
  private ArrayList<Abo> abos;
  private ArrayList<Bundle> bundles;

  public Spiel(String name, double price, int bewertung) {
    this.name = name;
    this.price = price;
    this.bewertung = bewertung;
  }

  public Spiel(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public int getBewertung() {
    return this.bewertung;
  }

  public double suggestOptimalPrice() {
    return 0;
  }

  public boolean checkAboOverlap(Abo newAbo) {
    return false;
  }

  public void syncSpielPreisBundle() {}

  public double getPrice() {
    return price;
  }
}
