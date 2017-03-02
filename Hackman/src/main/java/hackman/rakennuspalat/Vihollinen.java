package hackman.rakennuspalat;

import hackman.enumit.Suunta;

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
        super.setSuunta(Suunta.ALAS);
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
     * @param random satunnainen (pelissä, testeissä ennalta määrätty)
     * kokonaisluku, jolla päätetään mihin suuntaan käännytään.
     *
     * @return true, jos suunta muuttuu ja false, jos ei.
     */
    public boolean vaihdaSuunta(int random) {

        if (random == 1) {
            setSuunta(Suunta.ALAS);
            return true;
        }
        if (random == 2) {
            setSuunta(Suunta.YLOS);
            return true;
        }
        if (random == 3) {
            setSuunta(Suunta.OIKEA);
            return true;
        }
        if (random == 4) {
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
