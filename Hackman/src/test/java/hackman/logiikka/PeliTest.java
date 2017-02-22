package hackman.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hackman.logiikka.Peli;
import hackman.kartat.Kartta1;
import hackman.kayttoliittyma.Kayttoliittyma;
import hackman.kayttoliittyma.Piirtaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author oce
 */
public class PeliTest {

    private Peli peli;
    private Peli peli2;

    public PeliTest() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.peli2 = new Peli(20, 20, new Kartta1(20, 20), "", Vaikeustaso.NORMAALI);
    }

    @Test
    public void getteritToimii() {
        assertEquals("(10, 10)", this.peli.getPelaaja().toString());
        assertEquals(0, this.peli.getLogiikka().getPojot());
        assertEquals("Kartta1", this.peli.getKartta().toString());
        assertEquals(null, this.peli.getPaivitettava());
        this.peli.setPaivitettava(new Piirtaja(this.peli, 20, new Kayttoliittyma(20, false, "")));
        assertNotEquals(null, this.peli.getPaivitettava());
        assertEquals(20, this.peli.getKorkeus());
        assertEquals(20, this.peli.getLeveys());
        assertEquals("(10, 10)", this.peli2.getPelaaja().toString());
        assertEquals(0, this.peli2.getLogiikka().getPojot());
        assertEquals("Kartta1", this.peli2.getKartta().toString());
        assertEquals(null, this.peli2.getPaivitettava());
        this.peli2.setPaivitettava(new Piirtaja(this.peli2, 20, new Kayttoliittyma(20, false, "")));
        assertNotEquals(null, this.peli2.getPaivitettava());
        assertEquals(20, this.peli2.getKorkeus());
        assertEquals(20, this.peli2.getLeveys());
        assertEquals(Vaikeustaso.NORMAALI, this.peli2.getVaikeustaso());
    }

    @Test
    public void setteritToimii() {
        this.peli.getLogiikka().setPojot(99);
        assertEquals(99, this.peli.getLogiikka().getPojot());
        this.peli2.setVaikeustaso(Vaikeustaso.VAIKEA);
        assertEquals(Vaikeustaso.VAIKEA, this.peli2.getVaikeustaso());
    }

}