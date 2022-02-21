package domain.player;

import java.util.ArrayList;
import java.util.List;

public class PlayersFactory {
    private static final int INITIAL_Y_POSITION = 0;

    public static Players from(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), new Position(i, INITIAL_Y_POSITION)));
        }
        return new Players(players);
    }
}
