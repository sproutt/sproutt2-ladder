package src.view;

import java.util.Map;

public class OutputView {

	private static final String LADDER_RESULT_RENDER_MESSAGE = "사다리 결과";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	public void renderLadderResult(StringBuilder sbPlayers, StringBuilder sbLadder, StringBuilder sbResult){
		System.out.println("\n" + LADDER_RESULT_RENDER_MESSAGE + "\n");
		System.out.println(sbPlayers.toString());
		System.out.print(sbLadder.toString());
		System.out.println(sbResult.toString());
	}

	public void printSingleResult(String string) {
		System.out.println(EXECUTION_RESULT_MESSAGE);
		System.out.println(string);
	}

	public void printAllResult(Map<String, String> resultAll) {
		System.out.println(EXECUTION_RESULT_MESSAGE);
		for (String key : resultAll.keySet()) {
			System.out.println(key + ":" + resultAll.get(key));
		}
	}
}
