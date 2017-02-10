package hackman.kayttoliittyma;

import hackman.rakennuspalat.Suunta;
import hackman.peli.Peli;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;
/**
 * Näppäimistönkuuntelija, joka siirtää näppäinten painallukset logiikan käyttöön.
 * @author Oce
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Pelihahmo pelaaja;
    private Peli peli;
    private Kayttoliittyma kali;

    public Nappaimistonkuuntelija(Pelihahmo pelaaja, Peli peli, Kayttoliittyma kali) {
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

        if (e.getKeyCode() == KeyEvent.VK_ENTER && !this.peli.isAlkaa()) {
            if (this.peli.isHavia()) {
                kali.uusiPeli();
            } else {
                this.peli.setAlkaa();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && this.peli.isVoita()) {
            this.kali.nextMap();
        }

        if (e.getKeyCode() == KeyEvent.VK_F1) {
            if (!this.peli.isHighscore()) {
                this.peli.setHighscore(true);
            } else {
                this.peli.setHighscore(false);
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
