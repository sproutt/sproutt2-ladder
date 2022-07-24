import controller.LadderGame;
import model.Info;
import model.Ladder;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        List<Info> players = InputView.inputPlayer();
        List<Info> winnings = InputView.inputWinning();
        int height = InputView.inputLadderHeight();

        OutputView.outputResultMessage();
        Ladder ladder = ladderGame.generateLadder(height, players.size());
    }
}