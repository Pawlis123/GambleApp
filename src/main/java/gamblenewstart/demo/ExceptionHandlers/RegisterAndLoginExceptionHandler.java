package gamblenewstart.demo.ExceptionHandlers;


import gamblenewstart.demo.ErrorResponses.BasicErrorResponse;
import gamblenewstart.demo.Exceptions.UsernameIsBeingAlreadyUsedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegisterAndLoginExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BasicErrorResponse> handleRegisterException(UsernameIsBeingAlreadyUsedException exception){
        BasicErrorResponse error = new BasicErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BasicErrorResponse> handleAuthenticationException(Exception exception){
        BasicErrorResponse error = new BasicErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                exception.getMessage(),
                System.currentTimeMillis());


        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
