package de.ostfalia.prog.ws21.figuren;

import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.interfaces.Figur;

import java.util.List;

public class Oberschlump extends Figur {
    /**
     * Constructor FIgur
     *
     * @param name     name
     * @param isZombie isZombie
     * @param i        i
     * @param feld     f
     */
    public Oberschlump(String name, Boolean isZombie, int i, Feld feld) {
        super(name, isZombie, i, feld);
    }
    /**
     * @return name
     */


    @Override
    public boolean bewegen(int augenzahl, Richtung richtung, List<Figur> felder) {
        return false;
    }

    @Override
    public void wirken(Figur schlumpf) {
        schlumpf.setZombie(false);
    }


}
