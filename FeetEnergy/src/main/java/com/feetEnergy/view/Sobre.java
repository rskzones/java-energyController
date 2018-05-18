package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Sobre extends JFrame {

	private JPanel contentPane;

	public Sobre() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel btnFechar = new JLabel("X");
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Sobre.this.dispose();
			}
		});
		btnFechar.setHorizontalAlignment(SwingConstants.CENTER);
		btnFechar.setForeground(new Color(255, 255, 255));
		btnFechar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnFechar.setBounds(560, 11, 30, 35);
		contentPane.add(btnFechar);
		
		JLabel lblFeetenergy = new JLabel("FeetEnergy: Plataforma de Controle e Geração de Energia");
		lblFeetenergy.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeetenergy.setForeground(new Color(255, 255, 255));
		lblFeetenergy.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFeetenergy.setBounds(10, 57, 580, 50);
		contentPane.add(lblFeetenergy);
		
		JLabel lblNewLabel = new JLabel("Versão 1.0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(175, 180, 250, 40);
		contentPane.add(lblNewLabel);
	}
}
