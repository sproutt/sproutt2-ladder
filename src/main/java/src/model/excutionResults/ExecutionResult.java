package src.model.excutionResults;

public class ExecutionResult {

	private static final String EMPTY_RESULT_ERROR_MESSAGE = "게임 결과는 1글자 이상이어야 합니다.";

	private String result;

	public ExecutionResult(String result) {
		validateEmptyResult(result);
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	private void validateEmptyResult(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException(EMPTY_RESULT_ERROR_MESSAGE);
		}
	}
}
