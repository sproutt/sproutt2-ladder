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

	public StringBuilder renderPlayers(){
		StringBuilder sb = new StringBuilder();
		for(Player player : players){
			String name = player.getName();
			if (name.length() <= 5){
				int blank = 5 - name.length() + 1;
				sb.append(name);
				appendBlank(blank, sb);
			}
		}
		return sb;
	}

	private void appendBlank(int blank, StringBuilder sb){
		for (int i = 0; i < blank; i++) {
			sb.append(" ");
		}
	}

	public List<Player> getPlayers() {
		return players;
	}
}
