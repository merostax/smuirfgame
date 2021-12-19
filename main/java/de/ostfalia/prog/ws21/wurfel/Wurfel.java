package de.ostfalia.prog.ws21.wurfel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Wurfel {
    String schlumpfine = "Schlumpfine";
    String bzz = "Bzz";
    List<String> list = Arrays.asList(schlumpfine, bzz, "1", "2", "3", "4", "5");

    public String wurfel() {
        Random r = new Random();
        int augenzahl = r.nextInt(7) ;

        return list.get(augenzahl);
    }

    public static void main(String[] args) {
        Wurfel wurfel = new Wurfel();
        String wurfelName = wurfel.wurfel();
        int augenzahl;
        if (wurfelName.equals("Bzz") || wurfelName.equals("Schlumpfine")) {
            System.out.println(" Sie haben den Figur " + wurfelName + " gewurfelt");
            wurfelName = wurfel.wurfel();
            while (wurfelName.equals("Bzz") || wurfelName.equals("Schlumpfine")) {
                wurfelName = wurfel.wurfel();
            }
        }
        augenzahl = Integer.parseInt(wurfelName);
        System.out.println("Sie haben " + augenzahl + "   gweurfelt");
    }
}

