package br.com.devhouse.protur.beans.reservas;

import java.util.Date;

import br.com.devhouse.protur.beans.endereco.Endereco;
import br.com.devhouse.protur.beans.pessoa.Pessoa;

public class ReservaHotel extends Reserva{
	
	private Endereco endereco;
	private int numeroAcomodacoes;

	public ReservaHotel(Pessoa pessoa, int numReserva, String nomeEmpresa,
			String emailContato, Date dataHoraInicial, Date dataHoraFinal,
			Endereco endereco, int status, float preco, int numeroAcomodacoes) {
		
		super(pessoa, numReserva, nomeEmpresa, emailContato, dataHoraInicial,
				dataHoraFinal, status, preco);
		
		this.endereco = endereco;
		this.numeroAcomodacoes = numeroAcomodacoes;		
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getNumeroAcomodacoes() {
		return numeroAcomodacoes;
	}

	public void setNumeroAcomodacoes(int numeroAcomodacoes) {
		this.numeroAcomodacoes = numeroAcomodacoes;
	}

	@Override
	public String toString() {
		return super.toString() + " - ReservaHotel [endereco=" + endereco + ", numeroAcomodacoes="
				+ numeroAcomodacoes + "]";
	}
	
	

}