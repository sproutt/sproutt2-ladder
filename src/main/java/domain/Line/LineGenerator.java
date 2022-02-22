package domain.Line;

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

    public static Point generateFirstPoint() {
        Point prePoint = new Point();
        return prePoint.first();
    }

    public static Point generateMiddlePoint(Point prePoint) {
        Point presentPoint = new Point();
        return presentPoint.next(prePoint);
    }

    public static Point generateLastPoint(Point prePoint) {
        Point lastPoint = new Point();
        return lastPoint.last(prePoint);
    }

    public static List<Point> generateSingleVerticalLine(List<Point> points) {
        points.add(generateFirstPoint());
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
