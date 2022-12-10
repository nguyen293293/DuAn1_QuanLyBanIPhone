/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.services.impl.HoaDonService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Admin
 */
public class BieuDoThongKeDSPNamDialog extends javax.swing.JDialog {

    /**
     * Creates new form ThongK
     */
    public HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    private HoaDonService hoaDonService = new HoaDonService();
    private SanPhamService sanPhamService = new SanPhamService();

    private List<HoaDonViewModel> listhdvm = new ArrayList<>();

    private List<HoaDonChiTietViewModel> listhdctvm = new ArrayList<>();

    int year;

    public BieuDoThongKeDSPNamDialog(java.awt.Frame parent, boolean modal,int year) {

        super(parent, modal);
        this.year = year;

        initComponents();
        loadBieuDo(String.valueOf(this.year));
        this.setLocationRelativeTo(null);

    }

    public List<HoaDonViewModel> getListHoaDonThanhToan(List<HoaDonViewModel> listInput) {
        List<HoaDonViewModel> listOuput = new ArrayList<>();
        for (HoaDonViewModel x : listInput) {
            if (x.getTrangthai() == 1) {
                listOuput.add(x);
            }
        }
        return listOuput;
    }

//    public List<Object[]> getTenDSP() {
//        List<Object[]> listOutput = new ArrayList<>();
//        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPYear(year, 1);
//
//        for (int i = 0; i < listInput.size(); i++) {
//            Object[] row = (Object[]) listInput.get(i);
//            listOutput.add(row);
//
//        }
//        return listOutput;
//    }
//
//    public List<Integer> getSoLuongDSP() {
//        List<Integer> listOutput = new ArrayList<>();
//        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPMonth(month, year, 1);
//
//        for (int i = 0; i < listInput.size(); i++) {
//            Object[] row = (Object[]) listInput.get(i);
//
//            listOutput.add(Integer.parseInt((String) row[0]));
//        }
//        return listOutput;
//    }

    private void loadBieuDo(String nam) {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPYear(year, 1);

        for (int i = 0; i < listInput.size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            String tenDongSP = sanPhamService.getOnebyId(String.valueOf(row[3])).getTen();
            pieDataset.setValue(tenDongSP, (Number) row[0]);
        }
        JFreeChart barChart = ChartFactory.createPieChart3D("Biểu đồ thống kê dòng sản phẩm năm "+nam, pieDataset, true, true, true);
        PiePlot3D plot = (PiePlot3D) barChart.getPlot();
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
            .addGap(0, 807, Short.MAX_VALUE)
        );
        pnbieudoLayout.setVerticalGroup(
            pnbieudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnbieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnbieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
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
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BieuDoThongKeDoanhThuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BieuDoThongKeDoanhThuDialog().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnbieudo;
    // End of variables declaration//GEN-END:variables
}
