package src.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import src.model.excutionResults.ExecutionResult;
import src.model.player.Player;

public class ResultAllDto {
	private Map<String, String> resultAll;

	private ResultAllDto(Map<String, String> resultAll){
		this.resultAll = resultAll;
	}

	public static ResultAllDto from(Map<Player, ExecutionResult> results){
		Map<String, String> resultAll = new LinkedHashMap<>();
		for (Player player : results.keySet()) {
			String playerName = player.getName();
			ExecutionResult executionResult = results.get(player);
			String resultName = executionResult.getResult();
			resultAll.put(playerName, resultName);
		}
		return new ResultAllDto(resultAll);
	}

	public Map<String, String> getResultAll() {
		return resultAll;
	}
}
