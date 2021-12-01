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
		playerX = new Player(PlayerType.X);
		playerO = new Player(PlayerType.O);

		PromptName(in, playerX);
		PromptName(in, playerO);
		scoreBoard = new ScoreBoard(playerX, playerO);

		while(startNewGame) {
			Game game = new Game(playerX, playerO);
			int turnOrder = rand.nextInt(2);

			var isTurnX = false;
			while (!game.IsFinished()) {
				if(game.IsStarted())
				{
					isTurnX = turnOrder == 0;
					var mark = isTurnX ? "X" : "O";
					var cell = isTurnX? playerX.MakeMove(in) : playerO.MakeMove(in);

					game.UpdateMove(mark, cell);
				}
				else {
					if (isTurnX) {
						var cell = playerX.MakeMove(in);
						game.UpdateMove("X", cell);
					} else {
						var cell = playerO.MakeMove(in);
						game.UpdateMove("O", cell);
					}
				}
				isTurnX = !isTurnX;

				scoreBoard.DisplayPlayers();
				scoreBoard.Display();
				game.DisplayBoard();
				game.CheckWinner();
				if(game.IsFinished())
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

	private static void PromptName(Scanner inputStream, Player player)
	{
		System.out.println(String.format("Ready Player %s? Please enter your name!", player.getType()));
		var name = inputStream.nextLine();
		player.setName(name);
	}

	private static boolean PromptNewGame(Scanner inputStream)
	{
		System.out.println("Player Another Game? (Y/N)");
		String response = inputStream.nextLine();

		return response == "Y" ? true : false;
	}
}
