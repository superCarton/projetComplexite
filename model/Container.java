package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yukikoo on 1/2/15.
 */
public class Container {

    public List<Box> getRangement() {
        return rangement;
    }

    public void setRangement(List<Box> rangement) {
        this.rangement = rangement;
    }

    private List<Box> rangement = new LinkedList<>();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public Container(int x, int y){
        this.x = x;
        this.y = y;
    }

}
