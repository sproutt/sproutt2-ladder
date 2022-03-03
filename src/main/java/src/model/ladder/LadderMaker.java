package src.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
	private Height height;

	public LadderMaker(int height) {
		this.height = new Height(height);
	}

	public Ladder makeLadder(int playerNumber) {
		List<Line> lines = new ArrayList<>();

		for (int i = 0; i < height.getHeight(); i++) {
			lines.add(makeLine(playerNumber));
		}
		return new Ladder(lines);
	}

	private Line makeLine(int playerNumber) {
		List<Bridge> bridges = new ArrayList<>();
		for (int i = 0; i < (2 * playerNumber) - 1; i++) {
			makeBridge(bridges, i);
		}
		return new Line(bridges);
	}

	private void makeBridge(List<Bridge> bridges, int i) {
		Random random = new Random();
		if (i % 2 == 0) {
			bridges.add(new Bridge(-1));
		}
		if (i == 1) {
			bridges.add(new Bridge(random.nextInt(2)));
		}
		if (i > 1 && i % 2 == 1 && bridges.get(i - 2).getValue() == 1) {
			bridges.add(new Bridge(0));
		}
		if (i > 1 && i % 2 == 1 && bridges.get(i - 2).getValue() == 0) {
			bridges.add(new Bridge(random.nextInt(2)));
		}
	}

}