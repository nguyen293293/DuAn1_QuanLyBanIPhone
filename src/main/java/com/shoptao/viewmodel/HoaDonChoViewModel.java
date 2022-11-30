package com.shoptao.viewmodel;

import java.util.Date;
import javax.swing.JTable;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class HoaDonChoViewModel {

    private String maHoaDon;
    
    private String tenNhanVien;
    
    private Date ngayTao;
 
    public Object[] toDataRow(JTable table){
        return new Object[]{table.getRowCount() + 1, maHoaDon, tenNhanVien, ngayTao};
    }
}
