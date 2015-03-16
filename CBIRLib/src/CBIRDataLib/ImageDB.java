package CBIRDataLib;

import java.io.Serializable;
import java.util.Vector;

public class ImageDB implements Serializable{
    public Vector <ImageEntry> db;
    
    public ImageDB() {
        db = new Vector <ImageEntry> ();
    }
    
}
