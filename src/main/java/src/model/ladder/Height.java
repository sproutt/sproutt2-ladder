package src.model.ladder;

public class Height {

	private static final String UNDER_ZERO_NUMBER_ERROR_MESSAGE = "[ERROR] 높이는 양수를 입력해야 한다.";
	public static final int MINIMUM_HEIGHT = 1;
	private int height;

	public Height(int height) {
		validateNegative(height);
		this.height = height;
	}

	private void validateNegative(int height) {
		if (height < MINIMUM_HEIGHT) {
			throw new IllegalArgumentException(UNDER_ZERO_NUMBER_ERROR_MESSAGE);
		}
	}

	public int getHeight() {
		return height;
	}
}
