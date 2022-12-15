package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.repositories.HoaDonRepository;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;
import com.shoptao.services.ChungServices;
import java.util.Date;

/**
 *
 * @author nguyen293
 */
public class HoaDonService implements ChungServices<HoaDonViewModel>,com.shoptao.services.HoaDonService {

    private final HoaDonRepository hoaDonRepository;

    public HoaDonService() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<HoaDonViewModel> getList() {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon x : hoaDonRepository.getList()) {
            list.add(new HoaDonViewModel(x.getMa(), x.getNgaytao(), x.getNgaythanhtoan(), x.getTrangthai(),
                    x.getKhachhang().getHoten(), x.getNhanvien().getHoten(), x.getTongtien(), x.getTienkhachdua()));
        }
        return list;
    }

    @Override
    public String add(HoaDonViewModel t, Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(HoaDonViewModel t, Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonViewModel getOne(String ma) {
        HoaDon hoaDon = hoaDonRepository.getOne(ma);
        return new HoaDonViewModel(hoaDon.getMa(), hoaDon.getNgaytao(), hoaDon.getNgaythanhtoan(),
                hoaDon.getTrangthai(), hoaDon.getKhachhang().getHoten(), hoaDon.getNhanvien().getHoten(),
                hoaDon.getTongtien(), hoaDon.getTienkhachdua());
    }

    @Override
    public List<HoaDonViewModel> search(String ma) {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDonViewModel x : getList()) {
            if(x.getMa().startsWith(ma.toUpperCase())){
                list.add(x);
            }
        }
        return list;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<HoaDonViewModel> searchbydate(Date ngaybd, Date ngaykt) {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDonViewModel x : getList()) {
            if(x.getNgaytao().compareTo(ngaybd) >= 0 && x.getNgaytao().compareTo(ngaykt) <= 0){
                list.add(x);
            }
        }
        return list;
    }
    
    public List<HoaDonViewModel> searchbytrangthai(int trangthai) {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDonViewModel x : getList()) {
            if(x.getTrangthai() == trangthai){
                list.add(x);
            }
        }
        return list;
    }
    
     @Override
    public List<HoaDonViewModel> getListHoaDonTheoNgay(Date datebd,Date datekt, int trangthai) {
          List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon x : hoaDonRepository.getListHoaDonTheoNgay(datebd,datekt,trangthai)) {
               list.add(new HoaDonViewModel(x.getMa(), x.getNgaytao(), x.getNgaythanhtoan(), x.getTrangthai(),
                    x.getKhachhang().getHoten(), x.getNhanvien().getHoten(), x.getTongtien(), x.getTienkhachdua()));
        }
        return list;
    }

    @Override
    public List<HoaDonViewModel> getListHoaDonTheoThang(int month, int year, int trangthai) {
         List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon x : hoaDonRepository.getListHoaDonTheoThang(month, year, trangthai)) {
              list.add(new HoaDonViewModel(x.getMa(), x.getNgaytao(), x.getNgaythanhtoan(), x.getTrangthai(),
                    x.getKhachhang().getHoten(), x.getNhanvien().getHoten(), x.getTongtien(), x.getTienkhachdua()));
        }
        return list;
    }

    @Override
    public List<HoaDonViewModel> getListHoaDonTheoNam(int year, int trangthai) {
          List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon x : hoaDonRepository.getListHoaDonTheoNam(year, trangthai)) {
              list.add(new HoaDonViewModel(x.getMa(), x.getNgaytao(), x.getNgaythanhtoan(), x.getTrangthai(),
                    x.getKhachhang().getHoten(), x.getNhanvien().getHoten(), x.getTongtien(), x.getTienkhachdua()));
        }
        return list;
    }

    @Override
    public List<HoaDonViewModel> getListHoaDonTheoMaKM(String maKM) {
       List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon x : hoaDonRepository.getListHoaDonTheoMaKM(maKM)) {
              list.add(new HoaDonViewModel(x.getMa(), x.getNgaytao(), x.getNgaythanhtoan(), x.getTrangthai(),
                    x.getKhachhang().getHoten(), x.getNhanvien().getHoten(), x.getTongtien(), x.getTienkhachdua()));
        }
        return list;
    }
}
