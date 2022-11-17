package com.shoptao.view;

import java.awt.Font;
import javax.swing.plaf.basic.BasicTableUI;

public class HoaDonPanel extends javax.swing.JPanel {

    public HoaDonPanel() {
        initComponents();
        
        tblHoaDon.getTableHeader().setFont(new Font("Arial", 1, 22));
        tblHoaDon.setOpaque(false);
        tblHoaDon.setUI(new BasicTableUI());
        
        txtSeacrch.setText("Mã HD");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcDenNgay = new com.toedter.calendar.JDateChooser();
        jdcTuNgay = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        txtSeacrch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Trạng thái");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, -1, -1));

        jdcDenNgay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jdcDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(758, 33, 180, 40));

        jdcTuNgay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jdcTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 33, 180, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Từ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 39, 40, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Đến");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 50, -1));

        cboTrangThai.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Đã hủy" }));
        jPanel1.add(cboTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1161, 38, -1, -1));

        txtSeacrch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtSeacrch.setBorder(null);
        txtSeacrch.setOpaque(false);
        txtSeacrch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSeacrchMouseClicked(evt);
            }
        });
        jPanel1.add(txtSeacrch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 130, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchbar1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Nhân viên", "Khách hàng", "Ngày tạo", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(25);
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setMinWidth(15);
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 46, 1300, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1386, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSeacrchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSeacrchMouseClicked
        if(!txtSeacrch.getText().equals("Mã HD")) return;
        txtSeacrch.setText("");
    }//GEN-LAST:event_txtSeacrchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcDenNgay;
    private com.toedter.calendar.JDateChooser jdcTuNgay;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtSeacrch;
    // End of variables declaration//GEN-END:variables
}
