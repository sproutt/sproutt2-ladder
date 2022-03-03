package domain.player;

import domain.point.Direction;
import domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    @DisplayName("포인트의 방향이 왼쪽일 때 플레이어의 위치를 x좌표는 -1만큼 y좌표는 +1만큼 이동한다.")
    void testIfPointDirectionLeftPlayerPositionXMoveAndYMove() {
        // given
        Point firstPoint = Point.first(true);
        Point nextPoint = Point.next(firstPoint, false);

        Direction direction = nextPoint.getDirection();
        Player player = new Player(new Name("채상엽"), new Position(1, 0));

        // when
        player.move(direction);

        // then
        assertThat(player.getPosition().getX()).isEqualTo(0);
        assertThat(player.getPosition().getY()).isEqualTo(1);
    }

    @Test
    @DisplayName("포인트의 방향이 오른쪽일 때 플레이어의 위치를 x좌표는 +1만큼 y좌표는 +1만큼 이동한다.")
    void testIfPointDirectionRightPlayerPositionXMoveAndYMove() {
        // given
        Point firstPoint = Point.first(true);
        Point nextPoint = Point.next(firstPoint, false);

        Direction direction = firstPoint.getDirection();
        Player player = new Player(new Name("김성혁"), new Position(0, 0));

        // when
        player.move(direction);

        // then
        assertThat(player.getPosition().getX()).isEqualTo(1);
        assertThat(player.getPosition().getY()).isEqualTo(1);
    }

    @Test
    @DisplayName("포인트의 방향이 아래일 때 플레이어의 위치를 y좌표는 +1만큼 이동한다.")
    void testIfPointDirectionDownPlayerPositionYMove() {
        // given
        Point point = Point.onlyFirstExist();
        Direction direction = point.getDirection();
        Player player = new Player(new Name("김성혁"), new Position(0, 0));

        // when
        player.move(direction);

        // then
        assertThat(player.getPosition().getY()).isEqualTo(1);
    }
}