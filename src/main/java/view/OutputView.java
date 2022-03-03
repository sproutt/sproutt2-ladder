package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String VERTICAL_BAR = "|";
    private static final String SPACE = "     ";
    private static final String HYPHEN = "-----";
    private static final String PRINT_LADDER_RESULT_MESSAGE = "사다리 결과";

    public OutputView() {

    }

    public void printOneLine(List<Boolean> bridges) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SPACE);
        stringBuilder.append(VERTICAL_BAR);
        bridges.forEach(bridge -> {
            stringBuilder.append(makeBridge(bridge));
            stringBuilder.append(VERTICAL_BAR);

        });
        System.out.println(stringBuilder.toString());
    }

    public String makeBridge(boolean isConnected) {
        if (isConnected) {
            return HYPHEN;
        }
        return SPACE;
    }

    public void printPlayers(List<String> names) {
        System.out.println(PRINT_LADDER_RESULT_MESSAGE);
        for (String name : names) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    public void printGameResultNames(List<String> gameResultNames) {
        for (String gameResultName : gameResultNames) {
            System.out.printf("%-5s ", gameResultName);
        }
        System.out.println();
    }

    public void printMatchedGameResult(Map<String, String> matchedGameResult, String playerName) {
        System.out.println(matchedGameResult.get(playerName));
    }

    public void printMatchedGameResults(Map<String, String> matchedGameResult) {
        matchedGameResult.forEach((playerName, gameResultName) -> System.out.println(playerName + " : " + gameResultName));
    }
}
