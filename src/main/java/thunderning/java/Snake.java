package thunderning.java;

import java.util.Random;

public class Snake extends EvilCreature {
    public Snake(int x, int y, Field field) {
        super(x, y, field);
        imageName = "snake.png";
        setImageByName();
        victoryPobabilityWithGrandpa = 30;
        victoryPobabilityWithHuluEva = 80;
    }

}
