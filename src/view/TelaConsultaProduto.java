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
import dao.ProdutoDAO;
import dominio.Produto;

public class TelaConsultaProduto {

	private JFrame frame;
	private JTextField txtDesc;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaProduto window = new TelaConsultaProduto();
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
	public TelaConsultaProduto() {
		initialize();
	}
	
	private void atualizaBusca() {
		ProdutoDAO pd = new ProdutoDAO();
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setNumRows(0);
		for(Produto p: pd.ConsultarPorDescricao(txtDesc.getText())) {
			modelo.addRow(new Object[] {
					p.getDescricao(),
					p.getCodBarras(),
					p.getPreco(),
					p.getId()
			});
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setBounds(10, 24, 67, 14);
		panel.add(lblNewLabel);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(87, 21, 337, 20);
		panel.add(txtDesc);
		txtDesc.setColumns(10);
		
		
		JButton btnBuscaPorDescricao = new JButton("Filtrar");
		btnBuscaPorDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();				
			}
		});
		btnBuscaPorDescricao.setBounds(335, 52, 89, 23);
		panel.add(btnBuscaPorDescricao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 87, 434, 217);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 414, 163);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Descricao", "Codigo de Barras", "Custo", "Id"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.setAutoCreateRowSorter(true);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =  (int) table.getValueAt(table.getSelectedRow(), 3);
				ProdutoDAO pd = new ProdutoDAO();
				pd.excluir(id);
				atualizaBusca();
			}
		});
		btnExcluir.setBounds(335, 183, 89, 23);
		panel_1.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao = (String)table.getValueAt(table.getSelectedRow(), 0);
				String codBarras = (String)table.getValueAt(table.getSelectedRow(), 1);
				float custo = (float)table.getValueAt(table.getSelectedRow(), 2);
				int id = (int)table.getValueAt(table.getSelectedRow(), 3);
				TelaAlterarProduto ta = new TelaAlterarProduto();
				ta.setTxtDesc(descricao);
				ta.setTxtCodBarras(codBarras);
				ta.setTxtCusto(Float.toString(custo));
				ta.setTextId(Integer.toString(id));
				ta.getFrmTelaAlterar().setVisible(true);
				
			}
		});
		btnAlterar.setBounds(236, 183, 89, 23);
		panel_1.add(btnAlterar);
	}

	public JFrame getFrame() {
		return frame;
	}
}
