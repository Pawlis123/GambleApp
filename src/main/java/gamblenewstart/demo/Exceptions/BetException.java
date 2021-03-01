package gamblenewstart.demo.Exceptions;

public class BetException extends RuntimeException {
    public BetException() {
    }

    public BetException(String message) {
        super(message);
    }

    public BetException(String message, Throwable cause) {
        super(message, cause);
    }

    public BetException(Throwable cause) {
        super(cause);
    }

    public BetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
