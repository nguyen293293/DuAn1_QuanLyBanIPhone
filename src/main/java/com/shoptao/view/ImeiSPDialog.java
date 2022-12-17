package com.shoptao.view;

import static com.microsoft.sqlserver.jdbc.StringUtils.isEmpty;
import com.shoptao.services.ChungServices;
import com.shoptao.services.impl.ImeiService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.utilities.DialogHelper;
import com.shoptao.utilities.ReadAndWriteExcelHelper;
import com.shoptao.utilities.Validation;
import com.shoptao.viewmodel.ImeiViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen293
 */
public class ImeiSPDialog extends javax.swing.JDialog {

    SanPhamViewModle spvmtest = new SanPhamViewModle();

    public ImeiService imeiService = new ImeiService();
    public SanPhamService sanPhamService = new SanPhamService();
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    List<ImeiViewModel> listImeiOfIdSanPham;

    SanPhamPanel sp;
    int indexsp;

    public ImeiSPDialog(java.awt.Frame parent, boolean modal, SanPhamPanel sp, int indexsp, String maSP) {
        super(parent, modal);
        initComponents();

        this.sp = sp;
        this.indexsp = indexsp;
        setTitle("Imei");
        setLocationRelativeTo(null);
        listImeiOfIdSanPham = imeiService.searchImeiByMa(maSP);
//        listImeiOfIdSanPham = imeiService.search(sanPhamService.getList().get(indexsp).getId());
        loadData(listImeiOfIdSanPham);

    }

    public void loadData(List<ImeiViewModel> list) {

        defaultTableModel = (DefaultTableModel) tbImei.getModel();
        defaultTableModel.setRowCount(0);
        int i = 0;
        for (ImeiViewModel ImeiViewModel : list) {
            if (ImeiViewModel.getTrangthai() == 0) {
                defaultTableModel.addRow(new Object[]{
                    i = i + 1,
                    ImeiViewModel.getMaimei()

                });
            }
        }
    }

    public ImeiViewModel getModel() {

        ImeiViewModel x = new ImeiViewModel(txtMa.getText(), 0, null);
        return x;
    }

    public void refesh() {
        txtMa.setText("");
    }

    //số lượng imei của 1 sản phẩm trạng thái = 0
    public int sizeList() {
        List<ImeiViewModel> listImvm = new ArrayList<>();
        listImeiOfIdSanPham = imeiService.search(sanPhamService.getList().get(indexsp).getId());
        for (ImeiViewModel imeiViewModel : listImeiOfIdSanPham) {
            if (imeiViewModel.getTrangthai() == 0) {
                listImvm.add(imeiViewModel);
            }
        }
        int soLuong = (listImvm.size());
        return soLuong;
    }

    //Check Imei
    int sumDig(int n) {
        int a = 0;
        while (n > 0) {
            a = a + n % 10;
            n = n / 10;
        }
        return a;
    }

    boolean isValidIMEI(long n) {
        String s = String.valueOf(n);
        int len = s.length();

        if (len != 15) {
            return false;
        }

        int sum = 0;
        for (int i = len; i >= 1; i--) {
            int d = (int) (n % 10);
            if (i % 2 == 0) {
                d = 2 * d;
            }
            sum += sumDig(d);
            n = n / 10;
        }
        return (sum % 10 == 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImei = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnThem1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mã Imei");

        txtMa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-xls-35.png"))); // NOI18N
        jButton1.setText("File excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tbImei.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tbImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Mã"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbImei.setRowHeight(25);
        tbImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbImeiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbImei);
        if (tbImei.getColumnModel().getColumnCount() > 0) {
            tbImei.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        btnThem1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_save_60px.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(btnThem1)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbImeiMouseClicked

    }//GEN-LAST:event_tbImeiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ChungServices<ImeiViewModel> service = new ImeiService();

        Collection<String> listOne = ReadAndWriteExcelHelper.ReadExcel();
        Collection<String> listTwo = new ArrayList();

        for (ImeiViewModel x : service.getList()) {
            listTwo.add(x.getMaimei());
        }

        List<String> sourceList = new ArrayList<String>(listOne);
        List<String> destinationList = new ArrayList<String>(listTwo);

        sourceList.removeAll(listTwo);
        if (!sourceList.isEmpty()) {
            for (String string : sourceList) {
                ImeiViewModel imvm = new ImeiViewModel();
                imvm.setMaimei(string);
                imeiService.add(imvm, indexsp);
            }

        }
        this.sp.setSoLuongAndUpdateSp(sizeList());

        List<ImeiViewModel> list = imeiService.search(sanPhamService.getList().get(indexsp).getId());
        loadData(list);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        if (!Validation.CheckTrongText(txtMa)) {
            return;
        }
        Long checkImei;
        try {
            checkImei = Long.parseLong(txtMa.getText().trim());
            if (!isValidIMEI(checkImei)) {
                DialogHelper.alert(null, "Mã Imei không đúng định dạng", "Lỗi!");
                return;
            }
        } catch (Exception e) {
            DialogHelper.alert(null, "Mã Imei không đúng định dạng", "Lỗi!");
            return;

        }

        if (txtMa.getText() == null) {
            return;
        }

        if (Validation.checkTrungMaIMEI(txtMa.getText())) {
            return;
        }
        ImeiViewModel imvm = new ImeiViewModel();
        imvm.setMaimei(txtMa.getText());
        JOptionPane.showMessageDialog(this, imeiService.add(imvm, indexsp));
        List<ImeiViewModel> list = imeiService.search(sanPhamService.getList().get(indexsp).getId());

        loadData(list);
        this.sp.setSoLuongAndUpdateSp(sizeList());
        this.sp.loadData(sanPhamService.getList());

        refesh();
    }//GEN-LAST:event_btnThem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbImei;
    private javax.swing.JTextField txtMa;
    // End of variables declaration//GEN-END:variables
}
