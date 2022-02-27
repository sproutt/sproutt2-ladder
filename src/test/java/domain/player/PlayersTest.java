package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("결과를 보고 싶은 사람이 참여한 사람들에 포함되어 있다면 true를 반환한다.")
    void testIfPlayersNotContainResultNameReturnTrue() {
        // given
        Player player = new Player(new Name("홍동건"),new Position(0,0));
        List<Player> players = new ArrayList<>();
        players.add(player);

        Players players1 = new Players(players);

        // when
        boolean contain = players1.isContain("홍동건");

        // then
        assertThat(contain).isTrue();
    }

    @Test
    @DisplayName("결과를 보고 싶은 사람이 참여한 사람들에 포함되어 있지 않다면 false를 반환한다.")
    void testIfPlayersNotContainResultNameReturnFalse() {
        // given
        Player player = new Player(new Name("김성혁"), new Position(0, 0));

        List<Player> players = new ArrayList<>();
        players.add(player);

        Players players1 = new Players(players);

        // when
        boolean contain = players1.isContain("채상엽");

        // then
        assertThat(contain).isFalse();
    }
}