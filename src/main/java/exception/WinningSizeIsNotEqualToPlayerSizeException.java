package exception;

public class WinningSizeIsNotEqualToPlayerSizeException extends RuntimeException {
    public WinningSizeIsNotEqualToPlayerSizeException(String message) {
        super(message);
    }
}