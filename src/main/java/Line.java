import java.util.ArrayList;
import java.util.List;

public class Line {
    private static List<Point> oneLine;

    public Line(List<Point> oneLine) {
        this.oneLine = new ArrayList<>(oneLine);
    }

    public int getLineSize() {
        return oneLine.size();
    }
}