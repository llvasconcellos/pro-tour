package br.com.devhouse.protur.beans.reservas;

import java.util.Date;

import br.com.devhouse.protur.beans.pessoa.Pessoa;

public abstract class Reserva {
	
	private Pessoa pessoa;
	private int numReserva;
	private String nomeEmpresa;
	private String emailContato;
	private Date dataHoraInicial;
	private Date dataHoraFinal;
	private float preco;
	
	/**
	 * Status da Reserva:
	 * 1 - a confirmar
	 * 2 - confirmada
	 * 3 - cancelada 
	 */
	private int status;

	public Reserva(Pessoa pessoa, int numReserva, String nomeEmpresa,
			String emailContato, Date dataHoraInicial, Date dataHoraFinal,
			int status, float preco) {
		this.pessoa = pessoa;
		this.numReserva = numReserva;
		this.nomeEmpresa = nomeEmpresa;
		this.emailContato = emailContato;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
		this.status = status;
		this.preco = preco;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getNumReserva() {
		return this.numReserva;
	}

	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}

	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEmailContato() {
		return this.emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public Date getDataHoraInicial() {
		return this.dataHoraInicial;
	}

	public void setDataHoraInicial(Date dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	public Date getDataHoraFinal() {
		return this.dataHoraFinal;
	}

	public void setDataHoraFinal(Date dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public float getPreco(){
		return this.preco;
	}
	
	public void setPreco(float preco){
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Reserva [pessoa=" + pessoa + ", numReserva=" + numReserva
				+ ", nomeEmpresa=" + nomeEmpresa + ", emailContato="
				+ emailContato + ", dataHoraInicial=" + dataHoraInicial
				+ ", dataHoraFinal=" + dataHoraFinal + ", preco=" + preco
				+ ", status=" + status + "]";
	}

}
