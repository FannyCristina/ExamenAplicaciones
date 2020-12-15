/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ups.edu.ec.modelo.Destinatario;
import ups.edu.ec.modelo.Mensaje;

/**
 *
 * @author Fanny
 */
@Stateless
public class DestinatarioDAO  {

    @PersistenceContext(name="ExamenGutamaFannyServidorPersistenceUnit")
    private EntityManager em;

    public DestinatarioDAO() {

    }
 public boolean insert(Destinatario des) throws Exception {
        boolean bandera = true;
    	try {
            System.out.println("si creo que llega aca");
            em.persist(des);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso mensaje" + e.getMessage());   
        }
        return bandera;
    }
       

    public void update(Destinatario des) throws Exception {
        try {
            em.merge(des);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Cliente " +e.getMessage());
        }
    }
    

 
   
    public List<Destinatario> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Destinatario.findAll");
            List<Destinatario> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar destinatarios " +e.getMessage());
        }

    }
    
    public List<Destinatario> findAllCodigo(int codigo) throws Exception {

        try {
            Query q = em.createNamedQuery("Destinatario.findAllCodigo");
            q.setParameter("codigo",  "%" + codigo + "%");
            List<Destinatario> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Destinatario " +e.getMessage());
        }

    }
    
    
   
    
}
