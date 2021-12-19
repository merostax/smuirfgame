package de.ostfalia.prog.ws21.figuren;

import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.interfaces.Figur;

import java.util.ArrayList;
import java.util.List;

public class Schlmpfine extends Figur {


    /**
     * Constructor FIgur
     *
     * @param name     name
     * @param isZombie isZombie
     * @param i        i
     * @param feld     f
     */
    public Schlmpfine(String name, Boolean isZombie, int i, Feld feld) {
        super(name, isZombie, i, feld);
    }


    @Override
    public boolean bewegen(int augenzahl, Richtung richtung, List<Figur> figuren) {
        Feld accualFeld = this.getFeld();
         List<Figur>figurenn;
        figurenn = this.getFigurenn();
        this.clone();
        for (int i = 0; i < augenzahl; i++) {
            accualFeld = accualFeld.getNaechstesFeld(richtung);
            List<Figur> figurenInFeld = this.figurenFeld(figuren, accualFeld);
            if (figurenInFeld != null && figurenInFeld.stream().noneMatch(e -> e instanceof Bzz)) {
                addFigur(figurenInFeld,accualFeld);
            } else {
                return zurucksetzen(figurenn);
            }
        }
        return true;
    }

    @Override
   public void wirken(Figur schlumpf) {
        schlumpf.setZombie(false);
    }
}
