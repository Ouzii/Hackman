/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.logiikka;

import hackman.peli.Peli;
import hackman.rakennuspalat.Palikka;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirto extends JPanel implements Paivitettava {

    private Peli peli;
    private int palikanKoko;

    public Piirto(Peli peli, int palikanKoko) {
        this.peli = peli;
        this.palikanKoko = palikanKoko;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        if (this.peli.getPelaaja().isElossa()) {
            g.fill3DRect(this.peli.getPelaaja().getHahmo().getX() * this.palikanKoko, this.peli.getPelaaja().getHahmo().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }
        g.setColor(Color.BLUE);
        if (!this.peli.getBitti().isKeratty()) {
            g.fill3DRect(this.peli.getBitti().getX() * this.palikanKoko, this.peli.getBitti().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }
        g.setColor(Color.red);
//        g.fill3DRect(this.peli.getVihu().getHahmo().getX() * this.palikanKoko, this.peli.getVihu().getHahmo().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        g.drawString("" + this.peli.getPojot(), 3 * this.palikanKoko, 3 * this.palikanKoko);
        g.setColor(Color.GRAY);
        
        for (Palikka seina : this.peli.getKartta().getSeinat()) {
            g.fill3DRect(seina.getX() * this.palikanKoko, seina.getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }
//        for (int i = 0; i <= this.peli.getLeveys() + 1; i++) {
//            g.fill3DRect(i * this.palikanKoko, this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
//        }
//        for (int i = 0; i <= this.peli.getKorkeus() + 1; i++) {
//            g.fill3DRect(this.palikanKoko, i * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
//        }
//        for (int i = this.peli.getLeveys() + 1; i >= 0; i--) {
//            g.fill3DRect(i * this.palikanKoko, 20 * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
//        }
//        for (int i = this.peli.getKorkeus() + 1; i >= 0; i--) {
//            g.fill3DRect(20 * this.palikanKoko, i * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
//        }
//        g.fill3DRect(this.peli.getSeina().getX() * this.palikanKoko, this.peli.getSeina().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
//        g.fill3DRect(this.peli.getSeina1().getX() * this.palikanKoko, this.peli.getSeina1().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);

    }

    @Override
    public boolean paivita() {
        repaint();
        return true;
    }

}
