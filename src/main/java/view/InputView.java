package view;

import model.StringInfo;
import utils.StringParsingUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PARTICIPANT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_WINNING_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_GET_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<StringInfo> inputPlayer() {
        System.out.println(INPUT_PARTICIPANT_MESSAGE);
        return StringParsingUtils.parseToName(scanner.nextLine());
    }

    public static List<StringInfo> inputWinning() {
        System.out.println(INPUT_WINNING_MESSAGE);
        return StringParsingUtils.parseToName(scanner.nextLine());
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_MAX_LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputResult() {
        System.out.println(INPUT_GET_RESULT_MESSAGE);
        return scanner.nextLine();
    }
}
