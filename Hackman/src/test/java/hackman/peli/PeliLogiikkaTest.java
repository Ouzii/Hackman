/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.peli;

import hackman.kartat.Kartta1;
import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.Vihollinen;
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
public class PeliLogiikkaTest {

    private Peli peli;

    public PeliLogiikkaTest() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
    }

    @Test
    public void getteritToimii() {
        assertFalse(this.peli.getLogiikka().isVuoro());
        assertEquals(0, this.peli.getLogiikka().getPojot());
        assertEquals(0, this.peli.getLogiikka().getAskelia());
        assertEquals(0, this.peli.getLogiikka().getKeratty());
        assertFalse(this.peli.getLogiikka().isAlkaa());
        assertFalse(this.peli.getLogiikka().isVoita());
        assertFalse(this.peli.getLogiikka().isHavia());
    }

    @Test
    public void setteritToimii() {
        this.peli.getLogiikka().setAlkaa();
        assertTrue(this.peli.isRunning());
        this.peli.getLogiikka().setVoita(true);
        assertTrue(this.peli.getLogiikka().isVoita());
        this.peli.getLogiikka().setAskelia(2);
        assertEquals(2, this.peli.getLogiikka().getAskelia());
        this.peli.getLogiikka().setPojot(99);
        assertEquals(99, this.peli.getLogiikka().getPojot());
        this.peli.getLogiikka().setVuoro(true);
        assertTrue(this.peli.getLogiikka().isVuoro());
        this.peli.getLogiikka().setKeratty(100);
        assertEquals(100, this.peli.getLogiikka().getKeratty());
    }

    @Test
    public void liikuPelaajaToimii() {
        assertTrue(this.peli.getLogiikka().liikuPelaaja());
        this.peli.getPelaaja().setSuunta(Suunta.ALAS);
        assertFalse(this.peli.getLogiikka().liikuPelaaja());
        this.peli.getLogiikka().liikuPelaaja();
        assertNotEquals("(10, 10)", this.peli.getPelaaja().toString());
    }

    @Test
    public void kuoleekoToimii() {
        assertFalse(this.peli.getLogiikka().isHavia());
        assertTrue(this.peli.getPelaaja().isElossa());
        Vihollinen vihu = new Vihollinen(10, 10);
        this.peli.getLogiikka().kuoleeko(vihu);
        assertFalse(this.peli.getPelaaja().isElossa());
        assertTrue(this.peli.getLogiikka().isHavia());
    }

    @Test
    public void pysaytaToimii() {
        this.peli.getLogiikka().setAlkaa();
        assertTrue(this.peli.getLogiikka().isAlkaa());
        this.peli.getLogiikka().pysayta();
        assertFalse(this.peli.getLogiikka().isAlkaa());
        assertEquals(false, this.peli.isRunning());

    }

    @Test
    public void liikutaVihollisiaToimii() {
        assertEquals("(2, 2)", this.peli.getKartta().getVihuPun().toString());
        assertEquals("(18, 18)", this.peli.getKartta().getVihuMus().toString());
        assertEquals("(18, 2)", this.peli.getKartta().getVihuKel().toString());
        assertEquals("(2, 18)", this.peli.getKartta().getVihuPin().toString());

        this.peli.getLogiikka().liikutaVihollisia();

        assertEquals("(2, 3)", this.peli.getKartta().getVihuPun().toString());
        assertEquals("(18, 17)", this.peli.getKartta().getVihuMus().toString());
        assertEquals("(17, 2)", this.peli.getKartta().getVihuKel().toString());
        assertEquals("(3, 18)", this.peli.getKartta().getVihuPin().toString());
    }

    @Test
    public void askelLukuToimii() {
        assertFalse(this.peli.getLogiikka().askelLuku());
        assertFalse(this.peli.getLogiikka().askelLuku());
        assertTrue(this.peli.getLogiikka().askelLuku());
        assertFalse(this.peli.getLogiikka().askelLuku());
        assertFalse(this.peli.getLogiikka().askelLuku());
        assertTrue(this.peli.getLogiikka().askelLuku());
    }

    @Test
    public void haviaToimii() {
        this.peli.start();
        assertTrue(this.peli.isRunning());
        assertFalse(this.peli.getLogiikka().isHavia());
        this.peli.getLogiikka().havia();
        assertTrue(this.peli.getLogiikka().isHavia());
        assertEquals(false, this.peli.isRunning());
    }

    @Test
    public void voitaToimii() {
        this.peli.start();
        assertTrue(this.peli.isRunning());
        assertFalse(this.peli.getLogiikka().isVoita());
        this.peli.getLogiikka().voita();
        assertTrue(this.peli.getLogiikka().isVoita());
        assertEquals(false, this.peli.isRunning());
    }

}
