/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.interfaces;

import com.netshoes.dtos.EnderecoDTO;
import com.netshoes.dtos.ResponseDTO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author engcpp
 */

@WebService
public interface InterfaceSWS {/** RWS extends from Soap WebService **/
        
    @WebMethod(operationName = "findAddress")
    public EnderecoDTO findAddress(@WebParam(name = "zipCode")String zipCode);
    
    @WebMethod(operationName = "findMyAddressById")
    public EnderecoDTO findMyAddressById(@WebParam(name = "id")String id);
    
    @WebMethod(operationName = "getMyAddresses")
    public EnderecoDTO[] getMyAddresses();   

    @WebMethod(operationName = "saveAddress")
    public ResponseDTO saveAddresses(@WebParam(name = "address")EnderecoDTO address); 
    
    @WebMethod(operationName = "updateAddress")
    public ResponseDTO updateAddresses(@WebParam(name = "address")EnderecoDTO address);
    
    @WebMethod(operationName = "deleteAddress")
    public ResponseDTO deleteAddresses(@WebParam(name = "id")String id);    
}
