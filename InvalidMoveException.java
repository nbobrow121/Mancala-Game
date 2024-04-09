package mancala;

import java.io.Serializable;

public class InvalidMoveException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public InvalidMoveException(final String errorMessage) {
        super(errorMessage); 
        System.out.println(errorMessage);
    }
}
