/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haih7
 */
public class KhuyenMaiMainPanel extends javax.swing.JPanel {

    public KhuyenMaiService khuyenMaiService = new KhuyenMaiService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();

    private ButtonGroup buttonGroupTrangThai = new ButtonGroup();
    private ButtonGroup buttonGroupHieuLuc = new ButtonGroup();

    List<KhuyenMaiViewModle> listKM = new ArrayList<>();

    public KhuyenMaiMainPanel() {
        initComponents();

        selectRDTrangThai();
        selectRDHieLuc();

        listKM = khuyenMaiService.getList();
        loadDataKM(listKM);
    }

    public void changeHieuLucKMTheoTime() {
        for (KhuyenMaiViewModle khuyenMaiViewModle : listKM) {

            Date ngaybatdau = khuyenMaiViewModle.getNgaybatdau();
            Date ngayketthuc = khuyenMaiViewModle.getNgayketthuc();
            Date ngayhientai = new Date();

            if (ngaybatdau.before(ngayhientai) && ngayketthuc.after(ngayhientai)) {
                khuyenMaiViewModle.setHieuluc(1);
                khuyenMaiService.update(khuyenMaiViewModle);//dang ap dung
            } else {
                khuyenMaiViewModle.setHieuluc(0);
                khuyenMaiService.update(khuyenMaiViewModle);//da het han 
            }

        }
    }

    public void selectRDTrangThai() {
        buttonGroupTrangThai.add(rd_tatCaTheoTrangThai);
        buttonGroupTrangThai.add(rd_chuaApDung);
        buttonGroupTrangThai.add(rd_kichHoat);
    }

    public void selectRDHieLuc() {
        buttonGroupTrangThai.add(rd_tatCaTheoTrangThai);
        buttonGroupHieuLuc.add(rd_ConHieuLuc);
        buttonGroupHieuLuc.add(rd_hetHieuLuc);
    }

