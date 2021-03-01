package gamblenewstart.demo.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SlotsResponse {
    private long prize;
    private String[] result;
}