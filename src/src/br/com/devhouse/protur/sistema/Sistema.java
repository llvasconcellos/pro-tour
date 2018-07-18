package br.com.devhouse.protur.sistema;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JViewport;

import br.com.devhouse.protur.beans.endereco.Cidade;
import br.com.devhouse.protur.beans.endereco.Estado;
import br.com.devhouse.protur.beans.endereco.GeoWebService;
import br.com.devhouse.protur.beans.endereco.Pais;
import br.com.devhouse.protur.beans.pessoa.Cliente;
import br.com.devhouse.protur.beans.pessoa.Pessoa;
import br.com.devhouse.protur.beans.reservas.Reserva;
import br.com.devhouse.protur.beans.reservas.ReservaHotel;
import br.com.devhouse.protur.ui.MainWindow;
import br.com.devhouse.protur.ui.forms.FormCliente;
import br.com.devhouse.protur.ui.forms.FormPessoa;
import br.com.devhouse.protur.ui.forms.FormReservaHotel;
import br.com.devhouse.protur.ui.tmodels.ClienteTableModel;
import br.com.devhouse.protur.ui.tmodels.PessoaTableModel;
import br.com.devhouse.protur.ui.tmodels.ReservaTableModel;


public class Sistema {
	
	public static MainWindow main = null;
	public static GeoWebService g = null;
	public static PessoaTableModel pessoasModel;
	public static ClienteTableModel clientesModel;
	public static ReservaTableModel reservasModel;
	
	static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static List<Reserva> reservas = new ArrayList<Reserva>();
	public static List<Pais> paises = null;
	
	public static void main(String[] args) {
				
		g = new GeoWebService();
		paises = g.getPaises();
		
		main = new MainWindow();
		main.setVisible(true);
		main.toFront();
	}
	
	public static List<Estado> getEstadosWeb(String paisId){
		List<Estado> estados = g.getEstados(paisId);
		return estados;
	}
	
	public static List<Cidade> getCidadesWeb(String estadoId){
		List<Cidade> cidades = g.getCidades(estadoId);
		return cidades;
	}
	
