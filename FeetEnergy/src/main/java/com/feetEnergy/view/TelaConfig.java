package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.JTree;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

public class TelaConfig extends JFrame {

	private JPanel contentPane;

	public TelaConfig() {
		setResizable(false);
		setTitle("Feet Energy - Configurações");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 530);
		contentPane = new JPanel();
		if(App.tema == 0)
			contentPane.setBackground(Color.WHITE);
		else
			contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPrincipal tlaPrincipal = new TelaPrincipal();
				tlaPrincipal.setVisible(true);
				TelaConfig.this.setVisible(false);
				
			}
		});
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(10, 11, 100, 35);
		contentPane.add(btnVoltar);
		
		final JLabel lblTema = new JLabel("Mudar tema:");
		lblTema.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTema.setBounds(61, 172, 100, 32);
		if(App.tema == 0)
			lblTema.setForeground(Color.BLACK);
		else
			lblTema.setForeground(Color.WHITE);
		contentPane.add(lblTema);
		
		final JToggleButton btnTema = new JToggleButton();
		if(App.tema == 0)
			btnTema.setText("Claro");
		else
			btnTema.setText("Escuro");
			
		btnTema.setBackground(Color.LIGHT_GRAY);
		btnTema.setBounds(299, 169, 170, 35);
		contentPane.add(btnTema);
		btnTema.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    if (btnTema.isSelected()) {
	    			contentPane.setBackground(Color.BLACK);
	    			lblTema.setForeground(Color.WHITE);
	    			btnTema.setText("Escuro");
	    			App.tema = 1;
	    	    } else {
		    		contentPane.setBackground(Color.WHITE);
	    			lblTema.setForeground(Color.BLACK);
	    			btnTema.setText("Claro");
	    			App.tema = 0;
	    	    }
	    	}
	        });
		
		JButton btnTestarComunicaoCom = new JButton("Testar Comunicação");
		btnTestarComunicaoCom.setBackground(Color.LIGHT_GRAY);
		btnTestarComunicaoCom.setBounds(299, 113, 170, 35);
		contentPane.add(btnTestarComunicaoCom);
		
		JLabel lblTestarComunicaoCom = new JLabel("Testar comunicação com o Arduino:");
		lblTestarComunicaoCom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTestarComunicaoCom.setBounds(61, 111, 228, 35);
		contentPane.add(lblTestarComunicaoCom);
		
		
	}
}
