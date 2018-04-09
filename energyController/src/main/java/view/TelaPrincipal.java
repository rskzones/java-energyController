package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {
	
		private int nivelBateria = 15;
		
		private JMenu menuOpcoes = new JMenu("Opcoes");
		
		private JMenuBar menuBar = new JMenuBar();
		
		private JMenuItem menuHistorico = new JMenuItem("Histórico");
		private JMenuItem menuConfig = new JMenuItem("Configurações");
			
		private JDesktopPane desktop;
			
		public TelaPrincipal() {
			super("Energy Controller");
		
			desktop = new JDesktopPane(){
		
				
			public void paintComponent(Graphics g){
				
				if(nivelBateria <= 100 && nivelBateria >= 75) {
					super.paintComponents(g);
					
					g.setColor(Color.GREEN);
					g.fill3DRect(80, 70, 50, 200, true);
					g.drawString("Nível da bateria: " + nivelBateria + " %", 50, 310);
				
				}else if(nivelBateria == 50 && nivelBateria >= 15) {
					super.paintComponents(g);
					
					g.setColor(Color.orange);
					g.fill3DRect(80, 150, 50, 125, true);
					g.drawString("Nível da bateria: " + nivelBateria + " %", 50, 310);
				
				}else if(nivelBateria >= 0 && nivelBateria <= 15) {
					super.paintComponents(g);
					
					g.setColor(Color.red);
					g.fill3DRect(80, 200, 50, 40, true);
					g.drawString("Nível da bateria: " + nivelBateria + " %", 50, 310);
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
			menuConfigActionPerformed(e);
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
		
		private void menuConfigActionPerformed(ActionEvent e){
		TelaConfig config = TelaConfig.getInstance();
		desktop.remove(config);
		desktop.add(config);
		config.setVisible(true);
		
		}	
}

