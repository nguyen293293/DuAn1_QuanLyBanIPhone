/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoptao.services.interfaces;

import java.util.List;

/**
 *
 * @author haih7
 */
public interface ChungService<T> {
<<<<<<< HEAD
     List<T> getList();
   String add(T t);
    String update( T t);
    T getOne(String id);
    List<T> Search(String search);
=======
    
    List<T> getList();
    
    String add(T t);
    
    String update(T t);
    
    T getOne(String ma);
    
    List<T> search(String ma);
>>>>>>> cf6d985c2be0a7046e8967f6b3eecfab37c74578
}
