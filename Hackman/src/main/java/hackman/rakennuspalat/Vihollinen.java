package hackman.rakennuspalat;

import java.util.Random;

public class Vihollinen {

    private Palikka hahmo;
    private Suunta suunta;
//    private int askelia;

    public Vihollinen(int x, int y) {
        this.hahmo = new Palikka(x, y);
        this.suunta = Suunta.ALAS;
//        this.askelia = 0;
    }

    public Palikka getHahmo() {
        return hahmo;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public void vaihdaSuunta() {
//        this.askelia = 0;
        int i = new Random().nextInt(3) + 1;
        if (i == 1) {
            setSuunta(Suunta.ALAS);
        }

        if (i == 2) {
            setSuunta(Suunta.YLOS);
        }

        if (i == 3) {
            setSuunta(Suunta.OIKEA);
        }

        if (i == 4) {
            setSuunta(Suunta.VASEN);
        }

    }

    public boolean liiku() {
//        if (this.askelia >= 5) {
//            this.vaihdaSuunta();
//        } else {
//            this.askelia++;
//        }
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
