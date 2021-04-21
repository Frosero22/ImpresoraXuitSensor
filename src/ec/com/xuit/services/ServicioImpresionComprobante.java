/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import ec.com.xuit.entitys.services.ComprobantesResponse;
import ec.com.xuit.entitys.services.DatosImpresionTirillaResponse;
import ec.com.xuit.entitys.services.ReImpresionResponse;
import ec.com.xuit.session.SessionApp;
import ec.com.xuit.util.PropiedadesApp;
import ec.com.xuit.util.UtilJerseyAPI;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author user
 */
public class ServicioImpresionComprobante {
  
String jwt ="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ4Q29tbWVyY2UiLCJpYXQiOjE1OTUxOTEzODEsInN1YiI6Im4zVTMkNiQwWC1DMG0zUmMzIiwiaXNzIjoiTkVVIiwiZXhwIjoxNTk1Mjc3NzgxfQ.y6KTmjtIXwuBw-YpCO2zTe2gJ9hFuxzHDbqsC8-kvTE";

public Map<String, Object> obtenerDatosTirilla(Integer intCodigoEmpresa,
                                               BigDecimal bdSecuenciaComprobante) {

        Map<String, Object> mapRespuesta = new HashMap<>();
        DatosImpresionTirillaResponse objDatosImpresionTirillaResponse = null;
        try {
            MultivaluedMapImpl param = new MultivaluedMapImpl();
            param.add("argCodigoEmpresa", intCodigoEmpresa);
            param.add("argSecuenciaComprobante", bdSecuenciaComprobante );

            UtilJerseyAPI utilJerseyAPI = new UtilJerseyAPI();
            Client client = utilJerseyAPI.createClient();

            WebResource webResourceGet = client.resource(PropiedadesApp.WS_PRINCIPAL+PropiedadesApp.METODO_2).queryParams(param);
            ClientResponse clienteResponse = webResourceGet.header(HttpHeaders.AUTHORIZATION, SessionApp.getAuthorization()).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            String strResponseEntity = clienteResponse.getEntity(String.class);

            System.out.println(strResponseEntity);

            if (clienteResponse.getStatus() == utilJerseyAPI.STATUS_OK) {
                Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                objDatosImpresionTirillaResponse = gson.fromJson(strResponseEntity, DatosImpresionTirillaResponse.class);
                mapRespuesta.put("lsDatosTirilla", objDatosImpresionTirillaResponse.getLsDatosTirilla());
                mapRespuesta.put("lsFacPagos", objDatosImpresionTirillaResponse.getLsFacPagos());
            } else {
                System.err.println("no devuelve data");
                mapRespuesta.put("error", "NO DEVUELVE DATA");
            }
        } catch (Exception ex) {
            mapRespuesta.put("error", ex.getMessage());
            ex.printStackTrace();
        }

        return mapRespuesta;
    }



public Map<String, Object> obtenerTirillasPendientes(Integer intCodigoEmpresa,
                                                     String  strUsuario) {

        Map<String, Object> mapRespuesta = new HashMap<>();
        ComprobantesResponse objComprobantesResponse = null;
        try {
            MultivaluedMapImpl param = new MultivaluedMapImpl();
            param.add("argCodigoEmpresa", intCodigoEmpresa);
            param.add("argUsuario", strUsuario );

            UtilJerseyAPI utilJerseyAPI = new UtilJerseyAPI();
            Client client = utilJerseyAPI.createClient();

            WebResource webResourceGet = client.resource(PropiedadesApp.WS_PRINCIPAL+PropiedadesApp.METODO_1).queryParams(param);
            ClientResponse clienteResponse = webResourceGet.header(HttpHeaders.AUTHORIZATION, SessionApp.getAuthorization()).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            String strResponseEntity = clienteResponse.getEntity(String.class);

            System.out.println(strResponseEntity);

            if (clienteResponse.getStatus() == utilJerseyAPI.STATUS_OK) {
                 Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                 objComprobantesResponse = gson.fromJson(strResponseEntity, ComprobantesResponse.class);
                 mapRespuesta.put("lista", objComprobantesResponse.getLsComprobantesPendientes());
                 System.err.println("Devuelve data");
            } else {
                System.err.println("no devuelve data");
                mapRespuesta.put("error", "NO DEVUELVE DATA");
            }
        } catch (Exception ex) {
            mapRespuesta.put("error", ex.getMessage());
            ex.printStackTrace();
        }

        return mapRespuesta;
    }
   

public Map<String, Object> actualizarEstadoImpresionNTirilla(Integer intCodigoEmpresa,
                                                            String  strUsuario,
                                                            BigDecimal bdSecuenciaComprobante) {

        Map<String, Object> mapRespuesta = new HashMap<>();
        ComprobantesResponse objComprobantesResponse = null;
        try {
            MultivaluedMapImpl param = new MultivaluedMapImpl();
            param.add("argCodigoEmpresa", intCodigoEmpresa);
            param.add("argUsuario", strUsuario );
            param.add("argSecuenciaComprobante", bdSecuenciaComprobante );

            UtilJerseyAPI utilJerseyAPI = new UtilJerseyAPI();
            Client client = utilJerseyAPI.createClient();

            WebResource webResourceGet = client.resource(PropiedadesApp.WS_PRINCIPAL+PropiedadesApp.METODO_3).queryParams(param);
            ClientResponse clienteResponse = webResourceGet.header(HttpHeaders.AUTHORIZATION, SessionApp.getAuthorization()).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
            String strResponseEntity = clienteResponse.getEntity(String.class);

            System.out.println(strResponseEntity);

            if (clienteResponse.getStatus() == utilJerseyAPI.STATUS_OK) {
                 Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                 objComprobantesResponse = gson.fromJson(strResponseEntity, ComprobantesResponse.class);
                 mapRespuesta.put("error", null);
            } else {
                mapRespuesta.put("error", "NO DEVUELVE DATA");
            }
        } catch (Exception ex) {
            mapRespuesta.put("error", ex.getMessage());
            ex.printStackTrace();
        }

        return mapRespuesta;
    }
   

public Map<String, Object> obtenerReImpresionFactura(String  strNumeroEstablecimiento,
                                                     BigDecimal  bdPuntoEmisionSRI,
                                                     BigDecimal  bdSecuencial) {

        Map<String, Object> mapRespuesta = new HashMap<>();
        ComprobantesResponse objComprobantesResponse = null;
        try {
            MultivaluedMapImpl param = new MultivaluedMapImpl();
            param.add("argNumeroEstablecimiento", strNumeroEstablecimiento);
            param.add("argPuntoEmision", bdPuntoEmisionSRI );
            param.add("argSecuenciaSri", bdSecuencial );

            UtilJerseyAPI utilJerseyAPI = new UtilJerseyAPI();
            Client client = utilJerseyAPI.createClient();

            WebResource webResourceGet = client.resource(PropiedadesApp.WS_PRINCIPAL+PropiedadesApp.METODO_4).queryParams(param);
            ClientResponse clienteResponse = webResourceGet.header(HttpHeaders.AUTHORIZATION, SessionApp.getAuthorization()).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            String strResponseEntity = clienteResponse.getEntity(String.class);

           // System.out.println(strResponseEntity);

            if (clienteResponse.getStatus() == utilJerseyAPI.STATUS_OK) {
                 Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                 ReImpresionResponse objReImpresionResponse = gson.fromJson(strResponseEntity, ReImpresionResponse.class);
                 if(objReImpresionResponse!=null){
                     mapRespuesta.put("codigoEmpresa", objReImpresionResponse.getCodigoEmpresa());
                     mapRespuesta.put("secuenciaComprobante", objReImpresionResponse.getSecuenciaComprobante());
                 }
            } else {
                mapRespuesta.put("error", "NO DEVUELVE DATA");
            }
        } catch (Exception ex) {
            mapRespuesta.put("error", ex.getMessage());
            ex.printStackTrace();
        }

        return mapRespuesta;
    }
   
public static void main(String[] args) {
        ServicioImpresionComprobante obj= new ServicioImpresionComprobante();
        obj.obtenerReImpresionFactura("001", new BigDecimal(105), new BigDecimal(659));
    }
}
