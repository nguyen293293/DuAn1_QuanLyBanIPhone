package com.shoptao.view;

import com.shoptao.services.BanHangService;
import com.shoptao.services.impl.HoaDonService;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.awt.Font;
import java.util.List;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableModel;
import com.shoptao.services.ChungServices;
import com.shoptao.services.InterfaceHoaDonChiTietService;
import com.shoptao.services.impl.BanHangServiceImpl;
import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.services.impl.ImeiDaBanService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.ImeiDaBanViewModel;
import java.util.Date;

public class HoaDonPanel1 extends javax.swing.JPanel {

    private final HoaDonService service;
    private List<HoaDonViewModel> listHoaDon;
    private List<HoaDonChiTietViewModel> listHDCT;
    private List<ImeiDaBanViewModel> listImeiDaBan;

    private DefaultTableModel tableModel;
    private InterfaceHoaDonChiTietService hdctService;

    public HoaDonPanel1() {
        initComponents();
        init();
        txtSeacrch.setOpaque(false);

        service = new HoaDonService();
        hdctService = new HoaDonChiTietService();

        listHoaDon = service.getList();
        loadDataHoaDon(listHoaDon);
    }

    public void init() {
        tblHoaDon.getTableHeader().setFont(new Font("Arial", 1, 20));
        tblHoaDon.setUI(new BasicTableUI());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        txtSeacrch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdcTuNgay = new com.toedter.calendar.JDateChooser();
        jdcDenNgay = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHDCT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbImei = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Trạng thái");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Từ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Đến");

        cboTrangThai.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Đã hủy" }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        txtSeacrch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtSeacrch.setBorder(null);
        txtSeacrch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeacrchCaretUpdate(evt);
            }
        });
        txtSeacrch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSeacrchMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchbar1.png"))); // NOI18N

        jdcTuNgay.setDateFormatString("dd - MM - yyyy");
        jdcTuNgay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jdcTuNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcTuNgayPropertyChange(evt);
            }
        });

        jdcDenNgay.setDateFormatString("dd - MM - yyyy");
        jdcDenNgay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jdcDenNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcDenNgayPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtSeacrch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(155, 155, 155)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSeacrch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Nhân viên", "Khách hàng", "Ngày tạo", "Tổng tiền", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(30);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbHDCT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tbHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHDCT.setRowHeight(28);
        tbHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHDCT);
        if (tbHDCT.getColumnModel().getColumnCount() > 0) {
            tbHDCT.getColumnModel().getColumn(0).setMinWidth(100);
            tbHDCT.getColumnModel().getColumn(0).setMaxWidth(100);
            tbHDCT.getColumnModel().getColumn(3).setMinWidth(120);
            tbHDCT.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imei đã bán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbImei.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tbImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã imei"
            }
        ));
        tbImei.setRowHeight(28);
        jScrollPane3.setViewportView(tbImei);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSeacrchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeacrchCaretUpdate
        if (listHoaDon == null) {
            return;
        }
        String ma = txtSeacrch.getText();
        if (ma.isEmpty()) {
            listHoaDon = service.getList();
        } else {
            listHoaDon = service.search(ma);
        }
        loadDataHoaDon(listHoaDon);
        loadDataHDCT(null);
        loadDataImeiDaBan(null);
    }//GEN-LAST:event_txtSeacrchCaretUpdate

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (tblHoaDon.getRowCount() < 0) {
            return;
        }
        int index = tblHoaDon.getSelectedRow();
        if (!tblHoaDon.getValueAt(index, 5).equals("Đã thanh toán")) {
            return;
        }

        String maHoaDon = (String) tblHoaDon.getValueAt(index, 0);
        listHDCT = hdctService.getList(maHoaDon);
        loadDataHDCT(listHDCT);
        loadDataImeiDaBan(null);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtSeacrchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSeacrchMouseClicked

        jdcTuNgay.setDate(null);
        jdcDenNgay.setDate(null);
    }//GEN-LAST:event_txtSeacrchMouseClicked

    private void jdcTuNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcTuNgayPropertyChange
        Date ngaybd = jdcTuNgay.getDate();
        Date ngaykt = jdcDenNgay.getDate();
        if (ngaybd == null && ngaykt == null) {
            listHoaDon = service.getList();
            loadDataHoaDon(listHoaDon);
            return;
        }
        loadDataHoaDon(service.searchbydate(ngaybd, ngaykt));
        loadDataHDCT(null);
        loadDataImeiDaBan(null);
        txtSeacrch.setText("");
        cboTrangThai.setSelectedIndex(0);
    }//GEN-LAST:event_jdcTuNgayPropertyChange

    private void jdcDenNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcDenNgayPropertyChange
        Date ngaybd = jdcTuNgay.getDate();
        Date ngaykt = jdcDenNgay.getDate();
        if (ngaybd == null && ngaykt == null) {
            listHoaDon = service.getList();
            loadDataHoaDon(listHoaDon);
            return;
        }
        loadDataHoaDon(service.searchbydate(ngaybd, ngaykt));
        loadDataHDCT(null);
        loadDataImeiDaBan(null);
        txtSeacrch.setText("");
        cboTrangThai.setSelectedIndex(0);
    }//GEN-LAST:event_jdcDenNgayPropertyChange

    private void tbHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCTMouseClicked
        int rowHD = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(rowHD, 0) + "";

        int rowHDCT = tbHDCT.getSelectedRow();
        String maSP = tbHDCT.getValueAt(rowHDCT, 0) + "";

        String idHDCT = new BanHangServiceImpl().checkSPisEmpty(maHD, maSP);
        listImeiDaBan = new ImeiDaBanService().search(idHDCT);
        loadDataImeiDaBan(listImeiDaBan);
    }//GEN-LAST:event_tbHDCTMouseClicked

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        String trangthai = cboTrangThai.getSelectedItem() + "";
        if (cboTrangThai.getSelectedIndex() == 1) {
            loadDataHoaDon(service.searchbytrangthai(1));
        } else if(cboTrangThai.getSelectedIndex() == 2){
            loadDataHoaDon(service.searchbytrangthai(2));
        }  else{
            listHoaDon = service.getList();
            loadDataHoaDon(listHoaDon);
        }
