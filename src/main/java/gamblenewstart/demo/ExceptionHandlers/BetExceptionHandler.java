package gamblenewstart.demo.ExceptionHandlers;


import gamblenewstart.demo.ErrorResponses.BetErrorResponse;
import gamblenewstart.demo.ErrorResponses.UserErrorResponse;
import gamblenewstart.demo.Exceptions.BetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BetExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BetErrorResponse> handleException(BetException exception){
        BetErrorResponse error = new BetErrorResponse(
                HttpStatus.PRECONDITION_FAILED.value(), // is this a proper http response??
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.PRECONDITION_FAILED);
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
