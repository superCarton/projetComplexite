package model;

public class Point implements Comparable{

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Point p = (Point) o;
        return p.getX() + x;
    }

    @Override
    public String toString(){
        return x+","+y;
    }
}
