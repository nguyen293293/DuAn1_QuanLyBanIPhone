package com.shoptao.services;

import java.util.List;

/**
 *
 * @author haih7
 */
public interface ChungService<T> {
    
    List<T> getList();
    
    String add(T t, Object ...obj);
    
    String update(T t, Object ...obj);
    
    T getOne(String ma);
    
    List<T> search(String ma);
}
