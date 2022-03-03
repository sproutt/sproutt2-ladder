package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {
    @Test
    @DisplayName("위치를 왼쪽으로 이동할 때 포인트의 x 좌표가 왼쪽으로 이동하는지 테스트한다.")
    void testWhenPositionMoveLeftXMoveLeft() {
        // given
        Position position = new Position(1, 0);

        // when
        position.moveLeft();

        // then
        assertThat(position.getX()).isEqualTo(0);
    }

    @Test
    @DisplayName("위치를 오른쪽으로 이동할 때 포인트의 x 좌표가 오른쪽으로 이동하는지 테스트한다.")
    void testWhenPositionMoveRightXMoveRight() {
        // given
        Position position = new Position(0, 0);

        // when
        position.moveRight();

        // then
        assertThat(position.getX()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치를 아래쪽으로 이동할 때 포인트의 y 좌표가 아래로 이동하는지 테스트한다.")
    void testWhenPositionMoveDownYMoveDown() {
        // given
        Position position = new Position(0, 0);

        // when
        position.moveDown();

        // then
        assertThat(position.getY()).isEqualTo(1);
    }

    @Test
    @DisplayName("x 좌표 또는 y 좌표가 음수일 때 예외를 처리한다.")
    void testValidateXAndYPostionIsNegative() {
        // given
        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Position(-1, 0));
        String message = illegalArgumentException.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] Position의 x, y 값은 양수입니다.");
    }
}