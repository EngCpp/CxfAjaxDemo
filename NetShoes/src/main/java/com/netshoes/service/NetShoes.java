/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.service;

import com.netshoes.dtos.EnderecoDTO;
import com.netshoes.dtos.ResponseDTO;
import com.netshoes.interfaces.InterfaceRWS;
import com.netshoes.interfaces.InterfaceSWS;
import com.netshoes.model.bo.Management;
import com.netshoes.model.vo.Bairro;
import com.netshoes.model.vo.Cidade;
import com.netshoes.model.vo.Endereco;
import com.netshoes.model.vo.Uf;
import com.netshoes.utils.StringUtils;
import java.util.HashMap;
import javax.jws.WebService;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

/**
 *
 * @author engcpp
 */
@WebService
@CrossOriginResourceSharing(allowAllOrigins = true)
public class NetShoes implements InterfaceSWS, InterfaceRWS {
    private HashMap<String, EnderecoDTO>myAddresses = new HashMap<>();

    /**
     *
     * @param zipCode
     * @return
     * @throws Exception
     */
    @Override
    public EnderecoDTO findAddress(String zipCode) {   
        if (zipCode!=null){
            
            Management management = new Management();
            Endereco   endereco = null;
            char[] zipCodeNumeric = StringUtils.justNumbers(zipCode).toCharArray(); // ensure just numbers
            int    pos = zipCodeNumeric.length-1;

            do {

                endereco = management.findEnderecoByCep(new String(zipCodeNumeric));
                
                if (endereco==null) {   
                    zipCodeNumeric[pos] = '0';
                    pos--;
                }
                
           } while (endereco==null && pos>=0);

           if (endereco==null)
              return new EnderecoDTO("Invalid ZipCode");        

            Bairro bairro = endereco.getBairro();
            Cidade cidade = bairro.getCidade();
            Uf     uf     = cidade.getUf();

            EnderecoDTO ret = new EnderecoDTO();
                        ret.setId(String.valueOf(endereco.getEnderecoCodigo()));
                        ret.setBairro(bairro.getBairroDescricao());
                        ret.setCidade(cidade.getCidadeDescricao());
                        ret.setEstado(uf.getUfSigla());
                        ret.setRua(endereco.getEnderecoLogradouro());
                        ret.setCep(endereco.getEnderecoCep());


            return ret;

        }
        
        return new EnderecoDTO("ZipCode string is empty");
    }

    @Override
    public EnderecoDTO[] getMyAddresses() {
        EnderecoDTO[] ret = new EnderecoDTO[myAddresses.size()];
        return myAddresses.values().toArray(ret);
    }

    @Override
    public EnderecoDTO findMyAddressById(String id) {
        EnderecoDTO dto = myAddresses.get(id);
        return dto;
    }    
    
    boolean validate(EnderecoDTO address){
        
        if (address.getRua().isEmpty()    ||
            address.getNumero().isEmpty() ||
            address.getCep().isEmpty()    ||
            address.getCidade().isEmpty() ||
            address.getEstado().isEmpty())
           return false;
                
        return true;
    }
    
    @Override
    public ResponseDTO saveAddresses(EnderecoDTO address) {
        if (!validate(address))
            return new ResponseDTO("Invalid Address", true);
        
        if (address.getId()==null)
            address.setId(String.valueOf(myAddresses.size()+1));
        
        if (myAddresses.containsKey(address.getId())) {
            return new ResponseDTO("Field Alredy Inserted", true);
        } else {
            myAddresses.put(address.getId(), address);                
            return new ResponseDTO("Address added successfully");
       }
    }

    @Override
    public ResponseDTO updateAddresses(EnderecoDTO address) {
        if (!validate(address))
            return new ResponseDTO("Invalid Address", true);
        
        if (!myAddresses.containsKey(address.getId()))
            return new ResponseDTO("Field not inserted before", true);
        else {
            myAddresses.remove(address.getId());
            myAddresses.put(address.getId(), address);                
            return new ResponseDTO("Address updated successfully!");
       }        
    }

    @Override
    public ResponseDTO deleteAddresses(String id) {
        if (myAddresses.containsKey(id)) {
            myAddresses.remove(id);
            return new ResponseDTO("Address deleted successfully!");
        } else
            return new ResponseDTO("Addess do not exist!", true);
    }
}
