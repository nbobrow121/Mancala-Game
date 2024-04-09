package mancala;

import java.io.Serializable;

public class PitNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public PitNotFoundException(final String errorMessage) {
        super(errorMessage); 
        System.out.println(errorMessage);
    }
}