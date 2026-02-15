package Publisher;
import java.util.ArrayList;

/**
 * DataManager class for managing Publisher data.
 *
 * @author Jame Bayerl
 * @author Anton Hackner
 */
public class DataManager {

  private ArrayList<Publisher> publishers;
  private ArrayList<Spiel> spiele;
  private ArrayList<Abo> abos;
  private ArrayList<Bundle> bundles;
  private ArrayList<PublisherSale> publisherSales;

  /**
   * Creates a new empty DataManager.
   */
  public DataManager() {
    this.publishers = new ArrayList<>();
    this.spiele = new ArrayList<>();
    this.abos = new ArrayList<>();
    this.bundles = new ArrayList<>();
    this.publisherSales = new ArrayList<>();
  }

  public boolean addPublisher(Publisher publisher) {
    if (publisher == null) return false;
    return publishers.add(publisher);
  }

  public boolean removePublisher(Publisher publisher) {
    return publishers.remove(publisher);
  }

  /**
   * Finds a publisher by name.
   *
   * @param fname the name of the publisher
   * @return the publisher if found, null otherwise
   */
  public Publisher findPublisher(String fname) {
    for (Publisher publisher : publishers) {
      if (publisher.getFname().equals(fname)) {
        return publisher;
      }
    }
    return null;
  }

  public ArrayList<Publisher> getAllPublishers() {
    return new ArrayList<>(publishers);
  }

  public boolean addSpiel(Spiel spiel) {
    if (spiel == null) return false;
    return spiele.add(spiel);
  }

  public boolean removeSpiel(Spiel spiel) {
    return spiele.remove(spiel);
  }

  /**
   * Finds a game by name.
   *
   * @param name the name of the game
   * @return the game if found, null otherwise
   */
  public Spiel findSpiel(String name) {
    for (Spiel spiel : spiele) {
      if (spiel.getName().equals(name)) {
        return spiel;
      }
    }
    return null;
  }

  public ArrayList<Spiel> findSpiel(Publisher publisher) {
    ArrayList<Spiel> result = new ArrayList<>();
    for (Spiel spiel : spiele) {
      if (spiel.getPublisher().equals(publisher)) {
        result.add(spiel);
      }
    }
    return result;
  }

  public ArrayList<Spiel> getAllSpiele() {
    return new ArrayList<>(spiele);
  }

  public boolean addAbo(Abo abo) {
    if (abo == null) return false;
    return abos.add(abo);
  }

  public boolean removeAbo(Abo abo) {
    return abos.remove(abo);
  }

  /**
   * Finds subscriptions by type.
   *
   * @param type the subscription type
   * @return list of subscriptions with the specified type
   */
  public ArrayList<Abo> findAbos(String type) {
    ArrayList<Abo> result = new ArrayList<>();
    for (Abo abo : abos) {
      if (abo.getType().equals(type)) {
        result.add(abo);
      }
    }
    return result;
  }

  /**
   * Finds subscriptions by game.
   *
   * @param spiel the game
   * @return list of subscriptions for the specified game
   */
  public ArrayList<Abo> findAbos(Spiel spiel) {
    ArrayList<Abo> result = new ArrayList<>();
    for (Abo abo : abos) {
      if (abo.getGame().equals(spiel)) {
        result.add(abo);
      }
    }
    return result;
  }

  public ArrayList<Abo> getAllAbos() {
    return new ArrayList<>(abos);
  }

  public boolean addBundle(Bundle bundle) {
    if (bundle == null) return false;
    return bundles.add(bundle);
  }

  public boolean removeBundle(Bundle bundle) {
    return bundles.remove(bundle);
  }

  /**
   * Finds a bundle by label.
   *
   * @param label the bundle label
   * @return the bundle if found, null otherwise
   */
  public Bundle findBundle(String label) {
    for (Bundle bundle : bundles) {
      if (bundle.getLabel().equals(label)) {
        return bundle;
      }
    }
    return null;
  }

  public ArrayList<Bundle> getAllBundles() {
    return new ArrayList<>(bundles);
  }

  public boolean addPublisherSale(PublisherSale sale) {
    if (sale == null) return false;
    return publisherSales.add(sale);
  }

  public boolean removePublisherSale(PublisherSale sale) {
    return publisherSales.remove(sale);
  }

  /**
   * Finds a publisher sale by label.
   *
   * @param label the sale label
   * @return the publisher sale if found, null otherwise
   */
  public PublisherSale findPublisherSale(String label) {
    for (PublisherSale sale : publisherSales) {
      if (sale.getLabel().equals(label)) {
        return sale;
      }
    }
    return null;
  }

  public ArrayList<PublisherSale> getAllPublisherSales() {
    return new ArrayList<>(publisherSales);
  }

  /**
   * Clears all data from the data manager.
   */
  public void clearAll() {
    publishers.clear();
    spiele.clear();
    abos.clear();
    bundles.clear();
    publisherSales.clear();
  }

  /**
   * Gets the total count of all managed objects.
   *
   * @return total number of objects
   */
  public int getTotalCount() {
    return (
      publishers.size() +
      spiele.size() +
      abos.size() +
      bundles.size() +
      publisherSales.size()
    );
  }
}
