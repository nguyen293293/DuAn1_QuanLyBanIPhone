/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.services.impl.HoaDonService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen293
 */
public class ThongKePanel extends javax.swing.JPanel {

    private HoaDonService hoaDonService = new HoaDonService();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
    private ButtonGroup buttonGroup = new ButtonGroup();

    public ThongKePanel() {
        initComponents();
//        init();

        selectRD();
    }

//    private void init() {
//        rd_nam.setOpaque(false);
//        rd_thang.setOpaque(false);
//        rd_ngay.setOpaque(false);
//    }
    public void selectRD() {
        buttonGroup.add(rd_nam);
        buttonGroup.add(rd_thang);
        buttonGroup.add(rd_ngay);
    }

//    public void test(){
//          List<HoaDonChiTietViewModel> list = hoaDonChiTietService.getList("mahd1");
//                              System.out.println("cdasdas");
//
//        if (!list.isEmpty()) {
//                    System.out.println(list.get(0).getSoluong());
//                    System.out.println("cdasdas");
//
//        }
//    }
//
//    public void date() {
//        Date date = jdc_ngay.getDate();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date date2 = new Date();
//
//        System.out.println(format.format(date));
//        System.out.println(format.format(date2));
//        System.out.println(format.format(date2).compareTo(format.format(date)));
//
//    }
    public void loadDataDaThanhToan(List<HoaDonChiTietViewModel> list) {
        defaultTableModel = (DefaultTableModel) tb_spdtt.getModel();
        defaultTableModel.setRowCount(0);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        int i = 1;
        for (HoaDonChiTietViewModel x : list) {
//            List<ImeiViewModel> listimvm = imeiService.search(sanPhamViewModle.getId());
//            int soLuongTon = listimvm.size();
            defaultTableModel.addRow(new Object[]{
          i++,
                x.getMaHoaDon(),
                x.getMaSanPham(),
                x.getTenSanPham(),
                format.format(x.getNgaytao()),
                x.getSoluong(),
                x.getDongia(),
                x.getTongTien()

            });
        }
    }

    public List<HoaDonChiTietViewModel> ngay() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<HoaDonChiTietViewModel> listHDVM = new ArrayList<>();
        String selectDate = format.format(jdc_ngay.getDate());
        for (HoaDonChiTietViewModel x : hoaDonChiTietService.getListHDCT()) {
            String dateHoaDon = format.format(x.getNgaytao());
            if (selectDate.compareTo(dateHoaDon) == 0) {
                listHDVM.add(x);
            }
        }
        return listHDVM;
    }

    public List<HoaDonChiTietViewModel> thang() {
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        List<HoaDonChiTietViewModel> listHDVM = new ArrayList<>();
        String selectDate = (String) cb_thang.getSelectedItem();
        for (HoaDonChiTietViewModel x : hoaDonChiTietService.getListHDCT()) {
            String dateHoaDon = format2.format(x.getNgaytao());
            if (selectDate.compareTo(dateHoaDon) == 0) {
                listHDVM.add(x);
            }
        }
        return listHDVM;
    }

    public List<HoaDonChiTietViewModel> nam() {
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");

        List<HoaDonChiTietViewModel> listHDVM = new ArrayList<>();
        String selectDate = (String) cb_nam.getSelectedItem();

        for (HoaDonChiTietViewModel x : hoaDonChiTietService.getListHDCT()) {
            String dateHoaDon = format3.format(x.getNgaytao());
            if (selectDate.compareTo(dateHoaDon) == 0) {
                listHDVM.add(x);
            }
        }
        return listHDVM;
    }
//
//    public List<HoaDonChiTietViewModel> checkDaThanhToan(List<HoaDonChiTietViewModel> list) {
//        List<HoaDonChiTietViewModel> listDTT = new ArrayList<>();
//        for (HoaDonChiTietViewModel x : list) {
//            if (x.getTrangThai() == 1) {
//                listDTT.add(x);
//            }
//        }
//        return listDTT;
//    }
//
//    public List<HoaDonChiTietViewModel> checkDaHuy(List<HoaDonChiTietViewModel> list) {
//        List<HoaDonChiTietViewModel> listDDH = new ArrayList<>();
//        for (HoaDonChiTietViewModel x : list) {
//            if (x.getTrangThai() == 2) {
//                listDDH.add(x);
//            }
//        }
//        return listDDH;
//    }

