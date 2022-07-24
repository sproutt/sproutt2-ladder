package model;

import exception.HeightIsUnderMiniHeightException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HeightTest {
    @Test
    public void should_throwException_when_height_is_under_1() {
        // given
        int testHeight = -1;

        // when & then
        assertThatThrownBy(() -> new Height(testHeight))
                .isInstanceOf(HeightIsUnderMiniHeightException.class);
    }

    @Test
    public void should_success_when_height_is_over_1() {
        // given
        int testHeight = 5;

        // when & then
        assertThatCode(() -> new Height(testHeight)).doesNotThrowAnyException();
    }
}
