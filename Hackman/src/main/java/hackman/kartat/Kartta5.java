package hackman.kartat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import java.util.Random;

/**
 * Pelin viides kartta.
 * @author Oce
 */
public class Kartta5 extends Kartta {

    /**
     * Luo seinät ja bitit kartalle.
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     */
    public Kartta5(int leveys, int korkeus) {
        super(leveys, korkeus);
        for (int i = 3; i < this.korkeus - 2; i += new Random().nextInt(2) + 1) {
            for (int j = 3; j < this.leveys - 2; j += new Random().nextInt(2) + 1) {
                if (i != 10 && j != 10) {
                    super.seinat.add(new Palikka(j, i));
                }
            }
        }

        for (int i = 2; i <= this.leveys - 2; i++) {
            this.bitit.add(new Bitti(i, 2));
        }
        for (int i = 2; i <= this.leveys - 2; i++) {
            this.bitit.add(new Bitti(i, 18));
        }
        for (int i = 2; i <= this.korkeus - 2; i++) {
            this.bitit.add(new Bitti(2, i));
        }
        for (int i = 2; i <= this.korkeus - 2; i++) {
            this.bitit.add(new Bitti(18, i));
        }
        for (int i = 2; i <= this.leveys - 2; i++) {
            if (i != 10) {
                this.bitit.add(new Bitti(i, 10));
            }
        }
        for (int i = 2; i <= this.korkeus - 2; i++) {
            if (i != 10) {
                this.bitit.add(new Bitti(10, i));
            }
        }
    }

    @Override
    public String toString() {
        return "Kartta5";
    }
    
    

}
