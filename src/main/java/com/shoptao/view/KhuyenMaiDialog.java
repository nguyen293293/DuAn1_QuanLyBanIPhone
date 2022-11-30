/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haih7
 */
public class KhuyenMaiDialog extends javax.swing.JDialog {

    /**
     * Creates new form KhuyenMaiDialog
     */
    public KhuyenMaiService khuyenMaiService = new KhuyenMaiService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();

    List<KhuyenMaiViewModle> listKM = new ArrayList<>();
    SanPhamKhuyenMaiPanel spkm;

    public KhuyenMaiDialog(java.awt.Frame parent, boolean modal, SanPhamKhuyenMaiPanel spkm) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.spkm = spkm;
        listKM = khuyenMaiService.getList();
        loadDataKM(listKM);
    }

    public void loadDataKM(List<KhuyenMaiViewModle> listKM) {
        defaultTableModel = (DefaultTableModel) tb_khuyenmai.getModel();
        defaultTableModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        int i = 1;
        for (KhuyenMaiViewModle khuyenMaiViewModle : listKM) {
            defaultTableModel.addRow(new Object[]{
                i++,
                khuyenMaiViewModle.getMa(),
                khuyenMaiViewModle.getTen(),
                khuyenMaiViewModle.getHinhthucgiamgia() == 0 ? "Giảm giá theo số tiền" : "Giảm giá theo %",
                khuyenMaiViewModle.getHinhthucgiamgia() == 0 ? khuyenMaiViewModle.getGiatri() : ((-100 * khuyenMaiViewModle.getGiatri()) + 100) + "%",
                simpleDateFormat.format(khuyenMaiViewModle.getNgaybatdau()),
                simpleDateFormat.format(khuyenMaiViewModle.getNgayketthuc()),
                khuyenMaiViewModle.getTrangthai() == 2 ? "Đã hết hạn" : khuyenMaiViewModle.getTrangthai() == 1 ? "Đang được áp dụng" : "Chưa được áp dụng"

            });
        }
    }

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

    public int trangthaikm() {
        Date ngaybatdau = jdc_ngayBatDau.getDate();
        Date ngayketthuc = jdc_ngayKetThuc.getDate();
        Date ngayhientai = new Date();
//        ngaybatdau.before(ngayhientai) && ngayketthuc.after(ngayhientai)
        if (ngaybatdau.after(ngayhientai) && ngayketthuc.after(ngayhientai)) {
            return 0;
        } else if (ngaybatdau.before(ngayhientai) && ngayketthuc.after(ngayhientai)) {
            return 1;
        } else {
            return 2;
        }
    }

    public KhuyenMaiViewModle getModelKM() {
        Float giatri = kmtheogiatri();
        Float dieukiengiamgia = Float.parseFloat(txt_dieuKienGiamGia.getText());

        KhuyenMaiViewModle km = new KhuyenMaiViewModle();
        km.setMa(txt_ma.getText());
        km.setTen(txt_ten.getText());
        km.setGiatri(giatri);
        km.setDieukiengiamgia(dieukiengiamgia);
        km.setHinhthucgiamgia(cb_hinhThucGiamGia.getSelectedIndex());
        km.setNgaybatdau(jdc_ngayBatDau.getDate());
        km.setNgayketthuc(jdc_ngayKetThuc.getDate());
        km.setTrangthai(trangthaikm());

        return km;
    }

    public void showDetail() {
        int index = tb_khuyenmai.getSelectedRow();

        KhuyenMaiViewModle kmvm = khuyenMaiService.getList().get(index);
        txt_ma.setText(kmvm.getMa());
        txt_ten.setText(kmvm.getTen());
        txt_giaTri.setText(String.valueOf(kmvm.getGiatri()));
        txt_dieuKienGiamGia.setText(String.valueOf(kmvm.getDieukiengiamgia()));
        cb_hinhThucGiamGia.setSelectedIndex(kmvm.getHinhthucgiamgia());
        jdc_ngayBatDau.setDate(kmvm.getNgaybatdau());
        jdc_ngayKetThuc.setDate(kmvm.getNgayketthuc());
    }

    public void refresh() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_giaTri.setText("");
        txt_dieuKienGiamGia.setText("");
        cb_hinhThucGiamGia.setSelectedIndex(0);
        Date date = new Date();
        jdc_ngayBatDau.setDate(date);
        jdc_ngayKetThuc.setDate(date);
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
        jLabel3 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_giaTri = new javax.swing.JTextField();
        cb_hinhThucGiamGia = new javax.swing.JComboBox<>();
        txt_ten = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jdc_ngayBatDau = new com.toedter.calendar.JDateChooser();
        jdc_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_dieuKienGiamGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_khuyenmai = new javax.swing.JTable();
        txt_serachKhuyenMai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên");

        txt_ma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_giaTri.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        cb_hinhThucGiamGia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_hinhThucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá theo số tiền", "Giảm giá theo %" }));

        txt_ten.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Mã");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Ngày kết thúc");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Ngày bắt đầu");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Giá trị");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Hình thức giảm giá");

        jdc_ngayBatDau.setDateFormatString("dd-MM-yyyy");
        jdc_ngayBatDau.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jdc_ngayKetThuc.setDateFormatString("dd-MM-yyyy");
        jdc_ngayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Refresh_Love_60px_1.png"))); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_save_60px.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_60px.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_dieuKienGiamGia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_dieuKienGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dieuKienGiamGiaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Điều kiện giảm giá");

        tb_khuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khuyến mại", "Tên khuyến mãi", "Hình thức ", "Giá trị", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tb_khuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khuyenmaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_khuyenmai);

        txt_serachKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_serachKhuyenMai.setBorder(null);
        txt_serachKhuyenMai.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_serachKhuyenMaiCaretUpdate(evt);
            }
        });
        txt_serachKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serachKhuyenMaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jdc_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jdc_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cb_hinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_giaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dieuKienGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_serachKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(423, 423, 423))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_dieuKienGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_hinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdc_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txt_serachKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(377, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, khuyenMaiService.add(getModelKM()));
        refresh();
        List<KhuyenMaiViewModle> listv = khuyenMaiService.getList();
        loadDataKM(listv);
        refresh();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JOptionPane.showMessageDialog(this, khuyenMaiService.update(getModelKM()));
        refresh();
        List<KhuyenMaiViewModle> listv = khuyenMaiService.getList();
        loadDataKM(listv);

        refresh();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_dieuKienGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dieuKienGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dieuKienGiamGiaActionPerformed

    private void tb_khuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khuyenmaiMouseClicked
        // TODO add your handling code here:
        showDetail();

    }//GEN-LAST:event_tb_khuyenmaiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        refresh();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_serachKhuyenMaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_serachKhuyenMaiCaretUpdate

        String maKM = txt_serachKhuyenMai.getText();
        List<KhuyenMaiViewModle> list = new ArrayList<>();
        if (maKM.isEmpty()) {
            list = khuyenMaiService.getList();
        } else {
            list = khuyenMaiService.search(maKM);
        }
        loadDataKM(list);
    }//GEN-LAST:event_txt_serachKhuyenMaiCaretUpdate

    private void txt_serachKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serachKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serachKhuyenMaiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_hinhThucGiamGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdc_ngayBatDau;
    private com.toedter.calendar.JDateChooser jdc_ngayKetThuc;
    private javax.swing.JTable tb_khuyenmai;
    private javax.swing.JTextField txt_dieuKienGiamGia;
    private javax.swing.JTextField txt_giaTri;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_serachKhuyenMai;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
