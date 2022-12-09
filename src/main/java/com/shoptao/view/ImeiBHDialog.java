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
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.ImeiDaBanViewModel;
import com.shoptao.viewmodel.ImeiViewModel;
import com.shoptao.viewmodel.SanPhamBanHangViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen293
 */
public class ImeiBHDialog extends javax.swing.JDialog {

    private final ImeiService imeiService;
    private final ChungServices<SanPhamViewModle> sanPhamService;
    private final InterfaceImeiDaBanService imeiDaBanService;
    private final InterfaceHoaDonChiTietService hDCTSerive;
    private final BanHangService banHangService;

    BanHangPanel banHangPanel;

    private List<ImeiViewModel> listImei = new ArrayList<>();
    private List<ImeiDaBanViewModel> listImeiDaBan = new ArrayList<>();

    SanPhamBanHangViewModel sanPham;
    HDCTBanHangViewModel hoaDonChiTiet;

    String idHDCT = null;
    String maHoaDon = null;

    public ImeiBHDialog(java.awt.Frame parent, boolean modal, BanHangPanel banHangPanel, String maSanPham, String idHDCT) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

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

        listImei = imeiService.searchImeiByMa(sanPham.getMasanpham());
        loadDataComboBox(listImei);

        listImeiDaBan = imeiDaBanService.search(idHDCT);
        loadDataTable(listImeiDaBan);

    }

//    private void init(){
//        btnAdd.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnAddActionPerformed(evt);
//            }
//        });
//    }
    public ImeiBHDialog() {
        this.imeiService = new ImeiService();
        this.sanPhamService = new SanPhamService();
        this.imeiDaBanService = new ImeiDaBanService();
        this.hDCTSerive = new HoaDonChiTietService();
        this.banHangService = new BanHangServiceImpl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSanPham = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        cboImei = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImeiDaBan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Sản phẩm");

        lblSanPham.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Số lượng còn lại");

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cboImei.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Imei");

        tbImeiDaBan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tbImeiDaBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Mã imei"
            }
        ));
        tbImeiDaBan.setRowHeight(22);
        jScrollPane1.setViewportView(tbImeiDaBan);
        if (tbImeiDaBan.getColumnModel().getColumnCount() > 0) {
            tbImeiDaBan.getColumnModel().getColumn(0).setMaxWidth(65);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(97, 97, 97)
                                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44)
                                .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(lblSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String maImei = (String) cboImei.getSelectedItem();

        if (maImei == null) {
            return;
        }

        ImeiDaBanViewModel imeiDaBan = new ImeiDaBanViewModel(maImei, idHDCT, 0);
        imeiDaBanService.add(imeiDaBan);

        ImeiViewModel imei = new ImeiViewModel();
        imei.setMaimei(maImei);
        imei.setTrangthai(1);
        String update = imeiService.update(imei);

        listImei = imeiService.searchImeiByMa(sanPham.getMasanpham());
        loadDataComboBox(listImei);

        listImeiDaBan = imeiDaBanService.search(idHDCT);
        loadDataTable(listImeiDaBan);

        int soLuong = listImeiDaBan.size();
        banHangService.updateHDCT(idHDCT, soLuong);

        sanPham.setSoluong(sanPham.getSoluong()- 1);
        banHangService.updateSanPham(sanPham);

        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        HoaDonChiTietViewModel hd = hDCTSerive.getOne(idHDCT);
//        if(hd.getSoluong() <= 0){
//            banHangService.deleteHDCT(i);
//        }
        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
            HDCTBanHangViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
            if (x.getSoluong() <= 0) {
                hDCTSerive.delete(i, maHoaDon);
                banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
                return;
            }
        }
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }//GEN-LAST:event_formWindowClosing

    public void removeAll(String maHoaDon) {
        List<HDCTBanHangViewModel> listHoaDonChiTiet = banHangService.getListHDCT(maHoaDon);
        for (HDCTBanHangViewModel hdct : listHoaDonChiTiet) {

            for (ImeiDaBanViewModel imeiDaBan : imeiDaBanService.search(hdct.getId())) {
                ImeiViewModel imei = new ImeiViewModel();
                imei.setMaimei(imeiDaBan.getMaimei());
                imei.setTrangthai(0);
                imeiService.update(imei);
            }

            imeiDaBanService.deleteByIdHDCT(hdct.getId());

            SanPhamBanHangViewModel sanPhamVM = banHangService.getOneSanPham(hdct.getMasanpham());

            listImei = imeiService.searchImeiByMa(hdct.getMasanpham());

            int soluongimei = 0;
            for (ImeiViewModel imei : listImei) {
                if (imei.getTrangthai() == 0) {
                    soluongimei += 1;
                }
            }
            sanPhamVM.setSoluong(soluongimei);
            banHangService.updateSanPham(sanPhamVM);

            hDCTSerive.delete(hdct.getId());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cboImei;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JTable tbImeiDaBan;
    // End of variables declaration//GEN-END:variables

    private void loadDataComboBox(List<ImeiViewModel> list) {
        cboImei.removeAllItems();
        for (ImeiViewModel x : list) {
            if (x.getTrangthai() == 0) {
                cboImei.addItem(x.getMaimei());
            }
        }
    }

    private void showDetail(SanPhamBanHangViewModel sp) {
        lblSanPham.setText(sp.getTensanpham()+ " - " + sp.getTenmausac()+ " - " + sp.getDungluong());
        lblSoLuong.setText(sp.getSoluong()+ "");
    }

    private void loadDataTable(List<ImeiDaBanViewModel> list) {
        DefaultTableModel tableModel = (DefaultTableModel) tbImeiDaBan.getModel();
        tableModel.setRowCount(0);
        for (ImeiDaBanViewModel x : list) {
            tableModel.addRow(new Object[]{
                tbImeiDaBan.getRowCount() + 1, x.getMaimei(), " "});
        }
//        ButtonColumn buttonColumn = new ButtonColumn(tbImeiDaBan, 2);

    }

    public void removeImeiDaban(int index) {
        index = tbImeiDaBan.getSelectedRow();
        if (index < 0) {
            return;
        }
        String maImei = (String) tbImeiDaBan.getValueAt(index, 1);

        imeiDaBanService.deleteByImei(maImei);

        ImeiViewModel imei = new ImeiViewModel();
        imei.setMaimei(maImei);
        imei.setTrangthai(0);
        imeiService.update(imei);

        listImei = imeiService.searchImeiByMa(sanPham.getMasanpham());
        loadDataComboBox(listImei);

        int soluongimei = 0;
        for (ImeiViewModel imeiVM : listImei) {
            if (imeiVM.getTrangthai() == 0) {
                soluongimei += 1;
            }
        }
        sanPham.setSoluong(soluongimei);
        banHangService.updateSanPham(sanPham);

        listImeiDaBan = imeiDaBanService.search(idHDCT);
        loadDataTable(listImeiDaBan);

        int soLuong = listImeiDaBan.size();
        banHangService.updateHDCT(idHDCT, soLuong);

//        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
//            HoaDonChiTietViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
//            if (x.getSoluong() <= 0) {
//                hDCTSerive.delete(i, maHoaDon);
//            }
//        }
        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }

}