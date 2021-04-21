/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresioncomprobantexiut;

import ec.com.xuit.bo.ImpresionComprobantesBO;
import ec.com.xuit.services.GeneralServices;
import ec.com.xuit.services.ServicioImpresionComprobante;
import ec.com.xuit.session.SessionApp;
import ec.com.xuit.util.PropiedadesApp;
import ec.com.xuit.view.frames.PrincipalFrame;
import java.math.BigDecimal;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ImpresionComprobanteXIUT {
    
    public static void main(String[] args) {
        
        Map<String, Object> mapAuth = GeneralServices.getLoginWS();
        
        if (mapAuth.get("error") != null) {
                JOptionPane.showMessageDialog(null, "AQUI SE CAE HP "+mapAuth.get("error").toString());
                return;
            } else if (mapAuth.get("myCustomExceptionWS") != null) {
               JOptionPane.showMessageDialog(null, "Exception");
               return;
            } else if (mapAuth.get("mensaje") == null || !mapAuth.get("mensaje").toString().equals("OK")) {
                if (mapAuth.get("mensaje") == null) {
                    JOptionPane.showMessageDialog(null, "Error al Consumir Servicio Web");
                    return;
                }
                JOptionPane.showMessageDialog(null, mapAuth.get("mensaje").toString());
                return;
            }
        
        
        /*ServicioImpresionComprobante obj= new ServicioImpresionComprobante();
        obj.obtenerReImpresionFactura("001", new BigDecimal(105), new BigDecimal(659));*/
        
        PrincipalFrame principalView = new PrincipalFrame();
        principalView.setLocationRelativeTo(null);
        principalView.setVisible(true);

    }
    
}
