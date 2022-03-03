package src.dto;

import java.util.ArrayList;
import java.util.List;

import src.model.ladder.Ladder;
import src.model.ladder.Line;

public class LinesDto {
	private List<BridgesDto> lines;

	private LinesDto(List<src.dto.BridgesDto> bridgeValues) {
		this.lines = bridgeValues;
	}

	public static LinesDto from(Ladder ladder) {
		List<Line> lines = ladder.getLines();
		List<BridgesDto> lineDtos = new ArrayList<>();
		for (Line line : lines) {
			lineDtos.add(BridgesDto.from(line));
		}
		return new LinesDto(lineDtos);
	}

	public List<src.dto.BridgesDto> getLinesDto() {
		return lines;
	}

}