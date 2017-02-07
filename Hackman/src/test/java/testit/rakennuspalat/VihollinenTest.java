/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testit.rakennuspalat;

import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.VihollinenPunainen;
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
public class VihollinenTest {

    private VihollinenPunainen vihu;

    public VihollinenTest() {
    }

    @Before
    public void setUp() {
        this.vihu = new VihollinenPunainen(4, 3);
    }

    @Test
    public void luoVihollinenToimii() {
        assertEquals("(4, 3)", this.vihu.toString());
    }

    @Test
    public void alussaSuuntaAlas() {
        assertEquals(Suunta.ALAS, this.vihu.getSuunta());
    }

    @Test
    public void suunnanMuutosToimii() {
        assertTrue(this.vihu.vaihdaSuunta());
    }

}
