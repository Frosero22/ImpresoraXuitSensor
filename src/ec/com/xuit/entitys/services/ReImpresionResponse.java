/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.entitys.services;

/**
 *
 * @author user
 */
public class ReImpresionResponse {
   private String codigoEmpresa;
   private String success;
   private String secuenciaComprobante;

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSecuenciaComprobante() {
        return secuenciaComprobante;
    }

    public void setSecuenciaComprobante(String secuenciaComprobante) {
        this.secuenciaComprobante = secuenciaComprobante;
    }
   
   
}
