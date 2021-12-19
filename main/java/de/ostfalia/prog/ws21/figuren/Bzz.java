package de.ostfalia.prog.ws21.figuren;

import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.felder.Pilz;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.interfaces.Figur;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bzz extends Figur {
    /**
     * Constructor FIgur
     *
     * @param name     name
     * @param isZombie isZombie
     * @param i        i
     * @param feld     f
     */
    public Bzz(String name, Boolean isZombie, int i, Feld feld) {
        super(name, isZombie, i, feld);
    }


    /**
     * @param a zombie
     */
    @Override
    public void setZombie(boolean a) {

    }

    @Override
    public boolean bewegen(int augenzahl, Richtung richtung, List<Figur> figuren) {
        Feld accualFeld = this.getFeld();
        this.setFigurenn(new ArrayList<>());

        this.clone();
        List<Figur> figurenInFeld = new ArrayList<>();
        for (int i = 0; i < augenzahl; i++) {
            accualFeld = accualFeld.getNaechstesFeld(richtung);
            figurenInFeld = this.figurenFeld(figuren, accualFeld);
        }
        if (!accualFeld.isfeldgultig(this) || Objects.requireNonNull(figurenInFeld).stream().anyMatch(e -> e instanceof Schlmpfine) ||
                Objects.requireNonNull(figurenInFeld).stream().anyMatch(e -> e instanceof Oberschlump)) {

            return zurucksetzen(this.getFigurenn());

        } else {
            addFigur(figurenInFeld, accualFeld);
        }

        //this zurucksetzen

        return true;
    }

    @Override
    public void wirken(Figur schlumpf) {
        if (!((schlumpf instanceof Schlmpfine) || (schlumpf instanceof Oberschlump)) && !(schlumpf.getFeld() instanceof Pilz)) {
            schlumpf.setZombie(true);
        }
    }
}
