/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kayttoliittyma;

import hackman.kayttoliittyma.Nappaimistonkuuntelija;
import hackman.kayttoliittyma.Paivitettava;
import hackman.kayttoliittyma.Piirtaja;
import hackman.peli.Kartta1;
import hackman.peli.Peli;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author oce
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private int sivunPituus;
    private Piirtaja piirto;

    public Kayttoliittyma(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        this.peli = new Peli(20, 20);
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
        this.piirto = new Piirtaja(this.peli, this.sivunPituus, frame);
        this.peli.setPaivitettava(piirto);
        container.add(piirto);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(this.peli.getPelaaja(), this.peli);
        frame.addKeyListener(nk);
    }

    public Paivitettava getPaivitettava() {
        return this.piirto;
    }

}
