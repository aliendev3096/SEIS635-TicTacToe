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

    public void Prompt()
    {
        Scanner in = new Scanner(System.in);
        System.out.println(String.format("Ready Player %s? Please enter your name!", this.Type));
        var name = in.nextLine();
        this.Name = name;
    }

    public String getName() {
        return Name;
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
}
