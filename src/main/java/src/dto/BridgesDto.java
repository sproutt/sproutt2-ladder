package src.dto;

import java.util.List;
import java.util.stream.Collectors;

import src.model.ladder.Bridge;
import src.model.ladder.Line;

public class BridgesDto {
	private List<Integer> bridges;

	public BridgesDto(List<Integer> values) {
		this.bridges = values;
	}

	public static BridgesDto from(Line line) {
		List<Integer> values = line.getLine().stream()
				.map(Bridge::getValue)
				.collect(Collectors.toList());
		return new BridgesDto(values);
	}

	public List<Integer> getBridges() {
		return bridges;
	}
}
