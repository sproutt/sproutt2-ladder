package controller;

import common.PlayerGameResult;
import domain.gameresult.GameResultFactory;
import domain.gameresult.GameResults;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.player.Players;
import domain.player.PlayersFactory;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Game {
    private InputView inputView;
    private OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        Players players = PlayersFactory.from(inputView.inputPlayer());
        List<String> gameResultNames = inputView.inputGameResult();
        int ladderHeight = inputView.inputLadderHeight();
        GameResults gameResults = GameResultFactory.from(gameResultNames, ladderHeight);

        Ladder ladder = LadderGenerator.generate(ladderHeight, players.size());
        players.moveAll(ladder.getLines());

        Map<String, String> matchedGameResult = PlayerGameResult.match(players, gameResults);

        outputView.printPlayers(players.toPlayerNames());
        for (int i = 0; i < ladderHeight; i++) {
            outputView.printOneLine(ladder.getLines().get(i).toBoolean());
        }


    }
}