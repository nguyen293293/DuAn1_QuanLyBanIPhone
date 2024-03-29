/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.services.impl.HoaDonService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Admin
 */
public class BieuDoThongKeDoanhThuThangTrongNamDialog extends javax.swing.JDialog {

    /**
     * Creates new form ThongK
     */
    public HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    private HoaDonService hoaDonService = new HoaDonService();

    private List<HoaDonViewModel> listhdvm = new ArrayList<>();

    private List<HoaDonChiTietViewModel> listhdctvm = new ArrayList<>();

    int year;

    public BieuDoThongKeDoanhThuThangTrongNamDialog(java.awt.Frame parent, boolean modal, int year) {

        super(parent, modal);
        this.year = year;
        initComponents();
        loadBieuDo(String.valueOf(this.year));
        this.setLocationRelativeTo(null);

    }

    public List<HoaDonViewModel> getListHoaDonThanhToan() {
        List<HoaDonViewModel> listOuput = new ArrayList<>();
        for (HoaDonViewModel x : hoaDonService.getList()) {
            if (x.getTrangthai() == 1) {
                listOuput.add(x);
            }
        }
        return listOuput;
    }

    public BigDecimal getTongTienGiaBantrong1HoaDon(HoaDonViewModel hdvm) {

        listhdctvm = hoaDonChiTietService.getList(hdvm.getMa());
        BigDecimal tongTien = new BigDecimal(0);
        for (HoaDonChiTietViewModel x : listhdctvm) {
            BigDecimal soLuong = BigDecimal.valueOf(x.getSoluong());
            tongTien = tongTien.add(soLuong.multiply(x.getDongia()));

        }
        return tongTien;
    }

    private BigDecimal doangThuThang(int thang) {

        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        BigDecimal tong1Thang = new BigDecimal(0);
        for (HoaDonViewModel x : getListHoaDonThanhToan()) {
            String yearHoaDon = String.valueOf(this.year);

            if (format3.format(x.getNgaythanhtoan()).compareTo(yearHoaDon) == 0 && format2.format(x.getNgaythanhtoan()).compareTo(String.valueOf(thang)) == 0) {
                tong1Thang = tong1Thang.add(getTongTienGiaBantrong1HoaDon(x));
            }
        }

        return tong1Thang;
    }

    private void loadBieuDo(String nam) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String str = "Doanh thu bán sản phẩm các tháng trong năm " + nam;
        dataset.addValue(doangThuThang(1), str, "1");
        dataset.addValue(doangThuThang(2), str, "2");
        dataset.addValue(doangThuThang(3), str, "3");
        dataset.addValue(doangThuThang(4), str, "4");
        dataset.addValue(doangThuThang(5), str, "5");
        dataset.addValue(doangThuThang(6), str, "6");
        dataset.addValue(doangThuThang(7), str, "7");
        dataset.addValue(doangThuThang(8), str, "8");
        dataset.addValue(doangThuThang(9), str, "9");
        dataset.addValue(doangThuThang(10), str, "10");
        dataset.addValue(doangThuThang(11), str, "11");
        dataset.addValue(doangThuThang(12), str, "12");
        System.out.println(doangThuThang(12));
        JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ THỐNG KÊ DOANH THU CÁC THÁNG TRONG NĂM  " + nam, "Tháng", "Tiền (VND)", dataset, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(pnbieudo.getWidth() - 10, pnbieudo.getHeight() - 10));
        pnbieudo.setLayout(new java.awt.BorderLayout());
        pnbieudo.add(chartPanel, BorderLayout.CENTER);
        pnbieudo.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnbieudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnbieudo.setBackground(new java.awt.Color(153, 153, 255));
        pnbieudo.setForeground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnbieudoLayout = new javax.swing.GroupLayout(pnbieudo);
        pnbieudo.setLayout(pnbieudoLayout);
        pnbieudoLayout.setHorizontalGroup(
            pnbieudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        pnbieudoLayout.setVerticalGroup(
            pnbieudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnbieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnbieudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuThangTrongNamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuThangTrongNamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuThangTrongNamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuThangTrongNamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BieuDoThongKeDoanhThuThangTrongNamDialog().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnbieudo;
    // End of variables declaration//GEN-END:variables
}
