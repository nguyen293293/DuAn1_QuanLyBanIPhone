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
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.viewmodel.SanPhamKhuyenMaiViewModle;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.shoptao.services.ChungServices;
import com.shoptao.viewmodel.KhuyenMaiBanHangViewModel;
import java.math.BigDecimal;

/**
 *
 * @author haih7
 */
public class SanPhamKhuyenMaiService implements ChungServices<SanPhamKhuyenMaiViewModle> {

    public SanPhamKhuyenMaiService() {
    }
    ModelMapper modelMapper = new ModelMapper();
    public SanPhamKhuyenMaiRepository sanPhamKhuyenMaiRepository = new SanPhamKhuyenMaiRepository();
    public KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    public SanPhamRepository sanPhamRepository = new SanPhamRepository();

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
    public List<SanPhamKhuyenMaiViewModle> search(String maSanPham) {
        List<SanPhamKhuyenMaiViewModle> list = new ArrayList<>();
        for (SanPhamKhuyenMai x : sanPhamKhuyenMaiRepository.getList()) {
            if (x.getSanpham().getMa().equals(maSanPham)) {
                list.add(new SanPhamKhuyenMaiViewModle(x.getId(), x.getSanpham().getTen(), x.getKhuyenmai().getTen(), x.getDongia(), x.getSotienconlai(), x.getTrangthai()));
            }
        }
        return list;
    }

    @Override
    public String add(SanPhamKhuyenMaiViewModle t, Object... obj) {
        boolean isSave;

        SanPham sp = sanPhamRepository.getList().get((int) obj[0]);
        KhuyenMai km = khuyenMaiRepository.getList().get((int) obj[1]);
        System.out.println(t.getTensanpham());
        SanPhamKhuyenMai sanPhamKhuyenMai = modelMapper.map(t, SanPhamKhuyenMai.class);
        sanPhamKhuyenMai.setKhuyenmai(km);
        sanPhamKhuyenMai.setSanpham(sp);
        isSave = sanPhamKhuyenMaiRepository.add(sanPhamKhuyenMai);
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
    
    public List<KhuyenMaiBanHangViewModel> getListKMBH(String maSanPham){
        List<KhuyenMaiBanHangViewModel> list = new ArrayList<>();
        for (SanPhamKhuyenMai x : sanPhamKhuyenMaiRepository.getList()) {
            list.add(new KhuyenMaiBanHangViewModel(x.getSanpham().getMa(),
                    x.getSanpham().getTen(), x.getKhuyenmai().getTen(),
                    x.getSanpham().getGiaban(), BigDecimal.valueOf(x.getKhuyenmai().getGiatri()),
                    x.getKhuyenmai().getHinhthucgiamgia()));
        }
        return list;
    }

}
