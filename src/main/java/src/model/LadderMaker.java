package src.model;

import java.util.Random;

public class LadderMaker {
	private int height;
	private int playerNumber;

	public LadderMaker(int height, int playerNumber) {
		this.height = height;
		this.playerNumber = playerNumber;
	}

	public int[][] makeLadder() {
		int[][] ladderBlueprint = new int[height][(2 * playerNumber) - 1];

		for (int i = 0; i < ladderBlueprint.length; i++) {
			ladderBlueprint[i] = makeLine();
		}
		return ladderBlueprint;
	}
}