package com.shoptao.services.impl;

import com.shoptao.domainmodel.NhanVien;
import com.shoptao.repositories.NhanVienRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.NhanVienViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haih7
 */
public class NhanVienService implements ChungService<NhanVienViewModel> {

    private final NhanVienRepository nhanVienRepository;

    public NhanVienService() {
        this.nhanVienRepository = new NhanVienRepository();
    }

    @Override
    public List<NhanVienViewModel> getList() {

        List<NhanVienViewModel> listNhanVienVM = new ArrayList<>();

        for (NhanVien x : nhanVienRepository.getList()) {
            listNhanVienVM.add(new NhanVienViewModel(x.getMa(), x.getHoten(), x.getGioitinh(),
                    x.getNgaysinh(), x.getSdt(), x.getEmail(), x.getDiachi(), x.getMatkhau(),
                    x.getVaitro(), x.getTrangthai()));
        }

        return listNhanVienVM;
    }

    @Override
    public String add(NhanVienViewModel t, Object ...obj) {
        NhanVien nhanVien = new NhanVien(null, t.getMa(), t.getHoten(), t.getGioitinh(),
                t.getNgaysinh(), t.getSdt(), t.getEmail(), t.getDiachi(), t.getMatkhau(),
                t.getVaitro(), t.getTrangthai());
        boolean isAdd = nhanVienRepository.save(nhanVien);
        return isAdd ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String update(NhanVienViewModel t, Object ...obj) {
        NhanVien nhanVien = new NhanVien(null, t.getMa(), t.getHoten(), t.getGioitinh(),
                t.getNgaysinh(), t.getSdt(), t.getEmail(), t.getDiachi(), t.getMatkhau(),
                t.getVaitro(), t.getTrangthai());
        for (NhanVien x : nhanVienRepository.getList()) {
            if (x.getMa().equals(nhanVien.getMa())) {
                nhanVien.setId(x.getId());
            }
        }
        boolean isUpdate = nhanVienRepository.update(nhanVien);
        return isUpdate ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public NhanVienViewModel getOne(String ma) {
        NhanVien x = nhanVienRepository.getOne(ma);
        return new NhanVienViewModel(x.getMa(), x.getHoten(), x.getGioitinh(),
                x.getNgaysinh(), x.getSdt(), x.getEmail(), x.getDiachi(), x.getMatkhau(),
                x.getVaitro(), x.getTrangthai());
    }

    @Override
    public List<NhanVienViewModel> search(String ma) {
        List<NhanVienViewModel> listNhanVienVM = new ArrayList<>();

        for (NhanVien x : nhanVienRepository.getList()) {
            if (x.getMa().startsWith(ma)) {
                listNhanVienVM.add(new NhanVienViewModel(x.getMa(), x.getHoten(), x.getGioitinh(),
                        x.getNgaysinh(), x.getSdt(), x.getEmail(), x.getDiachi(), x.getMatkhau(),
                        x.getVaitro(), x.getTrangthai()));
            }
        }
        return listNhanVienVM;
    }
}
