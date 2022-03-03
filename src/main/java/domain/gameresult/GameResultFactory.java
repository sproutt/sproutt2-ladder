package domain.gameresult;

import domain.player.Position;

import java.util.ArrayList;
import java.util.List;

public class GameResultFactory {

    public static GameResults from(List<GameResultName> gameResultNames, int positionY) {
        List<GameResult> gameResults = new ArrayList<>();
        for (int i = 0; i < gameResultNames.size(); i++) {
            gameResults.add(new GameResult(gameResultNames.get(i), new Position(i, positionY)));
        }
        return new GameResults(gameResults);
    }
}