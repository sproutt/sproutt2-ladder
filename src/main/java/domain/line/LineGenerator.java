package domain.line;

import domain.point.Point;
import domain.point.RandomPointGenerator;

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

    private static Point generateOnlyFirstExist() {
        return Point.onlyFirstExist();
    }

    private static Point generateFirstPoint() {
        return Point.first(RandomPointGenerator.generate());
    }

    private static Point generateMiddlePoint(Point prePoint) {
        return Point.next(prePoint, RandomPointGenerator.generate());
    }

    private static Point generateLastPoint(Point prePoint) {
        return Point.last(prePoint);
    }

    private static List<Point> generateSingleVerticalLine(List<Point> points) {
        points.add(generateOnlyFirstExist());
        return points;
    }

    private static List<Point> generateMultiVerticalLine(List<Point> points, int playerCount) {
        points.add(generateFirstPoint());
        for (int i = 0; i < playerCount - 2; i++) {
            points.add(generateMiddlePoint(points.get(i)));
        }
        points.add(generateLastPoint(points.get(points.size() - 1)));
        return points;
    }
}
