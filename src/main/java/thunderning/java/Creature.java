package thunderning.java;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;

import static java.lang.Thread.sleep;

public abstract class Creature extends Thing2D implements Runnable {
    protected Field field;
    protected Position position;
    protected String imageName = "player.png";
    protected boolean isJustice;
    protected boolean isAlive = true;
    protected int directionX;
    protected int directionY;

    public boolean getIsAlive() {
        return isAlive;
    }

    public Position getPosition() {
        return position;
    }

    public boolean getJustice() {
        return isJustice;
    }

    public Creature(int x, int y, Field field) {
        super(x, y);

        this.field = field;
        this.position = field.getPosition(x,y);
        this.position.setHolder(this);
        setImageByName();
    }

    public void setImageByName(){
        URL loc = this.getClass().getClassLoader().getResource(imageName);
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public abstract boolean battle(int x,int y);

    public boolean move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        if (nx >= this.field.getColumnCount() || nx < 0) {
            directionX = -directionX;
            return false;
        }
        if (ny >= this.field.getRowCount() || ny < 0){
            directionY = -directionY;
            return false;
        }
        synchronized (this.field.getPosition(nx,ny)){
            synchronized (this.position){
                if (!this.isAlive || this.field.isCompleted()) return false;
                if (this.field.getPosition(nx,ny).isEmpty()){
                    this.setX(nx);
                    this.setY(ny);
                    this.position.clearHolder();
                    this.position = this.field.getPosition(nx,ny);
                    this.position.setHolder(this);
                    return true;
                }
                else if (this.field.getPosition(nx,ny).getHolder().getJustice() != this.getJustice()
                        && this.field.getPosition(nx,ny).getHolder().getIsAlive()){
                    if (battle(nx,ny)){
                        this.field.getPosition(nx,ny).getHolder().wasKilled();
                    }
                    else{
                        this.wasKilled();
                    }
                }else{
                    if (x == 1)
                        directionX = -directionX;
                    if (y == 1)
                        directionY = -directionY;
                }
            }
        }

        return false;
    }


    public void run() {
        while (this.isAlive && !this.field.isCompleted()) {
            Random rand = new Random();
            try {
                this.move(rand.nextInt(2) * directionX,rand.nextInt(2) * directionY);
                sleep(rand.nextInt(500) + 500);
                this.field.repaint();
            } catch (Exception e) {

            }
        }
        try {
            sleep(10000);
            this.position.clearHolder();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void wasKilled(){
        this.isAlive = false;
        this.imageName = "Died"+this.imageName;
        this.setImageByName();
        if (isJustice){
            field.oneJusticeKilled();
        }else{
            field.oneInjusticeKilled();
        }
        this.field.repaint();
        //Thread.currentThread().notify();
        //Thread.currentThread().stop();
    }

}