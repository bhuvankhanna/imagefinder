/*
 * imageEntry.java
 *
 * Created on May 3, 2008, 3:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package CBIRDataLib;

import java.io.Serializable;

/**
 *
 * @author Ravee
 */
public class ImageEntry implements Serializable {
    public String imageFileName;
    public int signR[][];
    public int signG[][];
    public int signB[][];
    public int signGS[][];
    
    public int dominantCol;
    
    /** Creates a new instance of imageEntry */
    public ImageEntry() {
        imageFileName = "";
        signR = new int[10][10];
        signG = new int[10][10];
        signB = new int[10][10];
        signGS = new int[10][10];
        dominantCol = -1; // no. 1-r 2-g 3-b
    }
}
