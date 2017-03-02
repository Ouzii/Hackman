package hackman.kayttoliittyma;

import hackman.enumit.Menutila;
import hackman.enumit.Suunta;
import hackman.enumit.Pelitila;
import hackman.enumit.Vaikeustaso;
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


    private Kayttoliittyma kali;

    /**
     * Konstruktori näppäimistönkuuntelijalle, joka linkittää
     * näppäimistönkuuntelijan tarvittaviin muihin luokkiin.
     *
     * @param kali Käyttöliittymäluokka.
     */
    public NappaimistonKuuntelija(Kayttoliittyma kali) {
        this.kali = kali;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!this.kali.getPeli().getKartta().osuuSeinaan(new Pelihahmo(this.kali.getPeli().getPelaaja().getX(), this.kali.getPeli().getPelaaja().getY(), Suunta.OIKEA))) {
                this.kali.getPeli().getPelaaja().setSuunta(Suunta.OIKEA);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!this.kali.getPeli().getKartta().osuuSeinaan(new Pelihahmo(this.kali.getPeli().getPelaaja().getX(), this.kali.getPeli().getPelaaja().getY(), Suunta.VASEN))) {
                this.kali.getPeli().getPelaaja().setSuunta(Suunta.VASEN);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!this.kali.getPeli().getKartta().osuuSeinaan(new Pelihahmo(this.kali.getPeli().getPelaaja().getX(), this.kali.getPeli().getPelaaja().getY(), Suunta.YLOS))) {
                this.kali.getPeli().getPelaaja().setSuunta(Suunta.YLOS);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!this.kali.getPeli().getKartta().osuuSeinaan(new Pelihahmo(this.kali.getPeli().getPelaaja().getX(), this.kali.getPeli().getPelaaja().getY(), Suunta.ALAS))) {
                this.kali.getPeli().getPelaaja().setSuunta(Suunta.ALAS);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (this.kali.getPeli().getLogiikka().getPelitila().equals(Pelitila.NEUTRAALI)) {
                if (this.kali.getPeli().isRunning()) {
                    this.kali.getPeli().stop();
                } else {
                    this.kali.getPeli().restart();
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            kali.uusiPeli(this.kali.getPeli().getVaikeustaso());
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (this.kali.getPeli().getMenutila().equals(Menutila.MENU)) {
                this.kali.getFrame().setVisible(false);
                this.kali.getFrame().removeAll();
                this.kali = new Kayttoliittyma(25, false, "");
                SwingUtilities.invokeLater(kali);
            } else {
                kali.menuun();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && !this.kali.getPeli().getMenutila().equals(Menutila.KAYNNISSA)) {
            if (this.kali.getPeli().getLogiikka().getPelitila().equals(Pelitila.HAVIO)) {
                kali.uusiPeli(this.kali.getPeli().getVaikeustaso());
            } else {
                this.kali.getPeli().setMenutila(Menutila.KAYNNISSA);
                this.kali.getPeli().start();
            }
        }

        if ((e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_ADD) && this.kali.getPeli().getMenutila().equals(Menutila.MENU)) {
            if (this.kali.getPeli().getVaikeustaso().equals(Vaikeustaso.HELPPO)) {
                this.kali.uusiPeli(Vaikeustaso.NORMAALI);
            } else if (this.kali.getPeli().getVaikeustaso().equals(Vaikeustaso.NORMAALI)) {
                this.kali.uusiPeli(Vaikeustaso.VAIKEA);
            }
            this.kali.menuun();
        }

        if ((e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT) && this.kali.getPeli().getMenutila().equals(Menutila.MENU)) {
            if (this.kali.getPeli().getVaikeustaso().equals(Vaikeustaso.VAIKEA)) {
                this.kali.uusiPeli(Vaikeustaso.NORMAALI);
            } else if (this.kali.getPeli().getVaikeustaso().equals(Vaikeustaso.NORMAALI)) {
                this.kali.uusiPeli(Vaikeustaso.HELPPO);
            }
            this.kali.menuun();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && this.kali.getPeli().getLogiikka().getPelitila().equals(Pelitila.VOITTO)) {
            this.kali.nextMap();
        }

        if (e.getKeyCode() == KeyEvent.VK_F1) {
            if (!this.kali.getPeli().getMenutila().equals(Menutila.HIGHSCORE) && !this.kali.getPeli().getMenutila().equals(Menutila.KAYNNISSA)) {
                this.kali.getPeli().setMenutila(Menutila.HIGHSCORE);
            } else if (this.kali.getPeli().getMenutila().equals(Menutila.HIGHSCORE)) {
                this.kali.getPeli().setMenutila(Menutila.MENU);
            }

            this.kali.getPeli().getPaivitettava().paivita();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
