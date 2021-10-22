package tictactoe;

public class main {
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe!");

		Board board = new Board();

		String boardOutput = board.RenderBoard();

		System.out.println(boardOutput);
	}
}
