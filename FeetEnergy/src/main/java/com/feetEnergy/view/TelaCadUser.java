package com.feetEnergy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.feetEnergy.controller.CadastroJdbcDAO;
import com.feetEnergy.controller.ConnectionClass;
import com.feetEnergy.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class TelaCadUser extends JFrame {

	private JPanel contentPane;

	User user = new User();
	private JPasswordField pswPass;
	private JPasswordField pswConfirmaPass;

	public TelaCadUser() {
		setResizable(false);
		setTitle("Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("Nome de Usuário:");
		lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblUser.setBounds(20, 70, 140, 25);
		contentPane.add(lblUser);

		JLabel lblDigiteUmaSenha = new JLabel("Senha:");
		lblDigiteUmaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDigiteUmaSenha.setBounds(20, 142, 100, 25);
		contentPane.add(lblDigiteUmaSenha);

		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha:");
		lblConfirmeASenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblConfirmeASenha.setBounds(20, 212, 140, 25);
		contentPane.add(lblConfirmeASenha);

		final JTextField txtUser = new JTextField();
		txtUser.setBounds(20, 106, 235, 25);
		contentPane.add(txtUser);

		pswPass = new JPasswordField();
		pswPass.setBounds(20, 178, 235, 23);
		contentPane.add(pswPass);

		pswConfirmaPass = new JPasswordField();
		pswConfirmaPass.setBounds(20, 248, 235, 23);
		contentPane.add(pswConfirmaPass);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtUser.getText().isEmpty() || pswPass.getPassword().length == 0
						|| pswConfirmaPass.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Todos os Campos devem estar preenchidos!", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (String.valueOf(pswPass.getPassword()).equals(String.valueOf(pswConfirmaPass.getPassword()))) {
						int cadastro = JOptionPane.showConfirmDialog(null, "Deseja Cadastrar?", "Cadastro de Usuário",
								JOptionPane.YES_NO_OPTION);

						if (cadastro == 0) {
							User user = new User();
							try {
								user.setUser(txtUser.getText());
								user.setPass(String.valueOf(pswPass.getPassword()));

								Connection con = ConnectionClass.getConnection();
								CadastroJdbcDAO dao = new CadastroJdbcDAO(con);

								dao.Salvar(user);

								txtUser.setText(null);
								pswPass.setText(null);
								pswConfirmaPass.setText(null);

								user.setUser("");
								user.setPass("");

								JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");

							} catch (Exception e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "Erro na Comunicação com o Banco de Dados!", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							txtUser.setText(null);
							pswPass.setText(null);
							pswConfirmaPass.setText(null);
						}
					} else {
						JOptionPane.showMessageDialog(null, "As senhas não condizem!", "Aviso!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCadastrar.setBounds(155, 298, 100, 40);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login tlaLogin = new Login();
				tlaLogin.setVisible(true);
				TelaCadUser.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(20, 298, 100, 39);
		contentPane.add(btnVoltar);

		JLabel lblCadastro = new JLabel("Cadastrar Usuário");
		lblCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCadastro.setBounds(20, 11, 235, 35);
		contentPane.add(lblCadastro);

	}
}
