package src.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import src.model.excutionResults.ExecutionResult;
import src.model.excutionResults.ExecutionResults;
import src.model.ladder.Ladder;
import src.model.ladder.Line;
import src.model.player.Player;
import src.model.player.Players;

public class Referee {
	private static final int IS_LADDER_BRIDGE_TRUE = 1;

	private ArrayList<Integer> resultIndex = new ArrayList<>();
	private Map<Player, ExecutionResult> map = new LinkedHashMap<>();

	public ArrayList<Integer> matchingResults(Players players, Ladder ladder) {

		for (int i = 0; i < players.getPlayers().size(); i++) {
			matchingEach(i * 2, ladder);
			System.out.println();
		}
		return resultIndex;
	}

	private void matchingEach(int playerIndex, Ladder ladder) {
		int index = playerIndex;
		for (int i = 0; i < ladderBlueprint.length; i++) {
			index = matchingLine(i, index, ladderBlueprint);
		}
		resultIndex.add(index / 2);
	}

	public void makeResult(Players players, ExecutionResults executionResults) {
		for (int i = 0; i < players.getPlayers().size(); i++) {
			map.put(players.getPlayers().get(i).getName(),
					executionResults.getExecutionsResults().get(resultIndex.get(i)));
		}
	}

	public List<ExecutionResult> find(List<Player> players) {
		List<ExecutionResult> executionResults = new ArrayList<>();
		for (Player player : players) {
			executionResults.add(map.get(player));
		}
		return executionResults;
	}

	public Map<Player, ExecutionResult> findAll() {
		return map;
	}
}
