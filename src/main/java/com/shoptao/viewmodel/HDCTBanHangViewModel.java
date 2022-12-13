package com.shoptao.viewmodel;

import java.math.BigDecimal;
import javax.swing.JTable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nguyen293
 */

@NoArgsConstructor
@Data
public class HDCTBanHangViewModel {
    
    private String id;
    
    private String masanpham;
    
    private String tensanpham;
    
    private BigDecimal dongia;
    
    private int soluong;
    
    private BigDecimal thanhtien;
    

    public HDCTBanHangViewModel(String id, String masanpham, String tensanpham, BigDecimal dongia, int soluong) {
        this.id = id;
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    
    public BigDecimal getThanhtien() {
            return dongia.multiply(new BigDecimal(soluong));
    }
    
    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Object[] toDataRow(JTable tbl){
        return new Object[]{tbl.getRowCount() + 1,
            masanpham, tensanpham, dongia, soluong, getThanhtien()
        };
    }
}
