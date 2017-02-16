/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.peli;

import hackman.kartat.Kartta1;
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
public class HighscoreTest {
    
    private Peli peli;
    
    public HighscoreTest() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
    }
    
    @Test
    public void getteritToimii() {
        assertEquals("", this.peli.getHighscore().getNimi());
        assertFalse(this.peli.getHighscore().isMenuun());
    }
    
    @Test
    public void kirjoitaTest() {
        assertTrue(this.peli.getHighscore().kirjoita());
    }
}
