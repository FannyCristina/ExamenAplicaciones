/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.on;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import ups.edu.ec.dao.DestinatarioDAO;
import ups.edu.ec.dao.MensajeDAO;
import ups.edu.ec.modelo.Destinatario;
import ups.edu.ec.modelo.Mensaje;

/**
 *
 * @author Fanny
 */
@Stateless
public class GestionMensajeON implements GestionMensajeRemoto {

    @Inject
    private DestinatarioDAO destinatarioDAO;
    @Inject
    private MensajeDAO mensajeDAO;

    public boolean guardadoMensaje(Mensaje mensaje) throws Exception {
        try {
            mensajeDAO.insert(mensaje);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return true;
    }

    public List<Mensaje> listarMensajes() throws Exception {
        try {
            System.out.println("this is site");
            // PersonaDAO p = new PersonaDAO();
            return mensajeDAO.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Destinatario> listarDestinatario(int id) throws Exception {
        try {
            return destinatarioDAO.findByPersona(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarDestinatario(int p) throws Exception {
        try {
            destinatarioDAO.delete(p);
        } catch (Exception e) {
            throw new Exception("Error 1 " + e.getMessage());
        }

    }

    public void actualizarDestinatario(List<Destinatario> d) {
        try {
            for (Destinatario des : d) {
                destinatarioDAO.update(des);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            // throw new Exception("No se puede Actualizar contacto");
        }

    }

    public Mensaje listarMensajes(Mensaje p) {
        Mensaje aux = null;
        try {
            aux = mensajeDAO.read(p.getId());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return aux;
    }

    //Se utiliza ahora
    public void removeMensaje(Mensaje men) {
        mensajeDAO.removeDestinatario(men);
    }

}
