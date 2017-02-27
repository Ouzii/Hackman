/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.logiikka;

import hackman.kartat.Kartta1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oce
 */
public class HighscoreTest {

    private Peli peli;

    public HighscoreTest() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli(20, new Kartta1(20, 20), true);
    }

    @Test
    public void getteritToimii() {
        assertEquals("", this.peli.getHighscore().getNimi());
        assertEquals(10, this.peli.getHighscore().getRivit().size());
    }

    @Test
    public void setteritToimii() {
        this.peli.getHighscore().setNimi("Pekka");
        assertEquals("Pekka", this.peli.getHighscore().getNimi());
        Map<Integer, String> testiMappi = new LinkedHashMap<>();
        this.peli.getHighscore().setRivit(testiMappi);
        assertEquals(0, this.peli.getHighscore().getRivit().size());
    }

    @Test
    public void eiYliKymmenenRivia() {
        for (int i = 11; i < 1000; i++) {
            assertNotEquals(i, this.peli.getHighscore().getRivit().size());
        }
    }

    @Test
    public void kirjoitaToimii() {
        Map<Integer, String> testiMappi = new LinkedHashMap<>();
        this.peli.getHighscore().setRivit(testiMappi);
        assertTrue(this.peli.getHighscore().kirjoita());
        assertEquals("4. 70 -tyhja-", this.peli.getHighscore().annaRiviListalta(3));
        assertEquals("3. 80 -tyhja-", this.peli.getHighscore().annaRiviListalta(2));

        testiMappi.put(900, "Oce");

        this.peli.getHighscore().setRivit(testiMappi);
        assertTrue(this.peli.getHighscore().kirjoita());
        assertEquals("1. 900 Oce", this.peli.getHighscore().annaRiviListalta(0));
        assertEquals("2. 100 -tyhja-", this.peli.getHighscore().annaRiviListalta(1));
        testiMappi.remove(900);
        this.peli.getHighscore().setRivit(testiMappi);
        this.peli.getHighscore().kirjoita();
    }

    @Test
    public void annaRiviListaltaToimii() {
        assertNotEquals("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨", this.peli.getHighscore().annaRiviListalta(0));
        assertEquals("1. 100 -tyhja-", this.peli.getHighscore().annaRiviListalta(0));
        assertEquals("2. 90 -tyhja-", this.peli.getHighscore().annaRiviListalta(1));
        assertEquals("6. 50 -tyhja-", this.peli.getHighscore().annaRiviListalta(5));
    }

    @Test
    public void onkoHighscoreToimii() {
        assertFalse(this.peli.getHighscore().onkoHighscore(7));
        assertTrue(this.peli.getHighscore().onkoHighscore(12));
        assertTrue(this.peli.getHighscore().onkoHighscore(99));
    }

    @Test
    public void jarjestaToimii() {
        Map<Integer, String> testiMappi = new LinkedHashMap<>();

        for (int i = 10; i > 0; i--) {
            testiMappi.put(i * 10, "" + i);
        }

        this.peli.getHighscore().setRivit(testiMappi);
        this.peli.getHighscore().onkoHighscore(1);

        List<Integer> testiLista = new ArrayList<>();
        for (Integer integer : this.peli.getHighscore().getRivit().keySet()) {
            testiLista.add(integer);
        }

        assertTrue(testiLista.get(0) > testiLista.get(9));
        assertTrue(testiLista.get(3) > testiLista.get(4));
        assertTrue(testiLista.get(8) < testiLista.get(3));
        assertFalse(testiLista.get(8) > testiLista.get(3));
    }
}
