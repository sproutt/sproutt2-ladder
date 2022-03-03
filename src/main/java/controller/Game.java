package controller;

import common.PlayerGameResult;
import domain.gameresult.GameResultFactory;
import domain.gameresult.GameResultName;
import domain.gameresult.GameResults;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.player.Name;
import domain.player.Players;
import domain.player.PlayersFactory;
import exception.HeightValueException;
import exception.NameFormatException;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private InputView inputView;
    private OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        Players players = PlayersFactory.from(inputPlayer());
        List<GameResultName> gameResultNames = inputGameResultNames();
        Height ladderHeight = new Height(inputHeight());
        GameResults gameResults = GameResultFactory.from(gameResultNames, ladderHeight.getHeight());

        Ladder ladder = LadderGenerator.generate(ladderHeight.getHeight(), players.size());
        players.moveAll(ladder.getLines());

        Map<String, String> matchedGameResult = PlayerGameResult.match(players, gameResults);

        outputView.printPlayers(players.toPlayerNames());
        for (int i = 0; i < ladderHeight.getHeight(); i++) {
            outputView.printOneLine(ladder.getLines().get(i).toBoolean());
        }
        outputView.printGameResultNames(gameResults.toGameResultNames());

        printMatchedGameResult(players, matchedGameResult);
    }

    private void printMatchedGameResult(Players players, Map<String, String> matchedGameResult) {
        String playerName = inputPlayerName();
        if (players.isContain(playerName)) {
            outputView.printMatchedGameResult(matchedGameResult, playerName);
            printMatchedGameResult(players, matchedGameResult);
        }
        if (playerName.equals("all")) {
            outputView.printMatchedGameResults(matchedGameResult);
        }
    }

    public List<Name> inputPlayer() {
        List<Name> playerNames = new ArrayList<>();
        try {
            playerNames = inputView.inputPlayer().stream().map(playerName -> new Name(playerName)).collect(Collectors.toList());
        } catch (NameFormatException nameFormatException) {
            System.out.println(nameFormatException.getMessage());
            inputPlayer();
        }
        return playerNames;
    }

    public List<GameResultName> inputGameResultNames() {
        List<GameResultName> gameResultNames = new ArrayList<>();
        try {
            gameResultNames = inputView.inputGameResult().stream().map(gameResultName -> new GameResultName(gameResultName)).collect(Collectors.toList());
        } catch (NameFormatException nameFormatException) {
            System.out.println(nameFormatException.getMessage());
            inputGameResultNames();
        }
        return gameResultNames;
    }

    public int inputHeight() {
        int height = 0;
        try {
            height = inputView.inputLadderHeight();
        } catch (HeightValueException heightValueException) {
            System.out.println(heightValueException.getMessage());
            inputHeight();
        }
        return height;
    }

    public String inputPlayerName() {
        String playerName = "";
        try {
            playerName = inputView.inputPlayerName();
        } catch (NameFormatException nameFormatException) {
            System.out.println(nameFormatException.getMessage());
            inputPlayerName();
        }
        return playerName;
    }
}