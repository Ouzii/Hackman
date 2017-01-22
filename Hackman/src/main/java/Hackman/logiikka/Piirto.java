/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hackman.logiikka;

import Hackman.peli.Peli;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirto extends JPanel implements Paivitettava {

    private Peli peli;
    private int palikanKoko;

    public Piirto(Peli peli, int PalikanKoko) {
        this.peli = peli;
        this.palikanKoko = PalikanKoko;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fill3DRect(this.peli.getPelaaja().getHahmo().getX() * this.palikanKoko, this.peli.getPelaaja().getHahmo().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);

    }

    @Override
    public void paivita() {
        repaint();
    }

}
