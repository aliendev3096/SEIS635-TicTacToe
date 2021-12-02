package tictactoe;

import java.util.*;

public class main {
	private static Player playerX = new Player(PlayerType.X);
	private static Player playerO = new Player(PlayerType.O);
	private static ScoreBoard scoreBoard = new ScoreBoard(playerX, playerO);
	private static Random rand = new Random();
	private static Game currentGame;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe!");
		boolean startNewGame = true;

		playerX.promptName(in);
		playerO.promptName(in);

		currentGame = new Game(playerX, playerO);
		currentGame.promptMode(in);

		while(startNewGame) {
			currentGame = new Game(playerX, playerO);
			int turnOrder = rand.nextInt(2);

			var isTurnX = false;
			currentGame.setGameStatus(GameStatus.STARTED);
			while (!currentGame.isFinished()) {
				if(currentGame.isStarted())
				{
					isTurnX = turnOrder == 0;
					var mark = isTurnX ? "X" : "O";
					var cell = isTurnX ? currentGame.makePlayerXMove(in) : currentGame.makePlayerOMove(in);

					currentGame.updateMove(mark, cell);
					currentGame.setGameStatus(GameStatus.INPROGRESS);
				}
				else {
					if (isTurnX) {
						var cell = currentGame.makePlayerXMove(in);
						currentGame.updateMove("X", cell);
					} else {
						var cell = currentGame.makePlayerOMove(in);
						currentGame.updateMove("O", cell);
					}
				}
				isTurnX = !isTurnX;

				currentGame.displayBoard();
				currentGame.checkWinner();
				//todo: Check for Ties
				if(currentGame.isFinished())
				{
					String winnerName = currentGame.getWinner().getName();
					if(winnerName == playerX.getName())
					{
						AwardWinner(in, playerX, playerO);
					}
					else if(winnerName == playerO.getName())
					{
						AwardWinner(in, playerO, playerX);
					}

					scoreBoard.updateStreak(winnerName);
				}

				scoreBoard.displayPlayers();
				scoreBoard.display();
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
