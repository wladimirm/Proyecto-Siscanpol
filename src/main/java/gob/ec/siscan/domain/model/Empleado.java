package gob.ec.siscan.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import gob.ec.siscan.domain.model.base.AuditingEntity;

@Entity
@Table(name = "Empleado")
@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
public class Empleado extends AuditingEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idEmpleado;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String tipoDocumento;
	private String numeroDocumento;
	private String genero;
	private String estadoCivil;
	private String grupoSangre;
	private Integer discapacitado;
	//private String foto;
	private Date fechaNacimiento;
	private String codigo;
	private String emailInterno;
	private String telefonoInterno;
	private String anexoInterno;
	private String cargo;
	private String contratoTrabajo;
	//private String convenio;
	private String regimenHorario;
	private String regimenLaboral;
	//private Integer esPersonalDeConfianza;
	//private String situacionTrabajador;
	private String tipoTrabajador;
	private String telefonoCasa;
	private String telefonoCelular;
	private String telefonoAdicional;
	private String emailPersonal;
	private String tipoDomicilio;
	private String direccionDomicilio;
	
	private String nombreContactoEmergencia;
	private String emailContactoEmergencia;
	private String telefonoContactoEmergencia;
	private String relacionContactoEmergencia;
	private Date fechaIngreso;
	private Date fechaRenuncia;
	private String motivoRenuncia;
	private Date fechaCese;
	private String estado;
	
	private Empresa empresa;
//	private CentroCosto centroCosto;
	private List<DocumentoEmpleado> documentosEmpleado;
