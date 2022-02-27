package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersFactoryTest {

    @Test
    @DisplayName("참여한 사람들의 수만큼 Player 객체를 생성한다.")
    void testgeneratedPlayersSize() {
        // given
        Name 김성혁 = new Name("김성혁");
        Name 채상엽 = new Name("채상엽");

        List<Name> names = new ArrayList<>();
        names.add(김성혁);
        names.add(채상엽);

        // when
        Players players = PlayersFactory.from(names);

        // when
        assertThat(players.size()).isEqualTo(2);
    }
}