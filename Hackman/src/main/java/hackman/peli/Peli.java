package hackman.peli;

import hackman.kayttoliittyma.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Suunta;
import hackman.rakennuspalat.VihollinenMusta;
import hackman.rakennuspalat.VihollinenPunainen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private boolean alkaa;
    private Pelihahmo pelaaja;
    private Kartta kartta;
    private VihollinenPunainen vihuPun;
    private VihollinenMusta vihuMus;
    private int askelia;
    private int vuoro;
    private int pojot;
    private boolean voita;
    private boolean havia;
    private boolean highscore;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = new Kartta1(20, 20);
        this.pojot = 0;
        this.vihuPun = new VihollinenPunainen(4, 3);
        this.vihuMus = new VihollinenMusta(leveys-2, korkeus-2);
        this.askelia = 0;
        this.vuoro = 0;
        this.alkaa = false;
        this.voita = false;
        this.havia = false;
        this.highscore = false;
        this.addActionListener(this);
        super.setDelay(200);
        super.stop();
    }

//    HUOM !! KOODI SEKAVAA, KOSKA KOKEILUVAIHEESSA
    public Pelihahmo getPelaaja() {
        return this.pelaaja;
    }

    public boolean isHighscore() {
        return highscore;
    }

    public Paivitettava getPaivitettava() {
        return paivitettava;
    }

    public void setHighscore(boolean highscore) {
        this.highscore = highscore;
    }

    public VihollinenPunainen getVihuPun() {
        return vihuPun;
    }

    public VihollinenMusta getVihuMus() {
        return vihuMus;
    }

    public boolean isAlkaa() {
        return alkaa;
    }

    public void setAlkaa() {
        this.alkaa = true;
        super.start();
    }

    public boolean isVoita() {
        return voita;
    }

    public void voita() {
        this.voita = true;
        super.stop();
    }

    public boolean isHavia() {
        return havia;
    }
    
    public void havia() {
        this.havia = true;
        super.stop();
    }
    
    public int getPojot() {
        return pojot;
    }

    public Kartta getKartta() {
        return this.kartta;
    }

    public void setAskelia(int askelia) {
        this.askelia = askelia;
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
    
    public void liikuPelaaja() {
        int i = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if (!this.kartta.osuuSeinaan(this.pelaaja)) {
                i++;
            }
        }

        if (i >= this.korkeus) {
            pelaaja.liiku();
        }
    }
    
    public void liikuVihollinenPun() {
        int a = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if (!this.kartta.osuuSeinaan(this.vihuPun)) {
                a++;
            }
        }
        if (a >= this.korkeus) {
            vihuPun.liiku();
        } else {
            this.vihuPun.vaihdaSuunta();
        }
    }
    
    public void liikuVihollinenMus() {
        if(this.pelaaja.getX() == this.vihuMus.getX() && this.pelaaja.getY() < this.vihuMus.getY()) {
            this.vihuMus.setSuunta(Suunta.YLOS);
        }
        if(this.pelaaja.getX() == this.vihuMus.getX() && this.pelaaja.getY() > this.vihuMus.getY()) {
            this.vihuMus.setSuunta(Suunta.ALAS);
        }
        if(this.pelaaja.getX() < this.vihuMus.getX() && this.pelaaja.getY() == this.vihuMus.getY()) {
            this.vihuMus.setSuunta(Suunta.VASEN);
        }
        if(this.pelaaja.getX() > this.vihuMus.getX() && this.pelaaja.getY() == this.vihuMus.getY()) {
            this.vihuMus.setSuunta(Suunta.OIKEA);
        }
        
        int a = 0;
        for (Palikka seina : this.kartta.getSeinat()) {
            if (!this.kartta.osuuSeinaan(this.vihuMus)) {
                a++;
            }
        }
        if (a >= this.korkeus) {
            vihuMus.liiku();
        } else {
            this.vihuMus.vaihdaSuunta();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.pelaaja.osuuVihuun(this.vihuPun)) {
            this.havia();
        }
        if (this.pelaaja.osuuVihuun(this.vihuMus)) {
            this.havia();
        }

        if (this.vuoro == 0) {
            this.liikuPelaaja();
            this.vuoro++;
        } else {
            if (this.askelia >= 5) {
                this.vihuPun.vaihdaSuunta();
                this.askelia = 0;
            } else {
                this.askelia++;
            }
            this.liikuVihollinenPun();
            this.liikuVihollinenMus();
            this.vuoro--;
        }
        
        
        for (Bitti bitti : this.kartta.getBitit()) {
            if (this.pelaaja.osuu(bitti) && !bitti.isKeratty()) {
                bitti.setKeratty(true);
                this.pojot++;
            }
        }
        
        if(this.pojot == this.kartta.getBitit().size()) {
            this.voita();
        }

        paivitettava.paivita();

    }

}
