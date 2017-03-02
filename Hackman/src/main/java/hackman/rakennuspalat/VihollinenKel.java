/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.rakennuspalat;

import hackman.enumit.Suunta;

/**
 * Keltainen vihollinen, joka jahtaa pelaajaa x-akselilla.
 *
 * @author Oce
 */
public class VihollinenKel extends Vihollinen {

    /**
     * Luo vihollisen ja asettaa aloituskoordinaatit.
     *
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
    public VihollinenKel(int x, int y) {
        super(x, y);
        super.setSuunta(Suunta.VASEN);
    }

    /**
     * Muuttaa keltaisen vihollisen suuntaa pelaajaa kohti, jos Y-koordinaatit
     * ovat samat.
     *
     * @param pelaaja Pelihahmo, johon koordinaatteja verrataan.
     */
    @Override
    public void kaannaVihollinen(Pelihahmo pelaaja) {
        if (pelaaja.getX() <= super.getX() && pelaaja.getY() == super.getY()) {
            this.setSuunta(Suunta.VASEN);
        }
        if (pelaaja.getX() > super.getX() && pelaaja.getY() == super.getY()) {
            this.setSuunta(Suunta.OIKEA);
        }
    }
}
