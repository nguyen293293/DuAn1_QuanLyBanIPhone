package com.shoptao.viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author nguyen293
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonChiTietViewModel {

    private String id;

    private String maHoaDon;

    private String maSanPham;

    private String tenSanPham;

    private Date ngaytao;

    private int soluong;

    private BigDecimal gianhap;

    private BigDecimal dongia;

    private BigDecimal tongTien;

    public BigDecimal getTongTien() {
        return dongia.multiply(BigDecimal.valueOf(soluong));
    }

    private int trangThai;
    
    
    public Object[] toDataRow(JTable table) {
        return new Object[]{table.getRowCount() + 1, maSanPham, tenSanPham,
            soluong, dongia, tongTien};
    }
}
