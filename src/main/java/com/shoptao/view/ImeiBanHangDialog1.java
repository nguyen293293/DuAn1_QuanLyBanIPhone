package com.shoptao.view;

import com.shoptao.services.BanHangService;
import com.shoptao.services.ChungServices;
import com.shoptao.services.InterfaceHoaDonChiTietService;
import com.shoptao.services.InterfaceImeiDaBanService;
import com.shoptao.services.impl.BanHangServiceImpl;
import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.services.impl.ImeiDaBanService;
import com.shoptao.services.impl.ImeiService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.viewmodel.HDCTBanHangViewModel;
import com.shoptao.viewmodel.ImeiDaBanViewModel;
import com.shoptao.viewmodel.ImeiViewModel;
import com.shoptao.viewmodel.SanPhamBanHangViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.awt.ComponentOrientation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen293
 */
public class ImeiBanHangDialog1 extends javax.swing.JDialog {

    private final ImeiService imeiService;
    private final ChungServices<SanPhamViewModle> sanPhamService;
    private final InterfaceImeiDaBanService imeiDaBanService;
    private final InterfaceHoaDonChiTietService hDCTSerive;
    private final BanHangService banHangService;

    BanHangPanel banHangPanel;

    private List<ImeiViewModel> listImei = new ArrayList<>();
    private List<ImeiDaBanViewModel> listImeiDaBan = new ArrayList<>();

    private DefaultTableModel tableModel;

    SanPhamBanHangViewModel sanPham;
    HDCTBanHangViewModel hoaDonChiTiet;

    String idHDCT = null;
    String maHoaDon = null;

    public ImeiBanHangDialog1(java.awt.Frame parent, boolean modal, BanHangPanel banHangPanel, String maSanPham, String idHDCT) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        txtSearch.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        this.banHangPanel = banHangPanel;

        this.imeiService = new ImeiService();
        this.sanPhamService = new SanPhamService();
        this.hDCTSerive = new HoaDonChiTietService();
        this.banHangService = new BanHangServiceImpl();
        this.imeiDaBanService = new ImeiDaBanService();

        this.maHoaDon = banHangPanel.maHoaDon;
        this.idHDCT = idHDCT;

        sanPham = banHangService.getOneSanPham(maSanPham);

        showDetail(sanPham);

