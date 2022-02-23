package domain.line;

import domain.point.Point;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    public static Line generate(int playerCount) {
        List<Point> points = new ArrayList<>();
        if (playerCount == 1) {
            return new Line(generateSingleVerticalLine(points));
        }

        return new Line(generateMultiVerticalLine(points, playerCount));
    }

    public static Point generateOnlyFirstExist() {
        return Point.onlyFirstExist();
    }

    public static Point generateFirstPoint() {
        return Point.first();
    }

    public static Point generateMiddlePoint(Point prePoint) {
        return Point.next(prePoint);
    }

    public static Point generateLastPoint(Point prePoint) {
        return Point.last(prePoint);
    }

    public static List<Point> generateSingleVerticalLine(List<Point> points) {
        points.add(generateOnlyFirstExist());
        return points;
    }

    public static List<Point> generateMultiVerticalLine(List<Point> points, int playerCount) {
        points.add(generateFirstPoint());
        for (int i = 0; i < playerCount - 2; i++) {
            points.add(generateMiddlePoint(points.get(i)));
        }
        points.add(generateLastPoint(points.get(points.size() - 1)));
        return points;
    }
}
