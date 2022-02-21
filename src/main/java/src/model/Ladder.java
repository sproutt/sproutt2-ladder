package src.model;

public class Ladder {
	int[][] ladderBlueprint;

	public Ladder(int[][] ladderBlueprint) {
		this.ladderBlueprint = ladderBlueprint;
	}

	public StringBuilder blueprintToLadderShape() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ladderBlueprint.length; i++) {
			sb.append(" ");
			innerLadderRenderer(i, sb);
		}
		return sb;
	}

	private void innerLadderRenderer(int i, StringBuilder sb) {
		for (int j = 0; j < ladderBlueprint[i].length; j++) {
			if (j % 2 == 0 && ladderBlueprint[i][j] == 0) {
				sb.append("|");
			}
			if (j >= 1 && (j % 2) == 1 && ladderBlueprint[i][j] == 0) {
				sb.append("     ");
			}
			if (j >= 1 && (j % 2) == 1 && ladderBlueprint[i][j] == 1) {
				sb.append("-----");
			}
		}
		sb.append("\n");
	}
}
