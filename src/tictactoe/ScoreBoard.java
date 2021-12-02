package tictactoe;

import java.util.Scanner;

public class ScoreBoard {
    private Player playerX;
    private Player playerO;
    private String streakHolder;
    private int streakCount;

    public ScoreBoard(Player playerX, Player playerO)
    {
        this.playerO = playerO;
        this.playerX = playerX;
    }

    public void Display()
    {
        System.out.println(String.format("%s's Record: %s-%s-%s", playerX.getName(), playerX.getWins(), playerX.getLoss(), playerX.getTies()));
        System.out.println(String.format("%s's Record: %s-%s-%s", playerO.getName(), playerO.getWins(), playerO.getLoss(), playerO.getTies()));

        if(this.streakHolder != null)
        {
            System.out.println(String.format("Streak Holder: %s", this.streakHolder));
            System.out.println(String.format("Streak Count: %s", this.streakCount));
        }
    }

    public void DisplayPlayers()
    {
        System.out.println(String.format("Tic Tac Toe: %s(%s) vs %s(%s)", this.playerX.getName(), this.playerX.getType(), this.playerO.getName(), this.playerO.getType()));
    }

    public void updateStreak(String winnerName)
    {
        if (this.streakHolder == null)
        {
            this.streakHolder = winnerName;
            this.streakCount = 1;
        } else {
            if(streakHolder.equals(winnerName))
            {
                this.streakCount++;
            }
            else
            {
                this.streakHolder = winnerName;
                this.streakCount = 1;
            }
        }
    }
}
