package model;

import exception.HeightIsUnderMiniHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HeightTest {
    @Test
    @DisplayName("높이가 1 아래인 경우 예외 메시지를 발생한다.")
    public void should_throwException_when_height_is_under_1() {
        // given
        int testHeight = -1;

        // when & then
        assertThatThrownBy(() -> new Height(testHeight))
                .isInstanceOf(HeightIsUnderMiniHeightException.class);
    }

    @Test
    @DisplayName("높이가 1 이상인 경우 성공이다.")
    public void should_success_when_height_is_over_1() {
        // given
        int testHeight = 5;

        // when & then
        assertThatCode(() -> new Height(testHeight)).doesNotThrowAnyException();
    }
}