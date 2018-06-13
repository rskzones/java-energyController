package com.feetEnergy.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import com.feetEnergy.view.App;
import com.feetEnergy.view.Login;

public class App extends JWindow {

	private int duration;
	public static int tema;

	// Criação do Método App
	public App(int d) {
		// Determinando duração do Splash
		duration = d;
		tema = 0;
	}

	public void showApp() {
		getContentPane();
		

		// Instância da tela
		JPanel content = (JPanel) getContentPane();
		content.setBackground(new Color(0, 0, 128));
		getContentPane().setLayout(null);

		JLabel lblFeetenergy = new JLabel("FeetEnergy");
		lblFeetenergy.setForeground(new Color(255, 255, 255));
		lblFeetenergy.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeetenergy.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFeetenergy.setBounds(160, 75, 140, 35);
		getContentPane().add(lblFeetenergy);

		JLabel lblCarregando = new JLabel("Carregando...");
		lblCarregando.setForeground(new Color(255, 255, 255));
		lblCarregando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarregando.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCarregando.setBounds(160, 154, 140, 35);
		getContentPane().add(lblCarregando);

		// Configura a posição e o tamanho da tela
		int width = 450;
		int height = 200;

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		// Definindo o tamanho (coluna, linha, comprimento, altura) do Splash
		setBounds(x, y, width, height);
		// Torna Visivel
		setVisible(true);

		// Espera ate que os recursos estejam carregados
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}
		setVisible(false);

	}

	public void showAppAndExit() {
		// Chamada ao método construtor showApp
		showApp();
		Login login = new Login();
		login.setVisible(true);
		this.dispose();
	}

	public static void main(String[] args) {
		// Instancia da classe App e definindo tempo de duração do splash
		App splash = new App(5000);
		// Chamada ao método showAppAndExit
		splash.showAppAndExit();
	}
}