package hackman.kayttoliittyma;

import hackman.kayttoliittyma.Nappaimistonkuuntelija;
import hackman.kayttoliittyma.Paivitettava;
import hackman.kayttoliittyma.Piirtaja;
import hackman.kartat.Kartta;
import hackman.kartat.Kartta1;
import hackman.kartat.Kartta2;
import hackman.peli.Peli;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Käyttöliittymä, joka huolehtii pelin valikoista ja käynnistyksestä.
 * @author oce
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private int sivunPituus;
    private Piirtaja piirto;
    public int pojot;

    public Kayttoliittyma(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.pojot = 0;
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
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Luo piirtäjän ikkunalle ja lisää ikkunalle näppäimistönkuuntelijan.
     * @param container Piirtoalue.
     */
    public void luoKomponentit(Container container) {
        this.piirto = new Piirtaja(this.peli, this.sivunPituus);
        this.peli.setPaivitettava(piirto);
        container.add(piirto);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(this.peli.getPelaaja(), this.peli, this);
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
        }
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Luo uuden pelin ensimmäisellä kartalla.
     */
    public void uusiPeli() {
        frame.remove(piirto);
        frame.removeKeyListener(frame.getKeyListeners()[0]);
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.peli.getLogiikka().setAlkaa();
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
    }
}
