package domain.player;

import exception.NameFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름이 없을 경우 예외를 처리한다.")
    void testThrowNameFormatExceptionIfNameEmpty() {
        // given
        // when
        NameFormatException nameFormatException = assertThrows(NameFormatException.class, () -> new Name(""));
        String message = nameFormatException.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("이름의 길이가 5글자를 초과할 경우 예외를 처리한다.")
    void testThrowNameFormatExceptionIfNameLengthIsOverFiveCharacter() {
        // given
        // when
        NameFormatException nameFormatException = assertThrows(NameFormatException.class, () -> new Name("abcdefg"));
        String message = nameFormatException.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 이름은 5글자를 초과할 수 없습니다.");
    }
}