/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testit.rakennuspalat;

import hackman.rakennuspalat.Palikka;
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
public class PalikkaTest {
    
    private Palikka palikka;
    
    public PalikkaTest() {
    }

    @Before
    public void setUp() {
        this.palikka = new Palikka(10, 10);
    }
    
    @Test
    public void luominenToimii() {
        assertEquals("(10,10)", palikka.toString());
    }
    
    @Test
    public void osuuToimii() {
        Palikka p2 = new Palikka(10, 10);
        assertTrue(this.palikka.osuu(p2));
    }

}
