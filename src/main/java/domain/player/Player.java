package domain.player;

import domain.point.Direction;

public class Player {
    private Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
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

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}