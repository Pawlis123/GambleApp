package gamblenewstart.demo.ExceptionHandlers;


import gamblenewstart.demo.ErrorResponses.UserErrorResponse;
import gamblenewstart.demo.Exceptions.UsernameIsBeingAlreadyUsedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegisterExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UsernameIsBeingAlreadyUsedException exception){
        UserErrorResponse error = new UserErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exception){
        UserErrorResponse error = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
