// Everything in this file was written by AI unless specified otherwise

package mancala;
import java.io.Serializable; //I added this for Serialization
import java.util.ArrayList;

public class MancalaGame implements Serializable{
    private static final long serialVersionUID = 1L; //I added this for Serialization as well as "implements Serializable"

    private final ArrayList<Player> players;
    private Player currentPlayer;
    private GameRules board;

    public MancalaGame() {
        players = new ArrayList<>();
        board = new KalahRules();
    }

    public GameRules getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumStones(final int pitNum) throws PitNotFoundException {
        return board.getNumStones(pitNum);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getStoreCount(final Player player) throws NoSuchPlayerException {
        if (!players.contains(player)){
            throw new NoSuchPlayerException("Player not found.");
        }
        return player.getStoreCount();
    }

    //This entire method below is written by me without the help of AI
    public Player getWinner() throws GameNotOverException {
        if(!isGameOver()){  //I added this if statement plus the "throws GameNotOverException" that is above
            throw new GameNotOverException("Game is not over!");
        }

        // Determine the game winner.
        int stonesInPlayer1Store = players.get(0).getStoreCount();
        int stonesInPlayer2Store = players.get(1).getStoreCount();

        if (isGameOver()) {
            if (stonesInPlayer1Store > stonesInPlayer2Store) {
                return players.get(0);
            } else if (stonesInPlayer2Store > stonesInPlayer1Store) {
                return players.get(1);
            }
        }

        return null; // Game is not over, or it's a tie.
    }

    //This entire method below is written by me without the help of AI
    public boolean isGameOver() {
        try {
            if(board.isSideEmpty(1) || board.isSideEmpty(6)){
                return true;
            }
        } catch (PitNotFoundException e) {
            System.out.println("Pit is invalid - " + e.getMessage());
        }
        return false;

    }

    //This entire method below is written by me without the help of AI
    public int move(final int startPit) throws InvalidMoveException {
        try {
            int currentPlayerIndex = players.indexOf(currentPlayer);
            int currentPlay = (currentPlayerIndex == 0) ? 1 : 2;
    
            board.moveStones(startPit, currentPlay);
            setCurrentPlayer(players.get(1 - currentPlayerIndex));
    
            if (startPit < 1 || startPit > 12) {
                throw new PitNotFoundException("Invalid pit number.");
            }
    
            int stonesLeft = 0;
            int startRange = (startPit <= 6) ? 1 : 7;
            int endRange = (startPit <= 6) ? 6 : 12;
    
            for (int i = startRange; i <= endRange; i++) {
                stonesLeft += board.getNumStones(i);
            }
    
            return stonesLeft;
    
        } catch (PitNotFoundException e) {
            System.out.println("Invalid, enter number in range.");
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move attempt - " + e.getMessage());
        }
        return 0;
    }

    public void setBoard(final GameRules theBoard) {
        board = theBoard;
    }

    public void setCurrentPlayer(final Player player) {
        currentPlayer = player;
    }

    public void setPlayers(final Player onePlayer, final Player twoPlayer) {
        players.add(onePlayer);
        players.add(twoPlayer);
        setCurrentPlayer(onePlayer);
        board.registerPlayers(onePlayer, twoPlayer);
    }

    public void startNewGame() {
        board.resetBoard();
    }

    //I added this method to start a new Kalah Game
    public void newKalah(){
        board = new KalahRules();
        startNewGame();
    }

    //I added this method to start a new Ayo Game
    public void newAyo(){
        board = new AyoRules();
        startNewGame();
    }

    @Override
    public String toString() {
        return board.toString();
    }
}

