package src.model.ladder;

import java.util.Random;

import src.model.ladder.Height;

public class LadderMaker {
	private Height height;
	private int playerNumber;

	public LadderMaker(int height, int playerNumber) {
		this.height = new Height(height);
		this.playerNumber = playerNumber;
	}

	public int[][] makeLadder() {
		int[][] ladderBlueprint = new int[height.getHeight()][(2 * playerNumber) - 1];

		for (int i = 0; i < ladderBlueprint.length; i++) {
			ladderBlueprint[i] = makeLine();
		}
		return ladderBlueprint;
	}

	private int [] makeLine() {

		int[] line = new int[2 * playerNumber - 1];
		for (int i = 0; i < line.length; i++) {
			line[i] = -1;
			makeBridge(line, i);
		}
		return line;
	}

	private void makeBridge(int[] line, int i) {
		Random random = new Random();
		if (i == 1) {
			line[i] = random.nextInt(2);
		}
		if (i > 1 && i % 2 == 1 && line[i - 2] == 1) {
			line[i] = 0;
		}
		if (i > 1 && i % 2 == 1 && line[i - 2] == 0) {
			line[i] = random.nextInt(2);
		}
	}

}