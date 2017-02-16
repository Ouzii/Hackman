package hackman.peli;

import java.io.File;
import java.io.FileWriter;
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
    private String nimi;
    private boolean menuun;

    /**
     * Luo LinkedHashMapin, jossa pidetään kirjaa pisteistä ja scannerin, joka
     * lukee pisteet tekstitiedostosta.
     */
    public Highscore(String nimi) {
        this.rivit = new LinkedHashMap<>();
        this.nimi = nimi;
        this.menuun = false;
        try {
            this.lukija = new Scanner(new File("src/main/resources/highscore.txt"), "UTF-8");
            this.lisaaListaan();
        } catch (Exception e) {
            
        }
    }

    public String getNimi() {
        return nimi;
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

    private void lisaaListaan() {
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
     */
    public boolean kirjoita() {
        try {
            FileWriter kirjoittaja = new FileWriter(new File("src/main/resources/highscore.txt"));
            int i = 1;
            for (Integer integer : this.rivit.keySet()) {
                kirjoittaja.append(i + ". " + integer + " " + this.rivit.get(integer) + "\n");
                i++;
            }
            kirjoittaja.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
