package exception;

public class PlayerNameIsOverMaxNameSizeException extends RuntimeException {
    public PlayerNameIsOverMaxNameSizeException(String message) {
        super(message);
    }
}