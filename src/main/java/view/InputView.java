package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PLAYER_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String INPUT_GAME_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PLAYER_NAME_MESSAGE = "결과를 보고 싶은 사람은?";

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public List<String> inputPlayer() {
        System.out.println(INPUT_PLAYER_MESSAGE);
        List<String> playerNames = splitByDelimiter(scanner.nextLine());
        return trim(playerNames);
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    private List<String> splitByDelimiter(String playerNames) {
        return Arrays.asList(playerNames.split(DELIMITER));
    }

    private List<String> trim(List<String> playerNames) {
        return playerNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> inputGameResult() {
        System.out.println(INPUT_GAME_RESULT_MESSAGE);
        List<String> gameResults = splitByDelimiter(scanner.nextLine());
        return trim(gameResults);
    }

    public String inputPlayerName() {
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);
        return scanner.nextLine();
    }
}
