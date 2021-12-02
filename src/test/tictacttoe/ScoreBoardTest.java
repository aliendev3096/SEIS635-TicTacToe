package test.tictacttoe;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.Player;
import tictactoe.PlayerType;
import tictactoe.ScoreBoard;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    public ScoreBoardTest()
    {
        Player x = new Player(PlayerType.X);
        Player o = new Player(PlayerType.O);
        this.scoreBoard = new ScoreBoard(x, o);
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