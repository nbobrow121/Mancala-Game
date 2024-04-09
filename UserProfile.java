package mancala;

import java.io.Serializable;

public class UserProfile implements Serializable{
    private static final long serialVersionUID = 1L; 
    private String playerName;
    private int kalahGamesCount;
    private int ayoGamesCount;
    private int kalahWinsCount;
    private int ayoWinsCount;
  
    //Constructor for PlayerProfile, initializing the username and game counts.
    public UserProfile(final String playerName) {        
        setPlayerName(playerName);
        this.kalahGamesCount = 0;
        this.ayoGamesCount = 0;
        this.kalahWinsCount = 0;
        this.ayoWinsCount = 0;
    }

    //Getter method for the username.
    public String getPlayerName() {
        return playerName;
    }

    //Getter method for the number of Kalah games played.
    public int getKalahGamesPlayed() {
        return kalahGamesCount;
    }

    //Getter method for the number of Kalah games won.
    public int getKalahWins() {
        return kalahWinsCount;
    }

    //Getter method for the number of Ayo games played.
    public int getAyoGamesPlayed() {
        return ayoGamesCount;
    }

    //Getter method for the number of Ayo games won.
    public int getAyoWins() {
        return ayoWinsCount;
    }

    //Increment the count of Ayo games played.
    public void ayoGamesIncre() {
        ayoGamesCount++;
    }

    //Increment the count of Ayo games won.
    public void ayoWinsIncre() {
        ayoWinsCount++;
    }

    //Increment the count of Kalah games played.
    public void kalahGamesIncre() {
        kalahGamesCount++;
    }

    //Increment the count of Kalah games won.
    public void kalahWinsIncre() {
        kalahWinsCount++;
    }

    //Setter method for the username.
    public final void setPlayerName(final  String playerName) {
        this.playerName = playerName;
    }

}