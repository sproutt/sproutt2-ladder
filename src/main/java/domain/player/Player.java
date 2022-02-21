package domain.player;

import domain.Line.Line;
import domain.point.Direction;

import java.util.List;

public class Player {
    private Name name;
    private Position position;

    public Player(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            position.moveLeft();
            position.moveDown();
        }
        if (direction == Direction.RIGHT) {
            position.moveRight();
            position.moveDown();
        }
        if (direction == Direction.DOWN) {
            position.moveDown();
        }
    }

    public void moveOneLine(Line line) {
        int x = position.getX();
        move(line.getPoints().get(x).getDirection());
    }

    public void moveAll(List<Line> lines) {
        for (int i = 0; i < lines.size(); i++) {
            moveOneLine(lines.get(i));
        }
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}