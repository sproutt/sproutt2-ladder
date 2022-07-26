package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

public class WinningTest {
    @ParameterizedTest
    @ValueSource(strings = {"광", "-3000"})
    public void should_throw_exception_when_winning_input_is_wrong(String candidate) {
        assertThatThrownBy(() -> new Winning(candidate))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "3000"})
    public void should_success_when_winning_input_is_correct(String candidate) {
        assertThatCode(()-> new Winning(candidate)).doesNotThrowAnyException();
    }
}
