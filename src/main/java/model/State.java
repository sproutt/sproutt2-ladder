package model;

public class State {
    private Position position;
    private boolean xFlag;
    private Point point;
    private Direction direction;
    private int x, y;

    public State(Position position, boolean xFlag) {
        this.position = position;
        this.xFlag = xFlag;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isxFlag() {
        return xFlag;
    }

    public State changeState(Ladder ladder, State state) {
        x = state.position.getX();
        y = state.position.getY();

        point = ladder.getLines()
                .get(y)
                .getPoints()
                .get(x);
        direction = point.getDirection();

        // DESC: left, right 갈 곳이 없다 -> Y축으로 이동한다.
        if (!direction.isLeftFlag() && !direction.isRightFlag()) {
            position.moveYAxis(position.getY() + 1);
            point = ladder.getLines()
                    .get(position.getY())
                    .getPoints()
                    .get(position.getX());
            state.moveYAxis();

            return state;
        }

        // DESC: 좌우 이동했다면, Y축 이동한다.
        if (state.movedXAxis()) {
            position.moveYAxis(position.getY() + 1);
            point = ladder.getLines()
                    .get(position.getY())
                    .getPoints()
                    .get(position.getX());
            state.moveYAxis();

            return state;
        }

        // DESC: 오른쪽 깃발 있으면 -> 오른쪽으로 이동
        if (direction.isRightFlag()) {
            position.moveXAxis(position.getX() + 1);
            point = ladder.getLines()
                    .get(position.getY())
                    .getPoints()
                    .get(position.getX());
            state.moveXAxis();

            return state;
        }

        // DESC: 왼쪽 깃발 있으면 -> 왼쪽으로 이동
        if (direction.isLeftFlag()) {
            position.moveXAxis(position.getX() - 1);
            point = ladder.getLines()
                    .get(position.getY())
                    .getPoints()
                    .get(position.getX());
            state.moveXAxis();

            return state;
        }
        return state;
    }

    private boolean movedXAxis() {
        return xFlag;
    }

    private void moveXAxis() {
        this.xFlag = true;
    }

    private void moveYAxis() {
        this.xFlag = false;
    }
}