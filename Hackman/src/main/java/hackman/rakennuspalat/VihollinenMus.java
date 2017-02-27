/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
