package hackman.kartat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;

/**
 * Pelin toinen kartta.
 *
 * @author Oce
 */
public class Kartta2 extends Kartta {

    /**
     * Luo seinät ja bitit kartalle.
     *
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     */
    public Kartta2(int leveys, int korkeus) {
        super(leveys, korkeus);
        this.luoSeinat();
        this.luoBitit();
    }

    private void luoSeinat() {
        for (int i = 3; i <= leveys - 3; i++) {
            for (int j = 3; j <= leveys - 3; j++) {
                if (j != 10) {
                    super.seinat.add(new Palikka(j, i));
                }
            }
            i++;
        }
    }

    private void luoBitit() {
        for (int i = 2; i < leveys - 1; i++) {
            for (int k = 2; k < korkeus - 1; k++) {
                if (i != 10 || k != 10) {
                    super.bitit.add(new Bitti(i, k));
                }
                k++;
            }
        }
    }

    @Override
    public String toString() {
        return "Kartta2";
    }
}
