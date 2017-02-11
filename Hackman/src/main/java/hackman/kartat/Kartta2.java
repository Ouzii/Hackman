package hackman.kartat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import java.util.ArrayList;
import java.util.List;

/**
 * Pelin toinen kartta.
 *
 * @author Oce
 */
public class Kartta2 extends Kartta {

    public Kartta2(int leveys, int korkeus) {
        super(leveys, korkeus);
        for (int i = 3; i <= leveys - 3; i++) {
            for (int j = 3; j <= leveys - 3; j++) {
                if (j != 10) {
                    super.seinat.add(new Palikka(j, i));
                }
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
        }

    }

    @Override
    public String toString() {
        return "Kartta2";
    }
}
