package tictactoe;

public class Board {

    private String[] state;
    private String winner;
    private BoardStatus status;

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

    private String GetCellState(int stateCell)
    {
        return this.state[stateCell] != null ? state[stateCell] : " ";
    }
}
