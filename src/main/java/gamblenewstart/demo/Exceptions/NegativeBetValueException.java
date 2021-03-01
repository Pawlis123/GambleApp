package gamblenewstart.demo.Exceptions;

public class NegativeBetValueException extends BetException {
    public NegativeBetValueException() {
    }

    public NegativeBetValueException(String message) {
        super(message);
    }

    public NegativeBetValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeBetValueException(Throwable cause) {
        super(cause);
    }

    public NegativeBetValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
