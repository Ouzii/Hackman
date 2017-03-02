package hackman.rakennuspalat;

import hackman.enumit.Suunta;

/**
 * Musta vihollinen, joka jahtaa pelaajaa aina tämän nähdessään.
 *
 * @author Oce
 */
public class VihollinenMus extends Vihollinen {

    /**
     * Luo vihollisen ja asettaa aloituskoordinaatit.
     *
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
    public VihollinenMus(int x, int y) {
        super(x, y);
        super.setSuunta(Suunta.YLOS);
    }

    /**
     * Muuttaa mustan vihollisen suuntaa sen mukaan, missä päin pelaaja on.
     *
     * @param pelaaja Pelihahmo, johon koordinaatteja verrataan.
     */
    @Override
    public void kaannaVihollinen(Pelihahmo pelaaja) {
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

}
