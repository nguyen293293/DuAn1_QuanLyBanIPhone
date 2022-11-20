/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.repositories;

import com.shoptao.domainmodel.DongSanPham;
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
public class DongSanPhamRepository {

    public List<DongSanPham> getList() {
        List<DongSanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From DongSanPham");
            list = query.getResultList();
        }
        return list;
    }

    public String add(DongSanPham t) {
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

    public String update(DongSanPham t) {
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

    public DongSanPham getOneByTen(String ten) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("From DongSanPham where ten =: ten");
            query.setParameter("ten", ten);
            DongSanPham dongSanPham = (DongSanPham) query.getSingleResult();
            trans.commit();
            return dongSanPham;
        }
    }

}
