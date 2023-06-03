package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			stmt.setFloat(5, valorTotal);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(J, "Produto Pedido cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(J, "Produto Pedido não cadastrado, erro: " + e.getMessage());
		}

	}
}
