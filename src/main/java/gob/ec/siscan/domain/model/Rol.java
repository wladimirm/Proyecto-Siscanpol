package gob.ec.siscan.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 * 
 */
@Entity
@Table(name="Rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol extends AuditingEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idRol;
    private String nombre;
    private String descripcion;
    private Integer rolSistema;
    private String estado;
    private Empresa empresa;
    
    public List<Autorizacion> autorizacion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdRol")
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    @Column(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name="Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Column(name = "RolSistema")
    public Integer getRolSistema() {
        return rolSistema;
    }

    public void setRolSistema(Integer rolSistema) {
        this.rolSistema = rolSistema;
    }

    @Column(name="Estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String authority() {
        return "ROLE_" + this.nombre;
    }  
	
    @ManyToOne()
    @JoinColumn(name = "IdEmpresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},orphanRemoval=true, mappedBy = "rol",fetch=FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE,
			org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.PERSIST})
	public List<Autorizacion> getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(List<Autorizacion> autorizacion) {
		this.autorizacion = autorizacion;
	}
    
}
