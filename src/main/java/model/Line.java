package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int CONNECTION = 1;
    private static final int START_INDEX = 0;
    private static final int BOUND_NUMBER = 2;
    private int playerSize;

    private List<Point> line;

    public Line(int player) {
        playerSize = player;

        line = new ArrayList<>();

        makeLine(player, line);
    }

    public List<Point> getPoints() {
        return line;
    }

    private void makeLine(int player, List<Point> line) {
        for (int i = 0; i < player; i++) {
            line.add(new Point(makeDirection(i)));
        }
    }

    private Direction makeDirection(int index) {

        if (index == START_INDEX) {
            return new Direction(false, isVisited());
        }

        boolean beforeConnection = (line.get(index - 1)).getDirection().isRightFlag();

        if (beforeConnection) {
            return new Direction(true, false);
        }

        if (index == playerSize - 1) {
            return new Direction(false, false);
        }

        return new Direction(false, isVisited());
    }

    private boolean isVisited() {
        Random random = new Random();
        int randomNumber = random.nextInt(BOUND_NUMBER);
        if (randomNumber == CONNECTION) {
            return true;
        }
        return false;
    }
}