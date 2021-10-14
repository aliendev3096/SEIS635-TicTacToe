package tictactoe;

public class Board {

    private String[] state;
    public Board() {
        this.state = new String[] { null, null, null, null, null, null, null, null, null };
    }

    public String RenderBoard()
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
