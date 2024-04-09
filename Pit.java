// Everything in this file was written by AI unless specified otherwise

package mancala;

//I added "implements Countable"
public class Pit implements Countable { 
    private int stoneCount;

    public Pit() {
        // Initialize a new pit.
        stoneCount = 0;
    }

    //I added "@Override"
    @Override
    public void addStone() {
        // Add a stone to the pit.
        stoneCount++;
    }

    //I added "@Override" and "final" for numToAdd
    @Override
    public void addStones(final int numToAdd) {
        // Add stones to the store.
        stoneCount += numToAdd;
    }

    //I added "@Override"
    @Override
    public int getStoneCount() {
        // Get the number of stones in the pit.
        return stoneCount;
    }

    //I added "@Override"
    @Override
    public int removeStones() {
        // Remove and return the stones from the pit.
        //I added the "final" for stonesRemoved
        final int stonesRemoved = stoneCount;
        stoneCount = 0;
        return stonesRemoved;
    }

    @Override
    public String toString() {
        // Generate a string representation of the pit.
        return stoneCount + " total stones";
    }
}