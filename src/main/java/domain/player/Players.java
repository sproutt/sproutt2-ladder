package domain.player;

import domain.line.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<String> toPlayerNames() {
        return players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }

    public void moveAll(List<Line> lines) {
        lines.forEach(this::moveOneLine);
    }

    public boolean isContain(String playerName) {
        if(!toPlayerNames().contains(playerName)) {
            return false;
        }
        return true;
    }
}
