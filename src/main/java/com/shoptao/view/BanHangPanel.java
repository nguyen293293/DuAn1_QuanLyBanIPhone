package com.shoptao.view;

import com.shoptao.domainmodel.KhuyenMai;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.BanHangService;
import com.shoptao.services.InterfaceImeiDaBanService;
import com.shoptao.services.impl.BanHangServiceImpl;
import com.shoptao.services.impl.ImeiDaBanService;
import com.shoptao.services.impl.KhachHangService;
import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.JasperReports;
import com.shoptao.utilities.UserHelper;
import com.shoptao.viewmodel.HDCTBanHangViewModel;
import com.shoptao.viewmodel.HoaDonBanHangViewModel;
import com.shoptao.viewmodel.KhachHangViewModel;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamBanHangViewModel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author nguyen293
 */
public class BanHangPanel extends javax.swing.JPanel{
    
    private int indexHoaDon = -1;
    private int indexHoaDonChiTiet = -1;
    private int indexSanPham = -1;

    public String maHoaDon = null;

    private final BanHangService banHangService;
    private final InterfaceImeiDaBanService imeiDaBanService;
    private final KhuyenMaiService khuyenMaiService;

    private KhachHangViewModel khachHang;

    private List<HoaDonBanHangViewModel> listHoaDon = new ArrayList<>();
    private List<SanPhamBanHangViewModel> listSanPham = new ArrayList<>();
    public List<HDCTBanHangViewModel> listHDCT = new ArrayList<>();

    private DefaultTableModel tableModelHoaDon;
    private DefaultTableModel tableModelSanPham;
    private DefaultTableModel tableModelCTHD;
    
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

    private BigDecimal tongTien = BigDecimal.ZERO;
    private BigDecimal tienThanhToan = BigDecimal.ZERO;
    private BigDecimal giamGia = BigDecimal.ZERO;
    
    public BanHangPanel() {
        initComponents();
        init();

        this.banHangService = new BanHangServiceImpl();
        this.imeiDaBanService = new ImeiDaBanService();
        this.khuyenMaiService = new KhuyenMaiService();

        listHoaDon = banHangService.getListHoaDon();
        loadDataHoaDon(listHoaDon);

        listSanPham = banHangService.getListSanPham();
        loadDataSanPham(listSanPham);
    }

