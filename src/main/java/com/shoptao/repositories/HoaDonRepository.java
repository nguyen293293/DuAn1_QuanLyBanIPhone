package com.shoptao.repositories;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nguyen293
 */
public class HoaDonRepository {

    public List<HoaDon> getList() {
        List<HoaDon> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDon order by ma desc");
            list = query.getResultList();
        }
        return list;
    }

    public HoaDon getOne(String mahd) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDon n where n.ma = :mahd order by n.ma asc");
            query.setParameter("mahd", mahd);
            System.out.println("HoaDonrepo : " + query.getResultList().size());
            return (HoaDon) query.getResultList().get(0);
        }
    }

    public boolean save(HoaDon hoaDon) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(hoaDon);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDon hoaDon) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.update(hoaDon);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<HoaDon> getListHoaDonTheoNgay(Date datebd,Date datekt, int trangthai) {

        List<HoaDon> listOutput = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "From HoaDon hoadon where hoadon.ngaythanhtoan between :datebd and :datekt and hoadon.trangthai = :trangthai";
            Query query = session.createQuery(hql);
            query.setParameter("datebd", datebd,TemporalType.DATE);
            query.setParameter("datekt", datekt,TemporalType.DATE);
            
            query.setParameter("trangthai", trangthai);

            listOutput = query.getResultList();
        }
        return listOutput;
    }

    public List<HoaDon> getListHoaDonTheoThang(int month, int year, int trangthai) {

        List<HoaDon> listOutput = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "From HoaDon hoadon where YEAR(hoadon.ngaythanhtoan) = :year and  MONTH(hoadon.ngaythanhtoan) = :month and hoadon.trangthai = :trangthai";
            Query query = session.createQuery(hql);

            query.setParameter("month", month);
            query.setParameter("year", year);
            query.setParameter("trangthai", trangthai);

            listOutput = query.getResultList();
        }
        return listOutput;
    }

    public List<HoaDon> getListHoaDonTheoNam(int year, int trangthai) {

        List<HoaDon> listOutput = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "From HoaDon hoadon where  YEAR(hoadon.ngaythanhtoan) = :year and hoadon.trangthai = :trangthai";
            Query query = session.createQuery(hql);

            query.setParameter("year", year);
            query.setParameter("trangthai", trangthai);

            listOutput = query.getResultList();
        }
        return listOutput;
    }

    public List<HoaDon> getListHoaDonTheoMaKM(String maKM) {
        List<HoaDon> listOutput = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "From HoaDon hoadon where  khuyenmai.ma = :maKM";
            Query query = session.createQuery(hql);
            query.setParameter("maKM", maKM);
            listOutput = query.getResultList();
        }
        return listOutput;
    }

}
