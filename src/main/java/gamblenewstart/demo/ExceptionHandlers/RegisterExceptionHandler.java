package gamblenewstart.demo.ExceptionHandlers;


import gamblenewstart.demo.ErrorResponses.BasicErrorResponse;
import gamblenewstart.demo.Exceptions.UsernameIsBeingAlreadyUsedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegisterExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BasicErrorResponse> handleException(UsernameIsBeingAlreadyUsedException exception){
        BasicErrorResponse error = new BasicErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BasicErrorResponse> handleException(Exception exception){
        BasicErrorResponse error = new BasicErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
