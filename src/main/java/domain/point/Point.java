package domain.point;

public class Point {
    private static final String CONTINUOUS_CONNECTION_BRIDGE_ERROR_MESSAGE = "[ERROR] 다리는 연속되어 존재할 수 없습니다.";

    private boolean left;
    private boolean right;
    private Direction direction;

    public Point(boolean left, boolean right) {
        validateContinuousConnectionBridge(left, right);
        this.left = left;
        this.right = right;
        this.direction = checkConnection();
    }

    public static Point onlyFirstExist() {
        return new Point(false, false);
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point next(Point prePoint, boolean right) {
        if (prePoint.right) {
            return new Point(prePoint.right, false);
        }
        return new Point(false, right);
    }

    public static Point last(Point prePoint) {
        return new Point(prePoint.right, false);
    }

    private void validateContinuousConnectionBridge(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(CONTINUOUS_CONNECTION_BRIDGE_ERROR_MESSAGE);
        }
    }

    public Direction checkConnection() {
        if (left & !right) {
            return Direction.LEFT;
        }
        if (right & !left) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public Direction getDirection() {
        return direction;
    }


}
