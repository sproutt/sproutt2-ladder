package model;

import exception.PlayerNameIsOverMaxNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    @Test
    @DisplayName("참여자 이름이 5글자 이상이면 예외를 발생시킨다.")
    public void should_throw_exception_when_participantName_over_5() {
        // given
        String testName = "crystal";

        // when & then
        assertThatThrownBy(() -> new Player(testName))
                .isInstanceOf(PlayerNameIsOverMaxNameSizeException.class);
    }

    @Test
    @DisplayName("참여자 이름이 5글자 이하이면 성공이다.")
    public void should_success_when_participantName_below_5() {
        // given
        String testName = "july";

        // when & then
        assertThatCode(() -> new Player(testName)).doesNotThrowAnyException();
    }
}
