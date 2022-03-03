package common;

import domain.gameresult.GameResult;
import domain.gameresult.GameResults;
import domain.player.Player;
import domain.player.Players;

import java.util.HashMap;
import java.util.Map;

public class PlayerGameResult {
    public static Map<String, String> match(Players players, GameResults gameResults) {
        Map<String, String> result = new HashMap<>();
        for (Player player : players.getPlayers()) {
            String gameResultName = gameResults.getGameResults().stream()
                    .filter(gameResult -> gameResult.getPosition().equals(player.getPosition()))
                    .map(GameResult::getName).findFirst().get();
            result.put(player.getName(), gameResultName);
        }
        return result;
    }
}
