/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.services.impl.HoaDonService;
import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.Validation;
import com.shoptao.viewmodel.HoaDonViewModel;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
public class KhuyenMaiChiTietDialog extends javax.swing.JDialog {

    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();

    private HoaDonService hoaDonService = new HoaDonService();
    public KhuyenMaiService khuyenMaiService = new KhuyenMaiService();

    List<KhuyenMaiViewModle> listKM = new ArrayList<>();
    int indexkm;
    String maKM;
    public KhuyenMaiMainPanel kmm;

    public KhuyenMaiChiTietDialog(java.awt.Frame parent, boolean modal, int indexkm, KhuyenMaiMainPanel kmm) {
        super(parent, modal);
        this.indexkm = indexkm;
        this.kmm = kmm;

        initComponents();
        setLocationRelativeTo(null);

        listKM = khuyenMaiService.getList();
        maKM = listKM.get(indexkm).getMa();
        showDetail(listKM.get(indexkm));
        loadDataLichSuKM();
    }

    @SuppressWarnings("unchecked")

    public void loadDataLichSuKM() {

        defaultTableModel = (DefaultTableModel) tb_lichSuKm.getModel();
        defaultTableModel.setRowCount(0);
        
        KhuyenMaiViewModle khuyenMaiViewModle = listKM.get(indexkm);
        for (HoaDonViewModel x : hoaDonService.getListHoaDonTheoMaKM(maKM)) {
            BigDecimal giaTriKM = x.getTongTien().multiply(BigDecimal.valueOf(khuyenMaiViewModle.getGiatri()));
            defaultTableModel.addRow(new Object[]{
                x.getMa(),
                dateFormat.format(x.getNgaythanhtoan()),
                x.getTenNhanVien(),
                x.getTenKhachHang(),
                decimalFormat.format(x.getTongTien()),
                decimalFormat.format(x.getTongTien().subtract(giaTriKM))

            });
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jdc_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdc_ngayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_setMa = new javax.swing.JLabel();
        lbl_setTrangThai = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cb_hinhThucGiamGia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_giaTri = new javax.swing.JTextField();
        lbl_donVi = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_lichSuKm = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin chi tiết");
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jdc_ngayKetThuc.setDateFormatString("dd-MM-yyyy");
        jdc_ngayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Ngày kết thúc");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Ngày bắt đầu");

        jdc_ngayBatDau.setDateFormatString("dd-MM-yyyy");
        jdc_ngayBatDau.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Trạng thái");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Tên chương trình");

        txt_ten.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mã");

        lbl_setMa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_setMa.setText("Mã");

        lbl_setTrangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_setTrangThai.setText("Trạng thái");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jdc_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(168, 168, 168)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_setTrangThai))
                            .addComponent(jdc_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(242, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_setMa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbl_setMa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(lbl_setTrangThai))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdc_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdc_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        cb_hinhThucGiamGia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_hinhThucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá theo số tiền", "Giảm giá theo %" }));
        cb_hinhThucGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_hinhThucGiamGiaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Hình thức giảm giá");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cb_hinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(284, 284, 284)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_giaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_donVi)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_giaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_donVi)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(cb_hinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 298, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hình thức", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        tb_lichSuKm.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tb_lichSuKm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Thời gian", "Người bán", "Khách hàng", "Tổng cộng", "Giá trị khuyến mại"
            }
        ));
        tb_lichSuKm.setAlignmentX(3.0F);
        tb_lichSuKm.setAlignmentY(3.0F);
        tb_lichSuKm.setMinimumSize(new java.awt.Dimension(210, 100));
        tb_lichSuKm.setRowHeight(25);
        tb_lichSuKm.setRowMargin(2);
        tb_lichSuKm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_lichSuKmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_lichSuKm);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử", jPanel4);

        btn_xoa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-document-60.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_60px.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa)
                    .addComponent(btn_sua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showDetail(KhuyenMaiViewModle khuyenMaiViewModle) {
        lbl_setMa.setText(khuyenMaiViewModle.getMa());
        txt_ten.setText(khuyenMaiViewModle.getTen());
        String trangThai;
        if (khuyenMaiViewModle.getTrangthai() == 0) {
            trangThai = "Chưa kích hoạt";
        } else {
            trangThai = "Đã kích hoạt";
        }
        lbl_setTrangThai.setText(trangThai);
        int hinhThucGG;
        if (khuyenMaiViewModle.getHinhthucgiamgia() == 0) {
            hinhThucGG = 0;
        } else {
            hinhThucGG = 1;
        }
        cb_hinhThucGiamGia.setSelectedIndex(hinhThucGG);
        String giaTri = decimalFormat.format(khuyenMaiViewModle.getGiatri());
        txt_giaTri.setText(giaTri);
        jdc_ngayBatDau.setDate(khuyenMaiViewModle.getNgaybatdau());
        jdc_ngayKetThuc.setDate(khuyenMaiViewModle.getNgayketthuc());
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
        if (lbl_setTrangThai.getText().equals("Chưa kích hoạt")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }
        km.setTrangthai(trangThai);
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
        SimpleDateFormat spl = new SimpleDateFormat("dd-MM-yyyy");
        String date = spl.format(jdc_ngayBatDau.getDate());
        String date2 = spl.format(jdc_ngayKetThuc.getDate());

        if (date2.compareTo(date) < 0) {
            DialogHelper.alert(null, "Ngày kết thúc phải sau ngày bắt đầu", "Lỗi!");
            return;
        }
        JOptionPane.showMessageDialog(this, khuyenMaiService.update(getModelKM()));
        List<KhuyenMaiViewModle> listv = khuyenMaiService.getList();
        List<KhuyenMaiViewModle> list = khuyenMaiService.getList();
        this.kmm.loadDataKM(list);
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_lichSuKmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_lichSuKmMouseClicked
    }//GEN-LAST:event_tb_lichSuKmMouseClicked

    private void cb_hinhThucGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_hinhThucGiamGiaMouseClicked
        // TODO add your handling code hlbere:

    }//GEN-LAST:event_cb_hinhThucGiamGiaMouseClicked

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdc_ngayBatDau;
    private com.toedter.calendar.JDateChooser jdc_ngayKetThuc;
    private javax.swing.JLabel lbl_donVi;
    private javax.swing.JLabel lbl_setMa;
    private javax.swing.JLabel lbl_setTrangThai;
    private javax.swing.JTable tb_lichSuKm;
    private javax.swing.JTextField txt_giaTri;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
