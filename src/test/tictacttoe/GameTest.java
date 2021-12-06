package test.tictacttoe;

import org.junit.*;

import tictactoe.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class GameTest {
    private Player x;
    private Player o;
    private Game game;
    private ByteArrayInputStream in;

    public GameTest()
    {
        this.x = new Player(PlayerType.X);
        this.x.setName("Test");
        this.o = new Player(PlayerType.O);
        this.o.setName("Test");
    }

    @Test
    public void GameStatus_Test()
    {
        this.game = new Game(this.x, this.o);

        this.game.setGameStatus(GameStatus.STARTED);

        GameStatus startedStatus = this.game.getStatus();

        Assert.assertEquals(startedStatus, GameStatus.STARTED);

        this.game.setGameStatus(GameStatus.INPROGRESS);

        GameStatus progressStatus = this.game.getStatus();

        Assert.assertEquals(progressStatus, GameStatus.INPROGRESS);

        this.game.setGameStatus(GameStatus.FINISHED);

        GameStatus finishedStatus = this.game.getStatus();

        Assert.assertEquals(finishedStatus, GameStatus.FINISHED);
    }

    @Test
    public void CheckWinner_X_Test()
    {
        Board board = new Board();
        board.setState(new String[] { "X", "X", "X", null, null, null, null, null, null });

        this.game = new Game(this.x, this.o, board);

        this.game.checkWinner();

        Player winner = this.game.getWinner();
        GameStatus status = this.game.getStatus();

        Assert.assertEquals(winner.getName(), this.x.getName());
        Assert.assertEquals(status, GameStatus.FINISHED);
    }

    @Test
    public void CheckWinner_O_Test()
    {
        Board board = new Board();
        board.setState(new String[] { "O", "O", "O", null, null, null, null, null, null });

        this.game = new Game(this.x, this.o, board);

        this.game.checkWinner();

        Player winner = this.game.getWinner();
        GameStatus status = this.game.getStatus();

        Assert.assertEquals(winner.getName(), this.o.getName());
        Assert.assertEquals(status, GameStatus.FINISHED);
    }

    @Test
    public void PromptName_PvP_Test()
    {
        this.game = new Game(this.x, this.o);

        // Mock Input Stream
        this.in = new ByteArrayInputStream("1".getBytes());

        this.game.promptMode(new Scanner(this.in));

        GameMode mode = this.game.getMode();

        Assert.assertEquals(mode, GameMode.PvP);
    }

    @Test
    public void PromptName_PvC_Test()
    {
        this.game = new Game(this.x, this.o);

        // Mock Input Stream
        this.in = new ByteArrayInputStream("2".getBytes());

        this.game.promptMode(new Scanner(this.in));

        GameMode mode = this.game.getMode();

        Assert.assertEquals(mode, GameMode.PvC);
        Assert.assertEquals(this.o.getName(), "CPU");
        Assert.assertEquals(this.o.getMode(), PlayerMode.Cpu);
    }
}