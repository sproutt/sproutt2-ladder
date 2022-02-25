package src.view;

import java.util.List;
import java.util.Map;

import src.dto.BridgesDto;
import src.dto.LinesDto;
import src.dto.PlayersDto;
import src.dto.ResultsDto;

public class OutputView {

	private static final String LADDER_RESULT_RENDER_MESSAGE = "사다리 결과";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	private static final int IS_LADDER_BRIDGE_TRUE = 1;
	private static final int IS_LADDER_BRIDGE_FALSE = 0;
	private static final int IS_VERTICAL_BRIDGE_VALUE = -1;


	private static final String VERTICAL_BRIDGE = "|";
	private static final String HORIZON_BRIDGE = "-----";
	private static final String EMPTY_BRIDGE = "     ";

	private static final String PLAYER_NAME_FORMAT = "%5s ";

	public void renderLadderResult(PlayersDto playersDto, LinesDto ladderBluePrintDto, ResultsDto resultsDto){
		System.out.println(LADDER_RESULT_RENDER_MESSAGE);
		playersRenderer(playersDto);
		ladderRenderer(ladderBluePrintDto);
		resultsRenderer(resultsDto);
	}

	public void playersRenderer (PlayersDto playersDto) {
		List<String> names = playersDto.getNames();
		for (String name : names) {
			System.out.printf(OUTPUT_FORMAT,name);
		}
		System.out.print(System.lineSeparator());
	}

	public void ladderRenderer(LinesDto linesDto) {
		List<BridgesDto> bridgesDtos = linesDto.getLinesDto();
		for (int i = 0; i < bridgesDtos.size(); i++) {
			innerLadderRenderer(bridgesDtos.get(i));
		}
	}

	private void innerLadderRenderer(BridgesDto bridgesDto) {
		List<Integer> bridges = bridgesDto.getBridges();
		for (int j = 0; j < bridges.size(); j++) {
			printBridge(bridges.get(j));
		}
		sb.append("\n");
	}

	public void resultsRenderer (ResultsDto resultsDto){
		List<String> results = resultsDto.getResults();
		for (String result : results) {
			System.out.printf(OUTPUT_FORMAT, result);
		}
		System.out.print(System.lineSeparator());
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
