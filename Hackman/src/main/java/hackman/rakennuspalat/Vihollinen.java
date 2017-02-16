package hackman.rakennuspalat;

import java.util.Random;

/**
 * Peruslogiikka pelissä nähtäville vihollisille.
 *
 * @author Oce
 */
public class Vihollinen extends Palikka {

    /**
     * Konstruktori Viholliselle, joka asettaa alkukoordinaatit parametrien mukaan.
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
    public Vihollinen(int x, int y) {
        super(x, y);
    }

    /**
     * Muuttaa mustan vihollisen suuntaa sen mukaan, missä päin pelaaja on.
     *
     * @param pelaaja Pelihahmo, johon koordinaatteja verrataan.
     */
    public void liikuVihollinenMus(Pelihahmo pelaaja) {
        if (pelaaja.getX() == this.getX() && pelaaja.getY() <= this.getY()) {
            this.setSuunta(Suunta.YLOS);
        }
        if (pelaaja.getX() == this.getX() && pelaaja.getY() > this.getY()) {
            this.setSuunta(Suunta.ALAS);
        }
        if (pelaaja.getX() <= this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.VASEN);
        }
        if (pelaaja.getX() > this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.OIKEA);
        }
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

    /**
     * Muuttaa keltaisen vihollisen suuntaa pelaajaa kohti, jos Y-koordinaatit
     * ovat samat.
     *
     * @param pelaaja Pelihahmo, johon koordinaatteja verrataan.
     */
    public void liikuVihollinenKel(Pelihahmo pelaaja) {
        if (pelaaja.getX() <= this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.VASEN);
        }
        if (pelaaja.getX() > this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.OIKEA);
        }
    }

    /**
     * Muuttaa pinkin vihollisen suuntaa pelaajaa kohti, jos X-koordinaatit ovat
     * samat.
     *
     * @param pelaaja Pelihahmo, johon koordinaatteja verrataan.
     */
    public void liikuVihollinenPin(Pelihahmo pelaaja) {
        if (pelaaja.getX() == this.getX() && pelaaja.getY() <= this.getY()) {
            this.setSuunta(Suunta.YLOS);
        }
        if (pelaaja.getX() == this.getX() && pelaaja.getY() > this.getY()) {
            this.setSuunta(Suunta.ALAS);
        }
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}
