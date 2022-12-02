/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoptao.services;

import com.shoptao.viewmodel.ImeiDaBanViewModel;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public interface InterfaceImeiDaBanService {
    
    List<ImeiDaBanViewModel> search(String idHDCT);
    
    boolean add(ImeiDaBanViewModel imeiVM);
    
    boolean deleteByImei(String maImei);
    
    boolean deleteByIdHDCT(String idHDCT);
}
