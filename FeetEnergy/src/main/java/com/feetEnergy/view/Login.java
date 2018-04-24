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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

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
		setTitle("Fazer Login no FeetEnergy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(126, 65, 150, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(126, 115, 150, 20);
		contentPane.add(txtPass);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(53, 71, 63, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(60, 121, 56, 14);
		contentPane.add(lblSenha);
		
		JButton btnFazerLogin = new JButton("Fazer Login");
		btnFazerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				try {
					con = ConnectionClass.getConnection();
					
					LoginJdbcDAO dao = new LoginJdbcDAO(con);
					
					if(dao.checkLogin(txtUser.getText(), String.valueOf(txtPass.getPassword()))){
				           new TelaPrincipal().setVisible(true);
				           Login.this.dispose();
				       }else{
				           JOptionPane.showMessageDialog(null, "Login Incorreto!");
				       }
		
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}       
				
		});
		
		btnFazerLogin.setBounds(176, 169, 100, 30);
		contentPane.add(btnFazerLogin);
	}
	
	
}