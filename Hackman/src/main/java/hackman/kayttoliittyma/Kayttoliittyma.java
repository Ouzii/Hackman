package hackman.kayttoliittyma;

import hackman.kartat.*;
import hackman.logiikka.Peli;
import java.awt.*;
import javax.swing.*;

/**
 * Käyttöliittymä, joka huolehtii pelin valikoista ja käynnistyksestä.
 *
 * @author oce
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private final int sivunPituus;
    private Piirtaja piirto;
    public int pojot;
    private String nimi;
    private MenunUlkoasu menunUlkoasu;

    /**
     * Konstruktori käyttöliittymälle, joka luo uuden pelin ja asettaa oikean
     * mittasuhteen pelille.
     *
     * @param sivunPituus Annettava koko palikoille pelissä.
     * @param error Kertoo käynnistetäänkö error-moodissa.
     * @param errorMsg Antaa tulostettavan merkkijonon.
     */
    public Kayttoliittyma(int sivunPituus, boolean error, String errorMsg) {
        this.sivunPituus = sivunPituus;
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.pojot = 0;
        this.nimi = "";
        this.menunUlkoasu = new MenunUlkoasu(this, error, errorMsg);

    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Käynnistää avattavan ikkunan.
     */
    @Override
    public void run() {
        frame = new JFrame("HACKMAN");
        int leveys = (this.peli.getLeveys()) * (this.sivunPituus + 2) - 4;
        int korkeus = (this.peli.getKorkeus()) * (this.sivunPituus + 3) - 2;
        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        this.menunUlkoasu.aseta();
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Peli getPeli() {
        return peli;
    }

    /**
     * Luo piirtäjän ikkunalle ja lisää ikkunalle näppäimistönkuuntelijan.
     * Lisäksi poistaa kirjautumisikkunan komponentit.
     *
     * @param container Piirtoalue.
     */
    public void luoKomponentit(Container container) {
        this.menunUlkoasu.poistaKomponentit();
        this.piirto = new Piirtaja(this.peli, this.sivunPituus, this);
        this.peli.setPaivitettava(piirto);
        container.add(piirto);
        NappaimistonKuuntelija nk = new NappaimistonKuuntelija(this.peli.getPelaaja(), this.peli, this);
        frame.addKeyListener(nk);
    }

    public Paivitettava getPaivitettava() {
        return this.piirto;
    }

    /**
     * Palauttaa päävalikkonäkymän.
     */
    public void menuun() {
        this.peli.getLogiikka().pysayta();
        this.piirto.paivita();
    }

    /**
     * Luo uuden pelin seuraavalla kartalla, jos edellinen kartta voitettu.
     */
    public void nextMap() {
        frame.remove(piirto);
        frame.removeKeyListener(frame.getKeyListeners()[0]);
        this.pojot = this.peli.getLogiikka().getPojot();
        if (this.peli.getKartta().toString().equals("Kartta1")) {
            asetaKartta(new Kartta2(20, 20));
        } else if (this.peli.getKartta().toString().equals("Kartta2")) {
            asetaKartta(new Kartta3(20, 20));
        } else if (this.peli.getKartta().toString().equals("Kartta3")) {
            asetaKartta(new Kartta4(20, 20));
        } else if (this.peli.getKartta().toString().equals("Kartta4")) {
            asetaKartta(new Kartta5(20, 20));
        } else if (this.peli.getKartta().toString().equals("Kartta5")) {
            this.uusiPeli();
            this.menuun();
            this.peli.getHighscore().setMenuun(true);
            this.peli.getHighscore().onkoHighscore(pojot);
            this.peli.getHighscore().kirjoita();
            return;
        }
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void asetaKartta(Kartta kartta) {
        this.peli = new Peli(20, 20, kartta, this.nimi);
        this.peli.getLogiikka().setPojot(this.pojot);
        this.peli.getLogiikka().setAlkaa();
    }

    /**
     * Luo uuden pelin ensimmäisellä kartalla.
     *
     * @return Peli palauttaa uuden pelin.
     */
    public Peli uusiPeli() {
        if (this.piirto != null) {
            frame.remove(piirto);
        }
        if (frame.getKeyListeners().length != 0) {
            frame.removeKeyListener(frame.getKeyListeners()[0]);
        }
        this.peli = new Peli(20, 20, new Kartta1(20, 20), this.nimi);
        this.peli.getLogiikka().setAlkaa();
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
        return this.peli;
    }
}
