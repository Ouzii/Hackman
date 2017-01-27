package hackman.peli;

import hackman.logiikka.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private boolean alkaa;
    private Pelihahmo pelaaja;
    private Bitti bitti;
    private Palikka seina;
    private int pojot;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
        this.bitti = new Bitti(8, 8);
        this.seina = new Palikka(13, 13);
        this.pojot = 0;
        this.addActionListener(this);
        super.setDelay(100);
    }

    public Pelihahmo getPelaaja() {
        return this.pelaaja;
    }

    public Bitti getBitti() {
        return this.bitti;
    }

    public int getPojot() {
        return pojot;
    }
    
    public Palikka getSeina() {
        return seina;
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
    
    public void lopeta() {
        super.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paivitettava.paivita();
        System.out.println(this.pelaaja.osuuSeinaan(seina));
        if (!this.pelaaja.osuuSeinaan(this.seina)) {
            this.pelaaja.liiku();
        }
        
        if (this.pelaaja.getHahmo().osuu(this.bitti) && !this.bitti.isKeratty()) {
            this.bitti.setKeratty(true);
            this.pojot++;
        }

    }

}
