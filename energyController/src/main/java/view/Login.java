package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;

public class Login extends JFrame{
		
	private JLabel lblUser = new JLabel();
	private JLabel lblSenha = new JLabel();
	
	private JButton btnLogin = new JButton();
	
	private JTextField txtUser = new JTextField();
	private JPasswordField txtSenha = new JPasswordField();
	
	public Login() {
		super("Login");
		
		Container pane = this.getContentPane();
		
		pane.add(lblUser);
		lblUser.setBounds(50, 30, 150, 50);
		lblUser.setText("Nome de Usuario: ");
		
		pane.add(lblSenha);
		lblSenha.setBounds(50, 90, 150, 50);
		lblSenha.setText("Senha: ");
		
		pane.add(txtUser);
		txtUser.setBounds(180, 40, 200, 30);
		
		pane.add(txtSenha);
		txtSenha.setBounds(180, 100, 200, 30);
		
		pane.add(btnLogin);
		btnLogin.setText("Fazer Login");
		btnLogin.setBounds(280, 180, 100, 50);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUserName(txtUser.getText());
				user.setPassUser(txtSenha.getPassword());
				
				TelaPrincipal tlaPrincipal = new TelaPrincipal();
				tlaPrincipal.setVisible(true);
				Login.this.setVisible(false);
				
			}
		});
		
		pane.setLayout(null);
		this.setVisible(true);
		this.setSize(450, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
}
