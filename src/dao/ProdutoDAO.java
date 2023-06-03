package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import dominio.Produto;

public class ProdutoDAO {
	Connection con;

	public ProdutoDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}

	public void create(Produto p, JFrame J) {
		PreparedStatement stmt = null;

		try {
			String sql = " INSERT INTO tb_produto " + " (id_produto, descricao, codbarras, preco) "
					+ " VALUES (?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getDescricao());
			stmt.setString(3, p.getCodBarras());
			stmt.setFloat(4, p.getPreco());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(J, "Produto cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Produto não cadastrado, erro: " + e.getMessage());
		}
	}
	
	//MÉTODO READ
	public ArrayList<Produto> Read(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_produto";
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setDescricao(rs.getString("descricao"));
				p.setCodBarras(rs.getString("codbarras"));
				p.setPreco(rs.getFloat("preco"));
				produtos.add(p);
			}
		} catch(SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return produtos;
	}
	
	//Método Consultar por descricao
	public ArrayList<Produto> ConsultarPorDescricao(String desc){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_produto WHERE descricao like '%" + desc + "%'";
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setDescricao(rs.getString("descricao"));
				p.setCodBarras(rs.getString("codbarras"));
				p.setPreco(rs.getFloat("preco"));
				produtos.add(p);
			}
		} catch(SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return produtos;
	}
	
	//Operação de delete (exclusão)
	public void excluir(int id) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM tb_produto WHERE id_produto = ?";
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
	public void Alterar(Produto p) {
		PreparedStatement stmt;
		String sql = "UPDATE tb_produto SET descricao = ?, codbarras = ?, preco = ? WHERE id_produto = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getDescricao());
			stmt.setString(2, p.getCodBarras());
			stmt.setFloat(3, p.getPreco());
			stmt.setFloat(4, p.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto Alterado!");
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar produto. Erro: " + ex.getMessage());
		}
	}
}
