package hackman.kayttoliittyma;

import hackman.peli.Peli;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.VihollinenPunainen;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.io.File;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Piirtaja extends JPanel implements Paivitettava {

    private final Peli peli;
    private final int palikanKoko;
    private JFrame frame;

    public Piirtaja(Peli peli, int palikanKoko, JFrame frame) {
        this.peli = peli;
        this.palikanKoko = palikanKoko;
        this.frame = frame;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

        if (!this.peli.isAlkaa()) {
            
            if(!this.peli.isHighscore()) {
            g.drawString("Aloita painamalla <Enter>", 4 * this.palikanKoko, 7 * this.palikanKoko);
            g.setColor(Color.red);
            g.drawString("Tulosta huipputulokset", 4 * this.palikanKoko, 9 * this.palikanKoko);
            g.drawString("painamalla <Esc>", 6 * this.palikanKoko, 10 * this.palikanKoko);
            } else {
                try {
                    Scanner tiedostonLukija = new Scanner(new File("src/main/resources/highscore.txt"));
                    int y = 4;
                    while(tiedostonLukija.hasNextLine()) {
                        g.drawString(tiedostonLukija.nextLine(), 5 * this.palikanKoko, y * this.palikanKoko);
                        y++;
                    }
                } catch (Exception e) {
                    System.out.println("fail");
                }
            }

        } else {
            g.setColor(Color.GREEN);
            if (this.peli.getPelaaja().isElossa()) {
                g.fill3DRect(this.peli.getPelaaja().getX() * this.palikanKoko, this.peli.getPelaaja().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            }

            g.setColor(Color.red);
            g.fill3DRect(this.peli.getVihuPun().getX() * this.palikanKoko, this.peli.getVihuPun().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            g.setColor(Color.BLACK);
            g.fill3DRect(this.peli.getVihuMus().getX() * this.palikanKoko, this.peli.getVihuMus().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            g.setColor(Color.red);
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
            
            if(this.peli.isVoita()) {
                g.setColor(Color.MAGENTA);
                g.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
                g.drawString("VOITIT!", 6 * this.palikanKoko, 9 * this.palikanKoko);
            }
            if(this.peli.isHavia()) {
                g.setColor(Color.MAGENTA);
                g.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
                g.drawString("HÄVISIT!", 6 * this.palikanKoko, 9 * this.palikanKoko);
            }
        }
    }

    @Override
    public boolean paivita() {
        repaint();
        return true;
    }

}
