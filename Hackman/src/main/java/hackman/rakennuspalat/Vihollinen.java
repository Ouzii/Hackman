package hackman.rakennuspalat;

import hackman.paaohjelma.Suunta;
import java.util.Random;

public class Vihollinen {

    private Palikka hahmo;
    private Suunta suunta;

    public Vihollinen(int x, int y) {
        this.hahmo = new Palikka(x, y);
        this.suunta = Suunta.ALAS;
    }

    public Palikka getHahmo() {
        return hahmo;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public void vaihdaSuunta() {
        int i = new Random().nextInt(3);
        if (i == 0) {
            setSuunta(Suunta.ALAS);
        }

        if (i == 1) {
            setSuunta(Suunta.YLOS);
        }

        if (i == 2) {
            setSuunta(Suunta.OIKEA);
        }

        if (i == 3) {
            setSuunta(Suunta.VASEN);
        }

    }

    public boolean liiku() {

        if (null != this.suunta) {
            switch (this.suunta) {
                case ALAS:
                    hahmo.setY(hahmo.getY() + 1);
                    return true;
                case YLOS:
                    hahmo.setY(hahmo.getY() - 1);
                    return true;
                case OIKEA:
                    hahmo.setX(hahmo.getX() + 1);
                    return true;
                case VASEN:
                    hahmo.setX(hahmo.getX() - 1);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public boolean osuuSeinaan(Palikka seina) {
        if (this.suunta == Suunta.ALAS && this.hahmo.getY() + 1 == seina.getY() && this.hahmo.getX() == seina.getX()) {
            return true;
        }
        if (this.suunta == Suunta.YLOS && this.hahmo.getY() - 1 == seina.getY() && this.hahmo.getX() == seina.getX()) {
            return true;
        }
        if (this.suunta == Suunta.OIKEA && this.hahmo.getY() == seina.getY() && this.hahmo.getX() + 1 == seina.getX()) {
            return true;
        }
        if (this.suunta == Suunta.VASEN && this.hahmo.getY() == seina.getY() && this.hahmo.getX() - 1 == seina.getX()) {
            return true;
        }

        return false;
    }
}
