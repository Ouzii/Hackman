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
 *
 * @author Oce
 */
public class NapinKuuntelija implements ActionListener {
    
    private Peli peli;
    private JTextField teksti;
//    private Piirtaja piirto;
    private Kayttoliittyma kali;

    public NapinKuuntelija(Peli peli, JTextField t,Kayttoliittyma kali) {
        this.peli = peli;
        this.teksti = t;
//        this.piirto = piirto;
        this.kali = kali;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.peli.getLogiikka().setNimi(this.teksti.getText());
        this.peli.getLogiikka().setKirjaudu(true);
        this.kali.uusiPeli();
        this.kali.getPaivitettava().paivita();
        this.kali.getFrame().removeAll();
        System.out.println(this.teksti.getText());
        System.out.println(this.peli.getLogiikka().isKirjaudu());
    }
    
}
