package src.model.player;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {
	private Players players;
	@BeforeEach
	void setUp(){
		players = new Players();
		String input = "p,s,v,m";
		String[] names = input.split(",");
		players.makePlayers(names);
	}


	@Test
	@DisplayName("이름 배열을 받아 플레이어가 제대로 생성되는지 테스트")
	void makePlayersWhenInputArray(){
		assertThat(players.getPlayers().get(0).getName()).isEqualTo("p");
	}

	@Test
	@DisplayName("이름을 받아서 players에 이름이 동일한 player 객체를 반환하는지 test")
	void returnPlayerWhenInputName(){
		String name = "s";
		List<Player> target = players.findPlayer(name);
		assertThat(target.get(0).getName()).isEqualTo(name);
	}
}