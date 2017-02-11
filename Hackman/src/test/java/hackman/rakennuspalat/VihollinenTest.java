/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.rakennuspalat;

import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.Vihollinen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.Timeout;

/**
 *
 * @author Oce
 */
public class VihollinenTest {

    private Vihollinen vihu;
    private Pelihahmo pelaaja;

    public VihollinenTest() {
    }

    @Before
    public void setUp() {
        this.vihu = new Vihollinen(4, 3);
        this.pelaaja = new Pelihahmo(10, 10);
    }

    @Test
    public void luoVihollinenToimii() {
        assertEquals("(4, 3)", this.vihu.toString());
    }

    @Test
    public void liikuVihollinenMusToimii() {
        this.vihu.setX(10);
        this.vihu.setY(16);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihu.getSuunta());

        this.vihu.setY(7);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihu.getSuunta());

        this.vihu.setX(18);
        this.vihu.setY(10);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihu.getSuunta());

        this.vihu.setX(3);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihu.getSuunta());
    }

    @Test 
    public void liikuVihollinenMusEiVaihdaSuuntaaJosEiTarvitse() {
        this.vihu.setX(2);
        this.vihu.setY(2);
        this.vihu.setSuunta(Suunta.OIKEA);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.VASEN);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.YLOS);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.ALAS);
        this.vihu.liikuVihollinenMus(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihu.getSuunta());
    }

    @Test
    public void liikuVihollinenKelToimii() {
        this.vihu.setX(11);
        this.vihu.setY(10);
        this.vihu.liikuVihollinenKel(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihu.getSuunta());

        this.vihu.setX(9);
        this.vihu.liikuVihollinenKel(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihu.getSuunta());
    }

    @Test
    public void liikuVihollinenKelEiVaihdaSuuntaaJosEiTarvitse() {
        this.vihu.setY(4);
        this.vihu.setX(4);

        this.vihu.setSuunta(Suunta.YLOS);
        this.vihu.liikuVihollinenKel(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.OIKEA);
        this.vihu.liikuVihollinenKel(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.VASEN);
        this.vihu.liikuVihollinenKel(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.ALAS);
        this.vihu.liikuVihollinenKel(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihu.getSuunta());
    }

    @Test
    public void liikuVihollinenPinToimii() {
        this.vihu.setX(10);
        this.vihu.setY(11);
        this.vihu.liikuVihollinenPin(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihu.getSuunta());

        this.vihu.setY(9);
        this.vihu.liikuVihollinenPin(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihu.getSuunta());
    }

    @Test
    public void liikuVihollinenPinEiVaihdaSuuntaaJosEiTarvitse() {
        this.vihu.setY(4);
        this.vihu.setX(4);

        this.vihu.setSuunta(Suunta.YLOS);
        this.vihu.liikuVihollinenPin(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.OIKEA);
        this.vihu.liikuVihollinenPin(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.VASEN);
        this.vihu.liikuVihollinenPin(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihu.getSuunta());

        this.vihu.setSuunta(Suunta.ALAS);
        this.vihu.liikuVihollinenPin(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihu.getSuunta());
    }

    @Test
    public void suunnanMuutosToimii() {
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
        assertTrue(this.vihu.vaihdaSuunta());
    }

}
