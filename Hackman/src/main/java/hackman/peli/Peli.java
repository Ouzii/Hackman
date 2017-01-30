package hackman.peli;

import hackman.logiikka.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Vihollinen;
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
    private Palikka seina1;
    private Kartta kartta;
    private Vihollinen vihu;
    private int askelia;
    private int pojot;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = new Kartta(20, 20);
        this.pojot = 0;
        this.vihu = new Vihollinen(4, 3);
        this.askelia = 0;
        this.addActionListener(this);
        super.setDelay(400);
    }

//    HUOM !! KOODI SEKAVAA, KOSKA KOKEILUVAIHEESSA
    public Pelihahmo getPelaaja() {
        return this.pelaaja;
    }

    public Vihollinen getVihu() {
        return vihu;
    }

    public int getPojot() {
        return pojot;
    }

    public Kartta getKartta() {
        return this.kartta;
    }

    public void setAskelia(int askelia) {
        this.askelia = askelia;
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

        if (this.pelaaja.getHahmo().osuu(this.vihu.getHahmo())) {
            this.pelaaja.kuole();
            super.stop();
        }

        int i = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if (!this.kartta.osuuSeinaan(this.pelaaja)) {
                i++;
            }
        }

        if (i >= this.korkeus) {
            pelaaja.liiku();
        }
        if(this.askelia >= 5) {
            this.vihu.vaihdaSuunta();
            this.askelia = 0;
        } else {
            this.askelia++;
        }
        int a = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if (!this.kartta.osuuSeinaan(this.vihu)) {
                a++;
            }
        }
        if (a >= this.korkeus) {
            vihu.liiku();
        } else {
            this.vihu.vaihdaSuunta();
        }

        for (Bitti bitti : this.kartta.getBitit()) {
            if (this.pelaaja.getHahmo().osuu(bitti) && !bitti.isKeratty()) {
                bitti.setKeratty(true);
                this.pojot++;
            }
        }

        paivitettava.paivita();

    }

}
