package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class TelaHistorico extends JInternalFrame {
	
	private JTable tabela;
	
	private JButton buttonAtualizar = new JButton("Atualizar");
	private JButton buttonFechar = new JButton("Fechar");
	
	private static TelaHistorico INSTANCE = null;
	
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public TelaHistorico(){
		super("Historico", true, true , false, false);
		Container pane = this.getContentPane();
		pane.setLayout(null);

		buttonAtualizar.setBounds(5, 10, 100, 80);
		buttonAtualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonAtualizar.setVerticalAlignment(SwingConstants.TOP);
		buttonAtualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		buttonAtualizar.setIcon(new ImageIcon());

		buttonAtualizar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		buttonAtualizarActionPerformed(e); //chama esse método
		}
		});
	
		buttonFechar.setBounds(110, 10, 100, 80);
		buttonFechar.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonFechar.setVerticalAlignment(SwingConstants.TOP);
		buttonFechar.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		buttonFechar.setIcon(new ImageIcon());
		
		
		buttonFechar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		buttonFecharActionPerformed(e);
		}
		});

		this.addInternalFrameListener(new InternalFrameAdapter(){
		public void internalFrameClosing(InternalFrameEvent e){
		interfaceAgendaInternalFrameClosing(e);
		}
		});
		
		tabela = new JTable(modelo);
		
		modelo.addColumn("Dia");
		modelo.addColumn("Geração");
		modelo.addColumn("Tempo");
		modelo.addColumn("%");
		
		JScrollPane scrollpane = new JScrollPane(tabela);
		scrollpane.setBounds(5, 95, 680, 390);
		
		pane.add(buttonAtualizar);
		pane.add(buttonFechar);
		pane.add(scrollpane);
		
		
		this.setResizable(false);
		this.setSize(700, 550);
		}
	
		private void buttonAtualizarActionPerformed(ActionEvent e){
			//EVENTO DO BOTÃO ATUALIZAR
		}
		private void buttonFecharActionPerformed(ActionEvent e){
			
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.destroyInstance();
		}
		
		public static TelaHistorico getInstance(){
			if (TelaHistorico.INSTANCE == null){
				return INSTANCE = new TelaHistorico();
			}
			
			return INSTANCE;
		}
		
		public TelaHistorico destroyInstance(){
			this.dispose();
			return INSTANCE = null;
		}
		
		private void interfaceAgendaInternalFrameClosing(InternalFrameEvent e){
				this.destroyInstance();
		}
}
