package test.tictacttoe;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.Player;
import tictactoe.PlayerType;
import tictactoe.ScoreBoard;

public class PlayerTest {
    private ScoreBoard scoreBoard;

    public PlayerTest()
    {
        Player x = new Player(PlayerType.X);
        Player o = new Player(PlayerType.O);
        this.scoreBoard = new ScoreBoard(x, o);
    }

}