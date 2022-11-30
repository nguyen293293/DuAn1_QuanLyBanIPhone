/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.repositories;

import com.shoptao.domainmodel.Imei;
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
public class ImeiRepository {
      public List<Imei> getList() {
        List<Imei> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From Imei");
            list = query.getResultList();
        }
        return list;
    }

    public boolean add(Imei t) {
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

    public boolean update(Imei t) {
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

//    public DongSanPham getOne(String ma) {
//        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
//            Transaction trans = session.beginTransaction();
//            Query query = session.createQuery("FROM SanPham where ma =: ma");
//            query.setParameter("ma", ma);
//            DongSanPham dongSanPham = (DongSanPham) query.getSingleResult();
//            trans.commit();
//            return dongSanPham;
//        }
//    }

//    public List<Imei> Search(String search) {
//        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
//            Transaction trans = session.beginTransaction();
//           
//            Query query = session.createQuery("FROM Imei AS p WHERE p.sanpham.idsanpham =: search");
//            query.setParameter("search", search);
//
//            List<Imei> x = query.getResultList();
//          
//            trans.commit();
//            session.close();
//            return x;
//        }catch(Exception e){
//            e.printStackTrace();
//        }  
//        return null;
//    
//    }
}
