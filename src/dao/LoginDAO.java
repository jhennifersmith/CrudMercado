package dao;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dominio.Login;
import view.TelaPrincipal;
import connection.ConnectionFactory;

public class LoginDAO {
	
	Connection con;

	public LoginDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}
	
	
	public void autenticar(Login l, JFrame j) {
		if(l.getUsername().equals("admin") && l.getSenha().equals("admin")) {
			JOptionPane.showMessageDialog(j, "Autenticação bem-sucedida!");
			TelaPrincipal tp = new TelaPrincipal();
			tp.getFrmTelaPrincipal().setVisible(true);
			j.dispose();
			
		} else {
			JOptionPane.showMessageDialog(j, "usuario ou senha incorretos!");
		}
	}
	
}
