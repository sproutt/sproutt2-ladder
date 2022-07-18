import controller.LadderGame;
import model.Ladder;
import model.Participant;
import model.Winning;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        List<Participant> participants = InputView.inputParticipant();
        List<Winning> winnings = InputView.inputWinning();
        int height = InputView.inputLadderHeight();

        OutputView.outputResultMessage();
        Ladder ladder = ladderGame.generateLadder(height, participants.size());
    }
}