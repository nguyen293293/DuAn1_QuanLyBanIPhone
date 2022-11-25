package com.shoptao.view;

import com.shoptao.services.ChungService;
import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen293
 */
public class HoaDonChiTietDialog extends javax.swing.JDialog {
    
    private HoaDonViewModel hoaDon = new HoaDonViewModel();
    private ChungService<HoaDonChiTietViewModel> service;
    private List<HoaDonChiTietViewModel> listHoaDonChiTiet;
    private DefaultTableModel tableModel;
    
    public HoaDonChiTietDialog(java.awt.Frame parent, boolean modal, HoaDonViewModel hoaDon) {
        super(parent, modal);
        initComponents();
        init();
        
        service = new HoaDonChiTietService();
        
        this.hoaDon = hoaDon;
        showDetail(this.hoaDon);
        
        listHoaDonChiTiet = service.search(this.hoaDon.getMa());
        loadDataToTable(listHoaDonChiTiet);
    }

    public void init(){
        tblHoaDonChiTiet.getTableHeader().setFont(new Font("Arial", 1, 22));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jlabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlabel1.setText("Mã hóa đơn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Ngày tạo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Tổng tiền");

        lblMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(0, 204, 255));
        lblMaHoaDon.setText("Mã hoá đơn");

        lblTenNhanVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(0, 204, 255));
        lblTenNhanVien.setText("Tên NV");

        lblTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTenKhachHang.setForeground(new java.awt.Color(0, 204, 255));
        lblTenKhachHang.setText("Tên KH");

        lblNgayTao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(0, 204, 255));
        lblNgayTao.setText("10 - 01 - 1001");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(0, 204, 255));
        lblTongTien.setText("10000VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaHoaDon)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenNhanVien)
                            .addComponent(lblTenKhachHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongTien)
                            .addComponent(lblNgayTao))
                        .addGap(122, 122, 122))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel1)
                    .addComponent(lblMaHoaDon))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblTenNhanVien)
                    .addComponent(lblNgayTao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTenKhachHang)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTien))
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tblHoaDonChiTiet.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonChiTiet.setRowHeight(24);
        jScrollPane1.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HoaDonChiTietDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HoaDonChiTietDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HoaDonChiTietDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HoaDonChiTietDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                HoaDonChiTietDialog dialog = new HoaDonChiTietDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblHoaDonChiTiet;
    // End of variables declaration//GEN-END:variables

    private void showDetail(HoaDonViewModel hoaDon){
        lblMaHoaDon.setText(hoaDon.getMa());
        lblTenNhanVien.setText(hoaDon.getTenNhanVien());
        lblTenKhachHang.setText(hoaDon.getTenKhachHang());
        lblNgayTao.setText(hoaDon.getNgaytao()+"");
    }
    
    private void loadDataToTable(List<HoaDonChiTietViewModel> listHoaDonChiTiet) {
        tableModel = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        tableModel.setRowCount(0);
        for (HoaDonChiTietViewModel x : listHoaDonChiTiet) {
            tableModel.addRow(x.toDataRow(tblHoaDonChiTiet));
        }
    }
}