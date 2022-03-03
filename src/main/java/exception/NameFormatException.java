package exception;

public class NameFormatException extends IllegalArgumentException {
    public NameFormatException(String message) {
        super(message);
    }
}
