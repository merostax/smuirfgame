package de.ostfalia.prog.ws21.exceptions;

public class FalscheSpielerzahlException extends Exception {
    public FalscheSpielerzahlException() {
        super();
    }

    /**
     * @param c c
     */
    public FalscheSpielerzahlException(String c) {
        super(c);
    }
}
