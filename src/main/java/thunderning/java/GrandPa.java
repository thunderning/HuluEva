package thunderning.java;

import java.util.Random;

public class GrandPa extends JusticeCreature {
    public GrandPa(int x, int y, Field field) {
        super(x, y, field);
        this.imageName = "grandpa.png";
        setImageByName();
        victoryPobabilityWithMinion = 40;
        victoryPobabilityWithScorpion = 20;
        victoryPobabilityWithSnake = 70;
    }
//    @Override
//    public void run() {
//        while (isAlive) {
//            Random rand = new Random();
//            try {
//                this.move(rand.nextInt(2),0);
//                Thread.sleep(rand.nextInt(1000) + 1000);
//                this.field.repaint();
//            } catch (Exception e) {
//
//            }
//        }
//    }
}
