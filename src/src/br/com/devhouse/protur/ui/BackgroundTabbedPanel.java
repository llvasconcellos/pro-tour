package br.com.devhouse.protur.ui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class BackgroundTabbedPanel extends JPanel{
	private Image image;
	private JTabbedPane tabs = null;
	
	public BackgroundTabbedPanel(){
		super(new GridLayout(1, 1));
		try	{
			image = ImageIO.read(new File("src/resources/background.jpg"));
		}
		catch (Exception e) { 
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g); 
		if (image != null)
		g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
	}
	
	private void createTabPanel(){
		this.tabs = new JTabbedPane();
		ContainerListener l = new ContainerListener() {
			
			@Override
			public void componentRemoved(ContainerEvent e) {
				JTabbedPane tab = (JTabbedPane) e.getContainer();
				if(tab.getTabCount() == 0){
					BackgroundTabbedPanel panel = (BackgroundTabbedPanel) tab.getParent();
					panel.remove(0);
					panel.repaint();
					panel.tabs = null;
				}
			}
			
			@Override
			public void componentAdded(ContainerEvent e) {
				// TODO Auto-generated method stub
			}
		};
		this.tabs.addContainerListener(l);
		this.add(tabs);
	}
	
	public void addTab(JComponent panel, String titulo, String toolTip, ImageIcon icon){
		if(this.tabs == null){
			this.createTabPanel();
		}
        this.tabs.addTab(titulo, icon, panel, toolTip);
        this.tabs.setTabComponentAt(this.tabs.getTabCount() - 1, new ButtonTabComponent(this.tabs));
        this.tabs.setSelectedIndex(this.tabs.getTabCount() - 1);
	}
	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
