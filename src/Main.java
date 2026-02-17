import Publisher.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Main class demonstrating the Publisher management system.
 * <strong>This file is AI generated and only shows a real use case for the Publisher system. </strong>
 * Creates sample data and prints a tree structure overview.
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("=== Publisher Management System Demo ===\n");

    DataManager dm = DataManager.getInstance();
    dm.clearAll();

    // ==================== CREATE PUBLISHERS ====================
    System.out.println("Creating publishers...");
    Publisher eaGames = new Publisher("EA Games", "Challenge Everything");
    Publisher ubisoft = new Publisher("Ubisoft", "Feel the Action");
    Publisher indie = new Publisher("Indie Studios", "Games from the Heart");

    dm.addPublisher(eaGames);
    dm.addPublisher(ubisoft);
    dm.addPublisher(indie);

    // ==================== CREATE GAMES ====================
    System.out.println("Creating games...");

    // EA Games
    ArrayList<String> sportsGenres = new ArrayList<>();
    sportsGenres.add("Sports");
    sportsGenres.add("Simulation");
    ArrayList<Integer> fifaRatings = new ArrayList<>();
    fifaRatings.add(8);
    fifaRatings.add(7);
    fifaRatings.add(9);
    Spiel fifa = new Spiel(
      "FIFA 25",
      69.99,
      sportsGenres,
      fifaRatings,
      eaGames
    );
    eaGames.addSpiel(fifa);

    ArrayList<String> shooterGenres = new ArrayList<>();
    shooterGenres.add("Shooter");
    shooterGenres.add("Action");
    shooterGenres.add("Multiplayer");
    ArrayList<Integer> bfRatings = new ArrayList<>();
    bfRatings.add(7);
    bfRatings.add(8);
    bfRatings.add(6);
    Spiel battlefield = new Spiel(
      "Battlefield 2042",
      59.99,
      shooterGenres,
      bfRatings,
      eaGames
    );
    eaGames.addSpiel(battlefield);

    ArrayList<Integer> apexRatings = new ArrayList<>();
    apexRatings.add(9);
    apexRatings.add(9);
    apexRatings.add(8);
    Spiel apex = new Spiel(
      "Apex Legends",
      0.0,
      shooterGenres,
      apexRatings,
      eaGames
    );
    eaGames.addSpiel(apex);

    // Ubisoft Games
    ArrayList<String> actionGenres = new ArrayList<>();
    actionGenres.add("Action");
    actionGenres.add("Adventure");
    actionGenres.add("Open World");
    ArrayList<Integer> acRatings = new ArrayList<>();
    acRatings.add(9);
    acRatings.add(8);
    acRatings.add(9);
    Spiel assassinsCreed = new Spiel(
      "Assassin's Creed Valhalla",
      49.99,
      actionGenres,
      acRatings,
      ubisoft
    );
    ubisoft.addSpiel(assassinsCreed);

    ArrayList<Integer> fcRatings = new ArrayList<>();
    fcRatings.add(8);
    fcRatings.add(7);
    fcRatings.add(8);
    Spiel farCry = new Spiel(
      "Far Cry 6",
      39.99,
      actionGenres,
      fcRatings,
      ubisoft
    );
    ubisoft.addSpiel(farCry);

    // Indie Games
    ArrayList<String> indieGenres = new ArrayList<>();
    indieGenres.add("Indie");
    indieGenres.add("Puzzle");
    indieGenres.add("Adventure");
    ArrayList<Integer> hollowRatings = new ArrayList<>();
    hollowRatings.add(10);
    hollowRatings.add(10);
    hollowRatings.add(9);
    Spiel hollowKnight = new Spiel(
      "Hollow Knight",
      14.99,
      indieGenres,
      hollowRatings,
      indie
    );
    indie.addSpiel(hollowKnight);

    ArrayList<String> rogueGenres = new ArrayList<>();
    rogueGenres.add("Roguelike");
    rogueGenres.add("Action");
    ArrayList<Integer> hadesRatings = new ArrayList<>();
    hadesRatings.add(10);
    hadesRatings.add(9);
    hadesRatings.add(10);
    Spiel hades = new Spiel("Hades", 24.99, rogueGenres, hadesRatings, indie);
    indie.addSpiel(hades);

    // ==================== CREATE ABOS ====================
    System.out.println("Creating subscriptions...");

    Abo fifaBasic = new Abo("Basic", 1, 4.99, fifa);
    Abo fifaPremium = new Abo("Premium", 12, 9.99, fifa);
    Abo fifaUltimate = new Abo("Ultimate", 6, 14.99, fifa);
    fifa.addAbo(fifaBasic);
    fifa.addAbo(fifaPremium);
    fifa.addAbo(fifaUltimate);
    dm.addAbo(fifaBasic);
    dm.addAbo(fifaPremium);
    dm.addAbo(fifaUltimate);

    Abo apexBattlePass = new Abo("Battle Pass", 3, 9.99, apex);
    apex.addAbo(apexBattlePass);
    dm.addAbo(apexBattlePass);

    Abo acSeason = new Abo("Season Pass", 12, 7.99, assassinsCreed);
    assassinsCreed.addAbo(acSeason);
    dm.addAbo(acSeason);

    // ==================== CREATE BUNDLES ====================
    System.out.println("Creating bundles...");

    Calendar cal = Calendar.getInstance();
    Date now = cal.getTime();
    cal.add(Calendar.MONTH, 3);
    Date threeMonths = cal.getTime();

    ArrayList<Spiel> eaBundle1Games = new ArrayList<>();
    eaBundle1Games.add(fifa);
    eaBundle1Games.add(battlefield);
    Bundle eaSportsBundle = new Bundle(
      "EA Sports Bundle",
      "Best sports games!",
      now,
      threeMonths,
      89.99,
      eaBundle1Games
    );
    eaGames.addBundle(eaSportsBundle);

    ArrayList<Spiel> eaBundle2Games = new ArrayList<>();
    eaBundle2Games.add(battlefield);
    eaBundle2Games.add(apex);
    Bundle eaShooterBundle = new Bundle(
      "EA Shooter Pack",
      "Action packed!",
      now,
      threeMonths,
      49.99,
      eaBundle2Games
    );
    eaGames.addBundle(eaShooterBundle);

    ArrayList<Spiel> ubiBundle = new ArrayList<>();
    ubiBundle.add(assassinsCreed);
    ubiBundle.add(farCry);
    Bundle ubisoftBundle = new Bundle(
      "Ubisoft Adventure Bundle",
      "Explore worlds!",
      now,
      threeMonths,
      64.99,
      ubiBundle
    );
    ubisoft.addBundle(ubisoftBundle);

    ArrayList<Spiel> indieBundle = new ArrayList<>();
    indieBundle.add(hollowKnight);
    indieBundle.add(hades);
    Bundle indieMasterpiece = new Bundle(
      "Indie Masterpiece Bundle",
      "Award winners!",
      now,
      threeMonths,
      29.99,
      indieBundle
    );
    indie.addBundle(indieMasterpiece);

    // ==================== CREATE PUBLISHER SALES ====================
    System.out.println("Creating publisher sales...");

    cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, -7);
    Date saleStart = cal.getTime();
    cal.add(Calendar.MONTH, 1);
    Date saleEnd = cal.getTime();

    PublisherSale eaSummerSale = new PublisherSale(
      "EA Summer Sale",
      "Up to 50% off!",
      saleStart,
      saleEnd,
      50
    );
    eaGames.addPublisherSale(eaSummerSale);

    PublisherSale eaWeekendDeal = new PublisherSale(
      "Weekend Deal",
      "25% off all games",
      saleStart,
      saleEnd,
      25
    );
    eaGames.addPublisherSale(eaWeekendDeal);

    PublisherSale ubiAnniversary = new PublisherSale(
      "Ubisoft Anniversary",
      "Celebrating 35 years!",
      saleStart,
      saleEnd,
      40
    );
    ubisoft.addPublisherSale(ubiAnniversary);

    PublisherSale indieSupport = new PublisherSale(
      "Support Indie Devs",
      "Special discount!",
      saleStart,
      saleEnd,
      20
    );
    indie.addPublisherSale(indieSupport);

    // ==================== CREATE CUSTOMERS ====================
    System.out.println("Creating customers...");

    Kunde alice = new Kunde("alice@example.com", "Alice_Gamer");
    Kunde bob = new Kunde("bob@example.com", "BobPlays");
    Kunde charlie = new Kunde("charlie@example.com", "CharlieXP");
    Kunde diana = new Kunde("diana@example.com", "DianaGaming");

    // ==================== PURCHASES ====================
    System.out.println("Processing purchases...\n");

    // Alice buys FIFA and subscribes
    Purchase aliceFifa = alice.purchase(fifa);
    eaGames.addPurchase(aliceFifa);

    Purchase aliceSub = alice.subscribe(fifaPremium);
    eaGames.addPurchase(aliceSub);

    // Bob buys the EA shooter bundle
    Purchase bobBundle = bob.purchase(eaShooterBundle);
    eaGames.addPurchase(bobBundle);

    // Charlie buys Ubisoft games
    Purchase charlieAC = charlie.purchase(assassinsCreed);
    ubisoft.addPurchase(charlieAC);

    Purchase charlieSub = charlie.subscribe(acSeason);
    ubisoft.addPurchase(charlieSub);

    // Diana buys indie bundle
    Purchase dianaBundle = diana.purchase(indieMasterpiece);
    indie.addPurchase(dianaBundle);

    // Alice gifts Hades to Bob
    Purchase giftToBob = alice.giftGame(hades, bob);
    indie.addPurchase(giftToBob);

    // ==================== ANALYSIS ====================
    System.out.println("=== Analysis Results ===\n");

    // Top games
    System.out.println("EA Games - Top 2 Games by Rating:");
    for (Spiel s : eaGames.getTopSpieleByBewertung(2)) {
      System.out.println(
        "  - " + s.getName() + " (Rating: " + s.getBewertung() + ")"
      );
    }

    System.out.println("\nIndie Studios - Top 2 Games by Rating:");
    for (Spiel s : indie.getTopSpieleByBewertung(2)) {
      System.out.println(
        "  - " + s.getName() + " (Rating: " + s.getBewertung() + ")"
      );
    }

    // Revenue calculation
    cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, -1);
    Date monthAgo = cal.getTime();
    cal.add(Calendar.MONTH, 2);
    Date monthAhead = cal.getTime();

    System.out.println("\n--- Revenue (Last Month to Next Month) ---");
    System.out.printf(
      "EA Games Revenue: $%.2f%n",
      eaGames.calculatePublisherRevenue(monthAgo, monthAhead)
    );
    System.out.printf(
      "Ubisoft Revenue: $%.2f%n",
      ubisoft.calculatePublisherRevenue(monthAgo, monthAhead)
    );
    System.out.printf(
      "Indie Studios Revenue: $%.2f%n",
      indie.calculatePublisherRevenue(monthAgo, monthAhead)
    );

    // Average discounts
    System.out.println("\n--- Average Discounts ---");
    System.out.printf(
      "EA Games Avg Discount: %.1f%%%n",
      eaGames.calculateAverageDiscount()
    );
    System.out.printf(
      "Ubisoft Avg Discount: %.1f%%%n",
      ubisoft.calculateAverageDiscount()
    );
    System.out.printf(
      "Indie Studios Avg Discount: %.1f%%%n",
      indie.calculateAverageDiscount()
    );

    // Bundle success prediction
    System.out.println("\n--- Bundle Success Predictions ---");
    System.out.printf(
      "EA Sports Bundle: %.1f%%%n",
      eaSportsBundle.predictBundleSuccess() * 100
    );
    System.out.printf(
      "Indie Masterpiece Bundle: %.1f%%%n",
      indieMasterpiece.predictBundleSuccess() * 100
    );

    // Optimal price suggestions
    System.out.println("\n--- Optimal Price Suggestions ---");
    System.out.printf(
      "FIFA 25 suggested price: $%.2f%n",
      fifa.suggestOptimalPrice()
    );
    System.out.printf(
      "Battlefield 2042 suggested price: $%.2f%n",
      battlefield.suggestOptimalPrice()
    );

    // Rabatt impact simulation
    System.out.println("\n--- Discount Impact Simulation ---");
    System.out.printf(
      "EA Games revenue with 30%% discount: $%.2f%n",
      eaGames.simulateRabattImpact(30)
    );
    System.out.printf(
      "EA Games revenue with 50%% discount: $%.2f%n",
      eaGames.simulateRabattImpact(50)
    );

    // Publisher sale limit validation
    System.out.println("\n--- Publisher Sale Limits ---");
    System.out.println(
      "EA Games at sale limit: " + eaGames.validatePublisherSaleLimit()
    );
    System.out.println(
      "Ubisoft at sale limit: " + ubisoft.validatePublisherSaleLimit()
    );

    // Customer recommendations
    System.out.println("\n--- Recommendations for Alice ---");
    ArrayList<Spiel> recommendations = alice.recommendSpieleForKunde();
    if (recommendations.isEmpty()) {
      System.out.println("  No recommendations available");
    } else {
      for (Spiel s : recommendations) {
        System.out.println("  - " + s.getName());
      }
    }

    // Generate personalized sale
    System.out.println("\n--- Personalized Sale for Charlie ---");
    PublisherSale personalSale = charlie.generatePersonalizedSale(ubisoft);
    System.out.println(
      "  Sale: " +
        personalSale.getLabel() +
        " (" +
        personalSale.getRabatt() +
        "% off)"
    );

    // Abo overlap check
    System.out.println("\n--- Abo Overlap Checks ---");
    Abo testAbo = new Abo("Premium", 6, 12.99, fifa);
    System.out.println(
      "Adding another Premium abo to FIFA would overlap: " +
        fifa.checkAboOverlap(testAbo)
    );

    // Generate report
    System.out.println("\n--- Generating Reports ---");
    boolean reportSuccess = eaGames.generatePublisherReport(
      "ea_games_report.md"
    );
    System.out.println("EA Games report generated: " + reportSuccess);

    // ==================== PRINT TREE STRUCTURE ====================
    System.out.println("\n");
    printTreeStructure(dm);
  }

  /**
   * Prints the entire data structure in a tree format
   */
  private static void printTreeStructure(DataManager dm) {
    System.out.println(
      "╔══════════════════════════════════════════════════════════════════════════════╗"
    );
    System.out.println(
      "║                        PUBLISHER SYSTEM - DATA OVERVIEW                      ║"
    );
    System.out.println(
      "╚══════════════════════════════════════════════════════════════════════════════╝"
    );
    System.out.println();
    System.out.println(
      "📊 DataManager (Total Objects: " + dm.getTotalCount() + ")"
    );
    System.out.println("│");

    ArrayList<Publisher> publishers = dm.getAllPublishers();
    for (int p = 0; p < publishers.size(); p++) {
      Publisher pub = publishers.get(p);
      boolean isLastPublisher = (p == publishers.size() - 1);
      String pubPrefix = isLastPublisher ? "└── " : "├── ";
      String childPrefix = isLastPublisher ? "    " : "│   ";

      System.out.println(pubPrefix + "🏢 Publisher: " + pub.getFname());
      System.out.println(childPrefix + "│   Motto: \"" + pub.getMotto() + "\"");
      System.out.println(childPrefix + "│");

      // Games
      ArrayList<Spiel> spiele = pub.getSpiele();
      System.out.println(childPrefix + "├── 🎮 Games (" + spiele.size() + ")");
      for (int s = 0; s < spiele.size(); s++) {
        Spiel spiel = spiele.get(s);
        boolean isLastSpiel = (s == spiele.size() - 1);
        String spielPrefix = isLastSpiel ? "└── " : "├── ";
        String spielChildPrefix = isLastSpiel ? "    " : "│   ";

        System.out.println(
          childPrefix + "│   " + spielPrefix + "📀 " + spiel.getName()
        );
        System.out.println(
          childPrefix +
            "│   " +
            spielChildPrefix +
            "├── Price: $" +
            String.format("%.2f", spiel.getPrice())
        );
        System.out.println(
          childPrefix +
            "│   " +
            spielChildPrefix +
            "├── Rating: " +
            String.format("%.1f", spiel.getBewertung()) +
            "/10"
        );
        System.out.println(
          childPrefix +
            "│   " +
            spielChildPrefix +
            "├── Genres: " +
            String.join(", ", spiel.getGenres())
        );

        // Abos for this game
        ArrayList<Abo> abos = spiel.getAbos();
        if (!abos.isEmpty()) {
          System.out.println(
            childPrefix +
              "│   " +
              spielChildPrefix +
              "└── 📋 Subscriptions (" +
              abos.size() +
              ")"
          );
          for (int a = 0; a < abos.size(); a++) {
            Abo abo = abos.get(a);
            boolean isLastAbo = (a == abos.size() - 1);
            String aboPrefix = isLastAbo ? "└── " : "├── ";
            System.out.println(
              childPrefix +
                "│   " +
                spielChildPrefix +
                "    " +
                aboPrefix +
                "🔖 " +
                abo.getType() +
                " (" +
                (int) abo.getDuration() +
                " months @ $" +
                String.format("%.2f", abo.getRent()) +
                "/mo = $" +
                String.format("%.2f", abo.getPriceForDuration()) +
                ")"
            );
          }
        } else {
          System.out.println(
            childPrefix + "│   " + spielChildPrefix + "└── 📋 Subscriptions (0)"
          );
        }
      }
      System.out.println(childPrefix + "│");

      // Bundles
      ArrayList<Bundle> bundles = pub.getBundles();
      System.out.println(
        childPrefix + "├── 📦 Bundles (" + bundles.size() + ")"
      );
      for (int b = 0; b < bundles.size(); b++) {
        Bundle bundle = bundles.get(b);
        boolean isLastBundle = (b == bundles.size() - 1);
        String bundlePrefix = isLastBundle ? "└── " : "├── ";
        String bundleChildPrefix = isLastBundle ? "    " : "│   ";

        System.out.println(
          childPrefix + "│   " + bundlePrefix + "🎁 " + bundle.getLabel()
        );
        System.out.println(
          childPrefix +
            "│   " +
            bundleChildPrefix +
            "├── Price: $" +
            String.format("%.2f", bundle.getPrice())
        );
        System.out.println(
          childPrefix +
            "│   " +
            bundleChildPrefix +
            "├── Description: \"" +
            bundle.getText() +
            "\""
        );
        System.out.println(
          childPrefix +
            "│   " +
            bundleChildPrefix +
            "├── Success Prediction: " +
            String.format("%.1f%%", bundle.predictBundleSuccess() * 100)
        );
        System.out.println(
          childPrefix + "│   " + bundleChildPrefix + "└── Contains:"
        );
        ArrayList<Spiel> bundleSpiele = bundle.getSpiele();
        for (int bs = 0; bs < bundleSpiele.size(); bs++) {
          boolean isLastBundleSpiel = (bs == bundleSpiele.size() - 1);
          String bsPrefix = isLastBundleSpiel ? "└── " : "├── ";
          System.out.println(
            childPrefix +
              "│   " +
              bundleChildPrefix +
              "    " +
              bsPrefix +
              "📀 " +
              bundleSpiele.get(bs).getName()
          );
        }
      }
      System.out.println(childPrefix + "│");

      // Publisher Sales
      ArrayList<PublisherSale> sales = pub.getPublisherSales();
      System.out.println(
        childPrefix + "├── 💰 Publisher Sales (" + sales.size() + ")"
      );
      for (int ps = 0; ps < sales.size(); ps++) {
        PublisherSale sale = sales.get(ps);
        boolean isLastSale = (ps == sales.size() - 1);
        String salePrefix = isLastSale ? "└── " : "├── ";
        String saleChildPrefix = isLastSale ? "    " : "│   ";

        System.out.println(
          childPrefix + "│   " + salePrefix + "🏷️ " + sale.getLabel()
        );
        System.out.println(
          childPrefix +
            "│   " +
            saleChildPrefix +
            "├── Discount: " +
            (int) sale.getRabatt() +
            "%"
        );
        System.out.println(
          childPrefix +
            "│   " +
            saleChildPrefix +
            "└── Description: \"" +
            sale.getText() +
            "\""
        );
      }
      System.out.println(childPrefix + "│");

      // Purchases
      ArrayList<Purchase> purchases = pub.getPurchases();
      System.out.println(
        childPrefix + "└── 🛒 Purchases (" + purchases.size() + ")"
      );
      for (int pu = 0; pu < purchases.size(); pu++) {
        Purchase purchase = purchases.get(pu);
        boolean isLastPurchase = (pu == purchases.size() - 1);
        String purchasePrefix = isLastPurchase ? "└── " : "├── ";

        String purchaseType;
        String itemName;
        if (purchase.getPurchasedGame() != null) {
          purchaseType = "🎮 Game";
          itemName = purchase.getPurchasedGame().getName();
        } else if (purchase.getPurchasedBundle() != null) {
          purchaseType = "📦 Bundle";
          itemName = purchase.getPurchasedBundle().getLabel();
        } else if (purchase.getSubscription() != null) {
          purchaseType = "📋 Subscription";
          itemName =
            purchase.getSubscription().getType() +
            " for " +
            purchase.getSubscription().getGame().getName();
        } else {
          purchaseType = "❓ Unknown";
          itemName = "N/A";
        }

        System.out.println(
          childPrefix +
            "    " +
            purchasePrefix +
            "🧾 " +
            purchase.getKunde().getUser() +
            " → " +
            purchaseType +
            ": " +
            itemName
        );
      }

      if (!isLastPublisher) {
        System.out.println("│");
      }
    }

    // Summary statistics
    System.out.println();
    System.out.println(
      "╔══════════════════════════════════════════════════════════════════════════════╗"
    );
    System.out.println(
      "║                              SUMMARY STATISTICS                              ║"
    );
    System.out.println(
      "╠══════════════════════════════════════════════════════════════════════════════╣"
    );
    System.out.printf(
      "║  📊 Total Publishers:     %-51d║%n",
      dm.getAllPublishers().size()
    );
    System.out.printf(
      "║  🎮 Total Games:          %-51d║%n",
      dm.getAllSpiele().size()
    );
    System.out.printf(
      "║  📋 Total Subscriptions:  %-51d║%n",
      dm.getAllAbos().size()
    );
    System.out.printf(
      "║  📦 Total Bundles:        %-51d║%n",
      dm.getAllBundles().size()
    );
    System.out.printf(
      "║  💰 Total Sales:          %-51d║%n",
      dm.getAllPublisherSales().size()
    );
    System.out.println(
      "╠══════════════════════════════════════════════════════════════════════════════╣"
    );
    System.out.printf(
      "║  📈 Total Objects:        %-51d║%n",
      dm.getTotalCount()
    );
    System.out.println(
      "╚══════════════════════════════════════════════════════════════════════════════╝"
    );
  }
}
