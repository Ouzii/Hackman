package hackman.logiikka;

import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.Vihollinen;

/**
 * Luokka, joka hoitaa peliin liittyviä loogisia metodeja.
 *
 * @author Oce
 */
public class PeliLogiikka {

    private Peli peli;
    private int pojot;
    private int askelia;
    private int keratty;
    private boolean vuoro;
//    private boolean voita;
//    private boolean havia;
    private Pelitila pelitila;

    /**
     * Konstruktori PeliLogiikalle, joka asettaa asetukset alkutilaan luotaessa.
     *
     * @param peli Peli, johon logiikat liittyvät.
     */
    public PeliLogiikka(Peli peli) {
        this.peli = peli;
        this.pojot = 0;
        this.askelia = 0;
        this.keratty = 0;
        this.vuoro = false;
//        this.voita = false;
//        this.havia = false;
        this.pelitila = Pelitila.NEUTRAALI;
    }

    public Pelitila getPelitila() {
        return pelitila;
    }

    public void setPelitila(Pelitila pelitila) {
        this.pelitila = pelitila;
    }

//    public boolean isVoita() {
//        return voita;
//    }
//
//    public void setVoita(boolean voita) {
//        this.voita = voita;
//    }

    public int getPojot() {
        return pojot;
    }

    public int getAskelia() {
        return askelia;
    }

    public boolean isVuoro() {
        return vuoro;
    }

    public int getKeratty() {
        return keratty;
    }

    public void setKeratty(int keratty) {
        this.keratty = keratty;
    }

    public void setPojot(int pojot) {
        this.pojot = pojot;
    }

    public void setVuoro(boolean vuoro) {
        this.vuoro = vuoro;
    }

    public void setAskelia(int askelia) {
        this.askelia = askelia;
    }

    /**
     * Metodi muuttaa pelin voita-tilaan ja pysäyttää Timerin.
     */
    public void voita() {
//        this.voita = true;
        this.pelitila = Pelitila.VOITTO;
        this.peli.stop();
    }

    /**
     * Metodi muuttaa pelin häviä-tilaan ja pysäyttää Timerin. Lisäksi kirjaa
     * pisteet huipputulosten listalle, jos tarvetta.
     */
    public void havia() {
//        this.havia = true;
        this.pelitila = Pelitila.HAVIO;
        this.peli.getHighscore().onkoHighscore(this.pojot);
        this.peli.getHighscore().kirjoita();
        this.peli.stop();
    }

//    public boolean isHavia() {
//        return havia;
//    }

    /**
     * Tarkastaa, onko pelaajan edessä seinää ja liikuttaa, jos ei ole. Vaihtaa
     * suunnan vastakkaiseksi, jos osutaan seinään.
     *
     * @return true, jos liikutaan ja false, jos ei liikuta.
     */
    public boolean liikuPelaaja() {
        int i = 0;
        for (Palikka seina : this.peli.getKartta().getSeinat()) {
            if (!this.peli.getKartta().osuuSeinaan(this.peli.getPelaaja())) {
                i++;
            }
        }
        if (i >= this.peli.getKorkeus()) {
            this.peli.getPelaaja().liiku();
            return true;
        } else {
            switch (this.peli.getPelaaja().getSuunta()) {
                case ALAS:
                    this.peli.getPelaaja().setSuunta(Suunta.YLOS);
                    break;
                case YLOS:
                    this.peli.getPelaaja().setSuunta(Suunta.ALAS);
                    break;
                case OIKEA:
                    this.peli.getPelaaja().setSuunta(Suunta.VASEN);
                    break;
                case VASEN:
                    this.peli.getPelaaja().setSuunta(Suunta.OIKEA);
                    break;
                default:
                    break;
            }
            return false;
        }
    }

    /**
     * Tarkistaa, osuuko pelaaja vihollisiin ja tappaa pelaajan sekä kutsuu
     * pelin havia-metodia, jos osuu.
     *
     * @param vihu Vihollinen, jonka osumiseen tarkistetaan.
     */
    public void kuoleeko(Vihollinen vihu) {
        if (this.peli.getPelaaja().osuu(vihu)) {
            this.peli.getPelaaja().kuole();
            this.havia();
        }
    }

    /**
     * Kutsuu pelin kartan vihollisten liikuttamismetodeja.
     */
    public void liikutaVihollisia() {
        this.peli.getKartta().liikuVihollinen(this.peli.getKartta().getVihuPun());
        this.peli.getKartta().getVihuMus().liikuVihollinenMus(this.peli.getPelaaja());
        this.peli.getKartta().liikuVihollinen(this.peli.getKartta().getVihuMus());
        this.peli.getKartta().getVihuKel().liikuVihollinenKel(this.peli.getPelaaja());
        this.peli.getKartta().liikuVihollinen(this.peli.getKartta().getVihuKel());
        this.peli.getKartta().getVihuPin().liikuVihollinenPin(this.peli.getPelaaja());
        this.peli.getKartta().liikuVihollinen(this.peli.getKartta().getVihuPin());
    }

    /**
     * Joka kolmannella askeleella muuttaa punaisen vihollisen suuntaa
     * satunnaisesti.
     *
     * @return true, jos muutetaan suuntaa ja false, jos ei muuteta.
     */
    public boolean askelLuku() {
        if (this.askelia >= 2) {
            this.peli.getKartta().getVihuPun().vaihdaSuunta();
            this.askelia = 0;
            return true;
        } else {
            this.askelia++;
            return false;
        }
    }
}
