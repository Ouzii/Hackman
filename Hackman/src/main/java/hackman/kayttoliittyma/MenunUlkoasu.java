/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackman.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author oce
 */
public class MenunUlkoasu {

    private Kayttoliittyma kali;
    private JButton nappi;
    private JTextField tekstikentta;
    private JLabel merkinta;

    public MenunUlkoasu(Kayttoliittyma kali, boolean error, String errorMsg) {
        this.kali = kali;
        this.nappi = new JButton("Kirjaudu");
        this.tekstikentta = new JTextField("");
        if (!error) {
            this.merkinta = new JLabel("Anna nimesi: (max. 20 merkkiä)", SwingConstants.CENTER);
        } else {
            this.merkinta = new JLabel(errorMsg, SwingConstants.CENTER);
        }

        asetaUlkoasu();
    }

    private void asetaUlkoasu() {
        Font fontti = new Font("Comic Sans MS", Font.BOLD, 34);
        Font fontti2 = new Font("Comic Sans MS", Font.BOLD, 24);
        Dimension dimenssio = new Dimension(150, 150);
        asetaNappi(fontti, dimenssio);
        asetaTekstikentta(fontti, dimenssio);
        asetaMerkinta(fontti2, dimenssio);
    }

    private void asetaNappi(Font fontti, Dimension dimenssio) {
        this.nappi.setFont(fontti);
        this.nappi.setOpaque(true);
        this.nappi.setBackground(Color.WHITE);
        this.nappi.setForeground(Color.BLACK);
        this.nappi.setPreferredSize(dimenssio);
    }

    private void asetaTekstikentta(Font fontti, Dimension dimenssio) {
        this.tekstikentta.setFont(fontti);
        this.tekstikentta.setOpaque(true);
        this.tekstikentta.setBorder(null);
        this.tekstikentta.setBackground(Color.BLACK);
        this.tekstikentta.setForeground(Color.RED);
        this.tekstikentta.setPreferredSize(dimenssio);
        this.tekstikentta.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void asetaMerkinta(Font fontti, Dimension dimenssio) {
        this.merkinta.setFont(fontti);
        this.merkinta.setOpaque(true);
        this.merkinta.setBackground(Color.BLACK);
        this.merkinta.setForeground(Color.WHITE);
        this.merkinta.setPreferredSize(dimenssio);
    }

    public void aseta() {
        this.nappi.addActionListener(new NapinKuuntelija(this.kali.getPeli(), this.tekstikentta, this.kali));
        this.kali.getFrame().add(this.merkinta, BorderLayout.NORTH);
        this.kali.getFrame().add(this.tekstikentta, BorderLayout.CENTER);
        this.kali.getFrame().add(this.nappi, BorderLayout.SOUTH);
    }
    
    public void poistaKomponentit() {
        this.kali.getFrame().remove(this.merkinta);
        this.kali.getFrame().remove(this.nappi);
        this.kali.getFrame().remove(this.tekstikentta);
    }

}
