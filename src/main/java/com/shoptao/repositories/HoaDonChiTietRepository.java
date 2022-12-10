package com.shoptao.repositories;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nguyen293
 */
public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getListbyMaHD(String maHD) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDonChiTiet where hoadon.ma = :mahd");
            query.setParameter("mahd", maHD);
            list = query.getResultList();
        }
        return list;
    }

    public List<HoaDonChiTiet> getListHDCT() {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDonChiTiet");
            list = query.getResultList();
        }
        return list;
    }

    public HoaDonChiTiet getOne(String idHDCT) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            System.out.println("HoaDOnChiTIetRepo : 29 : idHDCT" + idHDCT);
            Query query = session.createQuery("From HoaDonChiTiet where id = :idHDCT");
            query.setParameter("idHDCT", idHDCT);
            return (HoaDonChiTiet) query.getResultList().get(0);
        }
    }

    public boolean add(HoaDonChiTiet hdct) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(hdct);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonChiTiet hdct) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.update(hdct);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(HoaDonChiTiet hdct) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.delete(hdct);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String idHDCT) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            String hql = "DELETE HoaDonChiTiet where id = :idHDCT";
            Query query = session.createQuery(hql);
            query.setParameter("idHDCT", idHDCT);
            query.executeUpdate();
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> getListThongKeSP() {
        List<Object[]> result = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "SELECT SUM(hdct.soluong),SUM(hdct.dongia * hdct.soluong),SUM(sanpham.gianhap * hdct.soluong) ,sanpham.id FROM HoaDonChiTiet hdct GROUP BY sanpham.id";
            result = session.createQuery(hql).list();
        }
        return result;
    }

    public List<Object[]> getListThongKeSPDay(int day,int month,int year, int trangthai) {
        List<Object[]> result = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "SELECT SUM(hdct.soluong),SUM(hdct.dongia * hdct.soluong),SUM(sanpham.gianhap * hdct.soluong) ,sanpham.id FROM HoaDonChiTiet hdct where YEAR(hoadon.ngaythanhtoan) = :year and  MONTH(hoadon.ngaythanhtoan) = :month and DAY(hoadon.ngaythanhtoan) = :day and hoadon.trangthai = :trangthai  GROUP BY sanpham.id";
            Query query = session.createQuery(hql);
            query.setParameter("day", day);
            query.setParameter("month", month);
            query.setParameter("year", year);
            query.setParameter("trangthai", trangthai);
            result = query.getResultList();
        }
        return result;
    }

    public List<Object[]> getListThongKeSPMonth(int month, int year, int trangthai) {
        List<Object[]> result = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "SELECT SUM(hdct.soluong),SUM(hdct.dongia * hdct.soluong),SUM(sanpham.gianhap * hdct.soluong) ,sanpham.id FROM HoaDonChiTiet hdct where YEAR(hoadon.ngaythanhtoan) = :year and  MONTH(hoadon.ngaythanhtoan) = :month and hoadon.trangthai = :trangthai GROUP BY sanpham.id";
            Query query = session.createQuery(hql);
            query.setParameter("month", month);
            query.setParameter("year", year);
            query.setParameter("trangthai", trangthai);

            result = query.getResultList();
        }
        return result;
    }

    public List<Object[]> getListThongKeSPYear(int year, int trangthai) {
        List<Object[]> result = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            String hql = "SELECT SUM(hdct.soluong),SUM(hdct.dongia * hdct.soluong),SUM(sanpham.gianhap * hdct.soluong) ,sanpham.id FROM HoaDonChiTiet hdct where YEAR(hoadon.ngaythanhtoan) = :year and hoadon.trangthai = :trangthai  GROUP BY sanpham.id";
            Query query = session.createQuery(hql);
            query.setParameter("year", year);
            query.setParameter("trangthai", trangthai);

            result = query.getResultList();
        }
        return result;
    }
}
