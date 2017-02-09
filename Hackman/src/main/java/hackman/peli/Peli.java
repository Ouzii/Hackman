package hackman.peli;

import hackman.kartat.Kartta;
import hackman.kayttoliittyma.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Suunta;
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
    private int askelia;
    private int vuoro;
    private int pojot;
    private boolean voita;
    private boolean havia;
    private boolean highscore;

    public Peli(int leveys, int korkeus, Kartta kartta) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = kartta;
        this.pojot = 0;
        this.askelia = 0;
        this.vuoro = 0;
        this.alkaa = false;
        this.voita = false;
        this.havia = false;
        this.highscore = false;
        super.addActionListener(this);
        super.setInitialDelay(500);
        super.setDelay(200);
        super.stop();
    }

//    HUOM !! KOODI SEKAVAA, KOSKA KOKEILUVAIHEESSA
    public Pelihahmo getPelaaja() {
        return this.pelaaja;
    }

    public boolean isHighscore() {
        return highscore;
    }

    public Paivitettava getPaivitettava() {
        return paivitettava;
    }

    public void setHighscore(boolean highscore) {
        this.highscore = highscore;
    }

    public boolean isAlkaa() {
        return alkaa;
    }

    public void setAlkaa() {
        this.alkaa = true;
        super.start();
    }

    public void pysayta() {
        this.alkaa = false;
        super.stop();
    }

    public boolean isVoita() {
        return voita;
    }

    public void setVoita(boolean voita) {
        this.voita = voita;
    }

    public void voita() {
        this.voita = true;
        super.stop();
    }

    public boolean isHavia() {
        return havia;
    }

    public void havia() {
        this.havia = true;
        super.stop();
    }

    public int getPojot() {
        return pojot;
    }

    public void setPojot(int pojot) {
        this.pojot = pojot;
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

    public void liikuPelaaja() {
        int i = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if (!this.kartta.osuuSeinaan(this.pelaaja)) {
                i++;
            }
        }

        if (i >= this.korkeus) {
            pelaaja.liiku();
        }
    }

    public void kuoleeko(Vihollinen vihu) {
        if (this.pelaaja.osuuVihuun(vihu)) {
            this.havia();
        }
    }

    public void liikutaVihollisia() {
        this.kartta.liikuVihollinen(this.kartta.getVihuPun());
        this.kartta.getVihuMus().liikuVihollinenMus(this.pelaaja);
        this.kartta.liikuVihollinen(this.kartta.getVihuMus());
        this.kartta.getVihuKel().liikuVihollinenKel(this.pelaaja);
        this.kartta.liikuVihollinen(this.kartta.getVihuKel());
        this.kartta.getVihuPin().liikuVihollinenPin(this.pelaaja);
        this.kartta.liikuVihollinen(this.kartta.getVihuPin());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.kuoleeko(this.kartta.getVihuPun());
        this.kuoleeko(this.kartta.getVihuMus());
        this.kuoleeko(this.kartta.getVihuKel());
        this.kuoleeko(this.kartta.getVihuPin());

        if (this.vuoro == 0) {
            this.liikuPelaaja();
            this.vuoro++;
        } else {
            if (this.askelia >= 5) {
                this.kartta.getVihuPun().vaihdaSuunta();
                this.askelia = 0;
            } else {
                this.askelia++;
            }
            this.liikutaVihollisia();
            this.vuoro--;
        }

        for (Bitti bitti : this.kartta.getBitit()) {
            if (this.pelaaja.osuu(bitti) && !bitti.isKeratty()) {
                bitti.setKeratty(true);
                this.pojot++;
            }
        }

        if (this.pojot == this.kartta.getBitit().size()) {
            this.voita();
        }

        paivitettava.paivita();

    }

}
