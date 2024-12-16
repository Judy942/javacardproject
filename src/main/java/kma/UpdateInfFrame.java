/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kma;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Judy
 */
public class UpdateInfFrame extends javax.swing.JFrame {

    /**
     * Creates new form UpdateInfFrame
     */
    byte[] photo = null;
    SmartCard card = new SmartCard();
    int idLen, nameLen, addressLen, phoneLen;

    public UpdateInfFrame() {
        initComponents();
        txtId.setEditable(false);
        txtPhone.setEditable(false);
        setLocationRelativeTo(null);
        String Info = card.getInfo();
        System.out.println("info " + Info);
        byte[] bytes = card.hexStringToByteArray(Info);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 0x03) {
                if (idLen == 0) {
                    idLen = i;
                } else if (nameLen == 0) {
                    nameLen = i - idLen - 1;
                } else if (phoneLen == 0) {
                    phoneLen = i - idLen - nameLen - 2;
                    addressLen = bytes.length - i - 1;
                }
            }
        }
        byte[] id, name, address, phone;
        id = new byte[idLen];
        name = new byte[nameLen];
        address = new byte[addressLen];
        phone = new byte[phoneLen];
        for (int i = 0; i < idLen; i++) {
            id[i] = bytes[i];
        }

        for (int i = 0; i < nameLen; i++) {
            name[i] = bytes[i + idLen + 1];
        }

        for (int i = 0; i < phoneLen; i++) {
            phone[i] = bytes[i + idLen + 1 + nameLen + 1];
        }

        for (int i = 0; i < addressLen; i++) {
            address[i] = bytes[i + idLen + 1 + nameLen + 1 + phoneLen + 1];
        }

        txtId.setText(new String(id, StandardCharsets.UTF_8));
        txtName.setText(new String(name, StandardCharsets.UTF_8));
        txtAddress.setText(new String(address, StandardCharsets.UTF_8));
        txtPhone.setText(new String(phone, StandardCharsets.UTF_8));
        String studentAvatar = card.getAvatar();
        if (studentAvatar.equals("") == false) {
            byte[] bytesAvatar = card.hexStringToByteArray(studentAvatar);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytesAvatar);
            BufferedImage b;
            try {
                b = ImageIO.read(bais);
                ImageIcon icon = new ImageIcon(b.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
                icon.getImage();
                image.setIcon(icon);
            } catch (IOException ex) {

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        ButtonSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        image = new javax.swing.JLabel();
        btnImage1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 180, 204), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(53, 66, 89));
        jLabel4.setText("Họ Tên");

        txtName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(53, 66, 89));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 66, 89));
        jLabel5.setText("Số điện thoại");

        txtPhone.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(53, 66, 89));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 66, 89));
        jLabel6.setText("Địa chỉ");

        txtAddress.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(53, 66, 89));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        ButtonSave.setBackground(new java.awt.Color(53, 66, 89));
        ButtonSave.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        ButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSave.setText("CẬP NHẬT THÔNG TIN");
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 66, 89));
        jLabel7.setText("ID");

        txtId.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtId.setForeground(new java.awt.Color(53, 66, 89));

        image.setForeground(new java.awt.Color(53, 66, 89));
        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 180, 204)));

        btnImage1.setBackground(new java.awt.Color(182, 205, 216));
        btnImage1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnImage1.setForeground(new java.awt.Color(53, 66, 89));
        btnImage1.setText("CHỌN ẢNH");
        btnImage1.setToolTipText("");
        btnImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage1ActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        back.setForeground(new java.awt.Color(53, 66, 89));
        back.setText("Quay lại");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(txtName)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                .addComponent(txtAddress)))))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(btnImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(53, 66, 89));
        jLabel3.setText("CẬP NHẬT THÔNG TIN ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 24)));
        System.out.println("Test " + photo);
        if (txtName.getText().equals("") == true || txtAddress.getText().equals("") == true) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // get data from input
            String stName = String.format("%x", new BigInteger(1, txtName.getText().getBytes()));
            String address = String.format("%x", new BigInteger(1, txtAddress.getText().getBytes()));
            String avatar = String.format("%x", new BigInteger(1, photo));
            String dataReq = stName + "03" + address;
            System.out.println("dataReq ;" + dataReq);
            boolean res;
            boolean resUpAvatar;
            resUpAvatar = card.uploadAvatar(card.hexStringToByteArray(avatar));
            res = true;
//            res = card.changeInfo(card.hexStringToByteArray(dataReq));
            if (res&&resUpAvatar) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "", JOptionPane.INFORMATION_MESSAGE);
                CardInfFrame customer = new CardInfFrame();
                customer.setVisible(true);
                customer.setLocationRelativeTo(null);
                this.setVisible(false);
            } else {
                if (!resUpAvatar&&res) {
                    JOptionPane.showMessageDialog(null, "Cập nhật ảnh thất bại !", "", JOptionPane.INFORMATION_MESSAGE);
                    CardInfFrame customer = new CardInfFrame();
                    customer.setVisible(true);
                    customer.setLocationRelativeTo(null);
                    this.setVisible(false);
                } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại !", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_ButtonSaveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        CardInfFrame customer = new CardInfFrame();
        customer.setVisible(true);
        customer.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void btnImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage1ActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 24)));
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        File f = jFileChooser.getSelectedFile();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(f.toString()).getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
        image.setIcon(imageIcon);
        String fileName = f.getAbsolutePath();
        System.out.println("ok " + f.toString());
        try {
            BufferedImage bImage = ImageIO.read(new File(fileName));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            photo = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnImage1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateInfFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSave;
    private javax.swing.JButton back;
    private javax.swing.JButton btnImage1;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
