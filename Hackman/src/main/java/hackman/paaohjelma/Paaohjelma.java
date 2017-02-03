/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.paaohjelma;

import hackman.kayttoliittyma.Kayttoliittyma;
import hackman.peli.Peli;
import javax.swing.SwingUtilities;

/**
 *
 * @author oce
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Peli hackman = new Peli(20, 20);

        Kayttoliittyma kali = new Kayttoliittyma(hackman, 20);
        SwingUtilities.invokeLater(kali);

        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Jokin meni pieleen, yritä uudestaan!");
            }
        }

        hackman.setPaivitettava(kali.getPaivitettava());
        hackman.start();

    }

}
