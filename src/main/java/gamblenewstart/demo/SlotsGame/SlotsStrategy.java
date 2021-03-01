package gamblenewstart.demo.SlotsGame;


import gamblenewstart.demo.Entities.SlotsResponse;
import org.springframework.http.ResponseEntity;

public interface SlotsStrategy {

    String getSlotsName();
    String[] resultGenerator();
    long prizeGenerator(String[] results, long bet);
}
