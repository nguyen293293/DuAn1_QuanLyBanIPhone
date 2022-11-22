/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.utilities;

import com.shoptao.domainmodel.NhanVien;

/**
 *
 * @author DEll
 */
public class UserHelper {
    public static NhanVien USER = null;
    
    public static void logout(){
        UserHelper.USER = null;
    }
    
    public static  boolean isLogin(){
        return UserHelper.USER != null;
    }
}
