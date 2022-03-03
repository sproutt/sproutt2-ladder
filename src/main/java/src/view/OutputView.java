package src.view;

import java.util.List;
import java.util.Map;

import src.dto.BridgesDto;
import src.dto.LinesDto;
import src.dto.PlayersDto;
import src.dto.ResultAllDto;
import src.dto.ResultsDto;

public class OutputView {
	private static final String LADDER_RESULT_RENDER_MESSAGE = "\n사다리 결과\n";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

	private static final int IS_LADDER_BRIDGE_TRUE = 1;
	private static final int IS_LADDER_BRIDGE_FALSE = 0;
	private static final int IS_VERTICAL_BRIDGE_VALUE = -1;

	private static final String VERTICAL_BRIDGE = "|";
	private static final String HORIZON_BRIDGE = "-----";
	private static final String EMPTY_BRIDGE = "     ";

	private static final String OUTPUT_FORMAT = "%-5s ";

	private static final String RESULTS_SEPARATOR = ", ";
	private static final String PLAYER_RESULT_SEPARATOR = ":";

	public void renderLadderResult(PlayersDto playersDto, LinesDto ladderBluePrintDto, ResultsDto resultsDto) {
		System.out.println(LADDER_RESULT_RENDER_MESSAGE);
		playersRenderer(playersDto);
		ladderRenderer(ladderBluePrintDto);
		resultsRenderer(resultsDto);
	}

	public void playersRenderer(PlayersDto playersDto) {
		List<String> names = playersDto.getNames();
		for (String name : names) {
			System.out.printf(OUTPUT_FORMAT, name);
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
		System.out.print(System.lineSeparator());
	}

	private void printBridge(int value) {
		if (value == IS_LADDER_BRIDGE_FALSE) {
			System.out.print(EMPTY_BRIDGE);
		}
		if (value == IS_LADDER_BRIDGE_TRUE) {
			System.out.print(HORIZON_BRIDGE);
		}
		if (value == IS_VERTICAL_BRIDGE_VALUE) {
			System.out.print(VERTICAL_BRIDGE);
		}
	}

	public void resultsRenderer(ResultsDto resultsDto) {
		List<String> results = resultsDto.getResults();
		for (String result : results) {
			System.out.printf(OUTPUT_FORMAT, result);
		}
		System.out.print(System.lineSeparator());
	}

	public void printSingleResult(ResultsDto resultsDto) {
		System.out.println(EXECUTION_RESULT_MESSAGE);
		List<String> results = resultsDto.getResults();
		String resultMessage = String.join(RESULTS_SEPARATOR, results);
		System.out.println(resultMessage);
	}

	public void printAllResult(ResultAllDto resultAllDto) {
		System.out.println(EXECUTION_RESULT_MESSAGE);
		Map<String, String> resultAll = resultAllDto.getResultAll();
		for (String key : resultAll.keySet()) {
			System.out.println(key + PLAYER_RESULT_SEPARATOR + resultAll.get(key));
		}
	}
}
