/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author haih7
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MauSacViewModel {

    private String ma;
    private String ten;
    
     public Object[] toDataRow() {
         int i = 0;
        return new Object[]{(i = i+1),ma,ten};
    }
}
