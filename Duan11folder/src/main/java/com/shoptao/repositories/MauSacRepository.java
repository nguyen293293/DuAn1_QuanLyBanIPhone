/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.repositories;

import com.shoptao.domainmodel.MauSac;
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
public class MauSacRepository {

    public List<MauSac> getList() {
        List<MauSac> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From MauSac");
            list = query.getResultList();
        }
        return list;
    }

    public String add(MauSac t) {
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

    public String update(MauSac t) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();

            session.update(t);
            trans.commit();
            return "Thanh Cong";
        } catch (Exception e) {
            e.printStackTrace();
            return "ThatBai";
        }

    }

    public MauSac getOneByTen(String ten) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("From MauSac where ten =: ten");
            query.setParameter("ten", ten);
            MauSac mauSac = (MauSac) query.getSingleResult();
            trans.commit();
            return mauSac;
        }
    }


}
