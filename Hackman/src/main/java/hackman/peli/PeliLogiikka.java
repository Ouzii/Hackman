/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.peli;

import hackman.rakennuspalat.Palikka;
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
    private boolean vuoro;

    public PeliLogiikka(Peli peli) {
        this.peli = peli;
        this.pojot = 0;
        this.askelia = 0;
        this.vuoro = false;
    }

    public int getPojot() {
        return pojot;
    }

    public int getAskelia() {
        return askelia;
    }

    public boolean isVuoro() {
        return vuoro;
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
     * Tarkastaa, onko pelaajan edessä seinää ja liikuttaa, jos ei ole.
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
            return false;
        }
    }

    /**
     * Tarkistaa, osuuko pelaaja vihollisiin ja tappaa pelaajan sekä kutsuu
     * pelin havia-metodia, jos osuu.
     *
     * @param vihu
     */
    public void kuoleeko(Vihollinen vihu) {
        if (this.peli.getPelaaja().osuu(vihu)) {
            this.peli.getPelaaja().kuole();
            this.peli.havia();
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
