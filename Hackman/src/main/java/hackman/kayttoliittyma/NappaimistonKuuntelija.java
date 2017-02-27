package hackman.kayttoliittyma;

import hackman.kartat.Kartta1;
import hackman.logiikka.Menutila;
import hackman.rakennuspalat.Suunta;
import hackman.logiikka.Peli;
import hackman.logiikka.Pelitila;
import hackman.logiikka.Vaikeustaso;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;

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
            if (!this.peli.getKartta().osuuSeinaan(new Pelihahmo(this.pelaaja.getX(), this.pelaaja.getY(), Suunta.OIKEA))) {
                this.pelaaja.setSuunta(Suunta.OIKEA);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!this.peli.getKartta().osuuSeinaan(new Pelihahmo(this.pelaaja.getX(), this.pelaaja.getY(), Suunta.VASEN))) {
                this.pelaaja.setSuunta(Suunta.VASEN);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!this.peli.getKartta().osuuSeinaan(new Pelihahmo(this.pelaaja.getX(), this.pelaaja.getY(), Suunta.YLOS))) {
                this.pelaaja.setSuunta(Suunta.YLOS);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!this.peli.getKartta().osuuSeinaan(new Pelihahmo(this.pelaaja.getX(), this.pelaaja.getY(), Suunta.ALAS))) {
                this.pelaaja.setSuunta(Suunta.ALAS);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (this.peli.getLogiikka().getPelitila().equals(Pelitila.NEUTRAALI)) {
                if (this.peli.isRunning()) {
                    this.peli.stop();
                } else {
                    this.peli.restart();
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            kali.uusiPeli(this.peli.getVaikeustaso());
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (this.peli.getMenutila().equals(Menutila.MENU)) {
                this.kali.getFrame().setVisible(false);
                this.kali.getFrame().removeAll();
                this.kali = new Kayttoliittyma(25, false, "");
                SwingUtilities.invokeLater(kali);
            } else {
                kali.menuun();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && !this.peli.getMenutila().equals(Menutila.KAYNNISSA)) {
            if (this.peli.getLogiikka().getPelitila().equals(Pelitila.HAVIO)) {
                kali.uusiPeli(this.peli.getVaikeustaso());
            } else {
                this.peli.setMenutila(Menutila.KAYNNISSA);
                this.peli.start();
            }
        }

        if ((e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_ADD) && this.peli.getMenutila().equals(Menutila.MENU)) {
            if (this.peli.getVaikeustaso().equals(Vaikeustaso.HELPPO)) {
                this.kali.uusiPeli(Vaikeustaso.NORMAALI);
            } else if (this.peli.getVaikeustaso().equals(Vaikeustaso.NORMAALI)) {
                this.kali.uusiPeli(Vaikeustaso.VAIKEA);
            }
            this.kali.menuun();
        }

        if ((e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT) && this.peli.getMenutila().equals(Menutila.MENU)) {
            if (this.peli.getVaikeustaso().equals(Vaikeustaso.VAIKEA)) {
                this.kali.uusiPeli(Vaikeustaso.NORMAALI);
            } else if (this.peli.getVaikeustaso().equals(Vaikeustaso.NORMAALI)) {
                this.kali.uusiPeli(Vaikeustaso.HELPPO);
            }
            this.kali.menuun();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && this.peli.getLogiikka().getPelitila().equals(Pelitila.VOITTO)) {
            this.kali.nextMap();
        }

        if (e.getKeyCode() == KeyEvent.VK_F1) {
            if (!this.peli.getMenutila().equals(Menutila.HIGHSCORE) && !this.peli.getMenutila().equals(Menutila.KAYNNISSA)) {
                this.peli.setMenutila(Menutila.HIGHSCORE);
            } else if (this.peli.getMenutila().equals(Menutila.HIGHSCORE)) {
                this.peli.setMenutila(Menutila.MENU);
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
