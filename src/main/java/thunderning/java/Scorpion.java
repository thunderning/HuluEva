package thunderning.java;

import java.util.Random;

public class Scorpion extends EvilCreature {
    public Scorpion(int x, int y, Field field) {
        super(x, y, field);
        imageName = "scorpion.png";
        setImageByName();
        victoryPobabilityWithGrandpa = 100;
        victoryPobabilityWithHuluEva = 80;
    }

}
