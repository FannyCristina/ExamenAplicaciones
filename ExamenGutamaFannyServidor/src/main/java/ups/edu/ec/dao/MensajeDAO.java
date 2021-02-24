/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
   public void insert(Mensaje mensaje) throws Exception {
        try {
            System.out.println("si creo que llega aca");
            em.persist(mensaje);
        } catch (Exception e) {
            throw new Exception("Erro ingreso Persona " + e.getMessage());
        }
    }

    public void delete(Mensaje mensaje) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(mensaje.getId()));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Persona " +e.getMessage());
        }
    }

    public void deleteId(int id) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(id));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Persona " +e.getMessage());
        }
    }
    
    public void update(Mensaje persona) throws Exception {
        try {
            em.merge(persona);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Persona " +e.getMessage());
        }
    }

    public Mensaje read(int id) throws Exception {
        try {
            return em.find(Mensaje.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer Persona " +e.getMessage());
        }
    }

    public List<Mensaje> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Mensaje.findAll");
            List<Mensaje> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Persona " +e.getMessage());
        }

    }

    public Mensaje findByCedula(int id) throws Exception {
        try {
            String jpql = "SELECT m FROM mensaje m "
                    + "WHERE id = :id";
            Query q = em.createQuery(jpql, Mensaje.class);
            q.setParameter("id", id);

            return (Mensaje) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  cedula");
        }

    }

    public int maxId() throws Exception {
        try {
            String jpql = "SELECT m FROM mensaje m "
                    + "WHERE id = :id";
            Query q = em.createQuery(jpql, Mensaje.class);
            return (int) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error MaxID", e.getCause());
        }
    }
    
      public void removeDestinatario(Mensaje men) {
 	   Mensaje p;
        try {
            p = read(men.getId());
            em.remove(p);
 	   System.out.println("Se fue  >>>>> ->>>>" +p.getId());
        } catch (Exception ex) {
            Logger.getLogger(MensajeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 	   
 	   
    }
    
    
}
