package hackman.rakennuspalat;

import java.util.Random;

/**
 * Rakennuspalikka kaikille piirrettäville elementeille pelissä.
 *
 * @author Oce
 */
public class Palikka {

    public int x;
    public int y;
    private Suunta suunta;

    public Palikka(int x, int y) {
        this.x = x;
        this.y = y;
        this.suunta = Suunta.VASEN;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Suunta getSuunta() {
        return this.suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Metodi tarkistaa osuuko olio parametrina annettuun palikkaan.
     * @param palikka tarkistettava palikka.
     * @return true, jos osuu ja false, jos ei osu
     */
    public boolean osuu(Palikka palikka) {
        if (this.x == palikka.getX() && this.y == palikka.getY()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Metodi tarkistaa, onko parametrina annetun palikan edessä seinää.
     * @param seina tarkistettava seinä.
     * @return true, jos on seinä edessä ja false, jos ei ole.
     */
    public boolean osuuSeinaan(Palikka seina) {
        if (this.suunta == Suunta.ALAS && this.getY() + 1 == seina.getY() && this.getX() == seina.getX()) {
            return true;
        }
        if (this.suunta == Suunta.YLOS && this.getY() - 1 == seina.getY() && this.getX() == seina.getX()) {
            return true;
        }
        if (this.suunta == Suunta.OIKEA && this.getY() == seina.getY() && this.getX() + 1 == seina.getX()) {
            return true;
        }
        if (this.suunta == Suunta.VASEN && this.getY() == seina.getY() && this.getX() - 1 == seina.getX()) {
            return true;
        }

        return false;
    }
    /**
     * Siirtää olion X- tai Y-koordinaattia suunnan mukaan.
     * @return true, jos liikutaan ja false, jos suuntaa ei ole määritetty.
     */
    public boolean liiku() {
        if (null != this.suunta) {
            switch (this.suunta) {
                case ALAS:
                    this.setY(this.getY() + 1);
                    return true;
                case YLOS:
                    this.setY(this.getY() - 1);
                    return true;
                case OIKEA:
                    this.setX(this.getX() + 1);
                    return true;
                case VASEN:
                    this.setX(this.getX() - 1);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
