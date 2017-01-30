package hackman.peli;

import hackman.logiikka.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Vihollinen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private boolean alkaa;
    private Pelihahmo pelaaja;
    private Bitti bitti;
    private Palikka seina;
    private Palikka seina1;
    private Kartta kartta;
    private Vihollinen vihu;
    private int pojot;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
        this.bitti = new Bitti(8, 8);
        this.kartta = new Kartta(20, 20);
        this.seina = new Palikka(13, 13);
        this.seina1 = new Palikka(13, 8);
        this.pojot = 0;
//        this.vihu = new Vihollinen(13, 10);
        this.addActionListener(this);
        super.setDelay(400);
    }

//    HUOM !! KOODI SEKAVAA, KOSKA KOKEILUVAIHEESSA
    public Pelihahmo getPelaaja() {
        return this.pelaaja;
    }

    public Vihollinen getVihu() {
        return vihu;
    }

    public Bitti getBitti() {
        return this.bitti;
    }

    public int getPojot() {
        return pojot;
    }

    public Palikka getSeina() {
        return seina;
    }

    public Palikka getSeina1() {
        return seina1;
    }

    public Kartta getKartta() {
        return this.kartta;
    }
    
    public int getLeveys() {
        return this.leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public void lopeta() {
        super.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        if (this.pelaaja.getHahmo().osuu(this.vihu.getHahmo())) {
//            this.pelaaja.kuole();
//            super.stop();
//        }

        int i = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if(!this.kartta.osuuSeinaan(this.pelaaja)) {
                i++;
            }
        }
        
        if(i>= this.korkeus) {
            pelaaja.liiku();
        }
        
//        if (!this.pelaaja.osuuSeinaan(this.seina) && !this.pelaaja.osuuSeinaan(this.seina1)) {
//            this.pelaaja.liiku();
//        }
//        if(!this.kartta.osuuSeinaan(this.pelaaja)) {
//            this.pelaaja.liiku();
//        }

//        if (!this.vihu.osuuSeinaan(this.seina) && !this.vihu.osuuSeinaan(this.seina1)) {
//            this.vihu.liiku();
//        } else {
//            this.vihu.vaihdaSuunta();
//        }

        if (this.pelaaja.getHahmo().osuu(this.bitti) && !this.bitti.isKeratty()) {
            this.bitti.setKeratty(true);
            this.pojot++;
        }
        
        paivitettava.paivita();

    }

}
