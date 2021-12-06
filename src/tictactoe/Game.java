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
    private boolean isTie;

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

    public Game(Player playerX, Player playerO, Board board)
    {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = board;
    }

    public void checkWinner()
    {
        if(board.checkWinnerX())
        {
            this.winner = playerX;
            this.status = GameStatus.FINISHED;
            this.isTie = false;
        }
        else if(board.checkWinnerO())
        {
            this.winner = playerO;
            this.status = GameStatus.FINISHED;
            this.isTie = false;
        }
        else if(board.checkTie())
        {
            this.winner = null;
            this.status = GameStatus.FINISHED;
            this.isTie = true;
        }
    }

    public boolean isTie() {
        return isTie;
    }

    public GameMode getMode() {
        return mode;
    }

    public void displayBoard()
    {
        this.board.renderBoard();
    }
    public boolean updateMove(String mark, int cell)
    {
	return this.board.updateBoard(mark, cell);
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setGameStatus(GameStatus status)
    {
        this.status = status;
    }

    public void promptMode(Scanner inputStream)
        {
            System.out.println("Select Game Mode: \n");
            System.out.println("Player vs Player: Enter '1' else you will play the CPU \n");

            String modeInput = inputStream.nextLine();

            if(modeInput.equals("1"))
            {
                this.mode = GameMode.PvP;
            }

            else
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

