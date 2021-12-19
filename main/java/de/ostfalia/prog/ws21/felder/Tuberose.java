package de.ostfalia.prog.ws21.felder;

import de.ostfalia.prog.ws21.figuren.Bzz;
import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.interfaces.Figur;
import de.ostfalia.prog.ws21.figuren.Schlumpf;

public class Tuberose extends Feld {


    /**
     * @param nachsteFeld nn
     * @param position    position
     */
    public Tuberose(Feld nachsteFeld, int position) {
        super(nachsteFeld, position);
    }

    @Override
    public boolean isfeldgultig(Figur schlumpf) {
        if (schlumpf instanceof Bzz) {
            return false;
        }
        return !schlumpf.isZombie();
    }

    @Override
    public void wirkenFeld(Figur schlumpf) {
        if (schlumpf.isZombie() && schlumpf instanceof Schlumpf) {
            schlumpf.setZombie(false);

        }
        schlumpf.setFeld(this);
    }
}

