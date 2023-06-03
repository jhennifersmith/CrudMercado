package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import dominio.Produto;

public class TelaCadastroProduto {

	private JFrame frame;
	private JTextField inputId;
	private JTextField inputDesc;
	private JTextField inputCodBarras;
	private JTextField inputPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto window = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cadastro de Produto");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setBounds(10, 0, 108, 34);
		panel.add(lblCadastroProduto);

		JLabel lblIdProduto = new JLabel("Digite o id do produto:");
		lblIdProduto.setBounds(10, 38, 150, 14);
		panel.add(lblIdProduto);

		inputId = new JTextField();
		inputId.setBounds(10, 56, 139, 20);
		panel.add(inputId);
		inputId.setColumns(10);

		JLabel lblDescricao = new JLabel("Digite a descrição:");
		lblDescricao.setBounds(10, 87, 139, 14);
		panel.add(lblDescricao);

		inputDesc = new JTextField();
		inputDesc.setBounds(10, 112, 139, 20);
		panel.add(inputDesc);
		inputDesc.setColumns(10);

		JLabel lblCodBarras = new JLabel("Digite o código de barras:");
		lblCodBarras.setBounds(217, 33, 128, 14);
		panel.add(lblCodBarras);

		inputCodBarras = new JTextField();
		inputCodBarras.setBounds(217, 56, 139, 20);
		panel.add(inputCodBarras);
		inputCodBarras.setColumns(10);

		JLabel lblPreco = new JLabel("Digite o preço:");
		lblPreco.setBounds(217, 97, 139, 14);
		panel.add(lblPreco);

		inputPreco = new JTextField();
		inputPreco.setBounds(217, 112, 139, 20);
		panel.add(inputPreco);
		inputPreco.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = Integer.parseInt(inputId.getText());
				String descricao = inputDesc.getText();
				String codBarras = inputCodBarras.getText();
				Float preco = Float.parseFloat(inputPreco.getText());
				Produto p = new Produto(idProduto, descricao, codBarras, preco);
				ProdutoDAO pd = new ProdutoDAO();
				pd.create(p, frame);
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
