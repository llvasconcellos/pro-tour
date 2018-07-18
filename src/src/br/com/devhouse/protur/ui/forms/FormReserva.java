package br.com.devhouse.protur.ui.forms;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.devhouse.protur.beans.reservas.Reserva;

@SuppressWarnings("serial")
public class FormReserva extends JFrame {
	
	private Reserva reserva;
	
	/**
	 * Status da Reserva:
	 * 1 - a confirmar
	 * 2 - confirmada
	 * 3 - cancelada 
	 */
	
	/*
	 * Comuns para todas as reservas ===================================================
	 */
	
	private JLabel lblPessoa;
	private JComboBox jcbPessoa;
	
	private JLabel lblNumReserva;
	private JTextField txtNumReserva;
	
	private JLabel lblNomeEmpresa;
	private JTextField txtNomeEmpresa;
	
	private JLabel lblEmailContato;
	private JTextField txtEmailContato;
	
	private JLabel lblDataHoraInicial;
	private JTextField txtDataHoraInicial;

	private JLabel lblPreco;
	private JTextField txtPreco;
	
	private JLabel lblStatus;
	private JTextField txtStatus;
	
	/*
	 * Reserva Aérea ===================================================================
	 */
	
	private JLabel lblAeroportoOrigem;
	private JTextField txtAeroportoOrigem;
	
	private JLabel lblAeroportoDestino;
	private JTextField txtAeroportoDestino;
	
	/*
	 * Reserva Trem ===================================================================
	 */
	
	private JLabel lblEstacaoOrigem;
	private JTextField txtEstacaoOrigem;
	
	private JLabel lblEestacaoDestino;
	private JTextField txtEstacaoDestino;
	
	/*
	 * Reserva Onibus ===================================================================
	 */
	
	private JLabel lblTerminalOrigem;
	private JTextField txtTerminalOrigem;
	
	private JLabel lblTerminalDestino;
	private JTextField txtTerminalDestino;
		
	
	/*
	 * Comuns para Aérea, Ônibus e Trem ===============================================
	 */
	private JLabel lblAssento;
	private JTextField txtAssento;	
	
	private JLabel lblPais;
	private JComboBox jcbPais;
	
	private JLabel lblEstado;
	private JComboBox jcbEstado;
	
	private JLabel lblCidade;
	private JComboBox jcbCidade;
	
	
	/*
	 * Reserva Hotel===================================================================
	 */

	private JLabel lblNumeroAcomodacoes;
	private JTextField txtNumeroAcomodacoes;
	
	private JLabel lblEndereco;
	private JTextField txtEndereco;
	
	private JLabel lblNumEndereco;
	private JTextField txtNumEndereco;
	
	private JLabel lblBairro;
	private JTextField txtBairro;
	
	
	public FormReserva(Reserva r, String tipoReserva){
		setSize(600, 400);
		setTitle("Reservas");
		setResizable(false);
				
		setVisible(true);
		if(r != null){
			//this.setReserva(r);
		}
		
	}
	
}
