package com.shoptao.view;

import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.impl.DongSanPhamService;
import com.shoptao.services.impl.MauSacService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.utilities.ImageHelper;
import com.shoptao.viewmodel.DongSanPhamViewModle;
import com.shoptao.viewmodel.MauSacViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haih7
 */
public class SanPhamPanel extends javax.swing.JPanel {

    public SanPhamService sanPhamService = new SanPhamService();
    public DongSanPhamService dongSanPhamService = new DongSanPhamService();
    public MauSacService mauSacService = new MauSacService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
    private ButtonGroup buttonGroup = new ButtonGroup();

    private byte[] ImageByte;
    List<MauSacViewModel> listMSVM = new ArrayList<>();
//    List<KhuyViewModel> list;
    List<DongSanPhamViewModle> listDSPVM = new ArrayList<>();
    List<SanPhamViewModle> listSPVM = new ArrayList<>();
    int indexsp;

    public SanPhamPanel() {
        initComponents();
        init();
        selectRD();

        listMSVM = mauSacService.getList();
        listDSPVM = dongSanPhamService.getList();
        listSPVM = sanPhamService.getList();

        loadData(listSPVM);
        loadCBMauSac(listMSVM);
        loadCBDongSanPham(listDSPVM);

    }

    private void init() {

        JButton btns[] = {btnEditDongSP, btnEditMauSac};
        for (JButton btn : btns) {
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
        }

        rd_dangBan.setOpaque(false);
        rd_ngungBan.setOpaque(false);

        txtSeacrch.setOpaque(false);

    }

    public void selectRD() {
        buttonGroup.add(rd_dangBan);
        buttonGroup.add(rd_ngungBan);
    }

    public void loadData(List<SanPhamViewModle> listSPVM) {
        defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        for (SanPhamViewModle sanPhamViewModle : listSPVM) {
            defaultTableModel.addRow(new Object[]{
                i++,
                sanPhamViewModle.getMa(),
                sanPhamViewModle.getTen(),
                sanPhamViewModle.getDungluong(),
                sanPhamViewModle.getSoluongton(),
                sanPhamViewModle.getGianhap(),
                sanPhamViewModle.getGiaban(),
                sanPhamViewModle.getMota(),
                sanPhamViewModle.getAnhsanpham(),
                sanPhamViewModle.getBarcode(),
                sanPhamViewModle.getTrangthai() == 0 ? "Ngừng bán" : "Đang bán",
                sanPhamViewModle.getTendongsanpham(),
                sanPhamViewModle.getTenmausac()

            });
        }
    }

    public void loadCBMauSac(List<MauSacViewModel> listMSVM) {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_mauSac.getModel();
        defaultComboBoxModel.removeAllElements();
        for (MauSacViewModel mauSacViewModel : listMSVM) {
            defaultComboBoxModel.addElement(mauSacViewModel.getTen());
        }
    }

    public void loadCBDongSanPham(List<DongSanPhamViewModle> listDSPVM) {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_dongSP.getModel();
        defaultComboBoxModel.removeAllElements();
        for (DongSanPhamViewModle dongSanPhamViewModle : listDSPVM) {
            defaultComboBoxModel.addElement(dongSanPhamViewModle.getTen());
        }
    }

    public int getindexsp() {
        return indexsp;
    }

