package Publisher;

import java.util.Date;

public abstract class Angebot {

  private String label;
  private String text;
  private Date start;
  private Date end;

  public Angebot(String label, String text, Date start, Date end) {
    this.label = label;
    this.text = text;
    this.start = start;
    this.end = end;
  }

  /**
   * Deletes all expired Angebote from the DataManager
   * 
   * @return the amount of cleaned Angebote
   */
  public static int cleanupExpiredAngebote() {
    DataManager dataManager = DataManager.getInstance();
    int counter = 0;
    
    for (Bundle bundle : dataManager.getAllBundles()) {
      counter += dataManager.removeBundle(bundle) ? 1 : 0;
    }

    for (PublisherSale sale : dataManager.getAllPublisherSales()) {
      counter += dataManager.removePublisherSale(sale) ? 1 : 0;
    }
    
    return counter;
  }

  public Date getStart() {
    return start;
  }

  public Date getEnd() {
    return end;
  }

  public String getLabel() {
    return label;
  }

  public String getText() {
    return text;
  }
}
