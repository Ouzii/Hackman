package hackman.rakennuspalat;

import java.util.Random;

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

    public boolean osuu(Palikka palikka) {
        if (this.x == palikka.getX() && this.y == palikka.getY()) {
            return true;
        } else {
            return false;
        }
    }

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

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
