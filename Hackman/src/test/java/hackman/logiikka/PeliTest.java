package hackman.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        this.peli = new Peli(20, 20, new Kartta1(20, 20), false);
        this.peli2 = new Peli(20, 20, new Kartta1(20, 20), "", Vaikeustaso.NORMAALI, false);
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
        assertEquals(Menutila.MENU, this.peli.getMenutila());
        assertEquals(Menutila.MENU, this.peli2.getMenutila());
    }

    @Test
    public void setteritToimii() {
        this.peli2.setPaivitettava(new Piirtaja(this.peli2, 20, new Kayttoliittyma(20, false, "")));
        assertNotEquals(null, this.peli2.getPaivitettava());
        this.peli.getLogiikka().setPojot(99);
        assertEquals(99, this.peli.getLogiikka().getPojot());
        this.peli2.setVaikeustaso(Vaikeustaso.VAIKEA);
        assertEquals(Vaikeustaso.VAIKEA, this.peli2.getVaikeustaso());
        this.peli.setMenutila(Menutila.KAYNNISSA);
        assertEquals(Menutila.KAYNNISSA, this.peli.getMenutila());
        assertNotEquals(Menutila.HIGHSCORE, this.peli2.getMenutila());
        this.peli2.setMenutila(Menutila.HIGHSCORE);
        assertEquals(Menutila.HIGHSCORE, this.peli2.getMenutila());
    }

    @Test
    public void lisaaPisteetToimii() {
        assertEquals(0, this.peli.getLogiikka().getPojot());
        for (int i = 0; i < 6; i++) {
            this.peli.getPelaaja().liiku();
            this.peli.lisaaPisteet();
        }
        assertEquals(6, this.peli.getLogiikka().getPojot());
        assertEquals(3, this.peli.getLogiikka().getKeratty());

        
        this.peli = new Peli(20, 20, new Kartta1(20, 20), false);
        this.peli.setVaikeustaso(Vaikeustaso.VAIKEA);
        assertEquals(0, this.peli.getLogiikka().getPojot());
        for (int i = 0; i < 6; i++) {
            this.peli.getPelaaja().liiku();
            this.peli.lisaaPisteet();
        }
        assertEquals(9, this.peli.getLogiikka().getPojot());
        assertEquals(3, this.peli.getLogiikka().getKeratty());

        
        this.peli = new Peli(20, 20, new Kartta1(20, 20), false);
        this.peli.setVaikeustaso(Vaikeustaso.HELPPO);
        assertEquals(0, this.peli.getLogiikka().getPojot());
        for (int i = 0; i < 6; i++) {
            this.peli.getPelaaja().liiku();
            this.peli.lisaaPisteet();
        }
        assertEquals(3, this.peli.getLogiikka().getPojot());
        assertEquals(3, this.peli.getLogiikka().getKeratty());

    }

}
