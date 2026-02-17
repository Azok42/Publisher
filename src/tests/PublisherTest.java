package tests;

import static org.junit.jupiter.api.Assertions.*;

import Publisher.*;
import java.util.*;
import org.junit.jupiter.api.*;

public class PublisherTest {

  private DataManager dm;
  private Publisher pub;
  private Date now, later;

  @BeforeEach
  void setUp() {
    dm = DataManager.getInstance();
    dm.clearAll();
    pub = new Publisher("EA", "Play");
    dm.addPublisher(pub);
    now = new Date();
    later = new Date(now.getTime() + 86400000L * 30);
  }

  @Test
  void testPublisherCreation() {
    assertEquals("EA", pub.getFname());
    assertEquals("Play", pub.getMotto());
  }

  @Test
  void testAddRemovePublisher() {
    Publisher p2 = new Publisher("Ubisoft", "Motto");
    assertTrue(dm.addPublisher(p2));
    assertFalse(dm.addPublisher(p2)); // duplicate
    assertEquals(pub, dm.findPublisher("EA"));
    assertTrue(dm.removePublisher(p2));
  }

  @Test
  void testAddNullPublisher() {
    assertFalse(dm.addPublisher(null));
  }

  @Test
  void testSaleRabatt() {
    PublisherSale sale = new PublisherSale("Sale", "50% off", now, later, 50);
    assertEquals(50, sale.getRabatt());
    sale.setPublisher(pub);
    assertEquals(pub, sale.getPublisher());
  }

  @Test
  void testSaleAddGame() {
    PublisherSale sale = new PublisherSale("Sale", "Desc", now, later, 25);
    Spiel s = createSpiel("FIFA", 60);
    assertTrue(sale.addGame(s));
    assertEquals(1, sale.getGames().size());
  }

  @Test
  void testRevenueWithDiscount() {
    Spiel s = createSpiel("Game", 100);
    dm.addSpiel(s);

    PublisherSale sale = new PublisherSale("Sale", "50%", now, later, 50);
    sale.setPublisher(pub);
    dm.addPublisherSale(sale);

    Kunde k = new Kunde("a@b.com", "User");
    Purchase p = new Purchase(k, pub, s);
    pub.getPurchases().add(p);

    double rev = pub.calculatePublisherRevenue(
      new Date(0),
      new Date(Long.MAX_VALUE)
    );
    assertEquals(50.0, rev, 0.01); // 100 * 0.5
  }

  @Test
  void testBundleCreation() {
    ArrayList<Spiel> games = new ArrayList<>(
      Arrays.asList(createSpiel("A", 30), createSpiel("B", 20))
    );
    Bundle b = new Bundle("Pack", "Desc", now, later, 40, games);

    assertEquals(40, b.getPrice());
    assertEquals(2, b.getSpiele().size());
    assertEquals(0, b.getSales());
  }

  @Test
  void testBundleAddToDataManager() {
    Bundle b = new Bundle(
      "Pack",
      "Desc",
      now,
      later,
      50,
      new ArrayList<>(Arrays.asList(createSpiel("X", 60)))
    );
    b.setPublisher(pub);
    assertTrue(dm.addBundle(b));
    assertEquals(b, dm.findBundle("Pack"));
  }

  @Test
  void testBundlePriceAdjust() {
    Bundle b = new Bundle("Pack", "Desc", now, later, 100, new ArrayList<>());
    assertEquals(80.0, b.adjustBundlePrice(80), 0.01);
    assertEquals(80.0, b.getPrice(), 0.01);
  }

  @Test
  void testBundleSuccess() {
    Spiel s1 = createSpiel("A", 60); // rating ~5
    Spiel s2 = createSpiel("B", 40); // rating ~5
    Bundle b = new Bundle(
      "Pack",
      "Desc",
      now,
      later,
      50,
      new ArrayList<>(Arrays.asList(s1, s2))
    );

    double success = b.predictBundleSuccess();
    assertTrue(success >= 0 && success <= 1);
  }

  @Test
  void testSpielInBundle() {
    Spiel s = createSpiel("Game", 50);
    Bundle b = new Bundle(
      "Pack",
      "Desc",
      now,
      later,
      40,
      new ArrayList<>(Arrays.asList(s))
    );
    dm.addBundle(b);

    assertTrue(s.getBundles().contains(b));
  }

  // Helper
  private Spiel createSpiel(String name, double price) {
    return new Spiel(
      name,
      price,
      new ArrayList<>(Arrays.asList("Action")),
      new ArrayList<>(Arrays.asList(5, 5)),
      pub
    );
  }
}
