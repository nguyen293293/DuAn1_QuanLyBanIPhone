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
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.ImeiDaBanViewModel;
import com.shoptao.viewmodel.ImeiViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author nguyen293
 */
public class ImeiBHDialog extends javax.swing.JDialog {
    
    private final ChungServices<ImeiViewModel> imeiService;
    private final ChungServices<SanPhamViewModle> sanPhamService;
    private final InterfaceImeiDaBanService imeiDaBanService;
    private final InterfaceHoaDonChiTietService hDCTSerive;
    private final BanHangService banHangService;
    
    BanHangPanel banHangPanel;
    
    private List<ImeiViewModel> listImei = new ArrayList<>();
    private List<ImeiDaBanViewModel> listImeiDaBan = new ArrayList<>();
    
    SanPhamViewModle sanPhamViewModle;
    HoaDonChiTietViewModel hoaDonChiTietViewModel;
    
    String idHDCT = null;
    String maHoaDon = null;
    
    public ImeiBHDialog(java.awt.Frame parent, boolean modal, BanHangPanel banHangPanel, int indexSanPham, String idHDCT) {
        super(parent, modal);
        initComponents();
        
        this.banHangPanel = banHangPanel;
        
        this.imeiService = new ImeiService();
        this.sanPhamService = new SanPhamService();
        this.hDCTSerive = new HoaDonChiTietService();
        this.banHangService = new BanHangServiceImpl();
        this.imeiDaBanService = new ImeiDaBanService();
        
        this.maHoaDon = banHangPanel.maHoaDon;
        this.idHDCT = idHDCT;
        
        sanPhamViewModle = banHangService.getListSanPham().get(indexSanPham);
        
        showDetail(sanPhamViewModle);
        
        listImei = imeiService.search(sanPhamViewModle.getId());
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImeiDaBan = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(0, 9, Short.MAX_VALUE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

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

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoaTatCa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnXoaTatCa.setText("Xóa tất cả");
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaTatCa)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnXoaTatCa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        System.out.println("ImeiBH - 255: " + update);
        
        listImei = imeiService.search(sanPhamViewModle.getId());
        loadDataComboBox(listImei);
        
        listImeiDaBan = imeiDaBanService.search(idHDCT);
        loadDataTable(listImeiDaBan);
        
        int soLuong = listImeiDaBan.size();
        banHangService.updateHDCT(idHDCT, soLuong);
        
        sanPhamViewModle.setSoluongton(sanPhamViewModle.getSoluongton() - soLuong);
        banHangService.updateSanPham(sanPhamViewModle);

//        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
//            HoaDonChiTietViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
//            if (x.getSoluong() <= 0) {
//                banHangService.deleteHDCT(i);
//                return;
//            }
//        }
//        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
//            HoaDonChiTietViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
//            if(x.getMaSanPham().equals(sanPhamViewModle.getMa())){
//                return;
//            }
//        }
        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        HoaDonChiTietViewModel hd = hDCTSerive.getOne(idHDCT);
//        if(hd.getSoluong() <= 0){
//            banHangService.deleteHDCT(i);
//        }
        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
            HoaDonChiTietViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
            if (x.getSoluong() <= 0) {
                hDCTSerive.delete(i, maHoaDon);
                banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
                return;
            }
        }
        banHangPanel.loadDataSanPham(banHangService.getListSanPham());
    }//GEN-LAST:event_formWindowClosing

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        removeImeiDaban(tbImeiDaBan.getSelectedRow());
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed
        
        for (ImeiDaBanViewModel x : listImeiDaBan) {
            ImeiViewModel imei = new ImeiViewModel();
            imei.setMaimei(x.getMaimei());
            imei.setTrangthai(0);
            imeiService.update(imei);
        }
        
        imeiDaBanService.deleteByIdHDCT(idHDCT);
        
        listImei = imeiService.search(sanPhamViewModle.getId());
        loadDataComboBox(listImei);
        
        sanPhamViewModle.setSoluongton(listImei.size());
        banHangService.updateSanPham(sanPhamViewModle);
        
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
    }//GEN-LAST:event_btnXoaTatCaActionPerformed
    
    public void removeAll(String maHoaDon) {
        List<HoaDonChiTietViewModel> listHoaDonChiTiet = banHangService.getListHDCT(maHoaDon);
        for (HoaDonChiTietViewModel hdct : listHoaDonChiTiet) {
            
            for (ImeiDaBanViewModel imeiDaBan : imeiDaBanService.search(hdct.getId())) {
                ImeiViewModel imei = new ImeiViewModel();
                imei.setMaimei(imeiDaBan.getMaimei());
                imei.setTrangthai(0);
                imeiService.update(imei);
            }
            
            imeiDaBanService.deleteByIdHDCT(hdct.getId());
            
            SanPhamViewModle sanPhamVM = sanPhamService.getOne(hdct.getMaSanPham());
            
            listImei = imeiService.search(sanPhamVM.getId());
            
            sanPhamVM.setSoluongton(listImei.size());
            banHangService.updateSanPham(sanPhamVM);
            
            hDCTSerive.delete(hdct.getId());
            
        }
        
//        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
//        banHangPanel.loadDataSanPham(banHangService.getListSanPham());

//        for (ImeiDaBanViewModel x : listImeiDaBan) {
//            ImeiViewModel imei = new ImeiViewModel();
//            imei.setMaimei(x.getMaimei());
//            imei.setTrangthai(0);
//            imeiService.update(imei);
//        }
//
//        imeiDaBanService.deleteByIdHDCT(idHDCT);
//
//        listImei = imeiService.search(sanPhamViewModle.getId());
//        loadDataComboBox(listImei);
//
//        sanPhamViewModle.setSoluongton(listImei.size());
//        banHangService.updateSanPham(sanPhamViewModle);
//
//        listImeiDaBan = imeiDaBanService.search(idHDCT);
//        loadDataTable(listImeiDaBan);
//
//        int soLuong = listImeiDaBan.size();
//        banHangService.updateHDCT(idHDCT, soLuong);
//
//        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
//            HoaDonChiTietViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
//            if (x.getSoluong() <= 0) {
//                hDCTSerive.delete(i, maHoaDon);
//            }
//        }
//
//        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.JComboBox<String> cboImei;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    
    private void showDetail(SanPhamViewModle sp) {
        lblSanPham.setText(sp.getTen() + " - " + sp.getSoluongton() + " - " + sp.getTenmausac());
        lblSoLuong.setText(sp.getSoluongton() + "");
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
//        index = tbImeiDaBan.getSelectedRow();

        String maImei = (String) tbImeiDaBan.getValueAt(0, 1);
        
        imeiDaBanService.deleteByImei(maImei);
        
        ImeiViewModel imei = new ImeiViewModel();
        imei.setMaimei(maImei);
        imei.setTrangthai(0);
        imeiService.update(imei);
        
        listImei = imeiService.search(sanPhamViewModle.getId());
        loadDataComboBox(listImei);
        
        sanPhamViewModle.setSoluongton(listImei.size());
        banHangService.updateSanPham(sanPhamViewModle);
        
        listImeiDaBan = imeiDaBanService.search(idHDCT);
        loadDataTable(listImeiDaBan);
        
        int soLuong = listImeiDaBan.size();
        banHangService.updateHDCT(idHDCT, soLuong);
        
        for (int i = 0; i < banHangService.getListHDCT(banHangPanel.maHoaDon).size(); i++) {
            HoaDonChiTietViewModel x = banHangService.getListHDCT(banHangPanel.maHoaDon).get(i);
            if (x.getSoluong() <= 0) {
                hDCTSerive.delete(i, maHoaDon);
            }
        }
        
        banHangPanel.loadDataHoaDonChiTiet(banHangService.getListHDCT(banHangPanel.maHoaDon));
    }
    
}

/*
class ButtonColumn extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor, ActionListener {

    JTable table;
    JButton renderButton;
    JButton editButton;
    String text;

    public ButtonColumn(JTable table, int column) {
        super();
        this.table = table;
        renderButton = new JButton();

        editButton = new JButton("Xóa");
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
    }

    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        text = (value == null) ? "" : value.toString();
        editButton.setText("Xóa");
        return editButton;
    }

    public Object getCellEditorValue() {
        return text;
    }

    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
        System.out.println(e.getActionCommand() + " : " + table.getSelectedRow());
        ImeiBHDialog imeiBHDialog = new ImeiBHDialog();
        imeiBHDialog.removeImeiDaban(table.getSelectedRow());
    }
}
 */
