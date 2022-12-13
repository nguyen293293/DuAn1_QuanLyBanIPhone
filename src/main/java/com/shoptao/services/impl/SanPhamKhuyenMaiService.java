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
            list.add(new SanPhamKhuyenMaiViewModle(x.getId(), x.getSanpham().getMa(), x.getSanpham().getTen(), x.getKhuyenmai().getMa(), x.getKhuyenmai().getTen(), x.getKhuyenmai().getTrangthai(), x.getDongia(), x.getSotienconlai(), x.getTrangthai()));
        }
        return list;
    }

    @Override
    public String update(SanPhamKhuyenMaiViewModle t, Object... obj) {
        SanPham sp = sanPhamRepository.getOne(t.getMasanpham());
        KhuyenMai km = khuyenMaiRepository.getOne(t.getMakhuyenmai());
        System.out.println(t.getTensanpham());
        SanPhamKhuyenMai sanPhamKhuyenMai = modelMapper.map(t, SanPhamKhuyenMai.class);
        sanPhamKhuyenMai.setKhuyenmai(km);
        sanPhamKhuyenMai.setSanpham(sp);
        sanPhamKhuyenMai.setTrangthai(t.getTrangthai());
        
        return sanPhamKhuyenMaiRepository.update(sanPhamKhuyenMai) ? "Thành công" : "Thất bại";
    }

    public String updatevs2(SanPhamKhuyenMaiViewModle t) {

        SanPhamKhuyenMai sanPhamKhuyenMai = sanPhamKhuyenMaiRepository.getOne(t.getId());
        sanPhamKhuyenMai.setSotienconlai(t.getSotienconlai());

        boolean isUpdate = sanPhamKhuyenMaiRepository.update(sanPhamKhuyenMai);
        if (isUpdate) {
            return "Cap nhat thành công";
        } else {
            return "Cap nhat thất bại";
        }
    }

    @Override
    public SanPhamKhuyenMaiViewModle getOne(String id) {
        SanPhamKhuyenMai x = sanPhamKhuyenMaiRepository.getOne(id);
        SanPhamKhuyenMaiViewModle sanPhamKhuyenMaiViewModle = new SanPhamKhuyenMaiViewModle(x.getId(), x.getSanpham().getMa(), x.getSanpham().getTen(), x.getKhuyenmai().getMa(), x.getKhuyenmai().getTen(), x.getKhuyenmai().getTrangthai(), x.getDongia(), x.getSotienconlai(), x.getTrangthai());
        return sanPhamKhuyenMaiViewModle;
    }

    @Override
    public List<SanPhamKhuyenMaiViewModle> search(String maSanPham) {
        List<SanPhamKhuyenMaiViewModle> list = new ArrayList<>();
        for (SanPhamKhuyenMai x : sanPhamKhuyenMaiRepository.getList()) {
            if (x.getSanpham().getMa().equals(maSanPham)) {
                list.add(new SanPhamKhuyenMaiViewModle(x.getId(),
                        x.getSanpham().getMa(),  x.getSanpham().getTen(),  x.getKhuyenmai().getMa(),
                         x.getKhuyenmai().getTen(), x.getKhuyenmai().getTrangthai(), x.getSanpham().getGiaban(),
                        x.getSotienconlai(), x.getTrangthai()));
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

    public List<KhuyenMaiBanHangViewModel> getListKMBH(String maSanPham) {
        List<KhuyenMaiBanHangViewModel> list = new ArrayList<>();
        for (SanPhamKhuyenMai x : sanPhamKhuyenMaiRepository.getList()) {
            if (x.getSanpham().getMa().equals(maSanPham)) {
                list.add(new KhuyenMaiBanHangViewModel(x.getSanpham().getMa(),
                        x.getSanpham().getTen(), x.getKhuyenmai().getMa(), x.getKhuyenmai().getTen(),
                        x.getSanpham().getGiaban(), BigDecimal.valueOf(x.getKhuyenmai().getGiatri()),
                        x.getKhuyenmai().getHinhthucgiamgia()));
            }
        }
        return list;
    }
    
    public SanPhamKhuyenMaiViewModle getOneee(String maSanPham, String maKhuyenMai){
        for (SanPhamKhuyenMaiViewModle s : search(maSanPham)) {
            if(s.getMakhuyenmai().equals(maKhuyenMai)){
                return s;
            }
        }
        return null;
    }

}
