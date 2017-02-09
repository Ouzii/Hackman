package testit.peli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hackman.kartat.Kartta1;
import hackman.peli.Peli;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void getPelaajaToimii() {
        assertEquals("(10, 10)", this.peli.getPelaaja().toString());
    }

    @Test
    public void getVihuPunToimii() {
        assertEquals("(2, 2)", this.peli.getKartta().getVihuPun().toString());
    }

    @Test
    public void getPojotToimii() {
        assertEquals(0, this.peli.getPojot());
    }

    @Test
    public void getKarttaToimii() {
        assertEquals("Koko: 20 * 20, bittien määrä: 80", this.peli.getKartta().toString());
    }

    @Test
    public void pelaajaKuoleeJosOsuuViholliseen() {
        this.peli.getKartta().getVihuPun().setX(9);
        this.peli.getKartta().getVihuPun().setY(10);
        this.peli.getPelaaja().liiku();
        this.peli.getPelaaja().osuuVihuun(this.peli.getKartta().getVihuPun());
        assertFalse(this.peli.getPelaaja().isElossa());
    }

}
