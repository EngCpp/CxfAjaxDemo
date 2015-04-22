/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.utils;

/**
 *
 * @author engcpp
 */
public class StringUtils {
   
    
    public static String justNumbers(String str){
        String numbers = "0123456789";
        String ret="";
        
        for (int i=0; i<str.length(); i++){
            char digit = str.charAt(i);
            if(numbers.indexOf(digit)>=0)
               ret+=digit;
        }
    
        return ret;
    }
}
