/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.KhuyenMai;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.domainmodel.SanPhamKhuyenMai;
import com.shoptao.repositories.KhuyenMaiRepository;
import com.shoptao.repositories.SanPhamKhuyenMaiRepository;
import com.shoptao.services.vcl;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamKhuyenMaiViewModle;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.shoptao.services.ChungServices;

/**
 *
 * @author haih7
 */
public class SanPhamKhuyenMaiService implements ChungServices<SanPhamKhuyenMaiViewModle>,vcl<SanPhamKhuyenMaiViewModle> {

    public SanPhamKhuyenMaiService() {
    }
    ModelMapper modelMapper = new ModelMapper();
    public SanPhamKhuyenMaiRepository sanPhamKhuyenMaiRepository = new SanPhamKhuyenMaiRepository();
    public KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public List<SanPhamKhuyenMaiViewModle> getList() {
        List<SanPhamKhuyenMaiViewModle> list = new ArrayList<>();

        for (SanPhamKhuyenMai x : sanPhamKhuyenMaiRepository.getList()) {
            list.add(new SanPhamKhuyenMaiViewModle(x.getId(), x.getSanpham().getTen(), x.getKhuyenmai().getTen(), x.getDongia(), x.getSotienconlai(), x.getTrangthai()));
        }
        return list;
    }

    @Override
    public String update(SanPhamKhuyenMaiViewModle t, Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPhamKhuyenMaiViewModle getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamKhuyenMaiViewModle> search(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(SanPhamKhuyenMaiViewModle t, Object... obj) {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
  

//    @Override
//    public String ( List<SanPhamViewModle> list,KhuyenMaiViewModle km) {
//        
//        ModelMapper modelMapper = new ModelMapper();
//        KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
//        khuyenMaiService.add(km);
//        KhuyenMai khuyenMai = modelMapper.map(km, KhuyenMai.class);
//                for (KhuyenMai x : khuyenMaiRepository.getList()) {
//            if (x.getMa().equals(khuyenMai.getMa())) {
//                khuyenMai.setId(x.getId());
//            }
//        }
//
//        for (SanPhamViewModle t : list) {
//            SanPham sp = modelMapper.map(t, SanPham.class);
//             BigDecimal giatri = BigDecimal.valueOf(khuyenMai.getGiatri());
//            BigDecimal sotienconlai = sp.getGiaban().subtract(giatri);
//            BigDecimal dongia = sp.getGiaban();
//             SanPhamKhuyenMai spkm = new SanPhamKhuyenMai("",sp,khuyenMai,dongia,sotienconlai,t.getTrangthai());
//            isSave =  sanPhamKhuyenMaiRepository.add(spkm);
//        }
//
//       return isSave ?"Thêm thành công" : "Thêm thất bại";
//    }
    @Override
    public String add(SanPhamKhuyenMaiViewModle t, SanPhamViewModle spvm, KhuyenMaiViewModle km) {
          boolean isSave;
        SanPham sp = modelMapper.map(spvm, SanPham.class);
        KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
        khuyenMaiService.add(km);
        KhuyenMai khuyenMai = modelMapper.map(km, KhuyenMai.class);
        for (KhuyenMai x : khuyenMaiRepository.getList()) {
            if (x.getMa().equals(khuyenMai.getMa())) {
                khuyenMai.setId(x.getId());
            }
        }
        SanPhamKhuyenMai spkm = new SanPhamKhuyenMai("", sp, khuyenMai, t.getDongia(), t.getSotienconlai(), t.getTrangthai());
        isSave = sanPhamKhuyenMaiRepository.add(spkm);
        return isSave ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String delete(String id) {
    boolean isDel = sanPhamKhuyenMaiRepository.delete(id);
        if (isDel) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
