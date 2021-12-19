package de.ostfalia.prog.ws21.dataspeichern;

import de.ostfalia.prog.ws21.interfaces.Figur;
import de.ostfalia.prog.ws21.interfaces.IZombieSchluempfe;
import java.io.Serializable;
import java.util.List;

public class Dataspeichern implements Serializable {
   private List<Figur> fg;

    public List<Figur> getFg() {
        return fg;
    }

    public void setFg(List<Figur> fg) {
        this.fg = fg;
    }

    public IZombieSchluempfe getBs() {
        return bs;
    }

    public void setBs(IZombieSchluempfe bs) {
        this.bs = bs;
    }

   private IZombieSchluempfe bs;
}
