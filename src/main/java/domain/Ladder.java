package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
