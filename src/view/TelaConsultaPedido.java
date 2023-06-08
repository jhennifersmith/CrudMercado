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

import dao.PedidoDAO;
import dominio.Pedido;
import java.awt.Color;
import java.awt.Font;

public class TelaConsultaPedido {

	private JFrame frame;
	private JTextField txtId = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaPedido window = new TelaConsultaPedido();
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
	public TelaConsultaPedido() {
		initialize();
	}

	private void atualizaBusca() {
		PedidoDAO pd = new PedidoDAO();
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setNumRows(0);
		if (!txtId.getText().isEmpty()) {
			for(Pedido p: pd.ConsultarPorId(Integer.parseInt(txtId.getText()))) {
				modelo.addRow(new Object[] {
						p.getId(),
						p.getIdCliente(),
						p.getIdFuncionario(),
						p.getValorTotal()
				});
			}
		}
		else {
			buscaTodos();
		}

	}

	private void buscaTodos() {
		PedidoDAO pd = new PedidoDAO();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		for (Pedido p : pd.Read()) {
			modelo.addRow(new Object[] { p.getId(), p.getIdCliente(), p.getIdFuncionario(), p.getValorTotal() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 434, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id do pedido:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 24, 119, 14);
		panel.add(lblNewLabel);

		txtId = new JTextField();
		txtId.setBounds(139, 21, 285, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JButton btnBuscaPorId = new JButton("Filtrar");
		btnBuscaPorId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscaPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnBuscaPorId.setBounds(335, 52, 89, 23);
		panel.add(btnBuscaPorId);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 87, 434, 217);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 414, 163);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Id", "Id Cliente", "Id Funcionario", "Valor Total" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.setAutoCreateRowSorter(true);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				PedidoDAO pd = new PedidoDAO();
				pd.excluir(id);
				buscaTodos();
			}
		});
		btnExcluir.setBounds(335, 183, 89, 23);
		panel_1.add(btnExcluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				int idCliente = (int) table.getValueAt(table.getSelectedRow(), 1);
				int idFuncionario = (int) table.getValueAt(table.getSelectedRow(), 2);
				TelaAlterarPedido ta = new TelaAlterarPedido();
				ta.setTextId(Integer.toString(id));
				ta.setTextIdFuncionario(Integer.toString(idCliente));
				ta.setTextIdCliente(Integer.toString(idFuncionario));
				ta.getFrmTelaAlterar().setVisible(true);

			}
		});
		btnAlterar.setBounds(236, 183, 89, 23);
		panel_1.add(btnAlterar);
		
		JButton btnAlterarProdutos = new JButton("Alterar produtos do pedido");
		btnAlterarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				TelaConsultarProdutosPedido taa = new TelaConsultarProdutosPedido();
				taa.setTxtIdPedido(Integer.toString(id));
				taa.getFrame().setVisible(true);

			}
		});
		btnAlterarProdutos.setBounds(20, 183, 188, 23);
		panel_1.add(btnAlterarProdutos);
	}

	public JFrame getFrame() {
		return frame;
	}
}
