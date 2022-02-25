package src.model.ladder;

import java.util.List;

public class Ladder {
	private List<Line> lines;

	public Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public List<Line> getLines() {
		return lines;
	}

	public int getSize(){
		return lines.size();
	}

	public Line getLine(int yIndex){
		return lines.get(yIndex);
	}
}
