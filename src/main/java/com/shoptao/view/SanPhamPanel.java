package com.shoptao.view;

import com.shoptao.services.impl.DongSanPhamService;
import com.shoptao.services.impl.ImeiService;
import com.shoptao.services.impl.MauSacService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.ImageHelper;
import com.shoptao.utilities.Validation;
import com.shoptao.viewmodel.DongSanPhamViewModle;
import com.shoptao.viewmodel.ImeiViewModel;
import com.shoptao.viewmodel.MauSacViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.awt.Image;
import java.awt.Point;
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
    public ImeiService imeiService = new ImeiService();

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
    private ButtonGroup buttonGroup = new ButtonGroup();

    private byte[] ImageByte;
    List<MauSacViewModel> listMSVM = new ArrayList<>();
    List<DongSanPhamViewModle> listDSPVM = new ArrayList<>();
    List<SanPhamViewModle> listSPVM = new ArrayList<>();
    List<ImeiViewModel> listIMVM = new ArrayList<>();
    public int indexsp;

    public SanPhamPanel() {
        initComponents();
        init();
        selectRD();

        listMSVM = mauSacService.getList();
        listDSPVM = dongSanPhamService.getList();
        listSPVM = sanPhamService.getList();

//        listIMVM = imeiService.search(sanPhamService.getList().get(indexsp).getId());
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

    public List<ImeiViewModel> getListImeiOfIdSP() {
        String idsp = sanPhamService.getList().get(indexsp).getId();
        List<ImeiViewModel> list = imeiService.search(idsp);
        return list;

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
//            List<ImeiViewModel> listimvm = imeiService.search(sanPhamViewModle.getId());
//            int soLuongTon = listimvm.size();
            defaultTableModel.addRow(new Object[]{
                i++,
                sanPhamViewModle.getMa(),
                sanPhamViewModle.getTen(),
                sanPhamViewModle.getDungluong(),
                sanPhamViewModle.getSoluongton(),
                sanPhamViewModle.getNambaohanh(),
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

 

    public SanPhamViewModle getModel() {
        int index = tblSanPham.getSelectedRow();

        String ma = lbl_ma.getText();
        String ten = txt_ten.getText();
        String dungLuong = txt_dungLuong.getText();
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
        lbl_ma.setText(x.getMa());
        txt_ten.setText(x.getTen());
        txt_dungLuong.setText(x.getDungluong());
        txt_namBh.setText(String.valueOf(x.getNambaohanh()));
        txt_giaNhap.setText(String.valueOf(x.getGianhap()));
        txt_giaBan.setText(String.valueOf(x.getGiaban()));
        cb_dongSP.setSelectedItem(x.getTendongsanpham());
        cb_mauSac.setSelectedItem(x.getTenmausac());
        ta_moTa.setText(x.getMota());
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

        }

    }

    public void refesh() {
        lbl_ma.setText("");
        txt_ten.setText("");
        txt_dungLuong.setText("");
        txt_namBh.setText("");
        txt_giaNhap.setText("");
        txt_giaBan.setText("");
        ta_moTa.setText("");
        cb_dongSP.setSelectedIndex(0);
        cb_mauSac.setSelectedIndex(0);

        rd_dangBan.setSelected(false);
        rd_ngungBan.setSelected(false);

        ImageIcon icon = new ImageIcon(getClass().getResource(("/image/apple_mac_dinh.png")));

        Image img = ImageHelper.resize(icon.getImage(), 206, 250);
        ImageIcon resizedIcon = new ImageIcon(img);
        lb_anh.setIcon(resizedIcon);
    }
    public void setSoLuongAndUpdateSp(int soLuongImei){
        int indexDongSP = cb_dongSP.getSelectedIndex();
        int indexMauSac = cb_mauSac.getSelectedIndex();
        SanPhamViewModle spvm = getModel();
        spvm.setSoluongton(soLuongImei);
      sanPhamService.update(spvm, indexDongSP, indexMauSac);
        listSPVM = sanPhamService.getList();
        loadData(listSPVM);
    }
    
    private boolean validation(){
        if(!Validation.CheckTrongText( txt_ten, txt_dungLuong, txt_giaNhap, txt_namBh, txt_giaBan)){
            return false;
        }
        
        if(!Validation.checkNumberSo(txt_namBh)){
            return false;
        }
        
        if(!Validation.checkNumberSo(txt_giaNhap)){
            return false;
        }
        
        if(!Validation.checkNumberSo(txt_giaBan)){
            return false;
        }
        
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpop_Imei = new javax.swing.JPopupMenu();
        QuanLyImei = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtSeacrch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        txt_dungLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        lbl_ma = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();

        QuanLyImei.setText("QuanLyImei");
        QuanLyImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanLyImeiActionPerformed(evt);
            }
        });
        jpop_Imei.add(QuanLyImei);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tblSanPham.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên", "Dung lượng", "Số lượng Tồn", "Năm bảo hành", "Giá nhập", "Giá bán", "Mô tả", "ảnh", "barcode", "Trạng thái", "Dòng sản phẩm", "Màu sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, true, true, true, true
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseReleased(evt);
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
        txtSeacrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeacrchActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Dung lượng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Mô tả");

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

        buttonGroup1.add(rd_dangBan);
        rd_dangBan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rd_dangBan.setSelected(true);
        rd_dangBan.setText("Đang bán");

        buttonGroup1.add(rd_ngungBan);
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Mã");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_dungLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cb_dongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_namBh, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(113, 113, 113)
                        .addComponent(lb_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_dangBan)
                                .addGap(40, 40, 40)
                                .addComponent(rd_ngungBan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(94, 94, 94)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel12)))
                        .addGap(679, 679, 679))))
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
                                .addGap(9, 9, 9)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
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
                                .addComponent(txt_namBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rd_dangBan)
                    .addComponent(rd_ngungBan))
                .addGap(38, 38, 38))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Refresh_Love_60px_1.png"))); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_60px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_save_60px.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(61, 61, 61)
                .addComponent(btnSua)
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        
        if(!validation()) return;
        
        int indexDongSP = cb_dongSP.getSelectedIndex();
        int indexMauSac = cb_mauSac.getSelectedIndex();
        JOptionPane.showMessageDialog(this, sanPhamService.add(getModel(), indexDongSP, indexMauSac));
        listSPVM = sanPhamService.getList();
        loadData(listSPVM);
        refesh();

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        try {
            // TODO add your handling code here:
            showDetail();
        } catch (IOException ex) {
            Logger.getLogger(SanPhamPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        indexsp = tblSanPham.getSelectedRow();

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

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(tblSanPham.getSelectedRow() < 0){
            DialogHelper.alert(null, "Chọn sản phẩm cần sửa", "Thông báo");
            return;
        }
        if(!validation()) return;
        
        int indexDongSP = cb_dongSP.getSelectedIndex();
        int indexMauSac = cb_mauSac.getSelectedIndex();
        JOptionPane.showMessageDialog(this, sanPhamService.update(getModel(), indexDongSP, indexMauSac));
        listSPVM = sanPhamService.getList();
        loadData(listSPVM);
        refesh();
    }//GEN-LAST:event_btnSuaActionPerformed

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

    private void txtSeacrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeacrchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeacrchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        refesh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblSanPhamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseReleased
        // TODO add your handling code here:
         Point point = evt.getPoint();
        int currentRow = tblSanPham.rowAtPoint(point);
        if (currentRow < 0) {
            return;
        }
        tblSanPham.setRowSelectionInterval(currentRow, currentRow);
        if (evt.isPopupTrigger()) {
            jpop_Imei.show(tblSanPham, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblSanPhamMouseReleased

    private void QuanLyImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLyImeiActionPerformed
        // TODO add your handling code here:
        
          ImeiSPDialog imeiDialog = new ImeiSPDialog(null, true, this, indexsp);
        imeiDialog.setVisible(true);
        
    }//GEN-LAST:event_QuanLyImeiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem QuanLyImei;
    private javax.swing.JButton btnEditDongSP;
    private javax.swing.JButton btnEditMauSac;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_dongSP;
    private javax.swing.JComboBox<String> cb_mauSac;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
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
    private javax.swing.JPopupMenu jpop_Imei;
    private javax.swing.JLabel lb_anh;
    private javax.swing.JLabel lbl_ma;
    private javax.swing.JRadioButton rd_dangBan;
    private javax.swing.JRadioButton rd_ngungBan;
    private javax.swing.JTextArea ta_moTa;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtSeacrch;
    private javax.swing.JTextField txt_dungLuong;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_namBh;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
