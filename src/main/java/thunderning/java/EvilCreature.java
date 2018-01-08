package thunderning.java;

import java.util.Random;

public class EvilCreature extends Creature{
    protected int victoryPobabilityWithHuluEva;
    protected int victoryPobabilityWithGrandpa;
    public EvilCreature(int x, int y, Field field) {
        super(x, y, field);
        isJustice = false;
        directionX = -1;
        directionY = -1;
    }

    public boolean battle(int x, int y) {
        Creature enemy = field.getPosition(x,y).getHolder();
        int victory = new Random().nextInt(100);
        if (enemy instanceof GrandPa){
            return victory < victoryPobabilityWithGrandpa;
        }else{
            return victory < victoryPobabilityWithHuluEva;
        }
    }

}
