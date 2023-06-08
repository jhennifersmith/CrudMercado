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
import java.awt.Font;
import java.awt.Color;

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
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setTitle("Cadastro de Produto");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroProduto.setBounds(10, 10, 139, 34);
		panel.add(lblCadastroProduto);

		inputId = new JTextField();
		inputId.setBounds(10, 56, 139, 20);
		panel.add(inputId).setVisible(false);;
		inputId.setColumns(10);

		JLabel lblDescricao = new JLabel("Digite a descrição:");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescricao.setBounds(10, 111, 139, 14);
		panel.add(lblDescricao);

		inputDesc = new JTextField();
		inputDesc.setBounds(10, 135, 139, 20);
		panel.add(inputDesc);
		inputDesc.setColumns(10);

		JLabel lblCodBarras = new JLabel("Digite o código de barras:");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodBarras.setBounds(10, 58, 160, 14);
		panel.add(lblCodBarras);

		inputCodBarras = new JTextField();
		inputCodBarras.setBounds(10, 81, 139, 20);
		panel.add(inputCodBarras);
		inputCodBarras.setColumns(10);

		JLabel lblPreco = new JLabel("Digite o preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPreco.setBounds(217, 111, 139, 14);
		panel.add(lblPreco);

		inputPreco = new JTextField();
		inputPreco.setBounds(217, 135, 139, 20);
		panel.add(inputPreco);
		inputPreco.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = 0;
				String descricao = inputDesc.getText();
				String codBarras = inputCodBarras.getText();
				Float preco = Float.parseFloat(inputPreco.getText());
				Produto p = new Produto(idProduto, descricao, codBarras, preco);
				ProdutoDAO pd = new ProdutoDAO();
				pd.create(p, frame);
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(10, 174, 89, 23);
		panel.add(btnCadastrar);

	}

	public JFrame getFrame() {
		return frame;
	}
}
