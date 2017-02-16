package hackman.rakennuspalat;

import hackman.rakennuspalat.Bitti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oce
 */
public class BittiTest {

    private Bitti bitti;

    public BittiTest() {
    }

    @Before
    public void setUp() {
        this.bitti = new Bitti(8, 10);
    }

    @Test
    public void bitinLuominenToimii() {
        assertEquals("(8, 10)", this.bitti.toString());
    }
    
    @Test
    public void setKerattyToimii() {
        assertFalse(this.bitti.isKeratty());
        this.bitti.setKeratty(true);
        assertTrue(this.bitti.isKeratty());
    }

    @Test
    public void alussaEiOleKeratty() {
        assertFalse(this.bitti.isKeratty());
    }

}
