package com.shoptao.view;

import com.github.sarxos.webcam.Webcam;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.HibernateUtil;
import com.shoptao.utilities.UserHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author nguyen293
 */
public class DashBoard extends javax.swing.JFrame {

    public DashBoard() {
        this.setUndecorated(true);
        initComponents();
        init();
        lblTenNhanVien.setText(UserHelper.USER.getHoten());
        lblTitle.setText("Bán hàng");
        jPanel2.removeAll();
        jPanel2.add(new BanHangPanel());
        jPanel2.validate();
        if (UserHelper.USER.getVaitro().equals("Nhân viên")) {
            jPanel3.remove(4);
        }
    }

    private void init() {
//        this.setLocation(0, 0);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Gets the width and height
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        // Subtract height of taskbar from height in my case 50 
        this.setSize((int) width, (int) height - 50);
        this.setLocationRelativeTo(null);  // Set frame at center of the screen

        btnClose.setOpaque(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setBorderPainted(false);

        HibernateUtil.getSessionFactory();

        addMouseHover();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        btnBanThan = new javax.swing.JButton();
        btnDangXUat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnlRoot = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenu.setBackground(new java.awt.Color(0, 153, 51));

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));
        jPanel3.setMinimumSize(new java.awt.Dimension(276, 521));
        jPanel3.setLayout(new java.awt.GridLayout(7, 1, 5, 5));

        btnBanHang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_online_store_64px.png"))); // NOI18N
        btnBanHang.setText("Bán hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });
        jPanel3.add(btnBanHang);

        btnHoaDon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cheque_64px.png"))); // NOI18N
        btnHoaDon.setText("Hóa đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        jPanel3.add(btnHoaDon);

        btnSanPham.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_smartphones_64px.png"))); // NOI18N
        btnSanPham.setText("Sản phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });
        jPanel3.add(btnSanPham);

        btnKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_season_sale_64px.png"))); // NOI18N
        btnKhuyenMai.setText("Khuyến mãi");
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });
        jPanel3.add(btnKhuyenMai);

        btnNhanVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_badge_64px.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        jPanel3.add(btnNhanVien);

        btnKhachHang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_budget_64px.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        jPanel3.add(btnKhachHang);

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_combo_chart_64px.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel3.add(btnThongKe);

        lblTenNhanVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTenNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnBanThan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBanThan.setText("Bản thân");
        btnBanThan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanThanActionPerformed(evt);
            }
        });

        btnDangXUat.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDangXUat.setText("Đăng xuất");
        btnDangXUat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXUatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnBanThan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDangXUat)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangXUat)
                    .addComponent(btnBanThan))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ShopTao");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        getContentPane().add(pnlMenu, java.awt.BorderLayout.LINE_START);

        pnlRoot.setLayout(new java.awt.BorderLayout());

        pnlTop.setBackground(new java.awt.Color(0, 153, 51));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Trang chủ");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_close_window_48px_1.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addGap(633, 633, 633)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 747, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlRoot.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());
        pnlRoot.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlRoot, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        Webcam.getWebcams().get(0).close();
        this.dispose();
        UserHelper.logout();
        new LoginForm().setVisible(true);
//        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        lblTitle.setText("Bán hàng");
        jPanel2.removeAll();
        jPanel2.add(new BanHangPanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        lblTitle.setText("Hoá đơn");
        jPanel2.removeAll();
        jPanel2.add(new HoaDonPanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        lblTitle.setText("Sản phẩm");
        jPanel2.removeAll();
        jPanel2.add(new SanPhamPanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        lblTitle.setText("Khuyến mãi");
        jPanel2.removeAll();
        jPanel2.add(new KhuyenMaiMainPanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        if (!UserHelper.USER.getVaitro().equals("Quản lý")) {
            DialogHelper.alert(this, "Vui lòng sử dụng tài khoản quản lý", "Lỗi");
            return;
        }
        lblTitle.setText("Nhân viên");
        jPanel2.removeAll();
        jPanel2.add(new NhanVienPanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        lblTitle.setText("Khách hàng");
        jPanel2.removeAll();
        jPanel2.add(new KhachHangPanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if (UserHelper.isLogin() == false) {
            DialogHelper.alert(this, "Vui lòng đăng nhập", "Lỗi");
            jPanel2.removeAll();
            return;
        }
        lblTitle.setText("Thống kê");
        jPanel2.removeAll();
        jPanel2.add(new ThongKePanel());
        jPanel2.validate();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDangXUatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXUatActionPerformed
        if (!DialogHelper.confirm(null, "Bạn có muốn đăng xuất không ?", "Đăng xuất")) {
            return;
        }
        this.dispose();
        UserHelper.logout();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_btnDangXUatActionPerformed

    private void btnBanThanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanThanActionPerformed
        new BanThanDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnBanThanActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnBanThan;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDangXUat;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables

    private void addMouseHover() {
        JButton btns[] = {btnBanHang, btnHoaDon, btnSanPham,
            btnKhuyenMai, btnNhanVien, btnKhachHang, btnThongKe};
        for (JButton btn : btns) {
            btn.setUI(new BasicButtonUI());
            btn.setBackground(Color.WHITE);

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(Color.WHITE);
                }
            });

        }
    }
}
