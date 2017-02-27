/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kartat;

import hackman.kartat.Kartta;
import hackman.kartat.Kartta1;
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
public class KarttaTest {

    private Kartta kartta;

    public KarttaTest() {
    }

    @Before
    public void setUp() {
        this.kartta = new Kartta(20, 20);
    }
    
    @Test
    public void karttaToStringToimii() {
        this.kartta = new Kartta(20, 20);
        assertEquals("Koko: 20 * 20, bittien määrä: 0", this.kartta.toString());
    }

    @Test
    public void getBititToimii() {
        assertEquals(0, this.kartta.getBitit().size());
    }

    @Test
    public void getSeinatToimii() {
        assertEquals(84, this.kartta.getSeinat().size());
    }

    @Test
    public void getVihollisetToimii() {
        assertEquals("(2, 2)", this.kartta.getVihuPun().toString());
        assertEquals("(18, 18)", this.kartta.getVihuMus().toString());
        assertEquals("(2, 18)", this.kartta.getVihuPin().toString());
        assertEquals("(18, 2)", this.kartta.getVihuKel().toString());
    }
    
    @Test
    public void liikuVihollinenToimii() {
        this.kartta.getVihuPun().setSuunta(Suunta.VASEN);
        assertFalse(this.kartta.liikuVihollinen(this.kartta.getVihuPun()));
        this.kartta.getVihuPun().setSuunta(Suunta.ALAS);
        assertTrue(this.kartta.liikuVihollinen(this.kartta.getVihuPun()));
    }
    
    @Test
    public void seinienLuominenOikein() {
        assertEquals(84, this.kartta.getSeinat().size());
    }

    @Test
    public void bittienLuominenOikein() {
        assertEquals(0, this.kartta.getBitit().size());
    }

    @Test
    public void osuuSeinaanToimiiVasen() {
        Pelihahmo pelaaja = new Pelihahmo(2, 2);
        pelaaja.setSuunta(Suunta.VASEN);
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }

    @Test
    public void osuuSeinaanToimiiOikea() {
        Pelihahmo pelaaja = new Pelihahmo(18, 10);
        pelaaja.setSuunta(Suunta.OIKEA);
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }

    @Test
    public void osuuSeinaanToimiiAlas() {
        Pelihahmo pelaaja = new Pelihahmo(10, 18);
        pelaaja.setSuunta(Suunta.ALAS);
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }
    
    @Test
    public void osuuSeinaanToimiiYlos() {
        Pelihahmo pelaaja = new Pelihahmo(10, 2);
        pelaaja.setSuunta(Suunta.YLOS);
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }
    
    @Test
    public void osuuSeinaanPalauttaaFalseJosEiOsu() {
        Pelihahmo pelaaja = new Pelihahmo(10, 10);
        assertFalse(this.kartta.osuuSeinaan(pelaaja));
    }
}