//    public List<HoaDonChiTietViewModel> getListSelect() {
//        List<HoaDonChiTietViewModel> list = new ArrayList<>();
//        int count = ngay().size();
//                List<HoaDonViewModel> list2 = ngay();
//                count++;
//        for (int i = 0; i < count; i++) {
//            
//        
//            if (list2.get(i).getTrangthai() == 1) {
//                list = getTest(hoaDonChiTietService.getList(list2.get(i).getMa()));
//                getListSelect();
//               
//            }
//
//        }
//        return list;
//
//    }
//    public List<HoaDonChiTietViewModel> getTest(List<HoaDonChiTietViewModel> list) {
//        List<HoaDonChiTietViewModel> vcl = new ArrayList<>();
//        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : list) {
//            vcl.add(hoaDonChiTietViewModel);
//        }
//        return vcl;
//    }
    
    public BigDecimal tongGiaNhap(List<HoaDonChiTietViewModel>  list){
        BigDecimal tien = new BigDecimal(0);
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : list) {
            tien = tien.add(hoaDonChiTietViewModel.getGianhap().multiply(BigDecimal.valueOf(hoaDonChiTietViewModel.getSoluong())) );
        }
        
        return tien;
    }
    
      public BigDecimal tongGiaBan(List<HoaDonChiTietViewModel>  list){
        BigDecimal tien2 = new BigDecimal(0);
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : list) {
            tien2 = tien2.add(hoaDonChiTietViewModel.getDongia());
                        tien2 = tien2.add(hoaDonChiTietViewModel.getTongTien());

        }
        
        return tien2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_doanhThu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_lai = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_tongHoaDon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_spdtt = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rd_ngay = new javax.swing.JRadioButton();
        rd_thang = new javax.swing.JRadioButton();
        rd_nam = new javax.swing.JRadioButton();
        jdc_ngay = new com.toedter.calendar.JDateChooser();
        cb_nam = new javax.swing.JComboBox<>();
        cb_thang = new javax.swing.JComboBox<>();

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Doanh thu");

        lbl_doanhThu.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_doanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_doanhThu.setText("0 VND");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Lãi");

        lbl_lai.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_lai.setText("0 VND");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lbl_lai, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
            .addComponent(lbl_doanhThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_lai)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("Tổng hóa đơn");

        lb_tongHoaDon.setFont(new java.awt.Font("Tahoma", 1, 64)); // NOI18N
        lb_tongHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tongHoaDon.setText("20");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lb_tongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(lb_tongHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tb_spdtt.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tb_spdtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên", "Ngày tạo", "Số lượng", "Giá", "Tổng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_spdtt.setRowHeight(25);
        tb_spdtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_spdttMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_spdtt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        rd_ngay.setText("Ngày");
        rd_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ngayActionPerformed(evt);
            }
        });

        rd_thang.setText("Tháng");
        rd_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_thangActionPerformed(evt);
            }
        });

        rd_nam.setText("Năm");
        rd_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_namActionPerformed(evt);
            }
        });

        jdc_ngay.setDateFormatString("dd-MM-yyyy");
        jdc_ngay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        cb_nam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023" }));
        cb_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_namActionPerformed(evt);
            }
        });

        cb_thang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cb_thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cb_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_thangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_ngay)
                    .addComponent(rd_thang)
                    .addComponent(rd_nam))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cb_thang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdc_ngay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(cb_nam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_ngay)
                    .addComponent(jdc_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_thang)
                    .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rd_nam))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_namActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_namActionPerformed

    private void cb_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_thangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_thangActionPerformed

    private void tb_spdttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_spdttMouseClicked
//        try {
//            // TODO add your handling code here:
//            showDetail();
//        } catch (IOException ex) {
//            Logger.getLogger(SanPhamPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        indexsp = tb_spdtt.getSelectedRow();
//        loadCBSoLuongImei(getListImeiOfIdSP());
    }//GEN-LAST:event_tb_spdttMouseClicked

    private void rd_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ngayActionPerformed
        // TODO add your handling code here:
      
            int soHoaDon = ngay().size();
            lb_tongHoaDon.setText(String.valueOf(soHoaDon));
            
            lbl_doanhThu.setText(String.valueOf(tongGiaBan(ngay())));
            lbl_lai.setText(String.valueOf((tongGiaBan(ngay())).subtract(tongGiaNhap(ngay()))));
           
           loadDataDaThanhToan(ngay());

    
    }//GEN-LAST:event_rd_ngayActionPerformed

    private void rd_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_thangActionPerformed

      
            int soHoaDon = thang().size();
            lb_tongHoaDon.setText(String.valueOf(soHoaDon));
            lbl_doanhThu.setText(String.valueOf(tongGiaBan(thang())));
            lbl_lai.setText(String.valueOf((tongGiaBan(thang())).subtract(tongGiaNhap(thang()))));
            
                      loadDataDaThanhToan(thang());

     
    }//GEN-LAST:event_rd_thangActionPerformed

    private void rd_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_namActionPerformed

      
            int soHoaDon = nam().size();
            lb_tongHoaDon.setText(String.valueOf(soHoaDon));
            lbl_doanhThu.setText(String.valueOf(tongGiaBan(nam())));
            lbl_lai.setText(String.valueOf((tongGiaBan(nam())).subtract(tongGiaNhap(nam()))));
            
        
           loadDataDaThanhToan(nam());

    }//GEN-LAST:event_rd_namActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_nam;
    private javax.swing.JComboBox<String> cb_thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_ngay;
    private javax.swing.JLabel lb_tongHoaDon;
    private javax.swing.JLabel lbl_doanhThu;
    private javax.swing.JLabel lbl_lai;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_ngay;
    private javax.swing.JRadioButton rd_thang;
    private javax.swing.JTable tb_spdtt;
    // End of variables declaration//GEN-END:variables
}
