package domain.gameresult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultNameTest {

    @Test
    @DisplayName("이름이 없을 경우 예외를 처리한다.")
    void testThrowExceptionIfEmptyName() {
        // given
        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new GameResultName(""));
        String message = illegalArgumentException.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 실행 결과 이름은 공백일 수 없습니다.");
    }
}