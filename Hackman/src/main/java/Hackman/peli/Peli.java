package Hackman.peli;

import Hackman.logiikka.Paivitettava;
import Hackman.rakennuspalat.Bitti;
import Hackman.rakennuspalat.Pelihahmo;
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
        this.bitti = new Bitti(leveys / 2, korkeus / 2);
        addActionListener(this);
        setInitialDelay(200);
        setDelay(100);
    }

    public Pelihahmo getPelaaja() {
        return pelaaja;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
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
