package dao;

import java.sql.Connection;

import connection.ConnectionFactory;

public class LoginDAO {
	
	Connection con;

	public LoginDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}
	
}