        for (ImeiViewModel imeiViewModel : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
            if (imeiViewModel.getTrangthai() != 1) {
                listImei.add(imeiViewModel);
                if (check(imeiViewModel.getMaimei())) {
                    listImei.remove(imeiViewModel);
                }
            }
        }
        loadDataTableImei(listImei);
    }

    public ImeiBanHangDialog1(java.awt.Frame parent, boolean modal, BanHangPanel banHangPanel, String idHDCT) {
        this.banHangPanel = banHangPanel;

        this.imeiService = new ImeiService();
        this.sanPhamService = new SanPhamService();
        this.hDCTSerive = new HoaDonChiTietService();
        this.banHangService = new BanHangServiceImpl();
        this.imeiDaBanService = new ImeiDaBanService();

        this.maHoaDon = banHangPanel.maHoaDon;
        this.idHDCT = idHDCT;
        
        for (ImeiViewModel imeiViewModel : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
            if (imeiViewModel.getTrangthai() != 1) {
                listImei.add(imeiViewModel);
                if (check(imeiViewModel.getMaimei())) {
                    listImei.remove(imeiViewModel);
                }
            }
        }
        loadDataTableImei(listImei);
    }
    
    

    public ImeiBanHangDialog1(java.awt.Frame parent, boolean modal) {
        this.imeiService = new ImeiService();
        this.sanPhamService = new SanPhamService();
        this.imeiDaBanService = new ImeiDaBanService();
        this.hDCTSerive = new HoaDonChiTietService();
        this.banHangService = new BanHangServiceImpl();
    }

    private boolean check(String maImei) {
        List<HDCTBanHangViewModel> listhdct = new HoaDonChiTietService().getAllList();
        for (HDCTBanHangViewModel hdct : listhdct) {
            if (!hdct.getId().equals(idHDCT)) {
                List<ImeiDaBanViewModel> listIDB = imeiDaBanService.search(hdct.getId());
                if(listIDB != null){
                    for (ImeiDaBanViewModel idb : listIDB) {
                        if (idb.getMaimei().equals(maImei)) {
                            return true;
                        }
                    }
                }
                
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSanPham = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbImei = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Sản phẩm");

        lblSanPham.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Số lượng còn lại");

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tbImei.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tbImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã IMEI", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbImei.setRequestFocusEnabled(false);
        tbImei.setRowHeight(30);
        tbImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbImeiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbImei);
        if (tbImei.getColumnModel().getColumnCount() > 0) {
            tbImei.getColumnModel().getColumn(0).setMinWidth(65);
            tbImei.getColumnModel().getColumn(0).setMaxWidth(65);
            tbImei.getColumnModel().getColumn(2).setMinWidth(65);
            tbImei.getColumnModel().getColumn(2).setMaxWidth(65);
        }

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnXacNhan)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
//        ImeiViewModel imei = new ImeiViewModel();
//        ImeiDaBanViewModel imeiDaBan = new ImeiDaBanViewModel();
//
//        for (int i = 0; i < listImei.size(); i++) {
//            ImeiViewModel get = listImei.get(i);
//            if (Boolean.valueOf(tbImei.getValueAt(i, 2) + "") == true) {
//                String maImei = tbImei.getValueAt(i, 1) + "";
//
//                imei.setMaimei(maImei);
//                imei.setTrangthai(2);
//                imeiService.update(imei);
//
//                if (!checkImeiDaban(maImei)) {
//                    imeiDaBan.setIdHDCT(idHDCT);
//                    imeiDaBan.setMaimei(maImei);
//                    imeiDaBanService.add(imeiDaBan);
//                }
//            } else {
//                String maImei = tbImei.getValueAt(i, 1) + "";
//
//                imei.setMaimei(maImei);
//                imei.setTrangthai(0);
//                imeiService.update(imei);
//
//                if (!checkImeiDaban(idHDCT)) {
//                    imeiDaBan.setMaimei(maImei);
//                    imeiDaBanService.deleteByImei(maImei);
//                }
//            }
//        }
//
//        for (ImeiViewModel imeiViewModel : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
//            if (imeiViewModel.getTrangthai() != 1) {
//                listImei.add(imeiViewModel);
//            }
//        }
//
//        listImeiDaBan = imeiDaBanService.search(idHDCT);
//
//        int soLuong = listImeiDaBan.size();
//        banHangService.updateHDCT(idHDCT, soLuong);
//
//        int soluongimei = 0;
//        for (ImeiViewModel imeiVM : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
//            if (imeiVM.getTrangthai() == 0) {
//                soluongimei += 1;
//            }
//        }
//        sanPham.setSoluong(soluongimei);
//        banHangService.updateSanPham(sanPham);
//
        this.dispose();

        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(maHoaDon));
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }//GEN-LAST:event_btnXacNhanActionPerformed

    public void setTrangThaiImei() {
        for (ImeiViewModel x : listImei) {
            if (x.getTrangthai() == 2) {
                x.setTrangthai(1);
                imeiService.update(x);
            }
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
            HDCTBanHangViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
            if (x.getSoluong() <= 0) {
                hDCTSerive.delete(i, maHoaDon);
                banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
                return;
            }
        }
        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(maHoaDon));
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }//GEN-LAST:event_formWindowClosing

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        String maImei = txtSearch.getText();
        if (maImei.isEmpty()) {
            listImei = new ArrayList<>();
            for (ImeiViewModel imeiViewModel : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
                if (imeiViewModel.getTrangthai() != 1) {
                    listImei.add(imeiViewModel);
                }
            }
            loadDataTableImei(listImei);
        } else {
            listImei = new ArrayList<>();
            for (ImeiViewModel imeiViewModel : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
                if (imeiViewModel.getTrangthai() != 1 && imeiViewModel.getMaimei().endsWith(maImei)) {
                    listImei.add(imeiViewModel);
                }
            }
            loadDataTableImei(listImei);
        }
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void tbImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbImeiMouseClicked
        int column = tbImei.getSelectedColumn();
        if (column != 2) {
            return;
        }

        int row = tbImei.getSelectedRow();
        boolean check = (boolean) tbImei.getValueAt(row, 2);
        ImeiViewModel imei = new ImeiViewModel();
        ImeiDaBanViewModel imeiDaBan = new ImeiDaBanViewModel();
        String maImei = tbImei.getValueAt(row, 1) + "";
        if (check == true) {
            imei.setMaimei(maImei);
            imei.setTrangthai(2);
            imeiService.update(imei);
            if (!checkImeiDaban(maImei)) {
                imeiDaBan.setIdHDCT(idHDCT);
                imeiDaBan.setMaimei(maImei);
                imeiDaBan.setTrangthai(2);
                imeiDaBanService.add(imeiDaBan);
            }
        } else {
            imei.setMaimei(maImei);
            imei.setTrangthai(0);
            imeiService.update(imei);
            if (!checkImeiDaban(idHDCT)) {
                imeiDaBan.setMaimei(maImei);
                imeiDaBanService.deleteByImei(maImei);
            }
        }
        for (ImeiViewModel imeiViewModel : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
            if (imeiViewModel.getTrangthai() != 1) {
                listImei.add(imeiViewModel);
            }
        }

        listImeiDaBan = imeiDaBanService.search(idHDCT);

        int soLuong = listImeiDaBan.size();
        banHangService.updateHDCT(idHDCT, soLuong);

        int soluongimei = 0;
        for (ImeiViewModel imeiVM : imeiService.searchImeiByMa(sanPham.getMasanpham())) {
            if (imeiVM.getTrangthai() == 0) {
                soluongimei += 1;
            }
        }
        sanPham.setSoluong(soluongimei);
        banHangService.updateSanPham(sanPham);
        
        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(maHoaDon));
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }//GEN-LAST:event_tbImeiMouseClicked

    private boolean checkImeiDaban(String maImei) {
        for (ImeiDaBanViewModel imeiDaban : imeiDaBanService.search(idHDCT)) {
            if (imeiDaban.getMaimei().equals(maImei)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkImeiDaban1(String maImei) {
        for (ImeiDaBanViewModel imeiDaban : imeiDaBanService.search(idHDCT)) {
            if (imeiDaban.getMaimei().equals(maImei) && imeiDaban.getTrangthai() == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHangDialog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHangDialog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHangDialog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImeiBanHangDialog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImeiBanHangDialog1 dialog = new ImeiBanHangDialog1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JTable tbImei;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void showDetail(SanPhamBanHangViewModel sanPham) {
        lblSanPham.setText(sanPham.getTensanpham() + " - "
                + sanPham.getTenmausac() + " - " + sanPham.getDungluong());
        lblSoLuong.setText(sanPham.getSoluong() + "");
    }

    private void loadDataTableImei(List<ImeiViewModel> listImei) {
        tableModel = (DefaultTableModel) tbImei.getModel();
        tableModel.setRowCount(0);
        for (ImeiViewModel x : listImei) {
//            if (x.getTrangthai() == 0) {
            tableModel.addRow(new Object[]{
                tbImei.getRowCount() + 1, x.getMaimei(), x.getTrangthai() != 0
            });
//            }
        }
    }
    
    public void removeSP(String maSP, String maHD){
        System.out.println("1");
        String idhdct = banHangService.checkSPisEmpty(maHD, maSP);
        for (ImeiDaBanViewModel idb : imeiDaBanService.search(idhdct)) {
            ImeiViewModel i = new ImeiViewModel();
            i.setMaimei(idb.getMaimei());
            i.setTrangthai(0);
            imeiService.update(i);
        }
        imeiDaBanService.deleteByIdHDCT(idhdct);

        listImei = imeiService.searchImeiByMa(sanPham.getMasanpham());

        int soluongimei = 0;
        for (ImeiViewModel imeiVM : listImei) {
            if (imeiVM.getTrangthai() == 0) {
                soluongimei += 1;
            }
        }
        SanPhamBanHangViewModel sp = banHangService.getOneSanPham(maSP);
        sanPham.setSoluong(soluongimei);
        banHangService.updateSanPham(sanPham);
 

        int soLuong = listImeiDaBan.size();
        banHangService.updateHDCT(idHDCT, soLuong);
        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(maHoaDon));
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }
}
