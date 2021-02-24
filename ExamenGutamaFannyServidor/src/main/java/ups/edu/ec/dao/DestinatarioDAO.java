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
public class DestinatarioDAO {

    @PersistenceContext(name = "ExamenGutamaFannyServidorPersistenceUnit")
    private EntityManager em;

    public DestinatarioDAO() {

    }

    public void insert(Destinatario destinatario) throws Exception {
        try {
            em.persist(destinatario);
        } catch (Exception e) {
            throw new Exception("Erro ingreso telefono", e);
        }
    }

    public void delete(int id) throws Exception {
        try {
            em.remove(id);
        } catch (Exception e) {
            throw new Exception("Erro Eliminar telefono", e);
        }
    }

    public void update(Destinatario destinatario) throws Exception {
        try {
            em.merge(destinatario);
        } catch (Exception e) {
            throw new Exception("Erro actualizar telefono", e);
        }
    }

    public Destinatario read(int id) throws Exception {
        try {
            return em.find(Destinatario.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer telefono");
        }
    }

    public List<Destinatario> findAll() throws Exception {

        try {
            String jpql = "SELECT P FROM destinatario p ";
            Query q = em.createQuery(jpql, Destinatario.class);
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro listar Telefono");
        }

    }

    public List<Destinatario> findByPersona(int id) throws Exception {

        try {
            Query q = em.createNamedQuery("Destinatario.findByMensaje");
            q.setParameter("id", id);
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro listar Telefono /n" + e.getMessage());
        }

    }

}
