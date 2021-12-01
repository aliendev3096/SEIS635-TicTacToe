package tictactoe;

import java.util.Scanner;

public class ScoreBoard {
    private Player playerX;
    private Player playerO;

    public ScoreBoard(Player playerX, Player playerO)
    {
        this.playerO = playerO;
        this.playerX = playerX;
    }

    public void Display()
    {
        System.out.println(String.format("%s's Record: %s-%s-%s", playerX.getName(), playerX.getWins(), playerX.getLoss(), playerX.getTies()));
        System.out.println(String.format("%s's Record: %s-%s-%s", playerO.getName(), playerO.getWins(), playerO.getLoss(), playerO.getTies()));
    }

    public void DisplayPlayers()
    {
        System.out.println(String.format("Tic Tac Toe: %s vs %s", this.playerX.getName(), this.playerO.getName()));
    }
}
