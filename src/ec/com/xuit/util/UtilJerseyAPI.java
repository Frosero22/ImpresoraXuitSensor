/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.util;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

/**
 *
 * @author user
 */
public class UtilJerseyAPI {
      // Loggers
    private static final Logger logger = Logger.getLogger(UtilJerseyAPI.class.getName());
    
    // Integers
    private static final Integer READ_TIME_OUT = 30000; // 30 segundos
    private static final Integer CONNECT_TIME_OUT = 5000; // 5 Segundos
    
    // Ints
    public final int STATUS_OK = 200;
    
    public Client createClient() {
        Client client = null;
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getClasses().add(JacksonJaxbJsonProvider.class);
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            client = Client.create(clientConfig);
            // Es el tiempo de espera cuando tiene una conexión, está bloqueado read() y desea obtener una excepción si la lectura se bloquea 
            // por más de timeout.
            client.setReadTimeout(READ_TIME_OUT);
            // Es el tiempo de espera para crear una conexión. 
            // Supongamos que tiene un servidor poco confiable y desea esperar solo 15 segundos antes de decirle al usuario que "algo está mal"
            client.setConnectTimeout(CONNECT_TIME_OUT);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
        return client;
    }
    
    public boolean JsonIsNull(JsonObject gsonObject, String key) {
        try {
            if (gsonObject.has(key) && !gsonObject.get(key).isJsonNull() && gsonObject.get(key).isJsonPrimitive()) {
                return false;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
        return true;
    }
    
    public boolean JsonArrayIsNull(JsonObject gsonObject, String key) {
        try {
            if (gsonObject.has(key) && !gsonObject.get(key).isJsonNull() && gsonObject.get(key).isJsonArray()) {
                return false;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
        return true;
    }
    
    public boolean JsonObjectIsNull(JsonObject gsonObject, String key) {
        try {
            if (gsonObject.has(key) && !gsonObject.get(key).isJsonNull() && gsonObject.get(key).isJsonObject()) {
                return false;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
        return true;
    }
}
