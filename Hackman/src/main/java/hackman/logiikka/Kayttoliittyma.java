/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.logiikka;

import hackman.peli.Peli;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author oce
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli hackman;
    private int sivunPituus;
    private Piirto piirto;

    public Kayttoliittyma(Peli hackman, int sivunPituus) {
        this.hackman = hackman;
        this.sivunPituus = sivunPituus;
    }

    @Override
    public void run() {
        frame = new JFrame("HACKMAN");
        int leveys = (hackman.getLeveys()) * (sivunPituus + 3);
        int korkeus = (hackman.getKorkeus()) * (sivunPituus + 4);

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        this.piirto = new Piirto(this.hackman, this.sivunPituus);
        container.add(piirto);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(this.hackman.getPelaaja(), this.hackman);
        frame.addKeyListener(nk);
    }

    public Paivitettava getPaivitettava() {
        return this.piirto;
    }

}
