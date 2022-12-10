/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.viewmodel;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author haih7
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPhamKhuyenMaiViewModle {
     private String id;
     
     private String masanpham;
     
    private String tensanpham;
    
    private String makhuyenmai;

    private String tenkhuyenmai;
    
    private int trangthaikhuyenmai;
    
    private BigDecimal dongia;

    private BigDecimal sotienconlai;

    private int trangthai;
}
