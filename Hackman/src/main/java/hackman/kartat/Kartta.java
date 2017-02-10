package hackman.kartat;

import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Vihollinen;
import java.util.ArrayList;
import java.util.List;

/**
 * Perusta pelissä pelattaville kartoille.
 *
 * @author Oce
 */
public class Kartta {

    private int korkeus;
    private int leveys;
    public List<Palikka> seinat;
    public List<Bitti> bitit;
    private Vihollinen vihuPun;
    private Vihollinen vihuMus;
    private Vihollinen vihuKel;
    private Vihollinen vihuPin;

    public Kartta(int leveys, int korkeus) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.seinat = new ArrayList<>();
        this.bitit = new ArrayList<>();
        this.vihuPun = new Vihollinen(2, 2);
        this.vihuPun.setSuunta(Suunta.ALAS);
        this.vihuMus = new Vihollinen(leveys - 2, korkeus - 2);
        this.vihuMus.setSuunta(Suunta.YLOS);
        this.vihuKel = new Vihollinen(leveys - 2, 2);
        this.vihuKel.setSuunta(Suunta.VASEN);
        this.vihuPin = new Vihollinen(2, korkeus - 2);
        this.vihuPin.setSuunta(Suunta.OIKEA);

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
    }

    public List<Bitti> getBitit() {
        return this.bitit;
    }

    public List<Palikka> getSeinat() {
        return this.seinat;
    }

    public Vihollinen getVihuPun() {
        return this.vihuPun;
    }

    public Vihollinen getVihuMus() {
        return this.vihuMus;
    }

    public Vihollinen getVihuKel() {
        return this.vihuKel;
    }

    public Vihollinen getVihuPin() {
        return this.vihuPin;
    }

    public boolean liikuVihollinen(Vihollinen vihollinen) {
        int a = 0;
        for (Palikka seina : this.seinat) {
            if (!this.osuuSeinaan(vihollinen)) {
                a++;
            }
        }
        if (a >= this.korkeus) {
            vihollinen.liiku();
            return true;
        } else {
            vihollinen.vaihdaSuunta();
            return false;
        }
    }

    public boolean osuuSeinaan(Palikka hahmo) {
        for (Palikka seina : seinat) {
            if (hahmo.getSuunta() == Suunta.ALAS && hahmo.getX() == seina.getX() && hahmo.getY() + 1 == seina.getY()) {
                return true;
            }
            if (hahmo.getSuunta() == Suunta.YLOS && hahmo.getX() == seina.getX() && hahmo.getY() - 1 == seina.getY()) {
                return true;
            }
            if (hahmo.getSuunta() == Suunta.OIKEA && hahmo.getX() + 1 == seina.getX() && hahmo.getY() == seina.getY()) {
                return true;
            }
            if (hahmo.getSuunta() == Suunta.VASEN && hahmo.getX() - 1 == seina.getX() && hahmo.getY() == seina.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Koko: " + this.leveys + " * " + this.korkeus + ", bittien määrä: " + this.bitit.size();
    }

}
