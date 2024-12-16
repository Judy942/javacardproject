/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kma;

import java.awt.Font;
import java.awt.HeadlessException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Judy
 */
public class VerifyPassworkFrame extends javax.swing.JFrame {

    /**
     * Creates new form VerifyPassworkFrame
     */
    SmartCard card = new SmartCard();
    RandomString str = new RandomString();
    String pin, sign;
    BigInteger modulusPubkey, exponentPubkey;
    byte signData[];

    public VerifyPassworkFrame() {
        initComponents();
        setLocationRelativeTo(null);
        modulusPubkey = card.getModulusPubkey();
        exponentPubkey = card.getExponentPubkey();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        bntOK = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 66, 89));
        jLabel1.setText("XÁC NHẬN MẬT KHẨU");

        txtPin.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPin.setForeground(new java.awt.Color(53, 66, 89));
        txtPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPinActionPerformed(evt);
            }
        });

        bntOK.setBackground(new java.awt.Color(53, 66, 89));
        bntOK.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bntOK.setForeground(new java.awt.Color(255, 255, 255));
        bntOK.setText("OK");
        bntOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntOKActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(53, 66, 89));
        jLabel8.setText("Nhập mật khẩu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(bntOK, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntOK, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPinActionPerformed

    private void bntOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntOKActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 24)));
        boolean verify;
        if (txtPin.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Mời nhập mật khẩu!", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //xác thực Mật khẩu
            pin = new String(txtPin.getPassword());
            String login = card.login(card.hexStringToByteArray(String.format("%x", new BigInteger(1, pin.getBytes(/*YOUR_CHARSET?*/)))));
            switch (login) {
                case "7" -> JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 4 lần. Mời nhập lại!", "", JOptionPane.INFORMATION_MESSAGE);
                case "6" -> JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 3 lần. Mời nhập lại!", "", JOptionPane.INFORMATION_MESSAGE);
                case "5" -> JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 2 lần. Mời nhập lại!", "", JOptionPane.INFORMATION_MESSAGE);
                case "4" -> JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 1 lần. Mời nhập lại!", "", JOptionPane.INFORMATION_MESSAGE);
                case "1" -> {
                    //ToDO: Can xac thuc o day
                    String randomText = str.getAlphaNumericString(10);
                    String pinReq = String.format("%x", new BigInteger(1, pin.getBytes()));
                    String random = String.format("%x", new BigInteger(1, randomText.getBytes()));
                    String data = pinReq + "03" + random;
                    signData = card.hexStringToByteArray(data);
                    sign = card.getSign(signData);
                    //lay id
                    String idT = card.getId();
                    byte[] bytes = card.hexStringToByteArray(idT);
                    String id = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("id = " + id);
                    
                    DepositFrame napTien = new DepositFrame();
                    napTien.setVisible(true);
                    napTien.setLocationRelativeTo(null);
                    this.setVisible(false);
                    
                }
                case "2" -> JOptionPane.showMessageDialog(null, "Thẻ đã bị khóa", "", JOptionPane.INFORMATION_MESSAGE);
                default -> {
                }

            }
        }
    }//GEN-LAST:event_bntOKActionPerformed


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
            java.util.logging.Logger.getLogger(VerifyPassworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerifyPassworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerifyPassworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerifyPassworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerifyPassworkFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
