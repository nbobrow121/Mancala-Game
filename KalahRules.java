package mancala;

public class KalahRules extends GameRules {
    private final MancalaDataStructure board;

    // Constructor
    public KalahRules() {
        super();
        board = getDataStructure();
    }

    //Override method to move stones
    @Override
    public int moveStones(final int startPit, final int playerNum) throws InvalidMoveException {
        validatePitBounds(startPit, playerNum);
        final int startingStones = getNumStones(startPit);

        distributeStones(startPit);
        switchPlayer(startingStones + startPit);

        return board.getStoreCount(playerNum);
    }

    //Override method to distribute stones
    @Override
    protected int distributeStones(final int startingPoint) {
        int totalStones = board.removeStones(startingPoint);
        board.setIterator(startingPoint, getPlayer(), false);
        Countable currentPosition = board.iteratorPosition();

        for (int i = 0; i < totalStones - 1; i++) {
            currentPosition = board.next();
            currentPosition.addStone();
        }

        currentPosition = board.next();
        final int currentPitPos = board.getIteratorPosition();
        final int emptyStones = board.getNumStones(currentPitPos);

        // Check if stones should be captured
        if (shouldCaptureStones(startingPoint, currentPitPos, emptyStones)) {
            int capturedStones = captureStones(currentPitPos);
            totalStones += board.addToStore(startingPoint <= 6 ? 1 : 2, capturedStones);
        } else {
            currentPosition.addStone();
        }
        return totalStones;
    }

    //Method to validate pit bounds
    private void validatePitBounds(final int startPit, final int playerNum) throws InvalidMoveException {
        final int low = (playerNum == 1) ? 1 : 7;
        final int high = (playerNum == 1) ? 6 : 12;

        if (startPit < low || startPit > high) {
            throw new InvalidMoveException("Invalid pit number");
        }
    }

    //Method to check if stones should be captured
    private boolean shouldCaptureStones(final int startingPoint, final int currentPit, final int emptyStones) {
        return (startingPoint <= 6 && currentPit <= 6 || startingPoint > 6 && currentPit > 6) && emptyStones == 0;
    }

    //Method to switch players
    private void switchPlayer(final int storeIndex) {
        setPlayer((storeIndex == 7 || storeIndex == 13) ? (storeIndex == 7 ? 1 : 2) : (getPlayer() == 1 ? 2 : 1));
    }

    //Override method to capture stones
    @Override
    protected int captureStones(final int stoppingPoint) {
        final int emptyStones = board.removeStones(stoppingPoint);
        int stonesCaptured = 0;
        if (emptyStones == 0 || emptyStones == 1) {
            stonesCaptured = board.removeStones(13 - stoppingPoint);
        }
        return stonesCaptured + 1;
    }
}