/*
 * ToClient.java
 *
 * Created on April 25, 2008, 2:11 PM
 */

import CBIRDataLib.ImageDB;
import CBIRDataLib.ImageEntry;
import CBIRQueryLib.CBIRRequest;
import CBIRQueryLib.CBIRResponse;
import CBIRQueryLib.SingleImage;
import java.io.*;
import java.net.*;
import java.util.Random;
import JavaLib.*;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.ImageIcon;

class ImageScore implements Comparable<ImageScore> {
    public int index, score;

    public ImageScore(int index, int score) {
        this.index = index;
        this.score = score;
    }

    public String toString() {
        return ("I[" + index + "], S[" + score + "]");
    }

    public int compareTo(ImageScore is) {
        int res = 0;
        if(score == is.score) {
            res = 0;
        }else if(score < is.score) {
            // res = -1;
            // inverted since we need descending...
            res = 1;
        }else {
            // res = 1;
            res = -1;
        }
        return res;
    }
}

public class ToClient extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        CBIRRequest cbirReq = new CBIRRequest();
        CBIRResponse cbirRes = new CBIRResponse();
        ImageDB imageDB = new ImageDB();
        ImageEntry ieInput = new ImageEntry();
        
        try
        {
            System.gc();
            ObjectInputStream in1 = new ObjectInputStream(request.getInputStream());
            cbirReq = (CBIRRequest)in1.readObject();
            in1.close();

            ieInput = cbirReq.ie;

            // load image database...
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("C:\\Java Projects\\1736.CBIR\\ShapeColor-CBIR\\ImageQueryDB\\SIGNDB.DAT"));
            imageDB = (ImageDB)in2.readObject();
            in2.close();
            
            int rDiff, gDiff, bDiff, gsDiff;
            Vector <ImageScore> resultGS = new Vector <ImageScore> ();
            Vector <ImageScore> resultCol = new Vector <ImageScore> ();

            long t1 = Calendar.getInstance().getTimeInMillis();

            ImageEntry ie;
            int limit = 15; // threshold for comparision...

            for(int imgIndex=0;imgIndex<imageDB.db.size();imgIndex++) {
                ie = imageDB.db.get(imgIndex);
                rDiff = gDiff = bDiff = gsDiff = 0;
                for(int y=0;y<10;y++) {
                    for(int x=0;x<10;x++) {
                        if(Math.abs(ie.signR[y][x]-ieInput.signR[y][x]) < limit) {
                            rDiff++;
                        }
                        if(Math.abs(ie.signG[y][x]-ieInput.signG[y][x]) < limit) {
                            gDiff++;
                        }
                        if(Math.abs(ie.signB[y][x]-ieInput.signB[y][x]) < limit) {
                            bDiff++;
                        }
                        if(Math.abs(ie.signGS[y][x]-ieInput.signGS[y][x]) < limit) {
                            gsDiff++;
                        }
                    }
                }
                // if both have same dominance...
                if(ie.dominantCol == ieInput.dominantCol) {
                    switch(ie.dominantCol) {
                        case 1: // red
                            resultCol.add(new ImageScore(imgIndex,rDiff));
                            break;
                        case 2: // green
                            resultCol.add(new ImageScore(imgIndex,gDiff));
                            break;
                        case 3: // blue
                            resultCol.add(new ImageScore(imgIndex,bDiff));
                            break;
                    }
                }
                resultGS.add(new ImageScore(imgIndex,gsDiff));
            }
            System.out.println("Done Comparing Images!");

            Collections.sort(resultCol);
            Collections.sort(resultGS);
            System.out.println("Done Comparing Images!");

            // load color images for output...
            for(int i=0;i<6;i++) {
                int ww, hh;
                String fname = "C:\\Java Projects\\1736.CBIR\\ShapeColor-CBIR\\ImageQueryDB\\" + imageDB.db.get(resultCol.get(i).index).imageFileName;
                Image image = Toolkit.getDefaultToolkit().getImage(fname);
                MediaTracker mediaTracker = new MediaTracker(new Container());
                mediaTracker.addImage(image, 0);
                mediaTracker.waitForID(0);
                ww = image.getWidth(null);
                hh = image.getHeight(null);
                BufferedImage bi = new BufferedImage(ww,hh,BufferedImage.TYPE_INT_RGB);
                ((Graphics2D)(bi.getGraphics())).drawImage(image, 0, 0, ww, hh, null);
                SingleImage si = new SingleImage();
                si.hh = hh;
                si.ww = ww;
                si.pixels = new int[hh][ww];
                for(int y=0;y<hh;y++) {
                    for(int x=0;x<ww;x++) {
                        si.pixels[y][x] = bi.getRGB(x, y);
                    }
                }
                cbirRes.colResponse.add(si);
            }
            
            // load b/w images for output...
            for(int i=0;i<6;i++) {
                int ww, hh;
                String fname = "C:\\Java Projects\\1736.CBIR\\ShapeColor-CBIR\\ImageQueryDB\\" + imageDB.db.get(resultGS.get(i).index).imageFileName;
                Image image = Toolkit.getDefaultToolkit().getImage(fname);
                MediaTracker mediaTracker = new MediaTracker(new Container());
                mediaTracker.addImage(image, 0);
                mediaTracker.waitForID(0);
                ww = image.getWidth(null);
                hh = image.getHeight(null);
                BufferedImage bi = new BufferedImage(ww,hh,BufferedImage.TYPE_INT_RGB);
                ((Graphics2D)(bi.getGraphics())).drawImage(image, 0, 0, ww, hh, null);
                SingleImage si = new SingleImage();
                si.hh = hh;
                si.ww = ww;
                si.pixels = new int[hh][ww];
                for(int y=0;y<hh;y++) {
                    for(int x=0;x<ww;x++) {
                        si.pixels[y][x] = bi.getRGB(x, y);
                    }
                }
                cbirRes.bwResponse.add(si);
            }
            long t2 = Calendar.getInstance().getTimeInMillis();
            cbirRes.timeTaken = t2-t1;

            // send response back to client...
            cbirRes.responseStatus = 1; // ok
            ObjectOutputStream out1 = new ObjectOutputStream(response.getOutputStream());
            out1.writeObject(cbirRes);
            out1.close();
        } catch(Exception e) {
            cbirRes.responseStatus = -1; // error
            ObjectOutputStream out2 = new ObjectOutputStream(response.getOutputStream());
            out2.writeObject(cbirRes);
            out2.close();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        new LoadForm();
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        new LoadForm();
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
