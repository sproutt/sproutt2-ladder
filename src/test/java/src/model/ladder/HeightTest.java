package src.model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HeightTest {

	private static final String UNDER_ZERO_NUMBER_ERROR_MESSAGE = "[ERROR] 높이는 양수를 입력해야 한다.";

	@Test
	@DisplayName("높이에 0이 들어올 때 예외를 발생 시킨다.")
	void whenInputZeroThrowException() {
		int height = 0;
		assertThatThrownBy(() -> new Height(height))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(UNDER_ZERO_NUMBER_ERROR_MESSAGE);
	}

	@Test
	@DisplayName("음수가 들어올 때, 예외를 발생 시킨다.")
	void whenInputNegativeThrowException(){
		int height = -1;
		assertThatThrownBy(() -> new Height(height))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(UNDER_ZERO_NUMBER_ERROR_MESSAGE);
	}
}