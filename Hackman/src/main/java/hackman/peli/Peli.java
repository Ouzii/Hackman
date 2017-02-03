package hackman.peli;

import hackman.kayttoliittyma.Paivitettava;
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
    private Kartta kartta;
    private Vihollinen vihu;
    private int askelia;
    private int vuoro;
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
        this.vuoro = 0;
        this.addActionListener(this);
        super.setDelay(200);
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

        if (this.pelaaja.osuuVihuun(this.vihu)) {
            super.stop();
        }

        if (this.vuoro == 0) {
            int i = 0;
            for (Palikka seina : this.kartta.getSeinat()) {
                if (!this.kartta.osuuSeinaan(this.pelaaja)) {
                    i++;
                }
            }

            if (i >= this.korkeus) {
                pelaaja.liiku();
            }
            this.vuoro++;
        } else {
            if (this.askelia >= 5) {
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
            this.vuoro--;
        }
        for (Bitti bitti : this.kartta.getBitit()) {
            if (this.pelaaja.osuu(bitti) && !bitti.isKeratty()) {
                bitti.setKeratty(true);
                this.pojot++;
            }
        }

        paivitettava.paivita();

    }

}
