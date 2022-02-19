package domain;

public class Point {
    private static final String DUPLICATED_LINE_ERROR_MESSAGE = "[ERROR] 다리는 연속되어 존재할 수 없습니다.";

    private boolean left;
    private boolean right;

    public Point() {
    }

    public Point(boolean left, boolean right) {
        validateDuplicatedLine(left, right);
        this.left = left;
        this.right = right;
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

    public boolean getRight() {
        return right;
    }
}
