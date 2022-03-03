package src.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.model.player.Player;

public class PlayersDto {
	private List<String> names;

	private PlayersDto(List<String> names) {
		this.names = new ArrayList<>(names);
	}

	public static PlayersDto from(List<Player> players) {
		List<String> names = players.stream()
				.map(Player::getName)
				.collect(Collectors.toList());
		return new PlayersDto(names);
	}

	public List<String> getNames() {
		return names;
	}
}
