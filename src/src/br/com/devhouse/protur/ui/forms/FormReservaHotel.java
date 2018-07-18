package br.com.devhouse.protur.ui.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.devhouse.protur.beans.endereco.Cidade;
import br.com.devhouse.protur.beans.endereco.Endereco;
import br.com.devhouse.protur.beans.endereco.Estado;
import br.com.devhouse.protur.beans.endereco.Pais;
import br.com.devhouse.protur.beans.pessoa.Cliente;
import br.com.devhouse.protur.beans.pessoa.Pessoa;
import br.com.devhouse.protur.beans.reservas.ReservaHotel;
import br.com.devhouse.protur.sistema.Sistema;

import ui.util.layouts.ParagraphLayout;

@SuppressWarnings("serial")
public class FormReservaHotel extends JFrame {
	
	private ReservaHotel reserva;
	
	private JPanel jpnControle;
	private JPanel jpnBotao;
	
	private JLabel lblNumero;
	private JLabel lblEmpresa;
	private JLabel lblEmail;
	private JLabel lblDataIni;
	private JLabel lblDataFim;
	private JLabel lblHoraIni;
	private JLabel lblHoraFim;
	private JLabel lblStatus;
	private JLabel lblIntegrantes;
	private JLabel lblRua;
	private JLabel lblNumRua;
	private JLabel lblBairro;
	private JLabel lblCidade;
	
	private JTextField txtNumero;
	private JTextField txtEmpresa;
	private JTextField txtEmail;
	private JTextField txtIntegrantes;
	private JTextField txtRua;
	private JTextField txtNumRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	
	private JFormattedTextField txtDataIni;
	private JFormattedTextField txtDataFim;
	private JFormattedTextField txtHoraIni;
	private JFormattedTextField txtHoraFim;
	
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraHora;
	
	private JRadioButton jrbConfirmado;
	private JRadioButton jrbAConfirmar;
	private JRadioButton jrbCancelado;
	
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	public FormReservaHotel(ReservaHotel r) {
		
		setSize(600, 400);// tamanho tela
		setTitle("Reserva Acomodacao");// titulo tela
		setResizable(false);// Retira o redimencionamento da tela
		setDefaultCloseOperation(EXIT_ON_CLOSE);//para o java

		criaControle();
		criaBotao();

		setVisible(true);// exibe tela
		
		if(r != null){
			this.reserva = r;
		}
	}
	
	private void criaControle() {
		jpnControle = new JPanel(new ParagraphLayout());//componente painel criado//Paragraph define layout que o painel utiliza
		add("Center", jpnControle);// adiçao do componente no centro da tela

		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraHora = new MaskFormatter("##:##");
		} catch (Exception e) {
			e.printStackTrace();// print do erro no console
		}

		lblNumero = new JLabel("Número:");
		lblNumero.setForeground(Color.blue);
		jpnControle.add(lblNumero, ParagraphLayout.NEW_PARAGRAPH);
		txtNumero = new JTextField(5);
		jpnControle.add(txtNumero);

		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setForeground(Color.blue);
		jpnControle.add(lblEmpresa, ParagraphLayout.NEW_PARAGRAPH);
		txtEmpresa = new JTextField(30);
		jpnControle.add(txtEmpresa);
		
		lblRua = new JLabel("Rua:");
		lblRua.setForeground(Color.blue);
		jpnControle.add(lblRua, ParagraphLayout.NEW_PARAGRAPH);
		txtRua = new JTextField(30);
		jpnControle.add(txtRua);
		
