package test.tictacttoe;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.Player;
import tictactoe.PlayerMode;
import tictactoe.PlayerType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerTest {
    private Player player;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream outStream = System.out;
    private ByteArrayInputStream in;


    public PlayerTest()
    {
        this.player = new Player(PlayerType.X);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(outStream);
    }

    @Test
    public void MakeMove_Human_Test()
    {
        // Set Name and PlayerMode as Human
        player.setName("TestUser");
        player.setMode(PlayerMode.Human);

        // Mock Input Stream
        this.in = new ByteArrayInputStream("1".getBytes());

        // Set Empty Cells to select from
        ArrayList<Integer> emptyCells = new ArrayList<Integer>();
        emptyCells.add(1);

        // Make Move
        int cell = player.makeMove(new Scanner(this.in), emptyCells);

        // Assert
        Assert.assertEquals(cell, 1);
        String expectedOutput = "TestUser(X), select the cell you want to mark! (1-9)\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void MakeMove_Cpu_Test()
    {
        // Set PlayerMode as Cpu
        player.setMode(PlayerMode.Cpu);

        // Mock Input Stream
        this.in = new ByteArrayInputStream("1".getBytes());

        // Set Empty Cells to select from
        ArrayList<Integer> emptyCells = new ArrayList<Integer>();
        emptyCells.add(9);

        // Make Move
        int cell = player.makeMove(new Scanner(this.in), emptyCells);

        // Assert
        Assert.assertEquals(cell, 9);
    }

    @Test
    public void PromptName_Human_Test()
    {
        // Set PlayerMode as Cpu
        player.setMode(PlayerMode.Human);

        // Mock Input Stream
        this.in = new ByteArrayInputStream("TestUser".getBytes());

        // Prompt Name
        player.promptName(new Scanner(this.in));

        // Assert
        String expectedOutput = "Ready Player X? Please enter your name!\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}