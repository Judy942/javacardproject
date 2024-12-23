package kma;

import java.awt.Font;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Judy
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    String login, password, sign, checkCard;
    SmartCard card = new SmartCard();
    RandomString str = new RandomString();
    byte signData[];
    boolean verify;

    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        checkCard = card.checkCard();
        if (checkCard.equals("0")) {
            bt_login.setEnabled(false);
            unblock_btn.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        Input_Password = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        unblock_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 66, 89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thẻ Thành Viên Phòng Gym");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Input_Password.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Input_Password.setForeground(new java.awt.Color(53, 66, 89));
        Input_Password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 66, 89)));
        Input_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Input_PasswordActionPerformed(evt);
            }
        });

        bt_login.setBackground(new java.awt.Color(102, 102, 255));
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

        unblock_btn.setBackground(new java.awt.Color(102, 102, 255));
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
        jLabel2.setText("Nhập mật khẩu");

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
                    .addComponent(Input_Password)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(563, 563, 563)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unblock_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(Input_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unblock_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Input_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Input_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Input_PasswordActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 24)));
        checkCard = card.checkCard();
        if (Input_Password.getText().equals("") == true) {
            JOptionPane.showMessageDialog(null, "Nhập mật khẩu để đăng nhập!", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Đến đây");
        } else {
            password = new String(Input_Password.getPassword());
            System.out.println("pin " + password);
            System.out.println("pin2 " + String.format("%x", new BigInteger(1, password.getBytes(/*YOUR_CHARSET?*/))));
            System.out.println("pin3 " + card.hexStringToByteArray(String.format("%x", new BigInteger(1, password.getBytes(/*YOUR_CHARSET?*/)))));
            //id = String.format("%x", new BigInteger(1, txtId.getText().getBytes()));
            login = card.login(card.hexStringToByteArray(String.format("%x", new BigInteger(1, password.getBytes(/*YOUR_CHARSET?*/)))));
            switch (login) {
                case "7":
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 4 lần đăng nhập!", "", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 3 lần đăng nhập!", "", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 2 lần đăng nhập!", "", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu. Còn 1 lần đăng nhập!", "", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "1":
                    //TODO: Can xac thuc o day
                    String randomText = str.getAlphaNumericString(10);
                    String pinReq = String.format("%x", new BigInteger(1, password.getBytes()));
                    String random = String.format("%x", new BigInteger(1, randomText.getBytes()));
                    String data = pinReq + "03" + random;
                    signData = card.hexStringToByteArray(data);
                    sign = card.getSign(signData);
                    //lay id
                    String idT = card.getId();
                    byte[] bytes = card.hexStringToByteArray(idT);
                    String id = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("id = " + id);
                    CardInfFrame customer = new CardInfFrame();
                    customer.setLocationRelativeTo(null);
                    customer.setVisible(true);
                    this.setVisible(false);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Thẻ đã bị khóa", "", JOptionPane.INFORMATION_MESSAGE);
                    bt_login.setEnabled(false);
                    unblock_btn.setEnabled(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Có Lỗi xảy ra !!!", "", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_bt_loginActionPerformed

    private void unblock_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unblock_btnActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 24)));
        card.unblockcard();

        JOptionPane.showMessageDialog(null, "Mở khóa thành công!", "", JOptionPane.INFORMATION_MESSAGE);
        LoginFrame lg = new LoginFrame();
        lg.setLocationRelativeTo(null);
        lg.setVisible(true);
        this.setVisible(false);

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
    private javax.swing.JPasswordField Input_Password;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton unblock_btn;
    // End of variables declaration//GEN-END:variables
}
