package ec.com.xuit.util;

import ec.com.xuit.dto.DatosImpresionTirillaFactura;
import ec.com.xuit.dto.FacPagos;
import ec.com.xuit.util.ImprimirTicket;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneraImpresion
{
	// Integers Static
	private static final Integer PORCENTAJE_100 = 100;
	private static final Integer DECIMAS_REDONDEO_X_ERROR = 10;

	/**
	 * imprime Facturas orientadas al Paciente
	 * @param strNombreCarpetaCreacionComprobantes
	 * @param lsNumeroTransaccion
	 * @param lsDatosImpresionTirillaFactura
	 * @param lsFacPagos
	 * @param strEsImpresionVisual
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> imprimirFactura(String strNombreCarpetaCreacionComprobantes,
			List<DatosImpresionTirillaFactura> lsDatosImpresionTirillaFactura, 
			List<FacPagos> lsFacPagos, 
			String strEsImpresionVisual) 
			throws Exception {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			boolean booImpresionExitosa = false;
			List<String> lsCadena = new ArrayList<String>();

			if (lsDatosImpresionTirillaFactura==null || lsDatosImpresionTirillaFactura.isEmpty() || lsDatosImpresionTirillaFactura.size()<=0) {
				mapResult.put("error", "No se ha encontrado Factura a imprimir.");
				return mapResult;
			}

			List<DatosImpresionTirillaFactura> lsDatosImpresionTirillaFacturaXNumeroTransaccion = lsDatosImpresionTirillaFactura;

			List<FacPagos> lsFacPagosXNumeroTransaccion = lsFacPagos;

			DatosImpresionTirillaFactura objDatosImpresionTirillaFactura = (DatosImpresionTirillaFactura) lsDatosImpresionTirillaFacturaXNumeroTransaccion.get(0);

			int intWidthMaxPaper = 40;
			char chrEspacioBlanco = ' ';
			Double douPorcentajeIva = objDatosImpresionTirillaFactura.getPorcentajeIva()!=null?(objDatosImpresionTirillaFactura.getPorcentajeIva()*PORCENTAJE_100):0;
			int intNumMaxDecimasRed = objDatosImpresionTirillaFactura.getNumMaxDecimasRedondeo()!=null?objDatosImpresionTirillaFactura.getNumMaxDecimasRedondeo().intValue():6;
			int intNumIdealDecimasRed = objDatosImpresionTirillaFactura.getNumDecimasRedondeo()!=null?objDatosImpresionTirillaFactura.getNumDecimasRedondeo().intValue():2;


			// AGREGA NOMBRE DE LA CARPETA DONDE ALMACENA ARCHIVOS
			ImprimirTicket.AddNombreCarpetaComprobantes(strNombreCarpetaCreacionComprobantes);

			// CABECERA FACTURA
			ImprimirTicket.AddCabecera(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNombreSucursal()), intWidthMaxPaper, chrEspacioBlanco));
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());

			ImprimirTicket.AddCabecera(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getAdicionalCapitalPais()), intWidthMaxPaper, chrEspacioBlanco)); 
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddCabecera(ImprimirTicket.alineacion("RUC: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getRucEmpresa()), intWidthMaxPaper, chrEspacioBlanco)); 
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddCabecera(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getAdicionalFactura()), intWidthMaxPaper, chrEspacioBlanco)); 
			if (objDatosImpresionTirillaFactura.getAdicionalDocumento()!=null && objDatosImpresionTirillaFactura.getAdicionalDocumento().trim().length()>0) {
				ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
				ImprimirTicket.AddCabecera(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getAdicionalDocumento()), intWidthMaxPaper, chrEspacioBlanco));
			}
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());

			// DATOS PACIENTE / COMPROBANTE
			ImprimirTicket.AddCabecera("CLIENTE: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNombreCliente()));
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddCabecera("CEDULA/RUC: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNumeroIdentificacionCliente()));
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddCabecera(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getEtiquetaComprobante()) + ": " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getComprobante()));
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());

			if (objDatosImpresionTirillaFactura.getAutorizacionComprobante()!=null && objDatosImpresionTirillaFactura.getAutorizacionComprobante().trim().length()>0) {
				ImprimirTicket.AddCabecera(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getEtiquetaAutorizacionComprob() + ": "));
				ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
				ImprimirTicket.AddCabecera(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getAutorizacionComprobante()));
				ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
			}

			ImprimirTicket.AddCabecera("FECHA: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getFechaComprobante()));
//			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddCabecera("PACIENTE: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNombrePaciente()));
//			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddCabecera("CONVENIO: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getConvenio()));
//			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddCabecera("No. CONTRATO: " + ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNumeroContrato()));
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddCabecera(ImprimirTicket.DarEspacio());

			// DETALLE DEL COMPROBANTE
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DibujarLinea(intWidthMaxPaper)); 
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.CabeceraDetalle());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DibujarLinea(intWidthMaxPaper)); 

			Integer intCantidadServicios = 0;
			Double douSumSubtotalVenta = .0;
			Double douSumSubtotalVentaSinIva = .0;
			Double douSumSubtotalVentaConIva = .0;
			Double douSumDescuentosVenta = .0;
			Double douSumSubtotalBaseImponibleVenta = .0;
			Double douSumIvaVenta = .0;
			Double douValorTotalVenta = .0;
			for (DatosImpresionTirillaFactura objDetalleComprobante : lsDatosImpresionTirillaFacturaXNumeroTransaccion) {

				ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
				if (objDetalleComprobante.getMostrarPrestacionCompleta()!=null && "S".equals(objDetalleComprobante.getMostrarPrestacionCompleta())) {
					ImprimirTicket.AddSubCabecera(ImprimirTicket.DetalleCompleto(ImprimirTicket.formatear(objDetalleComprobante.getNombrePrestacion()), 
							objDetalleComprobante.getCantidad()!=null?objDetalleComprobante.getCantidad().toString():"-", 
									objDetalleComprobante.getPrecioUnitarioVenta()!=null?objDetalleComprobante.getPrecioUnitarioVenta().toString():"-", 
											objDetalleComprobante.getSubtotalVenta()!=null?objDetalleComprobante.getSubtotalVenta().toString():"-"));
				} else {
					ImprimirTicket.AddSubCabecera(ImprimirTicket.Detalle(ImprimirTicket.formatear(objDetalleComprobante.getNombrePrestacion()), 
							objDetalleComprobante.getCantidad()!=null?objDetalleComprobante.getCantidad().toString():"-", 
									objDetalleComprobante.getPrecioUnitarioVenta()!=null?objDetalleComprobante.getPrecioUnitarioVenta().toString():"-", 
											objDetalleComprobante.getSubtotalVenta()!=null?objDetalleComprobante.getSubtotalVenta().toString():"-"));
				}

				intCantidadServicios = intCantidadServicios + (objDetalleComprobante.getCantidad()!=null?objDetalleComprobante.getCantidad():0);
				douSumSubtotalVenta = douSumSubtotalVenta + (objDetalleComprobante.getSubtotalVenta()!=null?objDetalleComprobante.getSubtotalVenta():.0);
				if (objDetalleComprobante.getAplicaIva()!=null && "S".equalsIgnoreCase(objDetalleComprobante.getAplicaIva())) {
					douSumSubtotalVentaConIva = douSumSubtotalVentaConIva + (objDetalleComprobante.getSubtotalVenta()!=null?objDetalleComprobante.getSubtotalVenta():.0);
				} else {
					douSumSubtotalVentaSinIva = douSumSubtotalVentaSinIva + (objDetalleComprobante.getSubtotalVenta()!=null?objDetalleComprobante.getSubtotalVenta():.0);
				}
				douSumDescuentosVenta = douSumDescuentosVenta + (objDetalleComprobante.getValorDescuento()!=null?objDetalleComprobante.getValorDescuento():.0);
				douSumSubtotalBaseImponibleVenta = douSumSubtotalBaseImponibleVenta + (objDetalleComprobante.getSubtotalBaseImponible()!=null?objDetalleComprobante.getSubtotalBaseImponible():.0);
				douSumIvaVenta = douSumIvaVenta + (objDetalleComprobante.getValorIva()!=null?objDetalleComprobante.getValorIva():.0);
				douValorTotalVenta = douValorTotalVenta + (objDetalleComprobante.getValorTotal()!=null?objDetalleComprobante.getValorTotal():.0);
			}

			// Redondeo primario por error en decimales 
			douSumSubtotalVenta = (Double) redondearDecimales(douSumSubtotalVenta, DECIMAS_REDONDEO_X_ERROR);
			douSumSubtotalVentaSinIva = (Double) redondearDecimales(douSumSubtotalVentaSinIva, DECIMAS_REDONDEO_X_ERROR);
			douSumSubtotalVentaConIva = (Double) redondearDecimales(douSumSubtotalVentaConIva, DECIMAS_REDONDEO_X_ERROR);
			douSumDescuentosVenta = (Double) redondearDecimales(douSumDescuentosVenta, DECIMAS_REDONDEO_X_ERROR);
			douSumSubtotalBaseImponibleVenta = (Double) redondearDecimales(douSumSubtotalBaseImponibleVenta, DECIMAS_REDONDEO_X_ERROR);
			douSumIvaVenta = (Double) redondearDecimales(douSumIvaVenta, DECIMAS_REDONDEO_X_ERROR);
			douValorTotalVenta = (Double) redondearDecimales(douValorTotalVenta, DECIMAS_REDONDEO_X_ERROR);


			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DibujarLinea(intWidthMaxPaper));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Cabecera("Cant Item(s): ", intCantidadServicios.toString()));
//			ImprimirTicket.AddSubCabecera(ImprimirTicket.Detalle("Cant Item(s):", 
//					intCantidadServicios.toString(), 
//					"", 
//					""));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("Valor", ((Double)redondearDecimales(douSumSubtotalCopago+douSumSubtotalCliente, intNumMaxDecimasRed)).toString(), "D"));
//			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());

			ImprimirTicket.AddSubCabecera(ImprimirTicket.DibujarLineaater(intWidthMaxPaper));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("Subtotal "+new DecimalFormat("#0").format(douPorcentajeIva)+"%:", ((Double)redondearDecimales(douSumSubtotalVentaConIva, intNumMaxDecimasRed)).toString() , "D"));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("Subtotal 0%:", ((Double)redondearDecimales(douSumSubtotalVentaSinIva, intNumMaxDecimasRed)).toString(), "D"));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("Subt. Exc. IVA:", ((Double)redondearDecimales(0.00, intNumMaxDecimasRed)).toString(), "D"));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("Descuento:", ((Double)redondearDecimales(douSumDescuentosVenta, intNumMaxDecimasRed)).toString(), "D"));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("Subtotal:", ((Double)redondearDecimales(douSumSubtotalBaseImponibleVenta, intNumMaxDecimasRed)).toString(), "D"));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal("IVA "+new DecimalFormat("#0").format(douPorcentajeIva)+"%:", ((Double)redondearDecimales(douSumIvaVenta, intNumMaxDecimasRed)).toString(), "D"));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DibujarLineaater(intWidthMaxPaper));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.totales("VALOR TOTAL:", ((Double)redondearDecimales(douValorTotalVenta, intNumIdealDecimasRed)).toString()));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DibujarLineaater(intWidthMaxPaper));

			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getEtiquetaContribuyente()));
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());

			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());

			// PAGOS DEL COMPROBANTE
			if (lsFacPagosXNumeroTransaccion!=null && !lsFacPagosXNumeroTransaccion.isEmpty() && lsFacPagosXNumeroTransaccion.size()>0) { 
				Double douValorCambio = .0;
				ImprimirTicket.AddSubCabecera(ImprimirTicket.alineacion("FORMAS DE PAGO", intWidthMaxPaper, chrEspacioBlanco));
				for (FacPagos objPagos : lsFacPagosXNumeroTransaccion) {
					ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
					ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal(ImprimirTicket.formatear(objPagos.getNombreFormaPago()) + ":", objPagos.getValor()!=null?objPagos.getValor().toString():"-", "D"));
					douValorCambio = douValorCambio + (objPagos.getValorCambio()!=null&&objPagos.getValorCambio()>.0?objPagos.getValorCambio():.0);
				}

				ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
				ImprimirTicket.AddSubCabecera(ImprimirTicket.Subtotal(ImprimirTicket.formatear("Cambio: "), ((Double)redondearDecimales(douValorCambio, intNumIdealDecimasRed)).toString(), "D"));
				ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
				ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
			}

			// ADICIONALES FINALES DEL COMPROBANTE
//			ImprimirTicket.AddPieLinea(ImprimirTicket.Cabecera("Profesional: ", ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNombreProfesional())));
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio()); 

//			if (objDatosImpresionTirillaFactura.getNombreSitio() != null) {
//				ImprimirTicket.AddPieLinea(ImprimirTicket.Cabecera("Consultorio: ", ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getNombreSitio())));
//				ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			}
                        ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
                        ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
                        ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
                        ImprimirTicket.AddSubCabecera(ImprimirTicket.Cabecera("Puntos ganados: ", ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getPuntosAcumulados().toString())+"       "));
                        ImprimirTicket.AddSubCabecera(ImprimirTicket.DarEspacio());
                        ImprimirTicket.AddSubCabecera(ImprimirTicket.Cabecera("Saldo actual: ", ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getSaldoPuntos().toString())));
                        ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
                        ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());

			ImprimirTicket.AddPieLinea(ImprimirTicket.Cabecera("Cajero: ", ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getCajero())));
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio()); 
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());

//			ImprimirTicket.AddPieLinea(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getInfoConsultaResultados()), intWidthMaxPaper, chrEspacioBlanco)); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.formatear(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getInfoIngresaVerisLab())));
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.agregarBlanco_Split_pie("CI Paciente: ", objDatosImpresionTirillaFactura.getNumeroIdentificacionPaciente() )); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.agregarBlanco_Split_pie("Cod Visualizacion: ", objDatosImpresionTirillaFactura.getNumeroOrden()!=null?objDatosImpresionTirillaFactura.getNumeroOrden().toString():"-" )); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getInfoConsultaResultadosAdic()));
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());

			if (objDatosImpresionTirillaFactura.getMensajePaquete() != null) {
				ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
				ImprimirTicket.AddPieLinea(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getMensajePaquete()));
				ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			}

//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getInfoConsultaFactura()), intWidthMaxPaper, chrEspacioBlanco)); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getInfoIngresaVerisFact()), intWidthMaxPaper, chrEspacioBlanco)); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.agregarBlanco_Split_pie("Usuario: ", objDatosImpresionTirillaFactura.getNumeroIdentificacionFactura()!=null?objDatosImpresionTirillaFactura.getNumeroIdentificacionFactura():" ")); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.agregarBlanco_Split_pie("Clave: ", objDatosImpresionTirillaFactura.getClaveSri()));
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio()); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio()); 
			ImprimirTicket.AddPieLinea(ImprimirTicket.alineacion(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getGraciasAlCliente()), intWidthMaxPaper, chrEspacioBlanco));
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DibujarLinea(intWidthMaxPaper));
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
//			ImprimirTicket.AddPieLinea(ImprimirTicket.alineacion("FIRMA", intWidthMaxPaper, chrEspacioBlanco)); 
//			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
                        
                        
			ImprimirTicket.AddPieLinea(ImprimirTicket.Cabecera("Transaccion: ", ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getSecuenciaComprobante().toString())));
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			//Date datSysdate = new GeneralBO().getSysdate();
			//Date datSysdate = objDatosImpresionTirillaFactura.getFechaIngreso();
                        Date datSysdate = new Date();
			ImprimirTicket.AddPieLinea(ImprimirTicket.alineacion((new SimpleDateFormat("dd/MM/yyyy").format(datSysdate) + " " + new SimpleDateFormat("hh:mm:ss aa").format(datSysdate)), intWidthMaxPaper, chrEspacioBlanco)); 
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.formatear(objDatosImpresionTirillaFactura.getMensajeMktTermCond()));
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());
			ImprimirTicket.AddPieLinea(ImprimirTicket.DarEspacio());

			if (strEsImpresionVisual!=null && "S".equals(strEsImpresionVisual)) {
				List<String> lsCadenaTmp = ImprimirTicket.GenerarDocumentoXPantalla();
				if (lsCadenaTmp!=null && !lsCadenaTmp.isEmpty() && lsCadenaTmp.size()>0) {
					lsCadena.addAll(lsCadenaTmp);
					booImpresionExitosa = true;
				}
			} else {
				booImpresionExitosa = ImprimirTicket.ImprimirDocumento();
			}

			mapResult.put("booImpresionExitosa", booImpresionExitosa);
			if (strEsImpresionVisual!=null && "S".equals(strEsImpresionVisual)) {
				mapResult.put("lsCadena", lsCadena);
			}

		} catch (Exception e) {
			e.printStackTrace();
			mapResult.put("exception", e);
		}
		return mapResult;
	}

	private Double redondearDecimales(Double douValor, Integer intCantidadDecimales)
	{
		BigDecimal objBigDecimal = new BigDecimal(String.valueOf(douValor != null ? douValor : 0.00));
		BigDecimal objBigDecimalRedondeado = objBigDecimal.setScale(intCantidadDecimales, RoundingMode.HALF_UP);
		return objBigDecimalRedondeado.doubleValue();
	}
}