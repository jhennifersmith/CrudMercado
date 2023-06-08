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
import javax.swing.JTextField;

import dao.FuncionarioDAO;
import dominio.Funcionario;

public class TelaCadastrarFuncionario {

	private JFrame frmCadastroFuncionario;
	private JTextField txtNome;
	private JTextField txtSalario;
	private JTextField txtComissao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarFuncionario window = new TelaCadastrarFuncionario();
					window.frmCadastroFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroFuncionario = new JFrame();
		frmCadastroFuncionario.setTitle("Cadastro de Funcionario");
		frmCadastroFuncionario.setBounds(100, 100, 450, 300);
		frmCadastroFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroFuncionario.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 436, 263);
		frmCadastroFuncionario.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProduto = new JLabel("Cadastro de Funcionario");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroProduto.setBounds(20, 24, 162, 34);
		panel.add(lblCadastroProduto);

		JLabel lblNome = new JLabel("Digite o nome completo:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(20, 83, 162, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(192, 77, 211, 23);
		panel.add(txtNome);
		
		JLabel lblSalario = new JLabel("Digite o salário:");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalario.setBounds(20, 127, 128, 14);
		panel.add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setBounds(192, 121, 211, 23);
		panel.add(txtSalario);
		txtSalario.setColumns(10);
	
		JLabel lblComissao = new JLabel("Digite a comissao:");
		lblComissao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComissao.setBounds(20, 164, 139, 14);
		panel.add(lblComissao);

		txtComissao = new JTextField();
		txtComissao.setColumns(10);
		txtComissao.setBounds(192, 158, 211, 23);
		panel.add(txtComissao);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idFuncionario = 0; //Integer.parseInt(txtIdFuncionario.getText());
				String nome = txtNome.getText();
				Float salario = Float.parseFloat(txtSalario.getText());
				Float comissao = Float.parseFloat(txtComissao.getText());
				Funcionario f = new Funcionario(idFuncionario, nome, salario, comissao);
				FuncionarioDAO fd = new FuncionarioDAO();
				fd.create(f, frmCadastroFuncionario);
				frmCadastroFuncionario.dispose();
			}
		});
		btnCadastrar.setBounds(28, 209, 89, 23);
		panel.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(314, 209, 89, 23);
		panel.add(btnVoltar);
		

	}

	public JFrame frmCadastroFuncionario() {
		return frmCadastroFuncionario;
	}


}
