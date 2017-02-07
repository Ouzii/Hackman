/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testit.peli;

import hackman.peli.Kartta;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Suunta;
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
        assertEquals("Koko: 20 * 20, bittien määrä: 80", this.kartta.toString());
    }

    @Test
    public void getBititToimii() {
        assertEquals(80, this.kartta.getBitit().size());
    }

    @Test
    public void getSeinatToimii() {
        assertEquals(148, this.kartta.getSeinat().size());
    }

    @Test
    public void seinienLuominenOikein() {
        assertEquals(148, this.kartta.getSeinat().size());
    }

    @Test
    public void bittienLuominenOikein() {
        assertEquals(80, this.kartta.getBitit().size());
    }

    @Test
    public void osuuSeinaanToimiiVasen() {
        Pelihahmo pelaaja = new Pelihahmo(5, 10);
        pelaaja.liiku();
        pelaaja.liiku();
        pelaaja.liiku();
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }

    @Test
    public void osuuSeinaanToimiiOikea() {
        Pelihahmo pelaaja = new Pelihahmo(15, 10);
        pelaaja.setSuunta(Suunta.OIKEA);
        pelaaja.liiku();
        pelaaja.liiku();
        pelaaja.liiku();
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }

    @Test
    public void osuuSeinaanToimiiAlas() {
        Pelihahmo pelaaja = new Pelihahmo(10, 10);
        pelaaja.liiku();
        pelaaja.setSuunta(Suunta.ALAS);
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }
    
    @Test
    public void osuuSeinaanToimiiYlos() {
        Pelihahmo pelaaja = new Pelihahmo(10, 10);
        pelaaja.liiku();
        pelaaja.setSuunta(Suunta.YLOS);
        assertTrue(this.kartta.osuuSeinaan(pelaaja));
    }
    
    @Test
    public void osuuSeinaanPalauttaaFalseJosEiOsu() {
        Pelihahmo pelaaja = new Pelihahmo(10, 10);
        assertFalse(this.kartta.osuuSeinaan(pelaaja));
    }
}