//        loadDataHDCT(null);
//        loadDataImeiDaBan(null);
//
//        jdcTuNgay.setDate(null);
//        jdcDenNgay.setDate(null);
    }//GEN-LAST:event_cboTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcDenNgay;
    private com.toedter.calendar.JDateChooser jdcTuNgay;
    private javax.swing.JTable tbHDCT;
    private javax.swing.JTable tbImei;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtSeacrch;
    // End of variables declaration//GEN-END:variables

    private void loadDataHoaDon(List<HoaDonViewModel> listHoaDon) {
        tableModel = (DefaultTableModel) tblHoaDon.getModel();
        tableModel.setRowCount(0);
        System.out.println("1");
        for (HoaDonViewModel x : listHoaDon) {
            if (x.getTrangthai() != 0) {
                tableModel.addRow(x.toDataRow2());
            }
        }
    }

    private void loadDataHDCT(List<HoaDonChiTietViewModel> list) {
        DefaultTableModel tablemodel = (DefaultTableModel) tbHDCT.getModel();
        tablemodel.setRowCount(0);
        if (list == null) {
            tablemodel.setRowCount(0);
            return;
        }
        for (HoaDonChiTietViewModel x : list) {
            tablemodel.addRow(x.toDataRow2());
        }
    }

    private void loadDataImeiDaBan(List<ImeiDaBanViewModel> list) {
        DefaultTableModel tbModel = (DefaultTableModel) tbImei.getModel();
        tbModel.setRowCount(0);
        if (list == null) {
            tbModel.setRowCount(0);
            return;
        }
        for (ImeiDaBanViewModel x : list) {
            tbModel.addRow(new Object[]{
                x.getMaimei()
            });
        }
    }
}
