package hackman.kartat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;

/**
 *
 * @author Oce
 */
public class Kartta3 extends Kartta {

    public Kartta3(int leveys, int korkeus) {
        super(leveys, korkeus);
        for (int i = 3; i <= leveys - 3; i++) {
            for (int j = 3; j <= leveys - 3; j++) {
                if (i != 10) {
                    super.seinat.add(new Palikka(j, i));
                }
                j++;
            }
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

    @Override
    public String toString() {
        return "Kartta3";
    }

    
}
