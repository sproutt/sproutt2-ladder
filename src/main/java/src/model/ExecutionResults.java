package src.model;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResults {
	private List<String> executionsResults;

	public ExecutionResults() {
		this.executionsResults = new ArrayList<>();
	}

	public void makeExecutionResults(String [] results){
		for (String result : results){
			executionsResults.add(result);
		}
	}

	public StringBuilder renderResults(){
		StringBuilder sb = new StringBuilder();
		for(String result : executionsResults){
			if (result.length() < 5){
				int blank = 5 - result.length();
				sb.append(result);
				appendBlank(blank, sb);
			}
		}
		return sb;
	}

	private void appendBlank(int blank, StringBuilder sb){
		for (int i = 0; i <= blank; i++) {
			sb.append(" ");
		}
	}

	public List<String> getExecutionsResults() {
		return executionsResults;
	}
}
