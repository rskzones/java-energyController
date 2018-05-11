package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.feetEnergy.controller.ConnectionClass;
import com.feetEnergy.controller.GeracaoJdbcDAO;
import com.feetEnergy.model.GeracaoEnergia;
import com.feetEnergy.view.*;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private int nivelBat;

	public TelaPrincipal() {
		setTitle("Feet Energy - Controlador de Energia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 530);
		
		lerBat();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu mnOpes = new JMenu("Opções");
		menuBar.add(mnOpes);

		JMenuItem menuHistoricoItem = new JMenuItem("Histórico");
		mnOpes.add(menuHistoricoItem);

		JMenuItem menuConfigItem = new JMenuItem("Configurações");
		mnOpes.add(menuConfigItem);

		JMenuItem menuExitItem = new JMenuItem("Finalizar Aplicação");
		mnOpes.add(menuExitItem);

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

		menuExitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int status = JOptionPane.showConfirmDialog(null,"Deseja encerrar a aplicação?", "Aviso", JOptionPane.YES_NO_OPTION);
				if(status == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(10, 11, 799, 448);
		contentPane.add(panel);
		panel.setLayout(null);

		if (nivelBat >= 0 && nivelBat <= 15) {
			Canvas canvasBatLow = new Canvas();
			canvasBatLow.setBackground(Color.RED);
			canvasBatLow.setBounds(350, 222, 80, 45);
			panel.add(canvasBatLow);
		} else if (nivelBat >= 15 && nivelBat <= 60) {
			Canvas canvasBatMed = new Canvas();
			canvasBatMed.setBackground(Color.ORANGE);
			canvasBatMed.setBounds(350, 163, 80, 100);
			panel.add(canvasBatMed);
		} else if (nivelBat >= 61 && nivelBat <= 100) {
			Canvas canvasBatFull = new Canvas();
			canvasBatFull.setBackground(Color.GREEN);
			canvasBatFull.setBounds(350, 67, 80, 200);
			panel.add(canvasBatFull);
		}

		Label lblNivelBat = new Label("Nível da Bateria: " + nivelBat + "%");
		lblNivelBat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNivelBat.setForeground(new Color(255, 255, 255));
		lblNivelBat.setBackground(new Color(0, 0, 205));
		lblNivelBat.setAlignment(Label.CENTER);
		lblNivelBat.setBounds(320, 273, 141, 30);
		panel.add(lblNivelBat);

		JButton btnRecarregar = new JButton("Atualizar Nível");
		btnRecarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lerBat();
			}
		});
		btnRecarregar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRecarregar.setForeground(Color.BLACK);
		btnRecarregar.setBackground(Color.LIGHT_GRAY);
		btnRecarregar.setBounds(320, 313, 141, 30);
		panel.add(btnRecarregar);

		JPanel panelbat = new JPanel();
		panelbat.setBackground(new Color(0, 0, 205));
		panelbat.setBounds(272, 11, 235, 426);
		panel.add(panelbat);

	}

	private void lerBat() {
		Connection con;

		try {

			con = ConnectionClass.getConnection();
			GeracaoJdbcDAO gdao = new GeracaoJdbcDAO(con);

			for (GeracaoEnergia g : gdao.listar()) {
				
				nivelBat = g.getPorcentagem();
				con.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na Comunicação com o Banco de Dados!");
			e.printStackTrace();
		}
	}
}
