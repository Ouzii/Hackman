package hackman.rakennuspalat;

import java.util.Random;

public class Vihollinen extends Palikka {

    public Vihollinen(int x, int y) {
        super(x, y);
        int r = new Random().nextInt(4)-1;
        super.vaihdaSuunta();
    }
}
