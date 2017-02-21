/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kayttoliittyma;

import hackman.logiikka.Peli;
import hackman.logiikka.Vaikeustaso;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

/**
 * Huolehtii päävalikkonäkymän grafiikoiden piirtämisestä.
 * @author Oce
 */
public class MenunPiirtaja {

    private int palikanKoko;
    private Peli peli;

    /**
     * Asettaa viitteet oikein.
     * @param peli Pelattava peli.
     * @param palikanKoko Palikan koko.
     */
    public MenunPiirtaja(Peli peli, int palikanKoko) {
        this.palikanKoko = palikanKoko;
        this.peli = peli;
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
        g.drawString("Aloita/jatka peliä ", 4 * this.palikanKoko, 4 * this.palikanKoko);
        g.drawString("painamalla <Enter>", 4 * this.palikanKoko, 5 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Tulosta huipputulokset", 4 * this.palikanKoko, 7 * this.palikanKoko);
        g.drawString("painamalla <F1>", 6 * this.palikanKoko, 8 * this.palikanKoko);
        g.setColor(Color.BLACK);
        g.drawString("Pelissä paina <R>\naloittaaksesi alusta", 4 * this.palikanKoko, 10 * this.palikanKoko);
        g.drawString("aloittaaksesi alusta", 6 * this.palikanKoko, 11 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Pelissä paina <P>", 4 * this.palikanKoko, 13 * this.palikanKoko);
        g.drawString("pysäyttääksesi pelin", 6 * this.palikanKoko, 14 * this.palikanKoko);
        g.setColor(Color.BLACK);
        g.drawString("Paina <Esc> vaihtaaksesi", 4 * this.palikanKoko, 16 * this.palikanKoko);
        g.drawString("käyttäjän nimeä", 6 * this.palikanKoko, 17 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Muuta vaikeustasoa", 4 * this.palikanKoko, 19 * this.palikanKoko);
        g.drawString("painamalla <+> ja <->", 6 * this.palikanKoko, 20 * this.palikanKoko);
    }

    private void piirraVaikeustaso(Graphics g) {
        g.setColor(Color.BLACK);
        if (this.peli.getVaikeustaso().equals(Vaikeustaso.HELPPO)) {
            g.setColor(Color.RED);
            g.drawString("HELPPO", 3 * this.palikanKoko - 4, 2 * this.palikanKoko);
            g.setColor(Color.BLACK);
            g.drawString("NORMAALI", 8 * this.palikanKoko, 2 * this.palikanKoko);
            g.drawString("VAIKEA", 15 * this.palikanKoko, 2 * this.palikanKoko);
        } else if (this.peli.getVaikeustaso().equals(Vaikeustaso.NORMAALI)) {
            g.drawString("HELPPO", 3 * this.palikanKoko - 4, 2 * this.palikanKoko);
            g.setColor(Color.RED);
            g.drawString("NORMAALI", 8 * this.palikanKoko, 2 * this.palikanKoko);
            g.setColor(Color.BLACK);
            g.drawString("VAIKEA", 15 * this.palikanKoko, 2 * this.palikanKoko);
        } else {
            g.drawString("HELPPO", 3 * this.palikanKoko - 4, 2 * this.palikanKoko);
            g.drawString("NORMAALI", 8 * this.palikanKoko, 2 * this.palikanKoko);
            g.setColor(Color.RED);
            g.drawString("VAIKEA", 15 * this.palikanKoko, 2 * this.palikanKoko);
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
            this.peli.getHighscore().kirjoita();
            g.setColor(Color.BLUE);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            g.drawString("Sija   pisteet     nimi", 6 * this.palikanKoko, 3 * this.palikanKoko);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

            int y = 4;
            for (int i = 0; i < 10; i++) {
                g.drawString(this.peli.getHighscore().annaRiviListalta(i), 6 * this.palikanKoko, y * this.palikanKoko);
                y++;
            }
            g.setColor(Color.RED);
            g.drawString("Paina <F1> palataksesi takaisin", 2 * this.palikanKoko, (y + 2) * this.palikanKoko);
        } catch (Exception e) {
            g.setColor(Color.RED);
            g.drawString("Jokin meni pieleen, yritä uudelleen" + e.getMessage(), this.palikanKoko, 10 * this.palikanKoko);
            g.drawString("Paina <F1> palataksesi takaisin", 2 * this.palikanKoko, (12) * this.palikanKoko);
        }
    }

}
