/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.DongSanPham;
import com.shoptao.domainmodel.MauSac;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.DongSanPhamRepository;
import com.shoptao.repositories.MauSacRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.ArrayList;
import java.util.List;
import com.shoptao.services.ChungServices;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haih7
 */
public class SanPhamService implements ChungServices<SanPhamViewModle>,com.shoptao.services.SanPhamService {

    public SanPhamRepository sanPhamRepository = new SanPhamRepository();
    public DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();
    public MauSacRepository mauSacRepository = new MauSacRepository();

    public SanPhamService() {

    }

    @Override
    public List<SanPhamViewModle> getList() {

        List<SanPhamViewModle> listSPVM = new ArrayList<>();

        for (SanPham sanPham : sanPhamRepository.getList()) {
            listSPVM.add(new SanPhamViewModle(sanPham.getId(), sanPham.getMa(), sanPham.getTen(), sanPham.getDungluong(), sanPham.getSoluongton(), sanPham.getNambaohanh(), sanPham.getGianhap(), sanPham.getGiaban(), sanPham.getMota(), sanPham.getAnhsanpham(), sanPham.getBarcode(), sanPham.getTrangthai(), sanPham.getDongsanpham().getTen(), sanPham.getMausac().getTen()));
        }
        return listSPVM;
    }

    @Override
    public String add(SanPhamViewModle t, Object... ob) {

        DongSanPham ds = dongSanPhamRepository.getList().get((int) ob[0]);
        MauSac ms = mauSacRepository.getList().get((int) ob[1]);
        SanPham sanPham = new SanPham(null, genmahd(), t.getTen(), t.getDungluong(), t.getSoluongton(), t.getNambaohanh(), t.getGianhap(), t.getGiaban(), t.getMota(), t.getAnhsanpham(), autogenousBarCode(), t.getTrangthai(), ds, ms);
        String isSave = sanPhamRepository.add(sanPham);
        if (isSave.equals("Thanh cong")) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    public String autogenousBarCode() {
        int maQuocGia = 893;
        int maDoanhNghiep = 4481;
        int maHangHoa = 0;
        int soKiemTra = 2;

        List<SanPham> list = sanPhamRepository.getList();
        if (list.size() == 0) {
            maHangHoa = 10000;
            return String.valueOf(maQuocGia) + String.valueOf(maDoanhNghiep) + String.valueOf(maHangHoa) + String.valueOf(soKiemTra);
        } else {
            int num = list.size() + 1;
            maHangHoa = 10000 + num;
            return String.valueOf(maQuocGia) + String.valueOf(maDoanhNghiep) + String.valueOf(maHangHoa) + String.valueOf(soKiemTra);
        }

    }

    private String genmahd() {
        List<SanPham> list = sanPhamRepository.getList();
        if (list.size() == 0) {
            return "SP001";
        } else {
            int num = list.size() + 1;
            return "SP" + (String.format("%03d", num));
        }
    }

    @Override
    public String update(SanPhamViewModle t, Object... ob) {
        DongSanPham ds = dongSanPhamRepository.getList().get((int) ob[0]);
        MauSac ms = mauSacRepository.getList().get((int) ob[1]);
        SanPham sanPham = sanPhamRepository.getOne(t.getMa());

        
        sanPham.setMa(t.getMa());
        sanPham.setTen(t.getTen());
        sanPham.setNambaohanh(t.getNambaohanh());
        sanPham.setDungluong(t.getDungluong());
        sanPham.setSoluongton(t.getSoluongton());
        sanPham.setGianhap(t.getGianhap());
        sanPham.setGiaban(t.getGiaban());
//        sanPham.setBarcode(t.getBarcode());
        sanPham.setAnhsanpham(t.getAnhsanpham());
        sanPham.setMota(t.getMota());
        sanPham.setTrangthai(t.getTrangthai());
        sanPham.setDongsanpham(ds);
        sanPham.setMausac(ms);

//        for (SanPham x : sanPhamRepository.getList()) {
//            if (x.getMa().equals(sanPham.getMa())) {
//                sanPham.setId(x.getId());
//            }
//        }
        String isUpdate = sanPhamRepository.update(sanPham);
        if (isUpdate.equals("Thanh cong")) {
            return "Cap nhat thành công";
        } else {
            return "Cap nhat thất bại";
        }

    }

    public String updatevs2(SanPhamViewModle t) {

        SanPham sanPham = sanPhamRepository.getOne(t.getMa());
        sanPham.setGiaban(t.getGiaban());

        String isUpdate = sanPhamRepository.update(sanPham);
        if (isUpdate.equals("Thanh cong")) {
            return "Cap nhat thành công";
        } else {
            return "Cap nhat thất bại";
        }

    }

    @Override
    public SanPhamViewModle getOne(String ma) {
        SanPham x = sanPhamRepository.getOne(ma);
        SanPhamViewModle sanPhamViewModle = new SanPhamViewModle(x.getId(), x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getNambaohanh(), x.getGiaban(), x.getGianhap(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getMausac().getTen());
        return sanPhamViewModle;
    }

    public SanPhamViewModle getOnebyId(String id) {
        SanPham x = sanPhamRepository.getOnebyId(id);
        SanPhamViewModle sanPhamViewModle = new SanPhamViewModle(x.getId(), x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getNambaohanh(), x.getGiaban(), x.getGianhap(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getMausac().getTen());
        return sanPhamViewModle;
    }

    @Override
    public List<SanPhamViewModle> search(String ma) {
        List<SanPhamViewModle> listSPVM = new ArrayList<>();

        for (SanPhamViewModle x : getList()) {
            if (x.getMa().startsWith(ma)) {
                listSPVM.add(x);
            }
        }
        return listSPVM;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamViewModle> getListSPByMaDSP(String ma) {
          List<SanPhamViewModle> listSPVM = new ArrayList<>();

        for (SanPham sanPham : sanPhamRepository.getListSPByMaDSP(ma)) {
            listSPVM.add(new SanPhamViewModle(sanPham.getId(), sanPham.getMa(), sanPham.getTen(), sanPham.getDungluong(), sanPham.getSoluongton(), sanPham.getNambaohanh(), sanPham.getGianhap(), sanPham.getGiaban(), sanPham.getMota(), sanPham.getAnhsanpham(), sanPham.getBarcode(), sanPham.getTrangthai(), sanPham.getDongsanpham().getTen(), sanPham.getMausac().getTen()));
        }
        return listSPVM;
    }

    @Override
    public List<SanPhamViewModle> getListSPByMaMS(String ma) {
         List<SanPhamViewModle> listSPVM = new ArrayList<>();

        for (SanPham sanPham : sanPhamRepository.getListSPByMaMS(ma)) {
            listSPVM.add(new SanPhamViewModle(sanPham.getId(), sanPham.getMa(), sanPham.getTen(), sanPham.getDungluong(), sanPham.getSoluongton(), sanPham.getNambaohanh(), sanPham.getGianhap(), sanPham.getGiaban(), sanPham.getMota(), sanPham.getAnhsanpham(), sanPham.getBarcode(), sanPham.getTrangthai(), sanPham.getDongsanpham().getTen(), sanPham.getMausac().getTen()));
        }
        return listSPVM;
    }

}
