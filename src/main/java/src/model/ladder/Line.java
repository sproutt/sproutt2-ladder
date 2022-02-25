package src.model.ladder;

import java.util.List;

public class Line {
	private List<Bridge> line;

	public Line(List<Bridge> line) {
		this.line = line;
	}

	public Bridge getBridge(int index){
		return line.get(index);
	}

	public List<Bridge> getLine() {
		return line;
	}
}
