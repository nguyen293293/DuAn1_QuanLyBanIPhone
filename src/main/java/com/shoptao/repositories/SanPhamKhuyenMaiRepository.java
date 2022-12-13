/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.repositories;

import com.shoptao.domainmodel.SanPhamKhuyenMai;
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
public class SanPhamKhuyenMaiRepository {

    
    
     public List<SanPhamKhuyenMai> getList() {
        List<SanPhamKhuyenMai> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From SanPhamKhuyenMai");
            list = query.getResultList();
        }
        return list;
    }

    public boolean add(SanPhamKhuyenMai t) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(t);
            trans.commit();
           return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SanPhamKhuyenMai t) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();

            session.update(t);
            trans.commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
       public SanPhamKhuyenMai getOne(String id) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM SanPhamKhuyenMai where id = :id");
            query.setParameter("id", id);
            SanPhamKhuyenMai sanPhamKhuyenMai = (SanPhamKhuyenMai) query.getResultList().get(0);
            trans.commit();
            return sanPhamKhuyenMai;
        }
    }
    
    public boolean delete(String id) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "DELETE SanPhamKhuyenMai s WHERE s.id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                Integer result = query.executeUpdate();
                if (result == 0) {
                    return false;
                }
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                 return false;
            }

        }
         return true;
    }

}
