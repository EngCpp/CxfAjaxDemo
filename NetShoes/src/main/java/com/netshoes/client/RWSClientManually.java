/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.client;

import com.netshoes.interfaces.InterfaceRWS;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

/**
 *
 * @author engcpp
 */
public final class RWSClientManually {

    
    public RWSClientManually(){}
    
    public static void main(String args[]) throws Exception {
        InterfaceRWS rws =
        JAXRSClientFactory.create("http://localhost:8080/NetShoes/rws", 
                                                   InterfaceRWS.class);                       
               
        //EnderecoDTO endereco = rws.findAddress("08080650");
        //System.out.println(endereco);

    }

}