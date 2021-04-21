package ec.com.xuit.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class FacPagos {
    
    @Id
    private Long id;

    @Column(name = "SECUENCIA_COMPROBANTE")
    private BigDecimal secuenciaComprobante;
    
    @Column(name = "LINEA_DETALLE")
    private Integer lineaDetalle;
    
    @Column(name = "FECHA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "CODIGO_FORMA_PAGO")
    private Integer codigoFormaPago;
    
    @Column(name = "VALOR")
    private Double valor;
    
    @Column(name = "CODIGO_INSTITUCION")
    private Integer codigoInstitucion;
    
    @Column(name = "NUMERO_TARJETA")
    private String numeroTarjeta;
    
    @Column(name = "NUMERO_VOUCHER")
    private BigDecimal numeroVoucher;
    
    @Column(name = "NUMERO_AUTORIZACION")
    private BigDecimal numeroAutorizacion;
    
    @Column(name = "NUMERO_LOTE")
    private BigDecimal numeroLote;
    
    @Column(name = "NUMERO_CHEQUE")
    private BigDecimal numeroCheque;
    
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    
    @Column(name = "NOMBRE_TARJETA_CUENTA")
    private String nombreTarjetaCuenta;
    
    @Column(name = "ES_ACTIVO")
    private String esActivo;
    
    @Column(name = "CODIGO_MONEDA")
    private Integer codigoMoneda;
    
    @Column(name = "FECHA_INGRESO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIngreso;
    
    @Column(name = "USUARIO_INGRESO")
    private String usuarioIngreso;
    
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaModificacion;
    
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    
    @Column(name = "PLAZO")
    private String plazo;
    
    @Column(name = "CODIGO_MARCA_TC")
    private BigDecimal codigoMarcaTc;
    
    @Column(name = "TIPO_TARJETA")
    private String tipoTarjeta;
    
    @Column(name = "APLICA_INTERES")
    private String aplicaInteres;
    
    @Column(name = "CODIGO_INSTITUCION_LIQUIDADORA")
    private Integer codigoInstitucionLiquidadora;
    
    @Column(name = "NOMBRE_EMPRESA_RECAUDADORA")
    private String nombreEmpresaRecaudadora;
    
    @Column(name = "SECUENCIA")
    private BigDecimal secuencia;

    @Column(name = "NOTA")
    private String nota;
    
    //@Column(name = "DESCRIPCION_PAGO")
    private String descripcionPago; //Campo Clob en BD.
    
    @Column(name = "FECHA_CADUCIDAD")
    private String fechaCaducidad;
    
    @Column(name = "NOMBRE_BENEFICIARIO")
    private String nombreBeneficiario;
    
    @Column(name = "VALOR_DEVUELTO")
    private Double valorDevuelto;
    
    @Column(name = "VALOR_SALDO")
    private Double valorSaldo;
    
    @Column(name = "CODIGO_PERSONAL")
    private Integer codigoPersonal;
    
    @Column(name = "CODIGO_EMPRESA_PERSONAL")
    private Integer codigoEmpresaPersonal;
    
    @Column(name = "VALOR_CAMBIO")
    private Double valorCambio;
    
    //=========================================================== INI - VARIABLES DE DESARROLLO ===========================================================//
    private String mnemonicoFormaPago;
    
    @Column(name = "NOMBRE_FORMA_PAGO")
    private String nombreFormaPago;
    
    @Column(name = "NUMERO_TRANSACCION")
    private BigDecimal numeroTransaccion;
    
    private BigDecimal numeroOrden;
    
    private BigDecimal idTransaccion;
    
    private boolean ingresoManual;
    private String status;
    private Integer index;
    
    private Double valorADevolver;
    private String bloquearSeleccionXSaldoCero;
    
    private String esPagoXSolicitudDomicilio;
    
    //=========================================================== FIN - VARIABLES DE DESARROLLO ===========================================================//
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSecuenciaComprobante() {
        return secuenciaComprobante;
    }

    public void setSecuenciaComprobante(BigDecimal secuenciaComprobante) {
        this.secuenciaComprobante = secuenciaComprobante;
    }

    public Integer getLineaDetalle() {
        return lineaDetalle;
    }

    public void setLineaDetalle(Integer lineaDetalle) {
        this.lineaDetalle = lineaDetalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(Integer codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Integer codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public BigDecimal getNumeroVoucher() {
        return numeroVoucher;
    }

    public void setNumeroVoucher(BigDecimal numeroVoucher) {
        this.numeroVoucher = numeroVoucher;
    }

    public BigDecimal getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(BigDecimal numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public BigDecimal getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(BigDecimal numeroLote) {
        this.numeroLote = numeroLote;
    }

    public BigDecimal getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(BigDecimal numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreTarjetaCuenta() {
        return nombreTarjetaCuenta;
    }

    public void setNombreTarjetaCuenta(String nombreTarjetaCuenta) {
        this.nombreTarjetaCuenta = nombreTarjetaCuenta;
    }

    public String getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(String esActivo) {
        this.esActivo = esActivo;
    }

    public Integer getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(Integer codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getCodigoMarcaTc() {
        return codigoMarcaTc;
    }

    public void setCodigoMarcaTc(BigDecimal codigoMarcaTc) {
        this.codigoMarcaTc = codigoMarcaTc;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getAplicaInteres() {
        return aplicaInteres;
    }

    public void setAplicaInteres(String aplicaInteres) {
        this.aplicaInteres = aplicaInteres;
    }

    public Integer getCodigoInstitucionLiquidadora() {
        return codigoInstitucionLiquidadora;
    }

    public void setCodigoInstitucionLiquidadora(Integer codigoInstitucionLiquidadora) {
        this.codigoInstitucionLiquidadora = codigoInstitucionLiquidadora;
    }

    public String getNombreEmpresaRecaudadora() {
        return nombreEmpresaRecaudadora;
    }

    public void setNombreEmpresaRecaudadora(String nombreEmpresaRecaudadora) {
        this.nombreEmpresaRecaudadora = nombreEmpresaRecaudadora;
    }

    public BigDecimal getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDescripcionPago() {
        return descripcionPago;
    }

    public void setDescripcionPago(String descripcionPago) {
        this.descripcionPago = descripcionPago;
    }

    public Double getValorCambio() {
        return valorCambio;
    }

    public void setValorCambio(Double valorCambio) {
        this.valorCambio = valorCambio;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getMnemonicoFormaPago() {
        return mnemonicoFormaPago;
    }

    public void setMnemonicoFormaPago(String mnemonicoFormaPago) {
        this.mnemonicoFormaPago = mnemonicoFormaPago;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public boolean isIngresoManual() {
        return ingresoManual;
    }

    public void setIngresoManual(boolean ingresoManual) {
        this.ingresoManual = ingresoManual;
    }

    public BigDecimal getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(BigDecimal numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public BigDecimal getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(BigDecimal numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public Double getValorDevuelto() {
        return valorDevuelto;
    }

    public void setValorDevuelto(Double valorDevuelto) {
        this.valorDevuelto = valorDevuelto;
    }

    public Double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(Double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    public Double getValorADevolver() {
        return valorADevolver;
    }

    public void setValorADevolver(Double valorADevolver) {
        this.valorADevolver = valorADevolver;
    }

    public String getBloquearSeleccionXSaldoCero() {
        return bloquearSeleccionXSaldoCero;
    }

    public void setBloquearSeleccionXSaldoCero(String bloquearSeleccionXSaldoCero) {
        this.bloquearSeleccionXSaldoCero = bloquearSeleccionXSaldoCero;
    }

    public Integer getCodigoPersonal() {
        return codigoPersonal;
    }

    public void setCodigoPersonal(Integer codigoPersonal) {
        this.codigoPersonal = codigoPersonal;
    }

    public Integer getCodigoEmpresaPersonal() {
        return codigoEmpresaPersonal;
    }

    public void setCodigoEmpresaPersonal(Integer codigoEmpresaPersonal) {
        this.codigoEmpresaPersonal = codigoEmpresaPersonal;
    }

    public BigDecimal getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigDecimal idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getEsPagoXSolicitudDomicilio() {
        return esPagoXSolicitudDomicilio;
    }

    public void setEsPagoXSolicitudDomicilio(String esPagoXSolicitudDomicilio) {
        this.esPagoXSolicitudDomicilio = esPagoXSolicitudDomicilio;
    }
    
}