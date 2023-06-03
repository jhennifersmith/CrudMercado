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
		panel.setBounds(0, 0, 434, 261);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setBounds(10, 37, 77, 14);
		panel.add(lblNewLabel);

		JLabel lblCdigoDeBarras = new JLabel("Código de Barras:");
		lblCdigoDeBarras.setBounds(10, 74, 104, 14);
		panel.add(lblCdigoDeBarras);

		JLabel lblCusto = new JLabel("Custo:");
		lblCusto.setBounds(10, 113, 77, 14);
		panel.add(lblCusto);

		txtDesc = new JTextField();
		txtDesc.setBounds(115, 34, 289, 20);
		panel.add(txtDesc);
		txtDesc.setColumns(10);

		txtCodBarras = new JTextField();
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(115, 71, 289, 20);
		panel.add(txtCodBarras);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(115, 110, 289, 20);
		panel.add(txtPreco);

		JButton btnAlteraProduto = new JButton("Alterar");
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
		txtId.setBounds(115, 187, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 190, 77, 14);
		panel.add(lblId);
	}
}
