/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kayttoliittyma;

import hackman.peli.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Napinkuuntelija, joka toteuttaa nimenanto-nappulalle toiminnallisuuden.
 * @author Oce
 */
public class NapinKuuntelija implements ActionListener {

    private Peli peli;
    private JTextField teksti;
//    private Piirtaja piirto;
    private Kayttoliittyma kali;

    /**
     * Konstruktori NapinKuuntelijalle, joka asettaa tarvittavat yhteydet.
     * @param peli Peliluokka, joka on käynnissä.
     * @param t Tekstikentän teksti, joka otetaan talteen.
     * @param kali Käyttöliittymä, jonka metodeja käytetään.
     */
    public NapinKuuntelija(Peli peli, JTextField t, Kayttoliittyma kali) {
        this.peli = peli;
        this.teksti = t;
//        this.piirto = piirto;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.kali.setNimi(this.teksti.getText());
        this.peli = this.kali.uusiPeli();
        this.kali.getFrame().removeAll();
        this.peli.getLogiikka().setKirjaudu(true);
        if (this.peli.getPaivitettava() != null) {
            this.peli.getPaivitettava().paivita();
        } else {
            System.out.println("asddd");
        }
        this.kali.getFrame().repaint();
        System.out.println(this.teksti.getText());
        System.out.println(this.peli.getLogiikka().isKirjaudu());
    }

}
