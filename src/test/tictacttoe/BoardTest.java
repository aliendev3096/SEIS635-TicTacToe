package test.tictacttoe;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.Board;
import tictactoe.Player;
import tictactoe.PlayerMode;
import tictactoe.PlayerType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardTest {
    private Board board;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream outStream = System.out;
    private final InputStream sysInBackup = System.in;
    private  ByteArrayInputStream in;


    public BoardTest()
    {
        this.board = new Board();
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
    public void UpdateBoard_Test()
    {
        String[] initialState = new String[] { null, null, null, null, null, null, null, null, null };
        String[] expectedState = new String[] { "X", null, null, null, null, null, null, null, null };

        board.setState(initialState);

        board.updateBoard("X", 1);

        String[] result = board.getState();

        Assert.assertArrayEquals(result, expectedState);
    }

    @Test
    public void GetEmptyCells_Test()
    {
        String[] initialState = new String[] { "X", "O", "X", "X", null, null, null, null, null };

        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);

        board.setState(initialState);

        ArrayList<Integer> result = board.getEmptyCells();

        Assert.assertArrayEquals(result.toArray(), expected.toArray());
    }
}