package src.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Referee {
	private static final int IS_LADDER_BRIDGE_TRUE = 1;
	private ArrayList<Integer> resultIndex = new ArrayList<>();
	private Map<String, String> map = new HashMap<>();

	public ArrayList<Integer> matchingResults(Players players, int[][] ladderBlueprint) {
		for (int i = 0; i < players.getPlayers().size(); i++) {
			matchingEach(i, ladderBlueprint);
		}
		return resultIndex;
	}

	private void matchingEach(int playerIndex, int[][] ladderBlueprint) {
		int index = 0;
		if (playerIndex > 0) {
			index = 1;
			index *= 2*playerIndex;
		}

		for (int i = 0; i < ladderBlueprint.length; i++) {
			for (int j = index; j < ladderBlueprint[i].length; j++) {
				if (j == 0 && ladderBlueprint[i][j + 1] == IS_LADDER_BRIDGE_TRUE) {
					index += 2;
					break;
				}
				if (j == ladderBlueprint[i].length - 1 && ladderBlueprint[i][j - 1] == IS_LADDER_BRIDGE_TRUE) {
					index -= 2;
					break;
				}
				if (j != ladderBlueprint[i].length-1 && j != 0 && ladderBlueprint[i][j + 1] == IS_LADDER_BRIDGE_TRUE) {
					index += 2;
					break;
				}
				if (j != ladderBlueprint[i].length-1 && j != 0 && ladderBlueprint[i][j - 1] == IS_LADDER_BRIDGE_TRUE) {
					index -= 2;
					break;
				}
				break;
			}
		}
		// index 1일때 0으로 인덱스 추가
		resultIndex.add(index/2);
	}

	public void makeResult(Players players, ExecutionResults executionResults) {
		for (int i = 0; i < players.getPlayers().size(); i++) {
			map.put(players.getPlayers().get(i).getName(),
					executionResults.getExecutionsResults().get(resultIndex.get(i)));
		}
	}

	public String find(String name) {
		return map.get(name);
	}

	public Map<String, String> findAll() {
		return map;
	}
}
