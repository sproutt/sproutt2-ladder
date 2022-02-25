package src.dto;

import java.util.List;
import java.util.stream.Collectors;

import src.model.excutionResults.ExecutionResult;

public class ResultsDto {
	private List<String> results;

	private ResultsDto(List<String> results){
		this.results = results;
	}

	public static ResultsDto from(List<ExecutionResult> results) {
		List<String> resultNames = results.stream()
				.map(ExecutionResult::getResult)
				.collect(Collectors.toList());
		return new ResultsDto(resultNames);
	}

	public List<String> getResults() {
		return results;
	}
}
