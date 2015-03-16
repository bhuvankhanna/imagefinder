/*
 * MainMeny.java
 *
 * Created on January 7, 2008, 2:17 PM
 */

package cbirPack;
import CBIRDataLib.ImageEntry;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import JavaLib.*;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
//            res = -1;
            // inverted since we need descending...
            res = 1;
        }else {
//            res = 1;
            res = -1;
        }
        return res;
    }
}

public class ImageQuery extends javax.swing.JFrame {
    MainMenu parent;

    public BufferedImage tiInput, tiQuery, tiSignInputGS, tiSignQueryGS, tiSignInputCol, tiSignQueryCol;
    public Graphics2D    giInput, giQuery, giSignInputGS, giSignQueryGS, giSignInputCol, giSignQueryCol;
    public ImageIcon     iiInput, iiQuery, iiSignInputGS, iiSignQueryGS, iiSignInputCol, iiSignQueryCol;
    
    // new image width, height...
    int nh, nw;
    
    // image database
    DefaultListModel lm;
    DefaultListModel lmOutCol, lmOutGS;
    
    // output labels
    JLabel jlabelOut[];
    
    // miscellaneous variables
    boolean inputSet, querySet;
    ImageEntry ieInput, ieQuery;
    
    // time for retreival
    public long timeTaken;
    
    public ImageQuery(MainMenu parent) {
        this.parent = parent;
        
        initComponents();
        Dimension sd  = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth()/ 2, sd.height / 2 - this.getHeight()/ 2);
        
        inputSet = false;
        querySet = false;
        
        // output labels...
        jlabelOut = new JLabel[6];
        jlabelOut[0] = jLabelOut0;
        jlabelOut[1] = jLabelOut1;
        jlabelOut[2] = jLabelOut2;
        jlabelOut[3] = jLabelOut3;
        jlabelOut[4] = jLabelOut4;
        jlabelOut[5] = jLabelOut5;
        // output labels end.
        
        loadDB();
        
        lmOutCol = new DefaultListModel();
        jListOutCol.setModel(lmOutCol);
        
        lmOutGS = new DefaultListModel();
        jListOutGS.setModel(lmOutGS);
        
        timeTaken = -1;
    }
    
    public void loadDB() {
        lm = new DefaultListModel();
        for(int i=0;i<parent.imageDB.db.size();i++) {
            String fname = parent.imageDB.db.get(i).imageFileName;
            lm.addElement(fname);
        }
        jListDB.setModel(lm);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelInput = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jLabelQuery = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelInputSignCol = new javax.swing.JLabel();
        jLabelInputSignGS = new javax.swing.JLabel();
        jLabelQuerySignCol = new javax.swing.JLabel();
        jLabelQuerySignGS = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabelOut0 = new javax.swing.JLabel();
        jLabelOut1 = new javax.swing.JLabel();
        jLabelOut2 = new javax.swing.JLabel();
        jLabelOut3 = new javax.swing.JLabel();
        jLabelOut4 = new javax.swing.JLabel();
        jLabelOut5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDB = new javax.swing.JList();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListOutCol = new javax.swing.JList();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListOutGS = new javax.swing.JList();
        jTextStatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("SEARCH OUTPUT");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("C.B.I.R");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Query Image"));

        jLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane3.setViewportView(jLabelInput);

        jLabelQuery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane6.setViewportView(jLabelQuery);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 213, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Images", jPanel4);

        jLabelInputSignCol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back200x200.PNG"))); // NOI18N

        jLabelInputSignGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back200x200.PNG"))); // NOI18N

        jLabelQuerySignCol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back200x200.PNG"))); // NOI18N

        jLabelQuerySignGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back200x200.PNG"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabelQuerySignCol, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabelInputSignCol, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 117, Short.MAX_VALUE)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jLabelQuerySignGS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelInputSignGS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelInputSignCol)
                    .add(jLabelInputSignGS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(29, 29, 29)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabelQuerySignGS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelQuerySignCol))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Image Signatures", jPanel7);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("L O A D    Q U E R Y    I M A G E");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("C R E A T E    Q U E R Y    I M A G E");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("P R O C E S S     C U R R E N T");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jLabelOut0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelOut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelOut3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelOut4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabelOut5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Back160x120.PNG"))); // NOI18N

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("IMAGE DATABASE");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListDB.setFont(new java.awt.Font("Tahoma", 0, 10));
        jListDB.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListDB.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListDBValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListDB);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("RESULT WITH COL. INFO");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListOutCol.setFont(new java.awt.Font("Tahoma", 0, 10));
        jListOutCol.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListOutCol.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListOutColValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListOutCol);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("RESULT W/O COL. INFO");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListOutGS.setFont(new java.awt.Font("Tahoma", 0, 10));
        jListOutGS.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListOutGS.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListOutGSValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jListOutGS);

        jTextStatus.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextStatus, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabelOut3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabelOut0))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabelOut4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabelOut1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabelOut5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabelOut2)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9Layout.createSequentialGroup()
                        .add(jButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .add(62, 62, 62)
                        .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 161, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel22, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .add(jLabel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel22)
                    .add(jLabel16)
                    .add(jLabel24))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton4)
                    .add(jButton5))
                .add(5, 5, 5)
                .add(jTextStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelOut0)
                    .add(jLabelOut1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelOut2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabelOut5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelOut4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelOut3))
                .addContainerGap())
        );

        new LoadForm();
        new LoadForm();
        new LoadForm();
        new LoadForm();
        new LoadForm();
        new LoadForm();

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("B A C K");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton3.setForeground(new java.awt.Color(0, 51, 102));
        jButton3.setText("M A N A G E    D A T A B A S E");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton6.setForeground(new java.awt.Color(0, 51, 102));
        jButton6.setText("R E F R E S H    D A T A B A S E");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                        .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 196, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButton6)
                            .add(jButton1)
                            .add(jButton3))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(new java.awt.Component[] {jButton1, jButton6}, org.jdesktop.layout.GroupLayout.VERTICAL);

        new LoadForm();
        new LoadForm();

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
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

    private void jListOutGSValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListOutGSValueChanged
