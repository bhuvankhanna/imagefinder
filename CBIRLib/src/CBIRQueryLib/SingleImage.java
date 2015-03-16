/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CBIRQueryLib;

import java.io.Serializable;

/**
 *
 * @author Ravee
 */
public class SingleImage implements Serializable{
    public int pixels[][];
    public int ww, hh;

    public  SingleImage() {
        ww = -1;
        hh = -1;
    }
}
