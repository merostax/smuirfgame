package de.ostfalia.prog.ws21.figuren;

import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.interfaces.Figur;

import java.util.ArrayList;
import java.util.List;

public class Schlumpf extends Figur {


    /**
     * @param name     n
     * @param farbe    f
     * @param isZombie i
     * @param i        i
     * @param f        f
     */
    public Schlumpf(String name, Farbe farbe, boolean isZombie, int i, Feld f) {
        super(name, farbe, isZombie, i, f);
    }

    @Override
    public boolean bewegen(int augenzahl, Richtung richtung, List<Figur> figuren) {
        Feld accualFeld = this.getFeld();
        this.setFigurenn(new ArrayList<>());
        this.clone();
        for (int i = 0; i < augenzahl; i++) {
            //setfeld sowie wirkenFeld
            accualFeld = accualFeld.getNaechstesFeld(richtung);
            //setfiguren
            List<Figur> figurenInFeld = this.figurenFeld(figuren, accualFeld);
            accualFeld.wirkenFeld(this);
            if (figurenInFeld != null) {
                addFigur(figurenInFeld, accualFeld);
                figurenInFeld.forEach(s -> s.wirken(this));
            }
        }
        //end der bewegung
        if (accualFeld.isfeldgultig(this)) {
            accualFeld.wirkenFeldpilz(this);
        } else {
            //this zurucksetzen
            return zurucksetzen(this.getFigurenn());
        }
        return true;
    }

    @Override
    public void wirken(Figur schlumpf) {
        if (!((schlumpf instanceof Schlmpfine) || (schlumpf instanceof Oberschlump))) {
            if (this.isZombie()) {
                schlumpf.setZombie(true);
            }
        }

    }


}


