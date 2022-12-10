package com.shoptao.viewmodel;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nguyen293
 */
@NoArgsConstructor
@Data
public class KhuyenMaiBanHangViewModel {
    
    private String masanpham;
    
    private String tensanpham;
    
    private String makhuyenmia;
    
    private String tenkhuyenmai;
    
    private BigDecimal giasanpham;
    
    private BigDecimal giatrigiam;
    
    private int hinhthucgiam;

    public KhuyenMaiBanHangViewModel(String masanpham, String tensanpham, String tenkhuyenmai, BigDecimal giasanpham, BigDecimal giatrigiam, int hinhthucgiam) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.tenkhuyenmai = tenkhuyenmai;
        this.giasanpham = giasanpham;
        this.giatrigiam = giatrigiam;
        this.hinhthucgiam = hinhthucgiam;
    }
    
    public String getGiaTriGiam(){
        if(hinhthucgiam == 0){
            return giatrigiam + " VND";
        }else{
            return giasanpham + " %";
        }
    }
    
}
