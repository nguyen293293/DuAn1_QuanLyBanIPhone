package com.shoptao.viewmodel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nguyen293
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoaDonBanHangViewModel {
    
    private String mahoadon;
    
    private String tennhanvien;
    
    private Date ngaytao;
    
    private int trangthai;
    
    public Object[] toDataRow(JTable tbl){
        return new Object[]{tbl.getRowCount() + 1,
            mahoadon, tennhanvien, new SimpleDateFormat("dd-MM-yyyy hh:mm").format(ngaytao)
        };
    }
}