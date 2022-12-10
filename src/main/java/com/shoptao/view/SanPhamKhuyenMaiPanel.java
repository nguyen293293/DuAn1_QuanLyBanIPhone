/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.domainmodel.SanPham;
import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.services.impl.SanPhamKhuyenMaiService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamKhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haih7
 */
public class SanPhamKhuyenMaiPanel extends javax.swing.JPanel {

    public KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
    public SanPhamKhuyenMaiService sanPhamKhuyenMaiService = new SanPhamKhuyenMaiService();
    public SanPhamService sanPhamService = new SanPhamService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();

    SanPhamPanel sppl = new SanPhamPanel();

    List<SanPhamViewModle> listSP = new ArrayList<>();
    List<SanPhamKhuyenMaiViewModle> listSPMKM = new ArrayList<>();
    List<KhuyenMaiViewModle> listKM = new ArrayList<>();

    int indexKhuyenMai;
    int indexSanPhamKhuyenMai;

    public SanPhamKhuyenMaiPanel() {
        initComponents();

        listSP = sanPhamService.getList();
        listSPMKM = sanPhamKhuyenMaiService.getList();
        listKM = khuyenMaiService.getList();

        loadDataSP(listSP);
        loadDataSPKM(listSPMKM);
        loadDataKM(listKmApDung(listKM));
    }

    public void loadDataSP(List<SanPhamViewModle> listSPVM) {
        defaultTableModel = (DefaultTableModel) tb_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (SanPhamViewModle sanPhamViewModle : listSPVM) {
            defaultTableModel.addRow(new Object[]{
                false,
                sanPhamViewModle.getMa(),
                sanPhamViewModle.getTen(),});
        }
    }

