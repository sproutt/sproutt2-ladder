package domain.gameresult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {
    private List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = new ArrayList<>(gameResults);
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    public List<String> toGameResultNames() {
        return gameResults.stream()
                .map(gameResult -> gameResult.getName())
                .collect(Collectors.toList());
    }
}
