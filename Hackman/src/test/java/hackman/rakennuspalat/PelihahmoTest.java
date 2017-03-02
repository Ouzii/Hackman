package hackman.rakennuspalat;

import hackman.enumit.Suunta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oce
 */
public class PelihahmoTest {

    private Pelihahmo hahmo;
    private Pelihahmo hahmo2;

    public PelihahmoTest() {
    }

    @Before
    public void setUp() {
        this.hahmo = new Pelihahmo(10, 10);
        this.hahmo2 = new Pelihahmo(10, 10, Suunta.ALAS);
    }

    @Test
    public void luominenToimii() {
        assertEquals("(10, 10)", this.hahmo.toString());
        assertEquals("(10, 10)", this.hahmo2.toString());
        assertEquals(Suunta.ALAS, this.hahmo2.getSuunta());
    }
    
    @Test
    public void alussaOnElossa() {
        assertTrue(this.hahmo.isElossa());
        assertTrue(this.hahmo2.isElossa());
    }
    
    @Test
    public void kuolemaToimii() {
        this.hahmo.kuole();
        this.hahmo2.kuole();
        assertFalse(this.hahmo.isElossa());
        assertFalse(this.hahmo2.isElossa());
    }
}
