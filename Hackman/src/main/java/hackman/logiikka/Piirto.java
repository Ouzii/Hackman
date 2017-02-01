/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.logiikka;

import hackman.peli.Peli;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Vihollinen;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirto extends JPanel implements Paivitettava {

    private final Peli peli;
    private final int palikanKoko;

    public Piirto(Peli peli, int palikanKoko) {
        this.peli = peli;
        this.palikanKoko = palikanKoko;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        if (this.peli.getPelaaja().isElossa()) {
            g.fill3DRect(this.peli.getPelaaja().getX() * this.palikanKoko, this.peli.getPelaaja().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }

        g.setColor(Color.red);
        g.fill3DRect(this.peli.getVihu().getX() * this.palikanKoko, this.peli.getVihu().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        g.drawString("PISTEET: " + this.peli.getPojot(), 3 * this.palikanKoko - 20, 3 * this.palikanKoko - 41);
        g.setColor(Color.GRAY);

        for (Palikka seina : this.peli.getKartta().getSeinat()) {
            g.fill3DRect(seina.getX() * this.palikanKoko, seina.getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
        }

        g.setColor(Color.BLUE);

        for (Bitti bitti : this.peli.getKartta().getBitit()) {
            if (!bitti.isKeratty()) {
                g.fill3DRect(bitti.getX() * this.palikanKoko + 3, bitti.getY() * this.palikanKoko + 3, this.palikanKoko - 5, this.palikanKoko - 5, true);
            }
        }
    }

    @Override
    public boolean paivita() {
        repaint();
        return true;
    }

}
