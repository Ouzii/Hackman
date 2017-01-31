package hackman.logiikka;

import hackman.rakennuspalat.Suunta;
import hackman.peli.Peli;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Nappaimistonkuuntelija implements KeyListener {

    private Pelihahmo pelaaja;
    private Peli hackman;

    public Nappaimistonkuuntelija(Pelihahmo pelaaja, Peli hackman) {
        this.pelaaja = pelaaja;
        this.hackman = hackman;
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.pelaaja.setX(10);
            this.pelaaja.setY(10);
        }
//        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//
//        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
