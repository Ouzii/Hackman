package hackman.rakennuspalat;
/**
 * Pelaajan ohjaaman hahmon peruslogiikka.
 * @author Oce
 */
public class Pelihahmo extends Palikka {

    private boolean elossa;

    public Pelihahmo(int x, int y) {
        super(x, y);
        this.elossa = true;
    }

    public boolean isElossa() {
        return this.elossa;
    }

    public void kuole() {
        this.elossa = false;
    }

}
