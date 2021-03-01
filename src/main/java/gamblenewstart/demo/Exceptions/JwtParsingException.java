package gamblenewstart.demo.Exceptions;

public class JwtParsingException extends RuntimeException {
    public JwtParsingException() {
    }

    public JwtParsingException(String message) {
        super(message);
    }

    public JwtParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtParsingException(Throwable cause) {
        super(cause);
    }

    public JwtParsingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
