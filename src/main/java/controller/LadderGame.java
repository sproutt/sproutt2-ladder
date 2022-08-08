package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static int ladderHeight;
    private static int gamePlayer;
    private Ladder ladder;
    private Point playerPoint;
    private Direction direction;
    private Position playerPosition;
    private State playerState;
    private int x, y;

    public LadderGame(List<StringInfo> players, List<StringInfo> winnings, Height height) {
        validatePlayerSizeAndWinningSizeIsSame(players, winnings);
        this.players = players;
        this.winnings = winnings;
        this.height = height;
    }

        ladder = new Ladder(lines);

        return ladder;
    }

    public void getGameResult(Ladder ladder) {

        for (int i = 0; i < players.size(); i++) {
            this.state = startMove(new State(new Position(i, 0), false));
            gameResult.put(players.get(i).getStringInfo(), winnings.get(state.getPosition().getX()).getStringInfo());
        }
    }

    private State startMove(State playerState) {
        while (!((playerState.getPosition().getY() == ladderHeight - 1) && playerState.movedXAxis()) && !((playerState.getPosition().getY() == ladderHeight - 1) && (!ladder.getLines().get(y).getPoints().get(x).getDirection().isLeftFlag() && !ladder.getLines().get(y).getPoints().get(x).getDirection().isRightFlag()))) {

            movePlayer(playerState);
        }
        return playerState;
    }

    private State movePlayer(State playerState) {
        x = playerState.getPosition().getX();
        y = playerState.getPosition().getY();

        playerPosition = playerState.getPosition();
        playerPoint = ladder.getLines().get(y).getPoints().get(x);
        direction = playerPoint.getDirection();

        // DESC: left, right 갈 곳이 없다 -> Y축 이동한다.
        if (!direction.isLeftFlag() && !direction.isRightFlag()) {
            playerPosition.moveYAxis(playerPosition.getY() + 1);
            playerPoint = ladder.getLines().get(playerPosition.getY()).getPoints().get(playerPosition.getX());
            playerState.moveYAxis();

            return playerState;
        }

        // DESC: 좌우 이동했다면, Y축 이동한다.
        if (playerState.movedXAxis()) {
            playerPosition.moveYAxis(playerPosition.getY() + 1);
            playerPoint = ladder. getLines().get(playerPosition.getY()).getPoints().get(playerPosition.getX());
            playerState.moveYAxis();

            return playerState;
        }

        // DESC: 오른쪽 깃발 있으면 -> 오른쪽으로 이동
        if (direction.isRightFlag()) {
            playerPosition.moveXAxis(playerPosition.getX() + 1);
            playerPoint = ladder.getLines().get(playerPosition.getY()).getPoints().get(playerPosition.getX());
            playerState.moveXAxis();

            return playerState;
        }

        // DESC: 왼쪽 깃발 있으면 -> 왼쪽으로 이동
        if (direction.isLeftFlag()) {
            playerPosition.moveXAxis(playerPosition.getX() - 1);
            playerPoint = ladder.getLines().get(playerPosition.getY()).getPoints().get(playerPosition.getX());
            playerState.moveXAxis();

            return playerState;
        }

    public Map<String, String> getGameResult() {
        return gameResult;
    }
}