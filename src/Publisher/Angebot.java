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
   * Checks if this Angebot is expired (end date is before now)
   * @return true if expired, false otherwise
   */
  public boolean isExpired() {
    return end.before(new Date());
  }

  /**
   * Deletes all expired Angebote from the DataManager
   *
   * @return the amount of cleaned Angebote
   */
  public static int cleanupExpiredAngebote() {
    DataManager dataManager = DataManager.getInstance();
    int counter = 0;
    Date now = new Date();

    for (Bundle bundle : new java.util.ArrayList<>(
      dataManager.getAllBundles()
    )) {
      if (bundle.getEnd().before(now)) {
        counter += dataManager.removeBundle(bundle) ? 1 : 0;
      }
    }

    for (PublisherSale sale : new java.util.ArrayList<>(
      dataManager.getAllPublisherSales()
    )) {
      if (sale.getEnd().before(now)) {
        counter += dataManager.removePublisherSale(sale) ? 1 : 0;
      }
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

  @Override
  public String toString() {
    return (
      "Angebot [label=" +
      label +
      ", text=" +
      text +
      ", start=" +
      start +
      ", end=" +
      end +
      "]"
    );
  }
}
