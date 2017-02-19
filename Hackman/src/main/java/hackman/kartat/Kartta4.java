package hackman.kartat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;

/**
 * Pelin neljäs kartta.
 *
 * @author Oce
 */
public class Kartta4 extends Kartta {

    /**
     * Luo seinät ja bitit kartalle.
     *
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     */
    public Kartta4(int leveys, int korkeus) {
        super(leveys, korkeus);
        this.luoSeinat();
        this.luoBitit();
    }

    private void luoSeinat() {
        this.lisaaLaatikonUlkoseinat();
        this.lisaaLaatikonKeskus();
    }

    private void luoBitit() {
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

    private void lisaaLaatikonKeskus() {
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

    private void lisaaLaatikonUlkoseinat() {
        this.ulkoSeinatYlariviPysty();
        this.ulkoSeinatAlariviPysty();
        this.ulkoSeinatVasenPuoliVaaka();
        this.ulkoSeinatOikeaPuoliVaaka();
    }

    private void ulkoSeinatYlariviPysty() {
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
    }

    private void ulkoSeinatAlariviPysty() {
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
    }

    private void ulkoSeinatVasenPuoliVaaka() {
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
    }

    private void ulkoSeinatOikeaPuoliVaaka() {
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
