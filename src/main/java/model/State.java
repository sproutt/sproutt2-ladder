package model;

public class State {
    private Position position;
    private boolean xFlag;

    public State(Position position, boolean xFlag) {
        this.position = position;
        this.xFlag = xFlag;
    }

    public Position getPosition() {
        return position;
    }

    public boolean movedXAxis() {
        return xFlag;
    }

    public void moveXAxis() {
        this.xFlag = true;
    }

    public void moveYAxis() {
        this.xFlag = false;
    }
}