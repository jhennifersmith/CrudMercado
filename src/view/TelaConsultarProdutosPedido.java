package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.ProdutoPedidoDAO;
import dominio.ProdutoPedido;

public class TelaConsultarProdutosPedido {

	private JFrame frame;
	private JTextField txtIdPedido;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarProdutosPedido window = new TelaConsultarProdutosPedido();
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
	public TelaConsultarProdutosPedido() {
		initialize();
	}
	
	public JTextField getTxtIdPedido() {
		return txtIdPedido;
	}

	public void setTxtIdPedido(String txtIdPedido) {
		this.txtIdPedido.setText(txtIdPedido);
	}

	private void atualizaBusca() {
		ProdutoPedidoDAO pd = new ProdutoPedidoDAO();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		if (!txtIdPedido.getText().isEmpty()) {
			for (ProdutoPedido pp : pd.ConsultarPorId(Integer.parseInt(txtIdPedido.getText()))) {
				modelo.addRow(new Object[] { pp.getId(), pp.getIdPedido(), pp.getIdProduto(), pp.getPrecoCotado(),
						pp.getQuantidade() });
			}
		} else {
			buscaTodos();
		}

	}

	private void buscaTodos() {
		ProdutoPedidoDAO ppd = new ProdutoPedidoDAO();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (ProdutoPedido pp : ppd.Read()) {
			modelo.addRow(new Object[] { pp.getId(), pp.getIdPedido(), pp.getIdProduto(), pp.getPrecoCotado(),
					pp.getQuantidade() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id do pedido:");
		lblNewLabel.setBounds(10, 24, 67, 14);
		panel.add(lblNewLabel);

		txtIdPedido = new JTextField();
		txtIdPedido.setBounds(87, 21, 337, 20);
		panel.add(txtIdPedido);
		txtIdPedido.setColumns(10);

		JButton btnBuscaPorId = new JButton("Filtrar");
		btnBuscaPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnBuscaPorId.setBounds(335, 52, 89, 23);
		panel.add(btnBuscaPorId);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 87, 434, 217);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 414, 163);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Id", "Id Pedido", "Id Produto", "Preço Cotado", "Quantidade" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.setAutoCreateRowSorter(true);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				int idPedido = (int) table.getValueAt(table.getSelectedRow(), 1);
				int idProduto = (int) table.getValueAt(table.getSelectedRow(), 2);
				Float valorCotado = (float) table.getValueAt(table.getSelectedRow(), 3);
				int quantidade = (int) table.getValueAt(table.getSelectedRow(), 4);
				TelaAlterarProdutoPedido ta = new TelaAlterarProdutoPedido();
				ta.setTextId(Integer.toString(id));
				ta.setTxtIdPedido(Integer.toString(idPedido));
				ta.setTxtIdProduto(Integer.toString(idProduto));
				ta.setTxtValorCotado(Float.toString(valorCotado));
				ta.setTxtQuantidade(Integer.toString(quantidade));
				ta.getFrmTelaAlterar().setVisible(true);

			}
		});
		btnAlterar.setBounds(335, 183, 89, 23);
		panel_1.add(btnAlterar);
		
		JButton btnCadastrarProdutos = new JButton("Cadastrar Produtos");
		btnCadastrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProdutoPedido ta = new CadastrarProdutoPedido();
				ta.setTxtIdPedido(txtIdPedido.getText());
				ta.getFrame().setVisible(true);

			}
		});
		btnCadastrarProdutos.setBounds(20, 183, 175, 23);
		panel_1.add(btnCadastrarProdutos);

	}

	public JFrame getFrame() {
		return frame;
	}
}
