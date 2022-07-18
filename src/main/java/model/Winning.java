package model;

import java.util.regex.Pattern;

public class Winning {
    private static final int MINIMUM_NUMBER_SIZE = 0;
    private static final String LOSING_TICKET = "꽝";
    private static final String numberPattern = "^[0-9]+$";
    private String winningInput;


    public Winning(String winningInput) {
        checkWinningInputType(winningInput);
        this.winningInput = winningInput;
    }

    private void checkWinningInputType(String input) {
        if (isNumber(input)) {
            validateNumberInput(Integer.parseInt(input));
        }
        if (!isNumber(input)) {
            validateNotNumberInput(input);
        }
    }

    private void validateNumberInput(int input) {
        if (input < MINIMUM_NUMBER_SIZE) {
            throw new RuntimeException("당첨금은 0이상이어야 합니다.");
        }
    }

    private void validateNotNumberInput(String input) {
        if (!input.equals(LOSING_TICKET)) {
            throw new RuntimeException("'꽝'을 정확하게 입력해야 합니다.");
        }
    }

    private boolean isNumber(String input) {
        return Pattern.matches(numberPattern, input);
    }

    public String getWinningInput() {
        return winningInput;
    }
}
