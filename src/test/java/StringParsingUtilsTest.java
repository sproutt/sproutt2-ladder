import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParsingUtilsTest {

    @Test
    public void should_success_when_string_is_parsed_to_participant() {
        // given
        String testInput = "july, rayna, lua";
        int testSize = 3;

        // when
        List<Participant> testParticipant = StringParsingUtils.parseToParticipant(testInput);

        // then
        assertThat(testParticipant.size() == testSize).isTrue();
    }
}