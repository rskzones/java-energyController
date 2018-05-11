package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.feetEnergy.controller.LoginJdbcDAO;
import com.feetEnergy.controller.ConnectionClass;
import com.feetEnergy.view.TelaPrincipal;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.jar.JarOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnCadastro;

	public Login() {
		setResizable(false);
		setTitle("FeetEnergy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 270);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUser.setBounds(38, 52, 269, 30);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPass.setBounds(38, 128, 269, 30);
		contentPane.add(txtPass);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setForeground(Color.BLACK);
		lblUsurio.setBackground(Color.WHITE);
		lblUsurio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblUsurio.setBounds(38, 22, 69, 30);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSenha.setBounds(38, 93, 69, 30);
		contentPane.add(lblSenha);

		JButton btnFazerLogin = new JButton("Login");
		btnFazerLogin.setBackground(Color.LIGHT_GRAY);
		btnFazerLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnFazerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtUser.getText().isEmpty() || txtPass.getPassword().length == 0) {

					JOptionPane.showMessageDialog(null,"Todos os campos devem estar preenchidos!","Aviso",
							JOptionPane.WARNING_MESSAGE);

				} else {
					Connection con;
					try {
						con = ConnectionClass.getConnection();

						LoginJdbcDAO dao = new LoginJdbcDAO(con);

						if (dao.checkLogin(txtUser.getText(), String.valueOf(txtPass.getPassword()))) {
							new TelaPrincipal().setVisible(true);
							Login.this.dispose();
							con.close();
						} else {
							JOptionPane.showMessageDialog(null, "Login Incorreto!");
						}

					} catch (ClassNotFoundException | SQLException e) {
						JOptionPane.showMessageDialog(null, "Erro na Comunicação com o Banco de Dados!");
						e.printStackTrace();
					}

				}
			}
		});

		btnFazerLogin.setBounds(38, 180, 100, 35);
		contentPane.add(btnFazerLogin);

		btnCadastro = new JButton("Cadastrar-se");
		btnCadastro.setBackground(Color.LIGHT_GRAY);
		btnCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaCadUser tlaCadastro = new TelaCadUser();
				tlaCadastro.setVisible(true);
				Login.this.dispose();
			}
		});
		btnCadastro.setBounds(163, 180, 144, 35);
		contentPane.add(btnCadastro);
	}

}