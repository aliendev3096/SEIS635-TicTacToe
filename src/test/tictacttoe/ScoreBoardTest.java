package test.tictacttoe;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import tictactoe.Player;
import tictactoe.PlayerType;
import tictactoe.ScoreBoard;

public class ScoreBoardTest {

    private Player x;
    private Player o;
    private ScoreBoard scoreBoard;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream outStream = System.out;
    private final PrintStream errStream = System.err;

    public ScoreBoardTest()
    {
        this.x = new Player(PlayerType.X);
        this.o = new Player(PlayerType.O);
        this.scoreBoard = new ScoreBoard(x, o);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(outStream);
        System.setErr(errStream);
    }

    @Test
    public void Display_WithoutStreakHolder_Test()
    {
        this.x.setName("TestUserX");
        this.x.setWins(1);
        this.x.setLoss(1);
        this.x.setTies(1);

        this.o.setName("TestUserO");
        this.o.setWins(1);
        this.o.setLoss(1);
        this.o.setTies(1);

        this.scoreBoard.display();

        String expectedOutput = "TestUserX's Record: 1-1-1\nTestUserO's Record: 1-1-1\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void Display_WithStreakHolder_Test()
    {
        this.x.setName("TestUserX");
        this.x.setWins(1);
        this.x.setLoss(1);
        this.x.setTies(1);

        this.o.setName("TestUserO");
        this.o.setWins(1);
        this.o.setLoss(1);
        this.o.setTies(1);

        // Set Streak Holder and Streak Count
        this.scoreBoard.updateStreak("TestUser");

        // Set Output Stream
        this.scoreBoard.display();

        String expectedOutput = "TestUserX's Record: 1-1-1\nTestUserO's Record: 1-1-1\nStreak Holder: TestUser\nStreak Count: 1\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void UpdateStreak_ExistingStreakHolder_Test()
    {
        String testPlayer = "UserOne";
        // Set Initial Streak
        this.scoreBoard.updateStreak(testPlayer);

        // Increase Streak
        this.scoreBoard.updateStreak(testPlayer);

        // Assert streak holder and count
        String holder = this.scoreBoard.getStreakHolder();
        int count = this.scoreBoard.getStreakCount();

        Assert.assertEquals(count, 2);
        Assert.assertEquals(holder, testPlayer);
    }

    @Test
    public void UpdateStreak_NewStreakHolderFromEmptyStreak_Test()
    {
        String testPlayer = "UserOne";

        // Create New Streak
        this.scoreBoard.updateStreak(testPlayer);

        // Assert streak holder and count
        String holder = this.scoreBoard.getStreakHolder();
        int count = this.scoreBoard.getStreakCount();

        Assert.assertEquals(count, 1);
        Assert.assertEquals(holder, testPlayer);
    }

    @Test
    public void UpdateStreak_NewStreakHolderFromExistingStreak_Test()
    {
        String oldTestPlayer = "UserOne";
        String newTestPlayer = "UserTwo";

        // Set Initial Streak
        this.scoreBoard.updateStreak(oldTestPlayer);

        // Create New Streak
        this.scoreBoard.updateStreak(newTestPlayer);

        // Assert streak holder and count
        String holder = this.scoreBoard.getStreakHolder();
        int count = this.scoreBoard.getStreakCount();

        Assert.assertEquals(count, 1);
        Assert.assertEquals(holder, newTestPlayer);
    }
}