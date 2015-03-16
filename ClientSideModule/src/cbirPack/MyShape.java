
package cbirPack;

import java.util.Vector;


public class MyShape {
    int minX, minY, maxX, maxY;
    Vector <Integer> xArr;
    Vector <Integer> yArr;
    
    public MyShape() {
        xArr = new Vector <Integer> ();
        yArr = new Vector <Integer> ();
        minX = minY = -1;
    }
}
