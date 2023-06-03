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
	private JTextField inputIdPedido;
	private JTextField inputIdProduto;
	private JTextField inputQuantidade;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProdutoPedido = new JLabel("Cadastro Produto Pedido");
		lblCadastroProdutoPedido.setBounds(10, 0, 192, 34);
		panel.add(lblCadastroProdutoPedido);

		JLabel lblIdProdutoPedido = new JLabel("Digite o id do produto pedido:");
		lblIdProdutoPedido.setBounds(10, 38, 150, 14);
		panel.add(lblIdProdutoPedido);

		inputId = new JTextField();
		inputId.setBounds(10, 56, 139, 20);
		panel.add(inputId);
		inputId.setColumns(10);

		JLabel lblIdPedido = new JLabel("Digite o Id do Pedido:");
		lblIdPedido.setBounds(10, 87, 139, 14);
		panel.add(lblIdPedido);

		inputIdPedido = new JTextField();
		inputIdPedido.setBounds(10, 108, 139, 20);
		panel.add(inputIdPedido);
		inputIdPedido.setColumns(10);

		JLabel lblIdProduto = new JLabel("Digite o id do produto:");
		lblIdProduto.setBounds(218, 39, 139, 14);
		panel.add(lblIdProduto);

		inputIdProduto = new JTextField();
		inputIdProduto.setBounds(218, 61, 139, 20);
		panel.add(inputIdProduto);
		inputIdProduto.setColumns(10);

		JLabel lblQuantidade = new JLabel("Digite a quantidade: ");
		lblQuantidade.setBounds(218, 91, 150, 14);
		panel.add(lblQuantidade);

		inputQuantidade = new JTextField();
		inputQuantidade.setBounds(218, 108, 139, 20);
		panel.add(inputQuantidade);
		inputQuantidade.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProdutoPedido = Integer.parseInt(inputId.getText());
				int idPedido = Integer.parseInt(inputIdPedido.getText());
				int idProduto = Integer.parseInt(inputIdProduto.getText());
				int quantidade = Integer.parseInt(inputQuantidade.getText());
				Float precoCotado = (float) 0;
				ProdutoPedido pp = new ProdutoPedido(idProdutoPedido, idPedido, idProduto, quantidade, precoCotado);
				ProdutoPedidoDAO ppd = new ProdutoPedidoDAO();
				ppd.create(pp, frame);
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(10, 143, 89, 23);
		panel.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(132, 143, 89, 23);
		panel.add(btnVoltar);

	}

}
