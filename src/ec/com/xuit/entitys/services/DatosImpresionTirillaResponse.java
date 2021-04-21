
package ec.com.xuit.entitys.services;

import ec.com.xuit.dto.DatosImpresionTirillaFactura;
import ec.com.xuit.dto.FacPagos;
import java.util.List;

public class DatosImpresionTirillaResponse {
    private List<DatosImpresionTirillaFactura> lsDatosTirilla;
    private List<FacPagos> lsFacPagos;
    private String success;

    public List<DatosImpresionTirillaFactura> getLsDatosTirilla() {
        return lsDatosTirilla;
    }

    public void setLsDatosTirilla(List<DatosImpresionTirillaFactura> lsDatosTirilla) {
        this.lsDatosTirilla = lsDatosTirilla;
    }

    public List<FacPagos> getLsFacPagos() {
        return lsFacPagos;
    }

    public void setLsFacPagos(List<FacPagos> lsFacPagos) {
        this.lsFacPagos = lsFacPagos;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
    
    
}
