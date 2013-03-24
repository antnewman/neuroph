package org.neuroph.netbeans.ide.imageeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.neuroph.imgrec.ImageUtilities;
import org.neuroph.imgrec.image.ImageFactory;
import org.neuroph.imgrec.image.ImageJ2SE;
import org.openide.util.Exceptions;

/*
 * SimpleImageEditor.java
 *
 * Created on Dec 31, 2011, 1:18:32 AM
 */
/**
 *
 * @author hrza
 */
public class SimpleImageEditor extends JFrame {

    boolean cropingReady = false;
    Graphics bufferedGraphics;
    Image offscreen;
    Rectangle newCrop;
    private org.neuroph.imgrec.image.Image image;
    String imgPath;
    ImageChangeListener changeListener;
    boolean imageChanged = false;

    /** Creates new form SimpleImageEditor */
    public SimpleImageEditor() {
        super("Image editor");
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = imagePanel = new ImagePanel();
        jPanel1 = new javax.swing.JPanel();
        cropButton = new javax.swing.JButton();
        resizeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        widthField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        heightField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        grayscaleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        imagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        getContentPane().add(imagePanel, java.awt.BorderLayout.CENTER);

        cropButton.setText("Crop");
        cropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropButtonActionPerformed(evt);
            }
        });

        resizeButton.setText("Resize to");
        resizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resizeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Width:");

        jLabel2.setText("Height:");

        okButton.setText("Ok");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        grayscaleButton.setText("Grayscale");
        grayscaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayscaleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cropButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resizeButton)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heightField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(grayscaleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cropButton)
                    .addComponent(resizeButton)
                    .addComponent(jLabel1)
                    .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(heightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(cancelButton)
                    .addComponent(grayscaleButton))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setImage(String imgPath) {
        this.imgPath = imgPath;
        File imageFile = new File(imgPath);
        if (imageFile.exists() && !imageFile.isDirectory()) {
            image = ImageFactory.getImage(imageFile);
        }
        
        widthField.setText(""+image.getWidth());
        heightField.setText(""+image.getHeight());

        BufferedImage bimg = ((ImageJ2SE) image).getBufferedImage();
        ((ImagePanel) imagePanel).setImage(bimg);
        imageChanged = false;
    
    }
    
    public void setListener(ImageChangeListener changeListener) {
       this.changeListener = changeListener; 
    }

    private void resizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizeButtonActionPerformed
        int width = Integer.parseInt(widthField.getText().trim());
        int height = Integer.parseInt(heightField.getText().trim());
        org.neuroph.imgrec.image.Image scaledImage = ImageUtilities.resizeImage(image, width, height);
        BufferedImage bimg = ((ImageJ2SE) scaledImage).getBufferedImage();
        ((ImagePanel) imagePanel).setImage(bimg);
         onImageChange();
    }//GEN-LAST:event_resizeButtonActionPerformed

    private void cropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cropButtonActionPerformed
        ImagePanel imgPanel = (ImagePanel) imagePanel;
        if (((ImagePanel) imagePanel).isCropSelected()) {
            int x1 = imgPanel.getCropX1();
            int x2 = imgPanel.getCropX2();
            int y1 = imgPanel.getCropY1();
            int y2 = imgPanel.getCropY2();
            
            if (x2 < x1) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }
            
            if (y2 < y1) {
                int temp = y1;
                y1 = y2;
                y2= temp;
            }            

            BufferedImage cropedImage = ImageUtilities.cropImage( ((ImageJ2SE)image).getBufferedImage(), x1, y1, x2, y2);
      //      BufferedImage bimg = ((ImageJ2SE) cropedImage).getBufferedImage();
            imgPanel.setImage(cropedImage);
            onImageChange();
        }

    }//GEN-LAST:event_cropButtonActionPerformed

private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            ImageIO.write(((ImageJ2SE)image).getBufferedImage(), "jpg", new File(imgPath));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    changeListener.imageChanged();
    this.dispose();
}//GEN-LAST:event_okButtonActionPerformed

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    this.dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

    private void grayscaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayscaleButtonActionPerformed
       
        int width  = image.getWidth();
        int height = image.getHeight();

        // convert to grayscale
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = new Color(image.getPixel(x, y));
                Color gray = toGray(color);
                image.setPixel(x, y, gray.getRGB());
            }
        }
        
            BufferedImage bimg = ((ImageJ2SE) image).getBufferedImage();
             ((ImagePanel) imagePanel).setImage(bimg);
            onImageChange();        
        
    }//GEN-LAST:event_grayscaleButtonActionPerformed

    public static double lum(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return .299*r + .587*g + .114*b;
    }

    // return a gray version of this Color
    public static Color toGray(Color color) {
        int y = (int) (Math.round(lum(color)));   // round to nearest int
        Color gray = new Color(y, y, y);
        return gray;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cropButton;
    private javax.swing.JButton grayscaleButton;
    private javax.swing.JTextField heightField;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton resizeButton;
    private javax.swing.JTextField widthField;
    // End of variables declaration//GEN-END:variables

    private void onImageChange() {
        okButton.setEnabled(true);
        imageChanged = true;
    }

}
