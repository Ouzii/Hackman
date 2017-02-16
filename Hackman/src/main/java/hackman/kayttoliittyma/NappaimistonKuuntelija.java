package hackman.kayttoliittyma;

import hackman.rakennuspalat.Suunta;
import hackman.peli.Peli;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;

/**
 * Näppäimistönkuuntelija, joka siirtää näppäinten painallukset logiikan
 * käyttöön.
 *
 * @author Oce
 */
public class NappaimistonKuuntelija implements KeyListener {

    private Pelihahmo pelaaja;
    private Peli peli;
    private Kayttoliittyma kali;

    /**
     * Konstruktori näppäimistönkuuntelijalle, joka linkittää
     * näppäimistönkuuntelijan tarvittaviin muihin luokkiin.
     *
     * @param pelaaja Pelaajan ohjaama pelihahmo.
     * @param peli Peliluokka.
     * @param kali Käyttöliittymäluokka.
     */
    public NappaimistonKuuntelija(Pelihahmo pelaaja, Peli peli, Kayttoliittyma kali) {
        this.pelaaja = pelaaja;
        this.peli = peli;
        this.kali = kali;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.pelaaja.setSuunta(Suunta.OIKEA);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.pelaaja.setSuunta(Suunta.VASEN);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.pelaaja.setSuunta(Suunta.YLOS);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.pelaaja.setSuunta(Suunta.ALAS);
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (this.peli.isRunning()) {
                this.peli.stop();
            } else {
                this.peli.restart();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            kali.uusiPeli();
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            kali.menu();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && !this.peli.getLogiikka().isAlkaa()) {
            if (this.peli.getLogiikka().isHavia()) {
                kali.uusiPeli();
            } else {
                this.peli.getLogiikka().setAlkaa();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && this.peli.getLogiikka().isVoita()) {
            this.kali.nextMap();
        }

        if (e.getKeyCode() == KeyEvent.VK_F1) {
            if (!this.peli.getHighscore().isMenuun()) {
                this.peli.getHighscore().setMenuun(true);
            } else {
                this.peli.getHighscore().setMenuun(false);
            }

            this.peli.getPaivitettava().paivita();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
