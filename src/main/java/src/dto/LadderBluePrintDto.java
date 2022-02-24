package src.dto;

import src.model.ladder.Ladder;

public class LadderBluePrintDto {
	public int [][] ladderBlueprint;

	public LadderBluePrintDto(Ladder ladder) {
		this.ladderBlueprint = ladder.getLadderBlueprint();
	}

	public int[][] getLadderBlueprint() {
		return ladderBlueprint;
	}

	public static LadderBluePrintDto from(Ladder ladder) {
		int[][] ladderBlueprint = ladder.getLadderBlueprint();
		return new LadderBluePrintDto(ladder);
	}
}
