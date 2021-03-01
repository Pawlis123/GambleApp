package gamblenewstart.demo.Components;

import gamblenewstart.demo.ErrorResponses.JwtErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JwtErrorHandler {

    public ResponseEntity<JwtErrorResponse> jwtErrorResponseResponseEntity(String message){
        JwtErrorResponse errorResponse = new JwtErrorResponse
                (HttpStatus.BAD_REQUEST.value(), // is this a proper http response??
                    message,
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
