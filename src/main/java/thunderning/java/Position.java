package thunderning.java;

public class Position {
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x,y;

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    public void clearHolder(){this.holder=null;}

    private Creature holder;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Boolean isEmpty(){
        return holder == null;
    }
}