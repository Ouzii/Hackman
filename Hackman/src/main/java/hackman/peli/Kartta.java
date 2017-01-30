package hackman.peli;

import hackman.paaohjelma.Suunta;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
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
        
        for (int i = 0; i <= leveys+1; i++) {
            this.seinat.add(new Palikka(i, 1));
        }
        for (int j = 0; j <= korkeus+1; j++) {
            this.seinat.add(new Palikka(1, j));
        }
        for (int i = leveys+1; i >= 0; i--) {
            this.seinat.add(new Palikka(leveys, i));
        }
        for (int i = korkeus+1; i >= 0; i--) {
            this.seinat.add(new Palikka(i, korkeus));
        }
    }

    public List<Bitti> getBitit() {
        return this.bitit;
    }

    public List<Palikka> getSeinat() {
        return this.seinat;
    }

    public boolean osuuSeinaan(Pelihahmo hahmo) {
        for (Palikka seina : seinat) {
            if(hahmo.getSuunta() == Suunta.ALAS && hahmo.getHahmo().getX() == seina.getX() && hahmo.getHahmo().getY()+1 == seina.getY()) {
                return true;
            }
            if(hahmo.getSuunta() == Suunta.YLOS && hahmo.getHahmo().getX() == seina.getX() && hahmo.getHahmo().getY()-1 == seina.getY()) {
                return true;
            }
            if(hahmo.getSuunta() == Suunta.OIKEA && hahmo.getHahmo().getX()+1 == seina.getX() && hahmo.getHahmo().getY() == seina.getY()) {
                return true;
            }
            if(hahmo.getSuunta() == Suunta.VASEN && hahmo.getHahmo().getX()-1 == seina.getX() && hahmo.getHahmo().getY() == seina.getY()) {
                return true;
            }
//            if (hahmo.osuuSeinaan(seina)) {
//                return true;
//            }
        }
        return false;
    }

}
