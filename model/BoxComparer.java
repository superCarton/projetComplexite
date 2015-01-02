package model;

import java.util.Comparator;

/**
 * Created by yukikoo on 1/2/15.
 */
public class BoxComparer implements Comparator<Box> {
    @Override
    public int compare(Box box, Box t1) {
        if(box.size() > t1.size()){
            return -1;
        }else if(box.size() == t1.size()){
            return 0;
        }
        return 1;
    }
}
