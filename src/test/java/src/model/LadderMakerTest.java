package src.model;

import org.junit.jupiter.api.Test;

import src.model.ladder.Ladder;
import src.model.ladder.LadderMaker;

class LadderMakerTest {
	@Test
	void makeLadderTest(){

		LadderMaker lm = new LadderMaker(5, 4);
		int [][] ladderShape = lm.makeLadder();

		Ladder ladder = new Ladder(ladderShape);
		StringBuilder stringBuilder = ladder.blueprintToLadderShape();
		System.out.println(stringBuilder.toString());
	}

}