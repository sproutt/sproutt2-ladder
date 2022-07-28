package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int NON_CONNECTION = 0;
    private static final int CONNECTION = 1;
    private static final int START_INDEX = 0;
    private static final int BOUND_NUMBER = 2;

    private List<Point> line;

    private boolean leftFlag, rightFlag;

    public Line(int player) {

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
            leftFlag = false;
            rightFlag = isVisited();
        }

        // DESC : 이후 인덱스부터 방문한 곳이라면
        if (rightFlag) {
            leftFlag = true;
            rightFlag = false;
        }

        // DESC : 이후 인덱스부터 방문하지 않은 곳이라면
        if (!rightFlag) {
            leftFlag = false;
            rightFlag = isVisited();
        }

        return new Direction(leftFlag, rightFlag, false);
    }

    private boolean isVisited() {
        Random random = new Random();
        int randomNumber = random.nextInt(BOUND_NUMBER);
        if (randomNumber == NON_CONNECTION) {
            return false;
        } else if (randomNumber == CONNECTION) {
            return true;
        }
        return false;
    }
}