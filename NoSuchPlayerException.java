package mancala;

import java.io.Serializable;

public class NoSuchPlayerException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public NoSuchPlayerException(final String errorMessage) {
        super(errorMessage); 
        System.out.println(errorMessage);
    }
}