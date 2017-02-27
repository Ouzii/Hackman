package hackman.paaohjelma;

import hackman.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 * Pääohjelma-luokka, joka käynnistyy, kun ohjelma käynnistetään. Hoitaa
 * käyttöliittymän käynnistämisen.
 *
 * @author oce
 */
public class Paaohjelma {

    /**
     * Luo ja käynnistää käyttöliittymän.
     *
     * @param args Javan komennot String muodossa.
     */
    public static void main(String[] args) {

        Kayttoliittyma kali = new Kayttoliittyma(25, false, "");
        SwingUtilities.invokeLater(kali);

//        while (kali.getPaivitettava() == null) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Thread.yield();
//            }
//        }
    }

}
