package hackman.kayttoliittyma;

import hackman.logiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Napinkuuntelija, joka toteuttaa nimenanto-nappulalle toiminnallisuuden.
 *
 * @author Oce
 */
public class NapinKuuntelija implements ActionListener {


    private JTextField teksti;
    private Kayttoliittyma kali;

    /**
     * Konstruktori NapinKuuntelijalle, joka asettaa tarvittavat yhteydet.
     *
     * @param teksti Tekstikentän teksti, joka otetaan talteen.
     * @param kali Käyttöliittymä, jonka metodeja käytetään.
     */
    public NapinKuuntelija(JTextField teksti, Kayttoliittyma kali) {

        this.teksti = teksti;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.teksti.getText().length() > 20) {
            this.kali.getFrame().setVisible(false);
            this.kali.getFrame().removeAll();
            this.kali = new Kayttoliittyma(25, true, "Nimi liian pitkä!");
            SwingUtilities.invokeLater(kali);
        } else if (this.teksti.getText().trim().isEmpty()) {
            this.kali.getFrame().setVisible(false);
            this.kali.getFrame().removeAll();
            this.kali = new Kayttoliittyma(25, true, "Et antanut nimeäsi!");
            SwingUtilities.invokeLater(kali);
        } else {
            this.kali.getPeli().getHighscore().setNimi(this.teksti.getText());
            this.kali.setNimi(this.teksti.getText());
            this.kali.luoKomponentit(this.kali.getFrame().getContentPane());
            this.kali.getFrame().dispose();
            this.kali.getFrame().pack();
            this.kali.getFrame().setVisible(true);
        }
    }

}
