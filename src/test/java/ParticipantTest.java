import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ParticipantTest {
    @Test
    public void should_throwException_when_participantName_over_5() {
        // given
        String testName = "crystal";

        // when & then
        assertThatThrownBy(() -> new Participant(testName))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void should_success_when_participantName_below_5() {
        // given
        String testName = "july";

        // when & then
        assertThatCode(() -> new Participant(testName)).doesNotThrowAnyException();
    }
}

