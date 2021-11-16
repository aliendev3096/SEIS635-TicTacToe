package tictactoe;

import org.junit.*;


public class PlayerTest {

    Player player;
    @Before
    public void init() {
        player = new Player(PlayerType.X);
    }

    @Test
    public void getNameTest() {
        // Arrange
        var expectedName = "PlayerOne";
        player.setName(expectedName);

        // Act
        var name = player.getName();
        // Assert
        Assert.assertEquals(name, expectedName);
    }

    @Test
    public void getWinsTest() {
        // Arrange
        player.setWins(11);

        // Act
        var wins = player.getWins();
        // Assert
        Assert.assertEquals(wins, 11);
    }

    @Test
    public void getLossTest() {
        // Arrange
        player.setLoss(11);

        // Act
        var loss = player.getLoss();
        // Assert
        Assert.assertEquals(loss, 11);
    }

    @Test
    public void getTiesTest() {
        // Arrange
        player.setTies(11);

        // Act
        var ties = player.getTies();
        // Assert
        Assert.assertEquals(ties, 11);
    }
}