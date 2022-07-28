package model;

public class Direction {
    private boolean leftFlag;
    private boolean rightFlag;
    private boolean downFlag;

    public Direction(boolean leftFlag, boolean rightFlag, boolean downFlag) {
        this.leftFlag = leftFlag;
        this.rightFlag = rightFlag;
        this.downFlag = downFlag;
    }

    public boolean isLeftFlag() {
        return leftFlag;
    }

    public boolean isRightFlag() {
        return rightFlag;
    }

    public boolean isDownFlag() {
        return downFlag;
    }
}