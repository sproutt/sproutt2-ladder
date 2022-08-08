import controller.LadderGame;
import model.Height;
import model.Info;
import model.Ladder;
import model.StringInfo;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<StringInfo> players = InputView.inputPlayer();
        List<StringInfo> winnings = InputView.inputWinning();
        Height height = new Height(InputView.inputLadderHeight());

        LadderGame ladderGame = new LadderGame(players, winnings, height);

        Ladder ladder = ladderGame.initLadder();
        OutputView.printLadderResultMessage();
        OutputView.printStringLadder(ladder.generateStringLadder(ladder, players, winnings));
        ladderGame.startGame();

        OutputView.printGameResultMessage();
        OutputView.printGameResult(ladderGame.getGameResult(), InputView.inputResult());
    }
}