package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ProdutoPedidoDAO;
import dominio.ProdutoPedido;

public class CadastrarProdutoPedido {

	private JFrame frame;
	private JTextField inputId;
	private JTextField inputIdProduto;
	private JTextField inputQuantidade;
	private JTextField txtIdPedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProdutoPedido window = new CadastrarProdutoPedido();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTextField getTxtIdPedido() {
		return txtIdPedido;
	}

	public void setTxtIdPedido(String txtIdPedido) {
		this.txtIdPedido.setText(txtIdPedido);
	}

	/**
	 * Create the application.
	 */
	public CadastrarProdutoPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cadastro de Produto Pedido");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProdutoPedido = new JLabel("Cadastro  de produto no pedido");
		lblCadastroProdutoPedido.setBounds(107, 11, 264, 34);
		panel.add(lblCadastroProdutoPedido);

		inputId = new JTextField();
		inputId.setBounds(31, 85, 139, 20);
		panel.add(inputId).setVisible(false);;
		inputId.setColumns(10);

		JLabel lblIdPedido = new JLabel("Id do pedido:");
		lblIdPedido.setBounds(20, 124, 139, 14);
		panel.add(lblIdPedido);

		txtIdPedido = new JTextField();
		txtIdPedido.setEditable(false);
		txtIdPedido.setBounds(20, 149, 139, 20);
		panel.add(txtIdPedido);
		txtIdPedido.setColumns(10);

		JLabel lblIdProduto = new JLabel("Digite o id do produto:");
		lblIdProduto.setBounds(20, 56, 139, 14);
		panel.add(lblIdProduto);

		inputIdProduto = new JTextField();
		inputIdProduto.setBounds(20, 81, 139, 20);
		panel.add(inputIdProduto);
		inputIdProduto.setColumns(10);

		JLabel lblQuantidade = new JLabel("Digite a quantidade: ");
		lblQuantidade.setBounds(218, 56, 150, 14);
		panel.add(lblQuantidade);

		inputQuantidade = new JTextField();
		inputQuantidade.setBounds(204, 81, 139, 20);
		panel.add(inputQuantidade);
		inputQuantidade.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProdutoPedido = 0;
				int idPedido = Integer.parseInt(txtIdPedido.getText());
				int idProduto = Integer.parseInt(inputIdProduto.getText());
				int quantidade = Integer.parseInt(inputQuantidade.getText());
				Float precoCotado = (float) 0;
				ProdutoPedido pp = new ProdutoPedido(idProdutoPedido, idPedido, idProduto, quantidade, precoCotado);
				ProdutoPedidoDAO ppd = new ProdutoPedidoDAO();
				ppd.create(pp, frame);
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(146, 191, 110, 23);
		panel.add(btnCadastrar);

	}
	
	public JFrame getFrame() {
		return frame;
	}

}
