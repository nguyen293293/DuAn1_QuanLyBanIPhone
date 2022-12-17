package com.shoptao.viewmodel;

import java.math.BigDecimal;
import javax.swing.JTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nguyen293
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SanPhamBanHangViewModel {
    
    private String masanpham;
    
    private String tensanpham;
    
    private String tenmausac;
    
    private String dungluong;
    
    private int nambaohanh;
    
    private int soluong;
    
    private BigDecimal giaban;
    
    private String barcode;
    
    private int trangthai;
    public Object[] toDataRow(JTable tbl){
        return new Object[]{
            tbl.getRowCount() + 1, masanpham, tensanpham, tenmausac, dungluong, nambaohanh,
            soluong, giaban
        };
    }
}
