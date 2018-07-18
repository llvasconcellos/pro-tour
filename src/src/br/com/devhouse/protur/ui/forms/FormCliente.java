package br.com.devhouse.protur.ui.forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.devhouse.protur.beans.endereco.Cidade;
import br.com.devhouse.protur.beans.endereco.Endereco;
import br.com.devhouse.protur.beans.endereco.Estado;
import br.com.devhouse.protur.beans.endereco.Pais;
import br.com.devhouse.protur.beans.pessoa.Cliente;
import br.com.devhouse.protur.sistema.Sistema;

import ui.util.layouts.ParagraphLayout;

@SuppressWarnings("serial")
public class FormCliente extends JFrame{
    
	private Cliente cliente;
	
	private JPanel jpnControle;
	private JPanel jpnBotao;
	
	private JLabel lblCliente;
	private JLabel lblSobrenome;
	//private JLabel lblDocumento;
	//private JLabel lblNumDocum;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JLabel lblNumEndereco;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblPais;
	
	private JTextField txtCliente;
	private JTextField txtSobrenome;
	//private JTextField txtNumDocum;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtNumEndereco;
	private JTextField txtBairro;
	
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCpf;
	
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraTelefone;
	
	//private JComboBox jcbDocumento;
	private JComboBox jcbPais;
	private JComboBox jcbEstado;
	private JComboBox jcbCidade;
	
	//private String documento[] = {"Selecione um documento","CPF", "RG", "CNH", "Certidão de Nascimento"}; 
	
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	
	public FormCliente(Cliente c) {
		setSize(600, 400);
		setTitle("Clientes");
		setResizable(false);
		
		criaControle();
		criaBotao();
				
		setVisible(true);
		if(c != null){
			this.setCliente(c);
		}
	}
	
