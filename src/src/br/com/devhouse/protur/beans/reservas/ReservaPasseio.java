package br.com.devhouse.protur.beans.reservas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.devhouse.protur.beans.endereco.Endereco;
import br.com.devhouse.protur.beans.pessoa.Pessoa;

public class ReservaPasseio extends Reserva{
	
	private int qtdMaxIntegrantes;
	private int numIntegrantes;
	private Endereco origem;
	private Endereco destino;
	private List<Pessoa> integrantes = new ArrayList<Pessoa>();
	
	public ReservaPasseio(Pessoa pessoa, int numReserva, String nomeEmpresa,
			String emailContato, Date dataHoraInicial, Date dataHoraFinal,
			int status, float preco, int qtdMaxIntegrantes, Endereco origem,
			Endereco destino) {
		
		super(pessoa, numReserva, nomeEmpresa, emailContato, dataHoraInicial,
				dataHoraFinal, status, preco);
		
		this.qtdMaxIntegrantes = qtdMaxIntegrantes;
		this.origem = origem;
		this.destino = destino;
		this.numIntegrantes = 0;
	}

	public int getQtdMaxIntegrantes() {
		return qtdMaxIntegrantes;
	}

	public void setQtdMaxIntegrantes(int qtdMaxIntegrantes) {
		this.qtdMaxIntegrantes = qtdMaxIntegrantes;
	}

	public Endereco getOrigem() {
		return origem;
	}

	public void setOrigem(Endereco origem) {
		this.origem = origem;
	}

	public Endereco getDestino() {
		return destino;
	}

	public void setDestino(Endereco destino) {
		this.destino = destino;
	}

	public List<Pessoa> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Pessoa> integrantes) {
		this.integrantes = integrantes;
		this.numIntegrantes = this.integrantes.size();
	}
	
	public void addIntegrante(Pessoa integrante){
		if(this.numIntegrantes < this.qtdMaxIntegrantes){
			this.integrantes.add(integrante);
			this.numIntegrantes++;
		}
	}
	
	public void removeIntegrante(Pessoa integrante){
		if(this.numIntegrantes > 0){
			this.integrantes.remove(integrante);
			this.numIntegrantes--;
		}
	}

	@Override
	public String toString() {
		return "ReservaPasseio [qtdMaxIntegrantes=" + qtdMaxIntegrantes
				+ ", origem=" + origem + ", destino=" + destino + "]";
	}
}

