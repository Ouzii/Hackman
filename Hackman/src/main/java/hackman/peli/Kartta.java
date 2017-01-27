package hackman.peli;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oce
 */
public class Kartta {
    
    private List<Palikka> seinat;
    private List<Bitti> bitit;

    public Kartta(int leveys, int korkeus) {
        this.seinat = new ArrayList<>();
        this.bitit = new ArrayList<>();
        int i = 0;
        while(i<leveys) {
            this.seinat.add(new Palikka(i, 0));
        }
        i = 0;
        while(i<korkeus) {
            this.seinat.add(new Palikka(0, i));
        }
    }

    public List<Bitti> getBitit() {
        return this.bitit;
    }

    public List<Palikka> getSeinat() {
        return this.seinat;
    }
    
    
    
    
    
}
