/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kartat;

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
public class Kartta5Test {

    private Kartta5 kartta;

    public Kartta5Test() {
    }

    @Before
    public void setUp() {
        this.kartta = new Kartta5(20, 20);
    }

    @Test
    public void toStringToimii() {
        assertEquals("Kartta5", this.kartta.toString());
    }

    @Test
    public void getteritToimii() {
        assertEquals(100, this.kartta.getBitit().size());
        assertEquals("(2, 2)", this.kartta.getVihuPun().toString());
        assertEquals("(18, 18)", this.kartta.getVihuMus().toString());
        assertEquals("(2, 18)", this.kartta.getVihuPin().toString());
        assertEquals("(18, 2)", this.kartta.getVihuKel().toString());
    }
}