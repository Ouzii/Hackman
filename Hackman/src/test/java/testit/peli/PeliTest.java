package testit.peli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hackman.peli.Peli;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author oce
 */
public class PeliTest {
    
    private Peli peli;
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli(20, 20);
    }
    
    @Test
    public void luominenToimiiKorkeus() {
        assertEquals(20, this.peli.getKorkeus());
    }
    
    @Test
    public void luominenToimiiLeveys() {
        assertEquals(20, this.peli.getLeveys());
    }
            
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
