package br.com.devhouse.protur.beans.pessoa;

public class Pessoa {
	
	private String nome;
	private String sobrenome;
	private String tipoDocumento;
	private String documento;

	public Pessoa(String nome, String sobrenome, String tipoDocumento,
			String documento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
