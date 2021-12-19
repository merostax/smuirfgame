package de.ostfalia.prog.ws21.interfaces;

import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;

import java.io.Serializable;
import java.util.List;

public abstract class Feld implements Cloneable , Serializable {
    /**
     * position der Feld
     */
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Feld getNachsteFeld() {
        return nachsteFeld;
    }

    public void setNachsteFeld(Feld nachsteFeld) {
        this.nachsteFeld = nachsteFeld;
    }

    /**
     * nachste Feld
     */
    private Feld nachsteFeld;


    /**
     * @param position position
     */
    public Feld(int position) {
        this.position = position;
    }

    /**
     * @param nachsteFeld nachstefeld
     * @param position    position
     */
    public Feld(Feld nachsteFeld, int position) {
        this.position = position;
        this.nachsteFeld = nachsteFeld;
    }

    /**
     * @param rr richtung
     * @return nachstefled
     */
    public Feld getNaechstesFeld(Richtung rr) {
        return nachsteFeld;
    }


    /**
     * @return feld and position and figur
     */
    @Override
    public String toString() {

        return "" + this.getClass().getSimpleName() + ": " + position + "" + "  Next-->" +
                nachsteFeld.getClass().getSimpleName() + " " + nachsteFeld.position + "\n" + "";

    }

    public boolean isfeldgultig(Figur Figur) {
        return true;
    }

    public void wirkenFeld(Figur figur) {
        figur.setFeld(this);
        figur.setPosition(this.getPosition());
    }

    public void wirkenFeldpilz(Figur schlumpf) {

    }
    @Override
    public Feld clone() {
        try {
            return (Feld) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Farbe gewinner(List<Figur> listfiguren) {
        return null;
        }
}

