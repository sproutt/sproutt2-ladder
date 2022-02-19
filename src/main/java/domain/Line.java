package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
