package com.shoptao.view;

import com.shoptao.domainmodel.NhanVien;
import com.shoptao.services.ChungServices;
import com.shoptao.services.impl.NhanVienService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.UserHelper;
import com.shoptao.utilities.Validation;
import com.shoptao.viewmodel.NhanVienViewModel;

/**
 *
 * @author nguyen293
 */
public class BanThanDialog extends javax.swing.JDialog {

    ChungServices<NhanVienViewModel> nhanVienService;
    NhanVienViewModel nhanVien;
    
    public BanThanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        
        nhanVienService = new NhanVienService();
        
        nhanVien = nhanVienService.getOne(UserHelper.USER.getMa());
        
        showDetail(nhanVien);
        
        btnHuy.setEnabled(false);
        btnXacNhan.setEnabled(false);
        
        setEditabletxt(false);
    }
    
    private void setEditabletxt(boolean boo){
        txtDiaChi.setEditable(boo);
        txtEmail.setEditable(boo);
        txtHoTen.setEditable(boo);
        txtSoDienThoai.setEditable(boo);
        jdcNgaySinh.setEnabled(boo);
        rdNam.setEnabled(boo);
        rdNu.setEnabled(boo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        btnSuaThongTin = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Thông tin nhân viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Họ tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Số điện thoại");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Địa chỉ");

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdNu.setText("Nữ");

        jdcNgaySinh.setDateFormatString("dd - MM - yyyy");
        jdcNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnSuaThongTin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaThongTin)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoDienThoai)
                            .addComponent(txtEmail)
                            .addComponent(txtDiaChi)
                            .addComponent(txtHoTen)
                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdNu)
                                .addGap(71, 71, 71))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThongTin)
                    .addComponent(btnHuy)
                    .addComponent(btnXacNhan))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        setEditabletxt(true);
        btnHuy.setEnabled(true);
        btnXacNhan.setEnabled(true);
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        nhanVien = nhanVienService.getOne(UserHelper.USER.getMa());
        
        showDetail(nhanVien);
        
        setEditabletxt(false);
        btnHuy.setEnabled(false);
        btnXacNhan.setEnabled(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if(!validation()) return;
        
        String message = nhanVienService.update(nhanVien);
        DialogHelper.alert(null, message, "Thông báo");
        nhanVien = nhanVienService.getOne(UserHelper.USER.getMa());
        showDetail(nhanVien);
        setEditabletxt(false);
        btnHuy.setEnabled(false);
        btnXacNhan.setEnabled(false);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables

    private void showDetail(NhanVienViewModel nv) {
        txtMa.setText(nv.getMa());
        txtHoTen.setText(nv.getHoten());
        txtDiaChi.setText(nv.getDiachi());
        txtEmail.setText(nv.getEmail());
        txtSoDienThoai.setText(nv.getSdt());
        jdcNgaySinh.setDate(nv.getNgaysinh());
        rdNam.setSelected(nv.getGioitinh().equals("Nam"));
        rdNu.setSelected(!nv.getGioitinh().equals("Nam"));
    }
    
    private NhanVienViewModel getModel(){
        NhanVienViewModel nv = new NhanVienViewModel();
        nv.setMa(txtMa.getText());
        nv.setHoten(txtHoTen.getText());
        nv.setEmail(txtEmail.getText());
        nv.setSdt(txtSoDienThoai.getText());
        nv.setDiachi(txtDiaChi.getText());
        nv.setNgaysinh(jdcNgaySinh.getDate());
        nv.setGioitinh(rdNam.isSelected() ? "Nam" : "Nữ");
        nv.setTrangthai(0);
        
        return nv;
    }
    
    private boolean validation(){
        if(!Validation.CheckTrongText(txtHoTen, txtDiaChi, txtSoDienThoai, txtEmail)){
            return false;
        }
        
        if(!Validation.CheckTrongJDate(jdcNgaySinh)){
            return false;
        }
        
        if(!Validation.checkSoDT(txtSoDienThoai)){
            return false;
        }
        
        if(!Validation.checkEmail(txtEmail)){
            return false;
        }
        
        return true;
    }
}
