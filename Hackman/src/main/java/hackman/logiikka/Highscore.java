package hackman.logiikka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Highscore-luokka, joka huolehtii huipputulosten kirjaamisesta ja
 * järjestämisestä.
 *
 * @author Oce
 */
public class Highscore {

    private Scanner lukija;
    private Map<Integer, String> rivit;
    private List<String> rivitLista;
    private String nimi;
    private boolean menuun;

    /**
     * Luo LinkedHashMapin, jossa pidetään kirjaa pisteistä ja scannerin, joka
     * lukee pisteet tekstitiedostosta.
     *
     * @param nimi Pelaajan antama nimi.
     */
    public Highscore(String nimi) {
        this.rivit = new LinkedHashMap<>();
        this.nimi = nimi;
        this.menuun = false;
        this.rivitLista = new ArrayList<>();
        try {
//            InputStream is = getClass().getClassLoader().getResourceAsStream("highscore.txt");
//            this.lukija = new Scanner(is, StandardCharsets.UTF_8.name());
            this.lisaaKarttaan();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getNimi() {
        return nimi;
    }

    public Map<Integer, String> getRivit() {
        return rivit;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public boolean isMenuun() {
        return menuun;
    }

    public void setMenuun(boolean menuun) {
        this.menuun = menuun;
    }

    /**
     * Antaa rivit järjestyksessä.
     *
     * @param i monesko rivi.
     * @return rivi String muodossa.
     */
    public String annaRiviListalta(int i) {
        this.lisaaListaan();
        return this.rivitLista.get(i);
    }

    private void lisaaListaan() {
        int i = 1;
        this.rivitLista.clear();
        for (Integer integer : this.rivit.keySet()) {
            this.rivitLista.add(i + ". " + integer + " " + this.rivit.get(integer));
            i++;
        }
    }

    private void lisaaKarttaan() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("highscore.txt");
            this.lukija = new Scanner(is, StandardCharsets.UTF_8.name());
            int riveja = 0;
            while (this.lukija.hasNextLine()) {
                String s = this.lukija.nextLine();
                String[] apu = s.split(" ");
                this.rivit.put(Integer.parseInt(apu[1]), apu[2]);
                riveja++;
            }
            if (riveja < 10) {
                int score = 10;
                while (riveja < 10) {
                    this.rivit.put(score, "-tyhja-");
                    riveja++;
                    score += 10;
                }
            }
            this.jarjesta();
            this.lukija.close();
        } catch (Exception e) {
        }
    }

    private void jarjesta() {
        List<Integer> apu = new ArrayList<>();
        for (Integer integer : this.rivit.keySet()) {
            apu.add(integer);
        }
        Collections.sort(apu);
        Map<Integer, String> apuMap = new LinkedHashMap<>();
        for (int i = 1; i <= 10; i++) {
            apuMap.put(apu.get(apu.size() - i), this.rivit.get(apu.get(apu.size() - i)));
        }

        this.rivit = apuMap;
    }

    /**
     * Tarkastaa, onko pelaajan saavuttamat pisteet tarpeeksi suuret listalle
     * päästäkseen.
     *
     * @param pojot Pelaajan keräämät pisteet kutsuntahetkellä.
     */
    public void onkoHighscore(int pojot) {
        List<Integer> apu = new ArrayList<>();
        for (Integer integer : this.rivit.keySet()) {
            apu.add(integer);
        }

        if (pojot > apu.get(apu.size() - 1)) {
            this.rivit.put(pojot, this.nimi);
        }

        this.jarjesta();
    }

    /**
     * Kirjoittaa pisteet tekstitiedostoon.
     *
     * @return Palauttaa true, jos onnistuu ja false, jos ei onnistu.
     */
    public boolean kirjoita() {
        try {
            BufferedWriter kirjoittaja = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/highscore.txt"), "UTF-8"));
//            FileWriter kirjoittaja = new FileWriter(new File("src/main/highscore.txt", "UTF-8"));
            int i = 1;
            for (Integer integer : this.rivit.keySet()) {
                kirjoittaja.write(i + ". " + integer + " " + this.rivit.get(integer) + "\n");
                i++;
            }
            kirjoittaja.flush();
            kirjoittaja.close();
            this.lisaaKarttaan();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
