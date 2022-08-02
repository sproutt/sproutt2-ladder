package model;

public class Direction {
    private boolean leftFlag;
    private boolean rightFlag;

    public Direction(boolean leftFlag, boolean rightFlag) {
        this.leftFlag = leftFlag;
        this.rightFlag = rightFlag;
    }

    public boolean isLeftFlag() {
        return leftFlag;
    }

    public boolean isRightFlag() {
        return rightFlag;
    }
}