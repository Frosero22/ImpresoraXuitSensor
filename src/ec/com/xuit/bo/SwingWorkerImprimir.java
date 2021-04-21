
package ec.com.xuit.bo;

import ec.com.xuit.session.SessionApp;
import java.util.Map;
import javax.swing.SwingWorker;

public class SwingWorkerImprimir {
    
    private String strUsuario;
    private Integer intCodigoEmpresa;
    Map<String, Object> map= null;
    public SwingWorkerImprimir(String strUsuario, Integer intCodigoEmpresa) {
        this.strUsuario = strUsuario;
        this.intCodigoEmpresa = intCodigoEmpresa;
    }
    

    public void imprimir() {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                boolean ejecutarHilo=true;
                while(ejecutarHilo&&SessionApp.isEstaImprimiendo()){
                   String respuesta =  new ImpresionComprobantesBO().imprimirComprobante(intCodigoEmpresa, strUsuario);
                }
                
                return null;
            }
        };
        worker.execute();
    }

}
