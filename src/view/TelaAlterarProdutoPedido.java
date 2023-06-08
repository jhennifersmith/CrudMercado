package view;

import java.awt.EventQueue;
import dominio.ProdutoPedido;
import dao.ProdutoPedidoDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TelaAlterarProdutoPedido {

	private JFrame frmTelaAlterar;
	private JTextField txtIdPedido;
	private JTextField txtIdProduto;
	private JTextField txtQuantidade;
	private JTextField txtId;
	private JTextField txtValorCotado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarProdutoPedido window = new TelaAlterarProdutoPedido();
					window.frmTelaAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrmTelaDeAlterar() {
		return frmTelaAlterar;
	}

	public JFrame getFrmTelaAlterar() {
		return frmTelaAlterar;
	}

	public void setFrmTelaAlterar(JFrame frmTelaAlterar) {
		this.frmTelaAlterar = frmTelaAlterar;
	}

	public JTextField getTxtIdProduto() {
		return txtIdProduto;
	}

	public void setTxtIdProduto(String txtIdProduto) {
		this.txtIdProduto.setText(txtIdProduto);
	}
	
	public JTextField getTxtIdPedido() {
		return txtIdPedido;
	}

	public void setTxtIdPedido(String txtIdPedido) {
		this.txtIdPedido.setText(txtIdPedido);
	}
	
	public JTextField getTxtValorCotado() {
		return txtValorCotado;
	}

	public void setTxtValorCotado(String txtValorCotado) {
		this.txtValorCotado.setText(txtValorCotado);
	}

	public JTextField getQuantidade() {
		return txtQuantidade;
	}
	
	public void setTxtQuantidade(String txtQuantidade) {
		this.txtQuantidade.setText(txtQuantidade);
	}

	public JTextField getTextId() {
		return txtId;
	}

	public void setTextId(String textId) {
		this.txtId.setText(textId);
	}



	/**
	 * Create the application.
	 */
	public TelaAlterarProdutoPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAlterar = new JFrame();
		frmTelaAlterar.setTitle("Alterar Produto Pedido");
		frmTelaAlterar.setBounds(100, 100, 450, 299);
		frmTelaAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaAlterar.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 434, 261);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIdProduto = new JLabel("Id Produto:");
		lblIdProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdProduto.setBounds(28, 102, 77, 14);
		panel.add(lblIdProduto);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantidade.setBounds(28, 144, 104, 14);
		panel.add(lblQuantidade);

		txtIdProduto = new JTextField();
		txtIdProduto.setBounds(142, 101, 130, 20);
		panel.add(txtIdProduto);
		txtIdProduto.setColumns(10);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(142, 143, 130, 20);
		panel.add(txtQuantidade);
		
		txtIdPedido = new JTextField();
		txtIdPedido.setEditable(false);
		txtIdPedido.setColumns(10);
		txtIdPedido.setBounds(115, 121, 289, 20);
		panel.add(txtIdPedido).setVisible(false);
		
		txtValorCotado = new JTextField();
		txtValorCotado.setEditable(false);
		txtValorCotado.setColumns(10);
		txtValorCotado.setBounds(115, 156, 289, 20);
		panel.add(txtValorCotado).setVisible(false);;

		JButton btnAlteraProduto = new JButton("Alterar");
		btnAlteraProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlteraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				int idProduto = Integer.parseInt(txtIdProduto.getText());
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				int idPedido = Integer.parseInt(txtIdPedido.getText());
				Float precoCotado = Float.parseFloat(txtValorCotado.getText());
				ProdutoPedido pp = new ProdutoPedido(id, idPedido, idProduto, quantidade, precoCotado);
				pp.setId(id);
				ProdutoPedidoDAO ppd = new ProdutoPedidoDAO();
				ppd.Alterar(pp);
				frmTelaAlterar.dispose();
			}
		});
		btnAlteraProduto.setBounds(28, 202, 104, 23);
		panel.add(btnAlteraProduto);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(142, 54, 130, 19);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblId = new JLabel("Identificador:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(28, 55, 77, 14);
		panel.add(lblId);
		
		JLabel lblAlteraoDeCliente = new JLabel("Alteração de Produto no Pedido");
		lblAlteraoDeCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlteraoDeCliente.setBounds(10, 10, 223, 34);
		panel.add(lblAlteraoDeCliente);
	}
}
