import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    private Ladder ladder;
    private Line line;

    public Ladder initLadder(int participant, int height) {
        List<Line> ladder = new ArrayList<>();

        this.line = initLine(participant);

        for (int h = 0; h < height; h++) {
            ladder.add(line);
        }

        return makeLadder(ladder);
    }

    public Line initLine(int participant) {
        List<Point> oneLine = new ArrayList<>();

        for (int p = 0; p < participant; p++) {
            oneLine.add(new Point(false));
        }

        return makeOneLine(oneLine);
    }

    private Ladder makeLadder(List<Line> lines) {
        return ladder = new Ladder(lines);
    }

    private Line makeOneLine(List<Point> points) {
        return line = new Line(points);
    }
}