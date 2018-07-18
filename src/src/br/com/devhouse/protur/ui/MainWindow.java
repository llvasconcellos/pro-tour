package br.com.devhouse.protur.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.devhouse.protur.sistema.Sistema;


@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	private static final String[] log = {
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",
		"Carregando Módulo de Pessoa",		
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",
		"Carregando Módulo de Cliente",		
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",
		"Carregando Módulo de Endereços",		
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",
		"Carregando Módulo de Reserva",		
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",
		"Carregando Módulo de Reserva Aérea",		
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",
		"Carregando Módulo de Reserva de Ônibus",		
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",
		"Carregando Módulo de Reserva Trem",		
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",
		"Carregando Módulo de Reserva de Hotel",		
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando Módulo de Reserva Passeio",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService",
		"Carregando informações do GEO WebService"
	};

	public BackgroundTabbedPanel painel = null;
	
	static void renderSplashFrame(Graphics2D g, int progress) {
		
		g.setComposite(AlphaComposite.Clear);
		g.fillRect(0, 0, 640, 436);
		g.setPaintMode();
		
		BufferedImage img = null;
		try {
			//img = ImageIO.read(new File("C:\\Users\\leonardo.v\\Desktop\\LPG-2\\LPG-2\\Trabalho Final\\Leonardo\\ProTour\\bin\\br\\com\\devhouse\\protur\\ui\\images\\progress.jpg"));
			//img = ImageIO.read(new java.net.URL(JFrame.class.getResource("progress.jpg"), "progress.jpg"));
			img = ImageIO.read(new File("src/resources/progress.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int x = 30;
		int y = 360;
		int width = 583;
		int height = 24;
		
		int progresso = (int) (((width-4) / 100.0) * (progress + 1));
		
		g.setColor(Color.WHITE);
		g.drawString(log[progress], x, y-16);
		g.setColor(Color.WHITE);
		g.draw3DRect(x, y, width, height, true);
		g.setColor(Color.BLUE);
		g.drawImage(img, x+2, y+2, progresso, height-4, null);
		g.setColor(Color.WHITE);
		g.drawString(progress + "%", x+280, y+16);
    }
	
	public MainWindow(){
		
		final SplashScreen splash = SplashScreen.getSplashScreen();
		if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
		
        for(int i=0; i<10; i++) {
            renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(110);
            }
            catch(InterruptedException e) {
            }
        }
        splash.close();
		

		this.setWindowsLookAndFeel();
		
		this.setIcon("system-icon.png");
		
		this.setTitle("ProTur Sistema de Gerenciamento de Agências de Turismo");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				actionExit();
			}
		});
		
		painel = new BackgroundTabbedPanel();
		
		this.add(painel);
		this.createMenu();        
	}
	
	private void actionExit(){
		if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
			System.exit(0);
		}
	}
	
	private void setWindowsLookAndFeel(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}
	
	private void createMenu(){
		JMenuItem fileExitMenuItem = null;
		try {
			fileExitMenuItem = new JMenuItem("Sair", new ImageIcon(ImageIO.read(new File("src/resources/exit.png"))));
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		fileExitMenuItem.setMnemonic(KeyEvent.VK_X);
		fileExitMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				actionExit();
			}
		});
		
		JMenu fileMenu = new JMenu("    Sistema    ");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(fileExitMenuItem);

		
		JMenuItem clientesMenuItem = new JMenuItem("Clientes", KeyEvent.VK_X);
		clientesMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Sistema.criaJanelaClientes();
			}
		});
		
		JMenuItem pessoasMenuItem = new JMenuItem("Pessoas", KeyEvent.VK_X);
		pessoasMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Sistema.criaJanelaPessoas();
			}
		});
		
		
		JMenu rhMenu = new JMenu("     Cadastros      ");
		rhMenu.setMnemonic(KeyEvent.VK_R);
		rhMenu.add(clientesMenuItem);
		rhMenu.add(pessoasMenuItem);
		
		JMenu reservasMenu = new JMenu("     Reservas      ");
		reservasMenu.setMnemonic(KeyEvent.VK_S);
		reservasMenu.addMouseListener(new MouseListener() {
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
				Sistema.criaJanelaReservas();
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(rhMenu);
		menuBar.add(reservasMenu);
		this.setJMenuBar(menuBar);
	}
	
	public void setIcon(String filename){
		try {
			//this.setIconImage(javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/" + filename), filename)));
			this.setIconImage(ImageIO.read(new File("src/resources/" + filename)));
		} catch (MalformedURLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}