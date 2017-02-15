package hackman.kayttoliittyma;

import hackman.kayttoliittyma.NappaimistonKuuntelija;
import hackman.kayttoliittyma.Paivitettava;
import hackman.kayttoliittyma.Piirtaja;
import hackman.kartat.Kartta1;
import hackman.kartat.Kartta2;
import hackman.kartat.Kartta3;
import hackman.kartat.Kartta4;
import hackman.kartat.Kartta5;
import hackman.peli.Peli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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

    public Kayttoliittyma(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.pojot = 0;
        this.nimi = "";

    }

    public String getNimi() {
        return nimi;
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
        int leveys = (peli.getLeveys()) * (sivunPituus + 2) - 4;
        int korkeus = (peli.getKorkeus()) * (sivunPituus + 3) - 2;
        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        BorderLayout l = new BorderLayout();
//        frame.setLayout(l);
//        JButton b = new JButton("Kirjaudu");
//        b.setPreferredSize(new Dimension(150, 150));
//        JTextField t = new JTextField("Anna nimesi: ");
//        b.addActionListener(new NapinKuuntelija(this.peli, t, this));
//        frame.add(t, BorderLayout.CENTER);
//        frame.add(b, BorderLayout.SOUTH);

        luoKomponentit(frame.getContentPane());

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
            this.peli.getLogiikka().setHighscore(true);
            return;
        }
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo uuden pelin ensimmäisellä kartalla.
     */
    public Peli uusiPeli() {
        frame.setLayout(null);
        if (this.piirto != null) {
            frame.remove(piirto);
        }
        if (frame.getKeyListeners().length != 0) {
            frame.removeKeyListener(frame.getKeyListeners()[0]);
        }
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.peli.getLogiikka().setAlkaa();
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
        return this.peli;
    }
}
