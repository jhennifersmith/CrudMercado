package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import dominio.Funcionario;

public class FuncionarioDAO {

	Connection con;

    public FuncionarioDAO() {
        ConnectionFactory.getInstancia();
        con = ConnectionFactory.getConexao();
    }

    public void create(Funcionario f, JFrame J){
        PreparedStatement stmt = null;

        try{
            String sql = "INSERT INTO tb_funcionario"
                    + " (id_funcionario, nm_funcionario, salario, comissao)" 
                    + "VALUES (?, ?, ?, ? )";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getIdFuncionario());
            stmt.setString(2, f.getNome());
            stmt.setFloat(3, f.getSalario());
            stmt.setFloat(4, f.getComissao());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(J, "Funcionário cadastrado com sucesso!");

        } catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Funcionário não cadastrado, erro: " + e.getMessage());
		}
    }
    
  //read
    public ArrayList<Funcionario> Read(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_funcionario";
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			
			while(rs.next()) {
				Funcionario f = new Funcionario();
				f.setIdFuncionario(rs.getInt("id_funcionario"));
				f.setNome(rs.getString("nm_funcionario"));
				f.setSalario(rs.getFloat("salario"));
				f.setComissao(rs.getFloat("comissao"));
				funcionarios.add(f);
			}
		} catch(SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return funcionarios;
	}

  //Método Consultar por descricao
  	public ArrayList<Funcionario> ConsultarPorDescricao(String name){
  		PreparedStatement stmt = null;
  		ResultSet rs = null;
  		String sql = "SELECT * FROM tb_funcionario WHERE nm_funcionario like '%" + name + "%'";
  		ArrayList<Funcionario> funcionarios = new ArrayList<>();
  		try {
  			stmt = con.prepareStatement(sql);
  			rs = stmt.executeQuery();
  			System.out.println("Dados capturados com sucesso!");
  			
  			while(rs.next()) {
  				Funcionario f = new Funcionario();
  				f.setIdFuncionario(rs.getInt("id_funcionario"));
				f.setNome(rs.getString("nm_funcionario"));
				f.setSalario(rs.getFloat("salario"));
				f.setComissao(rs.getFloat("comissao"));
  				funcionarios.add(f);
  			}
  		} catch(SQLException e) {
  			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
  		}
  		return funcionarios;
  	}
  	
  	//Operação de delete (exclusão)
  	public void excluir(int id) {
  		PreparedStatement stmt = null;
  		String sql = "DELETE FROM tb_funcionario WHERE id_funcionario = ?";
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
  			JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage() + "Código lido: " + id);
  		}
  	}
  	
  	//Método update
  	public void Alterar(Funcionario f) {
  		PreparedStatement stmt;
  		String sql = "UPDATE tb_funcionario SET id_funcionario = ?, nm_funcionario = ?, salario = ?, comissao = ? WHERE id_funcionario = ?";
  		try {
  			stmt = con.prepareStatement(sql);
  			stmt.setInt(1, f.getIdFuncionario());
  			stmt.setString(2, f.getNome());
  			stmt.setFloat(3, f.getSalario());
  			stmt.setFloat(4, f.getComissao());
  			stmt.executeUpdate();
  			JOptionPane.showMessageDialog(null, "Funcionario Alterado!");
  			
  		}catch(SQLException ex) {
  			JOptionPane.showMessageDialog(null, "Falha ao alterar funcionario. Erro: " + ex.getMessage());
  		}
  	}
}
