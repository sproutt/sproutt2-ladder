package domain.gameresult;

import domain.player.Position;

public class GameResult {
    private GameResultName name;
    private Position position;

    public GameResult(GameResultName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
