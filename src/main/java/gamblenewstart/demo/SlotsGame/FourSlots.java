package gamblenewstart.demo.SlotsGame;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@Qualifier("FOUR")
public class FourSlots implements SlotsStrategy, Colour {

    private final Random randomizer;

    public FourSlots() {
        randomizer = new Random();
    }

    public String getSlotsName() {
        return "Four";
    }

    @Override
    public String[] resultGenerator() {
        String[] lotteryResult = new String[4];
        for(int i = 0; i<lotteryResult.length;i++)
            lotteryResult[i] = (Colour.colours)[randomizer.nextInt(Colour.colours.length)];

        return lotteryResult;
    }

    @Override
    public long prizeGenerator(String[] results, long bet) {

        Map<String,Integer> resultMap = new HashMap<>();
        String secondStreak = "";
        double multiplier;

        for (String result : results) {

            if (!resultMap.containsKey(result))
                resultMap.put(result, 1);
            else {
                resultMap.put(result, resultMap.get(result) + 1);
            }
        }
        if(resultMap.size() == 4)
            return 0;
        String maxColour = Collections.max(resultMap.entrySet(), Map.Entry.comparingByValue()).getKey();

         if(resultMap.size() == 2 && resultMap.containsValue(3)){
            //three same colours
            multiplier = Colour.tripleStreakMultiplierMap.get(maxColour) + fourSlotsBonus;
        }
        else if(resultMap.size() == 2 && resultMap.containsValue(2)) {
            // 2x double same colours
             for (String result : results) {
                 if (!result.equals(maxColour))
                     secondStreak = result;
             }
             multiplier = Colour.doubleStreakMultiplierMap.get(maxColour)*Colour.doubleStreakMultiplierMap.get(secondStreak);
        }
        else if(resultMap.size() == 3){
            // double same colours
             multiplier = Colour.doubleStreakMultiplierMap.get(maxColour);
         }
        else{
            //four same colours
          multiplier = Colour.quadrupleStreakMultiplierMap.get(maxColour);
         }
    return  Math.round(multiplier*bet);
    }



}
