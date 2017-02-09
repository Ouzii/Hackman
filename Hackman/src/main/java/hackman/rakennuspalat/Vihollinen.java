package hackman.rakennuspalat;

import java.util.Random;

public class Vihollinen extends Palikka {

    public Vihollinen(int x, int y) {
        super(x, y);
        int r = new Random().nextInt(4) - 1;
        super.vaihdaSuunta();
    }

    public void liikuVihollinenMus(Pelihahmo pelaaja) {
        if (pelaaja.getX() == this.getX() && pelaaja.getY() < this.getY()) {
            this.setSuunta(Suunta.YLOS);
        }
        if (pelaaja.getX() == this.getX() && pelaaja.getY() > this.getY()) {
            this.setSuunta(Suunta.ALAS);
        }
        if (pelaaja.getX() < this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.VASEN);
        }
        if (pelaaja.getX() > this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.OIKEA);
        }
    }

    public void liikuVihollinenKel(Pelihahmo pelaaja) {
        if (pelaaja.getX() < this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.VASEN);
        }
        if (pelaaja.getX() > this.getX() && pelaaja.getY() == this.getY()) {
            this.setSuunta(Suunta.OIKEA);
        }
    }

    public void liikuVihollinenPin(Pelihahmo pelaaja) {
        if (pelaaja.getX() == this.getX() && pelaaja.getY() < this.getY()) {
            this.setSuunta(Suunta.YLOS);
        }
        if (pelaaja.getX() == this.getX() && pelaaja.getY() > this.getY()) {
            this.setSuunta(Suunta.ALAS);
        }
    }

}