    public void loadDataKM(List<KhuyenMaiViewModle> listKM) {
        defaultTableModel = (DefaultTableModel) tb_khuyenMaiMain.getModel();
        defaultTableModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat df = new DecimalFormat("#.0");
        for (KhuyenMaiViewModle khuyenMaiViewModle : listKM) {
            int giatri = (int) khuyenMaiViewModle.getGiatri();
            String giaTriPhanTram = df.format(((-100 * khuyenMaiViewModle.getGiatri()) + 100));
            defaultTableModel.addRow(new Object[]{
                khuyenMaiViewModle.getTen(),
                simpleDateFormat.format(khuyenMaiViewModle.getNgaybatdau()),
                simpleDateFormat.format(khuyenMaiViewModle.getNgayketthuc()),
                khuyenMaiViewModle.getHinhthucgiamgia() == 0 ? "Giảm giá theo số tiền" : "Giảm giá theo phần trăm",
                khuyenMaiViewModle.getTrangthai() == 1 ? "Kích hoạt" : "Chưa được áp dụng"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rd_tatCaTheoTrangThai = new javax.swing.JRadioButton();
        rd_kichHoat = new javax.swing.JRadioButton();
        rd_chuaApDung = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rd_ConHieuLuc = new javax.swing.JRadioButton();
        rd_hetHieuLuc = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        txt_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_khuyenMaiMain = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        rd_tatCaTheoTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        rd_tatCaTheoTrangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rd_tatCaTheoTrangThai.setSelected(true);
        rd_tatCaTheoTrangThai.setText("Tất cả");
        rd_tatCaTheoTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_tatCaTheoTrangThaiActionPerformed(evt);
            }
        });

        rd_kichHoat.setBackground(new java.awt.Color(255, 255, 255));
        rd_kichHoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rd_kichHoat.setText("Kích hoạt");
        rd_kichHoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_kichHoatActionPerformed(evt);
            }
        });

        rd_chuaApDung.setBackground(new java.awt.Color(255, 255, 255));
        rd_chuaApDung.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rd_chuaApDung.setText("Chưa áp dụng");
        rd_chuaApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_chuaApDungActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Trạng thái");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hiệu lực");

        rd_ConHieuLuc.setBackground(new java.awt.Color(255, 255, 255));
        rd_ConHieuLuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rd_ConHieuLuc.setText("Còn hiệu lực");
        rd_ConHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ConHieuLucActionPerformed(evt);
            }
        });

        rd_hetHieuLuc.setBackground(new java.awt.Color(255, 255, 255));
        rd_hetHieuLuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rd_hetHieuLuc.setText("Hết hiệu lực");
        rd_hetHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_hetHieuLucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_kichHoat)
                            .addComponent(rd_chuaApDung)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rd_tatCaTheoTrangThai))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_ConHieuLuc)
                            .addComponent(jLabel1)
                            .addComponent(rd_hetHieuLuc)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(rd_tatCaTheoTrangThai)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(rd_kichHoat)
                .addGap(30, 30, 30)
                .addComponent(rd_chuaApDung)
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(rd_ConHieuLuc)
                .addGap(30, 30, 30)
                .addComponent(rd_hetHieuLuc)
                .addGap(40, 40, 40))
        );

        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-new-60.png"))); // NOI18N
        jButton1.setText("Khuyến mại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tb_khuyenMaiMain.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tb_khuyenMaiMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên chương trình", "Từ ngày", "Đến ngày", "Hình thức", "Trạng thái"
            }
        ));
        tb_khuyenMaiMain.setAlignmentX(3.0F);
        tb_khuyenMaiMain.setAlignmentY(3.0F);
        tb_khuyenMaiMain.setMinimumSize(new java.awt.Dimension(210, 100));
        tb_khuyenMaiMain.setRowHeight(30);
        tb_khuyenMaiMain.setRowMargin(2);
        tb_khuyenMaiMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khuyenMaiMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khuyenMaiMain);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(358, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        KhuyenMaiAddDialog khuyenMaiDialog = new KhuyenMaiAddDialog(null, true, this);
        khuyenMaiDialog.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_khuyenMaiMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khuyenMaiMainMouseClicked
        // TODO add your handling code here:
        int selectKhuyenMai = tb_khuyenMaiMain.getSelectedRow();
        KhuyenMaiChiTietDialog chiTietDialog = new KhuyenMaiChiTietDialog(null, true, selectKhuyenMai, this);
        chiTietDialog.setVisible(true);
    }//GEN-LAST:event_tb_khuyenMaiMainMouseClicked

    private void rd_tatCaTheoTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_tatCaTheoTrangThaiActionPerformed
        // TODO add your handling code here:

        loadDataKM(listKM);
    }//GEN-LAST:event_rd_tatCaTheoTrangThaiActionPerformed

    private void rd_kichHoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_kichHoatActionPerformed
        List<KhuyenMaiViewModle> listKichHoat = khuyenMaiService.fillterTrangThai(1);
        List<KhuyenMaiViewModle> listFillter = new ArrayList<>();
        List<String> listMaKichHoat = new ArrayList<>();
        List<String> listMaHieuLuc = new ArrayList<>();
        List<String> listMaFillter = new ArrayList<>();
        if (rd_ConHieuLuc.isSelected()) {
            List<KhuyenMaiViewModle> listHetHieuLuc = khuyenMaiService.fillterHieuLuc(1);

            for (KhuyenMaiViewModle khuyenMaiViewModle : listHetHieuLuc) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listKichHoat) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else if (rd_hetHieuLuc.isSelected()) {
            List<KhuyenMaiViewModle> listHetHieuLuc = khuyenMaiService.fillterHieuLuc(0);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHetHieuLuc) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listKichHoat) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else {
            listFillter = listKichHoat;
        }
        loadDataKM(listFillter);
    }//GEN-LAST:event_rd_kichHoatActionPerformed

    private void rd_chuaApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_chuaApDungActionPerformed
        List<KhuyenMaiViewModle> listChuaApDung = khuyenMaiService.fillterTrangThai(0);
        List<KhuyenMaiViewModle> listFillter = new ArrayList<>();
        List<String> listMaKichHoat = new ArrayList<>();
        List<String> listMaHieuLuc = new ArrayList<>();
        List<String> listMaFillter = new ArrayList<>();
        if (rd_ConHieuLuc.isSelected()) {
            List<KhuyenMaiViewModle> listHetHieuLuc = khuyenMaiService.fillterHieuLuc(1);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHetHieuLuc) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listChuaApDung) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else if (rd_hetHieuLuc.isSelected()) {
            List<KhuyenMaiViewModle> listHetHieuLuc = khuyenMaiService.fillterHieuLuc(0);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHetHieuLuc) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listChuaApDung) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else {
            listFillter = listChuaApDung;
        }
        loadDataKM(listFillter);
    }//GEN-LAST:event_rd_chuaApDungActionPerformed

    private void rd_ConHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ConHieuLucActionPerformed

        List<KhuyenMaiViewModle> listFillter = new ArrayList<>();
        List<KhuyenMaiViewModle> listHieuLuc = khuyenMaiService.fillterHieuLuc(1);
        List<String> listMaKichHoat = new ArrayList<>();
        List<String> listMaHieuLuc = new ArrayList<>();
        List<String> listMaFillter = new ArrayList<>();
        if (rd_kichHoat.isSelected()) {
            List<KhuyenMaiViewModle> listKichHoat = khuyenMaiService.fillterTrangThai(1);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listKichHoat) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHieuLuc) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else if (rd_chuaApDung.isSelected()) {
            List<KhuyenMaiViewModle> listKichHoat = khuyenMaiService.fillterTrangThai(0);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listKichHoat) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHieuLuc) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else {
            listFillter = listHieuLuc;
        }
        loadDataKM(listFillter);
    }//GEN-LAST:event_rd_ConHieuLucActionPerformed

    private void rd_hetHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_hetHieuLucActionPerformed
        List<KhuyenMaiViewModle> listFillter = new ArrayList<>();
        List<KhuyenMaiViewModle> listHetHieuLuc = khuyenMaiService.fillterHieuLuc(0);
        List<String> listMaKichHoat = new ArrayList<>();
        List<String> listMaHieuLuc = new ArrayList<>();
        List<String> listMaFillter = new ArrayList<>();
        if (rd_kichHoat.isSelected()) {
            List<KhuyenMaiViewModle> listKichHoat = khuyenMaiService.fillterTrangThai(1);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listKichHoat) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHetHieuLuc) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else if (rd_chuaApDung.isSelected()) {
            List<KhuyenMaiViewModle> listKichHoat = khuyenMaiService.fillterTrangThai(0);
            for (KhuyenMaiViewModle khuyenMaiViewModle : listKichHoat) {
                listMaKichHoat.add(khuyenMaiViewModle.getMa());
            }
            for (KhuyenMaiViewModle khuyenMaiViewModle : listHetHieuLuc) {
                listMaHieuLuc.add(khuyenMaiViewModle.getMa());
            }
            listMaFillter.addAll(listMaKichHoat);
            listMaFillter.retainAll(listMaHieuLuc);
            for (String string : listMaFillter) {
                listFillter.add(khuyenMaiService.getOne(string));
            }
        } else {
            listFillter = listHetHieuLuc;
        }
        loadDataKM(listFillter);
    }//GEN-LAST:event_rd_hetHieuLucActionPerformed

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
   String maKM = txt_search.getText();
        if (maKM.isEmpty()) {
            listKM = khuyenMaiService.getList();
        } else {
            listKM = khuyenMaiService.search(maKM);
        }
        loadDataKM(listKM);        
    }//GEN-LAST:event_txt_searchCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rd_ConHieuLuc;
    private javax.swing.JRadioButton rd_chuaApDung;
    private javax.swing.JRadioButton rd_hetHieuLuc;
    private javax.swing.JRadioButton rd_kichHoat;
    private javax.swing.JRadioButton rd_tatCaTheoTrangThai;
    private javax.swing.JTable tb_khuyenMaiMain;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
