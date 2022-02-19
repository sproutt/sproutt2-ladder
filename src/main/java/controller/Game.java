package controller;

import domain.Ladder;
import domain.Line;
import domain.Point;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private InputView inputView;
    private OutputView outputView;
    private List<Point> points;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        int playerCount = inputView.inputPlayerCount();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = generateLadder(playerCount, ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            outputView.printOneLine(ladder.getLines().get(i).toBoolean());
        }


    }

    public Line generateLine(int playerCount) {
        if (playerCount == 1) {
            Point onlyPoint = new Point();
            onlyPoint = onlyPoint.first();
            List<Point> points = new ArrayList<>();
            points.add(onlyPoint);
            return new Line(points);
        }
        Point prePoint = new Point();
        prePoint = prePoint.first();
        List<Point> points = new ArrayList<>();
        points.add(prePoint);

        Point presentPoint = new Point();
        for(int i = 0; i < playerCount - 2; i++) {
            presentPoint = new Point();
            presentPoint = presentPoint.next(prePoint);
            prePoint = presentPoint;
            points.add(presentPoint);
        }
        Point lastPoint = new Point();
        lastPoint = lastPoint.last(presentPoint);
        points.add(lastPoint);
        return new Line(points);
    }

    public Ladder generateLadder(int playerCount, int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(generateLine(playerCount));
        }
        return new Ladder(lines);
    }
}
