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
public class SanPhamViewModle {
    
    private String id;
      private String ma;
    
    private String ten;
    
    private String dungluong;
    
    private int soluongton;
    
    private int nambaohanh;
    
    private BigDecimal gianhap;
    
    private BigDecimal giaban;
   private String mota;
    private byte[] anhsanpham;
    
    private String barcode;
    
    private int trangthai;
    
  
    private String tendongsanpham;
    
    private String tenmausac;
    
    
    
    
}
