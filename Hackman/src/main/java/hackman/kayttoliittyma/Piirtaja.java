package hackman.kayttoliittyma;

import hackman.peli.Peli;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Vihollinen;
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

    public Piirtaja(Peli peli, int palikanKoko) {
        this.peli = peli;
        this.palikanKoko = palikanKoko;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            g.setColor(Color.LIGHT_GRAY);
            g.fill3DRect(0, 0, 21 * this.palikanKoko, 21 * this.palikanKoko, true);
        if (!this.peli.isAlkaa()) {
//            g.setColor(Color.LIGHT_GRAY);
//            g.fill3DRect(0, 0, 21 * this.palikanKoko, 21 * this.palikanKoko, true);
            if (!this.peli.isHighscore()) {
                g.setColor(Color.BLACK);
                g.drawString("Aloita painamalla <Enter>", 4 * this.palikanKoko, 7 * this.palikanKoko);
                g.setColor(Color.BLUE);
                g.drawString("Tulosta huipputulokset", 4 * this.palikanKoko, 9 * this.palikanKoko);
                g.drawString("painamalla <F1>", 6 * this.palikanKoko, 10 * this.palikanKoko);
                g.setColor(Color.BLACK);
                g.drawString("Pelissä paina <R>", 4 * this.palikanKoko, 12 * this.palikanKoko);
                g.drawString("aloittaaksesi alusta", 6 * this.palikanKoko, 13 * this.palikanKoko);
                g.setColor(Color.BLUE);
                g.drawString("Pelissä paina <Space>", 4 * this.palikanKoko, 15 * this.palikanKoko);
                g.drawString("pysäyttääksesi pelin", 6 * this.palikanKoko, 16 * this.palikanKoko);
            } else {
                try {
                    g.setColor(Color.BLACK);
                    Scanner tiedostonLukija = new Scanner(new File("src/main/resources/highscore.txt"));
                    int y = 4;
                    while (tiedostonLukija.hasNextLine()) {
                        g.drawString(tiedostonLukija.nextLine(), 8 * this.palikanKoko, y * this.palikanKoko);
                        y++;
                    }
                    g.setColor(Color.RED);
                    g.drawString("Paina <Esc> palataksesi takaisin", 2 * this.palikanKoko, (y + 2) * this.palikanKoko);
                } catch (Exception e) {
                    System.out.println("fail");
                }
            }

        } else {
            g.setColor(Color.GREEN);
            if (this.peli.getPelaaja().isElossa()) {
                g.fill3DRect(this.peli.getPelaaja().getX() * this.palikanKoko, this.peli.getPelaaja().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            }

            g.setColor(Color.BLUE);

            for (Bitti bitti : this.peli.getKartta().getBitit()) {
                if (!bitti.isKeratty()) {
//                    g.fill3DRect(bitti.getX() * this.palikanKoko + 3, bitti.getY() * this.palikanKoko + 3, this.palikanKoko - 5, this.palikanKoko - 5, true);
                    g.fillOval(bitti.getX() * this.palikanKoko +3, bitti.getY() * this.palikanKoko + 3, this.palikanKoko - 7, this.palikanKoko - 7);
                }
            }

            g.setColor(Color.RED);
            g.fill3DRect(this.peli.getVihuPun().getX() * this.palikanKoko, this.peli.getVihuPun().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            g.setColor(Color.BLACK);
            g.fill3DRect(this.peli.getVihuMus().getX() * this.palikanKoko, this.peli.getVihuMus().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            g.setColor(Color.YELLOW);
            g.fill3DRect(this.peli.getVihuKel().getX() * this.palikanKoko, this.peli.getVihuKel().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            g.setColor(Color.PINK);
            g.fill3DRect(this.peli.getVihuOra().getX() * this.palikanKoko, this.peli.getVihuOra().getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            g.setColor(Color.RED);
            g.drawString("PISTEET: " + this.peli.getPojot(), 3 * this.palikanKoko - 20, 3 * this.palikanKoko - 41);
            g.setColor(Color.GRAY);

            for (Palikka seina : this.peli.getKartta().getSeinat()) {
                g.fill3DRect(seina.getX() * this.palikanKoko, seina.getY() * this.palikanKoko, this.palikanKoko, this.palikanKoko, true);
            }

            if (this.peli.isVoita()) {
                g.setColor(Color.MAGENTA);
                g.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
                g.drawString("VOITIT!", 6 * this.palikanKoko, 9 * this.palikanKoko);
            }
            if (this.peli.isHavia()) {
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
