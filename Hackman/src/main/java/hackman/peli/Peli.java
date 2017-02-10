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

/**
 * Pelin logiikkaluokka. Huolehtii pelin tärkeimmistä toiminnoista ja muistaa
 * tärkeimmät muuttujat.
 *
 * @author Oce
 */
public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private boolean alkaa;
    private Pelihahmo pelaaja;
    private Kartta kartta;
    private boolean voita;
    private boolean havia;
    private boolean highscore;
    private PeliLogiikka logiikka;

    public Peli(int leveys, int korkeus, Kartta kartta) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.logiikka = new PeliLogiikka(this);
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = kartta;
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

    public Paivitettava getPaivitettava() {
        return paivitettava;
    }

    public boolean isHighscore() {
        return highscore;
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

    public PeliLogiikka getLogiikka() {
        return logiikka;
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

    /**
     * Metodi muuttaa pelin voita-tilaan ja pysäyttää Timerin.
     */
    public void voita() {
        this.voita = true;
        super.stop();
    }

    public boolean isHavia() {
        return havia;
    }

    /**
     * Metodi muuttaa pelin häviä-tilaan ja pysäyttää Timerin.
     */
    public void havia() {
        this.havia = true;
        super.stop();
    }

    public Kartta getKartta() {
        return this.kartta;
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

    /**
     * Hoitaa tapahtumien kulun, kun Timer antaa ActionEventin.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.logiikka.kuoleeko(this.kartta.getVihuPun());
        this.logiikka.kuoleeko(this.kartta.getVihuMus());
        this.logiikka.kuoleeko(this.kartta.getVihuKel());
        this.logiikka.kuoleeko(this.kartta.getVihuPin());
        if (this.logiikka.isVuoro() == false) {
            this.logiikka.liikuPelaaja();
            this.logiikka.setVuoro(true);
        } else {
            this.logiikka.askelLuku();
            this.logiikka.liikutaVihollisia();
            this.logiikka.setVuoro(false);
        }
        for (Bitti bitti : this.kartta.getBitit()) {
            if (this.pelaaja.osuu(bitti) && !bitti.isKeratty()) {
                bitti.setKeratty(true);
                this.logiikka.setPojot(this.logiikka.getPojot() + 1);
            }
        }
        if (this.logiikka.getPojot() == this.kartta.getBitit().size()) {
            this.voita();
        }
        paivitettava.paivita();
    }
}
