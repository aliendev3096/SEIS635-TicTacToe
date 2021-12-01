package tictactoe;

public class Board {

    private String[] state;

    private String winner;
    private BoardStatus status;

    public String getWinner() {
        return winner;
    }

    public boolean IsFinished() {
        return status == BoardStatus.FINISHED;
    }

    public boolean IsInProgress() {
        return status == BoardStatus.IN_PROGRESS;
    }

    public boolean IsStarted() {
        return status == BoardStatus.STARTED;
    }

    public Board() {
        this.state = new String[] { null, null, null, null, null, null, null, null, null };
        winner = "";
        status = BoardStatus.STARTED;
    }

    public void UpdateBoard(String mark, int cell)
    {
        this.state[cell - 1] = mark;
    }

    public void SetBoardStatus(BoardStatus status)
    {
        this.status = status;
    }

    public void RenderBoard()
    {
        var board = BuildBoard();
        System.out.println(board);
    }

    public void CheckWinner()
    {
        if(CheckWinnerX())
        {
            this.winner = "X";
            this.status = BoardStatus.FINISHED;
        }
        else if(CheckWinnerO())
        {
            this.winner = "O";
            this.status = BoardStatus.FINISHED;
        }
    }

    public String BuildBoard()
    {

        String stateLine = " %s | %s | %s \n";
        String borderLine = "---|---|---\n";

        StringBuilder builder = new StringBuilder();

        builder.append(String.format(stateLine, GetCellState(0), GetCellState(1), GetCellState(2)));
        builder.append(borderLine);
        builder.append(String.format(stateLine, GetCellState(3), GetCellState(4), GetCellState(5)));
        builder.append(borderLine);
        builder.append(String.format(stateLine, GetCellState(6), GetCellState(7), GetCellState(8)));

        return builder.toString();
    }

    private boolean CheckWinnerX()
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

    private boolean CheckWinnerO()
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

    private String GetCellState(int stateCell)
    {
        return this.state[stateCell] != null ? state[stateCell] : " ";
    }
}
