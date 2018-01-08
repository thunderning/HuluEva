package thunderning.java;

import java.util.Random;

public class Minion extends EvilCreature{
    public Minion(int x, int y, Field field) {
        super(x, y, field);
        this.imageName = "minion.png";
        setImageByName();
        victoryPobabilityWithGrandpa = 60;
        victoryPobabilityWithGrandpa = 50;
    }

}
