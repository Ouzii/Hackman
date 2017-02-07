package hackman.peli;

import hackman.kayttoliittyma.Paivitettava;
import hackman.rakennuspalat.Bitti;
import hackman.rakennuspalat.Palikka;
import hackman.rakennuspalat.Pelihahmo;
import hackman.rakennuspalat.Vihollinen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.Timer;

public class Peli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private Paivitettava paivitettava;
    private boolean alkaa;
    private Pelihahmo pelaaja;
    private Kartta kartta;
    private Vihollinen vihu;
    private int askelia;
    private int vuoro;
    private int pojot;
    private boolean voita;
    private boolean highscore;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.pelaaja = new Pelihahmo(10, 10);
        this.kartta = new Kartta(20, 20);
        this.pojot = 0;
        this.vihu = new Vihollinen(4, 3);
        this.askelia = 0;
        this.vuoro = 0;
        this.alkaa = false;
        this.voita = false;
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

    public Vihollinen getVihu() {
        return vihu;
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
        
//        try {
//            Scanner lukija = new Scanner(System.in);
//            Scanner tiedostonLukija = new Scanner(new File("src/main/resources/highscore.txt"));
//            FileWriter tiedostoonKirjoittaja = new FileWriter("src/main/resources/highscore.txt");
//            System.out.print("Anna nimesi: ");
//            String nimi = lukija.nextLine();
//            String vanha = "";
//            while(tiedostonLukija.hasNextLine()) {
//                vanha += tiedostonLukija.nextLine();
//            }
////            tiedostoonKirjoittaja.write(vanha);
//            tiedostoonKirjoittaja.write(vanha + "\n" + nimi + ", " + this.pojot);
//            tiedostoonKirjoittaja.close();
//        } catch (Exception e) {
//            System.out.println("fail");
//        }
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
    
    public void liikuVihollinen() {
        int a = 0;
            for (Palikka seina : this.kartta.getSeinat()) {
                if (!this.kartta.osuuSeinaan(this.vihu)) {
                    a++;
                }
            }
            if (a >= this.korkeus) {
                vihu.liiku();
            } else {
                this.vihu.vaihdaSuunta();
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.pelaaja.osuuVihuun(this.vihu)) {
            super.stop();
        }

        if (this.vuoro == 0) {
            this.liikuPelaaja();
            this.vuoro++;
        } else {
            if (this.askelia >= 5) {
                this.vihu.vaihdaSuunta();
                this.askelia = 0;
            } else {
                this.askelia++;
            }
            this.liikuVihollinen();
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
