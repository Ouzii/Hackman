package hackman.rakennuspalat;

import hackman.enumit.Suunta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oce
 */
public class VihollinenTest {

    private VihollinenMus vihuMus;
    private VihollinenKel vihuKel;
    private VihollinenPin vihuPin;
    private Vihollinen vihuPun;
    private Pelihahmo pelaaja;

    public VihollinenTest() {
    }

    @Before
    public void setUp() {
        this.vihuMus = new VihollinenMus(4, 3);
        this.vihuKel = new VihollinenKel(4, 3);
        this.vihuPin = new VihollinenPin(4, 3);
        this.vihuPun = new Vihollinen(4, 3);
        this.pelaaja = new Pelihahmo(10, 10);
    }

    @Test
    public void luoVihollinenToimii() {
        assertEquals("(4, 3)", this.vihuPun.toString());
        assertEquals("(4, 3)", this.vihuMus.toString());
        assertEquals("(4, 3)", this.vihuKel.toString());
        assertEquals("(4, 3)", this.vihuPin.toString());
    }

    @Test
    public void kaannaVihollinenMusToimii() {
        this.vihuMus.setX(10);
        this.vihuMus.setY(16);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihuMus.getSuunta());

        this.vihuMus.setY(7);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihuMus.getSuunta());

        this.vihuMus.setX(18);
        this.vihuMus.setY(10);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihuMus.getSuunta());

        this.vihuMus.setX(3);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihuMus.getSuunta());
    }

    @Test 
    public void kaannaVihollinenMusEiVaihdaSuuntaaJosEiTarvitse() {
        this.vihuMus.setX(2);
        this.vihuMus.setY(2);
        this.vihuMus.setSuunta(Suunta.OIKEA);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihuMus.getSuunta());

        this.vihuMus.setSuunta(Suunta.VASEN);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihuMus.getSuunta());

        this.vihuMus.setSuunta(Suunta.YLOS);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihuMus.getSuunta());

        this.vihuMus.setSuunta(Suunta.ALAS);
        this.vihuMus.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihuMus.getSuunta());
    }

    @Test
    public void kaannaVihollinenKelToimii() {
        this.vihuKel.setX(11);
        this.vihuKel.setY(10);
        this.vihuKel.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihuKel.getSuunta());

        this.vihuKel.setX(9);
        this.vihuKel.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihuKel.getSuunta());
    }

    @Test
    public void kaannaVihollinenKelEiVaihdaSuuntaaJosEiTarvitse() {
        this.vihuKel.setY(4);
        this.vihuKel.setX(4);

        this.vihuKel.setSuunta(Suunta.YLOS);
        this.vihuKel.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihuKel.getSuunta());

        this.vihuKel.setSuunta(Suunta.OIKEA);
        this.vihuKel.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihuKel.getSuunta());

        this.vihuKel.setSuunta(Suunta.VASEN);
        this.vihuKel.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihuKel.getSuunta());

        this.vihuKel.setSuunta(Suunta.ALAS);
        this.vihuKel.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihuKel.getSuunta());
    }

    @Test
    public void kaannaVihollinenPinToimii() {
        this.vihuPin.setX(10);
        this.vihuPin.setY(11);
        this.vihuPin.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihuPin.getSuunta());

        this.vihuPin.setY(9);
        this.vihuPin.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihuPin.getSuunta());
    }

    @Test
    public void kaannaVihollinenPinEiVaihdaSuuntaaJosEiTarvitse() {
        this.vihuPin.setY(4);
        this.vihuPin.setX(4);

        this.vihuPin.setSuunta(Suunta.YLOS);
        this.vihuPin.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.YLOS, this.vihuPin.getSuunta());

        this.vihuPin.setSuunta(Suunta.OIKEA);
        this.vihuPin.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.OIKEA, this.vihuPin.getSuunta());

        this.vihuPin.setSuunta(Suunta.VASEN);
        this.vihuPin.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.VASEN, this.vihuPin.getSuunta());

        this.vihuPin.setSuunta(Suunta.ALAS);
        this.vihuPin.kaannaVihollinen(this.pelaaja);
        assertEquals(Suunta.ALAS, this.vihuPin.getSuunta());
    }

    @Test
    public void suunnanMuutosToimii() {
        assertTrue(this.vihuPun.vaihdaSuunta());
        assertTrue(this.vihuPun.vaihdaSuunta());
        assertTrue(this.vihuPun.vaihdaSuunta());
        assertTrue(this.vihuPun.vaihdaSuunta());
        assertTrue(this.vihuKel.vaihdaSuunta());
        assertTrue(this.vihuKel.vaihdaSuunta());
        assertTrue(this.vihuKel.vaihdaSuunta());
        assertTrue(this.vihuKel.vaihdaSuunta());
        assertTrue(this.vihuPin.vaihdaSuunta());
        assertTrue(this.vihuPin.vaihdaSuunta());
        assertTrue(this.vihuPin.vaihdaSuunta());
        assertTrue(this.vihuPin.vaihdaSuunta());
        assertTrue(this.vihuMus.vaihdaSuunta());
        assertTrue(this.vihuMus.vaihdaSuunta());
        assertTrue(this.vihuMus.vaihdaSuunta());
        assertTrue(this.vihuMus.vaihdaSuunta());
    }

}
