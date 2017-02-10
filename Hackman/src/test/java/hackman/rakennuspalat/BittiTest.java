/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.rakennuspalat;

import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Pelihahmo;
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
    public void alussaEiOleKeratty() {
        assertFalse(this.bitti.isKeratty());
    }

}
