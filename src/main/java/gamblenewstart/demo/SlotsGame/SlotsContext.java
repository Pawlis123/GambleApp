package gamblenewstart.demo.SlotsGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class SlotsContext {
    private Map<String, SlotsStrategy> strategies;

    @Autowired
    public SlotsContext(Set<SlotsStrategy> slotsStrategySet) {
        createSlotsStrategy(slotsStrategySet);
    }

    public SlotsStrategy findStrategy(String slotsName){
        return strategies.get(slotsName);
    }

    private void createSlotsStrategy(Set<SlotsStrategy> strategySet){
        strategies = new HashMap<>();
        strategySet.forEach(
            SlotsStrategy -> strategies.put(SlotsStrategy.getSlotsName(), SlotsStrategy)
        );
    }
}
