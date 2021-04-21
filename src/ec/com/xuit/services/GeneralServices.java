/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import ec.com.xuit.session.SessionApp;
import ec.com.xuit.util.PropiedadesApp;
import ec.com.xuit.util.UtilJerseyAPI;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author user
 */
public class GeneralServices {
        // Loggers
    private static final Logger logger = Logger.getLogger(GeneralServices.class.getName());
    
    
    public static Map<String, Object> getLoginWS() {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            UtilJerseyAPI utilJerseyAPI = new UtilJerseyAPI();
            Client client = utilJerseyAPI.createClient();
            client.addFilter(new HTTPBasicAuthFilter("NEU", "1MPR3S10NC0MPR0B@NT3S"));
            
            WebResource webResourceGet = client.resource(PropiedadesApp.WS_PRINCIPAL + PropiedadesApp.METODO_0);
            ClientResponse clienteResponse = webResourceGet.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
            
            String strResponseEntity = clienteResponse.getEntity(String.class);
            if (clienteResponse.getStatus() == utilJerseyAPI.STATUS_OK) {
                // logger.info(strResponseEntity);
                JsonObject gsonObject = new JsonParser().parse(strResponseEntity).getAsJsonObject();
                SessionApp.setTokenType(!utilJerseyAPI.JsonIsNull(gsonObject, "tokenType") ? gsonObject.get("tokenType").getAsString() : null);
                SessionApp.setAccesToken(!utilJerseyAPI.JsonIsNull(gsonObject, "accesToken") ? gsonObject.get("accesToken").getAsString() : null);
                if (SessionApp.getTokenType()!=null && SessionApp.getAccesToken()!=null) {
                    SessionApp.setAuthorization(SessionApp.getTokenType() + " " + SessionApp.getAccesToken());
                    logger.log(Level.WARNING, "Token de Autorizaci\u00f3n: {0}", SessionApp.getAccesToken());
                    mapResult.put("mensaje", "OK");
                    return mapResult;
                } else {
                    mapResult.put("mensaje", "El Servicio Web Phantom Kiosko no retorno Token de Autorización");
                    return mapResult;
                }
            } else {
                logger.warning(strResponseEntity);
            }
        } catch (UniformInterfaceException | ClientHandlerException | JsonSyntaxException e) {
            logger.log(Level.SEVERE, null, e);
            mapResult.put("error", e.getMessage());
        }
        return mapResult;
    }
}
