package hackman.peli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hackman.kartat.Kartta1;
import hackman.kayttoliittyma.Piirtaja;
import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.Vihollinen;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author oce
 */
public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
    }

    @Test
    public void luominenToimiiKorkeus() {
        assertEquals(20, this.peli.getKorkeus());
    }

    @Test
    public void luominenToimiiLeveys() {
        assertEquals(20, this.peli.getLeveys());
    }

    @Test
    public void getteritToimii() {
        assertEquals("(10, 10)", this.peli.getPelaaja().toString());
        assertEquals(0, this.peli.getLogiikka().getPojot());
        assertEquals("Kartta1", this.peli.getKartta().toString());
        assertFalse(this.peli.isHighscore());
        assertFalse(this.peli.isAlkaa());
        assertFalse(this.peli.isVoita());
        assertFalse(this.peli.isHavia());
        assertEquals(null, this.peli.getPaivitettava());
        this.peli.setPaivitettava(new Piirtaja(this.peli, 20));
        assertNotEquals(null, this.peli.getPaivitettava());
    }

    @Test
    public void setteritToimii() {
        this.peli.setAlkaa();
        assertTrue(this.peli.isRunning());
        this.peli.setHighscore(true);
        assertTrue(this.peli.isHighscore());
        this.peli.setVoita(true);
        assertTrue(this.peli.isVoita());
        this.peli.getLogiikka().setPojot(99);
        assertEquals(99, this.peli.getLogiikka().getPojot());
    }

    @Test
    public void pysaytaToimii() {
        this.peli.setAlkaa();
        assertTrue(this.peli.isAlkaa());
        this.peli.pysayta();
        assertFalse(this.peli.isAlkaa());
        assertEquals(false, this.peli.isRunning());
        
    }
    
    @Test
    public void haviaToimii() {
        this.peli.start();
        assertTrue(this.peli.isRunning());
        assertFalse(this.peli.isHavia());
        this.peli.havia();
        assertTrue(this.peli.isHavia());
        assertEquals(false, this.peli.isRunning());
    }

    @Test
    public void voitaToimii() {
        this.peli.start();
        assertTrue(this.peli.isRunning());
        assertFalse(this.peli.isVoita());
        this.peli.voita();
        assertTrue(this.peli.isVoita());
        assertEquals(false, this.peli.isRunning());
    }

}
