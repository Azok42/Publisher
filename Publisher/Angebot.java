package Publisher;

import java.util.Date;

public class Angebot {

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

  public static int cleanupExpiredAngebote() {
    return 0; //TODO: Implement
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
