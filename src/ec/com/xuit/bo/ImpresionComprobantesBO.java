
package ec.com.xuit.bo;

import ec.com.xuit.dto.Comprobantes;
import ec.com.xuit.dto.DatosImpresionTirillaFactura;
import ec.com.xuit.dto.FacPagos;
import ec.com.xuit.services.ServicioImpresionComprobante;
import ec.com.xuit.util.GeneraImpresion;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ImpresionComprobantesBO {
    
    
    
    public String imprimirComprobante(Integer intCodigoEmpresa, String strUsuario){
        Map<String, Object> mapComprobantes  = null;
        Map<String, Object> mapDataImpresion = null;
        List<Comprobantes> lsComprobantesPendientes = null;
        List<DatosImpresionTirillaFactura> lsDatosTirilla= null;
        List<FacPagos> lsFacPagos = null;
        String mensaje = null;
        try{
            mapComprobantes= new ServicioImpresionComprobante().obtenerTirillasPendientes(intCodigoEmpresa, strUsuario);
            if(mapComprobantes != null){
                lsComprobantesPendientes = (List<Comprobantes>) mapComprobantes.get("lista");
                
                if(lsComprobantesPendientes!=null && lsComprobantesPendientes.size()>0){
                    
                    for (Comprobantes itemComprobantesPendiente : lsComprobantesPendientes) {
                        mapDataImpresion = new ServicioImpresionComprobante().obtenerDatosTirilla(intCodigoEmpresa, 
                                                                                                  itemComprobantesPendiente.getSecuenciaComprobante());
                        
                        if(mapDataImpresion != null){
                            System.out.println(itemComprobantesPendiente.getSecuenciaComprobante());
                            lsDatosTirilla= (List<DatosImpresionTirillaFactura>) mapDataImpresion.get("lsDatosTirilla");
                            lsFacPagos= (List<FacPagos>) mapDataImpresion.get("lsFacPagos");
                            
                            
                            Map<String, Object> mapResult = new GeneraImpresion().imprimirFactura("ComprobantesXUIT", 
                                                                                                  lsDatosTirilla, 
                                                                                                  lsFacPagos, 
                                                                                                  "N");
                            
                            if(mapResult != null ){
                                boolean estaImpreso = (boolean) mapResult.get("booImpresionExitosa");
                                
                                if(estaImpreso){
                                   Map<String,Object> mapActualiza= new ServicioImpresionComprobante().actualizarEstadoImpresionNTirilla(intCodigoEmpresa,
                                                                                                         strUsuario, 
                                                                                                         itemComprobantesPendiente.getSecuenciaComprobante());
                                
                                   if(mapActualiza!= null && mapActualiza.get("error")== null){
                                       mensaje = "documento impreso";
                                   }else{
                                       mensaje=" documento no impreso";
                                   }
                                }
                            }
                        }else{
                            mensaje = "No existe comprobante pendiente a imprimir";
                        }
                        
                        //break;
                    }
                    
                }else{
                    mensaje = "No existe comprobante pendiente a imprimir";
                }
            }else{
                mensaje = "No existe comprobante pendiente a imprimir";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return mensaje;
    }
    
    
      public String reImprimirComprobante(String strUsuario,
                                          String strNumeroEstablecimiento, 
                                          String strPuntoEmision, 
                                          String strSecuencialSRI){
          
        Map<String, Object> mapDataImpresion = null;
        Map<String, Object> mapReImprimir = null;
        List<DatosImpresionTirillaFactura> lsDatosTirilla= null;
        List<FacPagos> lsFacPagos = null;
        String mensaje = null;
        String strCodigoEmpresa= null, strSecuenciaComprobante = null;
        Integer intCodigoEmpresa= 1;
        BigDecimal bdSecuenciaComprobante = null;
        
        try{
            
            //obtengo datos de reimpresion de acuerdo a valores de entrada
               mapReImprimir= new ServicioImpresionComprobante().obtenerReImpresionFactura(strNumeroEstablecimiento, new BigDecimal(strPuntoEmision), new BigDecimal(strSecuencialSRI));
               
               if(mapReImprimir == null){
                   mensaje = "Servicio no disponible por el momento.";
                   return mensaje;
               }
               strCodigoEmpresa= (String) mapReImprimir.get("codigoEmpresa");
               strSecuenciaComprobante = (String) mapReImprimir.get("secuenciaComprobante");
               
               if(strCodigoEmpresa == null || strCodigoEmpresa.length()<=0){
                   mensaje = "El servicio no pudo obtener el codigo de empresa con los datos ingresados.";
                   return mensaje;
               }
               
               if(strSecuenciaComprobante == null || strSecuenciaComprobante.length()<=0){
                   mensaje = "El servicio no pudo obtener la secuencia comprobante con los datos ingresados.";
                   return mensaje;
               }
               
                intCodigoEmpresa = Integer.valueOf(strCodigoEmpresa);
                bdSecuenciaComprobante= new BigDecimal(strSecuenciaComprobante);
                
                        mapDataImpresion = new ServicioImpresionComprobante().obtenerDatosTirilla(intCodigoEmpresa, 
                                                                                                  bdSecuenciaComprobante);
                        
                        if(mapDataImpresion != null){
                            lsDatosTirilla= (List<DatosImpresionTirillaFactura>) mapDataImpresion.get("lsDatosTirilla");
                            lsFacPagos= (List<FacPagos>) mapDataImpresion.get("lsFacPagos");
                            
                            
                            Map<String, Object> mapResult = new GeneraImpresion().imprimirFactura("ComprobantesXUIT", 
                                                                                                  lsDatosTirilla, 
                                                                                                  lsFacPagos, 
                                                                                                  "N");
                            
                            if(mapResult != null ){
                                boolean estaImpreso = (boolean) mapResult.get("booImpresionExitosa");
                                
                                if(estaImpreso){
                                   Map<String,Object> mapActualiza= new ServicioImpresionComprobante().actualizarEstadoImpresionNTirilla(intCodigoEmpresa,
                                                                                                                                         strUsuario, 
                                                                                                                                         bdSecuenciaComprobante);
                                
                                   if(mapActualiza!= null && mapActualiza.get("error")== null){
                                       mensaje = "documento impreso";
                                   }else{
                                       mensaje=" documento no impreso";
                                   }
                                }
                            }
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return mensaje;
    }
}
