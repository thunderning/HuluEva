import com.sun.rmi.rmid.ExecPermission;

import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

public class Player extends Actor implements Runnable{
    private Board borad;

    public Player(int x, int y, Board board) {
        super(x, y);

        this.borad = board;

        URL loc = this.getClass().getResource("sokoban.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            this.move(1,1);
            try{
                Random rand = new Random();

                Thread.sleep(rand.nextInt(1000)+2000);
                this.borad.repaint();

            }catch (Exception e){

            }
        }
    }
}