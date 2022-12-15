/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.services.impl.HoaDonService;
import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.Validation;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haih7
 */
public class KhuyenMaiAddDialog extends javax.swing.JDialog {

    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();

    private HoaDonService hoaDonService = new HoaDonService();
    public KhuyenMaiService khuyenMaiService = new KhuyenMaiService();

    String maKM;
    public KhuyenMaiMainPanel kmm;

    public KhuyenMaiAddDialog(java.awt.Frame parent, boolean modal,KhuyenMaiMainPanel kmmp ) {
        super(parent, modal);
        this.kmm = kmm;
        initComponents();
        
           setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_setMa = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdc_ngayBatDau = new com.toedter.calendar.JDateChooser();
        jdc_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        txt_ten = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cb_hinhThucGiamGia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_giaTri = new javax.swing.JTextField();
        lbl_donVi = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm khuyến mại");

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mã");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Tên chương trình");

        lbl_setMa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_setMa.setText("mã tự sinh");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Ngày bắt đầu");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Ngày kết thúc");

        jdc_ngayBatDau.setDateFormatString("dd-MM-yyyy");
        jdc_ngayBatDau.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jdc_ngayKetThuc.setDateFormatString("dd-MM-yyyy");
        jdc_ngayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_ten.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jdc_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(lbl_setMa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_setMa))
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdc_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdc_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Hình thức giảm giá");

        cb_hinhThucGiamGia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_hinhThucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá theo số tiền", "Giảm giá theo %" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Giá trị");

        txt_giaTri.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_giaTri.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_giaTriCaretUpdate(evt);
            }
        });

        lbl_donVi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_donVi.setText("Đơn vị");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cb_hinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(284, 284, 284)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_giaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_donVi)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_hinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_donVi))
                .addContainerGap(292, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hình thức", jPanel3);

        btn_sua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_save_60px.png"))); // NOI18N
        btn_sua.setText("Thêm");
        btn_sua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sua.setMaximumSize(new java.awt.Dimension(185, 66));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-remove-60.png"))); // NOI18N
        btn_xoa.setText("Thoát");
        btn_xoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_xoa.setMaximumSize(new java.awt.Dimension(185, 66));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 705, Short.MAX_VALUE)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public float kmtheogiatri() {
        int hinhThucGiamGia = cb_hinhThucGiamGia.getSelectedIndex();
        float giatri;
        if (hinhThucGiamGia == 0) {
            giatri = Float.parseFloat(txt_giaTri.getText());
        } else {
            Float phantram = (100 - Float.parseFloat(txt_giaTri.getText())) / 100;
            giatri = phantram;
        }
        return giatri;
    }

    public int hieuLucKM() {
        Date ngaybatdau = jdc_ngayBatDau.getDate();
        Date ngayketthuc = jdc_ngayKetThuc.getDate();
        Date ngayhientai = new Date();
        if (ngaybatdau.before(ngayhientai) && ngayketthuc.after(ngayhientai)) {
            return 0;//dang ap dung
        } else {
            return 1;//da het han 
        }
    }

    public KhuyenMaiViewModle getModelKM() {
        Float giatri = kmtheogiatri();
        KhuyenMaiViewModle km = new KhuyenMaiViewModle();
        km.setMa(lbl_setMa.getText());
        km.setTen(txt_ten.getText());
        km.setGiatri(giatri);
        km.setDieukiengiamgia(0);
        km.setHinhthucgiamgia(cb_hinhThucGiamGia.getSelectedIndex());
        km.setNgaybatdau(jdc_ngayBatDau.getDate());
        km.setNgayketthuc(jdc_ngayKetThuc.getDate());
        int trangThai;
        km.setTrangthai(0);
        km.setHieuluc(hieuLucKM());
        return km;
    }
    
    private boolean validation() {
        if (!Validation.CheckTrongText(txt_ten, txt_giaTri)) {
            return false;
        }
        return true;
    }
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

    if (!validation()) {
            return;
        }
        if (Validation.checkTrungTenKM(txt_ten.getText())) {
            return;
        }
        SimpleDateFormat spl = new SimpleDateFormat("dd-MM-yyyy");
        String date = spl.format(jdc_ngayBatDau.getDate());
        String date2 = spl.format(jdc_ngayKetThuc.getDate());

        if (date2.compareTo(date) < 0) {
            DialogHelper.alert(null, "Ngày kết thúc phải sau ngày bắt đầu", "Lỗi!");
            return;
        }
        JOptionPane.showMessageDialog(this, khuyenMaiService.add(getModelKM()));
        List<KhuyenMaiViewModle> listv = khuyenMaiService.getList();
        this.kmm.loadDataKM(listv);
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_giaTriCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_giaTriCaretUpdate
        int select = cb_hinhThucGiamGia.getSelectedIndex();
        lbl_donVi.setVisible(true);
        if (select == 1) {
            lbl_donVi.setText("%");

        } else {
            lbl_donVi.setText("VND");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaTriCaretUpdate

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cb_hinhThucGiamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdc_ngayBatDau;
    private com.toedter.calendar.JDateChooser jdc_ngayKetThuc;
    private javax.swing.JLabel lbl_donVi;
    private javax.swing.JLabel lbl_setMa;
    private javax.swing.JTextField txt_giaTri;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
