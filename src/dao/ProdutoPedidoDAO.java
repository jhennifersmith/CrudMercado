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
	
	public ProdutoPedidoDAO() {
		ConnectionFactory.getInstancia();
		con = ConnectionFactory.getConexao();
	}
	
	public void create(ProdutoPedido pd, JFrame J) {
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
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
	}
}
