package domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {

    @Test
    @DisplayName("포인트가 오직 하나 존재할 경우 포인트의 양쪽 연결 다리의 존재 여부는 거짓을 반환한다.")
    void testWhenOnlyFirstPointExist() {
        // given
        Point point = Point.onlyFirstExist();

        // when
        boolean left = point.isLeft();
        boolean right = point.isRight();

        // then
        assertThat(left).isFalse();
        assertThat(right).isFalse();
    }

    @Test
    @DisplayName("포인트가 하나 이상일 경우 첫 번째 포인트의 왼쪽 연결 다리는 거짓을 반환한다.")
    void testWhenMoreThanOnePointLeftBridgeOfFirstPointReturnFalse() {
        // given
        Point firstPoint = Point.first(true);

        // when
        boolean left = firstPoint.isLeft();

        // then
        assertThat(left).isFalse();
    }

    @Test
    @DisplayName("이전 포인트의 오른쪽 연결 다리가 존재하면 현재 포인트의 오른쪽 연결 다리는 거짓을 반환한다.")
    void testIfPrepointRightBridgeExistPresentPointRightBridgeReturnFalse() {
        // given
        Point prePoint = Point.first(true);
        Point presentPoint = Point.next(prePoint, true);

        // when
        boolean right = presentPoint.isRight();

        // then
        assertThat(right).isFalse();
    }

    @Test
    @DisplayName("이전 포인트의 오른쪽 연결 다리가 존재하지 않으면 현재 포인트의 왼쪽 연결 다리는 거짓을 반환한다.")
    void testIfPrepointRightBridgeNotExistPresentPointRightBridgeReturnFalse() {
        // given
        Point prePoint = Point.first(false);
        Point presentPoint = Point.next(prePoint, true);

        // when
        boolean left = presentPoint.isLeft();

        // then
        assertThat(left).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트의 오른쪽 연결 다리는 존재하지 않는다.")
    void testLastPointRightBridgeIsNotExist() {
        // given
        Point firstPoint = Point.first(true);
        Point nextPoint = Point.next(firstPoint, false);
        Point lastPoint = Point.last(nextPoint);

        // when
        boolean right = lastPoint.isRight();

        // then
        assertThat(right).isFalse();
    }

    @Test
    @DisplayName("한 포인트의 왼쪽과 오른쪽 연결 다리가 존재하면 예외를 처리한다.")
    void testValidateContinuousConnectionBridge() {
        // given
        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Point(true, true));
        String message = illegalArgumentException.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 다리는 연속되어 존재할 수 없습니다.");
    }
}