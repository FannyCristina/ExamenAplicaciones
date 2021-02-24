/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.on;

import java.util.List;
import ups.edu.ec.modelo.Destinatario;
import ups.edu.ec.modelo.Mensaje;

/**
 *
 * @author Fanny
 */
public interface GestionMensajeRemoto {

    public boolean guardadoMensaje(Mensaje mensaje) throws Exception;

    public List<Mensaje> listarMensajes() throws Exception;

    public List<Destinatario> listarDestinatario(int id) throws Exception;

    public void eliminarDestinatario(int p) throws Exception;

}
