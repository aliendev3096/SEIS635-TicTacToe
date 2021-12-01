package tictactoe;

import java.util.*;

public class main {
	private static Player playerX;
	private static Player playerO;
	private static Board board;
	private static Random rand = new Random();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe!");
		boolean startNewGame = true;
		playerX = new Player(PlayerType.X);
		playerO = new Player(PlayerType.O);

		while(startNewGame) {
			board = new Board();
			board.RenderBoard();
			int turnOrder = rand.nextInt(2);

			PromptName(in, playerX);
			PromptName(in, playerO);

			var isTurnX = false;
			while (!board.IsFinished()) {
				if(board.IsStarted())
				{
					isTurnX = turnOrder == 0;
					var mark = isTurnX ? "X" : "O";
					var cell = isTurnX? playerX.MakeMove(in) : playerO.MakeMove(in);

					board.UpdateBoard(mark, cell);
					board.SetBoardStatus(BoardStatus.IN_PROGRESS);
				}
				else {
					if (isTurnX) {
						var cell = playerX.MakeMove(in);
						board.UpdateBoard("X", cell);
					} else {
						var cell = playerO.MakeMove(in);
						board.UpdateBoard("O", cell);
					}
				}
				isTurnX = !isTurnX;

				DisplayPlayers(in, playerX, playerO);
				board.RenderBoard();
				board.CheckWinner();
				if(board.IsFinished())
				{
					String winner = board.getWinner();
					if(winner == "X")
					{
						AwardWinner(in, playerX, playerO);
					}
					else if(winner == "O")
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
		System.out.println(String.format("WINNER! CONGRADULATIONS %s!", winner.getName()));
		winner.setWins(winner.getWins() + 1);
		loser.setLoss(loser.getLoss() + 1);
	}

	private static void DisplayPlayers(Scanner inputStream, Player playerX, Player playerO)
	{
		System.out.println(String.format("Tic Tac Toe: %s vs %s", playerX.getName(), playerO.getName()));
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
