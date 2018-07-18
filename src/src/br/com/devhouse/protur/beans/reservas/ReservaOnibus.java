package br.com.devhouse.protur.beans.reservas;

import java.util.Date;

import br.com.devhouse.protur.beans.endereco.Lugar;
import br.com.devhouse.protur.beans.pessoa.Pessoa;

public class ReservaOnibus extends Reserva{
	
	private String assento;
	private Lugar origem;
	private Lugar destino;
	private String terminalOrigem;
	private String terminalDestino;
	

	public ReservaOnibus(Pessoa pessoa, int numReserva, String nomeEmpresa,
			String emailContato, Date dataHoraInicial, Date dataHoraFinal,
			Lugar origem, Lugar destino, int status, float preco, 
			String terminalOrigem, String terminalDestino, String assento) {

		super(pessoa, numReserva, nomeEmpresa, emailContato, dataHoraInicial,
				dataHoraFinal, status, preco);
		
		this.origem = origem;
		this.destino = destino;
		this.terminalOrigem = terminalOrigem;
		this.terminalDestino = terminalDestino;
		this.assento = assento;
	}


	public Lugar getOrigem() {
		return origem;
	}


	public void setOrigem(Lugar origem) {
		this.origem = origem;
	}


	public Lugar getDestino() {
		return destino;
	}


	public void setDestino(Lugar destino) {
		this.destino = destino;
	}


	public String getAssento() {
		return assento;
	}


	public void setAssento(String assento) {
		this.assento = assento;
	}


	public String getTerminalOrigem() {
		return terminalOrigem;
	}


	public void setTerminalOrigem(String terminalOrigem) {
		this.terminalOrigem = terminalOrigem;
	}


	public String getTerminalDestino() {
		return terminalDestino;
	}


	public void setTerminalDestino(String terminalDestino) {
		this.terminalDestino = terminalDestino;
	}

	@Override
	public String toString() {
		return super.toString() + " - ReservaOnibus [assento=" + assento + ", origem=" + origem
				+ ", destino=" + destino + ", terminalOrigem=" + terminalOrigem
				+ ", terminalDestino=" + terminalDestino + "]";
	}
	
}
