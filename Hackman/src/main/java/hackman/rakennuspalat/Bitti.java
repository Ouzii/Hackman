package hackman.rakennuspalat;
/**
 * Logiikka pelissä kerättäville biteille.
 * @author Oce
 */
public class Bitti extends Palikka {

    private boolean keratty;

    /**
     * Luo bitin annettuihin koordinaatteihin ja asettaa bitin keräämättömäksi.
     * @param x X-koordinaatti alussa.
     * @param y Y-koordinaatti alussa.
     */
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