    public void init() {
        txtTienKhachDua.setOpaque(false);
        txtTienKhachDua.setBorder(null);

        btnThanhToan.setEnabled(false);
        btnHuy.setEnabled(false);

        khachHang = new KhachHangService().getOne("KH00");
        lblKhachHang.setText(khachHang.getHoten());
        
        loadCBBKhuyenMai(BigDecimal.ZERO);
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
        txtBarcode = new javax.swing.JTextField();
        pnlSanPham = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        txtSearchSanPham = new javax.swing.JTextField();
        pnlThanhToan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnChonKhachHang = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLoiTien = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblTongTien1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboKhuyenMai = new javax.swing.JComboBox<>();

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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlChiTietHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        pnlChiTietHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbChiTietHoaDon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tbChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"
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

        txtBarcode.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlChiTietHoaDonLayout = new javax.swing.GroupLayout(pnlChiTietHoaDon);
        pnlChiTietHoaDon.setLayout(pnlChiTietHoaDonLayout);
        pnlChiTietHoaDonLayout.setHorizontalGroup(
            pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                    .addGroup(pnlChiTietHoaDonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlChiTietHoaDonLayout.setVerticalGroup(
            pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBarcode))
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
            tbSanPham.getColumnModel().getColumn(4).setMinWidth(100);
            tbSanPham.getColumnModel().getColumn(4).setMaxWidth(100);
            tbSanPham.getColumnModel().getColumn(5).setMinWidth(65);
            tbSanPham.getColumnModel().getColumn(5).setMaxWidth(150);
            tbSanPham.getColumnModel().getColumn(6).setMinWidth(65);
            tbSanPham.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        txtSearchSanPham.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtSearchSanPham.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchSanPhamCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pnlThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tổng tiền");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Thanh toán");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Tiền khách đưa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Tiền thừa");

        lblMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(0, 102, 204));
        lblMaHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(0, 102, 204));
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhachHang.setOpaque(true);

        lblTongTien.setBackground(new java.awt.Color(204, 255, 204));
        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTongTien.setText("0");
        lblTongTien.setOpaque(true);

        lblThanhToan.setBackground(new java.awt.Color(204, 255, 204));
        lblThanhToan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblThanhToan.setText("0");
        lblThanhToan.setOpaque(true);

        lblTienThua.setBackground(new java.awt.Color(204, 255, 204));
        lblTienThua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTienThua.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTienThua.setText("0");
        lblTienThua.setOpaque(true);

        btnTaoHoaDon.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setToolTipText("");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnChonKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel14.setText("VND");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel16.setText("VND");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel17.setText("VND");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel18.setText("VND");

        txtTienKhachDua.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtTienKhachDua.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHuy.setText("Hủy hóa đơn");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("Hóa đơn");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        lblLoiTien.setForeground(new java.awt.Color(255, 51, 0));
        lblLoiTien.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Giảm giá");

        lblTongTien1.setBackground(new java.awt.Color(204, 255, 204));
        lblTongTien1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTongTien1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTongTien1.setText("0");
        lblTongTien1.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel15.setText("VND");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Khuyến mãi");

        cboKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cboKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKhuyenMaiItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlThanhToanLayout = new javax.swing.GroupLayout(pnlThanhToan);
        pnlThanhToan.setLayout(pnlThanhToanLayout);
        pnlThanhToanLayout.setHorizontalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addComponent(btnTaoHoaDon)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(cboKhuyenMai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongTien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(32, 32, 32))
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLoiTien, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(31, 31, 31))))
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7))
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel8)
                            .addGap(38, 38, 38)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4))))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        pnlThanhToanLayout.setVerticalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnChonKhachHang)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTien1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblLoiTien, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(48, 48, 48)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuy)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(pnlChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        ImeiBHDialog imeiBHDialog = new ImeiBHDialog();
        imeiBHDialog.removeAll(maHoaDon);

        listHDCT = banHangService.getListHDCT(maHoaDon);
        loadDataHoaDonChiTiet(listHDCT);

        listSanPham = banHangService.getListSanPham();
        loadDataSanPham(listSanPham);

        HoaDonBanHangViewModel hoaDon = new HoaDonBanHangViewModel();
        hoaDon.setMahoadon(maHoaDon);
        hoaDon.setTrangthai(2);

        if (banHangService.updateHoaDon(hoaDon, khachHang.getMa(), null)) {
            DialogHelper.alert(null, "Đã hủy hóa đơn", "Thông báo");
            listHoaDon = banHangService.getListHoaDon();
            loadDataHoaDon(listHoaDon);
            clearForm();

            maHoaDon = null;
            tbChiTietHoaDon.removeAll();
            return;
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tbHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonChoMouseClicked
        showHoaDon();

        int indexHoaDon = tbHoaDonCho.getSelectedRow();
        maHoaDon = (String) tbHoaDonCho.getValueAt(indexHoaDon, 1);

        btnHuy.setEnabled(true);

        listHDCT = banHangService.getListHDCT(maHoaDon);
        loadDataHoaDonChiTiet(listHDCT);
        
        loadCBBKhuyenMai(tinhTongTien(listHDCT));
    }//GEN-LAST:event_tbHoaDonChoMouseClicked

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int indexSanPham = tbSanPham.getSelectedRow();

        if (maHoaDon == null) {
            return;
        }

        if (Integer.valueOf(tbSanPham.getValueAt(indexSanPham, 6) + "") <= 0) {
            return;
        }
        addImei(tbSanPham.getValueAt(indexSanPham, 1)+"");
    }//GEN-LAST:event_tbSanPhamMouseClicked

    public void addImei(String maSanPham) {
        SanPhamBanHangViewModel sanPham = banHangService.getOneSanPham(maSanPham);
        SanPham sanPhamDM = new SanPhamRepository().getOne(maSanPham);
        if(sanPhamDM.getTrangthai() != 1){
            DialogHelper.alert(null, "Sản phẩm đã ngừng bán", "Thông báo");
            return;
        }
        if(sanPham.getSoluong() <= 0){
            DialogHelper.alert(null, "Sản phẩm đã hết", "Thông báo");
            return;
        }
        
        String idHDCT = banHangService.checkSPisEmpty(maHoaDon, maSanPham);
       
        if (idHDCT == null) {
            idHDCT = UUID.randomUUID().toString();

            HDCTBanHangViewModel hdct = new HDCTBanHangViewModel();
            hdct.setId(idHDCT);
            hdct.setMasanpham(maSanPham);
            hdct.setSoluong(0);
            hdct.setDongia(sanPham.getGiaban());
            if (!banHangService.addHDCT(maHoaDon, hdct)) {
                return;
            }
        }
        listHDCT = banHangService.getListHDCT(maHoaDon);

        ImeiBanHangDialog imeiBHDialog = new ImeiBanHangDialog(null, true, this, maSanPham, idHDCT);
        imeiBHDialog.setVisible(true);
    }

    private void tbChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbChiTietHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        HoaDonBanHangViewModel hoaDon = new HoaDonBanHangViewModel();
        hoaDon.setMahoadon(lblMaHoaDon.getText());
        hoaDon.setTrangthai(1);
        hoaDon.setTongtien(tinhTongTien(listHDCT));
        hoaDon.setTienkhachdua(BigDecimal.valueOf(Double.valueOf(txtTienKhachDua.getText())));
        
        KhuyenMai khuyenmai = (KhuyenMai) cboKhuyenMai.getSelectedItem();
        
        if (banHangService.updateHoaDon(hoaDon, khachHang.getMa(), khuyenmai.getMa())) {
            DialogHelper.alert(null, "Thanh toán thành công", "Thông báo");

            listHoaDon = banHangService.getListHoaDon();
            loadDataHoaDon(listHoaDon);
            clearForm();

            tableModelCTHD.setRowCount(0);
            setTTImei();
            
            JasperReports.exportToPdf(maHoaDon);
            maHoaDon = null;
            return;
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void setTTImei(){
        for (HDCTBanHangViewModel hDCT : listHDCT) {
            ImeiBanHangDialog imeiBHDialog = new ImeiBanHangDialog(null,
                    true, this, hDCT.getMasanpham(), hDCT.getId());
            imeiBHDialog.setTrangThaiImei();
        }
    }
    
    private BigDecimal tinhTongTien(List<HDCTBanHangViewModel> listHDCT) {
        BigDecimal tongTien = BigDecimal.valueOf(0);
        listHDCT = banHangService.getListHDCT(maHoaDon);
        for (HDCTBanHangViewModel x : listHDCT) {
            tongTien = tongTien.add(x.getThanhtien());
        }
        return tongTien;
    }

    private void setTientoForm(List<HDCTBanHangViewModel> listHDCT) {
        tongTien = tinhTongTien(listHDCT);
        tienThanhToan = tinhTongTien(listHDCT) - giamGia;
        lblTongTien.setText(decimalFormat.format(tinhTongTien(listHDCT)));
        lblThanhToan.setText(decimalFormat.format(tinhTongTien(listHDCT)));
        loadCBBKhuyenMai(tinhTongTien(listHDCT));
    }

    private void setTienThua(BigDecimal thanhToan, String tienKhach) {
        BigDecimal tienKhachDua = BigDecimal.valueOf(Double.parseDouble(tienKhach));
        if (tienKhachDua.compareTo(thanhToan) < 0) {
            btnThanhToan.setEnabled(false);
        } else {
            lblTienThua.setText(decimalFormat.format(tienKhachDua.subtract(thanhToan)));
            lblLoiTien.setText("");
            btnThanhToan.setEnabled(true);
        }
    }

    private void checkTienKhachDua(String tienKhach) {
        try {
            lblLoiTien.setText("");
            btnThanhToan.setEnabled(true);
            double tienKhachDua = Double.parseDouble(tienKhach);
            if (tienKhachDua < 0) {
                lblLoiTien.setText("Lỗi nhập số tiền!");
                txtTienKhachDua.requestFocus();
                btnThanhToan.setEnabled(false);
            } else {
                lblLoiTien.setText("");
                btnThanhToan.setEnabled(true);
            }
        } catch (Exception e) {
            lblLoiTien.setText("Lỗi nhập số tiền!");
            txtTienKhachDua.requestFocus();
            btnThanhToan.setEnabled(false);
        }
    }

    private void clearForm() {
        lblMaHoaDon.setText("");
        lblKhachHang.setText("");
        lblTongTien.setText("0");
        lblTienThua.setText("0");
        txtTienKhachDua.setText("0");
        lblThanhToan.setText("");
        khachHang = new KhachHangService().getOne("KH00");
        lblKhachHang.setText(khachHang.getHoten());
        listHoaDon = banHangService.getListHoaDon();
        loadDataHoaDon(listHoaDon);
    }

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        HoaDonBanHangViewModel hoaDon = new HoaDonBanHangViewModel();
        hoaDon.setNgaytao(new Date());

        String maNhanVien = UserHelper.USER.getMa();

        if (!banHangService.addHoaDon(hoaDon, maNhanVien, khachHang.getMa())) {
            DialogHelper.alert(null, "Lỗi tạo hoá đơn", "Lỗi");
        }

        listHoaDon = banHangService.getListHoaDon();
        loadDataHoaDon(listHoaDon);

        tbHoaDonCho.setRowSelectionInterval(0, 0);
        showHoaDon();
        
        maHoaDon = lblMaHoaDon.getText().trim();

        btnHuy.setEnabled(true);
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
//        int indexSP = getIndexSanPham(maSanPham);
    if (maSanPham.isEmpty()) {
            return;
        }
        addImei(maSanPham);
    }//GEN-LAST:event_mnuThemOrXoaActionPerformed

    private void mnuXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuXoaTatCaActionPerformed
        ImeiBHDialog imeiBHDialog = new ImeiBHDialog();
        imeiBHDialog.removeAll(maHoaDon);

        listHDCT = banHangService.getListHDCT(maHoaDon);
        loadDataHoaDonChiTiet(listHDCT);

        listSanPham = banHangService.getListSanPham();
        loadDataSanPham(listSanPham);
    }//GEN-LAST:event_mnuXoaTatCaActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        if (maHoaDon.isEmpty()) {
            return;
        }

        if (banHangService.getListHDCT(maHoaDon).isEmpty()) {
            return;
        }

        String tienKhach = txtTienKhachDua.getText();
        if (tienKhach.isEmpty()) {
            lblLoiTien.setText("");
            lblTienThua.setText("0");
//            btnThanhToan.setEnabled(false);
            return;
        }
        checkTienKhachDua(tienKhach);
        setTienThua(tinhTongTien(banHangService.getListHDCT(maHoaDon)), tienKhach);
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtSearchSanPhamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchSanPhamCaretUpdate
        String ten = txtSearchSanPham.getText();
        listSanPham = banHangService.searchSanPham(ten);
        loadDataSanPham(listSanPham);
    }//GEN-LAST:event_txtSearchSanPhamCaretUpdate

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        String barcode = txtBarcode.getText();
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            SanPhamBanHangViewModel sanPham = banHangService.getSanPhambyBarcode(barcode);
            addImei(sanPham.getMasanpham());
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void cboKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKhuyenMaiItemStateChanged
        if(cboKhuyenMai.getSelectedIndex() == 0) return;
        String maKhuyenMai = cboKhuyenMai.getSelectedItem().toString().substring(0, 5);
        KhuyenMaiViewModle khuyenMai = khuyenMaiService.getOne(maKhuyenMai);
        
    }//GEN-LAST:event_cboKhuyenMaiItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cboKhuyenMai;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblLoiTien;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTien1;
    private javax.swing.JMenuItem mnuThemOrXoa;
    private javax.swing.JMenuItem mnuXoaTatCa;
    private javax.swing.JPanel pnlChiTietHoaDon;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JPopupMenu popupMnuHDCT;
    private javax.swing.JTable tbChiTietHoaDon;
    private javax.swing.JTable tbHoaDonCho;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtSearchSanPham;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables

    private void loadDataHoaDon(List<HoaDonBanHangViewModel> listHoaDon) {
        tableModelHoaDon = (DefaultTableModel) tbHoaDonCho.getModel();
        tableModelHoaDon.setRowCount(0);
        for (HoaDonBanHangViewModel x : listHoaDon) {
            tableModelHoaDon.addRow(x.toDataRow(tbHoaDonCho));
        }
        btnHuy.setEnabled(false);
    }

    public void loadDataSanPham(List<SanPhamBanHangViewModel> listSanPham) {
        tableModelSanPham = (DefaultTableModel) tbSanPham.getModel();
        tableModelSanPham.setRowCount(0);
        for (SanPhamBanHangViewModel x : listSanPham) {
            if (x.getSoluong() > 0) {
                tableModelSanPham.addRow(x.toDataRow(tbSanPham));
            }

        }
    }
    
    public void loadDataHoaDonChiTiet(List<HDCTBanHangViewModel> listHDCT) {
        tableModelCTHD = (DefaultTableModel) tbChiTietHoaDon.getModel();
        tableModelCTHD.setRowCount(0);
        for (HDCTBanHangViewModel x : listHDCT) {
            if(x.getSoluong() > 0){
                tableModelCTHD.addRow(x.toDataRow(tbChiTietHoaDon));
            }
        }
        if (!listHDCT.isEmpty()) {
            setTientoForm(listHDCT);
        } else {
            lblTongTien.setText("0");
            lblThanhToan.setText("0");
        }
    }

    public void showHoaDon() {
        indexHoaDon = tbHoaDonCho.getSelectedRow();
        lblMaHoaDon.setText((String) tbHoaDonCho.getValueAt(indexHoaDon, 1));
    }

    private void loadCBBKhuyenMai(BigDecimal tongTien){
        cboKhuyenMai.removeAllItems();
        cboKhuyenMai.addItem("--Chọn khuyến mãi--");
        for (KhuyenMaiViewModle x : new KhuyenMaiService().getList()) {
            if(tongTien.compareTo(BigDecimal.valueOf(Double.valueOf(x.getDieukiengiamgia()))) >= 0){
                String item = x.getMa() + " - " + x.getGiatri() 
                        + (x.getHinhthucgiamgia() == 0 ? "VND" : "%")
                        + "(>= " + x.getDieukiengiamgia() + "VND)";
                cboKhuyenMai.addItem(item);
            }else{
                cboKhuyenMai.removeItem(x);
            }
        }
    }
}
