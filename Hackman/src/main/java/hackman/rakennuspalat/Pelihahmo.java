package hackman.rakennuspalat;

import hackman.paaohjelma.Suunta;

public class Pelihahmo {

    private Palikka hahmo;
    private Suunta suunta;
    private boolean elossa;

    public Pelihahmo(int x, int y) {
        this.suunta = suunta.VASEN;
        this.hahmo = new Palikka(x, y);
        this.elossa = true;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public Suunta getSuunta() {
        return this.suunta;
    }

    public Palikka getHahmo() {
        return this.hahmo;
    }

    public boolean isElossa() {
        return this.elossa;
    }

    public void kuole() {
        this.elossa = false;
    }
    @Override
    public String toString() {
        return "(" + hahmo.getX() + "," + hahmo.getY() + ")";
    }

    public boolean osuuSeinaan(Palikka seina) {
        if(this.suunta == Suunta.ALAS && this.hahmo.getY()+1 == seina.getY() && this.hahmo.getX() == seina.getX()) {
            return true;
        }
        if(this.suunta == Suunta.YLOS && this.hahmo.getY()-1 == seina.getY() && this.hahmo.getX() == seina.getX()) {
            return true;
        }
        if(this.suunta == Suunta.OIKEA && this.hahmo.getY() == seina.getY() && this.hahmo.getX()+1 == seina.getX()) {
            return true;
        }
        if(this.suunta == Suunta.VASEN && this.hahmo.getY() == seina.getY() && this.hahmo.getX()-1 == seina.getX()) {
            return true;
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
