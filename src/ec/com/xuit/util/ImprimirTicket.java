/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.util;

import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.filechooser.FileSystemView;


public class ImprimirTicket
{
	static String NOMBRE_CARPETA_COMPROBANTES;
    static ArrayList<String> CabezaLineas = new ArrayList<String>();
    static ArrayList<String> SubCabezaLineas = new ArrayList<String>();
    static ArrayList<String> LineasPie = new ArrayList<String>();
    
    /**
     * Representa al comando cortar (combinacion de ESC i)
     */
    static char espacioBlanco = ' ';
    static byte[] CORTAR = {27, 105};
    static byte[] BOLD = {27, 52};
    static byte[] FINBOLD = {27, 53};
    static byte[] ESC_CUT_PAPER = {0x1B, 'r', 0};

    /**
     * Agrega el Nombre de la carpeta con la cual se deben crear los comprobantes en caso no se imprima.
     * @param strNombreCarpeta 
     */
    public static void AddNombreCarpetaComprobantes(String strNombreCarpeta) {
        NOMBRE_CARPETA_COMPROBANTES = strNombreCarpeta;
    }
    
    /**
     * Permite añadir valores a la Cabecera que se presentara en el Ticket
     *
     * @param line
     */
    public static void AddCabecera(String line) {
        CabezaLineas.add(line);
    }

    /**
     * Permite añadir valores a la SubCabecera que se presentara en el Ticket
     *
     * @param line
     */
    public static void AddSubCabecera(String line) {
        SubCabezaLineas.add(line);
    }

    /**
     * Permite añadir valores al Final para que se presenten en el Ticket
     *
     * @param line
     */
    public static void AddPieLinea(String line) {
        LineasPie.add(line);
    }

