package domain.point;

public class Point {
    private static final String DUPLICATED_LINE_ERROR_MESSAGE = "[ERROR] 다리는 연속되어 존재할 수 없습니다.";

    private boolean left;
    private boolean right;
    private Direction direction;

    public Point(boolean left, boolean right) {
        validateDuplicatedLine(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point onlyFirstExist() {
        return new Point(false, false);
    }

    public Point first() {
        return new Point(false, RandomPointGenerator.generate());
    }

    public Point next(Point prePoint) {
        if (prePoint.right) {
            return new Point(prePoint.right, false);
        }
        return new Point(false, RandomPointGenerator.generate());
    }

    public Point last(Point prePoint) {
        return new Point(prePoint.right, false);
    }

    private void validateDuplicatedLine(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(DUPLICATED_LINE_ERROR_MESSAGE);
        }
    }

    public void checkConnection() {
        if (left) {
            direction = Direction.LEFT;
            return;
        }
        if (right) {
            direction = Direction.RIGHT;
            return;
        }
        direction = Direction.DOWN;
    }

    public boolean isRight() {
        return right;
    }

    public Direction getDirection() {
        return direction;
    }
}
