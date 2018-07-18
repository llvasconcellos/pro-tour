package br.com.devhouse.protur.ui.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import ui.util.layouts.ParagraphLayout;

public class frmReservaTrem extends JFrame implements Observer {
	
	private JPanel jpnControle, jpnEstacao, jpnBotao;// painel que servira de container para os outros componentes da tela
	private JLabel lblNumero, lblEmpresa, lblEmail, lblDataIni, lblDataFim,
			lblHoraIni, lblHoraFim, lblOrigem, lblDestino, lblStatus,
			lblIntegrantes, lblTremOrigem, lblTremDestino, lblAssento;
	private JTextField txtNumero, txtEmpresa, txtEmail, txtOrigem, txtDestino,
			txtIntegrantes, txtTremOrigem, txtTremDestino, txtAssento;
	private JFormattedTextField txtDataIni, txtDataFim, txtHoraIni, txtHoraFim;
	private MaskFormatter mascaraData, mascaraHora;
	private JRadioButton jrbConfirmado, jrbAConfirmar, jrbCancelado;
	private JButton btnIncluir, btnConsultar, btnExcluir, btnSalvar,
			btnCancelar, btnConfirmar;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public int getNumero(){
		try {
			return Integer.parseInt(txtNumero.getText());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public String getEmpresa(){
		return txtEmpresa.getText();
	}
	
	public String getEmal(){
		return txtEmail.getText();
	}
	
	public String getOrigem(){
		return txtOrigem.getText();
	}
	
	public String getDestino(){
		return txtDestino.getText();
	}
	
	public int getIntegrantes(){
		try {
			return Integer.parseInt(txtIntegrantes.getText());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public String getTremOrigem(){
		return txtTremOrigem.getText();
	}
	
	public String getTremDestino(){
		return txtTremDestino.getText();
	}
	
	public int getAssento(){
		try {
			return Integer.parseInt(txtAssento.getText());
		} catch (Exception e) {
			return 0;
		}
	}
	
    public Date getDataIni(){
    	try {
    		return sdf.parse(txtDataIni.getText()); //Conversao da data
		} catch (Exception e) {
			return null;
		}
    }
    
    public Date getDataFim(){
    	try {
    		return sdf.parse(txtDataFim.getText()); //Conversao da data
		} catch (Exception e) {
			return null;
		}
    }
	
	public String getHoraIni(){
		return txtHoraIni.getText();
	}
	
	public String getHoraFim(){
		return txtHoraFim.getText();
	}

	public String getStatus(){
		if (jrbConfirmado.isSelected()){
            return "C";
        }else{
        	if (jrbAConfirmar.isSelected()){
        		return "A";
        	}else{
        		return "R";
        	}
        }
	}

	public frmReservaTrem() {
		
		setSize(600, 410);// tamanho tela
		setTitle("Reserva Trem");// titulo tela
		setResizable(false);// Retira o redimencionamento da tela

		// modelCadCargo = new modelCadCargo();
		// modelCadCargo.addObserver(this);

		criaControle();
		criaBotao();

		setVisible(true);// exibe tela
	}
	
	private void criaControle() {
		jpnControle = new JPanel(new ParagraphLayout());//componente painel criado//Paragraph define layout que o painel utiliza
		add("North", jpnControle);// adiçao do componente no centro da tela

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
		txtNumero.setEnabled(false);
		jpnControle.add(txtNumero);

		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setForeground(Color.blue);
		jpnControle.add(lblEmpresa, ParagraphLayout.NEW_PARAGRAPH);
		txtEmpresa = new JTextField(30);
		txtEmpresa.setEnabled(false);
		jpnControle.add(txtEmpresa);

		lblEmail = new JLabel("Email:");
		jpnControle.add(lblEmail, ParagraphLayout.NEW_PARAGRAPH);
		txtEmail = new JTextField(30);
		txtEmail.setEnabled(false);
		jpnControle.add(txtEmail);

		lblDataIni = new JLabel("Data inicial:");
		lblDataIni.setForeground(Color.blue);
		jpnControle.add(lblDataIni, ParagraphLayout.NEW_PARAGRAPH);
		txtDataIni = new JFormattedTextField(mascaraData);
		txtDataIni.setEnabled(false);
		txtDataIni.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtDataIni);

		lblDataFim = new JLabel("Data Final:");
		// lblDataFim.setForeground(Color.blue);
		jpnControle.add(lblDataFim);
		txtDataFim = new JFormattedTextField(mascaraData);
		txtDataFim.setEnabled(false);
		txtDataFim.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtDataFim);

		lblHoraIni = new JLabel("Hora Inicial:");
		lblHoraIni.setForeground(Color.blue);
		jpnControle.add(lblHoraIni, ParagraphLayout.NEW_PARAGRAPH);
		txtHoraIni = new JFormattedTextField(mascaraHora);
		txtHoraIni.setEnabled(false);
		txtHoraIni.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtHoraIni);

		lblHoraFim = new JLabel("Hora Final:");
		jpnControle.add(lblHoraFim);
		txtHoraFim = new JFormattedTextField(mascaraHora);
		txtHoraFim.setEnabled(false);
		txtHoraFim.setPreferredSize(new Dimension(100, 20));
		jpnControle.add(txtHoraFim);

		lblOrigem = new JLabel("Origem:");
		lblOrigem.setForeground(Color.blue);
		jpnControle.add(lblOrigem, ParagraphLayout.NEW_PARAGRAPH);
		txtOrigem = new JTextField(30);
		txtOrigem.setEnabled(false);
		jpnControle.add(txtOrigem);

		lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(Color.blue);
		jpnControle.add(lblDestino, ParagraphLayout.NEW_PARAGRAPH);
		txtDestino = new JTextField(30);
		txtDestino.setEnabled(false);
		jpnControle.add(txtDestino);

		lblStatus = new JLabel("Status:");
		jpnControle.add(lblStatus, ParagraphLayout.NEW_PARAGRAPH);
		ButtonGroup status = new ButtonGroup(); //Criacao do grupo do componente dos radiobutton
        jrbConfirmado = new JRadioButton("Confirmado"); //Criacao do radioButton
        jrbAConfirmar = new JRadioButton("A Confirmar");
        jrbCancelado = new JRadioButton("Cancelado");
        status.add(jrbConfirmado); //Adicao do radioButton ao grupo de componentes
        status.add(jrbAConfirmar);
        status.add(jrbCancelado);
        jrbConfirmado.setEnabled(false);
        jpnControle.add(jrbConfirmado);
        jrbAConfirmar.setEnabled(false);
        jpnControle.add(jrbAConfirmar);
        jrbCancelado.setEnabled(false);
        jpnControle.add(jrbCancelado);
		
        jpnEstacao = new JPanel(new ParagraphLayout());
        jpnEstacao.setBorder(BorderFactory.createTitledBorder("Estacao"));
		add("Center", jpnEstacao);

		lblTremOrigem = new JLabel("Origem:");
		lblTremOrigem.setForeground(Color.blue);
		jpnEstacao.add(lblTremOrigem, ParagraphLayout.NEW_PARAGRAPH);
		txtTremOrigem = new JTextField(20);
		txtTremOrigem.setEnabled(false);
		jpnEstacao.add(txtTremOrigem);
		
		lblTremDestino = new JLabel("Destino:");
		lblTremDestino.setForeground(Color.blue);
		jpnEstacao.add(lblTremDestino, ParagraphLayout.NEW_PARAGRAPH);
		txtTremDestino = new JTextField(20);
		txtTremDestino.setEnabled(false);
		jpnEstacao.add(txtTremDestino);
		
		lblAssento = new JLabel("Assento:");
		lblAssento.setForeground(Color.blue);
		jpnEstacao.add(lblAssento, ParagraphLayout.NEW_PARAGRAPH);
		txtAssento = new JTextField(5);
		txtAssento.setEnabled(false);
		jpnEstacao.add(txtAssento);
		
		lblIntegrantes = new JLabel("Integrantes:");
        lblIntegrantes.setForeground(Color.blue);
		jpnControle.add(lblIntegrantes, ParagraphLayout.NEW_PARAGRAPH);
		txtIntegrantes = new JTextField(5);
		txtIntegrantes.setEnabled(false);
		jpnControle.add(txtIntegrantes);
	}

	private void criaBotao() {// botoes da tela
		jpnBotao = new JPanel();
		add("South", jpnBotao);

		btnIncluir = new JButton("Incluir");
		btnIncluir.setName("btnIncluir");// Nome do botao para o actionPerformand
		//btnIncluir.addActionListener(ctrCliente); // Infoma quem efetuara a acao do componente
		jpnBotao.add(btnIncluir);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setName("btnConsultar");
		//btnConsultar.addActionListener(ctrCliente);
		jpnBotao.add(btnConsultar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setName("btnExcluir");
		//btnExcluir.addActionListener(ctrCliente);
		jpnBotao.add(btnExcluir);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setVisible(false);
		btnSalvar.setName("btnSalvar");
		//btnSalvar.addActionListener(ctrCliente);
		jpnBotao.add(btnSalvar);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setVisible(false);
		btnConfirmar.setName("btnConfirmar");
		//btnConfirmar.addActionListener(ctrCliente);
		jpnBotao.add(btnConfirmar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.setName("btnCancelar");
		//btnCancelar.addActionListener(ctrCliente);
		jpnBotao.add(btnCancelar);
	}
	
	public void LimparTela() {
		txtNumero.setText("");
		txtEmpresa.setText("");
		txtEmail.setText("");
		txtDataIni.setText("");
		txtDataFim.setText("");
		txtHoraIni.setText("");
		txtHoraFim.setText("");
		txtTremOrigem.setText("");
		txtTremDestino.setText("");
		jrbAConfirmar.setSelected(false);
		jrbCancelado.setSelected(false);
		jrbConfirmado.setSelected(false);
		txtAssento.setText("");
		txtIntegrantes.setText("");
	}

	public void DesabilitaBotoes(String funcao) {
		btnIncluir.setEnabled(false);
		btnConsultar.setEnabled(false);
		btnExcluir.setEnabled(false);
		if (funcao.equalsIgnoreCase("INCLUIR")){
			btnSalvar.setVisible(true);
		}else{
			btnConfirmar.setVisible(true);
		}
		btnCancelar.setVisible(true);
	}
	
	public void HabilitaBotoes() {
		btnIncluir.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnSalvar.setVisible(false);
		btnConfirmar.setVisible(false);
		btnCancelar.setVisible(false);
	}

	public void HabilitaCampos() {
		txtNumero.setEnabled(true);
		txtEmpresa.setEnabled(true);
		txtEmail.setEnabled(true);
		txtDataIni.setEnabled(true);
		txtDataFim.setEnabled(true);
		txtHoraIni.setEnabled(true);
		txtHoraFim.setEnabled(true);
		txtTremOrigem.setEnabled(true);
		txtTremDestino.setEnabled(true);
		jrbAConfirmar.setEnabled(true);
		jrbCancelado.setEnabled(true);
		jrbConfirmado.setEnabled(true);
		txtAssento.setEnabled(true);
		txtIntegrantes.setEnabled(true);
	}
	
	public void DesabilitaCampos() {
		txtNumero.setEnabled(false);
		txtEmpresa.setEnabled(false);
		txtEmail.setEnabled(false);
		txtDataIni.setEnabled(false);
		txtDataFim.setEnabled(false);
		txtHoraIni.setEnabled(false);
		txtHoraFim.setEnabled(false);
		txtTremOrigem.setEnabled(false);
		txtTremDestino.setEnabled(false);
		jrbAConfirmar.setEnabled(false);
		jrbCancelado.setEnabled(false);
		jrbConfirmado.setEnabled(false);
		txtAssento.setEnabled(false);
		txtIntegrantes.setEnabled(false);
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
						if (campo.equalsIgnoreCase("origem")){
							txtOrigem.requestFocus();
						}else{
							if (campo.equalsIgnoreCase("destino")){
								txtDestino.requestFocus();
							}else{
								if (campo.equalsIgnoreCase("integrantes")){
									txtIntegrantes.requestFocus();
								}else{
									if (campo.equalsIgnoreCase("aeroOrigem")){
										txtTremOrigem.requestFocus();
									}else{
										if (campo.equalsIgnoreCase("aeroDestino")){
											txtTremDestino.requestFocus();
										}else{
											if (campo.equalsIgnoreCase("assento")){
												txtAssento.requestFocus();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
