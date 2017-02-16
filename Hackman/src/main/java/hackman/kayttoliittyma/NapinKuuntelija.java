package hackman.kayttoliittyma;

import hackman.peli.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Napinkuuntelija, joka toteuttaa nimenanto-nappulalle toiminnallisuuden.
 *
 * @author Oce
 */
public class NapinKuuntelija implements ActionListener {

    private Peli peli;
    private JTextField teksti;
    private Kayttoliittyma kali;

    /**
     * Konstruktori NapinKuuntelijalle, joka asettaa tarvittavat yhteydet.
     *
     * @param peli Peliluokka, joka on käynnissä.
     * @param teksti Tekstikentän teksti, joka otetaan talteen.
     * @param kali Käyttöliittymä, jonka metodeja käytetään.
     */
    public NapinKuuntelija(Peli peli, JTextField teksti, Kayttoliittyma kali) {
        this.peli = peli;
        this.teksti = teksti;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.teksti.getText().length() <= 20) {
            this.kali.setNimi(this.teksti.getText());
            this.peli.getLogiikka().setKirjaudu(true);
            this.kali.luoKomponentit(this.kali.getFrame().getContentPane());
            this.kali.getFrame().dispose();
            this.kali.getFrame().pack();
            this.kali.getFrame().setVisible(true);
        } else {
            this.kali.getFrame().setVisible(false);
            this.kali.getFrame().removeAll();
            this.kali = new Kayttoliittyma(20, true);
            this.teksti.setName("Nimi liian pitkä!");
            SwingUtilities.invokeLater(kali);
        }
    }

}
