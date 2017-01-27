package hackman.rakennuspalat;

import hackman.paaohjelma.Suunta;

public class Pelihahmo {

    private Palikka hahmo;
    private Suunta suunta;

    public Pelihahmo(int x, int y) {
        this.suunta = suunta.VASEN;
        this.hahmo = new Palikka(x, y);
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public Suunta getSuunta() {
        return this.suunta;
    }

    public Palikka getHahmo() {
        return hahmo;
    }

    @Override
    public String toString() {
        return "(" + hahmo.getX() + "," + hahmo.getY() + ")";
    }

    public boolean osuuSeinaan(Palikka seina) {
        if (null != this.suunta) {
            switch (this.suunta) {
                case ALAS:
                    if(this.hahmo.getY()+1 == seina.getY() && this.hahmo.getX() == seina.getX()) {
                        return true;
                    } 
                case YLOS:
                    if(this.hahmo.getY()-1 == seina.getY() && this.hahmo.getX() == seina.getX()) {
                        return true;
                    }
                case OIKEA:
                    if(this.hahmo.getX()+1 == seina.getX() && this.hahmo.getY() == seina.getY()) {
                        return true;
                    }
                case VASEN:
                    if(this.hahmo.getX()-1 == seina.getX() && this.hahmo.getY() == seina.getY()) {
                        return true;
                    }
                default:
                    return false;
            }
        }
        return false;
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
}
