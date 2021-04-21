/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.entitys.services;

import ec.com.xuit.dto.Comprobantes;
import java.util.List;

/**
 *
 * @author user
 */
public class ComprobantesResponse {
    private String success;
    private List<Comprobantes> lsComprobantesPendientes;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Comprobantes> getLsComprobantesPendientes() {
        return lsComprobantesPendientes;
    }

    public void setLsComprobantesPendientes(List<Comprobantes> lsComprobantesPendientes) {
        this.lsComprobantesPendientes = lsComprobantesPendientes;
    }
    
    
    
}
