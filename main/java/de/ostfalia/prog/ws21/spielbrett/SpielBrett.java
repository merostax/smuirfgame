package de.ostfalia.prog.ws21.spielbrett;
import de.ostfalia.prog.ws21.felder.Dorf;
import de.ostfalia.prog.ws21.felder.Fluss;
import de.ostfalia.prog.ws21.felder.Fussfelder;
import de.ostfalia.prog.ws21.felder.Pilz;
import de.ostfalia.prog.ws21.felder.StartFeld;
import de.ostfalia.prog.ws21.felder.Tuberose;
import de.ostfalia.prog.ws21.felder.Verzweigungsfeld;
import de.ostfalia.prog.ws21.interfaces.Feld;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class SpielBrett implements Serializable {
    public List<Feld> getFelder() {
        return felder;
    }

    /**
     * felder
     */
    private List<Feld> felder = new ArrayList<>(37);
    /**
     * Spielbrett constructor
     */
    public SpielBrett() {
        for (int i = 0; i < 37; i++) {
            felder.add(new Fussfelder(i));
        }
        felder.set(0, new StartFeld(felder.get(1), 0));
        felder.set(11, new Tuberose(felder.get(12), 11));
        felder.set(16, new Fluss(felder.get(17), 16));
        felder.set(26, new Fluss(felder.get(27), 26));
        felder.set(17, new Fluss(felder.get(18), 17));
        felder.set(25, new Fluss(felder.get(26), 25));
        felder.set(27, new Fluss(felder.get(28), 27));
        felder.set(24, new Pilz(felder.get(25), 24, felder.get(0)));
        felder.set(36, new Dorf(36));
        felder.set(3, new Verzweigungsfeld(3, felder.get(8)));
        felder.set(31, new Verzweigungsfeld(31, felder.get(36)));
        for (int i = 0; i < 37; i++) {
            felder.get(i).setNachsteFeld(felder.get(i % 36 + 1));
        }
        felder.get(36).setNachsteFeld(felder.get(36));
        felder.get(35).setNachsteFeld(felder.get(1));
        felder.get(7).setNachsteFeld(felder.get(15));
    }

//    /**
//     * @return tostring
//     */
//    @Override
//    public String toString() {
//        StringJoiner sj = new StringJoiner(", ", "[", "]");
//        for (Feld feld : felder) {
//            if (felder.size() > 0) {
//                sj.add(feld.toString() + felder.indexOf(feld));
//
//            }
//        }
//        return sj.toString();
//    }


}


