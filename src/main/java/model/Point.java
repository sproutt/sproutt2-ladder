package model;

public class Point {
    private boolean isConnection;

    public Point(boolean isConnection) {
        this.isConnection = isConnection;
    }

    public boolean getConnection() {
        return isConnection;
    }
}