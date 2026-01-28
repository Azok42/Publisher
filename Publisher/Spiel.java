package Publisher;

public class Spiel {
    private String name;
    private double price;
    private int bewertung;

    public Spiel(String name, double price, int bewertung) {
        this.name = name;
        this.price = price;
        this.bewertung = bewertung;
    }

    public double suggestOptimalPrice() {
        return 0;
    }

    public boolean checkAboOverlap(Abo newAbo) {
        return false;
    }

    public void syncSpielPreisBundle() {

    }
}
