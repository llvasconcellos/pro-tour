package br.com.devhouse.protur.beans.endereco;

public class Endereco {
	
	private String rua;
	private String numero;
	private String bairro;
	private Cidade cidade;
	private Estado estado;
	private Pais pais;
	
	public Endereco(String rua, String numero, String bairro, Cidade cidade,
			Estado estado, Pais pais) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", bairro="
				+ bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", pais=" + pais + "]";
	}
	
	
}