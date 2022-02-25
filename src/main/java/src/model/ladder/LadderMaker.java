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

	public Ladder makeLadder(int playerNumber) {
		List<Line> lines = new ArrayList<>();

		for (int i = 0; i < height.getHeight(); i++) {
			lines.add(makeLine(playerNumber));
		}
		return ladderBlueprint;
	}

	private Line makeLine(int playerNumber) {
		List<Bridge> bridges = new ArrayList<>();
		for (int i = 0; i < (2 * playerNumber) - 1; i++) {
			makeBridge(bridges, i);
		}
		return new Line(bridges);
	}

	private void makeBridge(int[] line, int i) {
		Random random = new Random();
		if (i == 1) {
			bridges.add(new Bridge(random.nextInt(2)));
		}
		if (i > 1 && i % 2 == 1 && line[i - 2] == 1) {
			line[i] = 0;
		}
		if (i > 1 && i % 2 == 1 && line[i - 2] == 0) {
			line[i] = random.nextInt(2);
		}
	}

}