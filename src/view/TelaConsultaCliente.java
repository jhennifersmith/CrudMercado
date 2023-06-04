package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dominio.Cliente;
import java.awt.Color;
import java.awt.Font;

public class TelaConsultaCliente {

	private JFrame frmConsultaCliente;
	private JTextField txtDesc;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCliente window = new TelaConsultaCliente();
					window.frmConsultaCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaCliente() {
		initialize();
	}

	private void atualizaBusca() {
		ClienteDAO cd = new ClienteDAO();
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setNumRows(0);
		for(Cliente c: cd.ConsultarPorDescricao(txtDesc.getText())) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getTelefone(),
					c.getEndereco()
			});
		}
	}

	/**
	 * Initialize the contents of thefrmConsultaCliente.
	 */
	private void initialize() {
		frmConsultaCliente = new JFrame();
		frmConsultaCliente.setTitle("Ações em Cliente");
		frmConsultaCliente.getContentPane().setBackground(new Color(128, 128, 255));
		frmConsultaCliente.setBackground(new Color(128, 128, 255));
		frmConsultaCliente.setBounds(100, 100, 463, 354);
		frmConsultaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 10, 434, 65);
		frmConsultaCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDesc = new JLabel("Informe o nome:");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesc.setBounds(10, 10, 200, 14);
		panel.add(lblDesc);
		
		
		JButton btnBuscaPorDescricao = new JButton("Filtrar");
		btnBuscaPorDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscaPorDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();				
			}
		});
		btnBuscaPorDescricao.setBounds(335, 37, 89, 23);
		panel.add(btnBuscaPorDescricao);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(10, 34, 292, 26);
		panel.add(txtDesc);
		txtDesc.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(10, 90, 434, 217);
		frmConsultaCliente.getContentPane().add(panel_1);
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
				"Id Cliente", "Nome", "Telefone", "Endereco"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.setAutoCreateRowSorter(true);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =  (int) table.getValueAt(table.getSelectedRow(), 3);
				ClienteDAO pd = new ClienteDAO();
				pd.excluir(id);
				atualizaBusca();
			}
		});
		btnExcluir.setBounds(335, 183, 89, 23);
		panel_1.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (Integer)table.getValueAt(table.getSelectedRow(), 0);
				String nome = (String)table.getValueAt(table.getSelectedRow(), 1);
				String telefone = (String)table.getValueAt(table.getSelectedRow(), 2);
				String endereco = (String)table.getValueAt(table.getSelectedRow(), 3);
				
				TelaAlterarCliente tac = new TelaAlterarCliente();
				tac.setTxtIdCliente(Integer.toString(id));
				tac.setTxtNome(nome);
				tac.setTxtTelefone(telefone);
				tac.setTxtEndereco(endereco);
				
				tac.getFrmTelaAlterar().setVisible(true);
				
			}
		});
		btnAlterar.setBounds(236, 183, 89, 23);
		panel_1.add(btnAlterar);
	}

	public JFrame getFrmConsultaCliente() {
		return frmConsultaCliente;
	}
}

