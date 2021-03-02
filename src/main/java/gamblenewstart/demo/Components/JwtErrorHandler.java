package gamblenewstart.demo.Components;

import gamblenewstart.demo.ErrorResponses.BasicErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JwtErrorHandler {

    public ResponseEntity<BasicErrorResponse> jwtErrorResponseResponseEntity(String message){
        BasicErrorResponse errorResponse = new BasicErrorResponse
                (HttpStatus.BAD_REQUEST.value(), // is this a proper http response??
                    message,
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
