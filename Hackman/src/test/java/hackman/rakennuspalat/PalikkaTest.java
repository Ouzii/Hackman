/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.rakennuspalat;

import hackman.rakennuspalat.Palikka;
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
        assertEquals("(10, 10)", palikka.toString());
    }

    @Test
    public void osuuToimii() {
        Palikka p2 = new Palikka(10, 10);
        assertTrue(this.palikka.osuu(p2));
        p2.liiku();
        assertFalse(this.palikka.osuu(p2));
    }

    @Test
    public void suuntaMuuttuu() {
        this.palikka.liiku();
        this.palikka.setSuunta(Suunta.YLOS);
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        assertEquals("(9, 7)", this.palikka.toString());
    }

    @Test
    public void liikuToimii() {
        assertTrue(this.palikka.liiku());
        this.palikka.setSuunta(Suunta.OIKEA);
        int X = this.palikka.getX();
        assertEquals(X, this.palikka.getX());
        assertTrue(this.palikka.liiku());
        assertEquals(X, this.palikka.getX() - 1);
        
        this.palikka.setSuunta(Suunta.VASEN);
        X = this.palikka.getX();
        assertEquals(X, this.palikka.getX());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertEquals(X, this.palikka.getX() + 3);
        
        this.palikka.setSuunta(Suunta.ALAS);       
        int Y = this.palikka.getY();
        assertEquals(Y, this.palikka.getY());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertEquals(Y, this.palikka.getY() - 2);
        
        this.palikka.setSuunta(Suunta.YLOS);
        Y = this.palikka.getY();
        assertEquals(Y, this.palikka.getY());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertTrue(this.palikka.liiku());
        assertEquals(Y, this.palikka.getY() + 5);
        
        this.palikka.setSuunta(null);
        assertFalse(this.palikka.liiku());
        
    }
    @Test
    public void liikuToimiiVasen() {
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        assertEquals("(7, 10)", this.palikka.toString());
    }

    @Test
    public void liikuToimiiOikea() {
        this.palikka.setSuunta(Suunta.OIKEA);
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        assertEquals(16, this.palikka.getX());
    }

    @Test
    public void liikuToimiiAlas() {
        this.palikka.setSuunta(Suunta.ALAS);
        this.palikka.liiku();
        this.palikka.liiku();
        assertEquals(12, this.palikka.getY());
    }

    @Test
    public void liikuToimiiYlos() {
        this.palikka.setSuunta(Suunta.YLOS);
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();
        this.palikka.liiku();

        assertEquals(5, this.palikka.getY());
    }

    @Test
    public void osuuSeinaanToimiiVasen() {
        Palikka seina = new Palikka(8, 10);
        this.palikka.liiku();
        assertTrue(this.palikka.osuuSeinaan(seina));

    }

    @Test
    public void osuuSeinaanToimiiOikea() {
        Palikka seina = new Palikka(12, 10);
        this.palikka.setSuunta(Suunta.OIKEA);
        this.palikka.liiku();
        assertTrue(this.palikka.osuuSeinaan(seina));
    }

    @Test
    public void osuuSeinaanToimiiAlas() {
        Palikka seina = new Palikka(10, 12);
        this.palikka.setSuunta(Suunta.ALAS);
        this.palikka.liiku();
        assertTrue(this.palikka.osuuSeinaan(seina));
    }

    @Test
    public void osuuSeinaanToimiiYlos() {
        Palikka seina = new Palikka(10, 8);
        this.palikka.setSuunta(Suunta.YLOS);
        this.palikka.liiku();
        assertTrue(this.palikka.osuuSeinaan(seina));
    }

    @Test
    public void osuuSeinaanPalauttaaFalseJosEiOsu() {
        Palikka seina = new Palikka(8, 10);
        assertFalse(this.palikka.osuuSeinaan(seina));
    }

}
