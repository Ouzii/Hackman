package hackman.rakennuspalat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hackman.rakennuspalat.Pelihahmo;
import hackman.enumit.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oce
 */
public class PelihahmoTest {

    private Pelihahmo hahmo;

    public PelihahmoTest() {
    }

    @Before
    public void setUp() {
        this.hahmo = new Pelihahmo(10, 10);
    }

    @Test
    public void luominenToimii() {
        assertEquals("(10, 10)", this.hahmo.toString());
    }
    
    @Test
    public void alussaOnElossa() {
        assertTrue(this.hahmo.isElossa());
    }
    
    @Test
    public void kuolemaToimii() {
        this.hahmo.kuole();
        assertFalse(this.hahmo.isElossa());
    }
}
