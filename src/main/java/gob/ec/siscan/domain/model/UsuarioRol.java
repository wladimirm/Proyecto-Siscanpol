package gob.ec.siscan.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import gob.ec.siscan.domain.model.base.AuditingEntity;

/**
 *.
 */
@Entity
@Table(name="UsuarioRol")
@NamedQuery(name="UsuarioRol.findAll", query="SELECT u FROM UsuarioRol u")
public class UsuarioRol extends AuditingEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8253391951594175096L;
	private Long IdUsuarioRol;
	private Integer porDefecto;
    private Rol rol;
    private Usuario usuario;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuarioRol")
    public Long getIdUsuarioRol() {
        return IdUsuarioRol;
    }

    public void setIdUsuarioRol(Long idUsuarioRol) {
        IdUsuarioRol = idUsuarioRol;
    }
    @ManyToOne
    @JoinColumn(name="IdRol")
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    @ManyToOne
    @JoinColumn(name="IdUsuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public Integer getPorDefecto() {
		return porDefecto;
	}

	public void setPorDefecto(Integer porDefecto) {
		this.porDefecto = porDefecto;
	}
    
    
}
