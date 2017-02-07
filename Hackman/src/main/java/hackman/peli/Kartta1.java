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
public class Kartta1 extends Kartta {

    private int korkeus;
    private int leveys;
//    private List<Palikka> seinat;
//    private List<Bitti> bitit;
//    private List<Vihollinen> vihut;

    public Kartta1(int leveys, int korkeus) {
        super(leveys, korkeus);
//        this.korkeus = korkeus;
//        this.leveys = leveys;
//        this.seinat = new ArrayList<>();
//        this.bitit = new ArrayList<>();
//        this.vihut = new ArrayList<>();

//        for (int i = 0; i <= leveys; i++) {
//            this.seinat.add(new Palikka(i, 1));
//        }
//        for (int j = 0; j <= korkeus; j++) {
//            this.seinat.add(new Palikka(1, j));
//        }
//        for (int i = leveys; i >= 0; i--) {
//            this.seinat.add(new Palikka(leveys - 1, i));
//        }
//        for (int i = korkeus; i >= 0; i--) {
//            this.seinat.add(new Palikka(i, korkeus - 1));
//        }
        for (int i = 3; i <= leveys - 3; i++) {
            for (int j = 3; j <= leveys - 3; j++) {
                super.seinat.add(new Palikka(j, i));
                j++;
            }
            i++;
        }
        for (int i = 2; i < leveys - 1; i++) {
            for (int k = 2; k < korkeus - 1; k++) {
                if (i != 10 || k != 10) {
                    super.bitit.add(new Bitti(i, k));
                }
                k++;
            }
            i++;
        }

    }

//    public List<Bitti> getBitit() {
//        return this.bitit;
//    }
//
//    public List<Palikka> getSeinat() {
//        return this.seinat;
//    }
//    public List<Vihollinen> getVihut() {
//        return vihut;
//    }
//    public boolean osuuSeinaan(Palikka hahmo) {
//        for (Palikka seina : seinat) {
//            if (hahmo.getSuunta() == Suunta.ALAS && hahmo.getX() == seina.getX() && hahmo.getY() + 1 == seina.getY()) {
//                return true;
//            }
//            if (hahmo.getSuunta() == Suunta.YLOS && hahmo.getX() == seina.getX() && hahmo.getY() - 1 == seina.getY()) {
//                return true;
//            }
//            if (hahmo.getSuunta() == Suunta.OIKEA && hahmo.getX() + 1 == seina.getX() && hahmo.getY() == seina.getY()) {
//                return true;
//            }
//            if (hahmo.getSuunta() == Suunta.VASEN && hahmo.getX() - 1 == seina.getX() && hahmo.getY() == seina.getY()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    @Override
//    public String toString() {
//        return "Koko: " + this.leveys + " * " + this.korkeus + ", bittien määrä: " + this.bitit.size();
//    }
}
