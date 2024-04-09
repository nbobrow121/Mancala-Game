package mancala;

import java.io.Serializable;

// Represents a player in the Mancala game
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private UserProfile profile;
    private String userName;
    private transient Store userStore;

    // Default constructor creating a player with a default name and user profile
    public Player() {
        profile = new UserProfile("P1");
        setName("P1");
    }

    // Constructor creating a player with a specified name and corresponding user profile
    public Player(final String PlayerName) {
        profile = new UserProfile(PlayerName);
        setName(PlayerName);
    }

    // Getter method for the player's name
    public String getName() {
        return userName;
    }

    // Getter method for the player's stone store
    public Store getStore() {
        return userStore;
    }

    // Getter method for the total stone count in the player's store
    public int getStoreCount() {
        if (userStore != null) {
            return userStore.getStoneCount();
        }
        return 0;
    }

    // Setter method to set the player's name and update the user profile
    public final void setName(final String PlayerName) {
        this.userName = PlayerName;
        profile.setPlayerName(PlayerName);
    }

    // Setter method to set the player's stone store
    public void setStore(final Store store) {
        this.userStore = store;
    }

    // Setter method to set the user profile for the player
    public void setPlayerProfile(final UserProfile profile) {
        this.profile = profile;
    }

    // Getter method for the user profile associated with the player
    public UserProfile getPlayerProfile() {
        return profile;
    }

    // Override toString method for a meaningful representation of the player
    @Override
    public String toString() {
        return "MancalaPlayer: " + userName;
    }
}