	public static void criaJanelaPessoas(){
		JPanel p = new JPanel(new BorderLayout(5, 5));
		
		pessoasModel = new PessoaTableModel(getPessoas());		
		JTable table = new JTable(pessoasModel);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( e.getClickCount() == 2 ) {
					JTable tabela = (JTable) e.getSource();
					Sistema.criaFormPessoa((Pessoa) Sistema.pessoas.get(tabela.getSelectedRow()));
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		
		p.add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel botoes = new JPanel(new GridLayout(1, 0));
		
		JButton buttonCadastra = new JButton("Cadastrar");
		JButton buttonDados = new JButton("Mostrar dados");
		JButton buttonSair = new JButton("Sair");
		
		botoes.add(new JLabel());
		botoes.add(buttonCadastra);
		botoes.add(new JLabel());
		botoes.add(buttonDados);
		botoes.add(new JLabel());
		botoes.add(buttonSair);
		botoes.add(new JLabel());

		buttonCadastra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.criaFormPessoa(null);
			}
		});
		
		buttonSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				JTabbedPane tab = (JTabbedPane) botao.getParent().getParent().getParent();
				tab.remove(botao.getParent().getParent());
			}
		});
		
		buttonDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				JPanel painel = (JPanel) botao.getParent().getParent();
				JScrollPane p = (JScrollPane) painel.getComponent(0);
				JViewport v = (JViewport) p.getComponent(0);
				JTable table = (JTable) v.getComponent(0);
				Sistema.criaFormPessoa((Pessoa) Sistema.pessoas.get(table.getSelectedRow()));
			}
		});
		
		p.add(botoes, BorderLayout.SOUTH);

		//ImageIcon icon =  new ImageIcon(main.getClass().getResource("src/resources/system-icon.png"));
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File("src/resources/system-icon.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		main.painel.addTab(p, "Administração de Pessoas", "Mantem Pessoas", icon);
	}
	
	public static void criaJanelaClientes(){
		JPanel p = new JPanel(new BorderLayout(5, 5));
		
		clientesModel = new ClienteTableModel(getClientes());		
		JTable table = new JTable(clientesModel);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( e.getClickCount() == 2 ) {
					JTable tabela = (JTable) e.getSource();
					Sistema.criaFormCliente((Cliente) Sistema.clientes.get(tabela.getSelectedRow()));
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		
		p.add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel botoes = new JPanel(new GridLayout(1, 0));
		
		JButton buttonCadastra = new JButton("Cadastrar");
		JButton buttonDados = new JButton("Mostrar dados");
		JButton buttonSair = new JButton("Sair");
		
		botoes.add(new JLabel());
		botoes.add(buttonCadastra);
		botoes.add(new JLabel());
		botoes.add(buttonDados);
		botoes.add(new JLabel());
		botoes.add(buttonSair);
		botoes.add(new JLabel());

		buttonCadastra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.criaFormCliente(null);
			}
		});
		
		buttonSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				JTabbedPane tab = (JTabbedPane) botao.getParent().getParent().getParent();
				tab.remove(botao.getParent().getParent());
			}
		});
		
		buttonDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				JPanel painel = (JPanel) botao.getParent().getParent();
				JScrollPane p = (JScrollPane) painel.getComponent(0);
				JViewport v = (JViewport) p.getComponent(0);
				JTable table = (JTable) v.getComponent(0);
				Sistema.criaFormCliente((Cliente) Sistema.clientes.get(table.getSelectedRow()));
			}
		});
		
		p.add(botoes, BorderLayout.SOUTH);

		//ImageIcon icon =  new ImageIcon(main.getClass().getResource("images/system-icon.png"));
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File("src/resources/system-icon.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		main.painel.addTab(p, "Administração de Clientes", "Mantem Clientes", icon);
	}
	
	public static void criaFormCliente(Cliente c){
		FormCliente f = new FormCliente(c);
	}
	
	public static void criaFormPessoa(Pessoa c){
		FormPessoa f = new FormPessoa(c);
	}
	
	public static List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public static void salvaPessoa(Pessoa p){
		pessoas.add(p);
		pessoasModel.fireTableDataChanged();
	}
	
	public static List<Cliente> getClientes() {
		return clientes;
	}
	
	public static void salvaCliente(Cliente c){
		clientes.add(c);
		pessoas.add(c);
		clientesModel.fireTableDataChanged();
	}
	
	public static void removeCliente(Cliente c){
		clientes.remove(c);
		pessoas.remove(c);
		clientesModel.fireTableDataChanged();
	}
	
	public static void removePessoa(Pessoa c){
		pessoas.remove(c);
		pessoasModel.fireTableDataChanged();
	}
	
	public static List<Reserva> getReservas() {
		return reservas;
	}
	
	
	
	public static void criaJanelaReservas(){
		JPanel p = new JPanel(new BorderLayout(5, 5));
		
		reservasModel = new ReservaTableModel(getReservas());		
		JTable table = new JTable(reservasModel);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( e.getClickCount() == 2 ) {
					JTable tabela = (JTable) e.getSource();
					//Sistema.criaFormCliente((Cliente) Sistema.clientes.get(tabela.getSelectedRow()));
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		
		p.add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel botoes = new JPanel(new GridLayout(1, 0));
		
		JButton buttonReservaAcomodacao = new JButton("Reserva Acomodação");
		JButton buttonDados = new JButton("Mostrar dados");
		JButton buttonSair = new JButton("Sair");
		
		botoes.add(new JLabel());
		botoes.add(buttonReservaAcomodacao);
		botoes.add(new JLabel());
		botoes.add(buttonDados);
		botoes.add(new JLabel());
		botoes.add(buttonSair);
		botoes.add(new JLabel());

		buttonReservaAcomodacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.criaFormReservaHotel(null);
			}
		});
		
		buttonSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				JTabbedPane tab = (JTabbedPane) botao.getParent().getParent().getParent();
				tab.remove(botao.getParent().getParent());
			}
		});
		
		buttonDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				JPanel painel = (JPanel) botao.getParent().getParent();
				JScrollPane p = (JScrollPane) painel.getComponent(0);
				JViewport v = (JViewport) p.getComponent(0);
				JTable table = (JTable) v.getComponent(0);
				//Sistema.criaFormCliente((Cliente) Sistema.clientes.get(table.getSelectedRow()));
			}
		});
		
		p.add(botoes, BorderLayout.SOUTH);

		ImageIcon icon =  new ImageIcon(main.getClass().getResource("images/system-icon.png"));
		main.painel.addTab(p, "Administração de Reservas", "Mantem Reservas", icon);
	}
	
	public static void criaFormReservaHotel(ReservaHotel r){
		FormReservaHotel f = new FormReservaHotel(r);
	}
	
	
	
	
	
	
	
	
	
}
