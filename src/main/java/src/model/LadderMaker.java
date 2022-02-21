package src.model;

import java.util.Random;

public class LadderMaker {
	private int height;
	private int playerNumber;
	public LadderMaker(int height, int playerNumber) {
		this.height = height;
		this.playerNumber = playerNumber;
	}

	public int[][] makeLadder(){
		int[][] ladderBlueprint = new int[height][(2*playerNumber)-1];
		Random random = new Random();

		for (int i = 0; i < ladderBlueprint.length; i++) {
			for (int j = 0; j < ladderBlueprint[i].length; j++) {
				ladderBlueprint[i][j] = 0;
				if (j == 1) {
					ladderBlueprint[i][j] = random.nextInt(2);
				}
				if (j>1 && j%2 == 1 && ladderBlueprint[i][j-2] == 1) {
					ladderBlueprint[i][j] = 0;
				}
				if (j>1 && j%2 == 1 && ladderBlueprint[i][j-2] == 0) {
					ladderBlueprint[i][j] = random.nextInt(2);
				}
			}
		}
		return ladderBlueprint;
	}
}