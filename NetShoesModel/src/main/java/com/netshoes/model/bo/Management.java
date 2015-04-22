/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netshoes.model.bo;

import com.netshoes.model.vo.Endereco;
import com.netshoes.utils.HibernateUtil;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author engcpp
 */
public class Management {
    private static SessionFactory factory;
    private static Transaction tr;
    private static Session session;
    
    public static Session getSession() {
      if (factory == null)
          factory = HibernateUtil.getSessionFactory();
      
      Session hibernateSession;
      try{
              hibernateSession = factory.getCurrentSession();
      }catch(Exception e){
              hibernateSession = factory.openSession();     
      }
      
      return hibernateSession;
    }    
    
    public Management(){}
    
    private void beginTransaction(){
       session = getSession();
            tr = session.beginTransaction();
    } 
    
    public void save(Collection<? extends Object> list) throws Exception {
        this.beginTransaction();
            for (Object obj : list)
                session.save(obj);
        tr.commit();
        session.close();
    }
    
    public void save(Object obj) throws Exception {
        this.beginTransaction();
            session.save(obj);
        tr.commit();
        session.close();
    }
    
    
    public Endereco findEnderecoByCep(String cep){
        Endereco endereco = null;
        try{
            session = getSession();

            Query qry = session.createQuery("select o from Endereco o where o.enderecoCep = :cep");
                  qry.setParameter("cep", cep);
                  List profiles = qry.list();
                  
                  if (profiles.size()>0)
                    endereco = (Endereco)profiles.get(0);
            
        } finally {
            session.close();
        }
        
        return endereco;
    }    
    
    
    /*
    public Models createModel(String description, Long parentId){        
        try {    
            
            if (findModel(description)!=null)
                return null;
            
            this.beginTransaction();

            Models models = new Models(0, description, parentId);
            
            this.session.save(models);
                                      
            tr.commit();
            
            return models;
            
        } catch(Exception e) {
           if (tr.isActive())
               tr.rollback();
            
           return null;
        }
    }          
    
    public List<Resources> findResourcesByGameId(long gameId){
        List<Resources>ret = new ArrayList<>();
        
        try{
            session = getSession();
            
            Query qry = session.createQuery("select o from Resources o where o.gameid = :gameId");
                  qry.setParameter("gameId", gameId);
                  ret = qry.list();                 
                              
        } catch(Exception e) {           
           ret = new ArrayList<>();
        } finally {
            session.close();
        }
        
        return ret;
    }   
   
       
    public boolean deleteResourceBylId(long id){
        try{
            this.beginTransaction();

            Query qry = session.createQuery("delete from Resources o where o.id = :id");
                  qry.setParameter("id", id);                                    
                  qry.executeUpdate();
                    
                  
            tr.commit();
            return true;
        } catch(Exception e) {
           if (tr.isActive())
               tr.rollback();
          
           return false;
        } finally {
           session.close();
        }         
    }    
 */     
}
