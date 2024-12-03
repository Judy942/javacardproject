
package kma.javacardproject;

/**
 *
 * @author Judy
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        Input_Pin = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        init_btn = new javax.swing.JButton();
        unblock_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 66, 89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thẻ Thành Viên Phòng Gym");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 66, 89)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Input_Pin.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Input_Pin.setForeground(new java.awt.Color(53, 66, 89));
        Input_Pin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 66, 89)));
        Input_Pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Input_PinActionPerformed(evt);
            }
        });

        bt_login.setBackground(new java.awt.Color(53, 66, 89));
        bt_login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt_login.setForeground(new java.awt.Color(255, 255, 255));
        bt_login.setText("ĐĂNG NHẬP");
        bt_login.setBorderPainted(false);
        bt_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_login.setPreferredSize(new java.awt.Dimension(170, 30));
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        init_btn.setBackground(new java.awt.Color(53, 66, 89));
        init_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        init_btn.setForeground(new java.awt.Color(255, 255, 255));
        init_btn.setText("KHỞI TẠO THẺ");
        init_btn.setBorderPainted(false);
        init_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        init_btn.setPreferredSize(new java.awt.Dimension(170, 30));
        init_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                init_btnActionPerformed(evt);
            }
        });

        unblock_btn.setBackground(new java.awt.Color(53, 66, 89));
        unblock_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        unblock_btn.setForeground(new java.awt.Color(255, 255, 255));
        unblock_btn.setText("MỞ KHÓA THẺ");
        unblock_btn.setBorder(null);
        unblock_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unblock_btn.setPreferredSize(new java.awt.Dimension(170, 50));
        unblock_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unblock_btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(53, 66, 89));
        jLabel2.setText("Nhập mã PIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Input_Pin)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(init_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(unblock_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(563, 563, 563)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Input_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(init_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unblock_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Input_PinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Input_PinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Input_PinActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_loginActionPerformed

    private void init_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_init_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_init_btnActionPerformed

    private void unblock_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unblock_btnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_unblock_btnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Input_Pin;
    private javax.swing.JButton bt_login;
    private javax.swing.JButton init_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton unblock_btn;
    // End of variables declaration//GEN-END:variables
}