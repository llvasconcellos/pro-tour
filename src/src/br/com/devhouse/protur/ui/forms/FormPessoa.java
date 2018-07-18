package br.com.devhouse.protur.ui.forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.devhouse.protur.beans.pessoa.Pessoa;
import br.com.devhouse.protur.sistema.Sistema;

import ui.util.layouts.ParagraphLayout;

@SuppressWarnings("serial")
public class FormPessoa extends JFrame{
    
	private Pessoa pessoa;
	
	private JPanel jpnControle;
	private JPanel jpnBotao;
	
	private JLabel lblCliente;
	private JLabel lblSobrenome;
	private JLabel lblDocumento;
	private JLabel lblNumDocum;
	
	private JTextField txtCliente;
	private JTextField txtSobrenome;
	private JTextField txtNumDocum;

	private JComboBox jcbDocumento;
	
	private String documento[] = {"Selecione um documento","CPF", "RG", "CNH", "Certidão de Nascimento"}; 
	
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	
	public FormPessoa(Pessoa c) {
		setSize(500, 300);
		setTitle("Pessoas");
		setResizable(false);
		
		criaControle();
		criaBotao();
				
		setVisible(true);
		if(c != null){
			this.setPessoa(c);
		}
	}
	
	private void criaControle() {//campos que vao em tela
	   jpnControle = new JPanel(new ParagraphLayout());//componente painel criado//Paragraph define layout que o painel utiliza
	   add("Center", jpnControle);//adiçao do componente no centro da tela
	   
	   
	   lblCliente = new JLabel("Nome:");
	   lblCliente.setForeground(Color.blue);
	   jpnControle.add(lblCliente,ParagraphLayout.NEW_PARAGRAPH);
	   txtCliente = new JTextField(30);
	   jpnControle.add(txtCliente);
	   
	   lblSobrenome = new JLabel("Sobrenome:"); 
	   lblSobrenome.setForeground(Color.blue);
	   jpnControle.add(lblSobrenome,ParagraphLayout.NEW_PARAGRAPH);
	   txtSobrenome = new JTextField(30); 
	   jpnControle.add(txtSobrenome);
	   
	   lblDocumento = new JLabel("Documento:");
	   jpnControle.add(lblDocumento,ParagraphLayout.NEW_PARAGRAPH);
	   jcbDocumento = new JComboBox(documento);
	   jpnControle.add(jcbDocumento);
	   
	   lblNumDocum = new JLabel("Numero do Documento:");
	   jpnControle.add(lblNumDocum,ParagraphLayout.NEW_PARAGRAPH);
	   txtNumDocum = new JTextField(20);
	   jpnControle.add(txtNumDocum);
	}
	private void criaBotao() {//botoes da tela
		jpnBotao = new JPanel();
		add("South",jpnBotao);
				
		btnSalvar = new JButton("Salvar");
		btnSalvar.setName("btnSalvar");
		btnSalvar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.salvaPessoa(getPessoa());
				LimparTela();
			}
		});
		jpnBotao.add(btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setName("btnExcluir");
		btnExcluir.setVisible(false);
		btnExcluir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.removePessoa(pessoa);
				dispose();
			}
		});
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
		txtCliente.setText("");
		txtSobrenome.setText("");
		txtNumDocum.setText("");
        jcbDocumento.setSelectedIndex(0);
	}
	
	private void setPessoa(Pessoa c){
		this.pessoa = c;
		this.btnExcluir.setVisible(true);
		txtCliente.setText(c.getNome());
		txtSobrenome.setText(c.getSobrenome());
		txtNumDocum.setText(c.getDocumento());
        jcbDocumento.setSelectedIndex(0);
	}
	
	public Pessoa getPessoa(){
		return new Pessoa(txtCliente.getText(), txtSobrenome.getText(), jcbDocumento.getSelectedItem().toString(), txtNumDocum.getText());
	}
}
