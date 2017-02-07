/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.paaohjelma;

import hackman.kayttoliittyma.Kayttoliittyma;
import hackman.peli.Kartta1;
import hackman.peli.Peli;
import javax.swing.SwingUtilities;

/**
 *
 * @author oce
 */
public class Paaohjelma {

    public static void main(String[] args) {
//        Peli hackman = new Peli(20, 20, new Kartta1(20, 20));

        Kayttoliittyma kali = new Kayttoliittyma(20);
        SwingUtilities.invokeLater(kali);

        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Jokin meni pieleen, yritä uudestaan!");
            }
        }

        
//        hackman.start();

    }

}
