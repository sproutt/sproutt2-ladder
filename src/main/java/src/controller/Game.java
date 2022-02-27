package src.controller;

import java.util.List;
import java.util.Map;

import src.dto.LinesDto;
import src.dto.PlayersDto;
import src.dto.ResultAllDto;
import src.dto.ResultsDto;
import src.model.Referee;
import src.model.excutionResults.ExecutionResult;
import src.model.excutionResults.ExecutionResults;
import src.model.ladder.Ladder;
import src.model.ladder.LadderMaker;
import src.model.player.Player;
import src.model.player.Players;
import src.view.InputView;
import src.view.OutputView;

public class Game {

	private InputView inputView;
	private OutputView outputView;

	public Game() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		// inputPlayers , inputExecutionResults로 쪼개야 하는지는 조금 더 고민
		Players players = new Players();
		players.makePlayers(inputView.inputNames());

		ExecutionResults executionResults = new ExecutionResults();
		executionResults.makeExecutionResults(inputView.inputResults());

		// ladder 로직 Ladder.makeLadder(payers, executionResults);
		int ladderHeight = inputView.inputLadderHeight();
		LadderMaker lm = new LadderMaker(ladderHeight);
		Ladder ladder = lm.makeLadder(players.getPlayers().size());

		outputView.renderLadderResult(players.renderPlayers(), ladder.blueprintToLadderShape(),
				executionResults.renderResults());


		// 레프리 로직 넣고
		Referee referee = new Referee();
		referee.matchingResults(players, ladder);
		referee.makeResult(players, executionResults);

		askResult(players, referee);
	}

	private void askResult(Players players, Referee referee) {
		String specifyPlayer = inputView.inputSpecifyPlayer();
		if (specifyPlayer.equals("all")) {
			Map<Player, ExecutionResult> resultAll = referee.findAll();
			outputView.printAllResult(ResultAllDto.from(resultAll));
			return;
		}

		List<Player> specifyPlayers = players.findPlayer(specifyPlayer);
		List<ExecutionResult> executionResults = referee.find(specifyPlayers);
		outputView.printSingleResult(ResultsDto.from(executionResults));
	}
}
