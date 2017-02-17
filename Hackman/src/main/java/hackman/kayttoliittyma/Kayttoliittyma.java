package hackman.kayttoliittyma;

import hackman.kartat.*;
import hackman.peli.Peli;
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
    private JButton nappi;
    private JTextField tekstikentta;
    private JLabel merkinta;

    /**
     * Konstruktori käyttöliittymälle, joka luo uuden pelin ja asettaa oikean
     * mittasuhteen pelille.
     *
     * @param sivunPituus Annettava koko palikoille pelissä.
     * @param error Kertoo käynnistetäänkö error-moodissa.
     */
    public Kayttoliittyma(int sivunPituus, boolean error) {
        this.sivunPituus = sivunPituus;
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.pojot = 0;
        this.nimi = "";
        this.nappi = new JButton("Kirjaudu");
        this.tekstikentta = new JTextField("");
        if (!error) {
            this.merkinta = new JLabel("Anna nimesi: (max. 20 merkkiä)", SwingConstants.CENTER);
        } else {
            this.merkinta = new JLabel("Liian pitkä nimi!", SwingConstants.CENTER);
        }
        this.asetaUlkoasu();
    }

    private void asetaUlkoasu() {
        Font fontti = new Font("Comic Sans MS", Font.BOLD, 34);
        Font fontti2 = new Font("Comic Sans MS", Font.BOLD, 24);
        Dimension dimenssio = new Dimension(150, 150);
        this.merkinta.setFont(fontti2);
        this.nappi.setFont(fontti);
        this.tekstikentta.setFont(fontti);
        this.merkinta.setOpaque(true);
        this.merkinta.setBackground(Color.BLACK);
        this.merkinta.setForeground(Color.WHITE);
        this.merkinta.setPreferredSize(dimenssio);
        this.tekstikentta.setOpaque(true);
        this.tekstikentta.setBorder(null);
        this.tekstikentta.setBackground(Color.BLACK);
        this.tekstikentta.setForeground(Color.RED);
        this.tekstikentta.setPreferredSize(dimenssio);
        this.tekstikentta.setHorizontalAlignment(SwingConstants.CENTER);
        this.nappi.setOpaque(true);
        this.nappi.setBackground(Color.WHITE);
        this.nappi.setForeground(Color.BLACK);
        this.nappi.setPreferredSize(dimenssio);
    }

    public String getNimi() {
        return nimi;
    }

    /**
     * Asettaa JTextFieldistä saadun merkkijonon pelaajan nimeksi
     * Highscore-luokkaan.
     *
     * @param nimi pelaajan antama nimi.
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
        this.peli.getHighscore().setNimi(nimi);
    }

    /**
     * Käynnistää avattavan ikkunan.
     */
    @Override
    public void run() {
        frame = new JFrame("HACKMAN");
        int leveys = (peli.getLeveys()) * (sivunPituus + 2) - 4;
        int korkeus = (peli.getKorkeus()) * (sivunPituus + 3) - 2;
        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout l = new BorderLayout();
        frame.setLayout(l);
        this.nappi.addActionListener(new NapinKuuntelija(this.peli, this.tekstikentta, this));
        frame.add(this.merkinta, BorderLayout.NORTH);
        frame.add(this.tekstikentta, BorderLayout.CENTER);
        frame.add(this.nappi, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Luo piirtäjän ikkunalle ja lisää ikkunalle näppäimistönkuuntelijan.
     *
     * @param container Piirtoalue.
     */
    public void luoKomponentit(Container container) {
        frame.remove(this.merkinta);
        frame.remove(this.nappi);
        frame.remove(this.tekstikentta);
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
    public void menu() {
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
            this.peli = new Peli(20, 20, new Kartta2(20, 20));
            this.peli.getLogiikka().setPojot(this.pojot);
            this.peli.getLogiikka().setAlkaa();
        } else if (this.peli.getKartta().toString().equals("Kartta2")) {
            this.peli = new Peli(20, 20, new Kartta3(20, 20));
            this.peli.getLogiikka().setPojot(this.pojot);
            this.peli.getLogiikka().setAlkaa();
        } else if (this.peli.getKartta().toString().equals("Kartta3")) {
            this.peli = new Peli(20, 20, new Kartta4(20, 20));
            this.peli.getLogiikka().setPojot(this.pojot);
            this.peli.getLogiikka().setAlkaa();
        } else if (this.peli.getKartta().toString().equals("Kartta4")) {
            this.peli = new Peli(20, 20, new Kartta5(20, 20));
            this.peli.getLogiikka().setPojot(this.pojot);
            this.peli.getLogiikka().setAlkaa();
        } else if (this.peli.getKartta().toString().equals("Kartta5")) {
            this.uusiPeli();
            this.menu();
            this.peli.getHighscore().setMenuun(true);
            this.peli.getHighscore().onkoHighscore(pojot);
            this.peli.getHighscore().kirjoita();
            return;
        }
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
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
