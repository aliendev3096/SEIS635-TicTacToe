package tictactoe;

import java.util.Random;

public class Game {
    private Player playerX;
    private Player playerO;
    private Board board;
    private GameStatus status;
    private Player winner;

    private final Random rand = new Random();
    public boolean IsFinished() {
        return status == GameStatus.FINISHED;
    }

    public boolean IsStarted() {
        return status == GameStatus.STARTED;
    }

    public Game(Player playerX, Player playerO)
    {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new Board();
    }

    public void CheckWinner()
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

    public void DisplayBoard()
    {
        this.board.RenderBoard();
    }
    public void UpdateMove(String mark, int cell)
    {
        this.board.UpdateBoard(mark, cell);
    }

    public Player getWinner() {
        return this.winner;
    }
}
