package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import dominio.Pedido;
import dominio.Produto;


public class PedidoDAO extends Produto {
	Connection con;

	public PedidoDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}
	
	public void create(Pedido p, JFrame J) {
		PreparedStatement stmt = null;

		try {
			String sql = " INSERT INTO tb_pedido "
					+ " (id_pedido, valor_total, data_pedido, id_cliente, id_funcionario) "
					+ " VALUES (?,?,?,?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setFloat(2, p.getValorTotal());
			stmt.setString(3, p.getDataPedido().toString());
			stmt.setInt(4, p.getIdCliente());
			stmt.setInt(5, p.getIdFuncionario());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(J, "Pedido cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Pedido não cadastrado, erro: " + e.getMessage());
		}
	}
	
	//MÉTODO READ
		public ArrayList<Pedido> Read(){
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM tb_pedido" 
					+ " INNER JOIN tb_produto_pedido on tb_pedido.id_pedido = tb_produto_pedido.id_pedido "
					+ " INNER JOIN tb_produto on tb_produto_pedido.id_produto = tb_produto.id_produto ";
			ArrayList<Pedido> pedidos = new ArrayList<>();
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				System.out.println("Dados capturados com sucesso!");
				
				while(rs.next()) {
					Pedido p = new Pedido();
					p.setId(rs.getInt("id_pedido"));
					p.setIdCliente(rs.getInt("id_cliente"));
					p.setIdFuncionario(rs.getInt("id_cliente"));
					p.setValorTotal(rs.getFloat("valor_total"));
					
					pedidos.add(p);
				}
			} catch(SQLException e) {
				System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
			}
			return pedidos;
		}
		//Método Consultar por id
		public ArrayList<Pedido> ConsultarPorId(int id){
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM tb_pedido WHERE id_pedido = ?";
			ArrayList<Pedido> pedidos = new ArrayList<>();
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				System.out.println("Dados capturados com sucesso!");
				
				while(rs.next()) {
					Pedido p = new Pedido();
					p.setId(rs.getInt("id_pedido"));
					p.setIdCliente(rs.getInt("id_cliente"));
					p.setIdFuncionario(rs.getInt("id_cliente"));
					p.setValorTotal(rs.getFloat("valor_total"));
					pedidos.add(p);
				}
			} catch(SQLException e) {
				System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
			}
			return pedidos;
		}
		
		//Operação de delete (exclusão)
		public void excluir(int id) {
			PreparedStatement stmt = null;
			String sql = "DELETE FROM tb_pedido WHERE id_pedido = ?";
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
		public void Alterar(Pedido p) {
			PreparedStatement stmt;
			String sql = "UPDATE tb_pedido SET id_cliente = ?, id_funcionario = ? WHERE id_produto = ?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, p.getIdCliente());
				stmt.setInt(2, p.getIdFuncionario());
				stmt.setInt(3, p.getId());
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Pedido Alterado!");
				
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Falha ao alterar pedido. Erro: " + ex.getMessage());
			}
		}
}
