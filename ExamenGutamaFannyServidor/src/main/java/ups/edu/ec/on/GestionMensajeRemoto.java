/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.on;

import java.util.List;
import javax.ejb.Remote;
import ups.edu.ec.modelo.Destinatario;
import ups.edu.ec.modelo.Mensaje;

/**
 *
 * @author Fanny
 */
@Remote
public interface GestionMensajeRemoto {

    public void guardarMensaje(Mensaje msj);

    public void agregarDestintario(Destinatario destinatario);

    public List<Destinatario> listar();

    public List<Mensaje> lista(int id);

}
