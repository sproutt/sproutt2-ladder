package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class WinningTest {
    @ParameterizedTest
    @DisplayName("잘못된 값을 입력하면 예외 메시지를 발생한다.")
    @ValueSource(strings = {"광", "-3000"})
    public void should_throw_exception_when_winning_input_is_wrong(String candidate) {
        assertThatThrownBy(() -> new Winning(candidate))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("정확한 값을 입력해야 성공이다.")
    @ValueSource(strings = {"꽝", "3000"})
    public void should_success_when_winning_input_is_correct(String candidate) {
        assertThatCode(() -> new Winning(candidate)).doesNotThrowAnyException();
    }
}
