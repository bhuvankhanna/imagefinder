/*
 * MainMeny.java
 *
 * Created on January 7, 2008, 2:17 PM
 */

package cbirPack;
import CBIRDataLib.ImageEntry;
import CBIRQueryLib.CBIRRequest;
import CBIRQueryLib.CBIRResponse;
import CBIRQueryLib.SingleImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import JavaLib.*;
import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageQuery extends javax.swing.JFrame {
    MainMenu parent;

    public BufferedImage tiInput, tiSignInputGS, tiSignInputCol;
    public Graphics2D    giInput, giSignInputGS, giSignInputCol;
    public ImageIcon     iiInput, iiSignInputGS, iiSignInputCol;
    
    // new image width, height...
    int nh, nw;
    
    // miscellaneous variables
    boolean inputSet;
    ImageEntry ieInput;

    public CBIRRequest cbirRequest;
    public CBIRResponse cbirResponse;

    public BufferedImage biBW[], biCol[], biBWScaled[], biColScaled[];
    
    public ImageQuery(MainMenu parent) {
        this.parent = parent;
        
        initComponents();
        Dimension sd  = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth()/ 2, sd.height / 2 - this.getHeight()/ 2);
        
        inputSet = false;

        cbirRequest = new CBIRRequest();
        cbirResponse = new CBIRResponse();
        biBW = new BufferedImage[6];
        biCol = new BufferedImage[6];
        biBWScaled = new BufferedImage[6];
        biColScaled = new BufferedImage[6];

        for(int i=0;i<6;i++) {
            biBWScaled[i] = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
            biColScaled[i] = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
        }
        
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelInput = new javax.swing.JLabel();
        jLabelInputSignCol = new javax.swing.JLabel();
        jLabelInputSignGS = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("SEARCH OUTPUT");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CBIR - REMOTE QUERY INTERFACE");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Query Image"));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("LOAD QUERY IMAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane3.setViewportView(jLabelInput);

        jLabelInputSignCol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back200x200.PNG"))); // NOI18N

        jLabelInputSignGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back200x200.PNG"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("B A C K");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("P R O C E S S    A L L");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("CREATE QUERY IMAGE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .add(jButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .add(34, 34, 34)
                        .add(jLabelInputSignCol)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabelInputSignGS)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabelInputSignCol)
                    .add(jLabelInputSignGS)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jButton1)))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        new LoadForm();

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        new LoadForm();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        if(!inputSet) {
            new MessageBox(this,"Please Select A Query Image!").setVisible(true);
            return;
        }

        // call servlet....
        cbirRequest.ie = ieInput;
        try {
            System.gc();
            String urlstr = "http://" + parent.jTextServerName.getText() + ":8080/servlets-examples/ToClient";
            URL url = new URL(urlstr);
            URLConnection connection = url.openConnection();

            connection.setDoOutput(true);
            connection.setDoInput(true);

            // don't use a cached version of URL connection
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            ObjectOutputStream out1 = new ObjectOutputStream(connection.getOutputStream());
            out1.writeObject(cbirRequest);
            out1.close();
            
            ObjectInputStream in1 = new ObjectInputStream(connection.getInputStream());
            cbirResponse = (CBIRResponse)in1.readObject();
            in1.close();
            
            System.out.println("Response Status: " + cbirResponse.responseStatus);
            for(int i=0;i<cbirResponse.colResponse.size() && i<6;i++) {
                SingleImage siCol = cbirResponse.colResponse.get(i);
                SingleImage siBW = cbirResponse.bwResponse.get(i);
                biCol[i] = new BufferedImage(siCol.ww, siCol.hh, BufferedImage.TYPE_INT_RGB);
                biBW[i] = new BufferedImage(siBW.ww, siBW.hh, BufferedImage.TYPE_INT_RGB);
                for(int y=0;y<siCol.hh;y++) {
                    for(int x=0;x<siCol.ww;x++) {
                        biCol[i].setRGB(x, y, siCol.pixels[y][x]);
                    }
                }
                for(int y=0;y<siBW.hh;y++) {
                    for(int x=0;x<siBW.ww;x++) {
                        biBW[i].setRGB(x, y, siBW.pixels[y][x]);
                    }
                }
                ((Graphics2D)(biColScaled[i].getGraphics())).drawImage(biCol[i], 0, 0, 160, 120, null);
                ((Graphics2D)(biBWScaled[i].getGraphics())).drawImage(biBW[i], 0, 0, 160, 120, null);
            }
            //call output...
            new Output(this).setVisible(true);
        }catch(Exception e) {
            new MessageBox(this,"Exception Querying Server!").setVisible(true);
            System.out.println("Exception: " + e);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        try
        {
            System.gc();
            FileDialog fd = new FileDialog(this,"Load From",FileDialog.LOAD);
            fd.setVisible(true);
            if(fd.getFile()==null) {
                return;
            }
            
            String fname = fd.getDirectory() + fd.getFile();
            Image image = Toolkit.getDefaultToolkit().getImage(fname);
            MediaTracker mediaTracker = new MediaTracker(new Container());
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);
            
            nw = image.getWidth(null);
            nh = image.getHeight(null);
            
            tiInput = new BufferedImage(nw, nh, BufferedImage.TYPE_INT_RGB);
            giInput = tiInput.createGraphics();
            giInput.drawImage(image, 0, 0, nw, nh, null);
            iiInput = new ImageIcon(tiInput);
            jLabelInput.setIcon(iiInput);
            
            tiSignInputCol = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            giSignInputCol = tiSignInputCol.createGraphics();
            tiSignInputGS  = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            giSignInputGS = tiSignInputGS.createGraphics();
            
            int yDiv = nh/10;
            int xDiv = nw/10;
            int col, r, g, b, gs;
            long rSum, gSum, bSum, gsSum;
            long rDom, gDom, bDom, maxDom;
            
            ieInput = new ImageEntry();
            
            rDom = gDom = bDom = 0;
            for(int y=0;y<10;y++) {
                for(int x=0;x<10;x++) {
                    rSum = gSum = bSum = gsSum = 0;
                    for(int yy=y*yDiv;yy<(y+1)*yDiv;yy++) {
                        for(int xx=x*xDiv;xx<(x+1)*xDiv;xx++) {
                            col = tiInput.getRGB(xx,yy);
                            r = (col >> 16) & 0xff;
                            g = (col >> 8) & 0xff;
                            b = (col >> 0) & 0xff;
                            gs = (int)(r*0.33 + g*0.56 + b*0.11);
                            rSum += r;
                            gSum += g;
                            bSum += b;
                            gsSum += gs;
                        }
                    }
                    r = (int)(rSum/(yDiv*xDiv));
                    g = (int)(gSum/(yDiv*xDiv));
                    b = (int)(bSum/(yDiv*xDiv));
                    gs = (int)(gsSum/(yDiv*xDiv));
                    
                    ieInput.signR[y][x] = r;
                    ieInput.signG[y][x] = g;
                    ieInput.signB[y][x] = b;
                    ieInput.signGS[y][x] = gs;
                    
                    rDom += r;
                    gDom += g;
                    bDom += b;
                    
                    giSignInputCol.setColor(new Color(r,g,b));
                    giSignInputCol.fillRect(x*20,y*20,20,20);
                    giSignInputGS.setColor(new Color(gs,gs,gs));
                    giSignInputGS.fillRect(x*20,y*20,20,20);
                }
            }
            iiSignInputCol = new ImageIcon(tiSignInputCol);
            jLabelInputSignCol.setIcon(iiSignInputCol);
            iiSignInputGS = new ImageIcon(tiSignInputGS);
            jLabelInputSignGS.setIcon(iiSignInputGS);
            
            maxDom = Math.max(rDom,Math.max(gDom,bDom));
            if(maxDom==rDom) {
                ieInput.dominantCol = 1; // red
            }else if(maxDom==gDom) {
                ieInput.dominantCol = 2; // blue 
            }else if(maxDom==bDom) {
                ieInput.dominantCol = 3; // green
            }
            inputSet = true;
        }catch(Exception e) {
            System.out.println("Exception Loading Image: " + e);
            e.printStackTrace();
            inputSet = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CreateImage ci = new CreateImage(this);
        ci.setVisible(true);
        if(!ci.ok)
            return;

        try
        {
            System.gc();
            String fname = "C:\\temp.png";
            Image image = Toolkit.getDefaultToolkit().getImage(fname);
            MediaTracker mediaTracker = new MediaTracker(new Container());
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);

            nw = image.getWidth(null);
            nh = image.getHeight(null);

            tiInput = new BufferedImage(nw, nh, BufferedImage.TYPE_INT_RGB);
            giInput = tiInput.createGraphics();
            giInput.drawImage(image, 0, 0, nw, nh, null);
            iiInput = new ImageIcon(tiInput);
            jLabelInput.setIcon(iiInput);

            tiSignInputCol = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            giSignInputCol = tiSignInputCol.createGraphics();
            tiSignInputGS  = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            giSignInputGS = tiSignInputGS.createGraphics();

            int yDiv = nh/10;
            int xDiv = nw/10;
            int col, r, g, b, gs;
            long rSum, gSum, bSum, gsSum;
            long rDom, gDom, bDom, maxDom;

            ieInput = new ImageEntry();

            rDom = gDom = bDom = 0;
            for(int y=0;y<10;y++) {
                for(int x=0;x<10;x++) {
                    rSum = gSum = bSum = gsSum = 0;
                    for(int yy=y*yDiv;yy<(y+1)*yDiv;yy++) {
                        for(int xx=x*xDiv;xx<(x+1)*xDiv;xx++) {
                            col = tiInput.getRGB(xx,yy);
                            r = (col >> 16) & 0xff;
                            g = (col >> 8) & 0xff;
                            b = (col >> 0) & 0xff;
                            gs = (int)(r*0.33 + g*0.56 + b*0.11);
                            rSum += r;
                            gSum += g;
                            bSum += b;
                            gsSum += gs;
                        }
                    }
                    r = (int)(rSum/(yDiv*xDiv));
                    g = (int)(gSum/(yDiv*xDiv));
                    b = (int)(bSum/(yDiv*xDiv));
                    gs = (int)(gsSum/(yDiv*xDiv));

                    ieInput.signR[y][x] = r;
                    ieInput.signG[y][x] = g;
                    ieInput.signB[y][x] = b;
                    ieInput.signGS[y][x] = gs;

                    rDom += r;
                    gDom += g;
                    bDom += b;

                    giSignInputCol.setColor(new Color(r,g,b));
                    giSignInputCol.fillRect(x*20,y*20,20,20);
                    giSignInputGS.setColor(new Color(gs,gs,gs));
                    giSignInputGS.fillRect(x*20,y*20,20,20);
                }
            }
            iiSignInputCol = new ImageIcon(tiSignInputCol);
            jLabelInputSignCol.setIcon(iiSignInputCol);
            iiSignInputGS = new ImageIcon(tiSignInputGS);
            jLabelInputSignGS.setIcon(iiSignInputGS);

            maxDom = Math.max(rDom,Math.max(gDom,bDom));
            if(maxDom==rDom) {
                ieInput.dominantCol = 1; // red
            }else if(maxDom==gDom) {
                ieInput.dominantCol = 2; // blue
            }else if(maxDom==bDom) {
                ieInput.dominantCol = 3; // green
            }
            inputSet = true;
        }catch(Exception e) {
            System.out.println("Exception Loading Image: " + e);
            e.printStackTrace();
            inputSet = false;
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabelInput;
    private javax.swing.JLabel jLabelInputSignCol;
    private javax.swing.JLabel jLabelInputSignGS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