	private void criaControle() {//campos que vao em tela
	   jpnControle = new JPanel(new ParagraphLayout());//componente painel criado//Paragraph define layout que o painel utiliza
	   add("Center", jpnControle);//adiçao do componente no centro da tela
	   
	   try {
		   mascaraCpf = new MaskFormatter("###.###.###-##");
		   mascaraTelefone = new MaskFormatter("(##) ####-#####");
	} catch (Exception e) {
		e.printStackTrace();//print do erro no  console
	}
	   
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
	   
	   /*lblDocumento = new JLabel("Documento:");
	   jpnControle.add(lblDocumento,ParagraphLayout.NEW_PARAGRAPH);
	   jcbDocumento = new JComboBox(documento);
	   jpnControle.add(jcbDocumento);*/
	   
	   /*lblNumDocum = new JLabel("Numero do Documento:");
	   jpnControle.add(lblNumDocum,ParagraphLayout.NEW_PARAGRAPH);
	   txtNumDocum = new JTextField(20);
	   jpnControle.add(txtNumDocum);*/
	   
	   lblCpf = new JLabel("CPF:");
	   lblCpf.setForeground(Color.blue);
	   jpnControle.add(lblCpf,ParagraphLayout.NEW_PARAGRAPH);
	   txtCpf = new JFormattedTextField(mascaraCpf);
	   txtCpf.setPreferredSize(new Dimension(100,20));
	   jpnControle.add(txtCpf);
	   
	   lblTelefone = new JLabel("Telefone:");
	   lblTelefone.setForeground(Color.blue);
	   jpnControle.add(lblTelefone,ParagraphLayout.NEW_PARAGRAPH);
	   txtTelefone = new JFormattedTextField(mascaraTelefone);
	   txtTelefone.setPreferredSize(new Dimension(100,20));
	   jpnControle.add(txtTelefone);
	   
	   lblEmail = new JLabel("Email:");
	   jpnControle.add(lblEmail,ParagraphLayout.NEW_PARAGRAPH);
	   txtEmail = new JTextField(30);
	   jpnControle.add(txtEmail);
	   
	   lblEndereco = new JLabel("Endereço:");
	   jpnControle.add(lblEndereco,ParagraphLayout.NEW_PARAGRAPH);
	   txtEndereco = new JTextField(30); 
	   jpnControle.add(txtEndereco);
	   
       lblNumEndereco = new JLabel("Numero Endereço:");
       jpnControle.add(lblNumEndereco,ParagraphLayout.NEW_PARAGRAPH);
       txtNumEndereco = new JTextField(5); 
       jpnControle.add(txtNumEndereco);
       
       lblBairro = new JLabel("Bairro:");
       jpnControle.add(lblBairro,ParagraphLayout.NEW_PARAGRAPH);
       txtBairro = new JTextField(15); 
       jpnControle.add(txtBairro);
       
       lblPais = new JLabel("Pais:");
	   jpnControle.add(lblPais,ParagraphLayout.NEW_PARAGRAPH);
	   jcbPais = new JComboBox();
	   for (Pais p : Sistema.paises) {
		   jcbPais.addItem(p);
	   }
	   jcbPais.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("comboBoxChanged")){
					JComboBox c = (JComboBox) e.getSource();
					Pais pais = (Pais) c.getSelectedItem();
					populaComboEstados(pais.getGeonameId());
				}
			}
	   });
	   jpnControle.add(jcbPais);
	  
       lblEstado = new JLabel("Estado:");
	   jpnControle.add(lblEstado,ParagraphLayout.NEW_PARAGRAPH);
	   jcbEstado = new JComboBox();
	   jcbEstado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("comboBoxChanged")){
					JComboBox c = (JComboBox) e.getSource();
					Estado estado = (Estado) c.getSelectedItem();
					if(estado != null)
						populaComboCidades(estado.getGeonameId());
				}
			}
	   });
	   jpnControle.add(jcbEstado);
       
       lblCidade = new JLabel("Cidade:");
	   jpnControle.add(lblCidade,ParagraphLayout.NEW_PARAGRAPH);
	   jcbCidade = new JComboBox();
	   jpnControle.add(jcbCidade);
       
	}
	private void criaBotao() {//botoes da tela
		jpnBotao = new JPanel();
		add("South",jpnBotao);
				
		btnSalvar = new JButton("Salvar");
		btnSalvar.setName("btnSalvar");
		btnSalvar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.salvaCliente(getCliente());
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
				Sistema.removeCliente(cliente);
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
		//txtNumDocum.setText("");
		txtEmail.setText("");
		txtEndereco.setText("");
        txtNumEndereco.setText("");
        txtBairro.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
        jcbPais.setSelectedIndex(0);
        jcbEstado.removeAllItems();
        jcbCidade.removeAllItems();
        //jcbDocumento.setSelectedIndex(0);
	}
	
	private void setCliente(Cliente c){
		this.cliente = c;
		this.btnExcluir.setVisible(true);
		txtCliente.setText(c.getNome());
		txtSobrenome.setText(c.getSobrenome());
		//txtNumDocum.setText(c.getDocumento());
		txtEmail.setText(c.getEmail());
		txtEndereco.setText(c.getEndereco().getRua());
        txtNumEndereco.setText(c.getEndereco().getNumero());
        txtBairro.setText(c.getEndereco().getBairro());
        txtTelefone.setText(c.getTelefone());
        txtCpf.setText(c.getDocumento());
        /*jcbPais.setSelectedIndex(0);
        jcbEstado.removeAllItems();
        jcbCidade.removeAllItems();
        jcbDocumento.setSelectedIndex(0);*/
	}
	
	public void populaComboEstados(String codPais){
		jcbEstado.removeAllItems();
		List<Estado> estados = Sistema.getEstadosWeb(codPais);
		for (Estado e : estados) {
			jcbEstado.addItem(e);
	   }
	}
	
	public void populaComboCidades(String codEstado){
		jcbCidade.removeAllItems();
		List<Cidade> cidades = Sistema.getCidadesWeb(codEstado);
		for (Cidade c : cidades) {
			jcbCidade.addItem(c);
	   }
	}
	
	public Cliente getCliente(){
		Cidade cidade = (Cidade) jcbCidade.getSelectedItem();
		Estado estado = (Estado) jcbEstado.getSelectedItem();
		Pais pais = (Pais) jcbPais.getSelectedItem();
		
		Endereco endereco = new Endereco(txtEndereco.getText(), txtNumEndereco.getText(), txtBairro.getText(), cidade, estado, pais);
		return new Cliente(txtCliente.getText(), txtSobrenome.getText(), txtCpf.getText(), txtTelefone.getText(), txtEmail.getText(), endereco);
	}
}
