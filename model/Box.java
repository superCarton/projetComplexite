package model;
public class Box {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    private Point position = null;
    private int x;
    private int y;

    public Box(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean isBigger(Box b){
        return size() > b.size();
    }

    public int size(){
        return x * y;
    }

    @Override
    public String toString(){
        return "Coordonnée: "+ getPosition() +"; taille: "+getX() + "x" + getY() +"\n";
    }
}
