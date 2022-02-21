package domain.Line;

import domain.point.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public List<Boolean> toBoolean() {
        return points.stream()
                .limit(points.size() - 1)
                .map(point -> point.isRight())
                .collect(Collectors.toList());
    }

    public void decideDirection() {
        for (Point point : points) {
            point.checkConnection();
        }
    }
}
