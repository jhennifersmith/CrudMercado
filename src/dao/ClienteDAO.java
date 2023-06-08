package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import dominio.Cliente;

public class ClienteDAO {

    Connection con;


    public ClienteDAO() {
        ConnectionFactory.getInstancia();
        con = ConnectionFactory.getConexao();
    }

    //create
    public void create(Cliente c, JFrame J){
        PreparedStatement stmt = null;

        try{
            String sql = "INSERT INTO tb_cliente"
                    + " (id_cliente, nm_cliente, telefone, endereco)" 
                    + "VALUES (?, ?, ?, ? )";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getIdCliente());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEndereco());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(J, "Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Cliente não cadastrado, erro: " + e.getMessage());
		}
    }
    
    //read
    public ArrayList<Cliente> Read(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_cliente";
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nm_cliente"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				clientes.add(c);
			}
		} catch(SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return clientes;
	}

  //Método Consultar por descricao
  	public ArrayList<Cliente> ConsultarPorDescricao(String name){
  		PreparedStatement stmt = null;
  		ResultSet rs = null;
  		String sql = "SELECT * FROM tb_cliente WHERE nm_cliente like '%" + name + "%'";
  		ArrayList<Cliente> clientes = new ArrayList<>();
  		try {
  			stmt = con.prepareStatement(sql);
  			rs = stmt.executeQuery();
  			System.out.println("Dados capturados com sucesso!");
  			
  			while(rs.next()) {
  				Cliente c = new Cliente();
  				c.setIdCliente(rs.getInt("id_cliente"));
  				c.setNome(rs.getString("nm_cliente"));
  				c.setTelefone(rs.getString("telefone"));
  				c.setEndereco(rs.getString("endereco"));
  				clientes.add(c);
  			}
  		} catch(SQLException e) {
  			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
  		}
  		return clientes;
  	}
  	
  	//Operação de delete (exclusão)
  	public void excluir(int id) {
  		PreparedStatement stmt = null;
  		String sql = "DELETE FROM tb_cliente WHERE id_cliente = ?";
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
  	public void Alterar(Cliente c) {
  		PreparedStatement stmt;
  		String sql = "UPDATE tb_cliente SET nm_cliente = ?, telefone = ?, endereco = ? WHERE id_cliente = ?";
  		try {
  			stmt = con.prepareStatement(sql);
  			stmt.setString(1, c.getNome());
  			stmt.setString(2, c.getTelefone());
  			stmt.setString(3, c.getEndereco());
  			stmt.setInt(4, c.getIdCliente());
  			stmt.executeUpdate();
  			JOptionPane.showMessageDialog(null, "Cliente Alterado!");
  			
  		}catch(SQLException ex) {
  			JOptionPane.showMessageDialog(null, "Falha ao alterar cliente. Erro: " + ex.getMessage());
  		}
  	}
	

}
