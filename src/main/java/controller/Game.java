package controller;

import domain.Ladder;
import domain.LadderGenerator;
import view.InputView;
import view.OutputView;

public class Game {
    private InputView inputView;
    private OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        int playerCount = inputView.inputPlayerCount();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = LadderGenerator.generate(ladderHeight, playerCount);

        for (int i = 0; i < ladderHeight; i++) {
            outputView.printOneLine(ladder.getLines().get(i).toBoolean());
        }


    }
}
