package src.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import src.model.excutionResults.ExecutionResults;

class ExecutionResultsTest {

	@Test
	@DisplayName("실행 결과 입력 받았을 때 올바르게 split하여 저장하는지 테스트")
	void makeExecutionResultsWhenInputResults(){

		String input = "꽝,10000,50000,꽝";
		String[] inputResults = input.split(",");

		ExecutionResults executionResults = new ExecutionResults();
		executionResults.makeExecutionResults(inputResults);

		Assertions.assertThat(executionResults.getExecutionsResults().get(0)).isEqualTo("꽝");
	}
}