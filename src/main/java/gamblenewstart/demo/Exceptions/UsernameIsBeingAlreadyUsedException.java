package gamblenewstart.demo.Exceptions;

public class UsernameIsBeingAlreadyUsedException extends RuntimeException {

    public UsernameIsBeingAlreadyUsedException() {
    }

    public UsernameIsBeingAlreadyUsedException(String message) {
        super(message);
    }

    public UsernameIsBeingAlreadyUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameIsBeingAlreadyUsedException(Throwable cause) {
        super(cause);
    }

    public UsernameIsBeingAlreadyUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