    public SanPhamViewModle getModel() {
        int index = tblSanPham.getSelectedRow();

        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        String dungLuong = txt_dungLuong.getText();
//        int soLuongTon = Integer.parseInt(txt_soLuong.getText());
        int nambaohanh = Integer.parseInt(txt_namBh.getText());

        BigDecimal giaNhap = BigDecimal.valueOf(Double.parseDouble(txt_giaNhap.getText()));
        BigDecimal giaBan = BigDecimal.valueOf(Double.parseDouble(txt_giaBan.getText()));

        String mota = ta_moTa.getText();
        int trangThai;
        if (rd_dangBan.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        SanPhamViewModle sanPhamViewModle = new SanPhamViewModle(null, ma, ten, dungLuong, 0, nambaohanh, giaNhap, giaBan, mota, ImageByte, null, trangThai, null, null);
        return sanPhamViewModle;
    }

    public void showDetail() throws IOException {
        int index = tblSanPham.getSelectedRow();
        List<SanPhamViewModle> listSPVM = sanPhamService.getList();
        SanPhamViewModle x = listSPVM.get(index);
        txt_ma.setText(x.getMa());
        txt_ten.setText(x.getTen());
        txt_dungLuong.setText(x.getDungluong());
//        txt_soLuong.setText(String.valueOf(x.getSoluongton()));

        txt_giaNhap.setText(String.valueOf(x.getGianhap()));
        txt_giaBan.setText(String.valueOf(x.getGiaban()));
        cb_dongSP.setSelectedItem(x.getTendongsanpham());
        cb_mauSac.setSelectedItem(x.getTenmausac());
        int trangThai = (x.getTrangthai());

        if (trangThai == 1) {
            rd_dangBan.setSelected(true);
        }
        if (trangThai == 0) {
            rd_ngungBan.setSelected(true);
        }

        if (x.getAnhsanpham() != null) {
            Image img = ImageHelper.createImageFromByteArray(x.getAnhsanpham(), "jpg");
            lb_anh.setIcon(new ImageIcon(img));
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource(("/image/apple_mac_dinh.png")));

            Image img = ImageHelper.resize(icon.getImage(), 206, 250);
            ImageIcon resizedIcon = new ImageIcon(img);
            lb_anh.setIcon(resizedIcon);

//             lb_anh.setIcon(new ImageIcon(getClass().getResource(("/image/apple_mac_dinh.png"))));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtSeacrch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        txt_dungLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        txt_namBh = new javax.swing.JTextField();
        lb_anh = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_dongSP = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cb_mauSac = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        rd_dangBan = new javax.swing.JRadioButton();
        rd_ngungBan = new javax.swing.JRadioButton();
        btnEditDongSP = new javax.swing.JButton();
        btnEditMauSac = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_moTa = new javax.swing.JTextArea();
        btnsoluongton = new javax.swing.JButton();
        cbsoluongton = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tblSanPham.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên", "Dung lượng", "Số lượng Tồn", "Giá nhập", "Giá bán", "Mô tả", "ảnh", "barcode", "Trạng thái", "Dòng sản phẩm", "Màu sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(25);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        txtSeacrch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtSeacrch.setBorder(null);
        txtSeacrch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeacrchCaretUpdate(evt);
            }
        });
        txtSeacrch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSeacrchMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchbar1.png"))); // NOI18N

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtSeacrch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(518, 518, 518)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSeacrch)
                        .addGap(5, 5, 5)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mã");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Dung lượng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Mô tả");

        txt_ma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_ten.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_dungLuong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_dungLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_dungLuongMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_dungLuongMouseReleased(evt);
            }
        });
        txt_dungLuong.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txt_dungLuongCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_dungLuongInputMethodTextChanged(evt);
            }
        });
        txt_dungLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dungLuongActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Năm BH");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Imei");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Giá nhập");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Giá bán");

        txt_giaNhap.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_giaBan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_namBh.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_namBh.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_namBhCaretUpdate(evt);
            }
        });
        txt_namBh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_namBhMouseClicked(evt);
            }
        });

        lb_anh.setBackground(new java.awt.Color(0, 204, 102));
        lb_anh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_anh.setOpaque(true);
        lb_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_anhMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Dòng SP");

        cb_dongSP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Màu sắc");

        cb_mauSac.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Trạng thái");

        rd_dangBan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rd_dangBan.setText("Đang bán");

        rd_ngungBan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rd_ngungBan.setText("Ngừng bán");

        btnEditDongSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_35px.png"))); // NOI18N
        btnEditDongSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDongSPActionPerformed(evt);
            }
        });

        btnEditMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_RGB_Color_Wheel_35px_1.png"))); // NOI18N
        btnEditMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMauSacActionPerformed(evt);
            }
        });

        ta_moTa.setColumns(20);
        ta_moTa.setRows(5);
        jScrollPane2.setViewportView(ta_moTa);

        btnsoluongton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_35px.png"))); // NOI18N
        btnsoluongton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsoluongtonActionPerformed(evt);
            }
        });

        cbsoluongton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_dungLuong, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cb_dongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rd_dangBan)
                        .addGap(40, 40, 40)
                        .addComponent(rd_ngungBan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel12)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_giaBan)
                            .addComponent(txt_giaNhap)
                            .addComponent(txt_namBh)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cb_mauSac, 0, 221, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(165, 165, 165)
                        .addComponent(lb_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbsoluongton, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsoluongton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_dungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txt_namBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(cb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEditMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cb_dongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(rd_dangBan)
                            .addComponent(rd_ngungBan))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(btnsoluongton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbsoluongton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Refresh_Love_60px_1.png"))); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_60px.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_save_60px.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(55, 55, 55)
                .addComponent(jButton3)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSeacrchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSeacrchMouseClicked
//        String search = txtSeacrch.getText();
//        System.out.println(search);
//        List<SanPhamViewModle> sanPhamViewModles = sanPhamService.search(search);
//
//        loadData(sanPhamViewModles);

// if (!txtSeacrch.getText().equals("Mã HD")) {
//            return;
//        }
//        txtSeacrch.setText("");
    }//GEN-LAST:event_txtSeacrchMouseClicked

    private void btnEditDongSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDongSPActionPerformed
        DongSPDialog dongSPDialog = new DongSPDialog(null, true, this);
        dongSPDialog.setVisible(true);
    }//GEN-LAST:event_btnEditDongSPActionPerformed

    private void btnEditMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMauSacActionPerformed
        MauSacDialog mauSacDialog = new MauSacDialog(null, true, this);
        mauSacDialog.setVisible(true);
    }//GEN-LAST:event_btnEditMauSacActionPerformed

    private void txtSeacrchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeacrchCaretUpdate

        String maSP = txtSeacrch.getText();
        List<SanPhamViewModle> list = new ArrayList<>();
        if (maSP.isEmpty()) {
            list = sanPhamService.getList();
        } else {
            list = sanPhamService.search(maSP);
        }
        loadData(list);
    }//GEN-LAST:event_txtSeacrchCaretUpdate

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int indexDongSP = cb_dongSP.getSelectedIndex();
        int indexMauSac = cb_mauSac.getSelectedIndex();
        JOptionPane.showMessageDialog(this, sanPhamService.add(getModel(), indexDongSP, indexMauSac));
        listSPVM = sanPhamService.getList();
        loadData(listSPVM);
