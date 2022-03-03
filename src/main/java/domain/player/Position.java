package domain.player;

import java.util.Objects;

public class Position {
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] Position의 x, y 값은 양수입니다.";
    private int x;
    private int y;

    public Position(int x, int y) {
        validateNegative(x, y);
        this.x = x;
        this.y = y;
    }

    public void validateNegative(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getX() == position.getX() && getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
