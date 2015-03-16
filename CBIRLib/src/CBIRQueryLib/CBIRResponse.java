/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CBIRQueryLib;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Ravee
 */
public class CBIRResponse implements Serializable{
    public Vector <SingleImage> colResponse;
    public Vector <SingleImage> bwResponse;
    public int responseStatus;
    public long timeTaken;

    public CBIRResponse() {
        colResponse = new Vector<SingleImage>();
        bwResponse = new Vector<SingleImage>();
        responseStatus = 0;
        timeTaken = 0;
    }
}
