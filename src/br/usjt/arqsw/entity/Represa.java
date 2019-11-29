package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Represa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "volumeUtil")
	private Double volumeUtil;
	
	@Column(name = "sistemaPertencente")
	private String sistemaPertencente;

	@Column(name = "volumeReservaTecnica")
	private Double volumeReservaTecnica;

	@Column(name = "volumeArmazenado")
	private Double volumeArmazenado;

	@Column(name = "pluviometriaDiaAnterior")
	private Double pluviometriaDiaAnterior;

	@Column(name="volumeTotal")
	private Double volumeTotal;
	
	@Column(name="dataAbertura")
	private String dataAbertura;

	private Double calcIndice1;
	private Double calcIndice2;
	private Double calcIndice3;
	
	public Represa() {
	}

	public Represa(int id, String nome, Double volumeUtil, String sistemaPertencente, Double volumeReservaTecnica,
			Double volumeArmazenado, Double pluviometriaDiaAnterior, Double volumeTotal, String dataAbertura, 
			Double calcIndice1, Double calcIndice2, Double calcIndice3) {
		super();
		this.id = id;
		this.nome = nome;
		this.volumeUtil = volumeUtil;
		this.sistemaPertencente = sistemaPertencente;
		this.volumeReservaTecnica = volumeReservaTecnica;
		this.volumeArmazenado = volumeArmazenado;
		this.pluviometriaDiaAnterior = pluviometriaDiaAnterior;
		this.volumeTotal = volumeTotal;
		this.dataAbertura = dataAbertura;
		this.calcIndice1 = calcIndice1;
		this.calcIndice2 = calcIndice2;
		this.calcIndice3 = calcIndice3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSistemaPertencente() {
		return sistemaPertencente;
	}

	public void setSistemaPertencente(String sistemaPertencente) {
		this.sistemaPertencente = sistemaPertencente;
	}

	public Double getVolumeUtil() {
		return volumeUtil;
	}

	public void setVolumeUtil(Double volumeUtil) {
		this.volumeUtil = volumeUtil;
	}

	public Double getVolumeReservaTecnica() {
		return volumeReservaTecnica;
	}

	public void setVolumeReservaTecnica(Double volumeReservaTecnica) {
		this.volumeReservaTecnica = volumeReservaTecnica;
	}

	public Double getVolumeArmazenado() {
		return volumeArmazenado;
	}

	public void setVolumeArmazenado(Double volumeArmazenado) {
		this.volumeArmazenado = volumeArmazenado;
	}

	public Double getPluviometriaDiaAnterior() {
		return pluviometriaDiaAnterior;
	}

	public void setPluviometriaDiaAnterior(Double pluviometriaDiaAnterior) {
		this.pluviometriaDiaAnterior = pluviometriaDiaAnterior;
	}

	public Double getVolumeTotal() {
		return volumeTotal;
	}
	
	public void setVolumeTotal(Double volumeTotal) {
		this.volumeTotal = volumeTotal;
	}
	
	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Double getCalcIndice1() {
		return calcIndice1;
	}

	public void setCalcIndice1(Double calcIndice1) {
		this.calcIndice1 = calcIndice1;
	}

	public Double getCalcIndice2() {
		return calcIndice2;
	}

	public void setCalcIndice2(Double calcIndice2) {
		this.calcIndice2 = calcIndice2;
	}

	public Double getCalcIndice3() {
		return calcIndice3;
	}

	public void setCalcIndice3(Double calcIndice3) {
		this.calcIndice3 = calcIndice3;
	}
}
