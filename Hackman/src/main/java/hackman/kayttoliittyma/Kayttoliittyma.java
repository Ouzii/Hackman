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

    public void menu() {
        this.peli.pysayta();
        this.piirto.paivita();
    }

    public void nextMap() {
        frame.remove(piirto);
        frame.removeKeyListener(frame.getKeyListeners()[0]);
        this.pojot = this.peli.getPojot();
        if (this.peli.getKartta().toString().equals("Kartta1")) {
            this.peli = new Peli(20, 20, new Kartta2(20, 20));
            this.peli.setPojot(this.pojot);
            this.peli.setAlkaa();
        }
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
    }

    public void uusiPeli() {
        frame.remove(piirto);
        frame.removeKeyListener(frame.getKeyListeners()[0]);
        this.peli = new Peli(20, 20, new Kartta1(20, 20));
        this.peli.setAlkaa();
        this.luoKomponentit(frame);
        frame.pack();
        frame.setVisible(true);
    }
}
