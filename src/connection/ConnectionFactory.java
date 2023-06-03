package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	private static String usuario = "root";
	private static String senha = "itix.123";
	private static String url="jdbc:mysql://localhost:3306/mercado" ;
	
	//Atributo que garante a criação de uma única instância
	//Singleton
	private static ConnectionFactory instancia = null;
	
	//Atributo que realiza a conexão com o banco
	private static Connection conexao = null;
	//Construtor vazio
	private ConnectionFactory() {
		conectar();
	}
	
	//Método público que permite o uso de apenas 
	//uma instância da conexão com o banco, 
	//se ainda não houver instância ativa
	//este método cria e retorna pra
	//quem está chamando a instância.
	//Faz parte do padrão singleton
	public static ConnectionFactory getInstancia() {
		if(instancia == null) {
			instancia = new ConnectionFactory();
			conectar();
		}
		return instancia;
	}
	
	//Método que efetivamente conecta com o banco
	private static void conectar() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão bem sucedida!");
		} catch(ClassNotFoundException  | SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public static void desconectar() {
		try {
			conexao.close();
			System.out.println("Desconexão bem sucedida!");
		} catch(SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//Método que irá "pegar" a conexão
	//criada e retornar para quem está chamando
	//Ele que nos permitirá incluir, excluir, alterar...
	public static Connection getConexao() {
		return conexao;
	}
	
	
	
}