package hackman.rakennuspalat;

import hackman.enumit.Suunta;

/**
 * Pelaajan ohjaaman hahmon peruslogiikka.
 *
 * @author Oce
 */
public class Pelihahmo extends Palikka {

    private boolean elossa;

    /**
     * Luo pelihahmon ja asettaa sen alun koordinaatit parametrien mukaan.
     * Asettaa pelihahmon eläväksi ja suunnan halutuksi.
     *
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     * @param suunta Suunta, joka asetetaan pelihahmolle.
     */
    public Pelihahmo(int x, int y, Suunta suunta) {
        super(x, y, suunta);
        this.elossa = true;
    }

    /**
     * Luo pelihahmon ja asettaa sen alun koordinaatit parametrien mukaan.
     * Asettaa pelihahmon eläväksi.
     *
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
    public Pelihahmo(int x, int y) {
        super(x, y);
        this.elossa = true;
    }

    public boolean isElossa() {
        return this.elossa;
    }

    /**
     * Muuttaa pelihahmon kuolleeksi.
     */
    public void kuole() {
        this.elossa = false;
    }

}