//        clear();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        try {
            // TODO add your handling code here:
            showDetail();
        } catch (IOException ex) {
            Logger.getLogger(SanPhamPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        indexsp = tblSanPham.getSelectedRow();
        System.out.println(indexsp);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void lb_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_anhMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());

            Image img = ImageHelper.resize(icon.getImage(), 206, 250);
            ImageIcon resizedIcon = new ImageIcon(img);
            lb_anh.setIcon(resizedIcon);
            ImageByte = ImageHelper.toByteArray(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }//GEN-LAST:event_lb_anhMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int indexDongSP = cb_dongSP.getSelectedIndex();
        int indexMauSac = cb_mauSac.getSelectedIndex();
        JOptionPane.showMessageDialog(this, sanPhamService.update(getModel(), indexDongSP, indexMauSac));
        listSPVM = sanPhamService.getList();
        loadData(listSPVM);
//        clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_namBhCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_namBhCaretUpdate

    }//GEN-LAST:event_txt_namBhCaretUpdate

    private void txt_namBhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_namBhMouseClicked

    }//GEN-LAST:event_txt_namBhMouseClicked

    private void txt_dungLuongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dungLuongMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_dungLuongMouseExited

    private void txt_dungLuongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dungLuongMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_dungLuongMouseReleased

    private void txt_dungLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_dungLuongInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_dungLuongInputMethodTextChanged

    private void txt_dungLuongCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_dungLuongCaretPositionChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_dungLuongCaretPositionChanged

    private void txt_dungLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dungLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dungLuongActionPerformed

    private void btnsoluongtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsoluongtonActionPerformed
        // TODO add your handling code here:

        ImeiSPDialog imeiDialog = new ImeiSPDialog(null, true, this);
        imeiDialog.setVisible(true);
    }//GEN-LAST:event_btnsoluongtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditDongSP;
    private javax.swing.JButton btnEditMauSac;
    private javax.swing.JButton btnsoluongton;
    private javax.swing.JComboBox<String> cb_dongSP;
    private javax.swing.JComboBox<String> cb_mauSac;
    private javax.swing.JComboBox<String> cbsoluongton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_anh;
    private javax.swing.JRadioButton rd_dangBan;
    private javax.swing.JRadioButton rd_ngungBan;
    private javax.swing.JTextArea ta_moTa;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtSeacrch;
    private javax.swing.JTextField txt_dungLuong;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_namBh;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
