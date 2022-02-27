package src.model.excutionResults;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResults {
	private List<String> executionsResults;

	public ExecutionResults() {
		this.executionsResults = new ArrayList<>();
	}

	public void makeExecutionResults(String[] results) {
		for (String result : results) {
			executionsResults.add(new ExecutionResult(result));
		}
	}

	public List<ExecutionResult> getExecutionsResults() {
		return executionsResults;
	}
}
