package gamblenewstart.demo.Exceptions;

public class NotEnoughFunds extends BetException {
    public NotEnoughFunds() {
    }

    public NotEnoughFunds(String message) {
        super(message);
    }

    public NotEnoughFunds(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughFunds(Throwable cause) {
        super(cause);
    }

    public NotEnoughFunds(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
