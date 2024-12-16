/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kma;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Judy
 */
public class ConnectFrame extends javax.swing.JFrame {

    /**
     * Creates new form ConnectFrame
     */
    boolean isConnect = false;
    SmartCard sc = new SmartCard();

    public ConnectFrame() {
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_cnt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        bt_cnt.setBackground(new java.awt.Color(102, 102, 255));
        bt_cnt.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        bt_cnt.setForeground(new java.awt.Color(255, 255, 255));
        bt_cnt.setText("KẾT NỐI VỚI THẺ");
        bt_cnt.setBorder(null);
        bt_cnt.setBorderPainted(false);
        bt_cnt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_cnt.setDefaultCapable(false);
        bt_cnt.setFocusPainted(false);
        bt_cnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cntActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 66, 89));
        jLabel1.setText("Thẻ thành viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(bt_cnt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(bt_cnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cntActionPerformed
        // TODO add your handling code here:

        if (!isConnect) {//true
            if (sc.connectCard()) {
                isConnect = true;
                bt_cnt.setText("Ngắt kết nối với thẻ");
                bt_cnt.setForeground(Color.RED);
                String checkCard = sc.checkCard();
                if (checkCard.equals("0")) {
                    InitCardFrame formInit = new InitCardFrame();
                    formInit.setVisible(true);
                    formInit.setLocationRelativeTo(null);
                } else {
                    LoginFrame formLogin = new LoginFrame();
                    formLogin.setVisible(true);
                    formLogin.setLocationRelativeTo(null);
                }

            } else {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 24)));
                JOptionPane.showMessageDialog(this, "connect thất bại", "", JOptionPane.WARNING_MESSAGE);
                isConnect = false;
                bt_cnt.setText("Kết nối với thẻ");
                bt_cnt.setForeground(Color.BLACK);
            }
        } else {
            if (sc.disconnect()) {
                isConnect = false;
                bt_cnt.setText("Kết nối với thẻ");
                bt_cnt.setForeground(Color.BLACK);

            }
        }
    }//GEN-LAST:event_bt_cntActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cnt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
