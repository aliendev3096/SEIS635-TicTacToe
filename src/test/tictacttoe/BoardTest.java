package test.tictacttoe;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.Board;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BoardTest {
    private Board board;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream outStream = System.out;

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

    @Test
    public void RenderBoard_Test()
    {
        String[] initialState = new String[] { "X", "O", "X", "X", null, null, null, null, null };

        board.setState(initialState);

        board.renderBoard();

        String expectedBoard = " X | O | X \n---|---|---\n X |   |   \n---|---|---\n   |   |   \n\n";

        Assert.assertEquals(expectedBoard, outContent.toString());
    }

    @Test
    public void CheckWinnerX_ColumnOne_Test()
    {
        String[] initialState = new String[] { "X", "O", "X", "X", null, null, "X", null, null };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_ColumnTwo_Test()
    {
        String[] initialState = new String[] { null, "X", "O", "O", "X", null, "O", "X", null };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_ColumnThree_Test()
    {
        String[] initialState = new String[] { null, "O", "X", "O", "X", "X", "O", "O", "X" };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_DiagonalOne_Test()
    {
        String[] initialState = new String[] { "X", "O", "O", "O", "X", null, "O", null, "X" };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_DiagonalTwo_Test()
    {
        String[] initialState = new String[] { "O", "O", "X", "O", "X", null, "X", null, "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_RowOne_Test()
    {
        String[] initialState = new String[] { "X", "X", "X", "O", "O", null, "X", null, "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_RowTwo_Test()
    {
        String[] initialState = new String[] { "O", "X", "O", "X", "X", "X", "X", null, "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerX_RowThree_Test()
    {
        String[] initialState = new String[] { "X", "O", "O", "X", "X", null, "X", "X", "X" };

        board.setState(initialState);

        boolean result = board.checkWinnerX();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_ColumnOne_Test()
    {
        String[] initialState = new String[] { "O", "X", "X", "O", null, null, "O", null, null };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_ColumnTwo_Test()
    {
        String[] initialState = new String[] { null, "O", "X", "X", "O", "X", "X", "O", null };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_ColumnThree_Test()
    {
        String[] initialState = new String[] { null, "X", "O", "X", "X", "O", "X", "X", "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_DiagonalOne_Test()
    {
        String[] initialState = new String[] { "O", "X", "X", "X", "O", null, "X", null, "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_DiagonalTwo_Test()
    {
        String[] initialState = new String[] { "X", "X", "O", "X", "O", null, "O", null, "X" };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_RowOne_Test()
    {
        String[] initialState = new String[] { "O", "O", "O", "X", "X", null, "X", null, "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_RowTwo_Test()
    {
        String[] initialState = new String[] { "O", "X", "O", "O", "O", "O", "X", null, "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }

    @Test
    public void CheckWinnerO_RowThree_Test()
    {
        String[] initialState = new String[] { "X", "O", "X", "X", "X", null, "O", "O", "O" };

        board.setState(initialState);

        boolean result = board.checkWinnerO();

        Assert.assertEquals(result, true);
    }
}