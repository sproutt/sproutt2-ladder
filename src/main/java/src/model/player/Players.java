package src.model.player;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private List<Player> players;

	public Players() {
		this.players = new ArrayList<>();
	}

	public void makePlayers(String[] inputValues) {
		for (String name : inputValues) {
			players.add(new Player(name));
		}
	}

	public List<Player> getPlayers() {
		return players;
	}
}
