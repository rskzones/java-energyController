package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.feetEnergy.view.*;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JSeparator;


public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private int nivelBat = 15 ;

	public TelaPrincipal() {
		setTitle("Feet Energy - Controlador de Energia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 530);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpes = new JMenu("Opções");
		menuBar.add(mnOpes);
		
		JMenuItem menuHistoricoItem = new JMenuItem("Histórico");
		mnOpes.add(menuHistoricoItem);
		
		JMenuItem menuConfigItem = new JMenuItem("Configurações");
		mnOpes.add(menuConfigItem);
		
		menuHistoricoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaHistorico tlaHistorico = new TelaHistorico();
				tlaHistorico.setVisible(true);
				TelaPrincipal.this.setVisible(false);
				
			}
		});
		
		menuConfigItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaConfig tlaConfig = new TelaConfig();
				tlaConfig.setVisible(true);
				TelaPrincipal.this.setVisible(false);
				
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 799, 448);
		contentPane.add(panel);
		panel.setLayout(null);
		
		if(nivelBat >= 0 && nivelBat <= 15) {
		Canvas canvasBatLow = new Canvas();
		canvasBatLow.setBackground(Color.RED);
		canvasBatLow.setBounds(333, 222, 80, 45);
		panel.add(canvasBatLow);
		}
		else if(nivelBat >=15 && nivelBat <= 60) {
		Canvas canvasBatMed = new Canvas();
		canvasBatMed.setBackground(Color.ORANGE);
		canvasBatMed.setBounds(333, 137, 80, 130);
		panel.add(canvasBatMed);
		}
		else if(nivelBat >= 61 && nivelBat <=100) {
		Canvas canvasBatFull = new Canvas();
		canvasBatFull.setBackground(Color.GREEN);
		canvasBatFull.setBounds(333, 67, 80, 200);
		panel.add(canvasBatFull);
		}
		
		
		Label lblNivelBat = new Label("Nível da Bateria: " + nivelBat + "%");
		lblNivelBat.setBounds(320, 273, 120, 22);
		panel.add(lblNivelBat);
		
	}
}
