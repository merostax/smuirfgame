package de.ostfalia.prog.ws21.interfaces;

import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public abstract class Figur implements Cloneable, Serializable {
    public String getNamee() {
        return namee;
    }

    private String namee;

    public Farbe getFarbe() {
        return farbe;
    }

    public List<Figur> getFigurenn() {
        return figurenn;
    }

    public boolean isZombie() {
        return isZombie;
    }

    public void setZombie(boolean zombie) {
        isZombie = zombie;
    }

    public Feld getFeld() {
        return feld;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Figur getCloneFigur() {
        return cloneFigur;
    }

    public void setCloneFigur(Figur cloneFigur) {
        this.cloneFigur = cloneFigur;
    }

    private boolean isZombie;
    private Farbe farbe;
    private Feld feld;
    private int position=0;
    private List<Figur> figurenn=new ArrayList<>();
    private Figur cloneFigur;

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public void setFarbe(Farbe farbe) {
        this.farbe = farbe;
    }

    public void setFigurenn(List<Figur> figurenn) {
        this.figurenn = figurenn;
    }

    public void setFeld(Feld feld) {
        this.feld = feld;
        this.position = feld.getPosition();
    }


    /**
     * @param name     n
     * @param farbe    f
     * @param isZombie z
     * @param i        i
     * @param f        f
     */
    public Figur(String name, Farbe farbe, boolean isZombie, int i, Feld f) {
        this.namee = name;
        this.farbe = farbe;
        this.isZombie = isZombie;
        this.position = i;
        this.feld = f;
    }
    /**
     * @param name     n
     * @param isZombie i
     * @param i        i
     * @param f        f
     */
    public Figur(String name, Boolean isZombie, int i, Feld f) {
        this.namee = name;
        this.isZombie = isZombie;
        this.position = i;
        this.feld = f;
    }
    @Override
    public String toString() {
        return namee + "  ist :" + isZombie + " auf Feld  "+feld+"  in position  "+position+"\r";
    }

    public abstract boolean bewegen(int augenzahl, Richtung richtung, List<Figur> felder);

    public abstract void wirken(Figur schlumpf);

    public List<Figur> figurenFeld(List<Figur> figuren, Feld accualFeld) {
       return figuren.stream().filter(s -> s.getFeld().equals(accualFeld)).collect(Collectors.toList());
    }


    public void addFigur( List<Figur> figurenInFeld, Feld accualFeld) {
        this.setFeld(accualFeld);
        this.figurenn.addAll(figurenInFeld);
        figurenInFeld.forEach(Figur::clone);
        figurenInFeld.forEach(this::wirken);
    }
    public boolean zurucksetzen(List<Figur> figur) {
        figur.forEach(s -> s.isZombie = s.cloneFigur.isZombie);
        this.setFeld(this.cloneFigur.getFeld());
        this.setZombie(this.cloneFigur.isZombie);
        return false;
    }
    @Override
    public Figur clone() {
        try {
            Figur clone = (Figur) super.clone();
            clone.feld = feld.clone();
            this.cloneFigur=clone;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


