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
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;

public class TelaCadastrarCliente {

	private JFrame frmCadastroCliente;
	private JTextField txtTelefone;
	private JTextField txtNome;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCliente window = new TelaCadastrarCliente();
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroCliente = new JFrame();
		frmCadastroCliente.setTitle("Cadastro de Cliente");
		frmCadastroCliente.setBounds(100, 100, 450, 300);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroCliente.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 436, 263);
		frmCadastroCliente.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProduto = new JLabel("Cadastro de Cliente");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroProduto.setBounds(20, 21, 139, 34);
		panel.add(lblCadastroProduto);

		JLabel lblNome = new JLabel("Digite o nome completo:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(20, 83, 162, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(192, 77, 211, 23);
		panel.add(txtNome);
		
		JLabel lblTelefone = new JLabel("Digite o telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefone.setBounds(20, 124, 128, 14);
		panel.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(192, 121, 211, 23);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
	
		JLabel lblEndereco = new JLabel("Digite o endereço");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereco.setBounds(20, 164, 139, 14);
		panel.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(192, 158, 211, 23);
		panel.add(txtEndereco);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idCliente = 0; //Integer.parseInt(txtIdCliente.getText());
				String nome = txtNome.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText();
				Cliente c = new Cliente(idCliente, nome, telefone,endereco);
				ClienteDAO cd = new ClienteDAO();
				cd.create(c, frmCadastroCliente);
				frmCadastroCliente.dispose();
			}
		});
		btnCadastrar.setBounds(28, 209, 89, 23);
		panel.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(314, 209, 89, 23);
		panel.add(btnVoltar);
		

	}

	public JFrame frmCadastroCliente() {
		return frmCadastroCliente;
	}

}
