package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import dao.LoginDAO;
import dominio.Login;

public class TelaConsultaLogin {

	private JFrame frmConsultaLogin;
	private JTextField txtDesc;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaLogin window = new TelaConsultaLogin();
					window.frmConsultaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaLogin() {
		initialize();
	}

	private void atualizaBusca() {
		LoginDAO ld = new LoginDAO();
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setNumRows(0);
		for(Login l: ld.ConsultarPorDescricao(txtDesc.getText())) {
			modelo.addRow(new Object[] {
					l.getId(),
					l.getUsername(),
					l.getSenha(),
			});
		}
	}

	/**
	 * Initialize the contents of thefrmConsultaLogin.
	 */
	private void initialize() {
		frmConsultaLogin = new JFrame();
		frmConsultaLogin.setTitle("Ações em Login");
		frmConsultaLogin.getContentPane().setBackground(new Color(128, 128, 255));
		frmConsultaLogin.setBackground(new Color(128, 128, 255));
		frmConsultaLogin.setBounds(100, 100, 463, 354);
		frmConsultaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 10, 434, 65);
		frmConsultaLogin.getContentPane().add(panel);
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
		frmConsultaLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 414, 163);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Id Login", "Username"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.setAutoCreateRowSorter(true);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =  (int) table.getValueAt(table.getSelectedRow(),0);
				LoginDAO ld = new LoginDAO();
				ld.excluir(id);
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
				String username = (String)table.getValueAt(table.getSelectedRow(), 1);
				
				TelaAlterarLogin tac = new TelaAlterarLogin();
				tac.setTxtIdLogin(Integer.toString(id));
				tac.setTxtUsername(username);
				
				tac.getFrmTelaAlterar().setVisible(true);
				
			}
		});
		btnAlterar.setBounds(236, 183, 89, 23);
		panel_1.add(btnAlterar);
	}

	public JFrame getFrmConsultaLogin() {
		return frmConsultaLogin;
	}
}

