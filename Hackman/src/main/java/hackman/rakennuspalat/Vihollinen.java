package hackman.rakennuspalat;

import java.util.Random;

/**
 * Rakennusosat pelissä nähtäville vihollisille.
 *
 * @author Oce
 */
public class Vihollinen extends Palikka {

    public Vihollinen(int x, int y) {
        super(x, y);
    }

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

    public boolean vaihdaSuunta() {

        int i = new Random().nextInt(3) + 1;
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

    public void liikuVihollinenKel(Pelihahmo pelaaja) {
        if (pelaaja.getX() <= this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.VASEN);
        }
        if (pelaaja.getX() > this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.OIKEA);
        }
    }

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
