/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.logiikka;

import hackman.peli.Peli;
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
        g.fill3DRect(this.peli.getPelaaja().getHahmo().getX() * this.palikanKoko, this.peli.getPelaaja().getHahmo().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        g.setColor(Color.red);
        if (!this.peli.getBitti().isKeratty()) {
            g.fill3DRect(this.peli.getBitti().getX() * this.palikanKoko, this.peli.getBitti().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }
        
        g.setColor(Color.GRAY);
        g.fill3DRect(this.peli.getSeina().getX() * this.palikanKoko, this.peli.getSeina().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);

    }

    @Override
    public boolean paivita() {
        repaint();
        return true;
    }

}
