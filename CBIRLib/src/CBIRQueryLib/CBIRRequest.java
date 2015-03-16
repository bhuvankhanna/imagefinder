/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CBIRQueryLib;

import CBIRDataLib.ImageEntry;
import java.io.Serializable;

/**
 *
 * @author Ravee
 */
public class CBIRRequest implements Serializable {
    public ImageEntry ie;
    public CBIRRequest() {
        ie = new ImageEntry();
    }
}
