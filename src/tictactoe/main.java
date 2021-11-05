package tictactoe;

public class main {
	private static Player playerX;
	private static Player playerO;
	private static Board board;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe!");
		playerX = new Player(PlayerType.X);
		playerO = new Player(PlayerType.O);
		board = new Board();
		board.RenderBoard();

		playerX.Prompt();
		playerO.Prompt();
	}
}
