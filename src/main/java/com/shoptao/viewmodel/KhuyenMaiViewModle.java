/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.viewmodel;

import java.util.Date;
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
public class KhuyenMaiViewModle {
private String id;
    private String ma;
    
    private String ten;
    
    private float giatri;
    
    private int hinhthucgiamgia;
    
     private float dieukiengiamgia;
    
    private Date ngaybatdau;
    
    private Date ngayketthuc;
    
    private int trangthai;

}
