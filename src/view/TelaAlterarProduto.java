package view;

import java.awt.EventQueue;
import dominio.Produto;
import dao.ProdutoDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TelaAlterarProduto {

	private JFrame frmTelaAlterar;
	private JTextField txtDesc;
	private JTextField txtCodBarras;
	private JTextField txtPreco;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarProduto window = new TelaAlterarProduto();
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

	public JTextField getTxtDesc() {
		return txtDesc;
	}

	public void setTxtDesc(String txtDesc) {
		this.txtDesc.setText(txtDesc);
	}

	public JTextField getTxtCodBarras() {
		return txtCodBarras;
	}

	public void setTxtCodBarras(String txtCodBarras) {
		this.txtCodBarras.setText(txtCodBarras);
	}

	public JTextField getTextId() {
		return txtId;
	}

	public void setTextId(String textId) {
		this.txtId.setText(textId);
	}

	public JTextField getTxtCusto() {
		return txtPreco;
	}

	public void setTxtCusto(String txtCusto) {
		this.txtPreco.setText(txtCusto);
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAlterar = new JFrame();
		frmTelaAlterar.setTitle("Alterar Produto");
		frmTelaAlterar.setBounds(100, 100, 450, 299);
		frmTelaAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaAlterar.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 434, 261);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 104, 77, 14);
		panel.add(lblNewLabel);

		JLabel lblCdigoDeBarras = new JLabel("Código de Barras:");
		lblCdigoDeBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCdigoDeBarras.setBounds(21, 139, 104, 14);
		panel.add(lblCdigoDeBarras);

		JLabel lblCusto = new JLabel("Custo:");
		lblCusto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCusto.setBounds(21, 174, 77, 14);
		panel.add(lblCusto);

		txtDesc = new JTextField();
		txtDesc.setBounds(148, 103, 261, 20);
		panel.add(txtDesc);
		txtDesc.setColumns(10);

		txtCodBarras = new JTextField();
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(148, 138, 261, 20);
		panel.add(txtCodBarras);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(148, 173, 261, 20);
		panel.add(txtPreco);

		JButton btnAlteraProduto = new JButton("Alterar");
		btnAlteraProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlteraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				String descricao = txtDesc.getText();
				String codBarras = txtCodBarras.getText();
				float preco = Float.parseFloat(txtPreco.getText());
				Produto p = new Produto(id, descricao, codBarras, preco);
				p.setId(id);
				ProdutoDAO pd = new ProdutoDAO();
				pd.Alterar(p);
				frmTelaAlterar.dispose();
			}
		});
		btnAlteraProduto.setBounds(300, 227, 104, 23);
		panel.add(btnAlteraProduto);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(148, 65, 261, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblId = new JLabel("Identificador:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(21, 66, 77, 14);
		panel.add(lblId);
		
		JLabel lblAlteraoDeProduto = new JLabel("Alteração de Produto");
		lblAlteraoDeProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlteraoDeProduto.setBounds(10, 10, 165, 34);
		panel.add(lblAlteraoDeProduto);
	}
}
