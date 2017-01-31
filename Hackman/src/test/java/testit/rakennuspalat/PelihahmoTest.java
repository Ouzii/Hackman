package testit.rakennuspalat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PelihahmoTest {

    private Pelihahmo hahmo;

    public PelihahmoTest() {
    }

    @Before
    public void setUp() {
        this.hahmo = new Pelihahmo(10, 10);
    }

    @Test
    public void luominenToimii() {
        assertEquals("(10, 10)", this.hahmo.toString());
    }

    @Test
    public void liikuToimiiVasen() {
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        assertEquals(7, this.hahmo.getX());
    }

    @Test
    public void suuntaMuuttuu() {
        this.hahmo.liiku();
        this.hahmo.setSuunta(Suunta.YLOS);
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        assertEquals("(9, 7)", this.hahmo.toString());
    }

    @Test
    public void liikuToimiiOikea() {
        this.hahmo.setSuunta(Suunta.OIKEA);
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        assertEquals(16, this.hahmo.getX());
    }

    @Test
    public void liikuToimiiAlas() {
        this.hahmo.setSuunta(Suunta.ALAS);
        this.hahmo.liiku();
        this.hahmo.liiku();
        assertEquals(12, this.hahmo.getY());
    }

    @Test
    public void liikuToimiiYlos() {
        this.hahmo.setSuunta(Suunta.YLOS);
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        this.hahmo.liiku();
        assertEquals(5, this.hahmo.getY());
    }

}
