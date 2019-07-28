package gob.ec.siscan.domain.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import gob.ec.siscan.domain.model.base.AuditingEntity;

@Entity
@Table(name = "TimeClock")
public class TimeClock extends AuditingEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6824715802964954829L;
	private Long id_time_clock;
    private LocalDateTime horaentrada;
    private LocalDateTime horasalida;
    private Long totalhoras;
    private Usuario usuario;
   
    public TimeClock(Usuario usuario) {
    	
         clockin();
         clockout();
         this.usuario=usuario;
        
	}
	
    
	public void clockin() {
        this.horaentrada = LocalDateTime.now();
    }

    public void clockout() {
        this.horasalida = LocalDateTime.now();
        this.totalhoras = Duration.between(this.horaentrada, this.horasalida).toHours();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_time_clock")
	public Long getId_time_clock() {
		return id_time_clock;
	}
	public void setId_time_clock(Long id_time_clock) {
		this.id_time_clock = id_time_clock;
	}
	
	@ManyToOne()
	@JoinColumn(name = "IdUsuario")
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Column(name = "horaentrada")
	public LocalDateTime getHoraentrada() {
		return horaentrada;
	}
	public void setHoraentrada(LocalDateTime horaentrada) {
		this.horaentrada = horaentrada;
	}
	 @Column(name = "horasalida")
	public LocalDateTime getHorasalida() {
		return horasalida;
	}
	public void setHorasalida(LocalDateTime horasalida) {
		this.horasalida = horasalida;
	}
	
	
	 @Column(name = "totalhoras")
	public Long getTotalhoras() {
		return totalhoras;
	}
	
	public void setTotalhoras(Long totalhoras) {
		this.totalhoras = totalhoras;
	}
	
   

}
