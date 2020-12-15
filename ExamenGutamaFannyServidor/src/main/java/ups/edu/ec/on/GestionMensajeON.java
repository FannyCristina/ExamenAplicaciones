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
public class GestionMensajeON implements GestionMensajeRemoto{

   @Inject
   private DestinatarioDAO destinatarioDAO;
    @Inject
   private MensajeDAO mensajeDAO;
    
    
    public void guardarMensaje(Mensaje msj){
        
       try {
           mensajeDAO.insert(msj);
       } catch (Exception ex) {
           Logger.getLogger(GestionMensajeON.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    } 
   
   
   public void agregarDestintario(Destinatario destinatario){
       try {
           destinatarioDAO.insert(destinatario);
           
       } catch (Exception ex) {
           Logger.getLogger(GestionMensajeON.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public List<Destinatario> listar(){
       
       List<Destinatario> lsita = null;
       try {
           lsita = destinatarioDAO.findAll();
       } catch (Exception ex) {
           Logger.getLogger(GestionMensajeON.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(!lsita.isEmpty()){
           return lsita;
       }else{
          return null;  
       }
   }
   
    public List<Mensaje> lista(int id){
        
       List<Mensaje> lista = null;
       try {
           lista = mensajeDAO.listaMensajes(id);
       } catch (Exception ex) {
           Logger.getLogger(GestionMensajeON.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(!lista.isEmpty()){
           return lista;
       }else{
          return null;  
       }
   }
   
 
   
 
}
