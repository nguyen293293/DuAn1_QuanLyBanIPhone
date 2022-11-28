/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.repositories;

import com.shoptao.domainmodel.KhuyenMai;
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
public class KhuyenMaiRepository {
      public List<KhuyenMai> getList() {
        List<KhuyenMai> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM KhuyenMai");
            list = query.getResultList();
        }
        return list;
    }

    public boolean add(KhuyenMai t) {
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

    public boolean update(KhuyenMai t) {
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

//    public MauSac getOne(String ma) {
//        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
//            Transaction trans = session.beginTransaction();
//            Query query = session.createQuery("FROM SanPham where ma =: ma");
//            query.setParameter("ma", ma);
//            MauSac mauSac = (MauSac) query.getSingleResult();
//            trans.commit();
//            return mauSac;
//        }
//    }

    public List<KhuyenMai> Search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
