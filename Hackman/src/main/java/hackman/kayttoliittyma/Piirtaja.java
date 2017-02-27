package hackman.kayttoliittyma;

import hackman.logiikka.Menutila;
import hackman.logiikka.Peli;
import hackman.logiikka.Pelitila;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Pelin grafiikoiden piirtäjä-luokka.
 *
 * @author Oce
 */
public class Piirtaja extends JPanel implements Paivitettava {

    private Peli peli;
    private int palikanKoko;
    private Kayttoliittyma kali;
    private MenunPiirtaja menunPiirtaja;

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
        this.menunPiirtaja = new MenunPiirtaja(this.peli, this.palikanKoko);
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
    }

    private void piirraPelaaja(Graphics g) {
        g.setColor(Color.GREEN);
        if (this.peli.getPelaaja().isElossa()) {
            g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko, this.peli.getPelaaja().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko);
            g.setColor(Color.BLACK);
            switch (this.peli.getPelaaja().getSuunta()) {
                case ALAS:
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 6, this.peli.getPelaaja().getY() * this.palikanKoko + 18, 5, 5);
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 14, this.peli.getPelaaja().getY() * this.palikanKoko + 18, 5, 5);
                    break;
                case YLOS:
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 6, this.peli.getPelaaja().getY() * this.palikanKoko + 2, 5, 5);
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 14, this.peli.getPelaaja().getY() * this.palikanKoko + 2, 5, 5);
                    break;
                case VASEN:
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 2, this.peli.getPelaaja().getY() * this.palikanKoko + 6, 5, 5);
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 2, this.peli.getPelaaja().getY() * this.palikanKoko + 14, 5, 5);
                    break;
                case OIKEA:
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 18, this.peli.getPelaaja().getY() * this.palikanKoko + 6, 5, 5);
                    g.fillOval(this.peli.getPelaaja().getX() * this.palikanKoko + 18, this.peli.getPelaaja().getY() * this.palikanKoko + 14, 5, 5);
                    break;
                default:
                    break;
            }
        }
    }

    private void piirraBitit(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        for (Bitti bitti : this.peli.getKartta().getBitit()) {
            if (!bitti.isKeratty()) {
                int random = new Random().nextInt(4);
                if (random == 0) {
                    g.drawString("00", bitti.getX() * this.palikanKoko + 6, bitti.getY() * this.palikanKoko + 17);
                } else if (random == 1) {
                    g.drawString("01", bitti.getX() * this.palikanKoko + 6, bitti.getY() * this.palikanKoko + 17);
                } else if (random == 2) {
                    g.drawString("10", bitti.getX() * this.palikanKoko + 6, bitti.getY() * this.palikanKoko + 17);
                } else if (random == 3) {
                    g.drawString("11", bitti.getX() * this.palikanKoko + 6, bitti.getY() * this.palikanKoko + 17);
                }
//                g.fillOval(bitti.getX() * this.palikanKoko + 3, bitti.getY() * this.palikanKoko + 3, this.palikanKoko - 7, this.palikanKoko - 7);
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
        if (!this.peli.getMenutila().equals(Menutila.KAYNNISSA)) {

            if (this.peli.getMenutila().equals(Menutila.MENU)) {
                this.menunPiirtaja.piirraMenu(g);
            } else {
                this.menunPiirtaja.piirraHighscore(g);
            }

        } else {
            this.piirraSeinat(g);
            this.piirraPelaaja(g);
            this.piirraBitit(g);
            this.piirraViholliset(g);
            g.setColor(Color.RED);
            g.drawString("PISTEET: " + this.peli.getLogiikka().getPojot(), 3 * this.palikanKoko - 20, 2 * this.palikanKoko - 30);
            if (this.peli.getLogiikka().getPelitila().equals(Pelitila.VOITTO)) {
                g.setColor(Color.BLUE);
                g.setFont(suuri);
                g.drawString("VOITIT!", 7 * this.palikanKoko + 10, 9 * this.palikanKoko);
                g.setFont(pieni);
                g.drawString("Paina <Space> siirtyäksesi", 4 * this.palikanKoko + 10, 11 * this.palikanKoko);
                g.drawString("seuraavalle tasolle", 6 * this.palikanKoko + 10, 12 * this.palikanKoko);
            }
            if (this.peli.getLogiikka().getPelitila().equals(Pelitila.HAVIO)) {
                g.setColor(new Color(102, 0, 0));
                g.setFont(suuri);
                g.drawString("HÄVISIT!", 7 * this.palikanKoko, 9 * this.palikanKoko);
                g.setFont(pieni);
                g.drawString("Paina <R> aloittaaksesi alusta", 4 * this.palikanKoko, 11 * this.palikanKoko);
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
