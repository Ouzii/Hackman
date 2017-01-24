package hackman.peli;

import hackman.logiikka.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private boolean alkaa;
    private Pelihahmo pelaaja;
    private Bitti bitti;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
//        this.bitti = new Bitti(leveys / 2, korkeus / 2);
        this.addActionListener(this);
        super.setInitialDelay(200);
        super.setDelay(100);
    }

    public Pelihahmo getPelaaja() {
            return this.pelaaja;
    }

    public int getLeveys() {
            return this.leveys;
    }

    public int getKorkeus() {
            return this.korkeus;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pelaaja.liiku();
        paivitettava.paivita();
    }

}
