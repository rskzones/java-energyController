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

public class TelaCadUser extends JFrame {

	private JPanel contentPane;

	User user = new User();
	private JPasswordField pswPass;
	private JPasswordField pswConfirmaPass;

	public TelaCadUser() {
		setTitle("FeetEnergy - Criação de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("Nome de Usuário:");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUser.setBounds(20, 93, 113, 25);
		contentPane.add(lblUser);

		JLabel lblDigiteUmaSenha = new JLabel("Senha:");
		lblDigiteUmaSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDigiteUmaSenha.setBounds(20, 152, 51, 25);
		contentPane.add(lblDigiteUmaSenha);

		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha:");
		lblConfirmeASenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConfirmeASenha.setBounds(20, 207, 113, 25);
		contentPane.add(lblConfirmeASenha);

		final JTextField txtUser = new JTextField();
		txtUser.setBounds(20, 115, 200, 25);
		contentPane.add(txtUser);
		
		pswPass = new JPasswordField();
		pswPass.setBounds(20, 175, 200, 23);
		contentPane.add(pswPass);
		
		pswConfirmaPass = new JPasswordField();
		pswConfirmaPass.setBounds(20, 231, 200, 23);
		contentPane.add(pswConfirmaPass);

		JLabel lblCriacaoUsuario = new JLabel("Cadastro de Usuario");
		lblCriacaoUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblCriacaoUsuario.setBounds(33, 51, 166, 33);
		contentPane.add(lblCriacaoUsuario);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int cadastro = JOptionPane.showConfirmDialog(null, "Deseja Cadastrar?", "Cadastro de Usuário",
						JOptionPane.YES_NO_OPTION);
				if (cadastro == 0) {
					
					if(txtUser.getText().isEmpty() || pswPass.getPassword().length == 0 || pswConfirmaPass.getPassword().length == 0) {
						JOptionPane.showMessageDialog(null, "Todos os Campos devem estar preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);	
					}
					else {
						if(String.valueOf(pswPass.getPassword()).equals(String.valueOf(pswConfirmaPass.getPassword()))) {
							
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
							
							JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
							
							}catch (Exception e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "Erro na Comunicação com o Banco de Dados!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "As senhas não condizem!", "Aviso!", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				/*
				 * if(cadastro == JOptionPane.YES_OPTION) {
				 * 
				 * this.user.setUser(this.txtUser.getText());
				 * this.user.setPass(String.valueOf(txtPass.getText()));
				 * 
				 * }
				 */
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(69, 277, 100, 40);
		contentPane.add(btnCadastrar);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 819, 40);
		contentPane.add(toolBar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 11));
		/*btnVoltar.setIcon(
				new ImageIcon(TelaCadUser.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));*/
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login().setVisible(true);
		        TelaCadUser.this.dispose();
			}
		});
		toolBar.add(btnVoltar);

	}
}
