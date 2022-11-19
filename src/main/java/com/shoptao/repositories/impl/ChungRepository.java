/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.repositories.impl;

import java.util.List;

/**
 *
 * @author haih7
 */
public interface ChungRepository<T> {
    List<T> getList();
    String add(T t);
    String update( T t);
    T getOne(String id);
    
    List<T> Search(String search);
}
