package hackman.rakennuspalat;

import hackman.enumit.Suunta;

/**
 * Pinkki vihollinen, joka jahtaa pelaajaa y-akselilla.
 * @author Oce
 */
public class VihollinenPin extends Vihollinen {
    
    /**
     * Luo vihollisen ja asettaa aloituskoordinaatit.
     *
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
    public VihollinenPin(int x, int y) {
        super(x, y);
    }

    /**
     * Muuttaa pinkin vihollisen suuntaa pelaajaa kohti, jos X-koordinaatit ovat
     * samat.
     *
     * @param pelaaja Pelihahmo, johon koordinaatteja verrataan.
     */
    @Override
    public void kaannaVihollinen(Pelihahmo pelaaja) {
        if (pelaaja.getX() == super.getX() && pelaaja.getY() <= super.getY()) {
            this.setSuunta(Suunta.YLOS);
        }
        if (pelaaja.getX() == super.getX() && pelaaja.getY() > super.getY()) {
            this.setSuunta(Suunta.ALAS);
        }
    }

}
