package de.ostfalia.prog.ws21.felder;

import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.interfaces.Feld;

public class Verzweigungsfeld extends Feld {
    /**
     * drehendeld
     */
    private Feld drehenFeld;

    /**
     * @param position position
     * @param drehen   drehen
     */
    public Verzweigungsfeld(int position, Feld drehen) {
        super(position);
        drehenFeld = drehen;
    }

    /**
     * @param richtung nachstefeld
     * @return feld
     */
    @Override
    public Feld getNaechstesFeld(Richtung richtung) {
        return (richtung == Richtung.WEITER) ? super.getNaechstesFeld(Richtung.WEITER) : drehenFeld;
    }


}
