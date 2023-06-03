package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
