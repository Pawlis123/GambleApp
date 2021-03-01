package gamblenewstart.demo.SlotsGame;

import gamblenewstart.demo.Entities.SlotsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotsResultGenerator {

    private final SlotsContext slotsContext;

    @Autowired
    public SlotsResultGenerator(SlotsContext slotsContext) {
        this.slotsContext = slotsContext;
    }

    public SlotsResponse gameResult(long bet, String gameType){
        SlotsStrategy game = slotsContext.findStrategy(gameType);
        String[] drawResult = game.resultGenerator();

        return new SlotsResponse(
                game.prizeGenerator(drawResult, bet),
                drawResult
        );
    }
}
