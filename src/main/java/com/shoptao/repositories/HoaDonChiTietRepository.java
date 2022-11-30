package com.shoptao.repositories;

import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nguyen293
 */
public class HoaDonChiTietRepository {
    
    public List<HoaDonChiTiet> getListbyMaHD(String maHD){
        List<HoaDonChiTiet> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDonChiTiet where hoadon.ma = :mahd");
            query.setParameter("mahd", maHD);
            list = query.getResultList();
        }
        return list;
    }
    
    public HoaDonChiTiet getOne(String idHDCT){
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDonChiTiet where id = :idHDCT");
            query.setParameter("idHDCT", idHDCT);
            return (HoaDonChiTiet) query.getSingleResult();
        }
    }
    
    public boolean add(HoaDonChiTiet hdct){
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(hdct);
            trans.commit();
            return true;
        }catch(Exception e){
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
        }catch(Exception e){
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
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteAll(String maHD){
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            String hql = "DELETE HoaDonChiTiet hd where hd.hoadon.ma = :mahd";
            Query query = session.createQuery(hql);
            query.setParameter("mahd", maHD);
            query.executeUpdate();
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
