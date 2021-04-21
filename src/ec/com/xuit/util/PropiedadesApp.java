
package ec.com.xuit.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropiedadesApp {
    
    public final static String WS_PRINCIPAL;
    public final static String METODO_0;
    public final static String METODO_1;
    public final static String METODO_2;
    public final static String METODO_3;
    public final static String METODO_4;
    public final static String NOMBRE_IMPRESORA_MATRICIAL_TO_TICKET;
    static {
        Properties objProperties = new Properties();
        
        String strMetodo1 = null;
        String strMetodo2 = null;
        String strMetodo0= null;
        String strMetodo4 = null;
        String strWsPrincipal = null;
        String strMetodo3 = null;
        String strNombreImpresora= null;
        try {
            // objProperties.load(PropiedadesApp.class.getResourceAsStream("/configuracion.properties"));
            try (InputStream objInpStr = new FileInputStream(System.getProperty("user.dir") + "/configuracion.properties")) {
                objProperties.load(objInpStr);
                objInpStr.close();
            } catch (FileNotFoundException e) {
                throw new Exception(e.getMessage());
            }
            
            // Carga Datos!
            strMetodo0                       = objProperties.getProperty("METODO_0");
            strMetodo1                       = objProperties.getProperty("METODO_1");
            strMetodo2                       = objProperties.getProperty("METODO_2");
            strWsPrincipal                   = objProperties.getProperty("WS_PRINCIPAL");
            strMetodo3                       = objProperties.getProperty("METODO_3");
            strMetodo4                       = objProperties.getProperty("METODO_4");
            strNombreImpresora               = objProperties.getProperty("NOMBRE_IMPRESORA_MATRICIAL_TO_TICKET");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            WS_PRINCIPAL = strWsPrincipal;
            METODO_0 = strMetodo0;
            METODO_1 = strMetodo1;
            METODO_2 = strMetodo2;
            METODO_3 = strMetodo3;
            METODO_4 = strMetodo4;
            NOMBRE_IMPRESORA_MATRICIAL_TO_TICKET = strNombreImpresora;
         }   
    }    
    
    private PropiedadesApp() { }
}
