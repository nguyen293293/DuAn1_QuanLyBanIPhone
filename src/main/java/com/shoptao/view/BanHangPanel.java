package com.shoptao.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.shoptao.services.BanHangService;
import com.shoptao.services.InterfaceImeiDaBanService;
import com.shoptao.services.impl.BanHangServiceImpl;
import com.shoptao.services.impl.ImeiDaBanService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import com.shoptao.viewmodel.KhachHangViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author nguyen293
 */
public class BanHangPanel extends javax.swing.JPanel implements Runnable, ThreadFactory {

    //webcam
    private WebcamPanel webcamPanel = null;
    private Webcam webcam = null;
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    //banhang
    private int indexHoaDon = -1;
    private int indexHoaDonChiTiet = -1;
    private int indexSanPham = -1;

    public String maHoaDon = null;

    private final BanHangService banHangService;
    private final InterfaceImeiDaBanService imeiDaBanService;

    private KhachHangViewModel khachHang;

    private List<HoaDonViewModel> listHoaDon = new ArrayList<>();
    private List<SanPhamViewModle> listSanPham = new ArrayList<>();
    public List<HoaDonChiTietViewModel> listHDCT = new ArrayList<>();

    public BanHangPanel() {
        initComponents();
//        initWebcam();

        this.banHangService = new BanHangServiceImpl();
        this.imeiDaBanService = new ImeiDaBanService();

        listHoaDon = banHangService.getListHoaDon();
        loadDataHoaDon(listHoaDon);

        listSanPham = banHangService.getListSanPham();
        loadDataSanPham(listSanPham);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMnuHDCT = new javax.swing.JPopupMenu();
        mnuThemOrXoa = new javax.swing.JMenuItem();
        mnuXoaTatCa = new javax.swing.JMenuItem();
        pnlHoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDonCho = new javax.swing.JTable();
        pnlChiTietHoaDon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChiTietHoaDon = new javax.swing.JTable();
        pnlSanPham = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        pnlThanhToan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnChonKhachHang = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnResfresh = new javax.swing.JButton();
        pnlWebcam = new javax.swing.JPanel();

        mnuThemOrXoa.setText("Thêm hoặc xóa");
        mnuThemOrXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThemOrXoaActionPerformed(evt);
            }
        });
        popupMnuHDCT.add(mnuThemOrXoa);

        mnuXoaTatCa.setText("Xóa tất cả");
        mnuXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuXoaTatCaActionPerformed(evt);
            }
        });
        popupMnuHDCT.add(mnuXoaTatCa);

        pnlHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        pnlHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbHoaDonCho.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tbHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Nhân viên", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoaDonCho.setRowHeight(24);
        tbHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDonCho);
        if (tbHoaDonCho.getColumnModel().getColumnCount() > 0) {
            tbHoaDonCho.getColumnModel().getColumn(0).setMaxWidth(55);
            tbHoaDonCho.getColumnModel().getColumn(1).setMinWidth(150);
            tbHoaDonCho.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlChiTietHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        pnlChiTietHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbChiTietHoaDon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tbChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChiTietHoaDon.setRowHeight(24);
        tbChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiTietHoaDonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbChiTietHoaDonMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbChiTietHoaDon);
        if (tbChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            tbChiTietHoaDon.getColumnModel().getColumn(0).setMaxWidth(55);
            tbChiTietHoaDon.getColumnModel().getColumn(1).setMinWidth(150);
            tbChiTietHoaDon.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        javax.swing.GroupLayout pnlChiTietHoaDonLayout = new javax.swing.GroupLayout(pnlChiTietHoaDon);
        pnlChiTietHoaDon.setLayout(pnlChiTietHoaDonLayout);
        pnlChiTietHoaDonLayout.setHorizontalGroup(
            pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlChiTietHoaDonLayout.setVerticalGroup(
            pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHoaDonLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSanPham.setBackground(new java.awt.Color(204, 255, 204));
        pnlSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbSanPham.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu sắc", "Dung lượng", "Năm BH", "Số lượng", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSanPham.setRowHeight(24);
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSanPham);
        if (tbSanPham.getColumnModel().getColumnCount() > 0) {
            tbSanPham.getColumnModel().getColumn(0).setMaxWidth(55);
            tbSanPham.getColumnModel().getColumn(1).setMinWidth(130);
            tbSanPham.getColumnModel().getColumn(1).setMaxWidth(130);
            tbSanPham.getColumnModel().getColumn(5).setMinWidth(65);
            tbSanPham.getColumnModel().getColumn(5).setMaxWidth(150);
            tbSanPham.getColumnModel().getColumn(6).setMinWidth(65);
            tbSanPham.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlThanhToan.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Tổng tiền");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Giảm giá");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Thanh toán");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Tiền khách đưa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Tiền thừa");

        lblMaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblGiamGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTienThua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnTaoHoaDon.setText("Tạo");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("VND");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("VND");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("VND");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("VND");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("VND");

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnResfresh.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnResfresh.setText("Refresh");
        btnResfresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResfreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThanhToanLayout = new javax.swing.GroupLayout(pnlThanhToan);
        pnlThanhToan.setLayout(pnlThanhToanLayout);
        pnlThanhToanLayout.setHorizontalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(27, 27, 27)
                                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17)))
                                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))))
                        .addContainerGap(33, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnResfresh))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        pnlThanhToanLayout.setVerticalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnTaoHoaDon)))
                .addGap(37, 37, 37)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnChonKhachHang)))
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(43, 43, 43)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel15))
                        .addComponent(jLabel4))
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5))
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel16))
                    .addComponent(lblThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel17))
                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnResfresh))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout pnlWebcamLayout = new javax.swing.GroupLayout(pnlWebcam);
        pnlWebcam.setLayout(pnlWebcamLayout);
        pnlWebcamLayout.setHorizontalGroup(
            pnlWebcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        pnlWebcamLayout.setVerticalGroup(
            pnlWebcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlWebcam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        ImeiBHDialog imeiBHDialog = new ImeiBHDialog();
        imeiBHDialog.removeAll(maHoaDon);
        
        listHDCT = banHangService.getListHDCT(maHoaDon);
        loadDataHoaDonChiTiet(listHDCT);
        
        listSanPham = banHangService.getListSanPham();
        loadDataSanPham(listSanPham);
        
        HoaDonViewModel hoaDon = new HoaDonViewModel();
        hoaDon.setMa(maHoaDon);
        hoaDon.setNgaythanhtoan(new Date());
        hoaDon.setTrangthai(2);

        
        if (banHangService.updateHoaDon(hoaDon, khachHang.getMa())) {
            DialogHelper.alert(null, "Đã hủy hóa đơn", "Thông báo");

            listHoaDon = banHangService.getListHoaDon();
            loadDataHoaDon(listHoaDon);

            return;
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tbHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonChoMouseClicked
        showHoaDon();

        int indexHoaDon = tbHoaDonCho.getSelectedRow();
        maHoaDon = (String) tbHoaDonCho.getValueAt(indexHoaDon, 1);

        listHDCT = banHangService.getListHDCT(tbHoaDonCho.getValueAt(indexHoaDon, 1) + "");
        loadDataHoaDonChiTiet(listHDCT);
    }//GEN-LAST:event_tbHoaDonChoMouseClicked

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int indexSanPham = tbSanPham.getSelectedRow();

        if (Integer.valueOf(tbSanPham.getValueAt(indexSanPham, 6) + "") <= 0) {
            return;
        }

        addImei(indexSanPham);
//        String idHDCT = banHangService.checkSPisEmpty(maHoaDon, indexSanPham);
//
//        if (idHDCT == null) {
//            idHDCT = UUID.randomUUID().toString();
//
//            System.out.println("BanHangPanel - 528 : new idHDCT : " + idHDCT);
//
//            HoaDonChiTietViewModel hdct = new HoaDonChiTietViewModel();
//            hdct.setId(idHDCT);
//            hdct.setMaSanPham(listSanPham.get(indexSanPham).getMa());
//            hdct.setSoluong(0);
//            hdct.setDongia(listSanPham.get(indexSanPham).getGiaban());
//
//            if (!banHangService.addHDCT(maHoaDon, hdct)) {
//                return;
//            }
//
//        }
//
//        listHDCT = banHangService.getListHDCT(tbHoaDonCho.getValueAt(indexHoaDon, 1) + "");
//
////        String idHDCT = listHDCT.get(listHDCT.size() - 1).getId();
//        SanPhamViewModle sanPham = banHangService.getListSanPham().get(indexSanPham);
//
//        ImeiBHDialog imeiBHDialog = new ImeiBHDialog(null, true, this, indexSanPham, idHDCT);
//        imeiBHDialog.setVisible(true);
    }//GEN-LAST:event_tbSanPhamMouseClicked

    public void addImei(int index) {

        String idHDCT = banHangService.checkSPisEmpty(maHoaDon, index);

        if (idHDCT == null) {
            idHDCT = UUID.randomUUID().toString();

            System.out.println("BanHangPanel - 528 : new idHDCT : " + idHDCT);

            HoaDonChiTietViewModel hdct = new HoaDonChiTietViewModel();
            hdct.setId(idHDCT);
            hdct.setMaSanPham(listSanPham.get(index).getMa());
            hdct.setSoluong(0);
            hdct.setDongia(listSanPham.get(index).getGiaban());

            if (!banHangService.addHDCT(maHoaDon, hdct)) {
                return;
            }

        }

        listHDCT = banHangService.getListHDCT(tbHoaDonCho.getValueAt(index, 1) + "");

//        String idHDCT = listHDCT.get(listHDCT.size() - 1).getId();
        SanPhamViewModle sanPham = banHangService.getListSanPham().get(index);

        ImeiBHDialog imeiBHDialog = new ImeiBHDialog(null, true, this, index, idHDCT);
        imeiBHDialog.setVisible(true);
    }

    private void tbChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbChiTietHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        HoaDonViewModel hoaDon = new HoaDonViewModel();
        hoaDon.setMa(lblMaHoaDon.getText());
        hoaDon.setNgaythanhtoan(new Date());
        hoaDon.setTrangthai(1);

        if (banHangService.updateHoaDon(hoaDon, khachHang.getMa())) {
            DialogHelper.alert(null, "Thanh toán thành công", "Thông báo");

            listHoaDon = banHangService.getListHoaDon();
            loadDataHoaDon(listHoaDon);

            return;
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnResfreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResfreshActionPerformed
        lblMaHoaDon.setText("");
        lblKhachHang.setText("");
        lblTongTien.setText("");
        lblGiamGia.setText("");
        lblTienThua.setText("");
        txtTienKhachDua.setText("");
        khachHang = null;
        listHoaDon = banHangService.getListHoaDon();
        loadDataHoaDon(listHoaDon);
    }//GEN-LAST:event_btnResfreshActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        HoaDonViewModel hoaDon = new HoaDonViewModel();
        hoaDon.setNgaytao(new Date());
        hoaDon.setNgaythanhtoan(new Date());

        String maNhanVien = "NV01";

        if (!banHangService.addHoaDon(hoaDon, maNhanVien, khachHang.getMa())) {
            DialogHelper.alert(null, "Lỗi tạo hoá đơn", "Lỗi");
        }

        listHoaDon = banHangService.getListHoaDon();
        loadDataHoaDon(listHoaDon);

        tbHoaDonCho.setRowSelectionInterval(listHoaDon.size() - 1, listHoaDon.size() - 1);
        showHoaDon();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        KhachHangDialog khachHangDialog = new KhachHangDialog(null, true);
        khachHangDialog.setVisible(true);

        if (khachHangDialog.btnXacNhanAction(evt) == null
                && khachHangDialog.getDefaultCloseOperation() == JFrame.DISPOSE_ON_CLOSE) {
            return;
        }

        khachHang = khachHangDialog.btnXacNhanAction(evt);

        lblKhachHang.setText(khachHang.getHoten());

    }//GEN-LAST:event_btnChonKhachHangActionPerformed

    private void tbChiTietHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietHoaDonMouseReleased
        Point point = evt.getPoint();
        int currentRow = tbChiTietHoaDon.rowAtPoint(point);
        if (currentRow < 0) {
            return;
        }
        tbChiTietHoaDon.setRowSelectionInterval(currentRow, currentRow);
        if (evt.isPopupTrigger()) {
            popupMnuHDCT.show(tbChiTietHoaDon, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbChiTietHoaDonMouseReleased

    private void mnuThemOrXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThemOrXoaActionPerformed
        int indexHDCT = tbChiTietHoaDon.getSelectedRow();
        String maSanPham = tbChiTietHoaDon.getValueAt(indexHDCT, 1).toString();
        int indexSP = getIndexSanPham(maSanPham);
        if (indexSP < 0) {
            return;
        }
        addImei(getIndexSanPham(maSanPham));
    }//GEN-LAST:event_mnuThemOrXoaActionPerformed

    private void mnuXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuXoaTatCaActionPerformed
        ImeiBHDialog imeiBHDialog = new ImeiBHDialog();
        imeiBHDialog.removeAll(maHoaDon);
        
        listHDCT = banHangService.getListHDCT(maHoaDon);
        loadDataHoaDonChiTiet(listHDCT);
        
        listSanPham = banHangService.getListSanPham();
        loadDataSanPham(listSanPham);
        
        
//        listHDCT = banHangService.getListHDCT(maHoaDon);
//        int indexSP = 0;
//        String idHDCT = null;
//        for (int i = 0; i < listHDCT.size(); i++) {
//            HoaDonChiTietViewModel get = listHDCT.get(i);
//            int indexHDCT = tbChiTietHoaDon.getSelectedRow();
//            idHDCT = get.getId();
//            String maSanPham = tbChiTietHoaDon.getValueAt(indexHDCT, 1).toString();
//            indexSP = getIndexSanPham(maSanPham);
//            if (indexSP < 0) {
//                return;
//            }
//            ImeiBHDialog imeiBHDialog = new ImeiBHDialog(null, true, this, indexSP, idHDCT);
//            imeiBHDialog.removeAll();
//        }
        
//        DialogHelper.alert(null, "Đang code ok?", "Thông báo");
    }//GEN-LAST:event_mnuXoaTatCaActionPerformed

    private int getIndexSanPham(String maSanPham) {
        listSanPham = banHangService.getListSanPham();
        for (int i = 0; i < listSanPham.size(); i++) {
            SanPhamViewModle get = listSanPham.get(i);
            if (get.getMa().equals(maSanPham)) {
                return i;
            }
        }
        return -1;
    }
    
    public void deleteAllHDCT(String maHoaDon){
        listHDCT = banHangService.getListHDCT(maHoaDon);
        for (HoaDonChiTietViewModel x : listHDCT) {
            imeiDaBanService.deleteByIdHDCT(x.getId());
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnResfresh;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JMenuItem mnuThemOrXoa;
    private javax.swing.JMenuItem mnuXoaTatCa;
    private javax.swing.JPanel pnlChiTietHoaDon;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JPanel pnlWebcam;
    private javax.swing.JPopupMenu popupMnuHDCT;
    private javax.swing.JTable tbChiTietHoaDon;
    private javax.swing.JTable tbHoaDonCho;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables

    private void loadDataHoaDon(List<HoaDonViewModel> listHoaDon) {
        DefaultTableModel tableModelHoaDon = (DefaultTableModel) tbHoaDonCho.getModel();
        tableModelHoaDon.setRowCount(0);
        for (HoaDonViewModel x : listHoaDon) {
            tableModelHoaDon.addRow(new Object[]{
                tbHoaDonCho.getRowCount() + 1, x.getMa(), x.getTenNhanVien(), x.getNgaytao()
            });
        }
    }

    public void loadDataSanPham(List<SanPhamViewModle> listSanPham) {
        DefaultTableModel tableModelSanPham = (DefaultTableModel) tbSanPham.getModel();
        tableModelSanPham.setRowCount(0);
        for (SanPhamViewModle x : listSanPham) {
            tableModelSanPham.addRow(new Object[]{
                tbSanPham.getRowCount() + 1, x.getMa(), x.getTen(), x.getTenmausac(),
                x.getDungluong(), x.getNambaohanh(), x.getSoluongton(), x.getGiaban()
            });
        }
    }

    public void loadDataHoaDonChiTiet(List<HoaDonChiTietViewModel> listHDCT) {
        DefaultTableModel tableModelSanPham = (DefaultTableModel) tbChiTietHoaDon.getModel();
        tableModelSanPham.setRowCount(0);
        for (HoaDonChiTietViewModel x : listHDCT) {
            tableModelSanPham.addRow(new Object[]{
                tbChiTietHoaDon.getRowCount() + 1, x.getMaSanPham(), x.getTenSanPham(),
                x.getSoluong(), x.getDongia(), x.getTongTien()
            });
        }
    }

    public void showHoaDon() {
        indexHoaDon = tbHoaDonCho.getSelectedRow();
        lblMaHoaDon.setText((String) tbHoaDonCho.getValueAt(indexHoaDon, 1));
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setPreferredSize(size);
        webcamPanel.setFPSDisplayed(true);

        pnlWebcam.setLayout(new AbsoluteLayout());
        pnlWebcam.add(webcamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 314, 220));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
            }

            if (result != null) {
                listSanPham = banHangService.getListSanPham();
                for (int i = 0; i < listSanPham.size(); i++) {
                    SanPhamViewModle get = listSanPham.get(i);
                    if (get.getBarcode().equals(result)) {
                        System.out.println(result + " - " + get.getBarcode());
                        addImei(i);
                    }
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
