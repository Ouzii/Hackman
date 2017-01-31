package hackman.rakennuspalat;

import java.util.Random;

public class Vihollinen extends Palikka {


    public Vihollinen(int x, int y) {
        super(x, y);
        super.setSuunta(Suunta.ALAS);
    }
    
    public boolean vaihdaSuunta() {
        
        int i = new Random().nextInt(3) + 1;
        if (i == 1) {
            setSuunta(Suunta.ALAS);
            return true;
        }

        if (i == 2) {
            setSuunta(Suunta.YLOS);
            return true;
        }

        if (i == 3) {
            setSuunta(Suunta.OIKEA);
            return true;
        }

        if (i == 4) {
            setSuunta(Suunta.VASEN);
            return true;
        }
        
        return false;
    }
}
