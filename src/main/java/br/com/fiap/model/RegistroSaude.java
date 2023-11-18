package br.com.fiap.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "registros_saude")
public class RegistroSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	private Double pressaoArterial;

	private Integer batimentosCardiacos;

	private Double nivelGlicose;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_registro")
	private Date dataRegistro;

	public RegistroSaude(Usuario usuario, Double pressaoArterial, Integer batimentosCardiacos, Double nivelGlicose,
			Date dataRegistro) {
		super();
		this.usuario = usuario;
		this.pressaoArterial = pressaoArterial;
		this.batimentosCardiacos = batimentosCardiacos;
		this.nivelGlicose = nivelGlicose;
		this.dataRegistro = dataRegistro;
	}

	public RegistroSaude() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getPressaoArterial() {
		return pressaoArterial;
	}

	public void setPressaoArterial(Double pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

	public Integer getBatimentosCardiacos() {
		return batimentosCardiacos;
	}

	public void setBatimentosCardiacos(Integer batimentosCardiacos) {
		this.batimentosCardiacos = batimentosCardiacos;
	}

	public Double getNivelGlicose() {
		return nivelGlicose;
	}

	public void setNivelGlicose(Double nivelGlicose) {
		this.nivelGlicose = nivelGlicose;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
