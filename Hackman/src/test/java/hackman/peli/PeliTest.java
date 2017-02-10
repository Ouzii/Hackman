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
        assertEquals(0, this.peli.getPojot());
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
        this.peli.setPojot(99);
        assertEquals(99, this.peli.getPojot());
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

    @Test
    public void liikuPelaajaToimii() {
        assertTrue(this.peli.liikuPelaaja());
        this.peli.getPelaaja().setSuunta(Suunta.ALAS);
        assertFalse(this.peli.liikuPelaaja());
        this.peli.liikuPelaaja();
        assertNotEquals("(10, 10)", this.peli.getPelaaja().toString());
    }
    
    @Test
    public void kuoleekoToimii() {
        assertFalse(this.peli.isHavia());
        assertTrue(this.peli.getPelaaja().isElossa());
        Vihollinen vihu = new Vihollinen(10, 10);
        this.peli.kuoleeko(vihu);
        assertFalse(this.peli.getPelaaja().isElossa());
        assertTrue(this.peli.isHavia());
    }
    
    @Test
    public void liikutaVihollisiaToimii() {
        assertEquals("(2, 2)", this.peli.getKartta().getVihuPun().toString());
        assertEquals("(18, 18)", this.peli.getKartta().getVihuMus().toString());
        assertEquals("(18, 2)", this.peli.getKartta().getVihuKel().toString());
        assertEquals("(2, 18)", this.peli.getKartta().getVihuPin().toString());
        
        this.peli.liikutaVihollisia();
        
        assertEquals("(2, 3)", this.peli.getKartta().getVihuPun().toString());
        assertEquals("(18, 17)", this.peli.getKartta().getVihuMus().toString());
        assertEquals("(17, 2)", this.peli.getKartta().getVihuKel().toString());
        assertEquals("(3, 18)", this.peli.getKartta().getVihuPin().toString()); 
    }
    
    @Test
    public void askelLukuToimii() {
        assertFalse(this.peli.askelLuku());
        assertFalse(this.peli.askelLuku());
        assertTrue(this.peli.askelLuku());
        assertFalse(this.peli.askelLuku());
        assertFalse(this.peli.askelLuku());
        assertTrue(this.peli.askelLuku());
    }

}
