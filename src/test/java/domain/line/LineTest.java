package domain.line;

import domain.point.Direction;
import domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("한 포인트의 왼쪽 연결 다리가 존재하고 오른쪽 연결 다리가 존재하지 않을 경우 방향을 왼쪽으로 반환한다.")
    void testIfLeftBridgeExistAndRightBridgeNotExistReturnDirectionLeft() {
        // given
        Point prePoint = Point.first(true);
        Point nextPoint = Point.next(prePoint, false);
        Point lastPoint = Point.last(nextPoint);

        List<Point> points = new ArrayList<>();
        points.add(prePoint);
        points.add(nextPoint);
        points.add(lastPoint);

        Line line = new Line(points);

        // when
        Direction currentPointDirection = line.findCurrentPointDirection(1);

        // then
        assertThat(currentPointDirection).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("한 포인트의 오른쪽 연결 다리가 존재하고 왼쪽 연결 다리가 존재하지 않을 경우 방향을 오른쪽으로 반환한다.")
    void testIfRightBridgeExistAndLeftBridgeNotExistReturnDirectionRight() {
        // given
        Point prePoint = Point.first(false);
        Point nextPoint = Point.next(prePoint, true);
        Point lastPoint = Point.last(nextPoint);

        List<Point> points = new ArrayList<>();
        points.add(prePoint);
        points.add(nextPoint);
        points.add(lastPoint);

        Line line = new Line(points);

        // when
        Direction currentPointDirection = line.findCurrentPointDirection(1);

        // then
        assertThat(currentPointDirection).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("한 포인트의 양쪽 다리가 모두 존재하지 않을 경우 방향을 아래로 반환한다.")
    void testIfBothBridgeNotExistReturnDirectionDown() {
        // given
        Point prePoint = Point.first(false);
        Point nextPoint = Point.next(prePoint, false);
        Point lastPoint = Point.last(nextPoint);

        List<Point> points = new ArrayList<>();
        points.add(prePoint);
        points.add(nextPoint);
        points.add(lastPoint);

        Line line = new Line(points);

        // when
        Direction currentPointDirection = line.findCurrentPointDirection(1);

        // then
        assertThat(currentPointDirection).isEqualTo(Direction.DOWN);
    }




}