package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringParsingUtilsTest {
    @ParameterizedTest
    @DisplayName("타입이 list 형으로 변환 완료되면 성공이다.")
    @ValueSource(strings = {"july, rayna, lua", "2000, 꽝, 3000"})
    public void should_success_when_string_type_is_changed_to_list(String testInput) {
        assertThat(StringParsingUtils.parseToName(testInput)).asList();
    }
}