    public void loadDataKM(List<KhuyenMaiViewModle> listKM) {
        defaultTableModel = (DefaultTableModel) tb_khuyenMai.getModel();
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

    public void loadDataSPKM(List<SanPhamKhuyenMaiViewModle> listSPVM) {
        defaultTableModel = (DefaultTableModel) tb_sanPhamKhuyenMai.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (SanPhamKhuyenMaiViewModle sanPhamKhuyenMaiViewModle : listSPVM) {
            defaultTableModel.addRow(new Object[]{
                i++,
                sanPhamKhuyenMaiViewModle.getTensanpham(),
                sanPhamKhuyenMaiViewModle.getTenkhuyenmai(),
                sanPhamKhuyenMaiViewModle.getDongia(),
                sanPhamKhuyenMaiViewModle.getSotienconlai(),
                sanPhamKhuyenMaiViewModle.getTrangthai() == 1 ? "Đang áp dụng khuyến mại" : "Chưa áp dụng khuyến mại"
            });
        }
    }

    public List<Integer> getModelListSanPham() {
        List<Integer> listSelect = new ArrayList<>();
        for (int i = 0; i < tb_sanPham.getModel().getRowCount(); i++) {
            if ((Boolean) tb_sanPham.getModel().getValueAt(i, 0)) {
                listSelect.add(i);
            }
        }
        return listSelect;
    }

    public List<KhuyenMaiViewModle> listKmApDung(List<KhuyenMaiViewModle> listInput) {
        List<KhuyenMaiViewModle> listOutput = new ArrayList<>();
        for (KhuyenMaiViewModle x : listInput) {
            if (x.getTrangthai() == 1) {
                listOutput.add(x);
            }
        }
        return listOutput;

    }

    public String getId() {
        String id = sanPhamKhuyenMaiService.getList().get(indexSanPhamKhuyenMai).getId();
        return id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_khuyenMai = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_sanPham = new javax.swing.JTable();
        txt_serachKhuyenMai = new javax.swing.JTextField();
        txt_searchSanPham = new javax.swing.JTextField();
        btnkhuyenmai = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sanPhamKhuyenMai = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_save_60px.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_60px.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        tb_khuyenMai.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_khuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_khuyenMai);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        tb_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Select", "Mã", "Tên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tb_sanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        txt_searchSanPham.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_searchSanPham.setBorder(null);
        txt_searchSanPham.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchSanPhamCaretUpdate(evt);
            }
        });
        txt_searchSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchSanPhamActionPerformed(evt);
            }
        });

        btnkhuyenmai.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnkhuyenmai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_60px.png"))); // NOI18N
        btnkhuyenmai.setText("Khuyến mại");
        btnkhuyenmai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhuyenmaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_serachKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_searchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(226, 226, 226))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(btnkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_serachKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_searchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnkhuyenmai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_sanPhamKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Tên khuyến mại", "Đơn giá", "Số tiền còn lại", "Trạng thái"
            }
        ));
        tb_sanPhamKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanPhamKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_sanPhamKhuyenMai);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(btn_xoa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//validate
        if (tb_khuyenMai.getSelectedRow() < 0) {
            DialogHelper.alert(null, "Chọn khuyến mại muốn thêm", "Thông báo");
            return;
        }

        if (tb_sanPham.getSelectedRow() < 0) {
            DialogHelper.alert(null, "Chọn sản phẩm muốn thêm khuyến mại", "Thông báo");
            return;
        }
//ádasd
        KhuyenMaiViewModle khuyenMai = khuyenMaiService.getList().get(indexKhuyenMai);
        List<Integer> listSelectSP = getModelListSanPham();
        List<SanPhamViewModle> list = sanPhamService.getList();

        for (Integer i : listSelectSP) {

            BigDecimal giatri = BigDecimal.valueOf(khuyenMai.getGiatri());
            int indexcb = khuyenMai.getHinhthucgiamgia();
            BigDecimal sotienconlai;
            if (indexcb == 0) {
                sotienconlai = list.get(i).getGiaban().subtract(giatri);
            } else {
                sotienconlai = list.get(i).getGiaban().multiply(giatri);
            }
            BigDecimal dongia = list.get(i).getGiaban();
            SanPhamKhuyenMaiViewModle spkmvm = new SanPhamKhuyenMaiViewModle("", list.get(i).getMa(), list.get(i).getTen(), khuyenMai.getMa(), khuyenMai.getTen(), khuyenMai.getTrangthai(), dongia, sotienconlai, list.get(i).getTrangthai());
            sanPhamKhuyenMaiService.add(spkmvm, i, indexKhuyenMai);
            SanPhamViewModle spvm = sanPhamService.getOne(list.get(i).getMa());
            spvm.setGiaban(sotienconlai);
            sanPhamService.updatevs2(spvm);

            sppl.loadData(sanPhamService.getList());

        }
        loadDataSPKM(sanPhamKhuyenMaiService.getList());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        //validate
        if (tb_sanPhamKhuyenMai.getSelectedRow() < 0) {
            DialogHelper.alert(null, "Chọn sản phẩm khuyến mại muốn xoá", "Thông báo");
            return;
        }
        //fsaf
        SanPhamKhuyenMaiViewModle spkmvm = sanPhamKhuyenMaiService.getOne(sanPhamKhuyenMaiService.getList().get(tb_sanPhamKhuyenMai.getSelectedRow()).getId());
        SanPhamViewModle spvm = sanPhamService.getOne(spkmvm.getMasanpham());
        KhuyenMaiViewModle kmvm = khuyenMaiService.getOne(spkmvm.getMakhuyenmai());
        BigDecimal giatri = BigDecimal.valueOf(kmvm.getGiatri());
        BigDecimal sotienconlai;

        if (kmvm.getHinhthucgiamgia() == 0) {
            sotienconlai = spkmvm.getSotienconlai().add(giatri);
        } else {
            sotienconlai = spkmvm.getSotienconlai().divide(giatri);
        }

        spkmvm.setSotienconlai(sotienconlai);
        spvm.setGiaban(sotienconlai);
        sanPhamService.updatevs2(spvm);
        sanPhamKhuyenMaiService.updatevs2(spkmvm);

        JOptionPane.showMessageDialog(this, sanPhamKhuyenMaiService.delete(getId()));

        List<SanPhamKhuyenMaiViewModle> list = sanPhamKhuyenMaiService.getList();
        loadDataSPKM(list);

        sppl.loadData(sanPhamService.getList());

    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_khuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khuyenMaiMouseClicked
        // TODO add your handling code here:
        indexKhuyenMai = tb_khuyenMai.getSelectedRow();
    }//GEN-LAST:event_tb_khuyenMaiMouseClicked

    private void btnkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhuyenmaiActionPerformed
        KhuyenMaiDialog khuyenMaiDialog = new KhuyenMaiDialog(null, true, this);
        khuyenMaiDialog.setVisible(true);
    }//GEN-LAST:event_btnkhuyenmaiActionPerformed

    private void tb_sanPhamKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanPhamKhuyenMaiMouseClicked
        // TODO add your handling code here:
        indexSanPhamKhuyenMai = tb_sanPhamKhuyenMai.getSelectedRow();
    }//GEN-LAST:event_tb_sanPhamKhuyenMaiMouseClicked

    private void txt_serachKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serachKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serachKhuyenMaiActionPerformed

    private void txt_searchSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchSanPhamActionPerformed

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

    private void txt_searchSanPhamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchSanPhamCaretUpdate

        String maSP = txt_searchSanPham.getText();
        List<SanPhamViewModle> list = new ArrayList<>();
        if (maSP.isEmpty()) {
            list = sanPhamService.getList();
        } else {
            list = sanPhamService.search(maSP);
        }
        loadDataSP(list);
    }//GEN-LAST:event_txt_searchSanPhamCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btnkhuyenmai;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tb_khuyenMai;
    private javax.swing.JTable tb_sanPham;
    private javax.swing.JTable tb_sanPhamKhuyenMai;
    private javax.swing.JTextField txt_searchSanPham;
    private javax.swing.JTextField txt_serachKhuyenMai;
    // End of variables declaration//GEN-END:variables
}
