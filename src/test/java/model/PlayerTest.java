package model;

import exception.PlayerNameIsOverMaxNameSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    public void should_throwException_when_participantName_over_5() {
        // given
        String testName = "crystal";

        // when & then
        assertThatThrownBy(() -> new Player(testName))
                .isInstanceOf(PlayerNameIsOverMaxNameSizeException.class);
    }

    @Test
    public void should_success_when_participantName_below_5() {
        // given
        String testName = "july";

        // when & then
        assertThatCode(() -> new Player(testName)).doesNotThrowAnyException();
    }
}

