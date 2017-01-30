package hackman.peli;

import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Vihollinen;
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

        for (int i = 0; i <= leveys; i++) {
            this.seinat.add(new Palikka(i, 1));
        }
        for (int j = 0; j <= korkeus; j++) {
            this.seinat.add(new Palikka(1, j));
        }
        for (int i = leveys; i >= 0; i--) {
            this.seinat.add(new Palikka(leveys - 1, i));
        }
        for (int i = korkeus; i >= 0; i--) {
            this.seinat.add(new Palikka(i, korkeus - 1));
        }

        for (int i = 3; i <= leveys - 3; i++) {
            for (int j = 3; j <= leveys - 3; j++) {
                this.seinat.add(new Palikka(j, i));
                j++;
            }
            i++;
        }
        for (int i = 2; i < leveys-1; i++) {
            for (int k = 2; k < korkeus-1; k++) {
                this.bitit.add(new Bitti(i, k));
                k++;
            }
            i++;
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
            if (hahmo.getSuunta() == Suunta.ALAS && hahmo.getHahmo().getX() == seina.getX() && hahmo.getHahmo().getY() + 1 == seina.getY()) {
                return true;
            }
            if (hahmo.getSuunta() == Suunta.YLOS && hahmo.getHahmo().getX() == seina.getX() && hahmo.getHahmo().getY() - 1 == seina.getY()) {
                return true;
            }
            if (hahmo.getSuunta() == Suunta.OIKEA && hahmo.getHahmo().getX() + 1 == seina.getX() && hahmo.getHahmo().getY() == seina.getY()) {
                return true;
            }
            if (hahmo.getSuunta() == Suunta.VASEN && hahmo.getHahmo().getX() - 1 == seina.getX() && hahmo.getHahmo().getY() == seina.getY()) {
                return true;
            }
        }
        return false;
    }
    
        public boolean osuuSeinaan(Vihollinen vihu) {
        for (Palikka seina : seinat) {
            if (vihu.getSuunta() == Suunta.ALAS && vihu.getHahmo().getX() == seina.getX() && vihu.getHahmo().getY() + 1 == seina.getY()) {
                return true;
            }
            if (vihu.getSuunta() == Suunta.YLOS && vihu.getHahmo().getX() == seina.getX() && vihu.getHahmo().getY() - 1 == seina.getY()) {
                return true;
            }
            if (vihu.getSuunta() == Suunta.OIKEA && vihu.getHahmo().getX() + 1 == seina.getX() && vihu.getHahmo().getY() == seina.getY()) {
                return true;
            }
            if (vihu.getSuunta() == Suunta.VASEN && vihu.getHahmo().getX() - 1 == seina.getX() && vihu.getHahmo().getY() == seina.getY()) {
                return true;
            }
        }
        return false;
    }

}
