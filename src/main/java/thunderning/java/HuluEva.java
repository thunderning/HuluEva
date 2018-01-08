package thunderning.java;

public class HuluEva extends JusticeCreature{
    public HuluEva(int x, int y, Field field, SENIORITY seniority) {
        super(x, y, field);
        switch (seniority) {
            case 一:
                imageName = "redEva.png";
                victoryPobabilityWithMinion = 80;
                victoryPobabilityWithScorpion = 90;
                victoryPobabilityWithSnake = 90;
                break;
            case 二:
                imageName = "orangeEva.png";
                victoryPobabilityWithMinion = 50;
                victoryPobabilityWithScorpion = 40;
                victoryPobabilityWithSnake = 40;
                break;
            case 三:
                imageName = "yellowEva.png";
                victoryPobabilityWithMinion = 100;
                victoryPobabilityWithScorpion = 80;
                victoryPobabilityWithSnake = 80;
                break;
            case 四:
                imageName = "greenEva.png";
                victoryPobabilityWithMinion = 90;
                victoryPobabilityWithScorpion = 60;
                victoryPobabilityWithSnake = 80;
                break;
            case 五:
                imageName = "blueEva.png";
                victoryPobabilityWithMinion = 90;
                victoryPobabilityWithScorpion = 80;
                victoryPobabilityWithSnake = 60;
                break;
            case 六:
                imageName = "purpleEva.png";
                victoryPobabilityWithMinion = 40;
                victoryPobabilityWithScorpion = 100;
                victoryPobabilityWithSnake = 100;
                break;
            case 七:
                imageName = "blackEva.png";
                victoryPobabilityWithMinion = 100;
                victoryPobabilityWithScorpion = 90;
                victoryPobabilityWithSnake = 40;
                break;
        }
        setImageByName();
    }
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}
