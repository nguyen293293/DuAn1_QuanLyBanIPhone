/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.shoptao.view;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.services.impl.HoaDonChiTietService;
import com.shoptao.services.impl.HoaDonService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.awt.Point;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private SanPhamService sanPhamService = new SanPhamService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
    private ButtonGroup buttonGroup = new ButtonGroup();

    List<HoaDonViewModel> listhdvm = new ArrayList<>();
    List<HoaDonChiTietViewModel> listhdctvm = new ArrayList<>();
    List<HoaDonViewModel> listLocal = new ArrayList<>();
    List<Object[]> listThongKe = new ArrayList<>();
    
//    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

    int indexHoaDon;

    public ThongKePanel() {
        initComponents();
        
         
        
        listhdvm = hoaDonService.getList();
        listLocal = getListHoaDonThanhToanAndDaHuy(listhdvm);
        listThongKe = hoaDonChiTietService.getListThongKeSP();

        selectRD();

        loadDataThongKe(listThongKe);
//        showDetail(getListHoaDonThanhToanAndDaHuy(listhdvm));
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

    public void loadDataThongKe(List<Object[]> listInput) {
        defaultTableModel = (DefaultTableModel) tb_thongKe.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (int i = 0; i < listInput.size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            String tenDongSP = sanPhamService.getOnebyId(String.valueOf(row[3])).getTen();
            defaultTableModel.addRow(new Object[]{
                stt++,
                tenDongSP,
                row[0],
                row[1],});
        }
    }

    public List<HoaDonViewModel> getListHoaDonThanhToanAndDaHuy(List<HoaDonViewModel> listInput) {
        List<HoaDonViewModel> listOuput = new ArrayList<>();
        for (HoaDonViewModel x : listInput) {
            if (x.getTrangthai() == 1 || x.getTrangthai() == 2) {
                listOuput.add(x);
            }
        }
        return listOuput;
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

    public List<HoaDonViewModel> getListHoaDonDaHuy(List<HoaDonViewModel> listInput) {
        List<HoaDonViewModel> listOuput = new ArrayList<>();
        for (HoaDonViewModel x : listInput) {
            if (x.getTrangthai() == 2) {
                listOuput.add(x);
            }
        }
        return listOuput;
    }

    public int getSoLuongTrongHoaDon(HoaDonViewModel hdvm) {
        listhdctvm = hoaDonChiTietService.getList(hdvm.getMa());
        int soLuong = 0;
        for (HoaDonChiTietViewModel x : listhdctvm) {
            soLuong += x.getSoluong();

        }
        return soLuong;
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

    public BigDecimal getTongTienGiaNhaptrong1HoaDon(HoaDonViewModel hdvm) {

        listhdctvm = hoaDonChiTietService.getList(hdvm.getMa());
        BigDecimal tongTien = new BigDecimal(0);
        for (HoaDonChiTietViewModel x : listhdctvm) {
            BigDecimal soLuong = BigDecimal.valueOf(x.getSoluong());
            tongTien = tongTien.add(soLuong.multiply(x.getGianhap()));

        }
        return tongTien;
    }

    public void showDetail(List<HoaDonViewModel> listInput) {
        BigDecimal tongTienGiaBanHoaDon = new BigDecimal(0);
        BigDecimal tongTienGiaNhapHoaDon = new BigDecimal(0);
        for (HoaDonViewModel hoaDonViewModel : listInput) {
            if (hoaDonViewModel.getTrangthai() == 1) {
                tongTienGiaBanHoaDon = tongTienGiaBanHoaDon.add(getTongTienGiaBantrong1HoaDon(hoaDonViewModel));
                tongTienGiaNhapHoaDon = tongTienGiaNhapHoaDon.add(getTongTienGiaNhaptrong1HoaDon(hoaDonViewModel));
            }
        }
        lbl_doanhThu.setText(String.valueOf(tongTienGiaBanHoaDon) + "VND");
        lbl_lai.setText(String.valueOf(tongTienGiaBanHoaDon.subtract(tongTienGiaNhapHoaDon)) + "VND");
        lb_tongHoaDon.setText(String.valueOf(listInput.size()));
        lbl_dtt.setText(String.valueOf(getListHoaDonThanhToan(listInput).size()));
        lbl_dh.setText(String.valueOf(getListHoaDonDaHuy(listInput).size()));

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
    public BigDecimal tongTienNgayDonGia() {
        BigDecimal tongTien = new BigDecimal(0);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");

        int day = Integer.parseInt(sdf1.format(jdc_ngay.getDate()));
        int month = Integer.parseInt(sdf2.format(jdc_ngay.getDate()));
        int year = Integer.parseInt(sdf3.format(jdc_ngay.getDate()));

        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPDay(day, month, year, 1);
        for (int i = 0; i < hoaDonChiTietService.getListThongKeSPDay(day, month, year, 1).size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            BigDecimal tongTien1HD = (BigDecimal) row[1];
            tongTien = tongTien.add(tongTien1HD);
        }
        return tongTien;
    }

    public BigDecimal tongTienNgayGiaBan() {
        BigDecimal tongTien = new BigDecimal(0);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");

        int day = Integer.parseInt(sdf1.format(jdc_ngay.getDate()));
        int month = Integer.parseInt(sdf2.format(jdc_ngay.getDate()));
        int year = Integer.parseInt(sdf3.format(jdc_ngay.getDate()));
        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPDay(day, month, year, 1);
        for (int i = 0; i < hoaDonChiTietService.getListThongKeSPDay(day, month, year, 1).size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            BigDecimal tongTien1HD = (BigDecimal) row[2];
            tongTien = tongTien.add(tongTien1HD);
        }
        return tongTien;
    }

    public BigDecimal tongTienThangDonGia() {
        BigDecimal tongTien = new BigDecimal(0);
        int month = cb_month.getSelectedIndex() + 1;
        int year = jyc_year.getYear();
        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPMonth(month, year, 1);
        for (int i = 0; i < hoaDonChiTietService.getListThongKeSPMonth(month, year, 1).size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            BigDecimal tongTien1HD = (BigDecimal) row[1];
            tongTien = tongTien.add(tongTien1HD);
        }
        return tongTien;
    }

    public BigDecimal tongTienThangGiaBan() {
        BigDecimal tongTien = new BigDecimal(0);
        int month = cb_month.getSelectedIndex() + 1;
        int year = jyc_year.getYear();
        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPMonth(month, year, 1);
        for (int i = 0; i < hoaDonChiTietService.getListThongKeSPMonth(month, year, 1).size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            BigDecimal tongTien1HD = (BigDecimal) row[2];
            tongTien = tongTien.add(tongTien1HD);
        }
        return tongTien;
    }

    public BigDecimal tongTienNamDonGia() {
        BigDecimal tongTien = new BigDecimal(0);

        int year = jyc_year.getYear();
        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPYear(year, 1);
        for (int i = 0; i < hoaDonChiTietService.getListThongKeSPYear(year, 1).size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            BigDecimal tongTien1HD = (BigDecimal) row[1];
            tongTien = tongTien.add(tongTien1HD);
        }
        return tongTien;
    }

    public BigDecimal tongTienNamGiaBan() {
        BigDecimal tongTien = new BigDecimal(0);

        int year = jyc_year.getYear();
        List<Object[]> listInput = hoaDonChiTietService.getListThongKeSPYear(year, 1);
        for (int i = 0; i < hoaDonChiTietService.getListThongKeSPYear(year, 1).size(); i++) {
            Object[] row = (Object[]) listInput.get(i);
            BigDecimal tongTien1HD = (BigDecimal) row[2];
            tongTien = tongTien.add(tongTien1HD);
        }
        return tongTien;
    }
//    public BigDecimal tongGiaNhap(List<HoaDonChiTietViewModel> list) {
//        BigDecimal tien = new BigDecimal(0);
//        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : list) {
//            tien = tien.add(hoaDonChiTietViewModel.getGianhap().multiply(BigDecimal.valueOf(hoaDonChiTietViewModel.getSoluong())));
//        }
//
//        return tien;
//    }
//
//    public BigDecimal tongGiaBan(List<HoaDonChiTietViewModel> list) {
//        BigDecimal tien2 = new BigDecimal(0);
//        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : list) {
//            tien2 = tien2.add(hoaDonChiTietViewModel.getDongia());
//            tien2 = tien2.add(hoaDonChiTietViewModel.getTongTien());
//
//        }
//
//        return tien2;
//    }
//    
//    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public List<HoaDonViewModel> getTongHoaDonNgay() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");

        List<HoaDonViewModel> listOutput = new ArrayList<>();
        String day = sdf1.format(jdc_ngay.getDate());
        String month = sdf2.format(jdc_ngay.getDate());
        String year = sdf3.format(jdc_ngay.getDate());
        for (HoaDonViewModel x : hoaDonService.getList()) {
            if (sdf1.format(x.getNgaythanhtoan()).compareTo(day) == 0 && sdf2.format(x.getNgaythanhtoan()).compareTo(month) == 0 && sdf3.format(x.getNgaythanhtoan()).compareTo(year) == 0) {
                listOutput.add(x);
            }
        }
        return listOutput;
    }

    public List<HoaDonViewModel> getTongHoaDonNgayDaThanhToan() {

        List<HoaDonViewModel> listOutput = new ArrayList<>();

        for (HoaDonViewModel x : getTongHoaDonNgay()) {
            if (x.getTrangthai() == 1) {
                listOutput.add(x);
            }
        }
        return listOutput;
    }

    public List<HoaDonViewModel> getTongHoaDonThang() {
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        List<HoaDonViewModel> listOutput = new ArrayList<>();
        String month = String.valueOf(cb_month.getSelectedItem());
        String year = String.valueOf(jyc_year.getYear());
        for (HoaDonViewModel x : hoaDonService.getList()) {
            if (format2.format(x.getNgaythanhtoan()).compareTo(month) == 0 && format3.format(x.getNgaythanhtoan()).compareTo(year) == 0) {
                listOutput.add(x);
            }
        }
        return listOutput;
    }

    public List<HoaDonViewModel> getTongHoaDonThangDaThanhToan() {

        List<HoaDonViewModel> listOutput = new ArrayList<>();

        for (HoaDonViewModel x : getTongHoaDonThang()) {
            if (x.getTrangthai() == 1) {
                listOutput.add(x);
            }
        }
        return listOutput;
    }

    public List<HoaDonViewModel> getTongHoaDonNam() {
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        List<HoaDonViewModel> listOutput = new ArrayList<>();
        String year = String.valueOf(jyc_year.getYear());
        for (HoaDonViewModel x : hoaDonService.getList()) {
            if (format3.format(x.getNgaythanhtoan()).compareTo(year) == 0) {
                listOutput.add(x);
            }
        }
        return listOutput;
    }

    public List<HoaDonViewModel> getTongHoaDonNamDaThanhToan() {

        List<HoaDonViewModel> listOutput = new ArrayList<>();

        for (HoaDonViewModel x : getTongHoaDonNam()) {
            if (x.getTrangthai() == 1) {
                listOutput.add(x);
            }
        }
        return listOutput;
    }

    public Date getDate() throws ParseException {
        Date date = DateFormat.getDateInstance().parse("2017/11/09");
        return date;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_spdtt1 = new javax.swing.JTable();
        Hello = new javax.swing.JPopupMenu();
        XemChiTietHoaDon = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_lai = new javax.swing.JLabel();
        lbl_doanhThu = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_tongHoaDon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_thongKe = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rd_ngay = new javax.swing.JRadioButton();
        rd_thang = new javax.swing.JRadioButton();
        rd_nam = new javax.swing.JRadioButton();
        jdc_ngay = new com.toedter.calendar.JDateChooser();
        jyc_year = new com.toedter.calendar.JYearChooser();
        cb_month = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_dh = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_dtt = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_sanPham = new javax.swing.JButton();
        btn_doanhThu = new javax.swing.JButton();
        btn_sanPham1 = new javax.swing.JButton();
        btn_doanhThu1 = new javax.swing.JButton();

        tb_spdtt1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tb_spdtt1.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_spdtt1.setRowHeight(25);
        tb_spdtt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_spdtt1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_spdtt1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        XemChiTietHoaDon.setText("XemChiTiet");
        XemChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XemChiTietHoaDonActionPerformed(evt);
            }
        });
        Hello.add(XemChiTietHoaDon);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Doanh thu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Lãi");

        lbl_lai.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_lai.setText("      0 VND");

        lbl_doanhThu.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_doanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_doanhThu.setText("0 VND");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(lbl_lai, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addComponent(lbl_doanhThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(lbl_lai)
                .addGap(26, 26, 26))
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
                        .addGap(43, 43, 43)
                        .addComponent(lb_tongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(lb_tongHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tb_thongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên dòng sản phẩm", "Số lượng", "Tổng tiền"
            }
        ));
        jScrollPane3.setViewportView(tb_thongKe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1520, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3582, 3582, 3582)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
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

        jdc_ngay.setDateFormatString("yyyy-MM-dd");
        jdc_ngay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jdc_ngay.setMaxSelectableDate(new java.util.Date(253370743302000L));

        cb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_ngay)
                    .addComponent(rd_thang)
                    .addComponent(rd_nam))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdc_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(cb_month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jyc_year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_ngay)
                    .addComponent(jdc_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_thang)
                    .addComponent(cb_month, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rd_nam)
                    .addComponent(jyc_year, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setText("Đã thanh toán");

        lbl_dh.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_dh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dh.setText("7");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("Đã hủy");

        lbl_dtt.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_dtt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dtt.setText("13");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_dtt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_dh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_dtt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_dh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));

        btn_sanPham.setBackground(new java.awt.Color(204, 255, 204));
        btn_sanPham.setText("Dòng sản phẩm năm");
        btn_sanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanPhamActionPerformed(evt);
            }
        });

        btn_doanhThu.setBackground(new java.awt.Color(204, 255, 204));
        btn_doanhThu.setText("Doanh thu tháng ");
        btn_doanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doanhThuActionPerformed(evt);
            }
        });

        btn_sanPham1.setBackground(new java.awt.Color(204, 255, 204));
        btn_sanPham1.setText("Dòng sản phẩm tháng");
        btn_sanPham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanPham1ActionPerformed(evt);
            }
        });

        btn_doanhThu1.setBackground(new java.awt.Color(204, 255, 204));
        btn_doanhThu1.setText("Doanh thu năm");
        btn_doanhThu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doanhThu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sanPham1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_doanhThu1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btn_doanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addGap(9, 9, 9)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_doanhThu1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_sanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(btn_doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(194, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(120, 120, 120))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rd_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ngayActionPerformed
        BigDecimal tongTien = new BigDecimal(0);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");

        int day = Integer.parseInt(sdf1.format(jdc_ngay.getDate()));
        int month = Integer.parseInt(sdf2.format(jdc_ngay.getDate()));
        int year = Integer.parseInt(sdf3.format(jdc_ngay.getDate()));

        loadDataThongKe(hoaDonChiTietService.getListThongKeSPDay(day, month, year, 1));
        String lai = String.valueOf(tongTienNgayDonGia().subtract(tongTienNgayGiaBan()));
        String tongTienNgayDonGia = String.valueOf(tongTienNgayDonGia());
        lbl_doanhThu.setText((tongTienNgayDonGia) + "VND");
        lbl_lai.setText((lai) + "VND");
        lb_tongHoaDon.setText(String.valueOf((getTongHoaDonNgay().size())));
        lbl_dtt.setText(String.valueOf(getTongHoaDonNgayDaThanhToan().size()));
        String daHuy = String.valueOf(getTongHoaDonNgay().size() - getTongHoaDonNgayDaThanhToan().size());
        lbl_dh.setText(daHuy);


    }//GEN-LAST:event_rd_ngayActionPerformed

    private void rd_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_thangActionPerformed

        int month = cb_month.getSelectedIndex() + 1;
        int year = jyc_year.getYear();

        loadDataThongKe(hoaDonChiTietService.getListThongKeSPMonth(month, year, 1));
        String lai = String.valueOf(tongTienThangDonGia().subtract(tongTienThangGiaBan()));
        String tongTienThangDonGia = String.valueOf(tongTienThangDonGia());
        lbl_doanhThu.setText((tongTienThangDonGia) + "VND");
        lbl_lai.setText((lai) + "VND");
        lb_tongHoaDon.setText(String.valueOf(getTongHoaDonThang().size()));
        lbl_dtt.setText(String.valueOf(getTongHoaDonThangDaThanhToan().size()));
        String daHuy = String.valueOf(getTongHoaDonThang().size() - getTongHoaDonThangDaThanhToan().size());
        lbl_dh.setText(daHuy);

    }//GEN-LAST:event_rd_thangActionPerformed

    private void rd_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_namActionPerformed

        int year = jyc_year.getYear();

        loadDataThongKe(hoaDonChiTietService.getListThongKeSPYear(year, 1));

        String lai = String.valueOf(tongTienNamDonGia().subtract(tongTienNamGiaBan()));
        String tongTienNamDonGia = String.valueOf(tongTienNamDonGia());
        lbl_doanhThu.setText((tongTienNamDonGia) + "VND");
        lbl_lai.setText((lai) + "VND");
        lb_tongHoaDon.setText(String.valueOf(getTongHoaDonNam().size()));
        lbl_dtt.setText(String.valueOf(getTongHoaDonNamDaThanhToan().size()));
        String daHuy = String.valueOf(getTongHoaDonNam().size() - getTongHoaDonNamDaThanhToan().size());
        lbl_dh.setText(daHuy);

    }//GEN-LAST:event_rd_namActionPerformed

    private void tb_spdtt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_spdtt1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_spdtt1MouseClicked

    private void XemChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XemChiTietHoaDonActionPerformed
        // TODO add your handling code here:

        HoaDonViewModel hdvm = getListHoaDonThanhToanAndDaHuy(hoaDonService.getList()).get(indexHoaDon);
        HoaDonChiTietDialog hoaDonChiTietDialog = new HoaDonChiTietDialog(null, true, hdvm);
        hoaDonChiTietDialog.setVisible(true);
    }//GEN-LAST:event_XemChiTietHoaDonActionPerformed

    private void btn_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPhamActionPerformed
        // TODO add your handling code here:
        BieuDoThongKeDSPNamDialog bdtkdspd = new BieuDoThongKeDSPNamDialog(null, true, jyc_year.getYear());
        bdtkdspd.setVisible(true);
    }//GEN-LAST:event_btn_sanPhamActionPerformed

    private void btn_doanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doanhThuActionPerformed
        // TODO add your handling code here:
        BieuDoThongKeDoanhThuNamDialog bdtkdtd = new BieuDoThongKeDoanhThuNamDialog(null, true, jyc_year.getYear());
        bdtkdtd.setVisible(true);

    }//GEN-LAST:event_btn_doanhThuActionPerformed

    private void btn_sanPham1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPham1ActionPerformed
        // TODO add your handling code here:
        BieuDoThongKeDSPThangDialog bdtkdsptd = new BieuDoThongKeDSPThangDialog(null, true, cb_month.getSelectedIndex() + 1, jyc_year.getYear());
        System.out.println(cb_month.getSelectedIndex() + 1);
        bdtkdsptd.setVisible(true);
    }//GEN-LAST:event_btn_sanPham1ActionPerformed

    private void btn_doanhThu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doanhThu1ActionPerformed
        // TODO add your handling code here:
        BieuDoThongKeDoanhThu10NamDialog bdtkdtnd = new BieuDoThongKeDoanhThu10NamDialog(null, true, jyc_year.getYear());
        bdtkdtnd.setVisible(true);

    }//GEN-LAST:event_btn_doanhThu1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Hello;
    private javax.swing.JMenuItem XemChiTietHoaDon;
    private javax.swing.JButton btn_doanhThu;
    private javax.swing.JButton btn_doanhThu1;
    private javax.swing.JButton btn_sanPham;
    private javax.swing.JButton btn_sanPham1;
    private javax.swing.JComboBox<String> cb_month;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdc_ngay;
    private com.toedter.calendar.JYearChooser jyc_year;
    private javax.swing.JLabel lb_tongHoaDon;
    private javax.swing.JLabel lbl_dh;
    private javax.swing.JLabel lbl_doanhThu;
    private javax.swing.JLabel lbl_dtt;
    private javax.swing.JLabel lbl_lai;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_ngay;
    private javax.swing.JRadioButton rd_thang;
    private javax.swing.JTable tb_spdtt1;
    private javax.swing.JTable tb_thongKe;
    // End of variables declaration//GEN-END:variables
}
