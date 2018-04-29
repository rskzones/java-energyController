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
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("FeetEnergy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUser.setBounds(38, 51, 200, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPass.setBounds(38, 114, 200, 20);
		contentPane.add(txtPass);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsurio.setBounds(38, 22, 69, 30);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenha.setBounds(38, 82, 69, 30);
		contentPane.add(lblSenha);
		
		JButton btnFazerLogin = new JButton("Login");
		btnFazerLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				try {
					con = ConnectionClass.getConnection();
					
					LoginJdbcDAO dao = new LoginJdbcDAO(con);
					
					if(txtUser.getText().isEmpty() || txtPass.getPassword().length == 0){
						JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!","Aviso", JOptionPane.WARNING_MESSAGE);
					}else{
						if(dao.checkLogin(txtUser.getText(), String.valueOf(txtPass.getPassword()))){
							new TelaPrincipal().setVisible(true);
					        Login.this.dispose();
					    }else{
					    	JOptionPane.showMessageDialog(null, "Login Incorreto!");
					    }
					}
		
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro na Comunicação com o Banco de Dados!");
					e.printStackTrace();
				}
			}       
				
		});
		
		btnFazerLogin.setBounds(38, 160, 83, 30);
		contentPane.add(btnFazerLogin);
		
		btnCadastro = new JButton("Cadastrar-se");
		btnCadastro.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadUser tlaCadastro = new TelaCadUser();
				tlaCadastro.setVisible(true);
				Login.this.dispose();	
			}
		});
		btnCadastro.setBounds(131, 160, 107, 30);
		contentPane.add(btnCadastro);
	}
	
	
}