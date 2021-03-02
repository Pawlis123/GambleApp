package gamblenewstart.demo.ExceptionHandlers;


import gamblenewstart.demo.ErrorResponses.BasicErrorResponse;
import gamblenewstart.demo.Exceptions.BetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BetExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BasicErrorResponse> handleException(BetException exception){
        BasicErrorResponse error = new BasicErrorResponse(
                HttpStatus.PRECONDITION_FAILED.value(), // is this a proper http response??
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.PRECONDITION_FAILED);
    }

}
