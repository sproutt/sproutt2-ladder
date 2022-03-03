package src.view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String INPUT_EXECUTION_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
	private static final String INPUT_SPECIFY_PLAYER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

	private Scanner scanner = new Scanner(System.in);

	public String[] inputNames() {
		System.out.println(INPUT_PLAYER_NAME_MESSAGE);
		String input = scanner.nextLine();
		String[] inputNames = input.split(",");
		return inputNames;
	}

	public String[] inputResults() {
		System.out.println(INPUT_EXECUTION_RESULT_MESSAGE);
		String input = scanner.nextLine();
		String[] inputResults = input.split(",");
		return inputResults;
	}

	public int inputLadderHeight() {
		System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
		return scanner.nextInt();
	}

	public String inputSpecifyPlayer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(INPUT_SPECIFY_PLAYER_RESULT_MESSAGE);
		return scanner.nextLine();
	}
}
