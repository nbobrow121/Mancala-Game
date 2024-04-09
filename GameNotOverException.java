package mancala;

import java.io.Serializable;

public class GameNotOverException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public GameNotOverException(final String errorMessage) {
        super(errorMessage); 
        System.out.println(errorMessage);
    }
}