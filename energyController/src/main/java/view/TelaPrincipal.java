package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	public TelaPrincipal() {
		super("Energy Controller");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
}
