
package Hackman.rakennuspalat;

public class Palikka {
        private int x;
    private int y;

    public Palikka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    public boolean osuu(Palikka palikka) {
        if(this.x == palikka.getX() && this.y == palikka.getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}
