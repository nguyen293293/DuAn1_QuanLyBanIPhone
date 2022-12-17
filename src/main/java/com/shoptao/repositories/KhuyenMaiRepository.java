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
            Query query = session.createQuery("FROM KhuyenMai  ORDER BY ma desc");
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean delete(String ma) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            Query query = session.createQuery("delete KhuyenMai where ma = :ma");
            query.setParameter("ma", ma);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public KhuyenMai getOne(String ma) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM KhuyenMai where ma = :ma");
            query.setParameter("ma", ma);
            KhuyenMai khuyenMai = (KhuyenMai) query.getSingleResult();
            trans.commit();
            return khuyenMai;
        }
    }

    public List<KhuyenMai> fillterTrangThai(int trangThai) {
        List<KhuyenMai> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM KhuyenMai km where km.trangthai = :trangthai  ORDER BY ma desc");
            query.setParameter("trangthai", trangThai);

            list = query.getResultList();
        }
        return list;
    }

    public List<KhuyenMai> fillterHieuLuc(int hieuluc) {
        List<KhuyenMai> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM KhuyenMai km where km.hieuluc = :hieuluc  ORDER BY ma desc");
            query.setParameter("hieuluc", hieuluc);

            list = query.getResultList();
        }
        return list;
    }
}
