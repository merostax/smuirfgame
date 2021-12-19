package de.ostfalia.prog.ws21.interfaces;

import de.ostfalia.prog.ws21.dataspeichern.Dataspeichern;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Erweitert das Spiel Zombieschlümpfe, so dass die aktuelle Spielstellung
 * gespeichert werden kann und auch so, dass eine gespeicherte Spielstellung
 * geladen werden kann. Nach dem laden muss das Spiel in einem bespielbaren
 * Zustand sein.
 *
 * @author M. Gruendel, D. Dick
 * @since WS 2021/2022
 */
public interface ISpeicherbar {

    /**
     * Die Methode speichert in eine Datei den momentanen Spielzustand, so dass nach
     * dem Laden das Weiterspielen möglich ist.
     *
     * @param dateiName Name der Datei bzw. den kompletten Pfad, wo die Datei
     *                  gespeichert wird
     */
   void speichern(String dateiName) throws IOException;

    /**
     * Die Methode liest eine Datei und konfiguriert das Spiel, wie es dort
     * gespeichert ist, so dass nach dem Laden das Weiterspielen möglich ist.
     *
     * Die Figuren müssen in ihrem korrekten Zustand Gesund/Zombie auf die Position
     * gebracht werden, wie sie gespeichert wurden.
     *
     * @param dateiName Der Name der Datei, wo die gewünschte Spielkonfiguration
     *                  gespeichert ist.
     * @return eine Instanz der Klasse, die IZombieSchluempfe implementiert
     */
    public static IZombieSchluempfe laden(String dateiName) throws Exception {
        FileInputStream fis = new FileInputStream(dateiName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dataspeichern ss= (Dataspeichern) ois.readObject();
        return ss.getBs();
    }
}