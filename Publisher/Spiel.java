package Publisher;

import java.util.ArrayList;

public class Spiel {

  private String name;
  private double price;
  private int bewertung;
  private Publisher publisher;
  private ArrayList<Abo> abos;
  private ArrayList<Bundle> bundles;

  public Spiel(String name, double price, int bewertung, Publisher publisher) {
    this.name = name;
    this.price = price;
    this.bewertung = bewertung;
    this.publisher = publisher;
    abos = new ArrayList<Abo>();
    bundles = new ArrayList<Bundle>();
  }

  public int getBewertung() {
    return this.bewertung;
  }

  public double suggestOptimalPrice() {
    return 0; //TODO: Implement
  }

  public boolean checkAboOverlap(Abo newAbo) {
    return false; //TODO: Implement
  }

  public void syncSpielPreisBundle() {
    return; //TODO: Implement
  }

  public double getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Abo> getAbos() {
    return abos;
  }

  public ArrayList<Bundle> getBundles() {
    return bundles;
  }

  public Publisher getPublisher() {
    return publisher;
  }
}
