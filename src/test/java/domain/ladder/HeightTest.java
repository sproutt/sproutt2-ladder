package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {
    
    @Test
    @DisplayName("사다리의 높이가 음수일 경우 예외를 처리한다.")
    void testIfLadderHeightIsNegativeThrowsException() {
        // given
        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Height(-1));
        String message = illegalArgumentException.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 높이는 0 초과를 입력합니다.");
    }
}