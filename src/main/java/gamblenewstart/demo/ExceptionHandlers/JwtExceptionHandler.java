package gamblenewstart.demo.ExceptionHandlers;

import gamblenewstart.demo.ErrorResponses.BetErrorResponse;
import gamblenewstart.demo.ErrorResponses.JwtErrorResponse;
import gamblenewstart.demo.Exceptions.BetException;
import gamblenewstart.demo.Exceptions.JwtParsingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<JwtErrorResponse> handleException(JwtParsingException exception){
        JwtErrorResponse error = new JwtErrorResponse(
                HttpStatus.BAD_REQUEST.value(), // is this a proper http response??
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<BetErrorResponse> handleException(Exception exception){
        BetErrorResponse error = new BetErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
