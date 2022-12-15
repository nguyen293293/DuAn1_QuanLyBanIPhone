/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.KhuyenMai;
import com.shoptao.repositories.KhuyenMaiRepository;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.shoptao.services.ChungServices;

/**
 *
 * @author haih7
 */
public class KhuyenMaiService implements ChungServices<KhuyenMaiViewModle>,com.shoptao.services.KhuyenMaiService {

    public KhuyenMaiService() {
    }

    ModelMapper modelMapper = new ModelMapper();

    public KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMaiViewModle> getList() {
        List<KhuyenMaiViewModle> list = new ArrayList<>();

        for (KhuyenMai khuyenmai : khuyenMaiRepository.getList()) {
            list.add(new KhuyenMaiViewModle(khuyenmai.getId(), khuyenmai.getMa(), khuyenmai.getTen(), khuyenmai.getGiatri(), khuyenmai.getHinhthucgiamgia(), khuyenmai.getDieukiengiamgia(), khuyenmai.getNgaybatdau(), khuyenmai.getNgayketthuc(),khuyenmai.getHieuluc(), khuyenmai.getTrangthai()));
        }
        return list;
    }

    @Override
    public String add(KhuyenMaiViewModle t, Object... obj) {
       KhuyenMai km = new KhuyenMai(t.getId(), genmahd(), t.getTen(), t.getGiatri(),t.getHinhthucgiamgia(), t.getDieukiengiamgia(), t.getNgaybatdau(), t.getNgayketthuc(),t.getHieuluc(), t.getTrangthai());
        boolean isSave = khuyenMaiRepository.add(km);
        return isSave ? "Thêm thành công" : "Thêm thất bại";
    }
        private String genmahd() {
        List<KhuyenMai> list = khuyenMaiRepository.getList();
        if (list.size() == 0) {
            return "KM001";
        } else {
            int num = list.size() + 1;
            return "KM" + (String.format("%03d", num));
        }
    }

    @Override
    public String update(KhuyenMaiViewModle t, Object... obj) {
        KhuyenMai khuyenMai = modelMapper.map(t, KhuyenMai.class);

        for (KhuyenMai x : khuyenMaiRepository.getList()) {
            if (x.getMa().equals(khuyenMai.getMa())) {
                khuyenMai.setId(x.getId());
            }
        }
        boolean isUpdate = khuyenMaiRepository.update(khuyenMai);
        return isUpdate ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public KhuyenMaiViewModle getOne(String ma) {
        KhuyenMai khuyenmai = khuyenMaiRepository.getOne(ma);
        KhuyenMaiViewModle khuyenMaiViewModle = new KhuyenMaiViewModle(khuyenmai.getId(),
                khuyenmai.getMa(), khuyenmai.getTen(), khuyenmai.getGiatri(),
                khuyenmai.getHinhthucgiamgia(), khuyenmai.getDieukiengiamgia(),
                khuyenmai.getNgaybatdau(), khuyenmai.getNgayketthuc(),khuyenmai.getHieuluc(), khuyenmai.getTrangthai());
        return khuyenMaiViewModle;
    }

    @Override
    public List<KhuyenMaiViewModle> search(String ten) {
        List<KhuyenMaiViewModle> listKMVM = new ArrayList<>();

        for (KhuyenMaiViewModle x : getList()) {
            if (x.getTen().startsWith(ten)) {
                listKMVM.add(x);
            }
        }
        return listKMVM;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhuyenMaiViewModle> fillterTrangThai(int trangThai) {
         List<KhuyenMaiViewModle> list = new ArrayList<>();

        for (KhuyenMai khuyenmai : khuyenMaiRepository.fillterTrangThai(trangThai)) {
            list.add(new KhuyenMaiViewModle(khuyenmai.getId(), khuyenmai.getMa(), khuyenmai.getTen(), khuyenmai.getGiatri(), khuyenmai.getHinhthucgiamgia(), khuyenmai.getDieukiengiamgia(), khuyenmai.getNgaybatdau(), khuyenmai.getNgayketthuc(),khuyenmai.getHieuluc(), khuyenmai.getTrangthai()));
        }
        return list;
    }

    @Override
    public List<KhuyenMaiViewModle> fillterHieuLuc(int hieuLuc) {
          List<KhuyenMaiViewModle> list = new ArrayList<>();

        for (KhuyenMai khuyenmai : khuyenMaiRepository.fillterHieuLuc(hieuLuc)) {
            list.add(new KhuyenMaiViewModle(khuyenmai.getId(), khuyenmai.getMa(), khuyenmai.getTen(), khuyenmai.getGiatri(), khuyenmai.getHinhthucgiamgia(), khuyenmai.getDieukiengiamgia(), khuyenmai.getNgaybatdau(), khuyenmai.getNgayketthuc(),khuyenmai.getHieuluc(), khuyenmai.getTrangthai()));
        }
        return list;
    }
    
}
