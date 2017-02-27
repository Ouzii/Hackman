package hackman.logiikka;

import hackman.kartat.Kartta;
import hackman.kayttoliittyma.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Vihollinen;
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
    private Vaikeustaso vaikeustaso;
    private MenuTila menutila;

    /**
     * Konstruktori pelille, joka asettaa mittasuhteet oikein ja luo uuden
     * pelihahmon sekä käynnistää Timerin.
     *
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     * @param kartta Kartta.
     * @param highscoreTestMode kertoo, että halutaanko highscore-luokka
     * ajettavan testitilassa vai ei.
     */
    public Peli(int leveys, int korkeus, Kartta kartta, boolean highscoreTestMode) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.logiikka = new PeliLogiikka(this);
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = kartta;
        this.highscore = new Highscore("", highscoreTestMode);
        this.vaikeustaso = Vaikeustaso.NORMAALI;
        this.menutila = MenuTila.MENU;
        super.addActionListener(this);
        super.setInitialDelay(500);
        super.setDelay(150);
        super.stop();
    }

    /**
     * Toinen konstruktori, jolla pidetään String nimi tallessa.
     *
     * @param leveys Kartan leveys.
     * @param korkeus Kartan korkeus.
     * @param kartta Kartta.
     * @param nimi Pelaajan antama nimi.
     * @param vaikeustaso Vaikeustaso, joka asetetaan pelille.
     * @param highscoreTestMode kertoo, että halutaanko highscore-luokka
     * ajettavan testitilassa vai ei.
     */
    public Peli(int leveys, int korkeus, Kartta kartta, String nimi, Vaikeustaso vaikeustaso, boolean highscoreTestMode) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.logiikka = new PeliLogiikka(this);
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = kartta;
        this.highscore = new Highscore(nimi, highscoreTestMode);
        this.menutila = MenuTila.MENU;
        this.setVaikeustaso(vaikeustaso);
        super.addActionListener(this);
        super.setInitialDelay(500);
        super.stop();
    }

//    HUOM !! KOODI SEKAVAA, KOSKA KOKEILUVAIHEESSA
    public Vaikeustaso getVaikeustaso() {
        return vaikeustaso;
    }

    public MenuTila getMenutila() {
        return menutila;
    }

    public void setMenutila(MenuTila menutila) {
        this.menutila = menutila;
    }

    /**
     * Asettaa pelin vaikeustason ja muokkaa Timerin ajastusta sen mukaan.
     *
     * @param vaikeustaso Haluttu vaikeustaso.
     */
    public void setVaikeustaso(Vaikeustaso vaikeustaso) {
        switch (vaikeustaso) {
            case HELPPO:
                super.setDelay(200);
                break;
            case NORMAALI:
                super.setDelay(125);
                break;
            default:
                super.setDelay(75);
                break;
        }
        this.vaikeustaso = vaikeustaso;
    }

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

    private void lisaaPisteet() {
        for (Bitti bitti : this.kartta.getBitit()) {
            if (this.pelaaja.osuu(bitti) && !bitti.isKeratty()) {
                bitti.setKeratty(true);
                switch (this.vaikeustaso) {
                    case HELPPO:
                        this.logiikka.setPojot(this.logiikka.getPojot() + 1);
                        break;
                    case NORMAALI:
                        this.logiikka.setPojot(this.logiikka.getPojot() + 2);
                        break;
                    default:
                        this.logiikka.setPojot(this.logiikka.getPojot() + 3);
                        break;
                }
                this.logiikka.setKeratty(this.logiikka.getKeratty() + 1);
            }
        }
    }

    /**
     * Hoitaa tapahtumien kulun, kun Timer antaa ActionEventin.
     *
     * @param e Timerin antama ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.paivitettava.paivita();
        } catch (Exception ex) {
            super.restart();
        }
        for (Vihollinen vihu : this.kartta.getVihut()) {
            this.logiikka.kuoleeko(vihu);
        }
        if (this.logiikka.isVuoro() == false) {
            this.logiikka.liikuPelaaja();
            this.logiikka.setVuoro(true);
        } else {
            this.logiikka.askelLuku();
            this.logiikka.liikutaVihollisia();
            this.logiikka.setVuoro(false);
        }
        
        this.lisaaPisteet();
        
        if (this.logiikka.getKeratty() == this.kartta.getBitit().size()) {
            this.logiikka.voita();
        }
    }
}
