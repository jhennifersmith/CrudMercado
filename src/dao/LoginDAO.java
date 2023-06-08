package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dominio.Login;
import util.Criptografia;
import view.TelaPrincipal;
import connection.ConnectionFactory;

public class LoginDAO {
	
	Connection con;

	public LoginDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}

	//autenticacao
	public void autenticar(Login l, JFrame J) {
		
		validarLogin(l);
		String senhaCriptografada = Criptografia.calcularHash(l.getSenha());
		
		if (senhaCriptografada != null) {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM tb_login WHERE username like '%" + l.getUsername() + "%'";
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				System.out.println("Dados capturados com sucesso!");
				
				if (rs.next()) {
					String senhaBD = rs.getString("senha");
					String userBD = rs.getString("username");
					
					if(l.getUsername().equals(userBD) && senhaCriptografada.equals(senhaBD)) {
						JOptionPane.showMessageDialog(J, "Autenticação bem-sucedida!");
						TelaPrincipal tp = new TelaPrincipal();
						tp.getFrmTelaPrincipal().setVisible(true);
						J.dispose(); 
					}
					else {
						JOptionPane.showMessageDialog(J, "Usuário ou senha incorretos!");
					}	
				}  
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(J, "Login não cadastrado, erro: " + e.getMessage());
			}
		}		
	}
	
	//create
    public void create(Login l, JFrame J){
        PreparedStatement stmt = null;
        
        String senhaCriptografada = Criptografia.calcularHash(l.getSenha());

        try{
            String sql = "INSERT INTO tb_login"
                    + " (id_login, username, senha)" 
                    + "VALUES (?, ?, ?)";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, l.getId());
            stmt.setString(2, l.getUsername());
            stmt.setString(3, senhaCriptografada);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(J, "Login cadastrado com sucesso!");

        } catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Login não cadastrado, erro: " + e.getMessage());
		}
    }
    
    //read
    public ArrayList<Login> Read(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_login";
		ArrayList<Login> logins = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			
			while(rs.next()) {
				Login l = new Login();
				l.setId(rs.getInt("id_login"));
				l.setUsername(rs.getString("username"));
				l.setSenha(rs.getString("senha"));
				logins.add(l);
			}
		} catch(SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return logins;
	}

  //Método Consultar por descricao
  	public ArrayList<Login> ConsultarPorDescricao(String name){
  		PreparedStatement stmt = null;
  		ResultSet rs = null;
  		String sql = "SELECT * FROM tb_login WHERE username like '%" + name + "%'";
  		ArrayList<Login> logins = new ArrayList<>();
  		try {
  			stmt = con.prepareStatement(sql);
  			rs = stmt.executeQuery();
  			System.out.println("Dados capturados com sucesso!");
  			
  			while(rs.next()) {
  				Login l = new Login();
  				l.setId(rs.getInt("id_login"));
  				l.setUsername(rs.getString("username"));
  				l.setSenha(rs.getString("senha"));
  				logins.add(l);
  			}
  		} catch(SQLException e) {
  			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
  		}
  		return logins;
  	}
  	
  	//Operação de delete (exclusão)
  	public void excluir(int id) {
  		PreparedStatement stmt = null;
  		String sql = "DELETE FROM tb_login WHERE id_login = ?";
  		try {
  			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", 
  					"Selecione uma opção", JOptionPane.YES_NO_OPTION);
  			
  			if(confirma == 0) {
  				stmt = con.prepareStatement(sql);
  				stmt.setInt(1, id);
  				stmt.executeUpdate();
  				JOptionPane.showMessageDialog(null, "Dado excluído com sucesso!");
  			} else {
  				JOptionPane.showMessageDialog(null, "Operação cancelada!");
  			}
  			
  		}catch(SQLException ex) {
  			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex.getMessage() + "Código lido: " + id);
  		}
  	}
  	
  	//Método update
  	public void Alterar(Login l) {
  		PreparedStatement stmt;
  		
  		String senhaCriptografada = Criptografia.calcularHash(l.getSenha());
  		
  		try {
  			String sql = "UPDATE tb_login SET username = ?, senha = ? WHERE id_login = ?";
  			stmt = con.prepareStatement(sql);
            stmt.setString(1, l.getUsername());
            stmt.setString(2, senhaCriptografada);
            stmt.setInt(3, l.getId());
  			stmt.executeUpdate();
  			JOptionPane.showMessageDialog(null, "Login Alterado!");
  			
  		}catch(SQLException ex) {
  			JOptionPane.showMessageDialog(null, "Falha ao alterar login. Erro: " + ex.getMessage());
  		}
  	}

  	//validacao
  	private void validarLogin(Login l) {
		if(l.getUsername().isEmpty() || l.getUsername() == null) {
		JOptionPane.showMessageDialog(null, "Login inválido." );
		}
		if(l.getSenha().isEmpty() || l.getSenha() == null) {
		JOptionPane.showMessageDialog(null, "Login inválido." );
		}
	}

  	
	
}
