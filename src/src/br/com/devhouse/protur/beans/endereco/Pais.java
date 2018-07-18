package br.com.devhouse.protur.beans.endereco;

public class Pais {
	private String codigo;
	private String nome;
	private String isoNumeric;
	private String isoAlpha;
	private String continente;
	private String moeda;
	private String geonameId;
	
	public Pais(String nome){
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIsoNumeric() {
		return isoNumeric;
	}
	
	public void setIsoNumeric(String isoNumeric) {
		this.isoNumeric = isoNumeric;
	}
	
	public String getIsoAlpha() {
		return isoAlpha;
	}
	
	public void setIsoAlpha(String isoAlpha) {
		this.isoAlpha = isoAlpha;
	}
	
	public String getContinente() {
		return continente;
	}
	
	public void setContinente(String continente) {
		this.continente = continente;
	}
	
	public String getMoeda() {
		return moeda;
	}
	
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	
	public String getGeonameId() {
		return geonameId;
	}
	
	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}