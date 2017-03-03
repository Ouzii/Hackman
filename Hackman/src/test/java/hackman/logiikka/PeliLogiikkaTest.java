/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.logiikka;

import hackman.enumit.Pelitila;
import hackman.logiikka.Peli;
import hackman.kartat.Kartta1;
import hackman.enumit.Suunta;
import hackman.rakennuspalat.Vihollinen;
import org.junit.Before;
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
        this.peli = new Peli(20, new Kartta1(20, 20), false);
    }

    @Test
    public void getteritToimii() {
        assertFalse(this.peli.getLogiikka().isVuoro());
        assertEquals(0, this.peli.getLogiikka().getPojot());
        assertEquals(0, this.peli.getLogiikka().getAskelia());
        assertEquals(0, this.peli.getLogiikka().getKeratty());
        assertEquals(Pelitila.NEUTRAALI, this.peli.getLogiikka().getPelitila());
    }

    @Test
    public void setteritToimii() {
        this.peli.getLogiikka().setPelitila(Pelitila.VOITTO);
        assertTrue(this.peli.getLogiikka().getPelitila().equals(Pelitila.VOITTO));
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
        assertEquals("(9, 10)", this.peli.getPelaaja().toString());
        this.peli.getPelaaja().setSuunta(Suunta.VASEN);

        for (int i = 0; i < 7; i++) {
            assertTrue(this.peli.getLogiikka().liikuPelaaja());
        }
        assertFalse(this.peli.getLogiikka().liikuPelaaja());
        assertEquals(Suunta.OIKEA, this.peli.getPelaaja().getSuunta());
        assertEquals("(2, 10)", this.peli.getPelaaja().toString());
        this.peli.getPelaaja().setSuunta(Suunta.ALAS);

        for (int i = 0; i < 8; i++) {
            assertTrue(this.peli.getLogiikka().liikuPelaaja());
        }
        assertFalse(this.peli.getLogiikka().liikuPelaaja());
        assertEquals(Suunta.YLOS, this.peli.getPelaaja().getSuunta());
        assertEquals("(2, 18)", this.peli.getPelaaja().toString());

        for (int i = 0; i < 16; i++) {
            assertTrue(this.peli.getLogiikka().liikuPelaaja());
        }
        assertFalse(this.peli.getLogiikka().liikuPelaaja());
        assertEquals(Suunta.ALAS, this.peli.getPelaaja().getSuunta());
        assertEquals("(2, 2)", this.peli.getPelaaja().toString());
        this.peli.getPelaaja().setSuunta(Suunta.OIKEA);

        for (int i = 0; i < 16; i++) {
            assertTrue(this.peli.getLogiikka().liikuPelaaja());
        }
        assertFalse(this.peli.getLogiikka().liikuPelaaja());
        assertEquals(Suunta.VASEN, this.peli.getPelaaja().getSuunta());
        assertEquals("(18, 2)", this.peli.getPelaaja().toString());

        this.peli.getPelaaja().setX(2);
        this.peli.getPelaaja().setY(10);
        this.peli.getPelaaja().setSuunta(Suunta.VASEN);
        assertFalse(this.peli.getLogiikka().liikuPelaaja());

    }

    @Test
    public void kuoleekoToimii() {
        assertFalse(this.peli.getLogiikka().getPelitila().equals(Pelitila.HAVIO));
        assertTrue(this.peli.getPelaaja().isElossa());
        Vihollinen vihu = new Vihollinen(10, 10);
        this.peli.getLogiikka().kuoleeko(vihu);
        assertFalse(this.peli.getPelaaja().isElossa());
        assertTrue(this.peli.getLogiikka().getPelitila().equals(Pelitila.HAVIO));
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

        this.peli.getKartta().getVihuMus().setX(10);
        this.peli.getKartta().getVihuMus().setY(3);
        this.peli.getKartta().getVihuKel().setX(3);
        this.peli.getKartta().getVihuKel().setY(10);
        this.peli.getKartta().getVihuPin().setX(10);
        this.peli.getKartta().getVihuPin().setY(18);

        this.peli.getLogiikka().liikutaVihollisia();

        assertEquals(Suunta.ALAS, this.peli.getKartta().getVihuMus().getSuunta());
        assertEquals(Suunta.YLOS, this.peli.getKartta().getVihuPin().getSuunta());
        assertEquals(Suunta.OIKEA, this.peli.getKartta().getVihuKel().getSuunta());
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
        assertFalse(this.peli.getLogiikka().getPelitila().equals(Pelitila.HAVIO));
        this.peli.getLogiikka().havia();
        assertTrue(this.peli.getLogiikka().getPelitila().equals(Pelitila.HAVIO));
        assertEquals(false, this.peli.isRunning());
    }

    @Test
    public void voitaToimii() {
        this.peli.start();
        assertTrue(this.peli.isRunning());
        assertFalse(this.peli.getLogiikka().getPelitila().equals(Pelitila.VOITTO));
        this.peli.getLogiikka().voita();
        assertTrue(this.peli.getLogiikka().getPelitila().equals(Pelitila.VOITTO));
        assertEquals(false, this.peli.isRunning());
    }

    @Test
    public void liikuVihollinenToimii() {
        this.peli.getKartta().getVihuPun().setSuunta(Suunta.VASEN);
        assertFalse(this.peli.getLogiikka().liikuVihollinen(this.peli.getKartta().getVihuPun()));
        this.peli.getKartta().getVihuPun().setSuunta(Suunta.ALAS);
        assertTrue(this.peli.getLogiikka().liikuVihollinen(this.peli.getKartta().getVihuPun()));
    }

}
