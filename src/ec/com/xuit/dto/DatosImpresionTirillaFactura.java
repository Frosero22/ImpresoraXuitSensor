package ec.com.xuit.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DatosImpresionTirillaFactura {

    @Id
    private Long id;

    @Column(name = "NUMERO_ORDEN")
    private BigDecimal numeroOrden;

    @Column(name = "SECUENCIA_COMPROBANTE")
    private BigDecimal secuenciaComprobante;

    @Column(name = "NOMBRE_SUCURSAL")
    private String nombreSucursal;

    @Column(name = "ADICIONAL_CAPITAL_PAIS")
    private String adicionalCapitalPais;

    @Column(name = "ADICIONAL_NOMBRE_EMPRESA")
    private String adicionalNombreEmpresa;

    @Column(name = "RUC_EMPRESA")
    private String rucEmpresa;

    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;

    @Column(name = "ADICIONAL_FACTURA")
    private String adicionalFactura;

    @Column(name = "ADICIONAL_DOCUMENTO")
    private String adicionalDocumento;

    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;

    @Column(name = "NUMERO_IDENTIFICACION_CLIENTE")
    private String numeroIdentificacionCliente;

    @Column(name = "ETIQUETA_COMPROBANTE")
    private String etiquetaComprobante;

    @Column(name = "COMPROBANTE")
    private String comprobante;

    @Column(name = "ETIQUETA_AUTORIZACION_COMPROB")
    private String etiquetaAutorizacionComprob;

    @Column(name = "AUTORIZACION_COMPROBANTE")
    private String autorizacionComprobante;

    @Column(name = "FECHA_COMPROBANTE")
    private String fechaComprobante;

    @Column(name = "NOMBRE_PACIENTE")
    private String nombrePaciente;

    @Column(name = "NUMERO_IDENTIFICACION_PACIENTE")
    private String numeroIdentificacionPaciente;

    @Column(name = "CODIGO_TIPO_IDENTIFICACION_PAC")
    private Integer codigoTipoIdentificacionPac;

    @Column(name = "CONVENIO")
    private String convenio;

    @Column(name = "NUMERO_CONTRATO")
    private String numeroContrato;

    @Column(name = "ETIQUETA_CONTRIBUYENTE")
    private String etiquetaContribuyente;

    @Column(name = "CODIGO_MEDICO")
    private BigDecimal codigoMedico;

    @Column(name = "NOMBRE_PROFESIONAL")
    private String nombreProfesional;

    @Column(name = "CAJERO")
    private String cajero;

    @Column(name = "INFO_CONSULTA_RESULTADOS")
    private String infoConsultaResultados;

    @Column(name = "INFO_INGRESA_VERIS_LAB")
    private String infoIngresaVerisLab;

    @Column(name = "INFO_CONSULTA_FACTURA")
    private String infoConsultaFactura;

    @Column(name = "INFO_INGRESA_VERIS_FACT")
    private String infoIngresaVerisFact;

    @Column(name = "CODIGO_USUARIO_SRI")
    private String codigoUsuarioSri;

    @Column(name = "CLAVE_SRI")
    private String claveSri;

    @Column(name = "GRACIAS_AL_CLIENTE")
    private String graciasAlCliente;

    @Column(name = "MENSAJE_FIRMA")
    private String mensajeFirma;

    @Column(name = "NUMERO_TRANSACCION")
    private BigDecimal numeroTransaccion;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO_VENTA")
    private Double precioUnitarioVenta;

    @Column(name = "PRECIO_UNITARIO_COPAGO")
    private Double precioUnitarioCopago;

    @Column(name = "PRECIO_UNITARIO_CLIENTE")
    private Double precioUnitarioCliente;

    @Column(name = "SUBTOTAL_VENTA")
    private Double subtotalVenta;

    @Column(name = "SUBTOTAL_COPAGO")
    private Double subtotalCopago;

    @Column(name = "SUBTOTAL_CLIENTE")
    private Double subtotalCliente;

    @Column(name = "PORCENTAJE_DESCUENTO")
    private Double porcentajeDescuento;

    @Column(name = "VALOR_DESCUENTO")
    private Double valorDescuento;

    @Column(name = "PORCENTAJE_DESCUENTO_CLIENTE")
    private Double porcentajeDescuentoCliente;

    @Column(name = "VALOR_DESCUENTO_CLIENTE")
    private Double valorDescuentoCliente;

    @Column(name = "SUBTOTAL_BASE_IMPONIBLE")
    private Double subtotalBaseImponible;

    @Column(name = "SUBTOTAL_BASE_IMPONIBLE_CLIENT")
    private Double subtotalBaseImponibleClient;

    @Column(name = "APLICA_IVA")
    private String aplicaIva;

    @Column(name = "PORCENTAJE_IVA")
    private Double porcentajeIva;

    @Column(name = "VALOR_IVA")
    private Double valorIva;

    @Column(name = "VALOR_IVA_CLIENTE")
    private Double valorIvaCliente;

    @Column(name = "VALOR_TOTAL_COPAGO")
    private Double valorTotalCopago;

    @Column(name = "VALOR_TOTAL_CLIENTE")
    private Double valorTotalCliente;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "CODIGO_PRESTACION")
    private BigDecimal codigoPrestacion;

    @Column(name = "NOMBRE_PRESTACION")
    private String nombrePrestacion;

    @Column(name = "CODIGO_SERVICIO")
    private BigDecimal codigoServicio;

    @Column(name = "NOMBRE_SERVICIO")
    private String nombreServicio;

    @Column(name = "NUMERO_IDENTIFICACION_FACTURA")
    private String numeroIdentificacionFactura;

    @Column(name = "NUM_MAX_DECIMAS_REDONDEO")
    private Double numMaxDecimasRedondeo;

    @Column(name = "NUM_DECIMAS_REDONDEO")
    private Double numDecimasRedondeo;

    @Column(name = "MENSAJE_PAQUETE")
    private String mensajePaquete;

    @Column(name = "MENSAJE_MKT_TERM_COND")
    private String mensajeMktTermCond;

    @Column(name = "MOSTRAR_PRESTACION_COMPLETA")
    private String mostrarPrestacionCompleta;

    @Column(name = "INFO_CONSULTA_RESULTADOS_ADIC")
    private String infoConsultaResultadosAdic;

    @Column(name = "NOMBRE_SITIO")
    private String nombreSitio;

    @Column(name = "PUNTOS_ACUMULADOS")
    private BigDecimal puntosAcumulados;

    @Column(name = "SALDO_PUNTOS")
    private BigDecimal saldoPuntos;

    /*@Column(name = "FECHA_INGRESO")
     private Date fechaIngreso;*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(BigDecimal numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public BigDecimal getSecuenciaComprobante() {
        return secuenciaComprobante;
    }

    public void setSecuenciaComprobante(BigDecimal secuenciaComprobante) {
        this.secuenciaComprobante = secuenciaComprobante;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getAdicionalCapitalPais() {
        return adicionalCapitalPais;
    }

    public void setAdicionalCapitalPais(String adicionalCapitalPais) {
        this.adicionalCapitalPais = adicionalCapitalPais;
    }

    public String getAdicionalNombreEmpresa() {
        return adicionalNombreEmpresa;
    }

    public void setAdicionalNombreEmpresa(String adicionalNombreEmpresa) {
        this.adicionalNombreEmpresa = adicionalNombreEmpresa;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getAdicionalFactura() {
        return adicionalFactura;
    }

    public void setAdicionalFactura(String adicionalFactura) {
        this.adicionalFactura = adicionalFactura;
    }

    public String getAdicionalDocumento() {
        return adicionalDocumento;
    }

    public void setAdicionalDocumento(String adicionalDocumento) {
        this.adicionalDocumento = adicionalDocumento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroIdentificacionCliente() {
        return numeroIdentificacionCliente;
    }

    public void setNumeroIdentificacionCliente(String numeroIdentificacionCliente) {
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
    }

    public String getEtiquetaComprobante() {
        return etiquetaComprobante;
    }

    public void setEtiquetaComprobante(String etiquetaComprobante) {
        this.etiquetaComprobante = etiquetaComprobante;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(String fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNumeroIdentificacionPaciente() {
        return numeroIdentificacionPaciente;
    }

    public void setNumeroIdentificacionPaciente(String numeroIdentificacionPaciente) {
        this.numeroIdentificacionPaciente = numeroIdentificacionPaciente;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getEtiquetaContribuyente() {
        return etiquetaContribuyente;
    }

    public void setEtiquetaContribuyente(String etiquetaContribuyente) {
        this.etiquetaContribuyente = etiquetaContribuyente;
    }

    public BigDecimal getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(BigDecimal codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getInfoConsultaResultados() {
        return infoConsultaResultados;
    }

    public void setInfoConsultaResultados(String infoConsultaResultados) {
        this.infoConsultaResultados = infoConsultaResultados;
    }

    public String getInfoIngresaVerisLab() {
        return infoIngresaVerisLab;
    }

    public void setInfoIngresaVerisLab(String infoIngresaVerisLab) {
        this.infoIngresaVerisLab = infoIngresaVerisLab;
    }

    public String getInfoConsultaFactura() {
        return infoConsultaFactura;
    }

    public void setInfoConsultaFactura(String infoConsultaFactura) {
        this.infoConsultaFactura = infoConsultaFactura;
    }

    public String getInfoIngresaVerisFact() {
        return infoIngresaVerisFact;
    }

    public void setInfoIngresaVerisFact(String infoIngresaVerisFact) {
        this.infoIngresaVerisFact = infoIngresaVerisFact;
    }

    public String getCodigoUsuarioSri() {
        return codigoUsuarioSri;
    }

    public void setCodigoUsuarioSri(String codigoUsuarioSri) {
        this.codigoUsuarioSri = codigoUsuarioSri;
    }

    public String getClaveSri() {
        return claveSri;
    }

    public void setClaveSri(String claveSri) {
        this.claveSri = claveSri;
    }

    public String getGraciasAlCliente() {
        return graciasAlCliente;
    }

    public void setGraciasAlCliente(String graciasAlCliente) {
        this.graciasAlCliente = graciasAlCliente;
    }

    public String getMensajeFirma() {
        return mensajeFirma;
    }

    public void setMensajeFirma(String mensajeFirma) {
        this.mensajeFirma = mensajeFirma;
    }

    public BigDecimal getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(BigDecimal numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public Double getPrecioUnitarioCopago() {
        return precioUnitarioCopago;
    }

    public void setPrecioUnitarioCopago(Double precioUnitarioCopago) {
        this.precioUnitarioCopago = precioUnitarioCopago;
    }

    public Double getPrecioUnitarioCliente() {
        return precioUnitarioCliente;
    }

    public void setPrecioUnitarioCliente(Double precioUnitarioCliente) {
        this.precioUnitarioCliente = precioUnitarioCliente;
    }

    public Double getSubtotalVenta() {
        return subtotalVenta;
    }

    public void setSubtotalVenta(Double subtotalVenta) {
        this.subtotalVenta = subtotalVenta;
    }

    public Double getSubtotalCopago() {
        return subtotalCopago;
    }

    public void setSubtotalCopago(Double subtotalCopago) {
        this.subtotalCopago = subtotalCopago;
    }

    public Double getSubtotalCliente() {
        return subtotalCliente;
    }

    public void setSubtotalCliente(Double subtotalCliente) {
        this.subtotalCliente = subtotalCliente;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public Double getPorcentajeDescuentoCliente() {
        return porcentajeDescuentoCliente;
    }

    public void setPorcentajeDescuentoCliente(Double porcentajeDescuentoCliente) {
        this.porcentajeDescuentoCliente = porcentajeDescuentoCliente;
    }

    public Double getValorDescuentoCliente() {
        return valorDescuentoCliente;
    }

    public void setValorDescuentoCliente(Double valorDescuentoCliente) {
        this.valorDescuentoCliente = valorDescuentoCliente;
    }

    public Double getSubtotalBaseImponible() {
        return subtotalBaseImponible;
    }

    public void setSubtotalBaseImponible(Double subtotalBaseImponible) {
        this.subtotalBaseImponible = subtotalBaseImponible;
    }

    public Double getSubtotalBaseImponibleClient() {
        return subtotalBaseImponibleClient;
    }

    public void setSubtotalBaseImponibleClient(Double subtotalBaseImponibleClient) {
        this.subtotalBaseImponibleClient = subtotalBaseImponibleClient;
    }

    public String getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(String aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public Double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    public Double getValorIvaCliente() {
        return valorIvaCliente;
    }

    public void setValorIvaCliente(Double valorIvaCliente) {
        this.valorIvaCliente = valorIvaCliente;
    }

    public Double getValorTotalCopago() {
        return valorTotalCopago;
    }

    public void setValorTotalCopago(Double valorTotalCopago) {
        this.valorTotalCopago = valorTotalCopago;
    }

    public Double getValorTotalCliente() {
        return valorTotalCliente;
    }

    public void setValorTotalCliente(Double valorTotalCliente) {
        this.valorTotalCliente = valorTotalCliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getCodigoPrestacion() {
        return codigoPrestacion;
    }

    public void setCodigoPrestacion(BigDecimal codigoPrestacion) {
        this.codigoPrestacion = codigoPrestacion;
    }

    public String getNombrePrestacion() {
        return nombrePrestacion;
    }

    public void setNombrePrestacion(String nombrePrestacion) {
        this.nombrePrestacion = nombrePrestacion;
    }

    public BigDecimal getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(BigDecimal codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNumeroIdentificacionFactura() {
        return numeroIdentificacionFactura;
    }

    public void setNumeroIdentificacionFactura(String numeroIdentificacionFactura) {
        this.numeroIdentificacionFactura = numeroIdentificacionFactura;
    }

    public Double getNumMaxDecimasRedondeo() {
        return numMaxDecimasRedondeo;
    }

    public void setNumMaxDecimasRedondeo(Double numMaxDecimasRedondeo) {
        this.numMaxDecimasRedondeo = numMaxDecimasRedondeo;
    }

    public Double getNumDecimasRedondeo() {
        return numDecimasRedondeo;
    }

    public void setNumDecimasRedondeo(Double numDecimasRedondeo) {
        this.numDecimasRedondeo = numDecimasRedondeo;
    }

    public String getEtiquetaAutorizacionComprob() {
        return etiquetaAutorizacionComprob;
    }

    public void setEtiquetaAutorizacionComprob(String etiquetaAutorizacionComprob) {
        this.etiquetaAutorizacionComprob = etiquetaAutorizacionComprob;
    }

    public String getAutorizacionComprobante() {
        return autorizacionComprobante;
    }

    public void setAutorizacionComprobante(String autorizacionComprobante) {
        this.autorizacionComprobante = autorizacionComprobante;
    }

    public String getMensajePaquete() {
        return mensajePaquete;
    }

    public void setMensajePaquete(String mensajePaquete) {
        this.mensajePaquete = mensajePaquete;
    }

    public String getMostrarPrestacionCompleta() {
        return mostrarPrestacionCompleta;
    }

    public void setMostrarPrestacionCompleta(String mostrarPrestacionCompleta) {
        this.mostrarPrestacionCompleta = mostrarPrestacionCompleta;
    }

    public Integer getCodigoTipoIdentificacionPac() {
        return codigoTipoIdentificacionPac;
    }

    public void setCodigoTipoIdentificacionPac(Integer codigoTipoIdentificacionPac) {
        this.codigoTipoIdentificacionPac = codigoTipoIdentificacionPac;
    }

    public String getMensajeMktTermCond() {
        return mensajeMktTermCond;
    }

    public void setMensajeMktTermCond(String mensajeMktTermCond) {
        this.mensajeMktTermCond = mensajeMktTermCond;
    }

    public String getInfoConsultaResultadosAdic() {
        return infoConsultaResultadosAdic;
    }

    public void setInfoConsultaResultadosAdic(String infoConsultaResultadosAdic) {
        this.infoConsultaResultadosAdic = infoConsultaResultadosAdic;
    }

    public String getNombreSitio() {
        return nombreSitio;
    }

    public void setNombreSitio(String nombreSitio) {
        this.nombreSitio = nombreSitio;
    }

    /*public Date getFechaIngreso() {
     return fechaIngreso;
     }

     public void setFechaIngreso(Date fechaIngreso) {
     this.fechaIngreso = fechaIngreso;
     }*/

    public BigDecimal getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(BigDecimal puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public BigDecimal getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(BigDecimal saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }
    
    
    
}
