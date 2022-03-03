package src.model.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderMakerTest {
	private LadderMaker ladderMaker;
	private Ladder ladder;
	private int height = 5;
	private int numberOfPlayers = 4;
	private final int numberOfBridge = numberOfPlayers - 1;

	@BeforeEach
	void setUp() {
		ladderMaker = new LadderMaker(height);
		ladder = ladderMaker.makeLadder(numberOfPlayers);
	}
	@Test
	@DisplayName("사다리가 세로의 길이가 입력한 숫자 만큼 만들어 졌는지 테스트")
	void 사다리_크기_정보가_적절한지_테스트(){

		Assertions.assertThat(ladder.getLines().size()).isEqualTo(5);
	}

	@Test
	@DisplayName("사다리 가로의 길이가 적합한지 테스트")
	void 사다리_가로_크기가_적절한지_테스트(){
		Assertions.assertThat(ladder.getLines().get(0).getLine().size() - numberOfBridge).isEqualTo(numberOfPlayers);
	}
}