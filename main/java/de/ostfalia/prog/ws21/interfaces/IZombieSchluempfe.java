package de.ostfalia.prog.ws21.interfaces;

import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;

/**
 * Das Spiel „Die Zombieschlümpfe“ ist ein Brettspiel mit unterschiedlichen
 * Figuren, die sich durch unterschiedliche Felder entlang eines Spielbrettes
 * (den Schlumpfwald) in de.ostfalia.prog.ws21.enums.Richtung Dorf (das Ziel) bewegen. Während die Schlümpfe
 * den Schlumpfwald durchqueren, können sie ihren Zustand mehrmals ändern
 * (Gesund <-> Zombie), da sie von anderen Figuren aus dem Spiel oder von
 * speziellen Feldern beeinflusst werden.
 *
 * Als Vorlage dient uns das Spiel „Die schwarzen Schlümpfe“ von Bully Figuren,
 * Peyo Verlag aus dem Jahr 1975.
 *
 * Die ausführliche Erklärungen zum Spiel ist aus der Aufgabestellung zu
 * entnehmen.
 *
 * @author M. Gruendel und D. Dick
 * @since WS 2021/22
 */
public interface IZombieSchluempfe {

    /*
     * *********************************************************************
     * *************************** KONSTRUKTOREN ***************************
     *
     * "?" steht für den Name der Klasse, die das Interface implementiert
     *
     * *********************************************************************
     */

    /*
     * In diese Konstruktur werden ausschließlich die spielenden Farben
     * bekanntgegeben. Alle Figuren werden auf ihren Standardpositionen positioniert
     * (d.h. Schlümpfe auf Feld 0, Fliege auf Feld 20 und Oberschlumpf auf Feld 29).
     * Für jede spielende de.ostfalia.prog.ws21.enums.Farbe werden 4 Schlümpfe erzeugt.
     *
     * Die ausführliche Erklärungen zur Methode ist aus der Aufgabestellung zu
     * entnehmen.
     *
     * @param farben - Die spielenden Farben
     *
     * -----------------------------------------------------------------------
     * public ? (de.ostfalia.prog.ws21.enums.Farbe... farben);
     * -----------------------------------------------------------------------
     *
     */

    /*
     * In diesem Konstruktor werden neben den spielenden Farben auch die
     * Startposition der Figuren bekanntgegeben, die nicht auf ihren Standardfelder
     * zu positionieren sind.
     *
     * Die ausführliche Erklärungen zur Methode ist aus der Aufgabestellung zu
     * entnehmen.
     *
     * @param conf - String mit den Startpositionen der Figuren. Zum Beispiel:
     * "BLAU-A:30:Z, BLAU-B:28, BLAU-C:30, BLAU-D:28, GELB-A:30, GELB-B:28,
     * GELB-C:30, GELB-D:28, Bzz:20, Doc:29"
     *
     * @param farben - Die spielenden Farben
     *
     * -----------------------------------------------------------------------
     * public ? (String conf, de.ostfalia.prog.ws21.enums.Farbe... farben);
     * -----------------------------------------------------------------------
     *
     */

    /*
     * *********************************************************************
     * ****************************** METHODEN *****************************
     * *********************************************************************
     */

    /**
     * Bewegt die Figur mit dem angegebenen Namen um die gewuerfelte Augenzahl
     * weiter. Die Bewegungsrichtung ist hier immer WEITER.
     *
     * Bedenken Sie, dass ab Serie 3 ein Spielzug für unzulässig erklärt werden
     * kann. In diesem Fall behält die Figur sowohl ihre ursprüngliche Position als
     * auch ihren ursprünglichen Zustand (Gesund/Zombie). Gleiches gilt auch für
     * alle anderen Figuren. Der Spielzug gilt dennoch als vollzogen und der nächste
     * Spieler ist an der Reihe.
     *
     * Die ausführliche Erklärungen zur Figurbewegung ist aus der Aufgabestellung zu
     * entnehmen.
     *
     * @param figurName - Der Name bzw. die eindeutige Identifikation der Figur,
     *                  welche bewegt werden soll
     * @param augenzahl - Der gewürfelte Wert entspricht die Anzahl von Felder, die
     *                  die Figur vorrücken muss
     * @return true, wenn die Bewegungs ausgeführt werden konnte, sonst false.
     */
    public boolean bewegeFigur(String figurName, int augenzahl);

    public Figur getfigur(String figurName);
    /**
     * Bewegt die Figur mit dem angegebenen Namen um die gewuerfelte Augenzahl
     * weiter. Die Bewegungsrichtung wird hier anhand des Parameters "richtung"
     * angegeben.
     *
     * Bedenken Sie, dass ab Serie 3 ein Spielzug für unzulässig erklärt werden
     * kann. In diesem Fall behält die Figur sowohl ihre ursprüngliche Position als
     * auch ihren ursprünglichen Zustand (Gesund/Zombie). Gleiches gilt auch für
     * alle anderen Figuren. Der Spielzug gilt dennoch als vollzogen und der nächste
     * Spieler ist an der Reihe.
     *
     * Die ausführliche Erklärungen zur Figurbewegung ist aus der Aufgabestellung zu
     * entnehmen.
     *
     * @param figurName - Der Name bzw. die eindeutige Identifikation der Figur,
     *                  welche bewegt werden soll
     * @param augenzahl - Der gewürfelte Wert entspricht die Anzahl von Felder, die
     *                  die Figur vorrücken muss
     * @param richtung  - Richtungsangaben für die Verzweigungsfelder
     * @return true, wenn die Bewegungs ausgeführt werden konnte, sonst false.
     */
    public boolean bewegeFigur(String figurName, int augenzahl, Richtung richtung);

    /**
     *
     *
     * @param name der Name der Figur
     * @return die Position der Figur, wenn sie gefunden wurde; sonst -1
     */

    /**
     * Liefert die Position (die Feldnummer) der Figur mit dem angegebenen Namen.
     *
     * @param name - Der Name bzw. die eindeutige Identifikation der Figur
     * @return Feldnummer der Figur oder -1, falls sie nicht gefunden werden konnte.
     */
    public int getFeldnummer(String name);

    /**
     * Ermittelt, ob die Figur mit dem angegebenen Namen ein Zombie ist oder nicht.
     *
     * @param name - Der Name bzw. die eindeutige Identifikation der Figur
     * @return true, wenn die Figur ein Zombie ist, sonst false
     */
    public boolean istZombie(String name);


    /**
     * Methode liefert die de.ostfalia.prog.ws21.enums.Farbe des Spieler der aktuell spielen darf.
     *
     * Die ausführliche Erklärungen zum Spielverlauf ist aus der Aufgabestellung zu
     * entnehmen.
     *
     * @return die de.ostfalia.prog.ws21.enums.Farbe des Spieler, der aktuell spielen darf
     */
    public Farbe getFarbeAmZug();

    /**
     * Liefert die de.ostfalia.prog.ws21.enums.Farbe des Spielers, der das Spiel gewonnen hat.
     *
     * Die ausführliche Erklärungen zum Spielende ist aus der Aufgabestellung zu
     * entnehmen.
     *
     * @return de.ostfalia.prog.ws21.enums.Farbe des Spielgewinners, oder null, wenn es noch keinen Gewinner
     *         gibt
     */
    public Farbe gewinner();

    /**
     * Liefert eine textuelle Repräsentation des Spiels.
     *
     * @return Das Spiel in Form eines Strings
     */
    @Override
    public String toString();

}
