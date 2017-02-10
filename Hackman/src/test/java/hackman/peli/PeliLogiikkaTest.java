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
    public void liikuPelaajaToimii() {
        assertTrue(this.peli.getLogiikka().liikuPelaaja());
        this.peli.getPelaaja().setSuunta(Suunta.ALAS);
        assertFalse(this.peli.getLogiikka().liikuPelaaja());
        this.peli.getLogiikka().liikuPelaaja();
        assertNotEquals("(10, 10)", this.peli.getPelaaja().toString());
    }

    @Test
    public void kuoleekoToimii() {
        assertFalse(this.peli.isHavia());
        assertTrue(this.peli.getPelaaja().isElossa());
        Vihollinen vihu = new Vihollinen(10, 10);
        this.peli.getLogiikka().kuoleeko(vihu);
        assertFalse(this.peli.getPelaaja().isElossa());
        assertTrue(this.peli.isHavia());
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

}
