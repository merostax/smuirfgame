package de.ostfalia.prog.ws21.felder;

import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.interfaces.Figur;
import de.ostfalia.prog.ws21.figuren.Schlumpf;

public class Pilz extends Feld {
    private final Feld dorf;

    /**
     * @param nachsteFeld nachsteFeld
     * @param position    position
     * @param feld f
     */
    public Pilz(Feld nachsteFeld, int position, Feld feld) {
        super(nachsteFeld, position);
        dorf = feld;
    }

    @Override
    public void wirkenFeldpilz(Figur schlumpf) {
        if (schlumpf.isZombie()&&schlumpf instanceof Schlumpf) {
            schlumpf.setZombie(false);
            schlumpf.setFeld(dorf);
        }
    }

}
