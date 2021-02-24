/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ups.edu.ec.on.GestionMensajeON;

/**
 *
 * @author Fanny
 */
public class Princiapl {

    @Inject
    private GestionMensajeON on;

    public void intanciarMemberRegistration() throws Exception {
        try {
            final Hashtable<String, Comparable> jndiProperties
                    = new Hashtable<String, Comparable>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb1");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb1");

            final Context context = new InitialContext(jndiProperties);

            final String lookupName = "ejb:/ExamenGutamaFannyServidor/GestionMensajeON!ups.edu.ec.on.GestionMensajeRemoto";

            //  this.memberRegistration = (MemberRegistrationRemote) context.lookup(lookupName);  
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
