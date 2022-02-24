package src.view;

import java.util.Map;

import src.dto.LadderBluePrintDto;
import src.model.Ladder;

public class OutputView {

	private static final String LADDER_RESULT_RENDER_MESSAGE = "사다리 결과";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	public StringBuilder ladderRenderer(LadderBluePrintDto ladderBluePrintDto) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ladderBluePrintDto.getLadderBlueprint().length; i++) {
			sb.append(" ");
			innerLadderRenderer(i, sb, ladderBluePrintDto);
		}
		return sb;
	}

	private void innerLadderRenderer(int i, StringBuilder sb, LadderBluePrintDto ladderBluePrintDto) {
		for (int j = 0; j < ladderBluePrintDto.getLadderBlueprint()[i].length; j++) {
			if (j % 2 == 0 && ladderBluePrintDto.getLadderBlueprint()[i][j] == 0) {
				sb.append("|");
			}
			if (j >= 1 && (j % 2) == 1 && ladderBluePrintDto.getLadderBlueprint()[i][j] == 0) {
				sb.append("     ");
			}
			if (j >= 1 && (j % 2) == 1 && ladderBluePrintDto.getLadderBlueprint()[i][j] == 1) {
				sb.append("-----");
			}
		}
		sb.append("\n");
	}

	public void renderLadderResult(StringBuilder sbPlayers, LadderBluePrintDto ladderBluePrintDto, StringBuilder sbResult){
		System.out.println("\n" + LADDER_RESULT_RENDER_MESSAGE + "\n");
		System.out.println(sbPlayers.toString());
		System.out.print(ladderRenderer(ladderBluePrintDto));
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
