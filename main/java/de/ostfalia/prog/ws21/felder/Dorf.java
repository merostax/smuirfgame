package de.ostfalia.prog.ws21.felder;

import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.interfaces.Figur;

import java.util.ArrayList;
import java.util.List;

public class Dorf extends Feld {
    List<Figur> betretedorfFiguren = new ArrayList<>();

    /**
     * @param position position
     */
    public Dorf(int position) {
        super(position);
    }

    /**
     * @param richtung rr
     * @return nachste feld
     */
    @Override
    public Feld getNaechstesFeld(Richtung richtung) {
        return this;
    }

    @Override
    public Farbe gewinner(List<Figur> listfiguren) {
        int count = 0;
        for (Farbe f : Farbe.values()) {
            for (Figur ff : listfiguren) {
                if (ff.getFarbe()!=null&&ff.getFarbe().equals(f) && ff.getFeld().equals(this)) {
                    count++;
                }
                if (count == 4) {
                    return f;
                }

            }
            count = 0;
        }
        return null;
    }

    @Override
    public boolean isfeldgultig(Figur schlumpf) {
        return !schlumpf.isZombie();
    }
}


