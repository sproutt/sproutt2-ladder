package exception;

public class WinningMoneyIsUnderMinimumNumberSizeException extends RuntimeException{
    public WinningMoneyIsUnderMinimumNumberSizeException(String message) {
        super(message);
    }
}