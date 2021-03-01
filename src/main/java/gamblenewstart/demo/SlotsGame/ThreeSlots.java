package gamblenewstart.demo.SlotsGame;


import gamblenewstart.demo.Entities.SlotsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Component
public class ThreeSlots implements SlotsStrategy, Colour {

    private final Random randomizer;

    public ThreeSlots() {
        randomizer = new Random();
    }


    @Override
    public String getSlotsName() {
        return "Three";
    }

    @Override
    public String[] resultGenerator() {
        String[] result = new String[3];
        for(int i = 0; i<result.length;i++)
            result[i] = (Colour.colours)[randomizer.nextInt(Colour.colours.length)];
        return result;
    }

    @Override
    public long prizeGenerator(String[] results, long bet) {
        Map<String,Integer> resultMap = new HashMap<>();
        int streak = 0;
        String streakString = "";
        double multiplier = 0;
        for (String result : results) {

            if (!resultMap.containsKey(result))
                resultMap.put(result, 1);
            else {
                resultMap.put(result, resultMap.get(result) + 1);
            }
        }
        for (Map.Entry<String,Integer> entry : resultMap.entrySet())
            if(entry.getValue()>=2){
                streak = entry.getValue();
                streakString = entry.getKey();
            }

        if(streak == 2)
            multiplier = Colour.doubleStreakMultiplierMap.get(streakString);
        else if(streak == 3)
            multiplier = Colour.tripleStreakMultiplierMap.get(streakString);

        return Math.round(multiplier*bet);
    }

}
