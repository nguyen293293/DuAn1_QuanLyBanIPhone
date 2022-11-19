package com.shoptao.repositories;

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

    public List<SanPham> getList() {

        List<SanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From SanPham");
            list = query.getResultList();
        }
        return list;
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
            Query query = session.createQuery("FROM SanPham where ma like: search or ten like: search or dungluong like: search ");
            query.setParameter("search", search);
            query.setParameter("search", search);
            query.setParameter("search", search);
            List<SanPham> sanPhams = query.getResultList();
            trans.commit();

            return sanPhams;
        }
    }

}
