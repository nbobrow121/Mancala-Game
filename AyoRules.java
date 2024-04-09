package mancala;

public class AyoRules extends GameRules {
    //MancalaDataStructure to represent the game board
    private final MancalaDataStructure board;

    public AyoRules() {
        super();
        board = getDataStructure();
    }

    // method for moving stones
    @Override
    public int moveStones(final int startPit, final int playerNum) throws InvalidMoveException {
        validatePitBounds(startPit, playerNum);
        distributeStones(startPit);
        //Return the stone count in the player's store after the move
        return board.getStoreCount(playerNum);
    }

    //method for distributing stones on the board
    @Override
    int distributeStones(final int startingPoint) {
        int totalStones = 0;
        board.setIterator(startingPoint, getPlayer(), true);
        //Get the current position on the board
        Countable currentPosition = board.iteratorPosition();

        //Distribute stones until specific conditions are met
        do {
            int updatedStones = currentPosition.removeStones();
            totalStones += updatedStones;
            //Add stones to the next positions on the board
            for (int i = 0; i < updatedStones; i++) {
                currentPosition = board.next();
                currentPosition.addStone();
            }
        } while (currentPosition.getStoneCount() > 1 && board.returnPositionStore() != 13 && board.returnPositionStore() != 6);

        final int currentPit = board.getIteratorPosition();

        //Check if stones should be captured and add them to the player's store
        if (shouldCaptureStones(startingPoint, currentPit)) {
            int captureStones = captureStones(currentPit);
            totalStones += board.addToStore(startingPoint <= 6 ? 1 : 2, captureStones);
        }
        switchPlayer();
        return totalStones;
    }

    //method to validate the pit bounds
    private void validatePitBounds(final int startPit, final int playerNum) throws InvalidMoveException {
        //Determine the lower and upper bounds based on the player
        final int low = (playerNum == 1) ? 1 : 7;
        final int high = (playerNum == 1) ? 6 : 12;

        if (startPit < low || startPit > high) {
            throw new InvalidMoveException("Invalid pit number");
        }
    }

    //method to check if stones should be captured
    private boolean shouldCaptureStones(final int startingPoint, final int currentPit) {
        return (startingPoint <= 6 && currentPit < 6) ^ (startingPoint > 6 && currentPit >= 6);
    }

    //method to switch the player for the next turn
    private void switchPlayer() {
        setPlayer((getPlayer() == 1) ? 2 : 1);
    }

    //method for capturing stones
    @Override
    int captureStones(final int stoppingPoint) {
        final int emptyStones = board.getNumStones(stoppingPoint);
        int stonesCaptured = 0;

        //Check conditions for capturing stones and remove them from the board
        if (emptyStones == 1) {
            stonesCaptured = board.removeStones(13 - stoppingPoint);
        }
        return stonesCaptured;
    }
}