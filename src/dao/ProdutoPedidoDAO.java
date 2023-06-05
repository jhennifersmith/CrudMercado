package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import dominio.ProdutoPedido;

public class ProdutoPedidoDAO {
	Connection con;
	Float valorTotal;
	Float valorTotalPedido;

	public ProdutoPedidoDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}

	public void create(ProdutoPedido pd, JFrame J) {
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		ResultSet resultSet = null;

		try {
			String sql = " INSERT INTO tb_produto_pedido "
					+ " (id_produto_pedido, id_pedido, id_produto, quantidade, preco_cotado) "
					+ " VALUES (?,?,?,?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pd.getId());
			stmt.setInt(2, pd.getIdPedido());
			stmt.setInt(3, pd.getIdProduto());
			stmt.setInt(4, pd.getQuantidade());
			try {
				String sql2 = " SELECT preco FROM tb_produto WHERE id_produto = ? ";
				stmt2 = con.prepareStatement(sql2);
				stmt2.setInt(1, pd.getIdProduto());
				resultSet = stmt2.executeQuery();
				if (resultSet.next()) {
					Float valorProduto = resultSet.getFloat("preco");
					valorTotal = valorProduto * pd.getQuantidade();
				}
				JOptionPane.showMessageDialog(J, "Valor total Calculado!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(J, "Produto Pedido não calculado, erro: " + e.getMessage());
			}
			stmt.setFloat(5, valorTotal);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(J, "Produto Pedido cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Produto Pedido não cadastrado, erro: " + e.getMessage());
		}

		try {
			String sql3 = " SELECT SUM(preco_cotado) AS soma_total FROM tb_produto_pedido WHERE id_pedido = ? ";
			stmt3 = con.prepareStatement(sql3);
			stmt3.setInt(1, pd.getIdPedido());
			resultSet = stmt3.executeQuery();
			if (resultSet.next()) {
				Float valorCotadoTotalPedido = resultSet.getFloat("soma_total");
				valorTotalPedido = valorCotadoTotalPedido;
			}
			JOptionPane.showMessageDialog(J, "Valor total do pedido calculado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Valor total do pedido não calculado, erro: " + e.getMessage());
		}
		try {
			String sql4 = " UPDATE tb_pedido " + " SET valor_total " + " = ? " + " WHERE id_pedido = ? ";
			stmt4 = con.prepareStatement(sql4);
			stmt4.setFloat(1, valorTotalPedido);
			stmt4.setInt(2, pd.getIdPedido());
			stmt4.executeUpdate();
			JOptionPane.showMessageDialog(J, "Valor total do pedido cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Valor total do pedido não atualizado, erro: " + e.getMessage());
		}

	}

	// Método update
	public void Alterar(ProdutoPedido pp) {
		PreparedStatement stmt;
		PreparedStatement stmt2;
		PreparedStatement stmt3;
		PreparedStatement stmt4;
		ResultSet resultSet = null;
		String sql = "UPDATE tb_produto_pedido SET id_produto = ?, quantidade = ?, preco_cotado = ? WHERE id_produto_pedido = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pp.getIdProduto());
			stmt.setInt(2, pp.getQuantidade());
			try {
				String sql2 = " SELECT preco FROM tb_produto WHERE id_produto = ? ";
				stmt2 = con.prepareStatement(sql2);
				stmt2.setInt(1, pp.getIdProduto());
				resultSet = stmt2.executeQuery();
				if (resultSet.next()) {
					Float valorProduto = resultSet.getFloat("preco");
					valorTotal = valorProduto * pp.getQuantidade();
				}
				JOptionPane.showMessageDialog(null, "Valor cotado calculado!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Valor cotado calculado!" + e.getMessage());
			}
			stmt.setFloat(3, valorTotal);
			stmt.setInt(4, pp.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto pedido Alterado!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar produto pedido. Erro: " + ex.getMessage());
		}

		try {
			String sql3 = " SELECT SUM(preco_cotado) AS soma_total FROM tb_produto_pedido WHERE id_pedido = ? ";
			stmt3 = con.prepareStatement(sql3);
			stmt3.setInt(1, pp.getIdPedido());
			resultSet = stmt3.executeQuery();
			if (resultSet.next()) {
				Float valorCotadoTotalPedido = resultSet.getFloat("soma_total");
				valorTotalPedido = valorCotadoTotalPedido;
			}
			JOptionPane.showMessageDialog(null, "Valor total calculado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Valor total do pedido não calculado, erro: " + e.getMessage());
		}
		try {
			String sql4 = " UPDATE tb_pedido " + " SET valor_total " + " = ? " + " WHERE id_pedido = ? ";
			stmt4 = con.prepareStatement(sql4);
			stmt4.setFloat(1, valorTotalPedido);
			stmt4.setInt(2, pp.getIdPedido());
			stmt4.executeUpdate();
			JOptionPane.showMessageDialog(null, "Valor total do pedido cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Valor total do pedido não atualizado, erro: " + e.getMessage());
		}
	}

	// MÉTODO READ
	public ArrayList<ProdutoPedido> Read() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT  * FROM tb_produto_pedido";
		ArrayList<ProdutoPedido> produtosPedidos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");

			while (rs.next()) {
				ProdutoPedido p = new ProdutoPedido();
				p.setId(rs.getInt("id_produto_pedido"));
				p.setIdPedido(rs.getInt("id_pedido"));
				p.setIdProduto(rs.getInt("id_produto"));
				p.setPrecoCotado(rs.getFloat("preco_cotado"));
				p.setQuantidade(rs.getInt("quantidade"));
				produtosPedidos.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return produtosPedidos;
	}

	// Método Consultar por id
	public ArrayList<ProdutoPedido> ConsultarPorId(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_produto_pedido WHERE id_pedido = ?";
		ArrayList<ProdutoPedido> produtosPedidos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");

			while (rs.next()) {
				ProdutoPedido p = new ProdutoPedido();
				p.setId(rs.getInt("id_produto_pedido"));
				p.setIdPedido(rs.getInt("id_pedido"));
				p.setIdProduto(rs.getInt("id_produto"));
				p.setPrecoCotado(rs.getFloat("preco_cotado"));
				p.setQuantidade(rs.getInt("quantidade"));
				produtosPedidos.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Falha ao consultar dados erro: " + e.getLocalizedMessage());
		}
		return produtosPedidos;
	}

	// Operação de delete (exclusão)
	public void excluir(int id) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM tb_produto_pedido WHERE id_produto_pedido = ?";
		try {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Selecione uma opção",
					JOptionPane.YES_NO_OPTION);

			if (confirma == 0) {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dado excluído com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Operação cancelada!");
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage() + "Código lido: " + id);
		}
	}
}
