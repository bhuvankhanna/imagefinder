/*
 * Output.java
 *
 * Created on June 21, 2008, 1:37 PM
 */

package cbirPack;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import JavaLib.*;

public class Output1 extends javax.swing.JDialog {
    ImageQuery parent;
    JLabel jlWith[];
    JLabel jlWithout[];
    
    int currIndexWith, currIndexWithout;
    int maxWith, maxWithout;
    
    /** Creates new form Output */
    public Output1(ImageQuery parent) {
        super(parent, true);
        this.parent = parent;
        initComponents();
        Dimension sd  = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth()/ 2, sd.height / 2 - this.getHeight()/ 2);
        
        jlWith = new JLabel[6];
        jlWithout = new JLabel[6];
        
        jlWith[0] = jLabelWith0;
        jlWith[1] = jLabelWith1;
        jlWith[2] = jLabelWith2;
        jlWith[3] = jLabelWith3;
        jlWith[4] = jLabelWith4;
        jlWith[5] = jLabelWith5;
        
        jlWithout[0] = jLabelWithout0;
        jlWithout[1] = jLabelWithout1;
        jlWithout[2] = jLabelWithout2;
        jlWithout[3] = jLabelWithout3;
        jlWithout[4] = jLabelWithout4;
        jlWithout[5] = jLabelWithout5;
        
        maxWith = 6;
        maxWithout = 6;
        
        if(maxWith == 0) {
            currIndexWith = -1;
        }else {
            currIndexWith = 0;
        }
        if(maxWithout == 0) {
            currIndexWithout = -1;
        }else {
            currIndexWith = 0;
        }
        
        jLabelMain.setText("RESULT RETREIVED IN: " + parent.cbirResponse.timeTaken + " milliSecs.");
        
        loadImages();
    }
    
    public void loadImages() {
//        int index;
//        for(int i=0;i<6;i++) {
//            index = currIndexWith + i;
//            if( (index >= maxWith) || (index < 0)) {
//                loadWithBlank(i);
//            }else {
//                String fname = (String)parent.lmOutCol.get(index);
//                loadWith(i,fname);
//            }
//        }
//        for(int i=0;i<6;i++) {
//            index = currIndexWithout + i;
//            if( (index >= maxWithout) || (index < 0)) {
//                loadWithoutBlank(i);
//            }else {
//                String fname = (String)parent.lmOutGS.get(index);
//                loadWithout(i,fname);
//            }
//        }
    }
    
    public void loadWith(int labelIndex, String fname) {
        try
        {
            fname = System.getProperty("user.dir") + "\\ImageQueryDB\\" + fname;
            Image image = Toolkit.getDefaultToolkit().getImage(fname);
            MediaTracker mediaTracker = new MediaTracker(new Container());
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);

            BufferedImage biResult = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
            Graphics2D giResult = biResult.createGraphics();
            giResult.drawImage(image, 0, 0, 160, 120, null);
            ImageIcon iiResult = new ImageIcon(biResult);
            jlWith[labelIndex].setIcon(iiResult);
       }catch(Exception e) {
            System.out.println("Exception : " + e);
            e.printStackTrace();
       }
    }
    
    public void loadWithBlank(int labelIndex) {
        try
        {
            BufferedImage biResult = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
            Graphics2D giResult = biResult.createGraphics();
            ImageIcon iiResult = new ImageIcon(biResult);
            jlWith[labelIndex].setIcon(iiResult);
       }catch(Exception e) {
            System.out.println("Exception : " + e);
            e.printStackTrace();
       }
    } 
    
    public void loadWithout(int labelIndex, String fname) {
        try
        {
            fname = System.getProperty("user.dir") + "\\ImageQueryDB\\" + fname;
            Image image = Toolkit.getDefaultToolkit().getImage(fname);
            MediaTracker mediaTracker = new MediaTracker(new Container());
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);

            BufferedImage biResult = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
            Graphics2D giResult = biResult.createGraphics();
            giResult.drawImage(image, 0, 0, 160, 120, null);
            ImageIcon iiResult = new ImageIcon(biResult);
            jlWithout[labelIndex].setIcon(iiResult);
       }catch(Exception e) {
            System.out.println("Exception : " + e);
            e.printStackTrace();
       }
    }
    
    public void loadWithoutBlank(int labelIndex) {
        try
        {
            BufferedImage biResult = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
            Graphics2D giResult = biResult.createGraphics();
            ImageIcon iiResult = new ImageIcon(biResult);
            jlWithout[labelIndex].setIcon(iiResult);
       }catch(Exception e) {
            System.out.println("Exception : " + e);
            e.printStackTrace();
       }
    } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabelWith0 = new javax.swing.JLabel();
        jLabelWith1 = new javax.swing.JLabel();
        jLabelWith2 = new javax.swing.JLabel();
        jLabelWith3 = new javax.swing.JLabel();
        jLabelWith4 = new javax.swing.JLabel();
        jLabelWith5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabelMain = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabelWithout0 = new javax.swing.JLabel();
        jLabelWithout1 = new javax.swing.JLabel();
        jLabelWithout2 = new javax.swing.JLabel();
        jLabelWithout3 = new javax.swing.JLabel();
        jLabelWithout4 = new javax.swing.JLabel();
        jLabelWithout5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        new LoadForm();

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Query Result With Color Information"));

        jLabelWith0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWith1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWith2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWith3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWith4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWith5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelWith0)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWith1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWith2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWith3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWith4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWith5)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelWith0)
                    .add(jLabelWith1)
                    .add(jLabelWith2)
                    .add(jLabelWith3)
                    .add(jLabelWith4)
                    .add(jLabelWith5))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton3.setForeground(new java.awt.Color(0, 51, 102));
        jButton3.setText("O K");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabelMain.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMain.setFont(new java.awt.Font("Arial", 1, 18));
        jLabelMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMain.setText("Q U E R Y    R E S U L T");
        jLabelMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Query Result Without Color Information"));

        jLabelWithout0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWithout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWithout2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWithout3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWithout4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelWithout5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelWithout0)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWithout1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWithout2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWithout3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWithout4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWithout5)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelWithout0)
                    .add(jLabelWithout1)
                    .add(jLabelWithout2)
                    .add(jLabelWithout3)
                    .add(jLabelWithout4)
                    .add(jLabelWithout5))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 237, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton3)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabelMain;
    private javax.swing.JLabel jLabelWith0;
    private javax.swing.JLabel jLabelWith1;
    private javax.swing.JLabel jLabelWith2;
    private javax.swing.JLabel jLabelWith3;
    private javax.swing.JLabel jLabelWith4;
    private javax.swing.JLabel jLabelWith5;
    private javax.swing.JLabel jLabelWithout0;
    private javax.swing.JLabel jLabelWithout1;
    private javax.swing.JLabel jLabelWithout2;
    private javax.swing.JLabel jLabelWithout3;
    private javax.swing.JLabel jLabelWithout4;
    private javax.swing.JLabel jLabelWithout5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
    
}
