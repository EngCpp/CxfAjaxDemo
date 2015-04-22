/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.client;

import com.netshoes.dtos.EnderecoDTO;
import com.netshoes.interfaces.InterfaceSWS;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 *
 * @author engcpp
 */
public final class WSClientManually {

    private static final QName SERVICE_NAME 
        = new QName("http://interfaces.netshoes.com/", "NetShoesService");   
    private static final QName PORT_NAME 
        = new QName("http://interfaces.netshoes.com/", "NetShoesPort");

    public static void main(String args[]) throws Exception {
        Service service = Service.create(SERVICE_NAME);
        // Endpoint EnderecoDTO
        String endpointAddress = "http://localhost:8080/NetShoes/sws";
                                  
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        InterfaceSWS ws = service.getPort(InterfaceSWS.class);
        
        //EnderecoDTO endereco = ws.findAddress("08080650");
        //System.out.println(endereco);
    }
}