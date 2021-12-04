package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private String[] state;

    public Board() {
        this.state = new String[] { null, null, null, null, null, null, null, null, null };
    }

    public boolean updateBoard(String mark, int cell)
    {
    	if(this.state[cell-1] != null)
		{
   			return false;
		}
    	this.state[cell-1] = mark;
    	return true;
    }


    public String[] getState() {
        return state;
    }

    public void setState(String[] state) {
        this.state = state;
    }

    public void renderBoard()
    {
        var board = buildBoard();
        System.out.println(board);
    }

    public boolean checkWinnerX()
    {
        if((this.state[0] == "X" && this.state[1] == "X" && this.state[2] == "X") ||
            (this.state[3] == "X" && this.state[4] == "X" && this.state[5] == "X") ||
            (this.state[6] == "X" && this.state[7] == "X" && this.state[8] == "X")
        )
        {
            return true;
        }

        if((this.state[0] == "X" && this.state[3] == "X" && this.state[6] == "X") ||
            (this.state[1] == "X" && this.state[4] == "X" && this.state[7] == "X") ||
            (this.state[2] == "X" && this.state[5] == "X" && this.state[8] == "X")
        )
        {
            return true;
        }

        if((this.state[0] == "X" && this.state[4] == "X" && this.state[8] == "X") ||
            (this.state[2] == "X" && this.state[4] == "X" && this.state[6] == "X"))
        {
            return true;
        }

        return false;
    }

    public boolean checkTie()
    {
        if(!this.checkWinnerX() && !this.checkWinnerO() && !Arrays.asList(this.state).contains(null))
        {
            return true;
        }
        return false;
    }

    public boolean checkWinnerO()
    {
        if((this.state[0] == "O" && this.state[1] == "O" && this.state[2] == "O") ||
                (this.state[3] == "O" && this.state[4] == "O" && this.state[5] == "O") ||
                (this.state[6] == "O" && this.state[7] == "O" && this.state[8] == "O")
        )
        {
            return true;
        }

        if((this.state[0] == "O" && this.state[3] == "O" && this.state[6] == "O") ||
                (this.state[1] == "O" && this.state[4] == "O" && this.state[7] == "O") ||
                (this.state[2] == "O" && this.state[5] == "O" && this.state[8] == "O")
        )
        {
            return true;
        }

        if((this.state[0] == "O" && this.state[4] == "O" && this.state[8] == "O") ||
                (this.state[2] == "O" && this.state[4] == "O" && this.state[6] == "O"))
        {
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getEmptyCells()
    {
        ArrayList<Integer> cells = new ArrayList<Integer>();

        for (int x = 0; x < this.state.length; x++)
        {
            if(this.state[x] == null)
            {
                cells.add(x + 1);
            }
        }

        return cells;
    }

    private String buildBoard()
    {

        String stateLine = " %s | %s | %s \n";
        String borderLine = "---|---|---\n";

        StringBuilder builder = new StringBuilder();

        builder.append(String.format(stateLine, getCellState(0), getCellState(1), getCellState(2)));
        builder.append(borderLine);
        builder.append(String.format(stateLine, getCellState(3), getCellState(4), getCellState(5)));
        builder.append(borderLine);
        builder.append(String.format(stateLine, getCellState(6), getCellState(7), getCellState(8)));

        return builder.toString();
    }

    private String getCellState(int stateCell)
    {
        return this.state[stateCell] != null ? state[stateCell] : " ";
    }
}
