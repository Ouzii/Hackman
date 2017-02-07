package hackman.kayttoliittyma;

import hackman.rakennuspalat.Suunta;
import hackman.peli.Peli;
import hackman.rakennuspalat.Pelihahmo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;

public class Nappaimistonkuuntelija implements KeyListener {

    private Pelihahmo pelaaja;
    private Peli peli;

    public Nappaimistonkuuntelija(Pelihahmo pelaaja, Peli hackman) {
        this.pelaaja = pelaaja;
        this.peli = hackman;
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
//            this.pelaaja.setX(10);
//            this.pelaaja.setY(10);
            if(this.peli.isRunning()) {
                this.peli.stop();
            } else {
                this.peli.restart();
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER && !this.peli.isAlkaa()) {
            this.peli.setAlkaa();
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//            try {
//                Scanner lukija = new Scanner(new File("src/main/resources/highscore.txt"));
//                while(lukija.hasNextLine()) {
//                    System.out.println(lukija.nextLine());
//                }
//            } catch (Exception a) {
//                System.out.println("fail");
//            }
            if(!this.peli.isHighscore()) {
                this.peli.setHighscore(true);
            } else {
                this.peli.setHighscore(false);
            }
            
            this.peli.getPaivitettava().paivita();
            
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
