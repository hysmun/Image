/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagewindow;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import ImageClass.*;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 'Toine
 */




public class ImageWindows extends javax.swing.JFrame {

    /**
     * Creates new form ImageWindows
     */
    
    public static String ImagePath;
    public static String ImageName;
    public BufferedImage bufImage;
    public int x1tmp, y1tmp;
    public int x2tmp, y2tmp;
    public static int state;
    
    public ColorImage CI;
    
    public ImageWindows() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        BeforeLabel = new javax.swing.JLabel();
        NowLabel = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        okButton = new javax.swing.JButton();
        BeforeScroll = new javax.swing.JScrollPane();
        BeforeLabelIcon = new javax.swing.JLabel();
        AfterScroll = new javax.swing.JScrollPane();
        AfterLabelIcon = new javax.swing.JLabel();
        editCB = new javax.swing.JComboBox<>();
        doubleSpinner1 = new javax.swing.JSpinner();
        doubleSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        validateButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenuBar = new javax.swing.JMenu();
        OpenItem = new javax.swing.JMenuItem();
        EditMenuBar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ImageWindow");

        BeforeLabel.setText("Before editing");

        NowLabel.setText("Now");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        BeforeScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        BeforeScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        BeforeLabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BeforeLabelIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BeforeLabelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BeforeLabelIconMouseReleased(evt);
            }
        });
        BeforeScroll.setViewportView(BeforeLabelIcon);

        AfterScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        AfterScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        AfterLabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AfterLabelIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AfterScroll.setViewportView(AfterLabelIcon);

        editCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Taille", "ROI", "Palette", "Expansion (agrandir)", "Extraction (retrecir)" }));
        editCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editCBMouseReleased(evt);
            }
        });

        doubleSpinner1.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, null, 0.1d));

        doubleSpinner2.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, null, 0.1d));

        validateButton.setText("valider");
        validateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                validateButtonMousePressed(evt);
            }
        });

        FileMenuBar.setText("File");

        OpenItem.setText("Open image");
        OpenItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OpenItemMousePressed(evt);
            }
        });
        FileMenuBar.add(OpenItem);

        MenuBar.add(FileMenuBar);

        EditMenuBar.setText("Edit");
        MenuBar.add(EditMenuBar);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BeforeLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BeforeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doubleSpinner1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(doubleSpinner2)
                                .addGap(1, 1, 1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 34, Short.MAX_VALUE)
                                .addComponent(okButton)
                                .addGap(31, 31, 31))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editCB, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AfterScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NowLabel)
                        .addGap(36, 36, 36)
                        .addComponent(validateButton)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BeforeLabel)
                            .addComponent(NowLabel)
                            .addComponent(validateButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AfterScroll)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220)
                        .addComponent(doubleSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(doubleSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addGap(34, 34, 34))
                    .addComponent(BeforeScroll))
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OpenItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenItemMousePressed
        // TODO add your handling code here:
        System.out.println("Open Item");
        FileChooseImage fci = new FileChooseImage(this, true);
        fci.setVisible(true);
        
        if(ImagePath != null && ImageName != null)
        {
            System.out.println("Fichier choisi" + ImagePath + "  "+ ImageName);
            try {
                //fichier juste on l'affiche
                File f = new File(ImagePath);
                bufImage = ImageIO.read(f);
                
                CI = new ColorImage(bufImage);
                ImageIcon Ibefore = new ImageIcon(bufImage);
                ImageIcon Iafter = new ImageIcon(CI.bi);
                BeforeLabelIcon.setIcon(Ibefore);
                AfterLabelIcon.setIcon(Iafter);
                jSpinner1.setValue(bufImage.getWidth());
                jSpinner2.setValue(bufImage.getHeight());
                state= 0;
            }
            catch (Exception ex) {

                System.out.println("Erreur IO" + ex.getMessage());
            } 
        }
    }//GEN-LAST:event_OpenItemMousePressed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            CI.setBi(bufImage);
            if(((String)editCB.getSelectedItem()).equals("Taille"))
            {
                CI.setSize((int)jSpinner1.getValue(), (int)jSpinner2.getValue());
            }
            if(((String)editCB.getSelectedItem()).equals("ROI") )
            {
                if(state == 2)
                {
                    CI.ROI(x1tmp, y1tmp, x2tmp, y2tmp);
                    state = 0;
                }
            }
            if(((String)editCB.getSelectedItem()).equals("Palette"))
            {
                if(state == 1)
                {
                    CI.palette(x1tmp, y1tmp, (int)jSpinner1.getValue(), (int)jSpinner2.getValue(), (int)jSpinner3.getValue());
                    state = 0;
                }
            }
            if(((String)editCB.getSelectedItem()).equals("Expansion (agrandir)"))
            {
                //expansion
            }if(((String)editCB.getSelectedItem()).equals("Extraction (retrecir)"))
            {
                //extraction retrecir
                CI.extraction((double)doubleSpinner1.getValue(), (double)doubleSpinner2.getValue());
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur Image :" + e.getMessage() + "\n\n");
            System.out.println(e.getStackTrace());
        }
        RefreshAfter();
    }//GEN-LAST:event_okButtonActionPerformed

    private void BeforeLabelIconMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeforeLabelIconMouseReleased
        // TODO add your handling code here:
        if(((String)editCB.getSelectedItem()).equals("ROI") && state != 2)
        {
            if(state == 0)
            {
                x1tmp = evt.getX();
                y1tmp = evt.getY();
            }
            else
            {
                x2tmp = evt.getX();
                y2tmp = evt.getY();
            }
            state++;
        }
        if(((String)editCB.getSelectedItem()).equals("Palette"))
        {
            x1tmp = evt.getX();
            y2tmp = evt.getY();
            Color tmpC = new Color(CI.bi.getRGB(x1tmp, y1tmp));
            jSpinner1.setValue(tmpC.getRed());
            jSpinner2.setValue(tmpC.getGreen());
            jSpinner3.setValue(tmpC.getBlue());
            state=1;
        }
    }//GEN-LAST:event_BeforeLabelIconMouseReleased

    private void validateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_validateButtonMousePressed
        // TODO add your handling code here:
        bufImage = new BufferedImage(CI.bi.getWidth(), CI.bi.getHeight(), CI.bi.getType());
        Graphics g = bufImage.getGraphics();
        g.drawImage(CI.bi, 0, 0, null);
        g.dispose();
        ImageIcon Ibefore = new ImageIcon(bufImage);
        BeforeLabelIcon.setIcon(Ibefore);
        jSpinner1.setValue(bufImage.getWidth());
        jSpinner2.setValue(bufImage.getHeight());
        state=0;
    }//GEN-LAST:event_validateButtonMousePressed

    private void editCBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCBMouseReleased
        // TODO add your handling code here:
        if(((String)editCB.getSelectedItem()).equals("Taille"))
        {
            jSpinner1.setValue(bufImage.getWidth());
            jSpinner2.setValue(bufImage.getHeight());
            jSpinner3.setValue(0);
        }
        if(((String)editCB.getSelectedItem()).equals("ROI") )
        {
            jSpinner1.setValue(0);
            jSpinner2.setValue(0);
            jSpinner3.setValue(0);
        }
        if(((String)editCB.getSelectedItem()).equals("Palette"))
        {
           jSpinner1.setValue(0);
           jSpinner2.setValue(0);
           jSpinner3.setValue(0);
        }
        if(((String)editCB.getSelectedItem()).equals("Expansion (agrandir)"))
        {
            
        }if(((String)editCB.getSelectedItem()).equals("Extraction (retrecir)"))
        {
            
        }
        state=0;
    }//GEN-LAST:event_editCBMouseReleased
    
    public void RefreshAfter()
    {
        ImageIcon Iafter = new ImageIcon(CI.bi);
        AfterLabelIcon.setIcon(Iafter);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AfterLabelIcon;
    private javax.swing.JScrollPane AfterScroll;
    private javax.swing.JLabel BeforeLabel;
    private javax.swing.JLabel BeforeLabelIcon;
    private javax.swing.JScrollPane BeforeScroll;
    private javax.swing.JMenu EditMenuBar;
    private javax.swing.JMenu FileMenuBar;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel NowLabel;
    private javax.swing.JMenuItem OpenItem;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JSpinner doubleSpinner1;
    private javax.swing.JSpinner doubleSpinner2;
    private javax.swing.JComboBox<String> editCB;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JButton okButton;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
}
