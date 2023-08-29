package com.nasa.prueba.aspirante.dominio.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pruebaentity", catalog = "nasatest", schema = "public")
public class PruebaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_search", nullable = false)
    private Integer idSearch;
	@Basic(optional = false)
    @Column(name = "href", nullable = false, length = 1000)
	private String href;
	@Basic(optional = false)
    @Column(name = "center", nullable = false, length = 25)
	private String center;
	@Basic(optional = false)
    @Column(name = "titulo", nullable = false, length = 70)
	private String titulo;
	@Basic(optional = false)
    @Column(name = "nasa_id", nullable = false, length = 70)
	private String nasaId;
	@Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
	
	public Integer getIdSearch() {
		return idSearch;
	}
	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNasaId() {
		return nasaId;
	}
	public void setNasaId(String nasaId) {
		this.nasaId = nasaId;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
