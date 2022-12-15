/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoptao.services;

import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.List;

/**
 *
 * @author haih7
 */
public interface SanPhamService {

    List<SanPhamViewModle> getListSPByMaDSP(String ma);

    List<SanPhamViewModle> getListSPByMaMS(String ma);
}
