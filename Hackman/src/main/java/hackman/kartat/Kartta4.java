package hackman.kartat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;

/**
 *
 * @author Oce
 */
public class Kartta4 extends Kartta {

    public Kartta4(int leveys, int korkeus) {
        super(leveys, korkeus);
        this.lisaaLaatikonUlkoseinat();
        this.lisaaLaatikonKeskus();
        for (int i = 2; i < leveys - 1; i++) {
            for (int k = 2; k <= leveys - 1; k++) {
                if ((i != 10 || k != 10) && (i != 6 || k != 6) && (i != 14 || k != 14) && (i != 6 || k != 14) && (i != 14 || k != 6)) {
                    super.bitit.add(new Bitti(i, k));
                }
                k++;
            }
            i++;
        }
    }

    public void lisaaLaatikonKeskus() {
        for (int i = 5; i <= 7; i++) {
            for (int j = 5; j <= 7; j++) {
                super.seinat.add(new Palikka(i, j));
            }
        }
        for (int i = 5; i <= 7; i++) {
            for (int j = 13; j <= 15; j++) {
                super.seinat.add(new Palikka(i, j));
            }
        }
        for (int i = 13; i <= 15; i++) {
            for (int j = 5; j <= 7; j++) {
                super.seinat.add(new Palikka(i, j));
            }
        }
        for (int i = 13; i <= 15; i++) {
            for (int j = 13; j <= 15; j++) {
                super.seinat.add(new Palikka(i, j));
            }
        }
    }

    public void lisaaLaatikonUlkoseinat() {
        for (int i = 3; i <= super.korkeus / 2 - 1; i++) {
            for (int j = 3; j <= super.leveys - 3; j += 8) {
                super.seinat.add(new Palikka(j, i));
            }
        }
        for (int i = 3; i <= super.korkeus / 2 - 1; i++) {
            for (int j = 9; j <= super.leveys - 3; j += 8) {
                super.seinat.add(new Palikka(j, i));
            }
        }

        for (int i = super.korkeus / 2 + 1; i <= super.korkeus - 3; i++) {
            for (int j = 3; j <= super.korkeus - 3; j += 8) {
                super.seinat.add(new Palikka(j, i));
            }
        }
        for (int i = super.korkeus / 2 + 1; i <= super.korkeus - 3; i++) {
            for (int j = 9; j <= super.leveys - 3; j += 8) {
                super.seinat.add(new Palikka(j, i));
            }
        }

        for (int i = 4; i <= 8; i++) {
            for (int j = 3; j <= super.korkeus - 3; j += 8) {
                if (i != 6) {
                    super.seinat.add(new Palikka(i, j));
                }
            }
        }
        for (int i = 4; i <= 8; i++) {
            for (int j = 9; j <= super.korkeus - 3; j += 8) {
                if (i != 6) {
                    super.seinat.add(new Palikka(i, j));
                }
            }
        }
        for (int i = 12; i <= 16; i++) {
            for (int j = 3; j <= super.korkeus - 3; j += 8) {
                if (i != 14) {
                    super.seinat.add(new Palikka(i, j));
                }
            }
        }
        for (int i = 12; i <= 16; i++) {
            for (int j = 9; j <= korkeus - 3; j += 8) {
                if (i != 14) {
                    super.seinat.add(new Palikka(i, j));
                }
            }
        }
    }

        @Override
    public String toString() {
        return "Kartta4";
    }
}
