package domain.gameresult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultFactoryTest {

    @Test
    @DisplayName("참여한 사람들의 수만큼 실행 결과 객체를 생성한다.")
    void testgeneratedGameResultsSize() {
        // given
        GameResultName name1 = new GameResultName("꽝");
        GameResultName name2 = new GameResultName("20");

        List<GameResultName> gameResultNames = new ArrayList<>();
        gameResultNames.add(name1);
        gameResultNames.add(name2);

        int ladderHeight = 5;

        // when
        GameResults gameResults = GameResultFactory.from(gameResultNames, ladderHeight);

        // then
        assertThat(gameResults.size()).isEqualTo(2);
    }
}