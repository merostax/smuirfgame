package de.ostfalia.prog.ws21.mainZomieschlumpfe;

import de.ostfalia.prog.ws21.dataspeichern.Dataspeichern;
import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.exceptions.FalscheSpielerzahlException;
import de.ostfalia.prog.ws21.exceptions.UngueltigePositionException;
import de.ostfalia.prog.ws21.exceptions.WiederholteFarbenException;
import de.ostfalia.prog.ws21.figuren.Bzz;
import de.ostfalia.prog.ws21.interfaces.Feld;
import de.ostfalia.prog.ws21.interfaces.Figur;
import de.ostfalia.prog.ws21.figuren.Oberschlump;
import de.ostfalia.prog.ws21.figuren.Schlmpfine;
import de.ostfalia.prog.ws21.figuren.Schlumpf;
import de.ostfalia.prog.ws21.interfaces.ISpeicherbar;
import de.ostfalia.prog.ws21.interfaces.IZombieSchluempfe;
import de.ostfalia.prog.ws21.iterator.PlayerIterator;
import de.ostfalia.prog.ws21.spielbrett.SpielBrett;
import de.ostfalia.prog.ws21.wurfel.Wurfel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ZombieSchluempfe implements IZombieSchluempfe, ISpeicherbar, Serializable {

    private SpielBrett spielBrett = new SpielBrett();
    private List<Feld> felder = spielBrett.getFelder();
    private Farbe currentPlayer;
    private List<Figur> listfiguren = new ArrayList<>();
    private PlayerIterator playerIterator;
    private LinkedList<Farbe> players;


    public ZombieSchluempfe(Farbe... farben) throws FalscheSpielerzahlException, WiederholteFarbenException {
        addPlayers(farben);
        addfigurentoList(farben);
    }

    private void addPlayers(Farbe[] farben) throws FalscheSpielerzahlException, WiederholteFarbenException {

        playerIterator = new PlayerIterator(new LinkedList<>(Arrays.asList(farben)));
        players = playerIterator.getPlayers();
        checkFarben(farben);
        currentPlayer = playerIterator.getCurrentPlayer();
    }

    /**
     * @param conf   conf
     * @param farben farben
     */
    public ZombieSchluempfe(String conf, Farbe... farben)
            throws FalscheSpielerzahlException, WiederholteFarbenException, UngueltigePositionException {
        this(farben);
        String[] config = conf.split(",");
        for (String bb : config) {
            String[] cc = bb.trim().split(":");
            int positionFigur = Integer.parseInt(cc[1]);
            checkconf(cc, positionFigur);
            Figur ff = getfigur(cc[0]);
            ff.setZombie(cc.length > 2 && cc[2].equals("Z"));
            ff.setFeld(felder.get(positionFigur));
        }
    }

    public void addfigurentoList(Farbe... farbe) {
        for (Farbe ff : farbe) {
            Collections.addAll(listfiguren,
                    new Schlumpf(ff + "-A", ff, false, 0, felder.get(0)),
                    new Schlumpf(ff + "-B", ff, false, 0, felder.get(0)),
                    new Schlumpf(ff + "-C", ff, false, 0, felder.get(0)),
                    new Schlumpf(ff + "-D", ff, false, 0, felder.get(0)),
                    new Bzz("Bzz", true, 20, felder.get(20)),
                    new Oberschlump("Doc", false, 29, felder.get(29)),
                    new Schlmpfine("Schlumpfine", false, 1, felder.get(1)));
        }
    }

    public void checkFarben(Farbe... farbe) throws FalscheSpielerzahlException, WiederholteFarbenException {
        if (farbe.length < 1) {
            throw new FalscheSpielerzahlException("");
        }

        if (players.size() > 4) {
            throw new FalscheSpielerzahlException("Es darf nur 4 Spieler");
        }
        if (players.stream().anyMatch(i -> Collections.frequency(players, i) > 1)) {
            throw new WiederholteFarbenException("Wiederholte Farbe ");
        }
    }

    private void checkconf(String[] cc, int positionFigur) throws UngueltigePositionException, WiederholteFarbenException {
        if (positionFigur < 0 || positionFigur > 36) {
            throw new UngueltigePositionException("Position " + positionFigur + " ungueltig!");
        }
        if (getfigur(cc[0]) == null) {
            throw new WiederholteFarbenException("");
        }

    }

    /**
     * @param figurName - Der Name bzw. die eindeutige Identifikation der Figur,
     *                  welche bewegt werden soll
     * @param augenzahl - Der gewürfelte Wert entspricht die Anzahl von Felder, die
     *                  die Figur vorrücken muss
     * @return boolean
     */
    @Override
    public boolean bewegeFigur(String figurName, int augenzahl) {
        return bewegeFigur(figurName, augenzahl, Richtung.WEITER);
    }

    /**
     * @param figurName - Der Name bzw. die eindeutige Identifikation der Figur,
     *                  welche bewegt werden soll
     * @param augenzahl - Der gewürfelte Wert entspricht die Anzahl von Felder, die
     *                  die Figur vorrücken muss
     * @param richtung  - Richtungsangaben für die Verzweigungsfelder
     * @return rr
     */
    @Override
    public boolean bewegeFigur(String figurName, int augenzahl, Richtung richtung) {
        if (gewinner() == null) {
            currentPlayer = (Farbe) playerIterator.Next();
            return getfigur(figurName).bewegen(augenzahl, richtung, listfiguren);
        }
        return false;
    }
@Override
    public Figur getfigur(String figurName) {
        return listfiguren.stream().filter(s -> s.getNamee().equals(figurName)).findAny().orElse(null);
    }

    /**
     * @param name - Der Name bzw. die eindeutige Identifikation der Figur
     * @return int
     */
    @Override
    public int getFeldnummer(String name) {
        if (getfigur(name) == null) {
            return -1;
        }
        return getfigur(name).getPosition();

    }

    /**
     * @param name - Der Name bzw. die eindeutige Identifikation der Figur
     * @return boolan
     */
    @Override
    public boolean istZombie(String name) {
        if (getfigur(name) == null) {
            return false;
        }
        return getfigur(name).isZombie();
    }

    /**
     * @return zombie
     */
    @Override
    public Farbe getFarbeAmZug() {
        return currentPlayer;
    }

    /**
     * @return winner winner chicken Dinner
     */
    @Override
    public Farbe gewinner() {
        return felder.get(36).gewinner(listfiguren);
    }

    /**
     * @param anzahlspieler a
     * @return farbe
     */
    public static List<Farbe> spieleranzahl(int anzahlspieler) throws FalscheSpielerzahlException {
        if (anzahlspieler > 5) {
            throw new FalscheSpielerzahlException("max spieler 4");
        }
        List<Farbe> a = Arrays.asList(Farbe.GELB, Farbe.ROT, Farbe.BLAU, Farbe.GRUEN);
        List<Farbe> c = new ArrayList<>(anzahlspieler);
        for (int i = 0; i < anzahlspieler; i++) {
            c.add(a.get(i));
        }
        return c;
    }


    @Override
    public String toString() {
        return listfiguren.toString() + "";
    }

    public static void main(String[] args)
            throws UngueltigePositionException, FalscheSpielerzahlException, WiederholteFarbenException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie bitte die Anzahl der Spieler ein:   ");
        int spieleranzahl = scanner.nextInt();

        List<Farbe> anzahlspieler = spieleranzahl(spieleranzahl);
        IZombieSchluempfe spieler = new ZombieSchluempfe(anzahlspieler.toArray(Farbe[]::new));
        Wurfel wurfel = new Wurfel();
        int augenzahl = 0;
        while (spieler.gewinner() == null) {

            System.out.println("Der nachste Spieler ist :" + spieler.getFarbeAmZug());

            String wurfelName = wurfel.wurfel();
            if (wurfelName.equals("Bzz") || wurfelName.equals("Schlumpfine")) {
                System.out.println(" Sie haben den Figur " + wurfelName + " gewurfelt");
                wurfelName = wurfel.wurfel();
                while (wurfelName.equals("Bzz") || wurfelName.equals("Schlumpfine")) {
                    wurfelName = wurfel.wurfel();
                }
            }
            augenzahl = Integer.parseInt(wurfelName);
            System.out.println("Sie haben " + augenzahl + "  gweurfelt");

            System.out.print(spieler);


            System.out.println("Tragen Sie bitte der Name von der Figur ein, dass Sie bewegen mochten: ");
            String figurName = scanner.next();

            Richtung a = Richtung.ABZWEIGEN;
            Richtung b = Richtung.WEITER;


            System.out.println("Wählen Sie bitte eine Richtung : 2 fCr ABZWEIGEN und 1 für WEITER");
            int c = scanner.nextInt();
            switch (c) {
                case 1 -> spieler.bewegeFigur(figurName, augenzahl, b);
                case 2 -> spieler.bewegeFigur(figurName, augenzahl, a);
                default -> {
                }
            }

            System.out.println(spieler);

            System.out.println("Ist " + figurName + " Zombie ? " + spieler.istZombie(figurName));

        }
        System.out.println("der gewinner ist :"+spieler.gewinner());
    }

    /**
     * Die Methode speichert in eine Datei den momentanen Spielzustand, so dass nach
     * dem Laden das Weiterspielen möglich ist.
     *
     * @param dateiName Name der Datei bzw. den kompletten Pfad, wo die Datei
     *                  gespeichert wird
     */
    @Override
    public void speichern(String dateiName) throws IOException {
        FileOutputStream fos = new FileOutputStream(dateiName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Dataspeichern dts = new Dataspeichern();
        dts.setBs(this);
        oos.writeObject(dts);
        oos.close();
        System.out.println("Game saved");

    }

    public static IZombieSchluempfe laden(String dateiName) throws Exception {
        FileInputStream fis = new FileInputStream(dateiName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dataspeichern ss = (Dataspeichern) ois.readObject();
        return ss.getBs();
    }

}