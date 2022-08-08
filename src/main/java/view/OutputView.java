package view;

import exception.ResultInputIsNotProperException;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    private static final String OUTPUT_RESULT = "실행 결과";
    private static final String RESULT_INPUT_IS_NOT_PROPER_EXCEPTION = "입력값이 올바르지 않습니다.";
    private static final String ALL_STRING = "all";

    public static void printResultMessage() {
        System.out.println(OUTPUT_LADDER_RESULT);
    }

    public static void printStringLadder(List<List<String>> stringLadder) {
        for (List<String> line : stringLadder) {
            printStringLine(line);
        }
    }

    public static void printGameResultMessage() {
        System.out.println(OUTPUT_RESULT);
    }

    public static void printGameResult(Map<String, String> gameResult, String playerInput) {
        validateResultInputIsProper(gameResult, playerInput);
        if (playerInput.equals(ALL_STRING)) {
            printAllPlayerGameResult(gameResult);
        } else if (gameResult.containsKey(playerInput)){
            System.out.println(gameResult.get(playerInput));
        }
    }

    private static void printAllPlayerGameResult(Map<String, String> gameResult) {
        for (int i = 0; i < gameResult.size(); i++) {
            System.out.println(gameResult.keySet().toArray()[i] + " : " + gameResult.values().toArray()[i]);
        }
    }

    private static void printStringLine(List<String> line) {
        for (String stringLine : line) {
            System.out.print(stringLine);
        }
        System.out.println();
    }

    private static void validateResultInputIsProper(Map<String, String> gameResult, String playerInput) {
        if (!(playerInput.equals(ALL_STRING)) && !gameResult.containsKey(playerInput)) {
            throw new ResultInputIsNotProperException(RESULT_INPUT_IS_NOT_PROPER_EXCEPTION);
        }
    }
}
