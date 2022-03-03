package src.model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class NameTest {

	private static final String OVER_FIVE_LETTERS_NAME_ERROR_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";
	private static final String EMPTY_NAME_ERROR_MESSAGE = "이름은 1글자 이상이어야 합니다.";

	@Test
	@DisplayName("빈 글자가 이름이 들어올 때 테스트")
	void 빈글자_들어올때_테스트() {
		String name = "";
		assertThatThrownBy(() -> new Name(name))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(EMPTY_NAME_ERROR_MESSAGE);
	}

	@Test
	@DisplayName("5글자가 넘는 이름이 들어올 때 테스트")
	void 다섯글자_이상_들어올때_테스트() {
		String name = "hongdo";
		assertThatThrownBy(() -> new Name(name))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(OVER_FIVE_LETTERS_NAME_ERROR_MESSAGE);
	}

	@Test
	@DisplayName("5글자인 이름이 들어올 때 테스트")
	void 다섯글자_들어올때_테스트() {
		String input = "choii";
		Name name = new Name(input);
		String actual = name.getName();
		assertThat(actual).isEqualTo(input);
	}
}