// TODO add your handling code here:
        int index;        
        index = jListOutGS.getSelectedIndex();
        if(index!=-1) {
            String fname = (String)lmOutGS.get(index);
            load(5,fname);
        }
    }//GEN-LAST:event_jListOutGSValueChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        loadDB();
        new MessageBox(this,"Database Refreshed!").setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        new ManageImageQueryDatabase(parent).setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jListOutColValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListOutColValueChanged
// TODO add your handling code here:
        int index;
        
        index = jListOutCol.getSelectedIndex();
        if(index!=-1) {
            String fname = (String)lmOutCol.get(index);
            load(2,fname);
        }
    }//GEN-LAST:event_jListOutColValueChanged

    public void load(int labelIndex, String fname) {
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
            jlabelOut[labelIndex].setIcon(iiResult);
       }catch(Exception e) {
            System.out.println("Exception : " + e);
            e.printStackTrace();
       }
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        int rDiff, gDiff, bDiff, gsDiff;
        Vector <ImageScore> resultGS = new Vector <ImageScore> ();
        Vector <ImageScore> resultCol = new Vector <ImageScore> ();
        
        long t1 = Calendar.getInstance().getTimeInMillis();
        
        ImageEntry ie; 
        int limit = 15; // threshold for comparision...
        
        if(!inputSet) {
            new MessageBox(this,"Please Select A Query Image!").setVisible(true);
            return;
        }
        
        for(int imgIndex=0;imgIndex<parent.imageDB.db.size();imgIndex++) {
            ie = parent.imageDB.db.get(imgIndex);
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
        
        lmOutCol = new DefaultListModel();
        lmOutGS = new DefaultListModel();
        
        for(int i=0;i<resultCol.size();i++) {
            lmOutCol.addElement("" + parent.imageDB.db.get(resultCol.get(i).index).imageFileName);
        }
        for(int i=0;i<resultGS.size();i++) {
            lmOutGS.addElement("" + parent.imageDB.db.get(resultGS.get(i).index).imageFileName);
        }
        jListOutCol.setModel(lmOutCol);
        jListOutGS.setModel(lmOutGS);
        
        long t2 = Calendar.getInstance().getTimeInMillis();
        timeTaken = t2-t1;

        String fname0 = (String)lmOutCol.get(0);
        String fname1 = (String)lmOutCol.get(1);
        String fname3 = (String)lmOutGS.get(0);
        String fname4 = (String)lmOutGS.get(1);
        load(0,fname0);
        load(1,fname1);
        load(3,fname3);
        load(4,fname4);
        
        new Output(this).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        if((!inputSet) | (!querySet)) {
            new MessageBox(this,"Either Query Image Or Input Image Not Set!").setVisible(true);
            return;
        }
        compare();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void compare() {
        int rDiff = 0;
        int gDiff = 0;
        int bDiff = 0;
        int gsDiff = 0;
        
        int limit = 15; // threshold for comparision...
        
        String str;
        
        for(int y=0;y<10;y++) {
            for(int x=0;x<10;x++) {
                if(Math.abs(ieInput.signR[y][x]-ieQuery.signR[y][x]) < limit) {
                    rDiff++;
                }
                if(Math.abs(ieInput.signG[y][x]-ieQuery.signG[y][x]) < limit) {
                    gDiff++;
                }
                if(Math.abs(ieInput.signB[y][x]-ieQuery.signB[y][x]) < limit) {
                    bDiff++;
                }
                if(Math.abs(ieInput.signGS[y][x]-ieQuery.signGS[y][x]) < limit) {
                    gsDiff++;
                }
            }
        }
        
        str = "";
        if(ieInput.dominantCol == ieQuery.dominantCol) {
            str += "MATCH FOUND. ";
            switch(ieQuery.dominantCol) {
                case 1: // red
                    str += "RED DOMINANT. SIMILARITY: " + rDiff + "%";
                    break;
                case 2: // green
                    str += "GREEN DOMINANT. SIMILARITY: " + gDiff + "%";
                    break;
                case 3: // blue
                    str += "BLUE DOMINANT. SIMILARITY: " + bDiff + "%";
                    break;
            }
        }else {
            str += "NO MATCH. ";
            switch(ieInput.dominantCol) {
                case 1:
                    str += "INPUT RED DOMINANT. ";
                    break;
                case 2:
                    str += "INPUT GREEN DOMINANT. ";
                    break;
                case 3:
                    str += "INPUT BLUE DOMINANT. ";
                    break;
            }
            switch(ieQuery.dominantCol) {
                case 1:
                    str += "QUERY RED DOMINANT.";
                    break;
                case 2:
                    str += "QUERY GREEN DOMINANT.";
                    break;
                case 3:
                    str += "QUERY BLUE DOMINANT.";
                    break;
            }
        }
        str += " GRAYSCALE SIMILARITY: " + gsDiff + ".";
        jTextStatus.setText(str);
    }
    
    private void jListDBValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListDBValueChanged
// TODO add your handling code here:
        int index;
        // selected width height
        int sw, sh;
        
        index = jListDB.getSelectedIndex();
        if(index!=-1) {
            ieQuery = parent.imageDB.db.get(index);
            querySet = true;
            
            String fname = System.getProperty("user.dir") + "\\ImageQueryDB\\" + ieQuery.imageFileName;
            try
            {
                Image image = Toolkit.getDefaultToolkit().getImage(fname);
                MediaTracker mediaTracker = new MediaTracker(new Container());
                mediaTracker.addImage(image, 0);
                mediaTracker.waitForID(0);
                sw = image.getWidth(null);
                sh = image.getHeight(null);
                
                tiQuery = new BufferedImage(sw,sh,BufferedImage.TYPE_INT_RGB);
                giQuery = tiQuery.createGraphics();
                giQuery.drawImage(image, 0, 0, sw, sh, null);
                ImageIcon iiQuery = new ImageIcon(tiQuery);
                jLabelQuery.setIcon(iiQuery);
                
                tiSignQueryCol = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
                tiSignQueryGS = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
                giSignQueryCol = tiSignQueryCol.createGraphics();
                giSignQueryGS = tiSignQueryGS.createGraphics();
                
                int r, g, b, gs;
                for(int y=0;y<10;y++) {
                    for(int x=0;x<10;x++) {
                        r = ieQuery.signR[y][x];
                        g = ieQuery.signG[y][x];
                        b = ieQuery.signB[y][x];
                        gs = ieQuery.signGS[y][x];
                        
                        giSignQueryCol.setColor(new Color(r,g,b));
                        giSignQueryCol.fillRect(x*20,y*20,20,20);
                        giSignQueryGS.setColor(new Color(gs,gs,gs));
                        giSignQueryGS.fillRect(x*20,y*20,20,20);
                    }
                }
                iiSignQueryCol = new ImageIcon(tiSignQueryCol);
                iiSignQueryGS = new ImageIcon(tiSignQueryGS);
                
                jLabelQuerySignCol.setIcon(iiSignQueryCol);
                jLabelQuerySignGS.setIcon(iiSignQueryGS);
           }catch(Exception e) {
                System.out.println("Exception : " + e);
                e.printStackTrace();
           }
        }
    }//GEN-LAST:event_jListDBValueChanged

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
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
    }//GEN-LAST:event_jButton7ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabelInput;
    private javax.swing.JLabel jLabelInputSignCol;
    private javax.swing.JLabel jLabelInputSignGS;
    private javax.swing.JLabel jLabelOut0;
    private javax.swing.JLabel jLabelOut1;
    private javax.swing.JLabel jLabelOut2;
    private javax.swing.JLabel jLabelOut3;
    private javax.swing.JLabel jLabelOut4;
    private javax.swing.JLabel jLabelOut5;
    private javax.swing.JLabel jLabelQuery;
    private javax.swing.JLabel jLabelQuerySignCol;
    private javax.swing.JLabel jLabelQuerySignGS;
    private javax.swing.JList jListDB;
    private javax.swing.JList jListOutCol;
    private javax.swing.JList jListOutGS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextStatus;
    // End of variables declaration//GEN-END:variables
}
