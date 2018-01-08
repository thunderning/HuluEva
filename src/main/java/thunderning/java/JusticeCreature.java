package thunderning.java;

import java.util.Random;

public class JusticeCreature extends Creature {
    protected int victoryPobabilityWithScorpion;
    protected int victoryPobabilityWithSnake;
    protected int victoryPobabilityWithMinion;
    public JusticeCreature(int x, int y, Field field) {
        super(x, y, field);
        isJustice = true;
        directionX = 1;
        directionY = -1;
    }

    public boolean battle(int x, int y) {
        Creature enemy = field.getPosition(x,y).getHolder();
        int victory = new Random().nextInt(100);
        if (enemy instanceof Scorpion){
            return victory < victoryPobabilityWithScorpion;
        }else if (enemy instanceof Snake){
            return victory < victoryPobabilityWithSnake;
        }
        else{
            return victory < victoryPobabilityWithMinion;
        }
    }
}
