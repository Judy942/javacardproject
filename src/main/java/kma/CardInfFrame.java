/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Judy
 */
public class CardInfFrame extends javax.swing.JFrame {

    /**
     * Creates new form CardInfFrame
     */
    SmartCard card = new SmartCard();
    ThongTinThe info = new ThongTinThe();
    int idLen, nameLen, addressLen, phoneLen;

    public CardInfFrame() {
        getContentPane().setBackground(new Color(204, 204, 255));

        initComponents();
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
        //So du, tich diem 
        String du = card.checkScore();
        String temp = du.substring(1);
        String[] divide = temp.split("ff");
        //1000000
        DecimalFormat formatter = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.'); // Đặt dấu phân cách phần nghìn là dấu chấm
        formatter.setDecimalFormatSymbols(symbols);
        int soDu = Integer.parseInt(divide[0]);

        txtSoDu.setText(formatter.format(soDu));
//        int soDu = Integer.parseInt(divide[0]);
//        txtSoDu.setText(String.valueOf(soDu));
        int diem = Integer.parseInt(divide[1]);
        txtScore.setText(String.valueOf(diem));

        //avatar
        String studentAvatar = card.getAvatar();
        System.out.println("Avatar " + studentAvatar);

//        if (studentAvatar.equals("") == false) {
//            byte[] bytesAvatar = card.hexStringToByteArray(studentAvatar);
//            ByteArrayInputStream bais = new ByteArrayInputStream(bytesAvatar);
//            BufferedImage b;
//            try {
//                b = ImageIO.read(bais);
//                ImageIcon icon = new ImageIcon(b.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
//                icon.getImage();
//                image.setIcon(icon);
//            } catch (IOException ex) {
//
//            }
//
//        }
        if (!studentAvatar.equals("")) {
            byte[] bytesAvatar = card.hexStringToByteArray(studentAvatar);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytesAvatar);
            BufferedImage b = null;  // Khởi tạo b với giá trị null để kiểm tra sau
            try {
                b = ImageIO.read(bais);
                if (b != null) {  // Kiểm tra b có phải là null không
                    ImageIcon icon = new ImageIcon(b.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
                    image.setIcon(icon);
                } else {
                    // Nếu ảnh không hợp lệ, có thể sử dụng ảnh mặc định hoặc thông báo lỗi
                    System.out.println("Không thể đọc ảnh từ byte array.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                // Xử lý lỗi nếu có vấn đề khi đọc ảnh từ byte array
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

        jLabel1 = new javax.swing.JLabel();
        txtSoDu = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtScore = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtName = new javax.swing.JLabel();
        btnNapTien = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        txtAddress = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 66, 89));
        jLabel1.setText("Thông tin thẻ");

        txtSoDu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtSoDu.setForeground(new java.awt.Color(53, 66, 89));
        txtSoDu.setText("Số dư");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(53, 66, 89));
        jLabel8.setText("Tích điểm");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(53, 66, 89));
        jLabel2.setText("ID");

        txtScore.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtScore.setForeground(new java.awt.Color(53, 66, 89));
        txtScore.setText("score");

        txtId.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtId.setForeground(new java.awt.Color(53, 66, 89));
        txtId.setText("ID");

        image.setForeground(new java.awt.Color(255, 255, 255));
        image.setText("Ảnh");
        image.setAutoscrolls(true);
        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 66, 89), 2));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(53, 66, 89));
        jLabel3.setText("Họ tên");

        btnUpdate.setBackground(new java.awt.Color(53, 66, 89));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("CẬP NHẬT");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(53, 66, 89));
        txtName.setText("Họ tên");

        btnNapTien.setBackground(new java.awt.Color(53, 66, 89));
        btnNapTien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnNapTien.setForeground(new java.awt.Color(255, 255, 255));
        btnNapTien.setText("NẠP TIỀN");
        btnNapTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapTienActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 66, 89));
        jLabel5.setText("Địa chỉ");

        btnChangePass.setBackground(new java.awt.Color(53, 66, 89));
        btnChangePass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnChangePass.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePass.setLabel("ĐỔI MẬT KHẨU");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        txtAddress.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(53, 66, 89));
        txtAddress.setText("Địa chỉ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(53, 66, 89));
        jLabel4.setText("Số điện thoại");

        txtPhone.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(53, 66, 89));
        txtPhone.setText("Sdt");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 66, 89));
        jLabel6.setText("Số dư");

        btnThanhToan.setBackground(new java.awt.Color(53, 66, 89));
        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setLabel("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(txtSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(btnNapTien, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChangePass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoDu)
                    .addComponent(jLabel8)
                    .addComponent(txtScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNapTien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        UpdateInfFrame update = new UpdateInfFrame();
        update.setVisible(true);
        update.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNapTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapTienActionPerformed
        // TODO add your handling code here:
        VerifyPassworkFrame xacThuc = new VerifyPassworkFrame();
        xacThuc.setVisible(true);
        xacThuc.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnNapTienActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
        ChangePasswordFrame changePin = new ChangePasswordFrame();
        changePin.setVisible(true);
        changePin.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        PayFrame TT = new PayFrame();
        TT.setVisible(true);
        TT.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(CardInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardInfFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardInfFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnNapTien;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel txtAddress;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPhone;
    private javax.swing.JLabel txtScore;
    private javax.swing.JLabel txtSoDu;
    // End of variables declaration//GEN-END:variables
}
