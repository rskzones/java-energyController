package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class App extends JFrame {
	
	private int nivelBateria = 13;
	
	private JMenu menuOpcoes = new JMenu("Opcoes");
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenuItem menuHistorico = new JMenuItem("Histórico");
	private JMenuItem menuConfig = new JMenuItem("Configurações");
		
	private JDesktopPane desktop;
		
	public App(){ 
		super("Energy Controller");
	
		desktop = new JDesktopPane(){
	
			
		public void paintComponent(Graphics g){
			
			if(nivelBateria <= 100 || nivelBateria >= 75) {
				super.paintComponents(g);
				
				g.setColor(Color.green);
				g.fill3DRect(50, 50, 50, 250, true);
				g.drawString("Nível da bateria", 50, 310);
			
			}else if(nivelBateria == 50 || nivelBateria >= 15) {
				super.paintComponents(g);
				
				g.setColor(Color.orange);
				g.fill3DRect(50, 50, 50, 125, true);
				g.drawString("Nível da bateria", 50, 310);
			
			}else if(nivelBateria < 15) {
				super.paintComponents(g);
				
				g.setColor(Color.red);
				g.fill3DRect(50, 50, 50, 40, true);
				g.drawString("Nível da bateria", 50, 310);
			}else {
				super.paintComponents(g);
				
				g.setColor(Color.red);
				g.drawString("Erro, BATERIA NÃO CONECTADA", 50, 310);
			}
		}
	};
	
	desktop.setBackground(Color.WHITE);
	
	menuHistorico.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		menuHistoricoActionPerformed(e);
	}
	});
	
	
	menuConfig.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	menuFechaAgendaActionPerformed(e);
	}
	});
	
	/* Adicionando os menus à barra */
	menuOpcoes.add(menuHistorico);
	menuOpcoes.addSeparator();
	menuOpcoes.add(menuConfig);
	
	menuBar.add(menuOpcoes);
	
	this.getContentPane().add(desktop);
	
	this.setJMenuBar(menuBar);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	}

	private void menuHistoricoActionPerformed(ActionEvent e){
	
	TelaHistorico h = TelaHistorico.getInstance();
	desktop.remove(h);
	desktop.add(h);
	h.setVisible(true);
	
	}
	
	private void menuFechaAgendaActionPerformed(ActionEvent e){
	
	
	}
	
	public static void main(String[] args){
		App app = new App(); 
	}
	
}