//	private List<Educacion> educacionesEmpleado;
//	private List<ExperienciaLaboral> experienciasLaboralesEmpleado;
//	private List<EquipoEntregado> equiposEntregadoEmpleado;
//	private List<Dependiente> dependientesEmpleado;
	
	private Integer tieneEps;
	
	private String entidadBancariaSueldo;
	private String afp;
	private String eps;
	private String cts;
	
	private String cusppNumero;
	
	private Long idPaisNacimiento;
	private Long idDepartamentoNacimiento;
	private Long idProvinciaNacimiento;
	private Long idDistritoNacimiento;
	
	private Long idPaisDomicilio;
	private Long idDepartamentoDomicilio;
	private Long idProvinciaDomicilio;
	private Long idDistritoDomicilio;
	
	private Integer publicarTelefonoCasa;
	private Integer publicarTelefonoPersonal;
	private Integer publicarTelefonoAdicional;
	private Integer publicarEmailPersonal;
	
	private String categoriaEmpleado;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpleado")
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	@Column(name = "Nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "ApellidoPaterno")
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	@Column(name = "ApellidoMaterno")
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	@Column(name = "TipoDocumento")
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	@Column(name = "NumeroDocumento")
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	@Column(name = "Genero")
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Column(name = "EstadoCivil")
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Column(name = "GrupoSangre")
	public String getGrupoSangre() {
		return grupoSangre;
	}
	
	public void setGrupoSangre(String grupoSangre) {
		this.grupoSangre = grupoSangre;
	}
	
	@Column(name = "Discapacitado")
	public Integer getDiscapacitado() {
		return discapacitado;
	}
	
	public void setDiscapacitado(Integer discapacitado) {
		this.discapacitado = discapacitado;
	}
	
	/*@Column(name = "Foto")
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}*/
	
	@Column(name = "FechaNacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Column(name = "Codigo")
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Column(name = "EmailInterno")
	public String getEmailInterno() {
		return emailInterno;
	}
	
	public void setEmailInterno(String emailInterno) {
		this.emailInterno = emailInterno;
	}
	
	@Column(name = "TelefonoInterno")
	public String getTelefonoInterno() {
		return telefonoInterno;
	}
	
	public void setTelefonoInterno(String telefonoInterno) {
		this.telefonoInterno = telefonoInterno;
	}
	
	@Column(name = "AnexoInterno")
	public String getAnexoInterno() {
		return anexoInterno;
	}
	
	public void setAnexoInterno(String anexoInterno) {
		this.anexoInterno = anexoInterno;
	}
	
	@Column(name = "ContratoTrabajo")
	public String getContratoTrabajo() {
		return contratoTrabajo;
	}
	
	public void setContratoTrabajo(String contratoTrabajo) {
		this.contratoTrabajo = contratoTrabajo;
	}
	
	/*@Column(name = "Convenio")
	public String getConvenio() {
		return convenio;
	}
	
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}*/
	
	@Column(name = "RegimenHorario")
	public String getRegimenHorario() {
		return regimenHorario;
	}
	
	public void setRegimenHorario(String regimenHorario) {
		this.regimenHorario = regimenHorario;
	}
	
	@Column(name = "RegimenLaboral")
	public String getRegimenLaboral() {
		return regimenLaboral;
	}
	
	public void setRegimenLaboral(String regimenLaboral) {
		this.regimenLaboral = regimenLaboral;
	}
	
	/*@Column(name = "EsPersonalDeConfianza")
	public Integer getEsPersonalDeConfianza() {
		return esPersonalDeConfianza;
	}
	
	public void setEsPersonalDeConfianza(Integer esPersonalDeConfianza) {
		this.esPersonalDeConfianza = esPersonalDeConfianza;
	}*/
	
	/*@Column(name = "SituacionTrabajador")
	public String getSituacionTrabajador() {
		return situacionTrabajador;
	}
	
	public void setSituacionTrabajador(String situacionTrabajador) {
		this.situacionTrabajador = situacionTrabajador;
	}*/
	
	@Column(name = "TipoTrabajador")
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}
	
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	
	@Column(name = "TelefonoCasa")
	public String getTelefonoCasa() {
		return telefonoCasa;
	}
	
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}
	
	@Column(name = "TelefonoCelular")
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	
	@Column(name = "TelefonoAdicional")
	public String getTelefonoAdicional() {
		return telefonoAdicional;
	}
	
	public void setTelefonoAdicional(String telefonoAdicional) {
		this.telefonoAdicional = telefonoAdicional;
	}
	
	@Column(name = "EmailPersonal")
	public String getEmailPersonal() {
		return emailPersonal;
	}
	
	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	
	@Column(name = "TipoDomicilio")
	public String getTipoDomicilio() {
		return tipoDomicilio;
	}
	
	public void setTipoDomicilio(String tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}
	
	@Column(name = "DireccionDomicilio")
	public String getDireccionDomicilio() {
		return direccionDomicilio;
	}
	
	public void setDireccionDomicilio(String direccionDomicilio) {
		this.direccionDomicilio = direccionDomicilio;
	}
	
	@Column(name = "NombreContactoEmergencia")
	public String getNombreContactoEmergencia() {
		return nombreContactoEmergencia;
	}
	
	public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
		this.nombreContactoEmergencia = nombreContactoEmergencia;
	}
	
	@Column(name = "EmailContactoEmergencia")
	public String getEmailContactoEmergencia() {
		return emailContactoEmergencia;
	}
	
	public void setEmailContactoEmergencia(String emailContactoEmergencia) {
		this.emailContactoEmergencia = emailContactoEmergencia;
	}
	
	@Column(name = "TelefonoContactoEmergencia")
	public String getTelefonoContactoEmergencia() {
		return telefonoContactoEmergencia;
	}
	
	public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
		this.telefonoContactoEmergencia = telefonoContactoEmergencia;
	}
	
	@Column(name = "RelacionContactoEmergencia")
	public String getRelacionContactoEmergencia() {
		return relacionContactoEmergencia;
	}
	
	public void setRelacionContactoEmergencia(String relacionContactoEmergencia) {
		this.relacionContactoEmergencia = relacionContactoEmergencia;
	}
	
	@Column(name = "FechaIngreso")
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	@Column(name = "FechaRenuncia")
	public Date getFechaRenuncia() {
		return fechaRenuncia;
	}
	
	public void setFechaRenuncia(Date fechaRenuncia) {
		this.fechaRenuncia = fechaRenuncia;
	}
	
	@Column(name = "MotivoRenuncia")
	public String getMotivoRenuncia() {
		return motivoRenuncia;
	}
	
	public void setMotivoRenuncia(String motivoRenuncia) {
		this.motivoRenuncia = motivoRenuncia;
	}
	
	@Column(name = "FechaCese")
	public Date getFechaCese() {
		return fechaCese;
	}
	
	public void setFechaCese(Date fechaCese) {
		this.fechaCese = fechaCese;
	}

	@Column(name = "Estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@ManyToOne()
    @JoinColumn(name = "IdEmpresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},orphanRemoval=true, mappedBy = "empleado")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE,
			org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.PERSIST
	})
	public List<DocumentoEmpleado> getDocumentosEmpleado() {
		return documentosEmpleado;
	}

	public void setDocumentosEmpleado(List<DocumentoEmpleado> documentosEmpleado) {
		this.documentosEmpleado = documentosEmpleado;
	}


	@Column(name = "TieneEPS")
	public Integer getTieneEps() {
		return tieneEps;
	}

	public void setTieneEps(Integer tieneEps) {
		this.tieneEps = tieneEps;
	}

	@Column(name = "EntidadBancariaSueldo")
	public String getEntidadBancariaSueldo() {
		return entidadBancariaSueldo;
	}

	public void setEntidadBancariaSueldo(String entidadBancariaSueldo) {
		this.entidadBancariaSueldo = entidadBancariaSueldo;
	}

	@Column(name = "AFP")
	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	@Column(name = "EPS")
	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	@Column(name = "CTS")
	public String getCts() {
		return cts;
	}

	public void setCts(String cts) {
		this.cts = cts;
	}
	
	@Column(name = "CUSPPNumero")
	public String getCusppNumero() {
		return cusppNumero;
	}

	public void setCusppNumero(String cusppNumero) {
		this.cusppNumero = cusppNumero;
	}

	@Column(name = "IdPaisNacimiento")
	public Long getIdPaisNacimiento() {
		return idPaisNacimiento;
	}

	public void setIdPaisNacimiento(Long idPaisNacimiento) {
		this.idPaisNacimiento = idPaisNacimiento;
	}

	@Column(name = "IdDepartamentoNacimiento")
	public Long getIdDepartamentoNacimiento() {
		return idDepartamentoNacimiento;
	}

	public void setIdDepartamentoNacimiento(Long idDepartamentoNacimiento) {
		this.idDepartamentoNacimiento = idDepartamentoNacimiento;
	}

	@Column(name = "IdProvinciaNacimiento")
	public Long getIdProvinciaNacimiento() {
		return idProvinciaNacimiento;
	}

	public void setIdProvinciaNacimiento(Long idProvinciaNacimiento) {
		this.idProvinciaNacimiento = idProvinciaNacimiento;
	}

	@Column(name = "IdDistritoNacimiento")
	public Long getIdDistritoNacimiento() {
		return idDistritoNacimiento;
	}

	public void setIdDistritoNacimiento(Long idDistritoNacimiento) {
		this.idDistritoNacimiento = idDistritoNacimiento;
	}

	@Column(name = "IdPaisDomicilio")
	public Long getIdPaisDomicilio() {
		return idPaisDomicilio;
	}

	public void setIdPaisDomicilio(Long idPaisDomicilio) {
		this.idPaisDomicilio = idPaisDomicilio;
	}

	@Column(name = "IdDepartamentoDomicilio")
	public Long getIdDepartamentoDomicilio() {
		return idDepartamentoDomicilio;
	}

	public void setIdDepartamentoDomicilio(Long idDepartamentoDomicilio) {
		this.idDepartamentoDomicilio = idDepartamentoDomicilio;
	}

	@Column(name = "IdProvinciaDomicilio")
	public Long getIdProvinciaDomicilio() {
		return idProvinciaDomicilio;
	}

	public void setIdProvinciaDomicilio(Long idProvinciaDomicilio) {
		this.idProvinciaDomicilio = idProvinciaDomicilio;
	}

	@Column(name = "IdDistritoDomicilio")
	public Long getIdDistritoDomicilio() {
		return idDistritoDomicilio;
	}

	public void setIdDistritoDomicilio(Long idDistritoDomicilio) {
		this.idDistritoDomicilio = idDistritoDomicilio;
	}

	@Column(name = "PublicarTelefonoCasa")
	public Integer getPublicarTelefonoCasa() {
		return publicarTelefonoCasa;
	}

	public void setPublicarTelefonoCasa(Integer publicarTelefonoCasa) {
		this.publicarTelefonoCasa = publicarTelefonoCasa;
	}

	@Column(name = "PublicarTelefonoPersonal")
	public Integer getPublicarTelefonoPersonal() {
		return publicarTelefonoPersonal;
	}

	public void setPublicarTelefonoPersonal(Integer publicarTelefonoPersonal) {
		this.publicarTelefonoPersonal = publicarTelefonoPersonal;
	}

	@Column(name = "PublicarTelefonoAdicional")
	public Integer getPublicarTelefonoAdicional() {
		return publicarTelefonoAdicional;
	}

	public void setPublicarTelefonoAdicional(Integer publicarTelefonoAdicional) {
		this.publicarTelefonoAdicional = publicarTelefonoAdicional;
	}

	@Column(name = "PublicarEmailPersonal")
	public Integer getPublicarEmailPersonal() {
		return publicarEmailPersonal;
	}

	public void setPublicarEmailPersonal(Integer publicarEmailPersonal) {
		this.publicarEmailPersonal = publicarEmailPersonal;
	}

	@Column(name = "CategoriaEmpleado")
	public String getCategoriaEmpleado() {
		return categoriaEmpleado;
	}

	public void setCategoriaEmpleado(String categoriaEmpleado) {
		this.categoriaEmpleado = categoriaEmpleado;
	}

	@Column(name = "Cargo")
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
		
	
}