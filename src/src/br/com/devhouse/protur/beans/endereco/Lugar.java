package br.com.devhouse.protur.beans.endereco;

public class Lugar {
	private Cidade cidade;
	private Estado estado;
	private Pais pais;
	
	public Lugar(Cidade cidade, Estado estado, Pais pais){
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public Pais getPais() {
		return pais;
	}

	@Override
	public String toString() {
		return "Lugar [cidade=" + cidade + ", estado=" + estado + ", pais="
				+ pais + "]";
	}
	
}
