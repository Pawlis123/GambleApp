package gamblenewstart.demo.Roulette;

public interface RouletteGame  {
    //returns random number from 0 to 36 (closed set)
    int spinTheWheel();
    //returns colour of number
    String getColour(int winningNumber);

    // YET TO BE IMPLEMENTED
    //starts the game
   //long startGame(long bet, String betType);

}
