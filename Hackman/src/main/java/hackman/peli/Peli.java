package hackman.peli;

import hackman.kartat.Kartta;
import hackman.kayttoliittyma.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Pelin rakenneluokka. Yhdistää pelin eri osat yhteen ja hoitaa Timerin
 * tehtäviä.
 *
 * @author Oce
 */
public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private Pelihahmo pelaaja;
    private Kartta kartta;
    private PeliLogiikka logiikka;
    private Highscore highscore;

    /**
     * Konstruktori pelille, joka asettaa mittasuhteet oikein ja luo uuden
     * pelihahmon sekä käynnistää Timerin.
     *
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     * @param kartta Kartta.
     */
    public Peli(int leveys, int korkeus, Kartta kartta) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.logiikka = new PeliLogiikka(this);
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = kartta;
        this.highscore = new Highscore("");
        super.addActionListener(this);
        super.setInitialDelay(500);
        super.setDelay(135);
        super.stop();
    }

    /**
     * Toinen konstruktori, jolla pidetään String nimi tallessa.
     *
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     * @param kartta Kartta.
     * @param nimi Pelaajan antama nimi.
     */
    public Peli(int leveys, int korkeus, Kartta kartta, String nimi) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.logiikka = new PeliLogiikka(this);
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = kartta;
        this.highscore = new Highscore(nimi);
        super.addActionListener(this);
        super.setInitialDelay(500);
        super.setDelay(135);
        super.stop();
    }

//    HUOM !! KOODI SEKAVAA, KOSKA KOKEILUVAIHEESSA
    public Pelihahmo getPelaaja() {
        return this.pelaaja;
    }

    public Highscore getHighscore() {
        return highscore;
    }

    public Paivitettava getPaivitettava() {
        return paivitettava;
    }

    public PeliLogiikka getLogiikka() {
        return logiikka;
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
     * @param e Timerin antama ActionEvent.
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
                this.logiikka.setKeratty(this.logiikka.getKeratty() + 1);
            }
        }
        if (this.logiikka.getKeratty() == this.kartta.getBitit().size()) {
            this.logiikka.voita();
        }
        try {
            paivitettava.paivita();
        } catch (Exception ex) {
            super.restart();
        }
    }
}
