/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author engcpp
 */
@XmlRootElement(name = "ResponseDTO", namespace = "urn:dtos.netshoes.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDTO {
    @XmlElement(name="message", required = true)    
    private String message;
    
    @XmlElement(name="message", required = true)
    private boolean error;
    
    public ResponseDTO(){}
    public ResponseDTO(String message){
        this.message = message;
    }
    
    public ResponseDTO(String message, boolean error){
        this.message = message;
        this.error   = error;
    }    
    
    public void setMessage(String message){
       this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setError(boolean error){
        this.error = error;
    }
    
    public Boolean getError(){
        return error;
    }
}
