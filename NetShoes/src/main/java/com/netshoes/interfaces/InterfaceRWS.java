/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.interfaces;

import com.netshoes.dtos.EnderecoDTO;
import com.netshoes.dtos.ResponseDTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author engcpp
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface InterfaceRWS { /** RWS extends from Restiful WebService **/
            
    @POST
    @Path("/findAddress")
    public EnderecoDTO findAddress(String zipCode);   
    
    
    @POST
    @Path("/getMyAddresses")
    public EnderecoDTO[] getMyAddresses();   

    @POST
    @Path("/saveAddress")
    public ResponseDTO saveAddresses(EnderecoDTO address); 
    
    @POST
    @Path("/updateAddress")
    public ResponseDTO updateAddresses(EnderecoDTO address);
    
    @POST
    @Path("/deleteAddress")
    public ResponseDTO deleteAddresses(String id);
    
    @POST
    @Path("/findMyAddressById")
    public EnderecoDTO findMyAddressById(String id);
}
