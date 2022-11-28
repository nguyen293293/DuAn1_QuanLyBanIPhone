/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.Imei;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.ImeiRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.viewmodel.ImeiViewModel;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.shoptao.services.ChungServices;

/**
 *
 * @author haih7
 */
public class ImeiService implements ChungServices<ImeiViewModel>{
 ModelMapper modelMapper = new ModelMapper();
    public ImeiService() {
    }
    
    public ImeiRepository imeiRepository = new ImeiRepository();
    public SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    public List<ImeiViewModel> getList() {
         List<ImeiViewModel> list = new ArrayList<>();
        List<Imei> listIm = imeiRepository.getList();
        
        for (Imei imei : listIm) {
            list.add(new ImeiViewModel(imei.getMaimei(), imei.getTrangthai(),imei.getSanpham().getTen()));
        }
        return list;
          }

    @Override
    public String add(ImeiViewModel t, Object ...obj) {
        
        SanPham sp = sanPhamRepository.getList().get((int) obj[0]);
         boolean isSave = imeiRepository.add(new Imei("", t.getMaimei(), t.getTrangthai(),sp));
       return isSave ? "Thêm thành công" : "Thêm thất bại";
    
    } 

    @Override
    public String update(ImeiViewModel t, Object ...obj) {
//       MauSac mausac = new MauSac("null", t.getMa(), t.getTen());
//          for (MauSac x : mauSacRepository.getList()) {
//            if (x.getMa().equals(mausac.getMa())) {
//                mausac.setId(x.getId());
//            }
//          }
//            boolean isUpdate = mauSacRepository.update(mausac);
//         return isUpdate ? "Sửa thành công" : "Sửa thất bại";
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

          
    }

    @Override
    public ImeiViewModel getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ImeiViewModel> search(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
