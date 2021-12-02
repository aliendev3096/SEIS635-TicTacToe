package tictactoe;

import java.util.*;

public class main {
	private static Player playerX;
	private static Player playerO;
	private static ScoreBoard scoreBoard;
	private static Random rand = new Random();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe!");
		boolean startNewGame = true;

		while(startNewGame) {
			if(playerX == null) {
				playerX = new Player(PlayerType.X);
			}
			if(playerO == null) {
				playerO = new Player(PlayerType.O);
			}

			scoreBoard = new ScoreBoard(playerX, playerO);
			Game game = new Game(playerX, playerO);

			game.promptMode(in);

			playerX.promptName(in);
			playerO.promptName(in);
			int turnOrder = rand.nextInt(2);

			var isTurnX = false;
			game.setGameStatus(GameStatus.STARTED);
			while (!game.isFinished()) {
				if(game.isStarted())
				{
					isTurnX = turnOrder == 0;
					var mark = isTurnX ? "X" : "O";
					var cell = isTurnX ? game.makePlayerXMove(in) : game.makePlayerOMove(in);

					game.updateMove(mark, cell);
					game.setGameStatus(GameStatus.INPROGRESS);
				}
				else {
					if (isTurnX) {
						var cell = game.makePlayerXMove(in);
						game.updateMove("X", cell);
					} else {
						var cell = game.makePlayerOMove(in);
						game.updateMove("O", cell);
					}
				}
				isTurnX = !isTurnX;

				scoreBoard.DisplayPlayers();
				scoreBoard.Display();
				game.displayBoard();
				game.checkWinner();
				//todo: Check for Ties
				if(game.isFinished())
				{
					String winnerName = game.getWinner().getName();
					if(winnerName == playerX.getName())
					{
						AwardWinner(in, playerX, playerO);
					}
					else if(winnerName == playerO.getName())
					{
						AwardWinner(in, playerO, playerX);
					}
				}
			}


			startNewGame = PromptNewGame(in);
		}
	}

	private static void AwardWinner(Scanner inputStream, Player winner, Player loser)
	{
		System.out.println(String.format("WINNER! Congratulations %s!", winner.getName()));
		winner.setWins(winner.getWins() + 1);
		loser.setLoss(loser.getLoss() + 1);
	}


	private static boolean PromptNewGame(Scanner inputStream)
	{
		System.out.println("Player Another Game? (Y/N)");
		String response = inputStream.nextLine();

		return response.equals("Y") ? true : false;
	}
}
