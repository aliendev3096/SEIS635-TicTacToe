package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player playerX;
    private Player playerO;
    private Board board;
    private GameStatus status;
    private Player winner;
    private GameMode mode;

    private final Random rand = new Random();
    public boolean isFinished() {
        return status == GameStatus.FINISHED;
    }

    public boolean isStarted() {
        return status == GameStatus.STARTED;
    }

    public Game(Player playerX, Player playerO)
    {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new Board();
    }

    public void checkWinner()
    {
        if(board.CheckWinnerX())
        {
            this.winner = playerX;
            this.status = GameStatus.FINISHED;
        }
        else if(board.CheckWinnerO())
        {
            this.winner = playerO;
            this.status = GameStatus.FINISHED;
        }
    }

    public void displayBoard()
    {
        this.board.RenderBoard();
    }
    public void updateMove(String mark, int cell)
    {
        this.board.UpdateBoard(mark, cell);
    }
    public void setGameStatus(GameStatus status)
    {
        this.status = status;
    }
    public void promptMode(Scanner inputStream)
    {
        System.out.println("Select Game Mode: \n");
        System.out.println("1: Player vs Player \n");
        System.out.println("2: Player vs CPU \n");

        String modeInput = inputStream.nextLine();

        if(modeInput.equals("1"))
        {
            this.mode = GameMode.PvP;
        }

        if(modeInput.equals("2"))
        {
            this.mode = GameMode.PvC;
            this.playerO.setName("CPU");
            this.playerO.setMode(PlayerMode.Cpu);
        }
    }
    public Player getWinner() {
        return this.winner;
    }
    public int makePlayerXMove(Scanner in) {
        return this.playerX.makeMove(in, this.board.getEmptyCells());
    }

    public int makePlayerOMove(Scanner in) {
        return this.playerO.makeMove(in, this.board.getEmptyCells());
    }
}
