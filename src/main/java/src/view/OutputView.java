package src.view;

import java.util.List;
import java.util.Map;

import src.dto.BridgesDto;
import src.dto.LinesDto;

public class OutputView {

	private static final String LADDER_RESULT_RENDER_MESSAGE = "사다리 결과";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	private static final int IS_LADDER_BRIDGE_TRUE = 1;
	private static final int IS_LADDER_BRIDGE_FALSE = 0;
	private static final int IS_VERTICAL_BRIDGE_VALUE = -1;


	private static final String VERTICAL_BRIDGE = "|";
	private static final String HORIZON_BRIDGE = "-----";
	private static final String EMPTY_BRIDGE = "     ";

	public void ladderRenderer(LadderBluePrintDto ladderBluePrintDto) {
		int[][] ladderBlueprint = ladderBluePrintDto.getLadderBlueprint();
		for (int i = 0; i < ladderBluePrintDto.getLadderBlueprint().length; i++) {
			innerLadderRenderer(ladderBlueprint[i]);
		}
	}

	private void innerLadderRenderer(BridgesDto bridgesDto) {
		List<Integer> bridges = bridgesDto.getBridges();
		for (int j = 0; j < bridges.size(); j++) {
			printBridge(bridges.get(j));
		}
		sb.append("\n");
	}

	public void renderLadderResult(StringBuilder sbPlayers, LadderBluePrintDto ladderBluePrintDto, StringBuilder sbResult){
		System.out.println("\n" + LADDER_RESULT_RENDER_MESSAGE + "\n");
		System.out.println(sbPlayers.toString());
		ladderRenderer(ladderBluePrintDto);
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
