package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

public class TelaConfig extends JInternalFrame {

private JTable tabela;
	
	private JButton buttonAtualizar = new JButton("Atualizar");
	private JButton buttonFechar = new JButton("Fechar");
	
	private static TelaConfig INSTANCE = null;
	
	public TelaConfig(){
		super("Configurações", true, true , false, false);
		Container pane = this.getContentPane();
		pane.setLayout(null);

		this.addInternalFrameListener(new InternalFrameAdapter(){
		public void internalFrameClosing(InternalFrameEvent e){
		interfaceAgendaInternalFrameClosing(e);
		}
		});
		
		JScrollPane scrollpane = new JScrollPane(tabela);
		scrollpane.setBounds(5, 95, 680, 390);
		
		pane.add(scrollpane);
		
		
		this.setResizable(false);
		this.setSize(700, 550);
		}
		
		public static TelaConfig getInstance(){
			if (TelaConfig.INSTANCE == null){
				return INSTANCE = new TelaConfig();
			}
			
			return INSTANCE;
		}
		
		public TelaConfig destroyInstance(){
			this.dispose();
			return INSTANCE = null;
		}
		
		private void interfaceAgendaInternalFrameClosing(InternalFrameEvent e){
				this.destroyInstance();
		}
}
