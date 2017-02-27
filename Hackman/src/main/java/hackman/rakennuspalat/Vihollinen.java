package hackman.rakennuspalat;

import hackman.enumit.Suunta;
import java.util.Random;

/**
 * Peruslogiikka pelissä nähtäville vihollisille.
 *
 * @author Oce
 */
public class Vihollinen extends Palikka {

    /**
     * Konstruktori Viholliselle, joka asettaa alkukoordinaatit parametrien
     * mukaan.
     *
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
    public Vihollinen(int x, int y) {
        super(x, y);
    }

    /**
     * Overridattava metodi vihollisille, jotta eri vihollisilla voi olla
     * erilaiset tekoälyt kääntymiseen.
     *
     * @param pelaaja Pelin pelaajan ohjaama pelihahmo.
     */
    public void kaannaVihollinen(Pelihahmo pelaaja) {

    }

    /**
     * Vaihtaa vihollisen suunnan satunnaiseksi suunnaksi.
     *
     * @return true, jos suunta muuttuu ja false, jos ei.
     */
    public boolean vaihdaSuunta() {

        int i = new Random().nextInt(4) + 1;
        if (i == 1) {
            setSuunta(Suunta.ALAS);
            return true;
        }
        if (i == 2) {
            setSuunta(Suunta.YLOS);
            return true;
        }
        if (i == 3) {
            setSuunta(Suunta.OIKEA);
            return true;
        }
        if (i == 4) {
            setSuunta(Suunta.VASEN);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}
