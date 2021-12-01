package tictactoe;

import java.util.Scanner;

public class Player {

    private PlayerType Type;
    private String Name;
    private int Wins;
    private int Loss;
    private int Ties;

    public Player(PlayerType type)
    {
        this.Type = type;
    }

    public String getName() {
        return Name;
    }

    public PlayerType getType() {
        return Type;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getLoss() {
        return Loss;
    }

    public void setLoss(int loss) {
        Loss = loss;
    }

    public int getTies() {
        return Ties;
    }

    public void setTies(int ties) {
        Ties = ties;
    }

    public int MakeMove(Scanner inputStream)
    {
        System.out.println(String.format("Player %s, select the cell you want to mark! (1-9)", this.Type));
        var cell = inputStream.nextLine();
        return Integer.parseInt(cell);
    }
}
