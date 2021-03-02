package gamblenewstart.demo.Roulette;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Roulette implements RouletteGame, RouletteConstants {

    private final Random randomizer;

    public Roulette() {
        randomizer= new Random();
    }

    @Override
    public int spinTheWheel() {
        return randomizer.nextInt(37);
    }

    @Override
    public String getColour(int winningNumber) {
        return coloursOfNumber.get(winningNumber);
    }

//    @Override
//    public long startGame(long bet, String betType) {
//        return 0;
//    }
}