    public static String agregarBlanco(String string) {
        int largo = 7;
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = ceros + string;
            return retorno;
        } else {
            return string;
        }
    }

    public static String agregarBlancoValCierre(String string) {
        int largo = 8;
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = ceros + string;
            return retorno;
        } else {
            return string;
        }
    }

    public static String agregarBlancoddescrip(String string) {
        int largo = 16;
        int numeroval = 0;
        String dividido = "";
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = string + ceros;
            return retorno;
        } else {
            if (cantidad != 0) {
                numeroval = string.length() + cantidad;
                dividido = string.substring(0, numeroval);
                return dividido;
            }
            return string;
        }
    }
    
    public static String agregarBlancoddescripCierre(String string) {
        int largo = 24;
        int numeroval = 0;
        String dividido = "";
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = string + ceros;
            return retorno;
        } else {
            if (cantidad != 0) {
                numeroval = string.length() + cantidad;
                dividido = string.substring(0, numeroval);
                return dividido;
            }
            return string;
        }
    }
    
    public static String agregarBlancoddescrippie(String string) {
        int largo = 18;
        int numeroval = 0;
        String dividido = "";
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = string + ceros;
            return retorno;
        } else {
            if (cantidad != 0) {
                numeroval = string.length() + cantidad;
                dividido = string.substring(0, numeroval);
                return dividido;
            }
            return string;
        }
    }
    
    public static String agregarBlanco_Split(String stringactual, String validar) {
        int espaciousado = stringactual.length();
        int numeroval = 0;
        int largo = 40 - espaciousado;
        String dividido = "";
        int numero = 0;
        String ceros = "";

        int cantidad = largo - validar.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = validar + ceros;
            return retorno;
        } else {
            numero = validar.length();
        }
        numeroval = validar.length() + cantidad;
        dividido = validar.substring(0, numeroval);
        return dividido;
    }
    
    public static String agregarBlanco_cantidad(String stringactual) {
        int largo = 3;
        String ceros = "";

        int cantidad = largo - stringactual.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = stringactual + ceros;
            return retorno;
        } else {
            return stringactual;
        }

    }

    public static String agregarBlanco_Split_pie(String stringactual, String validar) {
        String Descripcion = "";
        Descripcion = agregarBlancoddescrippie(stringactual) + espacioBlanco;
        int espaciousado = Descripcion.length();
        int numeroval = 0;
        int largo = 40 - espaciousado;
        String dividido = "";
        int numero = 0;
        String ceros = "";

        int cantidad = largo - validar.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = validar + ceros;
            String cuenta = Descripcion + retorno;
            return cuenta;
        } else {
            numero = validar.length();
        }
        numeroval = validar.length() + cantidad;
        dividido = validar.substring(0, numeroval);
        String cuenta = Descripcion + dividido;
        return cuenta;

    }

    public static String agregarBlanco_fac_digital(String stringactual) {
        String Descripcion = "";
        String cuenta = "";
        Descripcion = stringactual;
        int espaciousado = Descripcion.length();
        int numeroval = 0;
        int largo = 40 - espaciousado;
        String dividido = "";
        int numero = 0;
        String ceros = "";

        if (largo >= 1) {
            for (int i = 0; i < largo; i++) {
                ceros += espacioBlanco;
            }
            String retorno = stringactual + ceros;
            cuenta = retorno;
            return cuenta;
        } else if (largo != 0) {
            numeroval = 40 + largo;
            dividido = stringactual.substring(0, numeroval);
            cuenta = Descripcion + dividido;
        }
        return cuenta;

    }
    
    public static String formatear(String strCadenaToEvaluar) {
        String strCaracteresEspeciales = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ"; // Cadena de caracteres original a sustituir.
        String strCaracteresNormales = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC"; // 
        String strRespuesta = "";
        if (strCadenaToEvaluar != null) {
            strRespuesta = strCadenaToEvaluar;
            for (int i = 0; i < strCaracteresEspeciales.length(); i++) {
                // Reemplazamos los caracteres especiales.
                strRespuesta = strRespuesta.replace(strCaracteresEspeciales.charAt(i), strCaracteresNormales.charAt(i));
            }
        }
        return strRespuesta;
    }
    
    public static String CabeceraDetalle() {
        String strCadenaDetalle = "" + agregarBlancoddescrip("Descripcion") + "Cant " + " P. Unit." + espacioBlanco + " Valor " + espacioBlanco + espacioBlanco;
        return strCadenaDetalle;
    }

    public static String piefactura(String Descripcion, String dato) {
        String detallemod = agregarBlanco_Split_pie(Descripcion + espacioBlanco, dato);
        String detalle = "" + Descripcion + "" + detallemod;
        return detalle;
    }

    public static String Cabecera(String Descripcion, String dato) {
        String detallemod = agregarBlanco_Split(Descripcion + espacioBlanco, dato + espacioBlanco);

        String detalle = "" + Descripcion + "" + detallemod;
        if (detalle.length() == 39) {
            detalle = detalle + espacioBlanco;
        }
        return detalle;
    }

    public static String Detalle(String descripcion, String cantidad, String punit, String ptotal) {
        String detallemod = agregarBlancoddescrip(descripcion);
        String cantidadmod = agregarBlanco_cantidad(cantidad);
        String punitmod = agregarBlanco(punit);
        String ptotalmod = agregarBlanco(ptotal);

        String detalle = "" + detallemod + espacioBlanco + espacioBlanco + "" + cantidadmod + espacioBlanco + "$" + punitmod + espacioBlanco + "$" + ptotalmod + espacioBlanco;
        return detalle;
    }
    
    public static String DetalleCompleto(String descripcion, String cantidad, String punit, String ptotal) {
        String detallemod = descripcion!=null ? generaDescripcionFormatCompleto(descripcion) : agregarBlancoddescrip("");
        String cantidadmod = agregarBlanco_cantidad(cantidad);
        String punitmod = agregarBlanco(punit);
        String ptotalmod = agregarBlanco(ptotal);
        
        String detalle = "" + detallemod + espacioBlanco + espacioBlanco + "" + cantidadmod + espacioBlanco + "$" + punitmod + espacioBlanco + "$" + ptotalmod + espacioBlanco;
        return detalle;
    }
    
    public static String generaDescripcionFormatCompleto(String strDescripcion) {
        String strValorToRetornar = null;
        try {
            int intMaxLengthDescripcion = 16; // La cantidad maxima de caracteres que soporta la DESCRIPCION
            int intMaxLengthPapel       = 40; // La cantidad maxima de caracteres que soporta el ANCHO DEL PAPEL

            List<String> lsCadenaDescripcion = new ArrayList<String>(); // Almacena una cadena de caracteres depurada con el maximo del ANCHO DEL PAPEL
            String srtCadenaAux = null;  // Cadena auxiliar donde se depura la cadena recibia para realizar calculos.

            // Recorre los caracteres de la cadena enviada y almacena la informacion
            for (int c=0; c<strDescripcion.length(); c++) {
                if (srtCadenaAux==null) {
                    srtCadenaAux = String.valueOf(strDescripcion.charAt(c));
                } else {
                    srtCadenaAux = srtCadenaAux + String.valueOf(strDescripcion.charAt(c));
                }
                String strDescipcionTmp = strDescripcion.substring(c+1, strDescripcion.length());
                // SI TIENE 40 CARACTERES Y EXISTEN MAS CARACTERES POR DEPURAR.
                if (srtCadenaAux.length()==intMaxLengthPapel && strDescipcionTmp.length()>0) {
                    lsCadenaDescripcion.add(srtCadenaAux);
                    srtCadenaAux = null;
                // SI TIENE MENOS DE 40 CARACTERES Y NO EXISTEN MAS CARACTERES POR DEPURAR.
                } else if (srtCadenaAux.length()<=intMaxLengthPapel && strDescipcionTmp.length()<=0) { 
                    lsCadenaDescripcion.add(srtCadenaAux);
                    srtCadenaAux = null;
                }
            }
            
            int intContadorValor = 1;
            for (String strValor : lsCadenaDescripcion) {
                boolean booAgregoSaltoLinea = false;
                String strValorNew = strValor.length()<intMaxLengthDescripcion ? ImprimirTicket.agregarBlancoddescrip(strValor) : strValor;
                if (strValorToRetornar==null) {
                    if (strValorNew.length()==intMaxLengthDescripcion) {
                        strValorToRetornar = strValorNew;
                    } else {
                        strValorToRetornar = strValorNew + "\n";
                        booAgregoSaltoLinea = true;
                    }
                } else {
                    if (strValorNew.length()==intMaxLengthDescripcion) {
                        strValorToRetornar = strValorToRetornar + strValorNew;
                    } else {
                        strValorToRetornar = strValorToRetornar + (strValorNew + "\n");
                        booAgregoSaltoLinea = true;
                    }
                }
                if (intContadorValor==lsCadenaDescripcion.size() && booAgregoSaltoLinea) {
                    strValorToRetornar = strValorToRetornar + ImprimirTicket.agregarBlancoddescrip("");
                }
                intContadorValor++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strValorToRetornar;
    }

    public static String detallecierrecaja(String descripcion, String cantidad, String punit, String ptotal) {
        String detallemod = agregarBlancoddescripCierre(descripcion);
        String punitmod = agregarBlancoValCierre(punit);
        String ptotalmod = agregarBlancoValCierre(ptotal);
        String cantidadmod = agregarBlanco_cantidad(cantidad);
        String detalle = "" + detallemod + "" + espacioBlanco + " " + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + "$" + ptotalmod;
        return detalle;
    }

    public static String servicios(String descripcion, String cantidad, String punit, String ptotal) {
        String detallemod = agregarBlancoddescrip(descripcion);
        String punitmod = agregarBlanco(punit);
        String ptotalmod = agregarBlanco(ptotal);
        String cantidadmod = agregarBlanco_cantidad(cantidad);
        String detalle = "" + detallemod + espacioBlanco + "" + cantidadmod + espacioBlanco + " " + punit + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + " " + ptotalmod + espacioBlanco;
        return detalle;
    }

    public static String Subtotal(String descripcion, String cantidad, String alineacion) {
        String detalle = "";
        if (alineacion.toUpperCase().equals("C")) {
            String detallemod = agregarBlancoddescrip(descripcion);
            String cantidadmod = agregarBlanco(cantidad);
            String preciomod = agregarBlanco(" ");
            detalle = "" + detallemod + espacioBlanco + espacioBlanco + "$" + cantidadmod + espacioBlanco + espacioBlanco + espacioBlanco + " " + preciomod + agregarBlanco_cantidad(" ");
        }
        if (alineacion.toUpperCase().equals("D")) {
            String detallemod = agregarBlancoddescrip(descripcion);
            String cantidadmod = agregarBlanco(" ");
            String preciomod = agregarBlanco(cantidad);
            detalle = "" + detallemod + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + espacioBlanco + cantidadmod + espacioBlanco + espacioBlanco + "$" + preciomod;
        }
        return detalle;
    }

    public static String totales(String descripcion, String cantidad) {

        String detallemod = agregarBlancoddescrip(descripcion);
        String cantidadmod = agregarBlanco(" ");
        String preciomod = agregarBlanco(cantidad);

        String detalle = "" + detallemod + espacioBlanco + espacioBlanco + " " + cantidadmod + agregarBlanco_cantidad(" ") + espacioBlanco + espacioBlanco + espacioBlanco + "$" + preciomod;

        return detalle;
    }

    public static String Pagos(String descripcion, String cantidad) {
        String detallemod = agregarBlancoddescrip(descripcion);
        String cantidadmod = agregarBlanco(" ");
        String preciomod = agregarBlanco(cantidad);

        String detalle = "" + detallemod + espacioBlanco + espacioBlanco + " " + cantidadmod + espacioBlanco + espacioBlanco + "$" + preciomod;

        return detalle;
    }

    /**
     * Dibuja el caracter que separa la Cabecera de la SubCabecera y de la parte
     * Final del Ticket
     *
     * @param valor
     * @return
     */
    public static String DibujarLinea(int valor) {
        String raya = "";
        for (int x = 0; x < valor; x++) {
            raya += "-";
        }
        return raya;
    }

    public static String DibujarLineaater(int valor) {
        String raya = "";
        for (int x = 0; x < valor; x++) {
            raya += "*";
        }
        return raya;
    }

    /**
     * Para dar un salto de Linea
     *
     * @return
     */
    public static String DarEspacio() {
        return "\n";
    }

    /**
     * Permite alinear al centro el texto que se envia, deacuerdo al tamaño de
     * caracteres que permite la impresora (40 caracteres)
     *
     * @param str
     * @param width
     * @param padWithChar
     * @return
     */
    public static String alineacion(String str, final int width, char padWithChar) {
        // Trim the leading and trailing whitespace ...
        str = str != null ? str.trim() : "";

        int addChars = width - str.length();
        if (addChars < 0) {
            // truncate
            return str.subSequence(0, width).toString();
        }
        // Write the content ...
        int prependNumber = addChars / 2;
        int appendNumber = prependNumber;
        if ((prependNumber + appendNumber) != addChars) {
            ++prependNumber;
        }

        final StringBuilder sb = new StringBuilder();

        // Prepend the pad character(s) ...
        while (prependNumber > 0) {
            sb.append(padWithChar);
            --prependNumber;
        }

        // Add the actual content
        sb.append(str);

        // Append the pad character(s) ...
        while (appendNumber > 0) {
            sb.append(padWithChar);
            --appendNumber;
        }

        return sb.toString();
    }

    /**
     * Realiza la impression del Documento, recorriendo las lineas de la
     * Cabecera, SubCabecera y al final del Ticket
     */
    public static boolean ImprimirDocumento()
    throws Exception {
        boolean booImpresionExitosa = false;
        try {
            //Inicializa variables 
            String strCadenaCabecera = "";
            String strCadenaDetalle = "";
            String strCadenaPie = "";

            //Lee Cabecera Pagina
            for (int intCabecera = 0; intCabecera < CabezaLineas.size(); intCabecera++) {
                strCadenaCabecera += CabezaLineas.get(intCabecera);
            }

            //Lee Detalle Pagina
            for (int intDetalle = 0; intDetalle < SubCabezaLineas.size(); intDetalle++) {
                strCadenaDetalle += SubCabezaLineas.get(intDetalle);
            }

            //Lee Pie Pagina
            for (int intPie = 0; intPie < LineasPie.size(); intPie++) {
                strCadenaPie += LineasPie.get(intPie);
            }

            //Arma el tipo de Datos que se va a recibir en el doc a imprimir
            DocFlavor docFlavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

            //Obtiene el servicio activo de la impresora
            PrintService printService = null;
            PrintService[] arrPrintService = PrinterJob.lookupPrintServices();
            for (int index = 0; printService == null && index < arrPrintService.length; index++) {
                //String strNamePrintService = "";//xuitPropiedadesApp.NOMBRE_IMPRESORA_MATRICIAL_TO_TICKET;
                String strNamePrintService = PropiedadesApp.NOMBRE_IMPRESORA_MATRICIAL_TO_TICKET;
                if (arrPrintService[index].getName().equalsIgnoreCase(strNamePrintService!=null?strNamePrintService:"Generic / Text Only")) {
                    printService = arrPrintService[index];
                }
            }

            //Permite añadir las especificaciones de lo que se va a imprimir
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

            //Convierte el texto a imprimir en Bytes y lo unifica con la variable cortar
            //que permite la accion de cortar papel a travez de comandos
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            try {
                byteArrayOutputStream.write(strCadenaCabecera.getBytes());
                byteArrayOutputStream.write(FINBOLD);
                byteArrayOutputStream.write(strCadenaDetalle.getBytes());
                byteArrayOutputStream.write(strCadenaPie.getBytes());
                byteArrayOutputStream.write(CORTAR);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            byte bytTicketCortado[] = byteArrayOutputStream.toByteArray();

            //Se arma el archivo con la cadena de bytes armada y el tipo de dato que debe leer
            Doc doc = new SimpleDoc(bytTicketCortado, docFlavor, null);

            //Comprueba que el servicio este activo 
            if (printService != null) {
                DocPrintJob docPrintJob = printService.createPrintJob();
                PrintJobWatcher pjw = new PrintJobWatcher(docPrintJob);
                try {
                    docPrintJob.print(doc, printRequestAttributeSet);
                } catch (Exception e) {
                    throw e;
                }
                pjw.waitForDone();
                booImpresionExitosa = true;
            } else {
                System.err.println("No existen impresoras instaladas.");
                
                List<String> lsCadena = new ArrayList<String>();
                if (CabezaLineas!=null && !CabezaLineas.isEmpty() && CabezaLineas.size()>0)
                    lsCadena.addAll(CabezaLineas);
                if (SubCabezaLineas!=null && !SubCabezaLineas.isEmpty() && SubCabezaLineas.size()>0)
                    lsCadena.addAll(SubCabezaLineas);
                if (LineasPie!=null && !LineasPie.isEmpty() && LineasPie.size()>0)
                    lsCadena.addAll(LineasPie);
                //crearArchivoTxt(lsCadena);
            }

        } catch (Exception e) {
            System.err.println("Error al imprimir documento. \n" + e.getMessage());
            e.printStackTrace();
        } finally {
            //Limpia variables
            CabezaLineas = null;
            SubCabezaLineas = null;
            LineasPie = null;

            //Inicializa variales
            CabezaLineas = new ArrayList<String>();
            SubCabezaLineas = new ArrayList<String>();
            LineasPie = new ArrayList<String>();
            
            //
            NOMBRE_CARPETA_COMPROBANTES = null;
        }
        return booImpresionExitosa;
    }
    
    
    public static List<String> GenerarDocumentoXPantalla()
    throws Exception {
        List<String> lsCadena = new ArrayList<String>();
        try {
            if (CabezaLineas!=null && !CabezaLineas.isEmpty() && CabezaLineas.size()>0)
                lsCadena.addAll(CabezaLineas);
            if (SubCabezaLineas!=null && !SubCabezaLineas.isEmpty() && SubCabezaLineas.size()>0)
                lsCadena.addAll(SubCabezaLineas);
            if (LineasPie!=null && !LineasPie.isEmpty() && LineasPie.size()>0)
                lsCadena.addAll(LineasPie);
            
        } catch (Exception e) {
            System.err.println("Error al procesar documento. \n" + e.getMessage());
        } finally {
            //Limpia variables
            CabezaLineas = null;
            SubCabezaLineas = null;
            LineasPie = null;

            //Inicializa variales
            CabezaLineas = new ArrayList<String>();
            SubCabezaLineas = new ArrayList<String>();
            LineasPie = new ArrayList<String>();
            
            //
            NOMBRE_CARPETA_COMPROBANTES = null;
        }
        return lsCadena;
    }
    
    /**
     * Crea un archivo txt con los comprobantes generados
     * @param lsCadena 
     */
   /* public static void crearArchivoTxt(List<String> lsCadena) {
        FileWriter flwriter = null;
        try {
            if (NOMBRE_CARPETA_COMPROBANTES!=null && NOMBRE_CARPETA_COMPROBANTES.trim().length()>0) {
            	DafUsuariosSistema objDafUsuariosSistema = (DafUsuariosSistema) Executions.getCurrent().getSession().getAttribute("user");
                String strUsuario = objDafUsuariosSistema!=null&&objDafUsuariosSistema.getCodigoUsuario()!=null ? objDafUsuariosSistema.getCodigoUsuario() : "X-USER";
                // Crea archivo 
                // File file = new File(filDirectorioWin.getAbsolutePath() + File.separator + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GeneralBO().getSysdate()) + "-" +strUsuario + ".txt");
                File objFile = new File(NOMBRE_CARPETA_COMPROBANTES + File.separator + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date()) + "-" +strUsuario + ".txt");
                // crea el flujo para escribir en el archivo
                flwriter = new FileWriter(objFile, true);
                // Crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for (String strCadena : lsCadena) {
                    // Escribe los datos en el archivo
                    // bfwriter.write(strCadena + System.getProperty("line.separator"));
                    StringTokenizer strToken = new StringTokenizer(strCadena, "\n"); 
                    while(strToken.hasMoreTokens()){
                        String strTokenTmp = strToken.nextToken();
                        bfwriter.write(strTokenTmp + System.getProperty("line.separator"));
                    }
                }
                // Da espacio para mantener texto separado en caso se mezcle 
                bfwriter.write(System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator")); 
                bfwriter.write(System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator")); 
                // Cierra el buffer intermedio
                bfwriter.close();
                Filedownload.save(objFile, null);
            }
            //System.out.println(System.getProperty("user.home")); //Obtiene Home del Usuario
            //System.out.println(System.getProperty("user.dir").toString()); //Obtiene ruta de ejecucion del Java
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try { // Cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
    
    public static String detallecierrecajaSimple(String descripcion, String cant) {
        String detallemod = descripcionClienteCierre(descripcion); //34
        String cantidadmod = agregarBlanco_cantidad(cant); //3
        String detalle = detallemod + espacioBlanco +  espacioBlanco +  espacioBlanco +  cantidadmod;
        return detalle;
    }
    
    public static String descripcionClienteCierre(String string) {
        int largo = 34;
        int numeroval = 0;
        String dividido = "";
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += espacioBlanco;
            }
            String retorno = string + ceros;
            return retorno;
        } else {
            if (cantidad != 0) {
                numeroval = string.length() + cantidad;
                dividido = string.substring(0, numeroval);
                return dividido;
            }
            return string;
        }
    }
}
