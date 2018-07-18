package br.com.devhouse.protur.beans.pessoa;

import br.com.devhouse.protur.beans.documentos.TipoDocumento;
import br.com.devhouse.protur.beans.endereco.Endereco;

public class Cliente extends Pessoa {

	private String cpf;
	private String telefone;
	private String email;
	private Endereco endereco;

	public Cliente(String nome, String sobrenome, String cpf, String telefone, String email, Endereco endereco) {
		super(nome, sobrenome, TipoDocumento.CPF, cpf);
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", telefone=" + telefone + ", email="
				+ email + ", endereco=" + endereco + "]";
	}
	
}
