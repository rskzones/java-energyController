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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaConfig extends JFrame {

	private JPanel contentPane;

	public TelaConfig() {
		setTitle("Feet Energy - Configurações");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		
		JLabel lblManutencao = new JLabel("Configurações em breve.");
		lblManutencao.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblManutencao.setBounds(138, 11, 400, 35);
		contentPane.add(lblManutencao);
	}
}
