package gamblenewstart.demo.ErrorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
