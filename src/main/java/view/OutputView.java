package view;

import model.Ladder;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";

    public static void printResultMessage() {
        System.out.println(OUTPUT_LADDER_RESULT);
    }

    public static void printStringLadder(List<List<String>> stringLadder) {
        for (List<String> line : stringLadder) {
            printStringLine(line);
        }
    }

    private static void printStringLine(List<String> line) {
        for (String stringLine : line) {
            System.out.print(stringLine);
        }
        System.out.println();
    }
}
