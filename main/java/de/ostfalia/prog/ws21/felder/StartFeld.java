package de.ostfalia.prog.ws21.felder;

import de.ostfalia.prog.ws21.interfaces.Feld;

public class StartFeld extends Feld {

    /**
     * @param nachsteFeld nachstefeld
     * @param position    position
     */
    public StartFeld(Feld nachsteFeld, int position) {
        super(nachsteFeld, position);
    }

}
