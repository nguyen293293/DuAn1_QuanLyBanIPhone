package com.shoptao.view;

import com.shoptao.services.impl.NhanVienService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.LoginHelper;
import com.shoptao.utilities.MailHelper;
import com.shoptao.utilities.Validation;
import com.shoptao.viewmodel.NhanVienViewModel;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import com.shoptao.services.ChungServices;

/**
 *
 * @author DEll
 */
public class LoginForm extends javax.swing.JFrame {

    private ChungServices<NhanVienViewModel> nhanVienService;
    private int maXacNhan;
    CardLayout card;
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);

        pnlChung.add("login", pnlLogin);
        pnlChung.add("quenmatkhau", pnlQuenMatKhau);

        card = new CardLayout();
        card = (CardLayout) pnlChung.getLayout();
        card.show(pnlChung, "login");

        nhanVienService = new NhanVienService();

        btnHide.setOpaque(false);
        btnHide.setContentAreaFilled(false);
        btnHide.setBorderPainted(false);
    }

    private boolean validation() {
        if (!Validation.CheckTrongText(txtUser, txtPfPass)) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlChung = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        lblPass = new javax.swing.JLabel();
        txtPfPass = new javax.swing.JPasswordField();
        btnHide = new javax.swing.JButton();
        lblQuenMatKhau = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblLogin = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        pnlQuenMatKhau = new javax.swing.JPanel();
        lblPass1 = new javax.swing.JLabel();
        btnGuiMa = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        lblLogin1 = new javax.swing.JLabel();
        lblUser1 = new javax.swing.JLabel();
        lblUser2 = new javax.swing.JLabel();
        lblPass2 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtMaXacNhan = new javax.swing.JTextField();
        txtMatKhauMoi = new javax.swing.JTextField();
        txtXacNhan = new javax.swing.JTextField();
        lblDangNhap = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconApple.png"))); // NOI18N

        pnlChung.setBackground(new java.awt.Color(204, 255, 204));
        pnlChung.setLayout(new java.awt.CardLayout());

        pnlLogin.setBackground(new java.awt.Color(204, 255, 204));

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPass.setText("Pass :");

        txtPfPass.setBackground(new java.awt.Color(204, 255, 204));
        txtPfPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPfPass.setText("123");
        txtPfPass.setBorder(null);

        btnHide.setBackground(new java.awt.Color(204, 255, 204));
        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_eye_35px.png"))); // NOI18N
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });

        lblQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(0, 153, 204));
        lblQuenMatKhau.setText("Quên mật khẩu ?");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });

        btnSignUp.setBackground(new java.awt.Color(153, 255, 153));
        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSignUp.setText("Đăng nhập");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 204, 0));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);
        jSeparator1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSeparator1MouseClicked(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(51, 204, 0));
        jSeparator2.setAlignmentX(1.0F);
        jSeparator2.setAlignmentY(1.0F);
        jSeparator2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSeparator2MouseClicked(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(0, 102, 0));
        lblLogin.setText("ShopTao");

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUser.setText("User :");

        txtUser.setBackground(new java.awt.Color(204, 255, 204));
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtUser.setText("NV01");
        txtUser.setToolTipText("");
        txtUser.setBorder(null);

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblPass))
                        .addGap(46, 46, 46)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPfPass)
                                    .addComponent(jSeparator2))
                                .addGap(29, 29, 29)
                                .addComponent(btnHide, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(137, Short.MAX_VALUE))))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addComponent(lblQuenMatKhau)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignUp)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogin)
                .addGap(152, 152, 152))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin)
                .addGap(96, 96, 96)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPass))
                    .addComponent(btnHide, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuenMatKhau)
                    .addComponent(btnSignUp))
                .addGap(112, 112, 112))
        );

        pnlChung.add(pnlLogin, "card2");

        pnlQuenMatKhau.setBackground(new java.awt.Color(204, 255, 204));

        lblPass1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblPass1.setText("Mật khẩu mới");

        btnGuiMa.setBackground(new java.awt.Color(204, 255, 204));
        btnGuiMa.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnGuiMa.setText("Gửi mã");
        btnGuiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(153, 255, 153));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        lblLogin1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblLogin1.setForeground(new java.awt.Color(0, 102, 0));
        lblLogin1.setText("ShopTao");

        lblUser1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblUser1.setText("Mail");

        lblUser2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblUser2.setText("Mã xác nhận");

        lblPass2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblPass2.setText("Nhập lại");

        txtMail.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtMail.setBorder(null);

        txtMaXacNhan.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtMaXacNhan.setBorder(null);

        txtMatKhauMoi.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtMatKhauMoi.setBorder(null);

        txtXacNhan.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtXacNhan.setBorder(null);

        lblDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(0, 153, 204));
        lblDangNhap.setText("Đăng nhập");
        lblDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangNhapMouseClicked(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 204, 0));
        jSeparator3.setAlignmentX(1.0F);
        jSeparator3.setAlignmentY(1.0F);

        jSeparator4.setForeground(new java.awt.Color(0, 204, 0));
        jSeparator4.setAlignmentX(1.0F);
        jSeparator4.setAlignmentY(1.0F);

        jSeparator5.setForeground(new java.awt.Color(0, 204, 0));
        jSeparator5.setAlignmentX(1.0F);
        jSeparator5.setAlignmentY(1.0F);

        jSeparator6.setForeground(new java.awt.Color(0, 204, 0));
        jSeparator6.setAlignmentX(1.0F);
        jSeparator6.setAlignmentY(1.0F);

        javax.swing.GroupLayout pnlQuenMatKhauLayout = new javax.swing.GroupLayout(pnlQuenMatKhau);
        pnlQuenMatKhau.setLayout(pnlQuenMatKhauLayout);
        pnlQuenMatKhauLayout.setHorizontalGroup(
            pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuenMatKhauLayout.createSequentialGroup()
                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuenMatKhauLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser2)
                            .addComponent(lblPass1)
                            .addComponent(lblPass2)
                            .addComponent(lblUser1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlQuenMatKhauLayout.createSequentialGroup()
                                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaXacNhan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMail)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlQuenMatKhauLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblDangNhap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(btnXacNhan)
                                .addGap(30, 30, 30))))
                    .addGroup(pnlQuenMatKhauLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblLogin1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlQuenMatKhauLayout.setVerticalGroup(
            pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuenMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin1)
                .addGap(50, 50, 50)
                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser1)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser2)
                    .addComponent(txtMaXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass1)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass2)
                    .addComponent(txtXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(pnlQuenMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDangNhap)
                    .addComponent(btnXacNhan))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pnlChung.add(pnlQuenMatKhau, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlChung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        if (!validation()) {
            return;
        }

        if (!LoginHelper.checkLogin(txtUser.getText(),
                new String(txtPfPass.getPassword()))) {
            return;
        }
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new DashBoard().setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        if (txtPfPass.getEchoChar() != '\u0000') {
            txtPfPass.setEchoChar('\u0000');
            btnHide.setIcon(new ImageIcon("src\\main\\resources\\image\\icons8_eye_35px.png"));
        } else {
            txtPfPass.setEchoChar('*');
            btnHide.setIcon(new ImageIcon("src\\main\\resources\\image\\icons8-invisible-35.png"));
        }
    }//GEN-LAST:event_btnHideActionPerformed

    private void jSeparator1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator1MouseClicked
        txtUser.requestFocus();
    }//GEN-LAST:event_jSeparator1MouseClicked

    private void jSeparator2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator2MouseClicked
        txtPfPass.requestFocus();
    }//GEN-LAST:event_jSeparator2MouseClicked

    private void btnGuiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMaActionPerformed
        String email = txtMail.getText();

        if (txtMail.getText().isEmpty()) {
            DialogHelper.alert(null, "Email không được để trống", "Thông báo");
            return;
        }

        if (!Validation.checkEmail(txtMail)) {
            return;
        }

        if (!checkEmail(email)) {
            DialogHelper.alert(null, "Không có nhân viên nào sử dụng email này", "Thông báo");
            return;
        }

        txtMaXacNhan.requestFocus();
        demnguocdehienthi();
        maXacNhan = (int) (Math.random()*(999999-100000))+100000;
        MailHelper.sendMail(email, maXacNhan);
    }//GEN-LAST:event_btnGuiMaActionPerformed

    private boolean checkEmail(String email) {
        for (NhanVienViewModel x : nhanVienService.getList()) {
            if (x.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        String matKhauMoi = txtMatKhauMoi.getText();
        String matKhauXacNhan = txtXacNhan.getText();

        if (txtMaXacNhan.getText().isEmpty()) {
            DialogHelper.alert(null, "Nhập mã xác nhận", "Thông báo");
            return;
        }

        int maNhap = Integer.valueOf(txtMaXacNhan.getText());

        if (maNhap != maXacNhan) {
            DialogHelper.alert(null, "Mã xác nhận không chính xác", "Thông báo");
            return;
        }

        if (matKhauMoi.isEmpty() && matKhauXacNhan.isEmpty()) {
            DialogHelper.alert(null, "Không để trống mật khẩu", "Thông báo");
            return;
        }

        if (!matKhauMoi.equals(matKhauXacNhan)) {
            DialogHelper.alert(null, "Các mật khẩu đã nhập không khớp", "Thông báo");
            return;
        }
        NhanVienViewModel nhanVien = getNhanVienbyMail(txtMail.getText());
        nhanVien.setMatkhau(matKhauMoi);
        String mess = nhanVienService.update(nhanVien);
        DialogHelper.alert(null, mess, "Thông báo");
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void lblDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangNhapMouseClicked
        card.show(pnlChung, "login");
    }//GEN-LAST:event_lblDangNhapMouseClicked

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        card.show(pnlChung, "quenmatkhau");
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private NhanVienViewModel getNhanVienbyMail(String email) {
        for (NhanVienViewModel x : nhanVienService.getList()) {
            if (x.getEmail().equals(email)) {
                return x;
            }
        }
        return null;
    }

    public void demnguocdehienthi() {
        new Thread() {
            int se = 59;

            @Override
            public void run() {
                while (true) {
                    btnGuiMa.setText(se + "");
                    btnGuiMa.setEnabled(false);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    if (se <= 0) {
                        btnGuiMa.setText("Gửi mã");
                        btnGuiMa.setEnabled(true);
                        return;
                    }
                    se--;
                }
            }
        }.start();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiMa;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLogin1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPass1;
    private javax.swing.JLabel lblPass2;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JLabel lblUser2;
    private javax.swing.JPanel pnlChung;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlQuenMatKhau;
    private javax.swing.JTextField txtMaXacNhan;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtMatKhauMoi;
    private javax.swing.JPasswordField txtPfPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtXacNhan;
    // End of variables declaration//GEN-END:variables
}
