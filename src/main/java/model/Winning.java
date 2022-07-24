package model;

import exception.WinningInputShouldBeEnteredCorrectlyException;
import exception.WinningMoneyIsUnderMinimumNumberSizeException;

import java.util.regex.Pattern;

public class Winning extends Info {
    private static final int MINIMUM_NUMBER_SIZE = 0;
    private static final String LOSING_TICKET = "꽝";
    private static final String numberPattern = "^[0-9]+$";
    private static final String WINNING_MONEY_IS_UNDER_MINIMUM_NUMBER_SIZE = "당첨금은 0이상이어야 합니다.";
    private static final String WINNING_INPUT_SHOULD_BE_ENTERED_CORRECTLY = "'꽝'을 정확하게 입력해야 합니다.";

    public Winning(String name) {
        checkWinningInputType(name);
        this.info = name;
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
            throw new WinningMoneyIsUnderMinimumNumberSizeException(WINNING_MONEY_IS_UNDER_MINIMUM_NUMBER_SIZE);
        }
    }

    private void validateNotNumberInput(String input) {
        if (!input.equals(LOSING_TICKET)) {
            throw new WinningInputShouldBeEnteredCorrectlyException(WINNING_INPUT_SHOULD_BE_ENTERED_CORRECTLY);
        }
    }

    private boolean isNumber(String input) {
        return Pattern.matches(numberPattern, input);
    }
}