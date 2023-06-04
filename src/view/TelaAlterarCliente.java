package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ClienteDAO;
import dominio.Cliente;
import java.awt.Color;
import java.awt.Font;

public class TelaAlterarCliente {

	private JFrame frmTelaAlterar;
	private JTextField txtIdCliente;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;

	public JTextField getTxtIdCliente() {
		return txtIdCliente;
	}

	public void setTxtIdCliente(String txtIdCliente) {
		this.txtIdCliente.setText(txtIdCliente);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(String txtNome) {
		this.txtNome.setText(txtNome);
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(String txtTelefone) {
		this.txtTelefone.setText(txtTelefone);
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(String txtEndereco) {
		this.txtEndereco.setText(txtEndereco);
	}
	
	public JFrame getFrmTelaAlterar() {
		return frmTelaAlterar;
	}	

	public void setFrmTelaAlterar(JFrame frmTelaAlterar) {
		this.frmTelaAlterar = frmTelaAlterar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarCliente window = new TelaAlterarCliente();
					window.frmTelaAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAlterar = new JFrame();
		frmTelaAlterar.setTitle("Alterar Cliente");
		frmTelaAlterar.setBounds(100, 100, 450, 299);
		frmTelaAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaAlterar.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 436, 262);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Identificador:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(20, 53, 77, 14);
		panel.add(lblId);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereco.setBounds(22, 168, 77, 14);
		panel.add(lblEndereco);

		JLabel lblNome = new JLabel("Nome completo: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(22, 91, 104, 14);
		panel.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefone.setBounds(22, 130, 77, 14);
		panel.add(lblTelefone);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(155, 50, 249, 23);
		panel.add(txtIdCliente);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(155, 88, 249, 23);
		panel.add(txtNome);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(155, 127, 249, 23);
		panel.add(txtTelefone);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(155, 167, 249, 23);
		panel.add(txtEndereco);

		JButton btnAlteraCliente = new JButton("Alterar");
		btnAlteraCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlteraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIdCliente.getText());
				String nome = txtNome.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText();
				Cliente c = new Cliente(id, nome, telefone, endereco);
				c.setIdCliente(id);
				ClienteDAO cd = new ClienteDAO();
				cd.Alterar(c);
				frmTelaAlterar.dispose();
			}
		});
		btnAlteraCliente.setBounds(300, 227, 104, 23);
		panel.add(btnAlteraCliente);
		
		JLabel lblAlteraoDeCliente = new JLabel("Alteração de Cliente");
		lblAlteraoDeCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlteraoDeCliente.setBounds(10, 10, 139, 34);
		panel.add(lblAlteraoDeCliente);
		
	}
	
}
