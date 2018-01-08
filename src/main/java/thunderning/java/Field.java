package thunderning.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Field extends JPanel {

    private final int OFFSET = 30;
    private final int SPACE = 60;

    private ArrayList tiles = new ArrayList();
    private ArrayList<ArrayList<Position>> positions = new ArrayList<ArrayList<Position>>();
    private ArrayList creatures = new ArrayList();
//    private Creature creature;
//    private Creature creature2;

    private int rowCount = 10;
    private int columnCount = 10;

    private int justiceCount = 8;
    private int injusticeCount = 8;

    private int w = rowCount * SPACE + OFFSET;
    private int h = rowCount * SPACE + OFFSET;


    public boolean isCompleted() {
        return completed;
    }

    private boolean completed = false;

//    private String level =
//            "..........\n" +
//                    "..........\n" +
//                    "..........\n" +
//                    "..........\n" +
//                    "..........\n" +
//                    "..........\n" +
//                    "..........\n" +
//                    "..........\n";

    public Field() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    public final void initWorld() {

        int x = OFFSET;
        int y = OFFSET;

        Tile a;

        for (int i = 0;i < this.rowCount ; i++){
            ArrayList<Position> temp = new ArrayList<Position>();
            for (int j = 0;j < this.columnCount ; j++){
                temp.add(new Position(i,j));
                tiles.add(new Tile(i,j));
            }
            positions.add(temp);
        }

        creatures.add(new GrandPa(0,1,this));
        creatures.add(new HuluEva(1,2,this,SENIORITY.一));
        creatures.add(new HuluEva(2,3,this,SENIORITY.二));
        creatures.add(new HuluEva(1,4,this,SENIORITY.三));
        creatures.add(new HuluEva(2,5,this,SENIORITY.四));
        creatures.add(new HuluEva(1,6,this,SENIORITY.五));
        creatures.add(new HuluEva(2,7,this,SENIORITY.六));
        creatures.add(new HuluEva(1,8,this,SENIORITY.七));
        creatures.add(new Scorpion(8,4,this));
        creatures.add(new Snake(9,5,this));
        creatures.add(new Minion(9,1,this));
        creatures.add(new Minion(8,2,this));
        creatures.add(new Minion(9,3,this));
        creatures.add(new Minion(8,6,this));
        creatures.add(new Minion(9,7,this));
        creatures.add(new Minion(8,8,this));

    }

    public void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList world = new ArrayList();
        world.addAll(tiles);
        world.addAll(creatures);

        for (int i = 0; i < world.size(); i++) {

            Thing2D item = (Thing2D) world.get(i);

            if (item instanceof Creature) {
                if (((Creature) item).getIsAlive())
                    g.drawImage(item.getImage(), OFFSET + item.x()*SPACE + 10 , item.y()*SPACE + OFFSET + 5, this);
                else
                    g.drawImage(item.getImage(), OFFSET + item.x()*SPACE + 5 , item.y()*SPACE + OFFSET + 10, this);
            } else {
                g.drawImage(item.getImage(), OFFSET + item.x()*SPACE, item.y()*SPACE + OFFSET, this);
            }

            if (completed) {
                g.setColor(new Color(0, 0, 0));
                if (justiceCount == 0)
                    g.drawString("INJUSTICE WIN!", 250, 20);
                else
                    g.drawString("JUSTICE WIN!", 250, 20);
            }else{
                g.setColor(new Color(0, 0, 0));
                g.drawString("JUSTICE " + justiceCount + " : " + injusticeCount + " INJUSTICE", 250, 20);
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (completed) {
                return;
            }


            int key = e.getKeyCode();


            if (key == KeyEvent.VK_SPACE) {

                for (int i = 0;i<creatures.size();i++){
                    Creature t = (Creature) creatures.get(i);
                    new Thread(t).start();
                }

            } else if (key == KeyEvent.VK_R) {
                restartLevel();
            }
            repaint();
        }
    }


    public void restartLevel() {

        tiles.clear();
        creatures.clear();

        initWorld();
        if (completed) {
            completed = false;
        }
    }

    public Position getPosition(int x,int y){
        return positions.get(y).get(x);
    }
    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void oneJusticeKilled(){
        justiceCount --;
        if (justiceCount == 0){
            completed = true;
        }
    }
    public void oneInjusticeKilled(){
        injusticeCount --;
        if (injusticeCount == 0){
            completed = true;
        }
    }
}