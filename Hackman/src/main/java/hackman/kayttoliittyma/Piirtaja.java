package hackman.kayttoliittyma;

import hackman.peli.Peli;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pelin grafiikoiden piirtäjä-luokka.
 *
 * @author Oce
 */
public class Piirtaja extends JPanel implements Paivitettava {

    private Peli peli;
    private int palikanKoko;
    private Kayttoliittyma kali;

    /**
     * Konstruktori piirtäjälle, joka asettaa tarvittavat yhteydet.
     *
     * @param peli Peli, jonka pohjalta grafiikat piirretään.
     * @param palikanKoko Koko palikoille, jotka piirretään.
     * @param kali Käyttöliittymä-luokka.
     */
    public Piirtaja(Peli peli, int palikanKoko, Kayttoliittyma kali) {
        this.peli = peli;
        this.palikanKoko = palikanKoko;
        this.kali = kali;
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
    }

    private void piirraMenu(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Aloita/jatka peliä ", 4 * this.palikanKoko, 5 * this.palikanKoko);
        g.drawString("painamalla <Enter>", 4 * this.palikanKoko, 6 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Tulosta huipputulokset", 4 * this.palikanKoko, 8 * this.palikanKoko);
        g.drawString("painamalla <F1>", 6 * this.palikanKoko, 9 * this.palikanKoko);
        g.setColor(Color.BLACK);
        g.drawString("Pelissä paina <R>", 4 * this.palikanKoko, 11 * this.palikanKoko);
        g.drawString("aloittaaksesi alusta", 6 * this.palikanKoko, 12 * this.palikanKoko);
        g.setColor(Color.BLUE);
        g.drawString("Pelissä paina <P>", 4 * this.palikanKoko, 14 * this.palikanKoko);
        g.drawString("pysäyttääksesi pelin", 6 * this.palikanKoko, 15 * this.palikanKoko);
        g.setColor(Color.BLACK);
        g.drawString("Paina <Esc> vaihtaaksesi", 4 * this.palikanKoko, 17 * this.palikanKoko);
        g.drawString("käyttäjän nimeä", 6 * this.palikanKoko, 18 * this.palikanKoko);
    }

    private void piirraHighscore(Graphics g) {
        try {
            this.peli.getHighscore().kirjoita();
            g.setColor(Color.BLACK);
            Scanner tiedostonLukija = new Scanner(new File("src/main/resources/highscore.txt"), "UTF-8");
            int y = 4;
            while (tiedostonLukija.hasNextLine()) {
                g.drawString(tiedostonLukija.nextLine(), 6 * this.palikanKoko, y * this.palikanKoko);
                y++;
            }
            g.setColor(Color.RED);
            g.drawString("Paina <F1> palataksesi takaisin", 2 * this.palikanKoko, (y + 2) * this.palikanKoko);
        } catch (Exception e) {
            g.setColor(Color.RED);
            g.drawString("Jokin meni pieleen, yritä uudelleen", this.palikanKoko, 10 * this.palikanKoko);
            g.drawString("Paina <F1> palataksesi takaisin", 2 * this.palikanKoko, (12) * this.palikanKoko);
        }
    }

    private void piirraPelaaja(Graphics g) {
        g.setColor(Color.GREEN);
        if (this.peli.getPelaaja().isElossa()) {
            g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko, this.peli.getPelaaja().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko);
        }
    }

    private void piirraBitit(Graphics g) {
        g.setColor(Color.BLUE);
        for (Bitti bitti : this.peli.getKartta().getBitit()) {
            if (!bitti.isKeratty()) {
                g.fillOval(bitti.getX() * this.palikanKoko + 3, bitti.getY() * this.palikanKoko + 3, this.palikanKoko - 7, this.palikanKoko - 7);
            }
        }
    }

    private void piirraViholliset(Graphics g) {
        g.setColor(Color.RED);
        g.fill3DRect(this.peli.getKartta().getVihuPun().getX() * this.palikanKoko, this.peli.getKartta().getVihuPun().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);

        g.setColor(Color.BLACK);
        g.fill3DRect(this.peli.getKartta().getVihuMus().getX() * this.palikanKoko, this.peli.getKartta().getVihuMus().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);

        g.setColor(Color.YELLOW);
        g.fill3DRect(this.peli.getKartta().getVihuKel().getX() * this.palikanKoko, this.peli.getKartta().getVihuKel().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);

        g.setColor(Color.PINK);
        g.fill3DRect(this.peli.getKartta().getVihuPin().getX() * this.palikanKoko, this.peli.getKartta().getVihuPin().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
    }

    private void piirraSeinat(Graphics g) {
        g.setColor(Color.GRAY);

        for (Palikka seina : this.peli.getKartta().getSeinat()) {
            g.fill3DRect(seina.getX() * this.palikanKoko, seina.getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }
    }

    /**
     * Päämetodi piirtämiselle, joka suorittaa muut piirtometodit.
     *
     * @param g Grafiikanluonti Javassa.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font suuri = new Font("Comic Sans MS", Font.BOLD, 34);
        Font pieni = new Font("Comic Sans MS", Font.BOLD, 22);
        g.setFont(pieni);
        g.setColor(Color.LIGHT_GRAY);
//        g.fill3DRect(-20, -20, 40 * this.palikanKoko, 40 * this.palikanKoko, true);
        if (!this.peli.getLogiikka().isAlkaa()) {

            if (!this.peli.getHighscore().isMenuun()) {
                this.piirraMenu(g);
            } else {
                this.piirraHighscore(g);
            }

        } else {
            this.piirraSeinat(g);
            this.piirraPelaaja(g);
            this.piirraBitit(g);
            this.piirraViholliset(g);
            g.setColor(Color.RED);
            g.drawString("PISTEET: " + this.peli.getLogiikka().getPojot(), 3 * this.palikanKoko - 20, 3 * this.palikanKoko - 41);
            if (this.peli.getLogiikka().isVoita()) {
                g.setColor(Color.BLUE);
                g.setFont(suuri);
                g.drawString("VOITIT!", 6 * this.palikanKoko, 9 * this.palikanKoko);
                g.setFont(pieni);
                g.drawString("Paina <Space> siirtyäksesi", 3 * this.palikanKoko, 11 * this.palikanKoko);
                g.drawString("seuraavalle tasolle", 5 * this.palikanKoko, 12 * this.palikanKoko);
            }
            if (this.peli.getLogiikka().isHavia()) {
                g.setColor(Color.RED);
                g.setFont(suuri);
                g.drawString("HÄVISIT!", 6 * this.palikanKoko, 9 * this.palikanKoko);
                g.setFont(pieni);
                g.drawString("Paina <R> aloittaaksesi alusta", 2 * this.palikanKoko + 10, 11 * this.palikanKoko);
            }
        }
    }

    /**
     * Kutsuttava metodi, joka piirtää uudelleen muuttuneet grafiikat.
     */
    @Override
    public void paivita() {
        repaint();
    }

}
