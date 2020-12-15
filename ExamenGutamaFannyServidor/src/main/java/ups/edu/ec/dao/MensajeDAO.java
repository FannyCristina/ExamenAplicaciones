/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
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
public class MensajeDAO {

    
    @PersistenceContext(name="ExamenGutamaFannyServidorPersistenceUnit")
    private EntityManager em;
    
    public MensajeDAO(){
        
    }
    
    public boolean insert(Mensaje msj) throws Exception {
        boolean bandera = true;
    	try {
            System.out.println("si creo que llega aca");
            em.persist(msj);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso mensaje" + e.getMessage());   
        }
        return bandera;
    }
    
    public void update(Mensaje msj) throws Exception {
        try {
            em.merge(msj);
        } catch (Exception e) {
            throw new Exception("Erro actualizar mensaje " +e.getMessage());
        }
    }
    
    public List<Destinatario> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Destinatario.findByContenido");
            List<Destinatario> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar destinatarios " +e.getMessage());
        }
    }
    
   
 
        public List<Mensaje> listaMensajes(int codigo) throws Exception {

        try {
            Query q = em.createNamedQuery("Mensaje.findAllCodigo");
            q.setParameter("codigo",  "%" + codigo + "%");
            List<Mensaje> lis = q.getResultList();
            return lis;
        } catch (Exception e) {
            throw new Exception("Erro listar Mensaje " +e.getMessage());
        }

    }
    
    
}