		lblNumRua = new JLabel("Num.:");
		lblNumero.setForeground(Color.blue);
		jpnControle.add(lblNumRua, ParagraphLayout.NEW_PARAGRAPH);
		txtNumRua = new JTextField(5);
		jpnControle.add(txtNumRua);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.blue);
		jpnControle.add(lblBairro, ParagraphLayout.NEW_PARAGRAPH);
		txtBairro = new JTextField(15);
		jpnControle.add(txtBairro);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.blue);
		jpnControle.add(lblCidade, ParagraphLayout.NEW_PARAGRAPH);
		txtCidade = new JTextField(20);
		jpnControle.add(txtCidade);

		lblEmail = new JLabel("Email:");
		jpnControle.add(lblEmail, ParagraphLayout.NEW_PARAGRAPH);
		txtEmail = new JTextField(30);
		jpnControle.add(txtEmail);

		lblDataIni = new JLabel("Data inicial:");
		lblDataIni.setForeground(Color.blue);
		jpnControle.add(lblDataIni, ParagraphLayout.NEW_PARAGRAPH);
		txtDataIni = new JFormattedTextField(mascaraData);
		txtDataIni.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtDataIni);

		lblDataFim = new JLabel("Data Final:");
		// lblDataFim.setForeground(Color.blue);
		jpnControle.add(lblDataFim);
		txtDataFim = new JFormattedTextField(mascaraData);
		txtDataFim.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtDataFim);

		lblHoraIni = new JLabel("Hora Inicial:");
		lblHoraIni.setForeground(Color.blue);
		jpnControle.add(lblHoraIni, ParagraphLayout.NEW_PARAGRAPH);
		txtHoraIni = new JFormattedTextField(mascaraHora);
		txtHoraIni.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtHoraIni);

		lblHoraFim = new JLabel("Hora Final:");
		jpnControle.add(lblHoraFim);
		txtHoraFim = new JFormattedTextField(mascaraHora);
		txtHoraFim.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtHoraFim);

		lblStatus = new JLabel("Status:");
		jpnControle.add(lblStatus, ParagraphLayout.NEW_PARAGRAPH);
		ButtonGroup status = new ButtonGroup(); //Criacao do grupo do componente dos radiobutton
        jrbConfirmado = new JRadioButton("Confirmado"); //Criacao do radioButton
        jrbAConfirmar = new JRadioButton("A Confirmar");
        jrbCancelado = new JRadioButton("Cancelado");
        status.add(jrbConfirmado); //Adicao do radioButton ao grupo de componentes
        status.add(jrbAConfirmar);
        status.add(jrbCancelado);
        jpnControle.add(jrbConfirmado);
        jpnControle.add(jrbAConfirmar);
        jpnControle.add(jrbCancelado);
        
        lblIntegrantes = new JLabel("Integrantes:");
        lblIntegrantes.setForeground(Color.blue);
		jpnControle.add(lblIntegrantes, ParagraphLayout.NEW_PARAGRAPH);
		txtIntegrantes = new JTextField(5);
		jpnControle.add(txtIntegrantes);
	}

	private void criaBotao() {// botoes da tela
		jpnBotao = new JPanel();
		add("South", jpnBotao);	

		btnSalvar = new JButton("Salvar");
		btnSalvar.setName("btnSalvar");
		btnSalvar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Sistema.salvaCliente(getReserva());
				LimparTela();
			}
		});
		jpnBotao.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setName("btnExcluir");
		btnExcluir.setVisible(false);
		//btnExcluir.addActionListener(ctrReservaAcomodacao);
		jpnBotao.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setName("btnCancelar");
		btnCancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jpnBotao.add(btnCancelar);
	}
	
	public void LimparTela() {
		txtNumero.setText("");
		txtEmpresa.setText("");
		txtRua.setText("");
		txtNumRua.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtEmail.setText("");
		txtDataIni.setText("");
		txtDataFim.setText("");
		txtHoraIni.setText("");
		txtHoraFim.setText("");
		jrbAConfirmar.setSelected(false);
		jrbCancelado.setSelected(false);
		jrbConfirmado.setSelected(false);
		txtIntegrantes.setText("");
	}

	public void setFoco(String campo) {
		if (campo.equalsIgnoreCase("numero")){
			txtNumero.requestFocus();
		}else{
			if (campo.equalsIgnoreCase("empresa")){
				txtEmpresa.requestFocus();
			}else{
				if (campo.equalsIgnoreCase("data")){
					txtDataIni.requestFocus();
				}else{
					if (campo.equalsIgnoreCase("hora")){
						txtHoraIni.requestFocus();
					}else{
						if (campo.equalsIgnoreCase("rua")){
							txtRua.requestFocus();
						}else{
							if (campo.equalsIgnoreCase("bairro")){
								txtBairro.requestFocus();
							}else{
								if (campo.equalsIgnoreCase("integrantes")){
									txtIntegrantes.requestFocus();
								}else{
									if (campo.equalsIgnoreCase("cidade")){
										txtCidade.requestFocus();
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public ReservaHotel getReserva(){
		
		return null;
		/*Pessoa pessoa, int numReserva, String nomeEmpresa,
		String emailContato, Date dataHoraInicial, Date dataHoraFinal,
		Endereco endereco, int status, float preco, int numeroAcomodacoes
		
		
		Cidade cidade = (Cidade) jcbCidade.getSelectedItem();
		Estado estado = (Estado) jcbEstado.getSelectedItem();
		Pais pais = (Pais) jcbPais.getSelectedItem();
		
		Endereco endereco = new Endereco(txtEndereco.getText(), txtNumEndereco.getText(), txtBairro.getText(), cidade, estado, pais);
		ReservaHotel r = new ReservaHotel(txtEndereco.getText(), txtNumEndereco.getText(), txtBairro.getText(), cidade, estado, pais);
		return r;*/
	}
}
