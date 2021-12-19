package de.ostfalia.prog.ws21.felder;


import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.interfaces.Figur;
import de.ostfalia.prog.ws21.figuren.Schlumpf;

public class Fluss extends Feld {
    /**
     * @param nachsteFeld nachsteFeld
     * @param position    position
     */
    public Fluss(Feld nachsteFeld, int position) {
        super(nachsteFeld, position);
    }

    @Override
    public boolean isfeldgultig(Figur schlumpf) {
        return !(schlumpf instanceof Schlumpf);
    }
}
