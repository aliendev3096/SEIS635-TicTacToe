package tictactoe;

import java.util.*;

public class Player {

    private PlayerType Type;
    private PlayerMode mode;
    private String Name;
    private int Wins;
    private int Loss;
    private int Ties;
    private Random rand;

    public Player(PlayerType type)
    {
        this.Type = type;
        this.mode = PlayerMode.Human;
        this.rand = new Random();
    }

    public PlayerMode getMode() {
        return mode;
    }

    public Random getRand() {
        return rand;
    }

    public void setMode(PlayerMode mode) {
        this.mode = mode;
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

    public int makeMove(Scanner inputStream, ArrayList<Integer> emptyCells)
    {
        if(this.mode != PlayerMode.Cpu) {
            System.out.println(String.format("%s(%s), select the cell you want to mark! (1-9)", this.Name, this.Type));
            var cell = inputStream.nextLine();
            return Integer.parseInt(cell);
        }

        int randomSlot = emptyCells.get(rand.nextInt(emptyCells.size()));
        return randomSlot;
    }

    public void promptName(Scanner inputStream)
    {
        if(this.mode != PlayerMode.Cpu) {
            System.out.println(String.format("Ready Player %s? Please enter your name!", this.getType()));
            var name = inputStream.nextLine();
            this.setName(name);
        }
    }
}
