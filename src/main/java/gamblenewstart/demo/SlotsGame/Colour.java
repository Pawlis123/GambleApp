package gamblenewstart.demo.SlotsGame;

import java.util.HashMap;
import java.util.Map;

public interface Colour {
    String DIAMONDS = "diamonds";
    String CLUBS = "clubs";
    String HEARTS = "hearts";
    String SPADES = "spades";
    String JOKER = "joker";
    String[] colours = {DIAMONDS,CLUBS,HEARTS,SPADES,JOKER};
    double clubsMultiplier = 1.1;
    double diamondMultiplier = 1.2;
    double heartsMultiplier = 1.3;
    double spadesMultiplier = 1.4;
    double jokerMultiplier = 1.5;
    double completeClubsMultiplier = 1.9;
    double completeDiamondsMultiplier = 2.0;
    double completeHeartsMultiplier = 2.1;
    double completeSpadesMultiplier = 2.2;
    double completeJokerMultiplier = 2.3;
    double quadrupleDiamondsMultiplier = 5.1;
    double quadrupleSpadesMultiplier = 5.3;
    double quadrupleClubsMultiplier = 5.0;
    double quadrupleHeartsMultiplier = 5.2;
    double quadrupleJokerMultiplier = 5.5;
    double fourSlotsBonus = 0.15;

    Map<String,Double> doubleStreakMultiplierMap = new HashMap<String,Double>() {{
        put(colours[0],diamondMultiplier);
        put(colours[1],clubsMultiplier);
        put(colours[2],heartsMultiplier);
        put(colours[3],spadesMultiplier);
        put(colours[4],jokerMultiplier);
    }};
    Map<String,Double> tripleStreakMultiplierMap = new HashMap<String, Double>(){{
        put(colours[0],completeDiamondsMultiplier);
        put(colours[1],completeClubsMultiplier);
        put(colours[2],completeHeartsMultiplier);
        put(colours[3],completeSpadesMultiplier);
        put(colours[4],completeJokerMultiplier);
    }};
    Map<String,Double> quadrupleStreakMultiplierMap = new HashMap<String,Double>(){{
        put(colours[0],quadrupleDiamondsMultiplier);
        put(colours[1],quadrupleClubsMultiplier);
        put(colours[2],quadrupleHeartsMultiplier);
        put(colours[3],quadrupleSpadesMultiplier);
        put(colours[4],quadrupleJokerMultiplier);
    }};

}
