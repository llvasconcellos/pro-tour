package br.com.devhouse.protur.beans.reservas;

import java.util.Date;

import br.com.devhouse.protur.beans.endereco.Lugar;
import br.com.devhouse.protur.beans.pessoa.Pessoa;

public class ReservaTrem extends Reserva{
	
	private String assento;
	private Lugar origem;
	private Lugar destino;
	private String estacaoOrigem;
	private String estacaoDestino;
	

	public ReservaTrem(Pessoa pessoa, int numReserva, String nomeEmpresa,
			String emailContato, Date dataHoraInicial, Date dataHoraFinal,
			Lugar origem, Lugar destino, int status, float preco, 
			String estacaoOrigem, String estacaoDestino, String assento) {

		super(pessoa, numReserva, nomeEmpresa, emailContato, dataHoraInicial,
				dataHoraFinal, status, preco);
		
		this.origem = origem;
		this.destino = destino;
		this.estacaoOrigem = estacaoOrigem;
		this.estacaoDestino = estacaoDestino;
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


	public String getEstacaoOrigem() {
		return estacaoOrigem;
	}


	public void setEstacaoOrigem(String estacaoOrigem) {
		this.estacaoOrigem = estacaoOrigem;
	}


	public String getEstacaoDestino() {
		return estacaoDestino;
	}


	public void setEstacaoDestino(String estacaoDestino) {
		this.estacaoDestino = estacaoDestino;
	}

	@Override
	public String toString() {
		return super.toString() + " - ReservaTrem [assento=" + assento + ", origem=" + origem
				+ ", destino=" + destino + ", estacaoOrigem=" + estacaoOrigem
				+ ", estacaoDestino=" + estacaoDestino + "]";
	}
	
}
