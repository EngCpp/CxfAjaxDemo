/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.dtos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author engcpp
 */

@XmlRootElement(name = "Endereco", namespace = "urn:dtos.netshoes.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnderecoDTO implements Serializable {
    @XmlElement(name="responseId", required = true)
    private String  id;
    @XmlElement(name="responseNumero", required = true)
    private String numero;
    @XmlElement(name="responseRua", required = true)
    private String rua;
    @XmlElement(name="responseBairro", required = true)
    private String bairro;
    @XmlElement(name="responseCidade", required = true)
    private String cidade;
    @XmlElement(name="responseEstado", required = true)
    private String estado;
    
    @XmlElement(name="responseCep", required = true)
    private String cep;
    
    @XmlElement(name="responseErr", required = true)
    private String err;
    
    public EnderecoDTO(){}
    public EnderecoDTO(String err){
        this.err = err;
    }
    public EnderecoDTO(String   id,
                     String numero,
                     String rua,
                     String bairro,
                     String cidade,
                     String estado,
                     String cep){
        
        this.id      = id;
        this.numero  = numero;
        this.rua     = rua;
        this.bairro  = bairro;
        this.cidade  = cidade;
        this.estado  = estado;
        this.cep     = cep;        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }    

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }   
    
    public String getErr(){
        return err;
    }
}