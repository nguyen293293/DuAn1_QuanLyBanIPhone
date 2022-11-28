/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoptao.services;

import com.shoptao.viewmodel.KhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamKhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamViewModle;

/**
 *
 * @author haih7
 */
public interface vcl<T> {
    String add(SanPhamKhuyenMaiViewModle t,SanPhamViewModle spvm,KhuyenMaiViewModle km);
    
}
