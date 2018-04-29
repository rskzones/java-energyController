package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.feetEnergy.controller.ConnectionClass;
import com.feetEnergy.controller.GeracaoJdbcDAO;
import com.feetEnergy.model.GeracaoEnergia;
import com.feetEnergy.model.GeracaoEnergiaTableModel;

import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

import com.feetEnergy.controller.GeracaoJdbcDAO;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPainel;
	private DefaultTableModel modelTable = new DefaultTableModel();
	
	private JMenuBar menuBar;
	private JMenu mnOpRelatorio;
	
	private JMenuItem menuGeraTxt;


	public TelaHistorico() {
		setTitle("Feet Energy - Histórico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 530);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnOpRelatorio = new JMenu("Opcões de Relatório");
		menuBar.add(mnOpRelatorio);
		
		menuGeraTxt = new JMenuItem("Gerar Documento .txt");
		mnOpRelatorio.add(menuGeraTxt);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable(modelTable);
		table.setBounds(1, 1, 807, 0);
		contentPane.add(table, BorderLayout.CENTER);
		
		modelTable.addColumn("Dia");
		modelTable.addColumn("Geração");
		modelTable.addColumn("Tempo");
		modelTable.addColumn("%");
		
		
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(5, 57, 809, 408);
		
		contentPane.add(scrollpane);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//btnAtualizar.setIcon(new ImageIcon(TelaHistorico.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnAtualizar.setBounds(10, 11, 110, 35);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPrincipal tlaPrincipal = new TelaPrincipal();
				tlaPrincipal.setVisible(true);
				TelaHistorico.this.setVisible(false);
				
			}
		});
		//btnVoltar.setIcon(new ImageIcon(TelaHistorico.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnVoltar.setBounds(707, 11, 100, 35);
		contentPane.add(btnVoltar);
	}
	
	       // DefaultTableModel modelo = (DefaultTableModel);
	       // jTProdutos.setRowSorter(new TableRowSorter(model));

	       // readJTable();
 }
	
	/*public void readJTable() {
    	
		//DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
		//GeracaoJdbcDAO gdao = new GeracaoJdbcDAO();
		
		
		
		for (GeracaoEnergia g : gdao.listar()) {

			modelTable.addRow(new Object[]{
				g.getData(),
				g.getGerado(),
				g.getTempo(),
				g.getPorcentagem()
			});

        }
	
		
        

        this.table = new JTable(modelTable);
        this.scrollPainel = new JScrollPane(table);

        this.add(scrollPainel);
    }*/
	
