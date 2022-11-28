package com.shoptao.repositories;

import com.shoptao.domainmodel.KhachHang;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author haih7
 */
public class SanPhamRepository {

    public SanPhamRepository() {
    }


    

    public List<SanPham> getList() {
        List<SanPham> listSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From SanPham");
            listSP = query.getResultList();
        }
       
        return listSP;
    }

    public String add(SanPham t) {

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(t);
            trans.commit();
            return "Thanh cong";
        } catch (Exception e) {
            e.printStackTrace();
            return "That bai";
        }

    }

    public String update(SanPham t) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.update(t);
            trans.commit();
            return "Thanh cong";
        } catch (Exception e) {
            e.printStackTrace();
            return "That bai";
        }

    }

    public SanPham getOne(String ma) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM SanPham where ma =: ma");
            query.setParameter("ma", ma);
            SanPham sanPham = (SanPham) query.getSingleResult();
            trans.commit();
            return sanPham;
        }
    }

    public List<SanPham> search(String search) {
      try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction trans = session.beginTransaction();
            if (search == null) {
                search = "%";
            } else {
                search = "%" + search + "%";
            }
//or ten like: search or dungluong like: search
            Query query = session.createQuery("From SanPham where ma like: search");
            query.setParameter("search", search);
//            query.setParameter("search", search);
//            query.setParameter("search", search);
            List<SanPham> x = query.getResultList();
          
            trans.commit();
            session.close();
            return x;
        }  

}
    
    //getList chứa km và notkm
    
     public List<SanPham> getListKM(){
        List<SanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From SanPham where idkhuyenmai is not null");
            list = query.getResultList();
        }
        return list;
    }
     
         public List<SanPham> getListNotKM(){
        List<SanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From SanPham where idkhuyenmai is null");
            list = query.getResultList();
        }
        return list;
    }
}
