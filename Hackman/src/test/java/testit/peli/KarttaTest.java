/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testit.peli;

import hackman.peli.Kartta;
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
public class KarttaTest {
    
    private Kartta kartta;
    
    public KarttaTest() {
    }
    
    @Before
    public void setUp() {
        this.kartta = new Kartta(20, 20);
    }
    
    @Test
    public void luominenToimii() {
        assertEquals("Koko: 20 * 20, bittien määrä: 81", this.kartta.toString());
    }
}
