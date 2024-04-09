package mancala;

public class Store implements Countable {
    //Player who owns the stone store
    private Player storeOwner;

    //Number of stones in the stone store
    private int stoneCount;

    //Default constructor for StoneStore. Initializes the owner to null and the stone count to 0.
    public Store() {
        storeOwner = null;
        stoneCount = 0;
    }

    //gets the owner of the stone store.
    public Player getOwner() {
        return storeOwner;
    }

    // Sets the owner of the stone store.
    public void setOwner(final Player player) {
        // check if the owner is already assigned
        if (storeOwner == null) {
            storeOwner = player;
        }
    }

    //Gets the current number of stones in the stone store.
    @Override
    public int getStoneCount() {
        return stoneCount;
    }

    //Empties the stone store and returns the number of stones it contained.
    public int emptyStore() {
        final int totalStonesInStore = stoneCount;
        stoneCount = 0;
        return totalStonesInStore;
    }

    //Removes all stones from the stone store and returns the total number removed.
    @Override
    public int removeStones() {
        final int stonesInStoreRemoved = stoneCount;
        stoneCount = 0;
        return stonesInStoreRemoved;
    }

    //Adds a specified number of stones to the stone store.
    @Override
    public void addStones(final int numToAdd) {
        stoneCount += numToAdd;
    }

    //Adds a single stone to the stone store.
    @Override
    public void addStone() {
        stoneCount++;
    }

    //Provides a string representation of the StoneStore.
    @Override
    public String toString() {
        return "StoneStore: " + stoneCount;
    }
}