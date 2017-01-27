package hackman.rakennuspalat;

public class Bitti extends Palikka {

    private boolean keratty;

    public Bitti(int x, int y) {
        super(x, y);
        this.keratty = false;
    }

    public boolean isKeratty() {
        return this.keratty;
    }

    public void setKeratty(boolean keratty) {
        this.keratty = keratty;
    }

}
