package domain.gameresult;

import domain.player.Position;

public class GameResult {
    private GameResultName name;
    private Position position;

    public GameResult(String name, Position position) {
        this.name = new GameResultName(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
