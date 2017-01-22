
package Hackman.rakennuspalat;

import Hackman.Paaohjelma.Suunta;

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
        return "("+hahmo.getX()+","+hahmo.getY()+")";
    }
    public void liiku() {
        if(null != this.suunta) switch (this.suunta) {
            case ALAS:
                hahmo.setY(hahmo.getY()+1);
                break;
            case YLOS:
                hahmo.setY(hahmo.getY()-1);
                break;
            case OIKEA:
                hahmo.setX(hahmo.getX()+1);
                break;
            case VASEN:
                hahmo.setX(hahmo.getX()-1);
                break;
            default:
                break;
        }
        
    }
}
