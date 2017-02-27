/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kayttoliittyma;

import hackman.logiikka.Peli;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Huolehtii päävalikkonäkymän grafiikoiden piirtämisestä.
 * @author Oce
 */
public class MenunPiirtaja {

    private int palikanKoko;
    private Kayttoliittyma kali;

    /**
     * Asettaa viitteet oikein.
     * @param kali Käyttöliittymä.
     * @param palikanKoko Palikan koko.
     */
    public MenunPiirtaja(Kayttoliittyma kali, int palikanKoko) {
        this.palikanKoko = palikanKoko;
        this.kali = kali;
    }

    /**
     * Piirtää menuikkunan.
     * @param g Grafiikan luonti Javassa.
     */
    public void piirraMenu(Graphics g) {
        this.piirraOhjeet(g);
        this.piirraVaikeustaso(g);
    }

    private void piirraOhjeet(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Aloita/jatka peliä ", 5 * this.palikanKoko, 4 * this.palikanKoko);
        g.drawString("painamalla <Enter>", 5 * this.palikanKoko, 5 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Tulosta huipputulokset", 5 * this.palikanKoko, 7 * this.palikanKoko);
        g.drawString("painamalla <F1>", 7 * this.palikanKoko, 8 * this.palikanKoko);
        g.setColor(Color.BLACK);
        g.drawString("Pelissä paina <R>", 5 * this.palikanKoko, 10 * this.palikanKoko);
        g.drawString("aloittaaksesi alusta", 7 * this.palikanKoko, 11 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Pelissä paina <P>", 5 * this.palikanKoko, 13 * this.palikanKoko);
        g.drawString("pysäyttääksesi pelin", 7 * this.palikanKoko, 14 * this.palikanKoko);
        g.setColor(Color.BLACK);
        g.drawString("Paina <Esc> vaihtaaksesi", 5 * this.palikanKoko, 16 * this.palikanKoko);
        g.drawString("käyttäjän nimeä", 7 * this.palikanKoko, 17 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Muuta vaikeustasoa", 5 * this.palikanKoko, 19 * this.palikanKoko);
        g.drawString("painamalla <+> ja <->", 7 * this.palikanKoko, 20 * this.palikanKoko);
    }

    private void piirraVaikeustaso(Graphics g) {
        g.setColor(Color.BLACK);
        switch (this.kali.getPeli().getVaikeustaso()) {
            case HELPPO:
                g.setColor(Color.RED);
                g.drawString("HELPPO", 3 * this.palikanKoko - 4, 2 * this.palikanKoko);
                g.setColor(Color.BLACK);
                g.drawString("NORMAALI", 8 * this.palikanKoko, 2 * this.palikanKoko);
                g.drawString("VAIKEA", 15 * this.palikanKoko, 2 * this.palikanKoko);
                break;
            case NORMAALI:
                g.drawString("HELPPO", 3 * this.palikanKoko - 4, 2 * this.palikanKoko);
                g.setColor(Color.RED);
                g.drawString("NORMAALI", 8 * this.palikanKoko, 2 * this.palikanKoko);
                g.setColor(Color.BLACK);
                g.drawString("VAIKEA", 15 * this.palikanKoko, 2 * this.palikanKoko);
                break;
            default:
                g.drawString("HELPPO", 3 * this.palikanKoko - 4, 2 * this.palikanKoko);
                g.drawString("NORMAALI", 8 * this.palikanKoko, 2 * this.palikanKoko);
                g.setColor(Color.RED);
                g.drawString("VAIKEA", 15 * this.palikanKoko, 2 * this.palikanKoko);
                break;
        }
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.BLUE);
        g.drawString("0.5x pisteet                1.0x pisteet                  1.5x pisteet", 3 * this.palikanKoko + 5, 2 * this.palikanKoko + 14);
    }

    /**
     * Piirtää highscore-ikkunan.
     * @param g Grafiikan luonti Javassa.
     */
    public void piirraHighscore(Graphics g) {
        try {
            this.kali.getPeli().getHighscore().kirjoita();
            g.setColor(Color.BLUE);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            g.drawString("Sija   pisteet     nimi", 6 * this.palikanKoko, 3 * this.palikanKoko);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

            int y = 4;
            for (int i = 0; i < 10; i++) {
                g.drawString(this.kali.getPeli().getHighscore().annaRiviListalta(i), 6 * this.palikanKoko, y * this.palikanKoko);
                y++;
            }
            g.setColor(Color.RED);
            g.drawString("Paina <F1> palataksesi takaisin", 4 * this.palikanKoko, (y + 2) * this.palikanKoko);
        } catch (Exception e) {
            g.setColor(Color.RED);
            g.drawString("Jokin meni pieleen, yritä uudelleen", this.palikanKoko, 10 * this.palikanKoko);
            g.drawString("Paina <F1> palataksesi takaisin", 2 * this.palikanKoko, (12) * this.palikanKoko);
        }
    }

}
