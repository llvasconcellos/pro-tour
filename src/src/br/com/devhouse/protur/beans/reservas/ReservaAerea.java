package br.com.devhouse.protur.beans.reservas;

import java.util.Date;

import br.com.devhouse.protur.beans.endereco.Lugar;
import br.com.devhouse.protur.beans.pessoa.Pessoa;

public class ReservaAerea extends Reserva{
	
	private String assento;
	private Lugar origem;
	private Lugar destino;
	private String aeroportoOrigem;
	private String aeroportoDestino;
	

	public ReservaAerea(Pessoa pessoa, int numReserva, String nomeEmpresa,
			String emailContato, Date dataHoraInicial, Date dataHoraFinal,
			Lugar origem, Lugar destino, int status, float preco, 
			String aeroportoOrigem, String aeroportoDestino, String assento) {

		super(pessoa, numReserva, nomeEmpresa, emailContato, dataHoraInicial,
				dataHoraFinal, status, preco);
		
		this.origem = origem;
		this.destino = destino;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
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


	public String getAeroportoOrigem() {
		return aeroportoOrigem;
	}


	public void setAeroportoOrigem(String aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}


	public String getAeroportoDestino() {
		return aeroportoDestino;
	}


	public void setAeroportoDestino(String aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	@Override
	public String toString() {
		return super.toString() + " - ReservaAerea [assento=" + assento + ", origem=" + origem
				+ ", destino=" + destino + ", aeroportoOrigem="
				+ aeroportoOrigem + ", aeroportoDestino=" + aeroportoDestino
				+ "]";
	}

}
